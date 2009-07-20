package org.emftext.sdk.codegen.util;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.DUMMY_E_OBJECT;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;

/**
 * A utility class to work with EMF GenClasses.
 */
public class GenClassUtil {

	private final GenClassCache genClassCache = new GenClassCache();

	public boolean isConcrete(GenClass genClass) {
		return !genClass.isAbstract() && !genClass.isInterface();
	}

	public boolean isNotConcrete(GenClass genClass) {
		return !isConcrete(genClass);
	}

	public boolean isSuperClass(GenClass superClass, GenClass subClass) {
		List<GenClass> superClasses = subClass.getAllBaseGenClasses();
		for (GenClass nextSuperclass : superClasses) {
			if (genClassCache.getQualifiedInterfaceName(nextSuperclass).equals(genClassCache.getQualifiedInterfaceName(superClass))) {
				return true;
			}
		}
		return false;
	}

	public String getAccessor(GenClass genClass) {
		return genClass.getGenPackage().getQualifiedPackageInterfaceName() + ".eINSTANCE.get" + genClass.getClassifierAccessorName() + "()";
	}

	public String getCreateObjectCall(GenClass genClass) {
		GenPackage genPackage = genClass.getGenPackage();
		if (Map.Entry.class.getName().equals(genClass.getEcoreClass().getInstanceClassName())) {
			return "new " + DUMMY_E_OBJECT + "("+ genPackage.getQualifiedPackageClassName() + ".eINSTANCE.get" + genClass.getName() 
					+ "(),\"" + genClass.getName() + "\")";
	    } else {
	    	return genPackage.getQualifiedFactoryInterfaceName() + ".eINSTANCE.create" + genClass.getName() + "()";
	    }
	}
}
