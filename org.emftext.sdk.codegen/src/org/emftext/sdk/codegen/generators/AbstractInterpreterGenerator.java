package org.emftext.sdk.codegen.generators;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.STACK;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.GenClassCache;
import org.emftext.sdk.concretesyntax.Import;
import org.emftext.sdk.finders.GenClassFinder;

public class AbstractInterpreterGenerator extends JavaBaseGenerator {

	private GenClassFinder genClassFinder = new GenClassFinder();
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

	public AbstractInterpreterGenerator() {
		super();
	}

	private AbstractInterpreterGenerator(GenerationContext context) {
		super(context, EArtifact.ABSTRACT_INTERPRETER);
		concreteSyntax = context.getConcreteSyntax();
		genClassCache = concreteSyntax.getGenClassCache();
	}

	public IGenerator newInstance(GenerationContext context) {
		return new AbstractInterpreterGenerator(context);
	}

	@Override
	public boolean generateJavaContents(StringComposite sc) {
		allGenClasses = getAllGenClasses();

		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + "<ResultType, ContextType> {");
		sc.addLineBreak();
		addFields(sc);
		addInterpreteMethod(sc);
		addDoSwitchMethod(sc);
		addInterpreteTypeMethods(sc);
		addAddObjectToInterpreteMethod(sc);
		sc.add("}");
		
		return true;
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
			String typeName = genClassCache.getQualifiedInterfaceName(genClass);
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
		String typeName = genClassCache.getQualifiedInterfaceName(genClass);
		String methodName = getMethodName(genClass);
		
		sc.add("public ResultType " + methodName + "(" + typeName + " object, ContextType context) {");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private String getMethodName(GenClass genClass) {
		String escapedTypeName = genClassFinder.getEscapedTypeName(genClass, genClassCache);
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
