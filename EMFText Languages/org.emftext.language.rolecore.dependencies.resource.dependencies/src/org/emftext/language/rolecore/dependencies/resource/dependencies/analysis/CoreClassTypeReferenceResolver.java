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
import org.emftext.language.rolecore.dependencies.Domain;

public class CoreClassTypeReferenceResolver implements org.emftext.language.rolecore.dependencies.resource.dependencies.IDependenciesReferenceResolver<org.emftext.language.rolecore.dependencies.CoreClass, org.eclipse.emf.ecore.EClass> {
	
	private org.emftext.language.rolecore.dependencies.resource.dependencies.analysis.DependenciesDefaultResolverDelegate<org.emftext.language.rolecore.dependencies.CoreClass, org.eclipse.emf.ecore.EClass> delegate = new org.emftext.language.rolecore.dependencies.resource.dependencies.analysis.DependenciesDefaultResolverDelegate<org.emftext.language.rolecore.dependencies.CoreClass, org.eclipse.emf.ecore.EClass>();
	
	public void resolve(java.lang.String identifier, org.emftext.language.rolecore.dependencies.CoreClass container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.rolecore.dependencies.resource.dependencies.IDependenciesReferenceResolveResult<org.eclipse.emf.ecore.EClass> result) {
		Domain domain = null;
		if (container.eContainer().eContainer() instanceof Domain)
			domain = (Domain)container.eContainer().eContainer();
		if (domain == null)
			return;
		EList<EClassifier> classifiers = domain.getModelPackage().getEClassifiers();
		for (EClassifier classifier : classifiers){
			if (classifier.getName().equals(identifier+"Core")){
				result.addMapping(identifier, (EClass)classifier);
				return;
			}
		}
		// TODO add code for resolveFuzzy
		//delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public java.lang.String deResolve(org.eclipse.emf.ecore.EClass element, org.emftext.language.rolecore.dependencies.CoreClass container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
