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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.ecore.EObject;
import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.concretesyntax.Cardinality;
import org.emftext.sdk.concretesyntax.CardinalityDefinition;
import org.emftext.sdk.concretesyntax.Choice;
import org.emftext.sdk.concretesyntax.CompoundDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Definition;
import org.emftext.sdk.concretesyntax.PLUS;
import org.emftext.sdk.concretesyntax.QUESTIONMARK;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.STAR;
import org.emftext.sdk.concretesyntax.Sequence;
import org.emftext.sdk.concretesyntax.Terminal;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResource;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.ECsProblemType;
import org.emftext.sdk.util.ConcreteSyntaxUtil;

/**
 * An analyser that checks whether the cardinality of a feature
 * matches the cardinality given in the syntax.
 */
public class FeatureCardinalityAnalyser extends AbstractPostProcessor {
	
	/**
	 * A helper class to hold information about the cardinality
	 * of a feature.
	 */
	private static class MinMax {
		private int min;
		private int max;
		public MinMax() {
		}
		public MinMax(int min, int max) {
			this.min = min;
			this.max = max;
		}
		public int getMin() {
			return min;
		}
		public void setMin(int min) {
			this.min = min;
		}
		public int getMax() {
			return max;
		}
		public void setMax(int max) {
			this.max = max;
		}
		public boolean enclosesMax(MinMax minMax) {
			if (max < 0) {
				return true;
			} else {
				if (minMax.getMax() < 0) {
					return false;
				} else  {
					return max >= minMax.getMax();
				}
			}
		}
		public String toString() {
			return min + ".." + max;
		}
	}

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
		Map<GenFeature, MinMax> featureToCountMap = new HashMap<GenFeature, MinMax>();
		countOccurences(choice, featureToCountMap);
		
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
				addProblem(resource, ECsProblemType.MAX_OCCURENCE_MISMATCH, "Maximum occurences ("+max+") of feature \"" + feature.getName() + "\" do not match upper bound (" + metaMinMax.getMax() + ").", rule);
			}
			int min = minMax.getMin();
			if (metaMinMax.getMin() != minMax.getMin()) {
				addProblem(resource, ECsProblemType.MIN_OCCURENCE_MISMATCH, "Minimum occurences ("+min+") of feature \"" + feature.getName() + "\" do not match lower bound (" + metaMinMax.getMin() + ").", rule);
			}
		}
	}

	private void countOccurences(Choice choice,
			Map<GenFeature, MinMax> featureToMinMaxMap) {

		List<Sequence> options = choice.getOptions();
		int optionCount = 0;
		for (Sequence sequence : options) {
			// next option
			Map<GenFeature, MinMax> newFeatureToCountMap;
			if (optionCount > 0) {
				newFeatureToCountMap = new HashMap<GenFeature, MinMax>();
			} else {
				newFeatureToCountMap = featureToMinMaxMap;
			}

			List<Definition> parts = sequence.getParts();
			for (Definition part : parts) {
				if (part instanceof Terminal) {
					Terminal terminal = (Terminal) part;
					GenFeature feature = terminal.getFeature();
					if (feature == ConcreteSyntaxUtil.ANONYMOUS_GEN_FEATURE) {
						continue;
					}
					MinMax currentMinMax = getTotalCardinality(terminal);
					MinMax previousMinMax = getMinMax(newFeatureToCountMap, feature);
					newFeatureToCountMap.put(feature, add(previousMinMax, currentMinMax));
				} else if (part instanceof CompoundDefinition) {
					CompoundDefinition compound = (CompoundDefinition) part;
					Choice subChoices = compound.getDefinition();
					countOccurences(subChoices, newFeatureToCountMap);
				}
			}
			if (optionCount > 0) {
				or(featureToMinMaxMap, newFeatureToCountMap);
			}
			optionCount++;
		}
	}

	private void or(Map<GenFeature, MinMax> oldFeatureToMinMaxMap,
			Map<GenFeature, MinMax> newFeatureToCountMap) {

		for (GenFeature oldFeature : oldFeatureToMinMaxMap.keySet()) {
			if (newFeatureToCountMap.containsKey(oldFeature)) {
				// feature is in both maps - do OR
				oldFeatureToMinMaxMap.put(oldFeature, or(oldFeatureToMinMaxMap.get(oldFeature), newFeatureToCountMap.get(oldFeature)));
			}
		}
		// copy new feature to old map
		for (GenFeature newFeature : newFeatureToCountMap.keySet()) {
			if (!oldFeatureToMinMaxMap.containsKey(newFeature)) {
				oldFeatureToMinMaxMap.put(newFeature, newFeatureToCountMap.get(newFeature));
			}
		}
	}

	private MinMax getMinMax(Map<GenFeature, MinMax> featureToMinMaxMap,
			GenFeature feature) {
		if (!featureToMinMaxMap.containsKey(feature)) {
			featureToMinMaxMap.put(feature, new MinMax());
		}
		return featureToMinMaxMap.get(feature);
	}

	private MinMax getTotalCardinality(Terminal terminal) {
		MinMax result = null;
		EObject current = terminal;
		while (current != null) {
			if (current instanceof CardinalityDefinition) {
				CardinalityDefinition cd = (CardinalityDefinition) current;
				Cardinality cardinality = cd.getCardinality();
				MinMax c = convertToMinMax(cardinality);
				result = multiply(result, c);
			}
			current = current.eContainer();
		}
		return result;
	}

	private MinMax multiply(MinMax inner, MinMax outer) {
		if (inner == null) {
			return outer;
		}
		int newMin;
		if (outer.min < 0) {
			newMin = -1;
		} else if (outer.min == 0) {
			newMin = 0;
		} else {
			newMin = outer.min * inner.min;
		}
		if (newMin < 0) {
			newMin = -1;
		}
		
		int newMax = 0;
		if (outer.max < 0) {
			newMax = -1;
		} else if (outer.max == 0) {
			assert false;
		} else {
			newMax = outer.max * inner.max;
		}
		if (newMax < 0) {
			newMax = -1;
		}
		
		return new MinMax(newMin, newMax);
	}

	private MinMax or(MinMax value1, MinMax value2) {
		MinMax result = new MinMax();
		result.setMin(orMin(value1.getMin(), value2.getMin()));
		result.setMax(orMax(value1.getMax(), value2.getMax()));
		return result;
	}

	private int orMax(int max1, int max2) {
		if (max1 < 0) {
			return max1;
		} else {
			if (max2 < 0) {
				return max2;
			} else {
				return Math.max(max1, max2);
			}
		}
	}

	private int orMin(int min1, int min2) {
		if (min1 < 0) {
			return min2;
		} else {
			if (min2 < 0) {
				return min1;
			} else {
				return Math.min(min1, min2);
			}
		}
	}

	private MinMax add(MinMax value1, MinMax value2) {
		MinMax result = new MinMax();
		result.setMin(add(value1.getMin(), value2.getMin()));
		result.setMax(add(value1.getMax(), value2.getMax()));
		return result;
	}
	
	private int add(int value1, int value2) {
		if (value1 < 0 || value2 < 0) {
			return -1;
		}
		return value1 + value2;
	}

	private MinMax convertToMinMax(Cardinality cardinality) {
		MinMax result = new MinMax();
		result.setMin(convertToMin(cardinality));
		result.setMax(convertToMax(cardinality));
		return result;
	}
	
	private int convertToMin(Cardinality cardinality) {
		if (cardinality == null) {
			return 1;
		}
		if (cardinality instanceof PLUS) {
			return 1;
		}
		if (cardinality instanceof STAR) {
			return 0;
		}
		if (cardinality instanceof QUESTIONMARK) {
			return 0;
		}
		// there should be no other subclasses of class 'Cardinality'
		assert false;
		return 0;
	}
	
	private int convertToMax(Cardinality cardinality) {
		if (cardinality == null) {
			return 1;
		}
		if (cardinality instanceof PLUS) {
			return -1;
		}
		if (cardinality instanceof STAR) {
			return -1;
		}
		if (cardinality instanceof QUESTIONMARK) {
			return 1;
		}
		// there should be no other subclasses of class 'Cardinality'
		assert false;
		return 0;
	}
}
