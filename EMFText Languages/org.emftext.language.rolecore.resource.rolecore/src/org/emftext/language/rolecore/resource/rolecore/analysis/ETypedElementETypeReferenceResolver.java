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
package org.emftext.language.rolecore.resource.rolecore.analysis;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EReference;
import org.emftext.language.rolecore.Import;
import org.emftext.language.rolecore.NaturalType;
import org.emftext.language.rolecore.RCPackage;

public class ETypedElementETypeReferenceResolver
		implements
		org.emftext.language.rolecore.resource.rolecore.IRolecoreReferenceResolver<org.eclipse.emf.ecore.ETypedElement, org.eclipse.emf.ecore.EClassifier> {

	private org.emftext.language.rolecore.resource.rolecore.analysis.RolecoreDefaultResolverDelegate<org.eclipse.emf.ecore.ETypedElement, org.eclipse.emf.ecore.EClassifier> delegate = new org.emftext.language.rolecore.resource.rolecore.analysis.RolecoreDefaultResolverDelegate<org.eclipse.emf.ecore.ETypedElement, org.eclipse.emf.ecore.EClassifier>();

	public void resolve(
			java.lang.String identifier,
			org.eclipse.emf.ecore.ETypedElement container,
			org.eclipse.emf.ecore.EReference reference,
			int position,
			boolean resolveFuzzy,
			final org.emftext.language.rolecore.resource.rolecore.IRolecoreReferenceResolveResult<org.eclipse.emf.ecore.EClassifier> result) {
		// TODO resolve fuzzy
		if (container instanceof EAttribute) {
			org.eclipse.emf.common.util.EList<org.eclipse.emf.ecore.EClassifier> classifiers = org.eclipse.emf.ecore.EcorePackage.eINSTANCE
					.getEClassifiers();
			for (org.eclipse.emf.ecore.EClassifier classifier : classifiers) {
				if (identifier.equals(classifier.getName())) {
					result.addMapping(identifier, classifier);
					return;
				}
			}
		}
		else if (container instanceof EReference && identifier.indexOf("->")>-0){
			RCPackage rcPackage = (RCPackage) container.eContainer().eContainer();
			int arrowPos = identifier.indexOf("->");
			String prefix = identifier.substring(0, arrowPos);
			String type = identifier.substring(arrowPos+2, identifier.length());
			for (Import importPackage : rcPackage.getImports()){
				if (importPackage.getPrefix().equals(prefix)){
					for (NaturalType coreClass : importPackage.getImportedPackage().getNaturals()) {
						if (coreClass.getName().equals(type)){
							result.addMapping(coreClass.getName(), coreClass);
							return;
						}
					}
				}
			}
		}
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}

	public java.lang.String deResolve(org.eclipse.emf.ecore.EClassifier element,
			org.eclipse.emf.ecore.ETypedElement container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}

	public void setOptions(java.util.Map<?, ?> options) {
		// TODO save options in a field or leave method empty if this resolver
		// does not depend on any option
	}

}
