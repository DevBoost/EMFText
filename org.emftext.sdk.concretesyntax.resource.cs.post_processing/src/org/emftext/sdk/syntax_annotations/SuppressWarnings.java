/*******************************************************************************
 * Copyright (c) 2006-2010 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.syntax_annotations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.IProblemWrapper;
import org.emftext.sdk.concretesyntax.Annotation;
import org.emftext.sdk.concretesyntax.AnnotationType;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.KeyValuePair;
import org.emftext.sdk.concretesyntax.resource.cs.CsEProblemType;
import org.emftext.sdk.concretesyntax.resource.cs.ICsProblem;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsProblem;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.ECsProblemType;
import org.emftext.sdk.concretesyntax.resource.cs.util.CsEObjectUtil;

public class SuppressWarnings extends AbstractPostProcessor {

	@Override
	public void analyse(ConcreteSyntax syntax) {
	    Collection<IProblemWrapper> warningsToRemove = new ArrayList<IProblemWrapper>();
		Collection<Annotation> annotations = CsEObjectUtil.getObjectsByType(syntax.eAllContents(), ConcretesyntaxPackage.eINSTANCE.getAnnotation());
		for (Annotation annotation : annotations) {
			AnnotationType type = annotation.getType();
			if (type == AnnotationType.SUPPRESS_WARNINGS) {
				Collection<String> warningsToSuppress = getWarningsToSuppress(annotation);
				EObject annotatedElement = annotation.eContainer();
				List<IProblemWrapper> warnings = getContext().getWarnings();
				for (IProblemWrapper warning : warnings) {
					if (wasCausedBy(warning, annotatedElement)) {
						if (warningsToSuppress.size() == 0) {
							warningsToRemove.add(warning);
						} else {
							// check type of the warnings
							ICsProblem problem = warning.getProblem();
							if (problem == null) {
								continue;
							}
							if (problem instanceof CsProblem) {
								CsProblem csProblem = (CsProblem) problem;
								ECsProblemType problemType = csProblem.getCsType();
								String typeName = problemType.getName();
								if (warningsToSuppress.contains(typeName)) {
									warningsToRemove.add(warning);
								}
							}
						}
					}
				}
			}
		}
		for (IProblemWrapper warningToRemove : warningsToRemove) {
			getContext().removeWarning(warningToRemove);
		}
	}

	private Collection<String> getWarningsToSuppress(Annotation annotation) {
		Collection<String> warningsToSuppress = new LinkedHashSet<String>();
		List<KeyValuePair> parameters = annotation.getParameters();
		for (KeyValuePair parameter : parameters) {
			final String key = parameter.getKey();
			// check whether 'key' is a valid warning type
			boolean isValid = isValidWarningType(key);
			if (!isValid) {
				addProblem(ECsProblemType.INVALID_WARNING_TYPE, "Invalid warning type found: " + key, annotation);
			}
			warningsToSuppress.add(key);
		}
		return warningsToSuppress;
	}

	private boolean isValidWarningType(String key) {
		for (ECsProblemType problemType : ECsProblemType.values()) {
			// errors are not valid
			if (problemType.getProblemType() == CsEProblemType.ERROR) {
				continue;
			}
			if (problemType.getName().equals(key)) {
				return true;
			}
		}
		return false;
	}

	private boolean wasCausedBy(IProblemWrapper problem,
			EObject annotatedElement) {
		if (problem.wasCausedBy(annotatedElement)) {
			return true;
		}
		Iterator<EObject> children = annotatedElement.eAllContents();
		while (children.hasNext()) {
			EObject child = children.next();
			if (problem.wasCausedBy(child)) {
				return true;
			}
		}
		return false;
	}
}
