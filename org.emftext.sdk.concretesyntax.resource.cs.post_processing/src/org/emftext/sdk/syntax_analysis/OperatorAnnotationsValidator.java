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
package org.emftext.sdk.syntax_analysis;

import java.util.List;

import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.concretesyntax.Annotation;
import org.emftext.sdk.concretesyntax.AnnotationType;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Containment;
import org.emftext.sdk.concretesyntax.CsString;
import org.emftext.sdk.concretesyntax.Definition;
import org.emftext.sdk.concretesyntax.OperatorAnnotationProperty;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.Sequence;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResource;

public class OperatorAnnotationsValidator extends AbstractPostProcessor {

	// TODO mseifert: split this method
	@Override
	public void analyse(CsResource resource, ConcreteSyntax syntax) {
		for(Rule expressionRule:syntax.getOperatorRules()){
			Annotation annotation = expressionRule.getOperatorAnnotation();
			String weight = annotation.getValue(OperatorAnnotationProperty.WEIGHT.toString());
			String identifier = annotation.getValue(OperatorAnnotationProperty.IDENTIFIER.toString());
			if (weight == null || identifier == null) {
				resource.addError("Operator annotations require values for weigth and identifier.",annotation);
			}
			try {
				Integer.parseInt(weight);
			} catch (NumberFormatException nfe) {
				resource.addError("Weight parameter must be Integer.",annotation);
			}
			if (annotation.getType() != AnnotationType.OP_PRIMITIVE) {
				List<Sequence> options = expressionRule.getDefinition().getOptions();
				if (options.size() == 1) {
					List<Definition> definitions = options.get(0).getParts();
					if (annotation.getType() == AnnotationType.OP_LEFTASSOC || 
						annotation.getType() == AnnotationType.OP_RIGHTASSOC) {
						
						if (definitions.size() != 3 ||
							!(definitions.get(0) instanceof Containment) ||
							!(definitions.get(1) instanceof CsString) ||
							!(definitions.get(2) instanceof Containment)) {
							resource.addError("Binary operators require exactly three arguments (containment keyword containment).", annotation);										
						}
					} else {
						assert annotation.getType() == AnnotationType.OP_UNARY;
						if (definitions.size() !=2 ||
							!(definitions.get(0) instanceof CsString && definitions.get(1) instanceof Containment) &&
							!(definitions.get(0) instanceof Containment && definitions.get(1) instanceof CsString)) {
							resource.addError("Unary operators require exactly two arguments ( keyword containment, containment keyword).",annotation);										
						}
					}
				} else {
					resource.addError("Non primitive operator annotations require exactly one choice.", annotation);
				}
			}
		}
		for (String subsetIdent : syntax.getOperatorRuleSubsets()) {
			List<Rule> subset = syntax.getOperatorRuleSubset(subsetIdent);
			for (int i=0; i<subset.size(); i++) {
				Rule firstRule = subset.get(i);
				Annotation firstAnnotation = firstRule.getOperatorAnnotation();
				String firstWeight = firstAnnotation.getValue(OperatorAnnotationProperty.WEIGHT.toString());
				firstWeight = firstWeight == null ? "" : firstWeight; 
				for(int j = i + 1; j < subset.size(); j++) {
					Rule rule = subset.get(j);
					Annotation annotation = rule.getOperatorAnnotation();
					String weight = annotation.getValue(OperatorAnnotationProperty.WEIGHT.toString());
					if (!firstWeight.equals(weight)) {
						i = j-1;
						break;
					} else if (firstAnnotation.getType() != annotation.getType()) {
						resource.addError("All equal weight operators must be of the same operator type.", annotation);
					}
				}
			}
		}
	}
}
