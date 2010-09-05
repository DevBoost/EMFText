package org.emftext.sdk.codegen.resource.generators;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.STACK;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.emftext.sdk.codegen.annotations.SyntaxDependent;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.GenClassCache;
import org.emftext.sdk.concretesyntax.Import;

@SyntaxDependent
public class AbstractInterpreterGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	private ConcreteSyntax concreteSyntax;
	private Set<GenClass> allGenClasses;
	private GenClassCache genClassCache;
	
	private class InheritanceComparator implements Comparator<GenClass>{

		public int compare(GenClass g1, GenClass g2) {
			List<GenClass> superClasses = g1.getAllBaseGenClasses();
			if (superClasses.contains(g2)) {
				return -1;
			} else {
				return 1;
			}
		}
		
	}

	@Override
	public void generateJavaContents(JavaComposite sc) {
		concreteSyntax = getContext().getConcreteSyntax();
		genClassCache = concreteSyntax.getGenClassCache();
		allGenClasses = getAllGenClasses();

		sc.add("package " + getResourcePackageName() + ";");
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
		addAddObjectToInterpreteMethod(sc);
	}

	private void addContinueInterpretationMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Override this method to stop the overall interpretation depending on " +
			"the result of the interpretation of a single model elements."
		);
		sc.add("public boolean continueInterpretation(ResultType result) {");
		sc.add("return true;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addDoSwitchMethod(StringComposite sc) {
		sc.add("public ResultType interprete(" + E_OBJECT + " object, ContextType context) {");
		sc.add("ResultType result = null;");
		// sort genClasses by inheritance
		List<GenClass> sortedClasses = new ArrayList<GenClass>();
		sortedClasses.addAll(allGenClasses);
		Collections.sort(sortedClasses, new InheritanceComparator());
		
		// add if statement for each class
		for (GenClass genClass : sortedClasses) {
			String methodName = getMethodName(genClass);
			String typeName = getTypeName(genClass);
			sc.add("if (object instanceof " + typeName + ") {");
			sc.add("result = " + methodName + "((" + typeName + ") object, context);");
			sc.add("}");
			sc.add("if (result != null) {");
			sc.add("return result;");
			sc.add("}");
		}
		sc.add("return result;");
		sc.add("}");
		sc.addLineBreak();
	}

	private String getTypeName(GenClass genClass) {
		String typeName = genClassCache.getQualifiedInterfaceName(genClass);
		// for maps we add type arguments to avoid compiler warnings
		if ("java.util.Map.Entry".equals(typeName)) {
			typeName += "<?,?>";
		}
		return typeName;
	}

	private void addInterpreteTypeMethods(StringComposite sc) {
		for (GenClass genClass : allGenClasses) {
			addInterpreteTypeMethod(sc, genClass);
		}
	}

	private Set<GenClass> getAllGenClasses() {
		Set<GenPackage> usedGenPackages = new LinkedHashSet<GenPackage>();
		usedGenPackages.add(concreteSyntax.getPackage());
		for (Import importElement : concreteSyntax.getImports()) {
			usedGenPackages.add(importElement.getPackage());
		}
		
		Set<GenClass> usedGenClasses = collectAllGenClasses(usedGenPackages);
		return usedGenClasses;
	}

	private void addInterpreteTypeMethod(StringComposite sc, GenClass genClass) {
		String typeName = getTypeName(genClass);
		String methodName = getMethodName(genClass);
		
		sc.add("public ResultType " + methodName + "(" + typeName + " object, ContextType context) {");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private String getMethodName(GenClass genClass) {
		String escapedTypeName = genClassCache.getEscapedTypeName(genClass);
		String methodName = "interprete_" + escapedTypeName;
		return methodName;
	}

	private Set<GenClass> collectAllGenClasses(Set<GenPackage> usedGenPackages) {
		Set<GenClass> allGenClasses = new LinkedHashSet<GenClass>();
		for (GenPackage genPackage : usedGenPackages) {
			for (GenClass genClass : genPackage.getGenClasses()) {
				allGenClasses.add(genClass);
			}
		}
		return allGenClasses;
	}

	private void addFields(StringComposite sc) {
		sc.add("private " + STACK + "<" + E_OBJECT + "> interpretationStack = new " + STACK + "<" + E_OBJECT + ">();");
		sc.addLineBreak();
	}

	private void addInterpreteMethod(StringComposite sc) {
		sc.add("public ResultType interprete(ContextType context) {");
		sc.add("ResultType result = null;");
		sc.add("while (!interpretationStack.empty()) {");
		sc.add(E_OBJECT + " next = interpretationStack.pop();");
		sc.add("result = interprete(next, context);");
		sc.add("if (!continueInterpretation(result)) {");
		sc.add("break;");
		sc.add("}");
		sc.add("}");
		sc.add("return result;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddObjectToInterpreteMethod(StringComposite sc) {
		sc.add("public void addObjectToInterprete(" + E_OBJECT + " object) {");
		sc.add("interpretationStack.push(object);");
		sc.add("}");
		sc.addLineBreak();
	}
}
