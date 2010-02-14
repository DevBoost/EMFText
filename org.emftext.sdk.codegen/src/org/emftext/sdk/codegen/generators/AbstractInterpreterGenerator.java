package org.emftext.sdk.codegen.generators;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.STACK;

import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Import;
import org.emftext.sdk.finders.GenClassFinder;

public class AbstractInterpreterGenerator extends JavaBaseGenerator {

	private GenClassFinder genClassFinder = new GenClassFinder();
	private ConcreteSyntax concreteSyntax;
	private Set<GenClass> allGenClasses;

	public AbstractInterpreterGenerator() {
		super();
	}

	private AbstractInterpreterGenerator(GenerationContext context) {
		super(context, EArtifact.ABSTRACT_INTERPRETER);
		concreteSyntax = context.getConcreteSyntax();
	}

	public IGenerator newInstance(GenerationContext context) {
		return new AbstractInterpreterGenerator(context);
	}

	@Override
	public boolean generateJavaContents(StringComposite sc) {
		allGenClasses = getAllGenClasses();

		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + "<ContextType> {");
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
		sc.add("public boolean doSwitch(" + E_OBJECT + " object, ContextType context) {");
		for (GenClass genClass : allGenClasses) {
			// TODO mseifert: sort genClasses by inheritance and add if statement
			// for each class
		}
		sc.add("return false;");
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
		String escapedTypeName = genClassFinder.getEscapedTypeName(genClass);
		String typeName = genClassFinder.getQualifiedInterfaceName(genClass);
		
		sc.add("public boolean interprete_" + escapedTypeName + "(" + typeName + " object, ContextType context) {");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
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
		sc.add("public boolean interprete(ContextType context) {");
		sc.add("while (!interpretationStack.empty()) {");
		sc.add(E_OBJECT + " next = interpretationStack.pop();");
		sc.add("doSwitch(next, context);");
		sc.add("}");
		sc.add("return false;");
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
