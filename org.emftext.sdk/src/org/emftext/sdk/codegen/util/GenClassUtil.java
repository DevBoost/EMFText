package org.emftext.sdk.codegen.util;

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
}
