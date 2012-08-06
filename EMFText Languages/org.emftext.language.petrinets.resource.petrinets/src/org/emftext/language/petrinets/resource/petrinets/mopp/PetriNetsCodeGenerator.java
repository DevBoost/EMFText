/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.language.petrinets.resource.petrinets.mopp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.emftext.language.petrinets.BooleanExpression;
import org.emftext.language.petrinets.BooleanLiteral;
import org.emftext.language.petrinets.Call;
import org.emftext.language.petrinets.Cast;
import org.emftext.language.petrinets.Component;
import org.emftext.language.petrinets.ConstructorCall;
import org.emftext.language.petrinets.ConsumingArc;
import org.emftext.language.petrinets.DoubleLiteral;
import org.emftext.language.petrinets.EClassLiteral;
import org.emftext.language.petrinets.Expression;
import org.emftext.language.petrinets.FloatLiteral;
import org.emftext.language.petrinets.Function;
import org.emftext.language.petrinets.FunctionCall;
import org.emftext.language.petrinets.InitialisedVariable;
import org.emftext.language.petrinets.IntegerLiteral;
import org.emftext.language.petrinets.LongLiteral;
import org.emftext.language.petrinets.MemberCallExpression;
import org.emftext.language.petrinets.NestedExpression;
import org.emftext.language.petrinets.PList;
import org.emftext.language.petrinets.PetriNet;
import org.emftext.language.petrinets.Place;
import org.emftext.language.petrinets.ProducingArc;
import org.emftext.language.petrinets.Setting;
import org.emftext.language.petrinets.Statement;
import org.emftext.language.petrinets.StringLiteral;
import org.emftext.language.petrinets.Transition;
import org.emftext.language.petrinets.TypedElement;
import org.emftext.language.petrinets.UnaryMinus;
import org.emftext.language.petrinets.VariableCall;
import org.emftext.language.petrinets.resource.petrinets.PetrinetsEProblemType;
import org.emftext.language.petrinets.resource.petrinets.analysis.FunctionCallAnalysisHelper;

public class PetriNetsCodeGenerator {

	private JavaStringBuffer stringBuffer;

	private String contextVariableName;

	private int counter = 0;

	private Map<String, GenClass> genClassMap = new HashMap<String, GenClass>();

	private PetrinetsResource resource;

	private String generateContextVariableName() {
		counter++;
		return "__temp_" + counter;
	}

