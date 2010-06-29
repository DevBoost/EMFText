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

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.CardinalityComputer;
import org.emftext.sdk.MinMax;
import org.emftext.sdk.concretesyntax.Choice;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResource;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.ECsProblemType;

/**
 * An analyser that checks whether the cardinality of a feature
 * matches the cardinality given in the syntax.
 */
public class FeatureCardinalityAnalyser extends AbstractPostProcessor {
	
	@Override
	public void analyse(CsResource resource, ConcreteSyntax syntax) {
		for (Rule rule : syntax.getAllRules()) {
			if (syntax.isImportedRule(rule)) {
				continue;
			}
			analyse(resource, rule);
		}
	}

	private void analyse(CsResource resource, Rule rule) {
		Choice choice = rule.getDefinition();
		Map<GenFeature, MinMax> featureToCountMap = new LinkedHashMap<GenFeature, MinMax>();
		new CardinalityComputer().countOccurences(choice, featureToCountMap);
		
		// compare counts with lower and upper bounds
		for (GenFeature feature : featureToCountMap.keySet()) {
			String lowerBoundString = feature.getLowerBound();
			String upperBoundString = feature.getUpperBound();
			int upperBound = Integer.parseInt(upperBoundString);
			int lowerBound = Integer.parseInt(lowerBoundString);
			
			// min/max cardinality in CS
			MinMax minMax = featureToCountMap.get(feature);
			// min/max cardinality in meta model
			MinMax metaMinMax = new MinMax(lowerBound, upperBound);
			
			int max = minMax.getMax();
			if (!metaMinMax.enclosesMax(minMax)) {
				addProblem(resource, ECsProblemType.MAX_OCCURENCE_MISMATCH, "Maximum occurences (" + max + ") of feature \"" + feature.getName() + "\" do not match upper bound (" + metaMinMax.getMax() + ").", rule);
			}
			int min = minMax.getMin();
			if (metaMinMax.getMin() != minMax.getMin()) {
				addProblem(resource, ECsProblemType.MIN_OCCURENCE_MISMATCH, "Minimum occurences (" + min + ") of feature \"" + feature.getName() + "\" do not match lower bound (" + metaMinMax.getMin() + ").", rule);
			}
		}
	}
}
