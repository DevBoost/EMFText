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
package org.emftext.language.rolecore.dependencies.resource.dependencies.analysis;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.emftext.language.rolecore.dependencies.CoreClass;
import org.emftext.language.rolecore.dependencies.resource.dependencies.IDependenciesReferenceResolveResult;

public class SimpleTermRoleReferenceResolver
		implements
		org.emftext.language.rolecore.dependencies.resource.dependencies.IDependenciesReferenceResolver<org.emftext.language.rolecore.dependencies.SimpleTerm, org.eclipse.emf.ecore.EClass> {

	private org.emftext.language.rolecore.dependencies.resource.dependencies.analysis.DependenciesDefaultResolverDelegate<org.emftext.language.rolecore.dependencies.SimpleTerm, org.eclipse.emf.ecore.EClass> delegate = new org.emftext.language.rolecore.dependencies.resource.dependencies.analysis.DependenciesDefaultResolverDelegate<org.emftext.language.rolecore.dependencies.SimpleTerm, org.eclipse.emf.ecore.EClass>();

	public void resolve(
			java.lang.String identifier,
			org.emftext.language.rolecore.dependencies.SimpleTerm container,
			org.eclipse.emf.ecore.EReference reference,
			int position,
			boolean resolveFuzzy,
			final org.emftext.language.rolecore.dependencies.resource.dependencies.IDependenciesReferenceResolveResult<org.eclipse.emf.ecore.EClass> result) {
		// equivalence
		CoreClass coreClass = container.getCoreClass();
		// blocks
		// in case w/o core class, 1st container is Edge, 2nd is CoreClass
		if (coreClass == null) {
			EObject eObject = container.eContainer().eContainer();
			if (eObject instanceof CoreClass) {
				coreClass = (CoreClass) eObject;
			}
		}
		if (!resolveFuzzy) {
			resolveRole(coreClass.getType(), identifier, result);
		}else{
			resolveFuzzyRole(coreClass.getType(), identifier, result);
		}
	}

	private void resolveFuzzyRole(EClass coreEClass, String identifier, IDependenciesReferenceResolveResult<EClass> result) {
		if (coreEClass == null){
			return;
		}
		String interfaceName = coreEClass.getName().substring(0, coreEClass.getName().lastIndexOf("Core"));
		EList<EClassifier> classifiers = coreEClass.getEPackage().getEClassifiers();
		for (EClassifier eClassifier : classifiers) {
			if (eClassifier instanceof EClass && eClassifier.getName().startsWith(identifier)){
				EList<EClass> superTypes = ((EClass)eClassifier).getESuperTypes();
				for (EClass eClass : superTypes) {
					if (eClass.getName().equals(interfaceName+"Role")){
						result.addMapping(eClassifier.getName(), (EClass)eClassifier);
					}
				}
			}
		}
		for (EClass superTypeEClass : coreEClass.getESuperTypes()) {
			if (superTypeEClass.getName().endsWith("Core")&&!superTypeEClass.getName().equals("RCCore")){
				resolveFuzzyRole(superTypeEClass, identifier, result);
			}
		}
	}

	private void resolveRole(EClass coreEClass, String identifier, IDependenciesReferenceResolveResult<EClass> result) {
		if (coreEClass == null) {
			return;
		}
		EPackage ePackage = coreEClass.getEPackage();
		EClassifier classifier = ePackage.getEClassifier(identifier);
		if (classifier != null && classifier instanceof EClass) {
			String interfaceName = coreEClass.getName().substring(0, coreEClass.getName().lastIndexOf("Core"));
			for (EClass eClass : ((EClass) classifier).getESuperTypes()) {
				if (eClass.getName().equals(interfaceName + "Role")) {
					result.addMapping(classifier.getName(), (EClass) classifier);
					return;
				}
			}
		}
		EList<EClass> superTypes = coreEClass.getESuperTypes();
		for (EClass superType : superTypes) {
			String superTypeName = superType.getName();
			if (superTypeName.endsWith("Core") && !superTypeName.equals("RCCore")) {
				resolveRole(superType, identifier, result);
				return;
			}
		}

	}

	public java.lang.String deResolve(org.eclipse.emf.ecore.EClass element,
			org.emftext.language.rolecore.dependencies.SimpleTerm container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}

	public void setOptions(java.util.Map<?, ?> options) {
		// save options in a field or leave method empty if this resolver does
		// not depend on any option
	}

}
