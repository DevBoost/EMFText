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
package org.emftext.language.java.jtemplates.resource.javatemplate.analysis;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.emftext.language.java.jtemplates.resource.javatemplate.IJavatemplateReferenceResolveResult;
import org.emftext.language.java.jtemplates.resource.javatemplate.IJavatemplateReferenceResolver;
import org.emftext.language.templateconcepts.InputMetaClassReferenceResolver;
import org.emftext.language.templateconcepts.Template;

public class TemplateInputMetaClassReferenceResolver implements IJavatemplateReferenceResolver<org.emftext.language.templateconcepts.Template, EClass> {

	private InputMetaClassReferenceResolver resolverDelegate = new InputMetaClassReferenceResolver();

	public java.lang.String deResolve(EClass element, org.emftext.language.templateconcepts.Template container, EReference reference) {
		return resolverDelegate.deResolve(element, container, reference);
	}

	public void resolve(String identifier, Template container, EReference reference, int position, boolean resolveFuzzy, IJavatemplateReferenceResolveResult<EClass> result) {
		EClass resolved = resolverDelegate.resolve(identifier, container, reference, position, resolveFuzzy);
		if (resolved != null) {
			result.addMapping(identifier, resolved);
		}
	}

	public void setOptions(Map<?, ?> options) {
	}
}
