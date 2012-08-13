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
package org.emftext.sdk.concretesyntax.resource.cs.postprocessing.syntax_analysis;

import java.util.Collection;
import java.util.List;

import org.emftext.sdk.concretesyntax.Annotation;
import org.emftext.sdk.concretesyntax.AnnotationType;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.KeyValuePair;
import org.emftext.sdk.concretesyntax.resource.cs.CsEProblemSeverity;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsAnalysisProblemType;
import org.emftext.sdk.concretesyntax.resource.cs.postprocessing.AbstractPostProcessor;
import org.emftext.sdk.concretesyntax.resource.cs.util.CsEObjectUtil;

/**
 * This class checks that only valid types of warnings are suppressed.
 */
public class SuppressedWarningTypesAnalyser extends AbstractPostProcessor {

	@Override
	public void analyse(ConcreteSyntax syntax) {
		Collection<Annotation> annotations = CsEObjectUtil.getObjectsByType(syntax.eAllContents(), ConcretesyntaxPackage.eINSTANCE.getAnnotation());
		for (Annotation annotation : annotations) {
			AnnotationType type = annotation.getType();
			if (type == AnnotationType.SUPPRESS_WARNINGS) {
				// check type
				List<KeyValuePair> parameters = annotation.getParameters();
				for (KeyValuePair parameter : parameters) {
					final String key = parameter.getKey();
					// check whether 'key' is a valid warning type
					boolean isValid = isValidWarningType(key);
					if (!isValid) {
						addProblem(CsAnalysisProblemType.INVALID_WARNING_TYPE, "Invalid warning type found: " + key, annotation);
					}
				}
			}
		}
	}

	private boolean isValidWarningType(String key) {
		for (CsAnalysisProblemType problemType : CsAnalysisProblemType.values()) {
			// errors are not valid
			if (problemType.getProblemSeverity() == CsEProblemSeverity.ERROR) {
				continue;
			}
			if (problemType.getName().equals(key)) {
				return true;
			}
		}
		return false;
	}
}
