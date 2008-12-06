package org.emftext.sdk.codegen;

import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.ecore.EClass;
import org.emftext.sdk.concretesyntax.Option;
import org.emftext.sdk.concretesyntax.Rule;

public class GeneratorUtil {

	/**
	 * Collects all the subclasses for which concrete syntax is defined.
	 */
	public static Collection<GenClass> getSubClassesWithCS(GenClass genClass,
			Collection<Rule> source) {
		Collection<GenClass> subClasses = new LinkedList<GenClass>();

		for (Rule rule : source) {
			GenClass subClassCand = rule.getMetaclass();
			// There seem to be multiple instances of metaclasses when accessed
			// through the genmodel. Therefore, we compare by name
			for (EClass superClass : subClassCand.getEcoreClass()
					.getEAllSuperTypes()) {
				EClass ecoreClass = genClass.getEcoreClass();
				if (namesAndPackageURIsAreEqual(superClass, ecoreClass)) {
					subClasses.add(subClassCand);
				}
			}
		}
		return subClasses;
	}

	/**
	 * Checks whether a subclass with concrete syntax does exist.
	 */
	public static boolean hasSubClassesWithCS(GenClass genClass,
			Collection<Rule> source) {
		for (Rule rule : source) {
			GenClass subClassCand = rule.getMetaclass();
			for (EClass superClass : subClassCand.getEcoreClass()
					.getEAllSuperTypes()) {
				EClass ecoreClass = genClass.getEcoreClass();
				if (namesAndPackageURIsAreEqual(superClass, ecoreClass)) {
					return true;
				}
			}
		}
		return false;

	}

	public static Option getOptionByName(String optionName,
			Collection<Option> options) {
		if (options != null && !options.isEmpty()) {
			for (Option option : options) {
				if (optionName.equals(option.getName())) {
					return option;
				}
			}
		}
		return null;
	}

	private static boolean namesAndPackageURIsAreEqual(EClass classA,
			EClass classB) {
		return namesAreEqual(classA, classB) && 
			packageURIsAreEqual(classA, classB);
	}

	private static boolean packageURIsAreEqual(EClass classA,
			EClass classB) {
		return classA.getEPackage().getNsURI().equals(
				classB.getEPackage().getNsURI());
	}

	private static boolean namesAreEqual(EClass classA, EClass classB) {
		return classA.getName().equals(classB.getName());
	}
}
