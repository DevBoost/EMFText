/*******************************************************************************
 * Copyright (c) 2006-2014
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
package org.emftext.sdk.codegen.resource.generators;

import static de.devboost.codecomposers.java.ClassNameConstants.ARRAY_LIST;
import static de.devboost.codecomposers.java.ClassNameConstants.ITERATOR;
import static de.devboost.codecomposers.java.ClassNameConstants.LIST;
import static de.devboost.codecomposers.java.IClassNameConstants.MAP_ENTRY;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.COLLECTION;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.COLLECTIONS;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.EMPTY_STACK_EXCEPTION;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.STACK;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenTypeParameter;
import org.emftext.sdk.codegen.annotations.SyntaxDependent;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenClassInheritanceComparator;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.GenClassCache;
import org.emftext.sdk.util.ConcreteSyntaxUtil;

import de.devboost.codecomposers.java.JavaComposite;
import de.devboost.codecomposers.util.StringUtil;

@SyntaxDependent
public class AbstractInterpreterGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	private ConcreteSyntax concreteSyntax;
	private Set<GenClass> allGenClasses;
	private GenClassCache genClassCache;
	
	@Override
	public void generateJavaContents(JavaComposite sc) {
		concreteSyntax = getContext().getConcreteSyntax();
		genClassCache = concreteSyntax.getGenClassCache();
		allGenClasses = new ConcreteSyntaxUtil().getAllGenClasses(concreteSyntax);

		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.addImportsPlaceholder();
		sc.addLineBreak();
		sc.addJavadoc(
				"This class provides basic infrastructure to interpret models. " +
				"To implement concrete interpreters, subclass this abstract interpreter " +
				"and override the interprete_* methods. The interpretation can be customized " +
				"by binding the two type parameters (ResultType, ContextType). The former " +
				"is returned by all interprete_* methods, while the latter is passed from " +
				"method to method while traversing the model. The concrete traversal strategy " +
				"can also be exchanged. One can use a static traversal strategy by pushing " +
				"all objects to interpret on the interpretation stack (using addObjectToInterprete()) " +
				"before calling interprete(). Alternatively, the traversal strategy can be dynamic " +
				"by pushing objects on the interpretation stack during interpretation."
		);
		sc.add("public class " + getResourceClassName() + "<ResultType, ContextType> {");
		// We must add the type parameters as implicit imports to make sure that
		// classes with the same name are referenced using fully qualified
		// names.
		sc.addImplicitImport("ResultType");
		sc.addImplicitImport("ContextType");
		sc.addLineBreak();
		addFields(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addMethods(JavaComposite sc) {
		addInterpreteMethod(sc);
		addContinueInterpretationMethod(sc);
		addDoSwitchMethod(sc);
		addInterpreteTypeMethods(sc);
		addNotifyListenersMethod(sc);
		addAddObjectToInterpreteMethod(sc);
		addAddObjectsToInterpreteMethod(sc);
		addAddObjectsToInterpreteInReverseOrderMethod(sc);
		addAddObjectTreeToInterpreteTopDownMethod(sc);
		addAddListenerMethod(sc);
		addRemoveListenerMethod(sc);
		addGetNextObjectToInterpreteMethod(sc);
		addGetInterpretationStackMethod(sc);
		addTerminateMethod(sc);
		addGetCurrentContextMethod(sc);
	}

	private void addAddObjectTreeToInterpreteTopDownMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Adds the given object and all its children to the interpretation stack such that they are interpret in top down order."
		);
		sc.add("public void addObjectTreeToInterpreteTopDown(" + E_OBJECT(sc) + " root) {");
		sc.add(LIST(sc) + "<" + E_OBJECT(sc) + "> objects = new " + ARRAY_LIST(sc) + "<" + E_OBJECT(sc) + ">();");
		sc.add("objects.add(root);");
		sc.add(ITERATOR(sc) + "<" + E_OBJECT(sc) + "> it = root.eAllContents();");
		sc.add("while (it.hasNext()) {");
		sc.add(E_OBJECT(sc) + " eObject = (" + E_OBJECT(sc) + ") it.next();");
		sc.add("objects.add(eObject);");
		sc.add("}");
		sc.add("addObjectsToInterpreteInReverseOrder(objects);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetNextObjectToInterpreteMethod(JavaComposite sc) {
		sc.add("public " + E_OBJECT(sc) + " getNextObjectToInterprete() {");
		sc.add("return nextObjectToInterprete;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetInterpretationStackMethod(JavaComposite sc) {
		sc.add("public " + STACK(sc) + "<" + E_OBJECT(sc) + "> getInterpretationStack() {");
		sc.add("return interpretationStack;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addTerminateMethod(JavaComposite sc) {
		sc.add("public void terminate() {");
		sc.add("interpretationStack.clear();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetCurrentContextMethod(JavaComposite sc) {
		sc.add("public ContextType getCurrentContext() {");
		sc.add("return currentContext;");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addAddListenerMethod(JavaComposite sc) {
		sc.add("public void addListener(" + iInterpreterListenerClassName + " newListener) {");
		sc.add("listeners.add(newListener);");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addRemoveListenerMethod(JavaComposite sc) {
		sc.add("public boolean removeListener(" + iInterpreterListenerClassName + " listener) {");
		sc.add("return listeners.remove(listener);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addContinueInterpretationMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Override this method to stop the overall interpretation depending on " +
			"the result of the interpretation of a single model elements."
		);
		sc.add("public boolean continueInterpretation(ContextType context, ResultType result) {");
		sc.add("return true;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addDoSwitchMethod(JavaComposite sc) {
		sc.add("public ResultType interprete(" + E_OBJECT(sc) + " object, ContextType context) {");
		sc.add("ResultType result = null;");
		// sort genClasses by inheritance
		List<GenClass> sortedClasses = new ArrayList<GenClass>();
		sortedClasses.addAll(allGenClasses);
		Collections.sort(sortedClasses, new GenClassInheritanceComparator());
		
		// add if statement for each class
		for (GenClass genClass : sortedClasses) {
			String methodName = getMethodName(genClass);
			String typeName = getTypeName(genClass);
			String typeArgumentString = getTypeArguments(genClass);
			sc.add("if (object instanceof " + typeName + ") {");
			sc.add("result = " + methodName + "((" + typeName + typeArgumentString + ") object, context);");
			sc.add("}");
			sc.add("if (result != null) {");
			sc.add("return result;");
			sc.add("}");
		}
		sc.add("return result;");
		sc.add("}");
		sc.addLineBreak();
	}

	private String getTypeArguments(GenClass genClass) {
		// for generic types we must add type arguments to avoid compiler
		// warnings
		List<GenTypeParameter> genTypeParameters = genClass.getGenTypeParameters();
		int getTypeParameterCount = genTypeParameters.size();
		String typeArgumentString;
		if (getTypeParameterCount <= 0) {
			typeArgumentString = "";
		} else {
			List<String> typeArguments = new ArrayList<String>(getTypeParameterCount);
			for (int i = 0; i < getTypeParameterCount; i++) {
				typeArguments.add("?");
			}
			typeArgumentString = "<" + StringUtil.explode(typeArguments, ", ") + ">";
		}
		return typeArgumentString;
	}

	private String getTypeName(GenClass genClass) {
		String typeName = genClassCache.getQualifiedInterfaceName(genClass);
		// for maps we add type arguments to avoid compiler warnings
		if (MAP_ENTRY.equals(typeName)) {
			typeName += "<?,?>";
		}
		return typeName;
	}

	private void addInterpreteTypeMethods(JavaComposite sc) {
		for (GenClass genClass : allGenClasses) {
			addInterpreteTypeMethod(sc, genClass);
		}
	}

	private void addInterpreteTypeMethod(JavaComposite sc, GenClass genClass) {
		String typeName = sc.getClassName(getTypeName(genClass));
		String methodName = getMethodName(genClass);
		String objectName = StringUtil.firstToLower(genClass.getName());
		if ("context".equals(objectName) || StringUtil.isReserveredWord(objectName)) {
			objectName = "_" + objectName;
		}
		String typeArgumentString = getTypeArguments(genClass);
		sc.add("public ResultType " + methodName + "(" + typeName + typeArgumentString + " " + objectName + ", ContextType context) {");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private String getMethodName(GenClass genClass) {
		String escapedTypeName = genClassCache.getEscapedTypeName(genClass);
		String methodName = "interprete_" + escapedTypeName;
		return methodName;
	}

	private void addFields(de.devboost.codecomposers.java.JavaComposite sc) {
		sc.add("private " + STACK(sc) + "<" + E_OBJECT(sc) + "> interpretationStack = new " + STACK(sc) + "<" + E_OBJECT(sc) + ">();");
		sc.add("private " + LIST(sc) + "<" + iInterpreterListenerClassName + "> listeners = new " + ARRAY_LIST(sc) + "<" + iInterpreterListenerClassName + ">();");
		sc.add("private " + E_OBJECT(sc) + " nextObjectToInterprete;");
		sc.add("private ContextType currentContext;");
		sc.addLineBreak();
	}

	private void addInterpreteMethod(JavaComposite sc) {
		sc.add("public ResultType interprete(ContextType context) {");
		sc.add("ResultType result = null;");
		sc.add(E_OBJECT(sc) + " next = null;");
		sc.add("currentContext = context;");
		sc.add("while (!interpretationStack.empty()) {");
		sc.add("try {");
		sc.add("next = interpretationStack.pop();");
		sc.add("} catch (" + EMPTY_STACK_EXCEPTION(sc) + " ese) {");
		sc.addComment(
			"this can happen when the interpreter was terminated between " +
			"the call to empty() and pop()"
		);
		sc.add("break;");
		sc.add("}");
		sc.add("nextObjectToInterprete = next;");
		sc.add("notifyListeners(next);");
		sc.add("result = interprete(next, context);");
		sc.add("if (!continueInterpretation(context, result)) {");
		sc.add("break;");
		sc.add("}");
		sc.add("}");
		sc.add("currentContext = null;");
		sc.add("return result;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addNotifyListenersMethod(de.devboost.codecomposers.java.JavaComposite sc) {
		sc.add("private void notifyListeners(" + E_OBJECT(sc) + " element) {");
		sc.add("for (" + iInterpreterListenerClassName + " listener : listeners) {");
		sc.add("listener.handleInterpreteObject(element);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddObjectToInterpreteMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Adds the given object to the interpretation stack. Attention: " +
			"Objects that are added first, are interpret last."
		);
		sc.add("public void addObjectToInterprete(" + E_OBJECT(sc) + " object) {");
		sc.add("interpretationStack.push(object);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddObjectsToInterpreteMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Adds the given collection of objects to the interpretation stack. Attention: " +
			"Collections that are added first, are interpret last."
		);
		sc.add("public void addObjectsToInterprete(" + COLLECTION(sc) + "<? extends " + E_OBJECT(sc) + "> objects) {");
		sc.add("for (" + E_OBJECT(sc) + " object : objects) {");
		sc.add("addObjectToInterprete(object);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddObjectsToInterpreteInReverseOrderMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Adds the given collection of objects in reverse order to the interpretation stack."
		);
		sc.add("public void addObjectsToInterpreteInReverseOrder(" + COLLECTION(sc) + "<? extends " + E_OBJECT(sc) + "> objects) {");
		sc.add(LIST(sc) + "<" + E_OBJECT(sc) + "> reverse = new " + ARRAY_LIST(sc) + "<" + E_OBJECT(sc) + ">(objects.size());");
		sc.add("reverse.addAll(objects);");
		sc.add(COLLECTIONS(sc) + ".reverse(reverse);");
		sc.add("addObjectsToInterprete(reverse);");
		sc.add("}");
		sc.addLineBreak();
	}
}
