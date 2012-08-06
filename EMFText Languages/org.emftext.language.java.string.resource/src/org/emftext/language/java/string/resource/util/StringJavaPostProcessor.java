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
package org.emftext.language.java.string.resource.util;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.java.references.ElementReference;
import org.emftext.language.java.references.IdentifierReference;
import org.emftext.language.java.references.ReferenceableElement;
import org.emftext.language.java.string.resource.stringjava.IStringjavaOptionProvider;
import org.emftext.language.java.string.resource.stringjava.IStringjavaOptions;
import org.emftext.language.java.string.resource.stringjava.IStringjavaResourcePostProcessor;
import org.emftext.language.java.string.resource.stringjava.IStringjavaResourcePostProcessorProvider;
import org.emftext.language.java.string.resource.stringjava.mopp.StringjavaContextDependentURIFragmentFactory;
import org.emftext.language.java.string.resource.stringjava.mopp.StringjavaReferenceResolverSwitch;
import org.emftext.language.java.string.resource.stringjava.mopp.StringjavaResource;
import org.emftext.language.java.util.JavaModelCompletion;
import org.emftext.language.java.util.JavaModelRepairer;

/**
 * Post processor that performs
 * <i>cast repair</i>,
 * <i>expression simplification</i> and
 * <i>java model completion</i>
 * on a resource after parsing using the JavaModelRepairer.
 */
public class StringJavaPostProcessor implements
	IStringjavaOptionProvider,
	IStringjavaResourcePostProcessor,
	IStringjavaResourcePostProcessorProvider {

	public Map<?, ?> getOptions() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(IStringjavaOptions.RESOURCE_POSTPROCESSOR_PROVIDER, this);
		return map;
	}

	public void process(StringjavaResource resource) {
		new JavaModelRepairer() {

			protected void registerContextDependentProxy(
					Resource resource,
					IdentifierReference mainIdReference,
					EReference targetReference,
					String id, EObject proxy) {

				((StringjavaResource)resource).registerContextDependentProxy(
						new StringjavaContextDependentURIFragmentFactory
							<ElementReference, ReferenceableElement>
								(new StringjavaReferenceResolverSwitch().getElementReferenceTargetReferenceResolver()),
						mainIdReference,
						targetReference,
						id,
						proxy);
			}
		}.repair(resource);

		JavaModelCompletion.complete(resource);
	}

	public IStringjavaResourcePostProcessor getResourcePostProcessor() {
		return this;
	}
}