	public void generateJavaCode(PetrinetsResource resource) {
		this.resource = resource;
		IFile file = WorkspaceSynchronizer.getFile(resource);

		stringBuffer = new JavaStringBuffer();
		if (resource.getContents().isEmpty())
			return;
		if (resource.getContents().get(0) instanceof PetriNet) {
			PetriNet pn = (PetriNet) resource.getContents().get(0);
			if (pn.isAbstrct())
				return;
			// EcoreUtil.resolveAll(pn.eResource().getResourceSet());
			initialiseGenClassMap(pn);
			generateCode(pn);

			try {

				String name = toFirstUpper(trimQuotes(pn.getName()));
				name = name + "SemanticsEvaluation.java";
				IPath currentDir = file.getProject().getLocation()
						.append(IPath.SEPARATOR + "src-gen" + IPath.SEPARATOR);
				// IPath currentDir = file.getLocation().removeLastSegments(1)
				// .append("" + IPath.SEPARATOR);

				EList<String> pkg = pn.getPkg();
				for (String p : pkg) {
					currentDir = currentDir.append(p + IPath.SEPARATOR);
					File folder = currentDir.toFile();
					if (!folder.exists()) {
						folder.mkdir();
					}
				}
				File f = currentDir.append(name).toFile();

				if (f.exists()) {
					f.delete();
				}
				f.createNewFile();
				FileOutputStream fout = new FileOutputStream(f);
				Writer out = new OutputStreamWriter(fout);
				try {
					out.write(stringBuffer.toString());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						out.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

		}

	}

	private void initialiseGenClassMap(PetriNet pn) {
		EList<GenModel> genModels = pn.getGenModels();
		for (GenModel genModel : genModels) {
			TreeIterator<EObject> eAllContents = genModel.eAllContents();
			while (eAllContents.hasNext()) {
				EObject eObject = (EObject) eAllContents.next();
				if (eObject instanceof GenClass) {
					GenClass gc = (GenClass) eObject;
					EClass ecoreClass = gc.getEcoreClass();
					this.genClassMap.put(ecoreClass.getName(), gc);
				}

			}
		}

	}

	private String trimQuotes(String name) {

		return name;
	}

	private void generateCode(PetriNet pn) {
		String name = toFirstUpper(trimQuotes(pn.getName()));
		List<Component> components = new LinkedList<Component>();
		components.addAll(pn.getComponents());
		EList<PetriNet> importedPNs = pn.getImports();
		for (PetriNet petriNet : importedPNs) {
			components.addAll(petriNet.getComponents());
		}
		String packageName = pn.getPkg().get(0);
		if (!pn.getPkg().isEmpty()) {
			for (String p : pn.getPkg().subList(1, pn.getPkg().size())) {
				packageName += "." + p;
			}
			stringBuffer.append("package " + packageName);
			stringBuffer.append(";");
		}
		stringBuffer.newline();
		stringBuffer
				.appendLine("import org.eclipse.emf.common.util.TreeIterator;");
		stringBuffer.appendLine("import org.eclipse.emf.ecore.*;");
		stringBuffer.appendLine("import java.util.*;");

		List<GenModel> imports = new LinkedList<GenModel>();
		imports.addAll(pn.getGenModels());
		for (PetriNet petriNet : importedPNs) {
			imports.addAll(petriNet.getGenModels());
		}
		for (GenModel i : imports) {
			EList<GenPackage> genPackages = i.getGenModel().getGenPackages();
			for (GenPackage genPackage : genPackages) {
				String interfacePackageName = genPackage
						.getInterfacePackageName();
				if (!interfacePackageName.equals(packageName)) {
					stringBuffer.appendLine("import " + interfacePackageName
							+ ".*;");
				}
			}
		}
		stringBuffer.newline();
		stringBuffer.appendLine("public class " + name
				+ "SemanticsEvaluation {");

		stringBuffer.newline();

		stringBuffer.appendLine("public interface ILogger {");
		stringBuffer.appendLine("public void log(String log);");
		stringBuffer.appendLine("}");
		stringBuffer.newline();

		stringBuffer.appendLine("private ILogger logger = null;");
		stringBuffer.newline();

		stringBuffer.appendLine("public void setLogger(ILogger l) {");
		stringBuffer.appendLine("logger = l;");
		stringBuffer.appendLine("}");
		stringBuffer.newline();

		stringBuffer.appendLine("public void log(String logMsg) {");
		stringBuffer.appendLine("if (logger != null)");
		stringBuffer.appendLine("logger.log(logMsg);");
		stringBuffer.appendLine("}");

		stringBuffer.newline();
		generateRemoveTransationCodeAccessorCode();

		for (Component component : components) {
			if (component instanceof Place)
				generateCode((Place) component);
		}

		stringBuffer.newline();
		stringBuffer
				.appendLine("List<PendingChange> pendingChanges = new LinkedList<PendingChange>();");
		stringBuffer.newline();
		stringBuffer.appendLine("private class PendingChange {");

		stringBuffer.appendLine("private String transitionName;");
		stringBuffer.appendLine("private List<Object> arguments;");
		stringBuffer
				.appendLine("public PendingChange(String transitionName, List<Object> arguments) {");

		stringBuffer.appendLine("this.transitionName = transitionName;");
		stringBuffer.appendLine("this.arguments = arguments;");

		stringBuffer.appendLine("}");

		stringBuffer.appendLine("}");

		stringBuffer.newline();
		stringBuffer
				.appendLine("private void addPendingChange(String transitionName, List<Object> arguments) {");

		stringBuffer
				.appendLine("this.pendingChanges.add(new PendingChange(transitionName, arguments));");

		stringBuffer.appendLine("}");

		generateAutoinitCode(pn);

		stringBuffer.appendLine("public void evaluateSemantics() {");

		stringBuffer.appendLine("while(this.pendingChanges.size() > 0) {");

		stringBuffer.appendLine("PendingChange pc = pendingChanges.remove(0);");
		for (Component component : components) {
			if (component instanceof Transition) {
				Transition t = (Transition) component;
				stringBuffer.appendLine("if (pc.transitionName.equals(\""
						+ t.getName() + "\") ) {");

				stringBuffer.appendLine("transition_" + t.getName()
						+ "_doFire(");
				EList<ConsumingArc> incoming = t.getIncoming();
				for (ConsumingArc consumingArc : incoming) {
					int index = incoming.indexOf(consumingArc);
					stringBuffer.append("(" + printType(consumingArc.getIn())
							+ ") pc.arguments.get(" + index + ")");
					if (index < incoming.size() - 1) {
						stringBuffer.append(", ");
					}
				}
				stringBuffer.append(");");

				stringBuffer.appendLine("}");

				stringBuffer.newline();

			}
		}

		stringBuffer.appendLine("}");

		stringBuffer.appendLine("}");

		for (Component component : components) {
			if (component instanceof Transition) {
				Transition t = (Transition) component;
				generateCode(t);
			}
		}

		stringBuffer.newline();

		stringBuffer.appendLine("}");
	}

	private void generateAutoinitCode(PetriNet pn) {
		stringBuffer.newline();
		stringBuffer.appendLine("public void intialisePlaces(EObject model) {");
		stringBuffer.appendLine("relayObject(model);");
		stringBuffer
				.appendLine("TreeIterator<EObject> eAllContents = model.eAllContents();");
		stringBuffer.appendLine("while (eAllContents.hasNext()) {");
		stringBuffer
				.appendLine("EObject eObject = (EObject) eAllContents.next();");
		stringBuffer.appendLine("relayObject(eObject);");
		stringBuffer.appendLine("}");

		stringBuffer.appendLine("}");

		stringBuffer.appendLine("private void relayObject(EObject eObject) {");
		EList<Component> components = pn.getComponents();
		for (Component component : components) {
			if (component instanceof Place && ((Place) component).isAutoinit()) {
				Place p = (Place) component;
				stringBuffer.appendLine("if (eObject instanceof "
						+ printType(p) + ") {");
				stringBuffer.appendLine("add_to_place_"
						+ trimQuotes(p.getName()) + "((" + printType(p)
						+ ") eObject);");
				stringBuffer.appendLine("}");
			}
		}
		stringBuffer.appendLine("}");

		stringBuffer.newline();
	}

	private void generateRemoveTransationCodeAccessorCode() {
		stringBuffer
				.appendLine("public class RemovalException extends Exception {");
		stringBuffer
				.appendLine("private static final long serialVersionUID = -8317569526723196361L;");
		stringBuffer.appendLine("}");
		stringBuffer.newline();
		stringBuffer.appendLine("public void revertRemovalTransactions() {");

		stringBuffer
				.appendLine("for(RemovalTransaction<?> e : removalTransactions) {");

		stringBuffer.appendLine("e.revert();");

		stringBuffer.appendLine("}");

		stringBuffer.appendLine("}");
		stringBuffer.newline();
		stringBuffer.appendLine("private class RemovalTransaction<T> {");

		stringBuffer.appendLine("private List<T> list;");
		stringBuffer.appendLine("private T element;");
		stringBuffer.appendLine("public RemovalTransaction(List<T> l, T e) {");

		stringBuffer.appendLine("list = l;");
		stringBuffer.appendLine("element = e;");

		stringBuffer.appendLine("}");
		stringBuffer.newline();
		stringBuffer.appendLine("public void revert() {");

		stringBuffer.appendLine("list.add(element);");

		stringBuffer.appendLine("}");

		stringBuffer.appendLine("}");
		stringBuffer.newline();

		stringBuffer
				.appendLine("private List<RemovalTransaction<?>> removalTransactions;");
		stringBuffer.newline();

		stringBuffer.appendLine("private void startTransaction() {");

		stringBuffer.appendLine("assert(removalTransactions.isEmpty());");
		stringBuffer
				.appendLine("removalTransactions = new LinkedList<RemovalTransaction<?>>();");

		stringBuffer.appendLine("}");

	}

	private String toFirstUpper(String s) {
		return s.substring(0, 1).toUpperCase() + s.substring(1);
	}

	private void generateCode(Place p) {
		stringBuffer.appendLine("private List<" + printType(p) + "> "
				+ "_place_" + trimQuotes(p.getName()) + " = new ArrayList<"
				+ printType(p) + ">();");
		stringBuffer.newline();
		stringBuffer.appendLine("public void add_to_place_"
				+ trimQuotes(p.getName()) + "(" + printType(p) + " object) {");
		stringBuffer.appendLine("if (_place_" + trimQuotes(p.getName())
				+ ".contains(object)) return;");

		EList<ConsumingArc> outgoing = p.getOutgoing();
		for (ConsumingArc consumingArc : outgoing) {
			stringBuffer.appendLine("{");

			Transition involvedTransition = consumingArc.getOut();
			EList<ConsumingArc> incoming = involvedTransition.getIncoming();
			int counter = 0;
			for (ConsumingArc transitionArc : incoming) {
				counter++;
				Place in = transitionArc.getIn();
				if (!transitionArc.equals(consumingArc)) {
					stringBuffer.appendLine("for(" + printType(in) + " "
							+ "argument_" + counter + " : _place_"
							+ trimQuotes(in.getName()) + ") {");

				}
			}
			;
			stringBuffer
					.appendLine("List<Object> args = new ArrayList<Object>();");
			counter = 0;
			for (ConsumingArc transitionArc : incoming) {
				counter++;
				if (!transitionArc.equals(consumingArc)) {
					stringBuffer.appendLine("args.add(argument_" + counter
							+ ");");
				} else {
					stringBuffer.appendLine("args.add(object);");
				}
			}
			;
			stringBuffer.appendLine("addPendingChange(\""
					+ involvedTransition.getName() + "\", args);");
			for (ConsumingArc transitionArc : incoming) {
				if (!transitionArc.equals(consumingArc)) {

					stringBuffer.append("}");
				}
			}

			stringBuffer.appendLine("}");
		}

		stringBuffer.appendLine("_place_" + trimQuotes(p.getName())
				+ ".add(object);");

		stringBuffer.appendLine("log(\"addding \"+ object +\" to place: "
				+ p.getName() + "\");");

		stringBuffer.appendLine("}");

		stringBuffer.newline();

		stringBuffer.appendLine("private void remove_from_place_"
				+ trimQuotes(p.getName()) + "(" + printType(p)
				+ " object) throws RemovalException{");

		stringBuffer
				.appendLine("removalTransactions.add(new RemovalTransaction<"
						+ printType(p) + ">(" + "_place_"
						+ trimQuotes(p.getName()) + ", object));");
		stringBuffer.appendLine("_place_" + trimQuotes(p.getName())
				+ ".remove(object);");

		stringBuffer.appendLine("}");

	}

	private void generateCode(Transition t) {

		EList<ConsumingArc> incomingArcs = t.getIncoming();

		stringBuffer.newline();

		stringBuffer.appendLine("private boolean transition_"
				+ trimQuotes(t.getName()) + "_doFire(");

		for (ConsumingArc arc : incomingArcs) {
			Place in = arc.getIn();

			stringBuffer.append(printType(in) + " "
					+ arc.getFreeVariable().getName());
			if (incomingArcs.indexOf(arc) < incomingArcs.size() - 1) {
				stringBuffer.append(", ");
			}
		}
		stringBuffer.append(") {");
		stringBuffer.newline();

		stringBuffer.appendLine("// evaluate guard expression");
		stringBuffer.appendLine("boolean guardSatisfied = false;");
		String guardEvaluationResult = null;
		if (t.getGuard() != null) {
			generateCode(t.getGuard());
			guardEvaluationResult = this.contextVariableName;
		} else {
			guardEvaluationResult = "true";
		}
		stringBuffer.appendLine("guardSatisfied = " + guardEvaluationResult
				+ ";");
		stringBuffer.appendLine("if (guardSatisfied) {");

		stringBuffer.appendLine("startTransaction();");
		stringBuffer.appendLine("try {");

		for (ConsumingArc arc : incomingArcs) {
			Place in = arc.getIn();

			stringBuffer.appendLine("remove_from_place_"
					+ trimQuotes(in.getName()) + "("
					+ arc.getFreeVariable().getName() + ");");
		}

		stringBuffer
				.appendLine("} catch(RemovalException __removalException) {");

		stringBuffer.appendLine("revertRemovalTransactions();");
		stringBuffer.appendLine("return false;");

		stringBuffer.appendLine("}");
		stringBuffer.appendLine("removalTransactions.clear();");

		stringBuffer.appendLine("}");
		stringBuffer.appendLine("else return false;");

		EList<Statement> statements = t.getStatements();
		for (Statement statement : statements) {
			generateCode(statement);
		}

		stringBuffer.appendLine("log(\"firing transition " + t.getName()
				+ "\");");

		stringBuffer.appendLine("// init out places");
		for (ProducingArc arc : t.getOutgoing()) {
			Place out = arc.getOut();
			String outvar =  arc.getOutput().getName();

			stringBuffer.appendLine("// evaluate settings for " + outvar);
			EList<Setting> settings = arc.getSettings();
			for (Setting setting : settings) {
				generateCode(arc.getOutput().getName(), setting);
			}

			stringBuffer.appendLine("// add " + outvar + " to place "
					+ out.getName());
			stringBuffer.appendLine("add_to_place_" + trimQuotes(out.getName())
					+ "(" + outvar + ");");
		}

		stringBuffer.appendLine("return true;");

		stringBuffer.appendLine("}");

	}

	private void generateCode(String contextVar, Setting setting) {
		EStructuralFeature feature = setting.getFeature();
		if (feature.eContainer() == null && contextVar == feature.getName()) {
			stringBuffer.appendLine(contextVar + " = "
					+ setting.getValue().getName() + ";");
		}
		if (feature.isMany()) {
			stringBuffer.appendLine(contextVar + ".get"
					+ toFirstUpper(feature.getName()) + "().add("
					+ setting.getValue().getName() + ");");

		} else {
			stringBuffer.appendLine(contextVar + ".set"
					+ toFirstUpper(feature.getName()) + "("
					+ setting.getValue().getName() + ");");
		}

	}

	private String printCreation(EClassifier type, ConstructorCall cc) {
		if (type.getDefaultValue() != null) {
			return type.getDefaultValue().toString();
		} else {
			GenClass genClass = findGenClass(type);
			if (genClass.isAbstract()) {
				resource.addError("'" + genClass.getName()
						+ "' is abstract and can not be instantiated",
						PetrinetsEProblemType.ANALYSIS_PROBLEM, cc);

			}
			GenPackage genPackage = genClass.getGenPackage();
			return genPackage.getQualifiedFactoryInterfaceName()
					+ ".eINSTANCE.create" + genClass.getName() + "();";

		}

	}

	private GenClass findGenClass(EClassifier type) {
		return genClassMap.get(type.getName());
	}

	private String printType(TypedElement element) {
		if (element.getType() == null) {
			EClassifier type = null;
			if (element instanceof TypedElement) {
				type = FunctionCallAnalysisHelper.getInstance().getType(
						(TypedElement) element);
			}
			if (element instanceof InitialisedVariable) {
				Expression initialisation = ((InitialisedVariable) element)
						.getInitialisation();
				type = FunctionCallAnalysisHelper.getInstance().getType(
						initialisation);
				((InitialisedVariable) element).setType(type);
			}
			if (type == null) {
				resource.addError("Type was not resolved",
						PetrinetsEProblemType.BUILDER_ERROR, element);
				return "UnresolvedType";
			}

		}
		EClassifier type = element.getType();
		if (type instanceof PList) {
			PList list = (PList) type;
			return "List<" + printType(list) + ">";
		}
		if (type.getInstanceClassName() != null) {
			return mapPrimitiveTypes(type.getInstanceClassName());
		}
		return mapPrimitiveTypes(type.getName());
	}

	private String mapPrimitiveTypes(String instanceClassName) {
		if (instanceClassName.equals("int"))
			return "Integer";
		if (instanceClassName.equals("bool"))
			return "Boolean";
		if (instanceClassName.equals("double"))
			return "Double";
		if (instanceClassName.equals("float"))
			return "Float";
		if (instanceClassName.equals("long"))
			return "Long";
		return instanceClassName;

	}

	private void generateCode(EObject o) {
		if (o == null)
			return;
		else if (o instanceof InitialisedVariable)
			generateCode((InitialisedVariable) o);
		else if (o instanceof UnaryMinus)
			generateCode((UnaryMinus) o);
		else if (o instanceof MemberCallExpression)
			generateCode((MemberCallExpression) o);
		else if (o instanceof VariableCall)
			generateCode((VariableCall) o);
		else if (o instanceof ConstructorCall)
			generateCode((ConstructorCall) o);
		else if (o instanceof StringLiteral)
			generateCode((StringLiteral) o);
		else if (o instanceof IntegerLiteral)
			generateCode((IntegerLiteral) o);
		else if (o instanceof DoubleLiteral)
			generateCode((DoubleLiteral) o);
		else if (o instanceof LongLiteral)
			generateCode((LongLiteral) o);
		else if (o instanceof FloatLiteral)
			generateCode((FloatLiteral) o);
		else if (o instanceof BooleanLiteral)
			generateCode((BooleanLiteral) o);
		else if (o instanceof LongLiteral)
			generateCode((LongLiteral) o);
		else if (o instanceof EClassLiteral)
			generateCode((EClassLiteral) o);
		else if (o instanceof Cast)
			generateCode((Cast) o);
		else if (o instanceof BooleanExpression)
			generateCode((BooleanExpression) o);
		else if (o instanceof NestedExpression)
			generateCode((NestedExpression) o);
		else
			throw new RuntimeException("No codegeneration routine found for "
					+ o);
	}

	private void generateCode(VariableCall vc) {
		String contextVar = generateContextVariableName();
		stringBuffer.appendLine(printType(vc) + " " + contextVar + " = ");
		stringBuffer.append(vc.getVariable().getName() + ";");
		stringBuffer.newline();
		this.contextVariableName = contextVar;

		// if (vc.getNextExpression() != null)
		// generateCode(vc.getNextExpression());
	}

	private void generateCode(ConstructorCall cc) {
		String contextVar = generateContextVariableName();
		stringBuffer.appendLine(printType(cc) + " " + contextVar + " = ");
		stringBuffer.append(printCreation(cc.getType(), cc));
		EList<Setting> settings = cc.getSettings();
		for (Setting setting : settings) {
			generateCode(contextVar, setting);
		}
		stringBuffer.newline();
		this.contextVariableName = contextVar;

		// if (cc.getNextExpression() != null)
		// generateCode(cc.getNextExpression());
	}

	private void generateCode(MemberCallExpression mce) {
		Expression target = mce.getTarget();
		generateCode(target);
		String prevContextVarName = this.contextVariableName;
		for (Call c : mce.getCalls()) {
			generateCode((FunctionCall) c, prevContextVarName);
			prevContextVarName = this.contextVariableName;
		}
	}

	private void generateCode(FunctionCall fc, String prevContextVarName) {
		Function function = fc.getFunction();
		stringBuffer.appendLine("// ." + function.getName() + "()");
		EList<Expression> parameters = fc.getParameters();
		Map<Expression, String> argumentVars = new HashMap<Expression, String>();
		for (Expression expression : parameters) {
			generateCode(expression);
			argumentVars.put(expression, this.contextVariableName);
		}
		String contextVar = null;
		String returnType = printType(fc);
		if (returnType != null && !"PVoid".equals(returnType)
				&& !"".equals(returnType)) {
			contextVar = generateContextVariableName();
			stringBuffer.appendLine(returnType + " " + contextVar + " = ");
		} else {
			stringBuffer.appendLine("");
		}
		// library function
		if (function.isLibrary()) {
			PetriNet net = (PetriNet) function.eResource().getContents().get(0);
			EList<String> pkgs = net.getPkg();
			String libraryName = "";
			for (String pkg : pkgs) {
				libraryName = libraryName + pkg + ".";
			}
			libraryName = libraryName + toFirstUpper(trimQuotes(net.getName()));
			libraryName = libraryName + "SemanticsLibrary";

			stringBuffer.appendLine(libraryName + "." + function.getName()
					+ "(");
		}
		if (prevContextVarName != null) {
			stringBuffer.append(prevContextVarName);
		}
		// api function
		if (!function.isLibrary()) {
			stringBuffer.append("." + function.getName() + "(");
		} else {
			if (parameters.size() > 0)
				stringBuffer.append(", ");
		}
		int i = 0;
		for (Expression expression : parameters) {
			i++;
			if (i == parameters.size()) {
				stringBuffer.append(argumentVars.get(expression));
			} else {
				stringBuffer.append(argumentVars.get(expression) + ", ");
			}
		}
		stringBuffer.append(");");
		this.contextVariableName = contextVar;
		// if (fc.getNextExpression() != null)
		// generateCode(fc.getNextExpression());
	}

	private void generateCode(InitialisedVariable v) {
		stringBuffer.newline();
		stringBuffer.appendLine("// " + v.getName() + " initialization ");
		Expression expression = v.getInitialisation();
		generateCode(expression);
		String contextVariableName = this.contextVariableName;
		stringBuffer.appendLine(printType(v) + " " + v.getName() + " = "
				+ contextVariableName + ";");
	}

	private void generateCode(StringLiteral sl) {
		this.contextVariableName = generateContextVariableName();
		stringBuffer.appendLine("String " + this.contextVariableName + " = "
				+ "\"" + sl.getValue() + "\";");
	}

	private void generateCode(IntegerLiteral il) {
		this.contextVariableName = generateContextVariableName();
		stringBuffer.appendLine("int " + this.contextVariableName + " = "
				+ il.getValue() + ";");

	}

	private void generateCode(LongLiteral ll) {
		this.contextVariableName = generateContextVariableName();
		stringBuffer.appendLine("long " + this.contextVariableName + " = "
				+ ll.getValue() + ";");

	}

	private void generateCode(EClassLiteral ecl) {
		this.contextVariableName = generateContextVariableName();
		stringBuffer.appendLine("Class<" + ecl.getClazz().getName() + "> "
				+ this.contextVariableName + " = " + ecl.getClazz().getName()
				+ ".class;");

	}

	private void generateCode(DoubleLiteral dl) {
		this.contextVariableName = generateContextVariableName();
		stringBuffer.appendLine("double " + this.contextVariableName + " = "
				+ dl.getValue() + ";");

	}

	private void generateCode(FloatLiteral fl) {
		this.contextVariableName = generateContextVariableName();
		stringBuffer.appendLine("float " + this.contextVariableName + " = "
				+ fl.getValue() + "f;");

	}

	private void generateCode(BooleanLiteral bl) {
		this.contextVariableName = generateContextVariableName();
		stringBuffer.appendLine("boolean " + this.contextVariableName + " = "
				+ bl.isValue() + ";");

	}

	private void generateCode(Cast cast) {
		String castVariable = generateContextVariableName();
		generateCode(cast.getExpression());
		String expressionVariable = this.contextVariableName;
		stringBuffer.appendLine(printType(cast) + " " + castVariable + " = "
				+ "(" + printType(cast) + ")" + expressionVariable + ";");
		this.contextVariableName = castVariable;
	}

	private void generateCode(NestedExpression ne) {
		String nv = generateContextVariableName();
		generateCode(ne.getExpression());
		String expressionVariable = this.contextVariableName;
		stringBuffer.appendLine(printType(ne) + " " + nv + " = "
				+ expressionVariable + ";");
		this.contextVariableName = nv;
	}

	private void generateCode(UnaryMinus um) {
		if (um.isMinus()) {
			String uv = generateContextVariableName();
			generateCode(um.getExpression());
			String expressionVariable = this.contextVariableName;
			stringBuffer.appendLine(printType(um) + " " + uv + " = - "
					+ expressionVariable + ";");
			this.contextVariableName = uv;
		} else {
			generateCode(um.getExpression());
		}
	}

	private void generateCode(BooleanExpression be) {
		String booleanExpressionResult = generateContextVariableName();
		generateCode(be.getLeft());
		String leftResult = this.contextVariableName;
		if (be.getOperator().equals("&&")) {
			stringBuffer.appendLine("boolean " + booleanExpressionResult
					+ " = " + leftResult + ";");
			stringBuffer.appendLine("if (" + booleanExpressionResult + ") {");

			generateCode(be.getRight());
			String rightResult = this.contextVariableName;
			stringBuffer.appendLine(booleanExpressionResult + " = "
					+ rightResult + ";");

			stringBuffer.appendLine("}");
		} else // || operator
		{
			stringBuffer.appendLine("boolean " + booleanExpressionResult
					+ " = " + leftResult + ";");
			stringBuffer.appendLine("if (!" + booleanExpressionResult + ") {");

			generateCode(be.getRight());
			String rightResult = this.contextVariableName;
			stringBuffer.appendLine(booleanExpressionResult + " = "
					+ rightResult + ";");

			stringBuffer.append("}");
		}

		this.contextVariableName = booleanExpressionResult;
	}
}
