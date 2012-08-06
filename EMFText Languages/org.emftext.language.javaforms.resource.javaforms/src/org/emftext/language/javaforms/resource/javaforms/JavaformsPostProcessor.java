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
package org.emftext.language.javaforms.resource.javaforms;

import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.java.references.ElementReference;
import org.emftext.language.java.references.IdentifierReference;
import org.emftext.language.java.references.ReferenceableElement;
import org.emftext.language.java.util.JavaModelCompletion;
import org.emftext.language.java.util.JavaModelRepairer;
import org.emftext.language.javaforms.resource.javaforms.mopp.JavaformsContextDependentURIFragmentFactory;
import org.emftext.language.javaforms.resource.javaforms.mopp.JavaformsReferenceResolverSwitch;
import org.emftext.language.javaforms.resource.javaforms.mopp.JavaformsResource;

public class JavaformsPostProcessor implements IJavaformsResourcePostProcessor, IJavaformsResourcePostProcessorProvider, IJavaformsOptionProvider {

	public Map<?, ?> getOptions() {
		return Collections.singletonMap(IJavaformsOptions.RESOURCE_POSTPROCESSOR_PROVIDER, this);
	}

	public void process(JavaformsResource resource) {
		processBasic(resource);
	}

	public void processBasic(Resource resource) {
		new JavaModelRepairer() {
			protected void registerContextDependentProxy(
					Resource resource,
					IdentifierReference mainIdReference, EReference targetReference,
					String id, EObject proxy) {
				assert !targetReference.isMany();

				((JavaformsResource)resource).registerContextDependentProxy(
						new JavaformsContextDependentURIFragmentFactory<ElementReference, ReferenceableElement>(new JavaformsReferenceResolverSwitch().getElementReferenceTargetReferenceResolver()),
						mainIdReference,
						targetReference,
						id,
						proxy,
						-1);
			}
		}.repair(resource);

		JavaModelCompletion.complete(resource);
	}

	public IJavaformsResourcePostProcessor getResourcePostProcessor() {
		return this;
	}

	public void terminate() {
		// do nothing
	}
}
