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

import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.eag.AttributeGrammar;
import org.emftext.language.eag.Computation;
import org.emftext.language.eag.Import;
import org.emftext.language.eag.resource.eag.IEagReferenceResolveResult;
import org.emftext.language.eag.resource.eag.IEagReferenceResolver;

public class ComputationContextReferenceResolver implements IEagReferenceResolver<Computation, EClass> {
	
	public void resolve(String identifier, Computation container, EReference reference, int position, boolean resolveFuzzy, final IEagReferenceResolveResult<EClass> result) {
		AttributeGrammar grammar = (AttributeGrammar) EcoreUtil.getRootContainer(container);
		EList<Import> imports = grammar.getImports();
		for (Import nextImport : imports) {
			// TODO check prefix
			EPackage importedPackage = nextImport.getImportedPackage();
			EList<EClassifier> eClassifiers = importedPackage.getEClassifiers();
			for (EClassifier eClassifier : eClassifiers) {
				if (eClassifier instanceof EClass) {
					EClass eClass = (EClass) eClassifier;
					String name = eClass.getName();
					if (resolveFuzzy || identifier.equals(name)) {
						result.addMapping(name, eClass);
						if (!resolveFuzzy) {
							return;
						}
					}
				}
			}
		}
	}
	
	public String deResolve(EClass element, Computation container, EReference reference) {
		// TODO add prefix of import
		return element.getName();
	}
	
	public void setOptions(Map<?,?> options) {
	}
}
