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
package org.emftext.language.eag.resource.eag.analysis;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.emftext.language.eag.AttributeGrammar;
import org.emftext.language.eag.Import;

public class AttributeTypeReferenceResolver implements org.emftext.language.eag.resource.eag.IEagReferenceResolver<org.emftext.language.eag.Attribute, EClassifier> {
		
	public void resolve(String identifier, org.emftext.language.eag.Attribute container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.eag.resource.eag.IEagReferenceResolveResult<EClassifier> result) {
		AttributeGrammar grammar = (AttributeGrammar) container.eContainer();
		EList<Import> imports = grammar.getImports();
		for (Import nextImport : imports) {
			EPackage importedPackage = nextImport.getImportedPackage();
			resolve(identifier, resolveFuzzy, result, importedPackage);
			if (result.wasResolved() && !resolveFuzzy) {
				return;
			}
		}
		EcorePackage ecorePackage = EcorePackage.eINSTANCE;
		resolve(identifier, resolveFuzzy, result, ecorePackage);
	}

	private void resolve(
			String identifier,
			boolean resolveFuzzy,
			final org.emftext.language.eag.resource.eag.IEagReferenceResolveResult<EClassifier> result,
			EPackage ePackage) {
		EList<EObject> contents = ePackage.eContents();
		for (EObject content : contents) {
			if (content instanceof EClassifier) {
				EClassifier eClassifier = (EClassifier) content;
				String name = eClassifier.getName();
				if (resolveFuzzy || identifier.equals(name)) {
					result.addMapping(name, eClassifier);
					if (!resolveFuzzy) {
						return;
					}
				}
			}
		}
	}
	
	public String deResolve(EClassifier element, org.emftext.language.eag.Attribute container, org.eclipse.emf.ecore.EReference reference) {
		return element.getName();
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
