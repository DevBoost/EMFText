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
package org.emftext.language.java_templates.resource.util;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.java.jtemplates.resource.javatemplate.IJavatemplateOptionProvider;
import org.emftext.language.java.jtemplates.resource.javatemplate.IJavatemplateOptions;
import org.emftext.language.java.jtemplates.resource.javatemplate.IJavatemplateResourcePostProcessor;
import org.emftext.language.java.jtemplates.resource.javatemplate.IJavatemplateResourcePostProcessorProvider;
import org.emftext.language.java.jtemplates.resource.javatemplate.JavatemplateEProblemSeverity;
import org.emftext.language.java.jtemplates.resource.javatemplate.JavatemplateEProblemType;
import org.emftext.language.java.jtemplates.resource.javatemplate.mopp.JavatemplateContextDependentURIFragmentFactory;
import org.emftext.language.java.jtemplates.resource.javatemplate.mopp.JavatemplateProblem;
import org.emftext.language.java.jtemplates.resource.javatemplate.mopp.JavatemplateReferenceResolverSwitch;
import org.emftext.language.java.jtemplates.resource.javatemplate.mopp.JavatemplateResource;
import org.emftext.language.java.references.ElementReference;
import org.emftext.language.java.references.IdentifierReference;
import org.emftext.language.java.references.ReferenceableElement;
import org.emftext.language.java.util.JavaModelCompletion;
import org.emftext.language.java.util.JavaModelRepairer;
import org.emftext.language.templateconcepts.ExpressionChecker;

/**
 * Post processor that performs
 * <i>cast repair</i>,
 * <i>expression simplification</i> and
 * <i>java model completion</i>
 * on a resource after parsing using the JavaModelRepairer.
 */
public class Java_templatePostProcessor implements IJavatemplateOptionProvider, IJavatemplateResourcePostProcessor, IJavatemplateResourcePostProcessorProvider {

	private ExpressionChecker expressionChecker = new ExpressionChecker();

	public Map<?, ?> getOptions() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(IJavatemplateOptions.RESOURCE_POSTPROCESSOR_PROVIDER, this);
		return map;
	}

	public void process(final JavatemplateResource resource) {
		new JavaModelRepairer() {
			protected void registerContextDependentProxy(
					Resource resource,
					IdentifierReference mainIdReference, EReference targetReference,
					String id, EObject proxy) {
				assert !targetReference.isMany();

				((JavatemplateResource)resource).registerContextDependentProxy(
						new JavatemplateContextDependentURIFragmentFactory<ElementReference, ReferenceableElement>(new JavatemplateReferenceResolverSwitch().getElementReferenceTargetReferenceResolver()),
						mainIdReference,
						targetReference,
						id,
						proxy,
						-1);
			}
		}.repair(resource);

		JavaModelCompletion.complete(resource);
		expressionChecker.process(resource, new ExpressionChecker.ErrorReporter() {

			public void report(EObject element, String message) {
				resource.addProblem(new JavatemplateProblem(message, JavatemplateEProblemType.ANALYSIS_PROBLEM, JavatemplateEProblemSeverity.ERROR), element);
			}
		});
	}

	public IJavatemplateResourcePostProcessor getResourcePostProcessor() {
		return this;
	}

	public void terminate() {
		// do nothing
	}
}
