/*******************************************************************************
 * Copyright (c) 2006-2010 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.codegen.util;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EClass;

/**
 * A utility class to work with EMF GenClasses.
 */
public class GenClassUtil {

	private final GenClassCache genClassCache = new GenClassCache();

	public boolean contains(Collection<GenClass> genClasses,
			GenClass genClass) {
		for (GenClass next : genClasses) {
			if (genClassCache.getQualifiedInterfaceName(next).equals(genClassCache.getQualifiedInterfaceName(genClass))) {
				return true;
			}
		}
		return false;
	}

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

	public String getCreateObjectCall(GenClass genClass, String qualifiedDummyEObjectClassName) {
		GenPackage genPackage = genClass.getGenPackage();
		if (Map.Entry.class.getName().equals(genClass.getEcoreClass().getInstanceClassName())) {
			return "new " + qualifiedDummyEObjectClassName + "("+ genPackage.getQualifiedPackageClassName() + ".eINSTANCE.get" + genClass.getName() 
					+ "(),\"" + genClass.getName() + "\")";
	    } else {
	    	return genPackage.getQualifiedFactoryInterfaceName() + ".eINSTANCE.create" + genClass.getName() + "()";
	    }
	}
	
	//TODO Original method from MetaclassReferenceResolver Check if this is equal to isSuperClass() above, if yes remove this method if 
	//not document the difference.
	@Deprecated
	public boolean hasSupertype(GenClass genClass,
			GenClass requiredSuperType) {
		if (requiredSuperType == null) {
			return true;
		}
		if (genClass.equals(requiredSuperType)) {
			return true;
		}
		for (EClass superTypeCand : genClass.getEcoreClass().getEAllSuperTypes()) {
			if (namesAndPackageURIsAreEqual(requiredSuperType.getEcoreClass(), superTypeCand)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean namesAndPackageURIsAreEqual(EClass classA,
			EClass classB) {
		return namesAreEqual(classA, classB) && 
			packageURIsAreEqual(classA, classB);
	}

	private boolean packageURIsAreEqual(EClass classA,
			EClass classB) {
		return classA.getEPackage().getNsURI().equals(
				classB.getEPackage().getNsURI());
	}

	private boolean namesAreEqual(EClass classA, EClass classB) {
		return classA.getName().equals(classB.getName());
	}

}
