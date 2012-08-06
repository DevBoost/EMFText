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
package org.emftext.language.customsandwich.resource.customsandwich.analysis;

import org.eclipse.emf.ecore.EClass;
import org.emftext.language.templateconcepts.InputMetaClassReferenceResolver;

public class TemplateInputMetaClassReferenceResolver implements org.emftext.language.customsandwich.resource.customsandwich.ICustomsandwichReferenceResolver<org.emftext.language.templateconcepts.Template, org.eclipse.emf.ecore.EClass> {

	private InputMetaClassReferenceResolver resolverDelegate = new InputMetaClassReferenceResolver();

	public void resolve(java.lang.String identifier, org.emftext.language.templateconcepts.Template container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, org.emftext.language.customsandwich.resource.customsandwich.ICustomsandwichReferenceResolveResult<org.eclipse.emf.ecore.EClass> result) {
		EClass resolved = resolverDelegate.resolve(identifier, container, reference, position, resolveFuzzy);
		if (resolved != null) {
			result.addMapping(identifier, resolved);
		}
	}

	public java.lang.String deResolve(org.eclipse.emf.ecore.EClass element, org.emftext.language.templateconcepts.Template container, org.eclipse.emf.ecore.EReference reference) {
		return resolverDelegate.deResolve(element, container, reference);
	}

	public void setOptions(java.util.Map<?,?> options) {}

}
