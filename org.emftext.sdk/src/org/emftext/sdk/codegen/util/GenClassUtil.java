package org.emftext.sdk.codegen.util;

import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;

/**
 * A utility class to work with EMF GenClasses.
 */
public class GenClassUtil {

	public boolean isConcrete(GenClass genClass) {
		return !genClass.isAbstract() && !genClass.isInterface();
	}

	public boolean isNotConcrete(GenClass genClass) {
		return !isConcrete(genClass);
	}

	public boolean isSuperClass(GenClass superClass, GenClass subClass) {
		List<GenClass> superClasses = subClass.getAllBaseGenClasses();
		for (GenClass nextSuperclass : superClasses) {
			if (nextSuperclass.getQualifiedInterfaceName().equals(superClass.getQualifiedInterfaceName())) {
				return true;
			}
		}
		return false;
	}

	public String getAccessor(GenClass genClass) {
		return genClass.getGenPackage().getQualifiedPackageInterfaceName() + ".eINSTANCE.get" + genClass.getClassifierAccessorName() + "()";
	}
}
