package org.emftext.sdk;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.ecore.EObject;
import org.emftext.sdk.concretesyntax.Cardinality;
import org.emftext.sdk.concretesyntax.CardinalityDefinition;
import org.emftext.sdk.concretesyntax.Choice;
import org.emftext.sdk.concretesyntax.CompoundDefinition;
import org.emftext.sdk.concretesyntax.Definition;
import org.emftext.sdk.concretesyntax.PLUS;
import org.emftext.sdk.concretesyntax.QUESTIONMARK;
import org.emftext.sdk.concretesyntax.STAR;
import org.emftext.sdk.concretesyntax.Sequence;
import org.emftext.sdk.concretesyntax.SyntaxElement;
import org.emftext.sdk.concretesyntax.Terminal;
import org.emftext.sdk.util.ConcreteSyntaxUtil;

public class CardinalityComputer {

	/**
	 * Counts the min/max occurrences of all features that are referenced by terminal
	 * in the given syntax tree. The occurrences are computed as follows:
	 * 
	 * - Mandatory occurrences do have cardinality 1..1
	 * - Optional (?) occurrences do have cardinality 0..1
	 * - Unbound (*) occurrences do have cardinality 0..*
	 * - Mandatory Unbound (+) occurrences do have cardinality 1..*
	 * 
	 * - For sequences the min/max values are added pairwise
	 * - For alternatives the minimum of the min and the maximum of the max values is returned
	 * - For compounds the min/max values are multiplied
	 * 
	 * @param choice the root of the syntax tree
	 * @param featureToMinMaxMap a map which maps features to their min/max occurrences
	 */
	public void countOccurences(Choice choice, Map<GenFeature, MinMax> featureToMinMaxMap) {

		List<Sequence> options = choice.getOptions();
		int optionCount = 0;
		for (Sequence sequence : options) {
			// next option
			Map<GenFeature, MinMax> newFeatureToCountMap;
			
			// for the first options we use the feature map that was
			// given as a parameter. for all other, we use a fresh
			// map, which is merged with the previous map at the end
			// of each loop iteration
			if (optionCount > 0) {
				newFeatureToCountMap = new LinkedHashMap<GenFeature, MinMax>();
			} else {
				newFeatureToCountMap = featureToMinMaxMap;
			}

			List<Definition> parts = sequence.getParts();
			for (Definition part : parts) {
				if (part instanceof Terminal) {
					Terminal terminal = (Terminal) part;
					GenFeature feature = terminal.getFeature();
					// ignore anonymous features
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
			// merge the min/max values found for the current option with 
			// the previous options
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

		
	public MinMax getTotalCardinality(Terminal terminal) {
		return getTotalCardinality(terminal, null);
	}
	
	public MinMax getTotalCardinality(SyntaxElement element, SyntaxElement stopAt) {
		MinMax result = null;
		EObject current = element;
		while (current != stopAt) {
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
		if (outer.getMin() < 0) {
			newMin = -1;
		} else if (outer.getMin() == 0) {
			newMin = 0;
		} else {
			newMin = outer.getMin() * inner.getMin();
		}
		if (newMin < 0) {
			newMin = -1;
		}
		
		int newMax = 0;
		if (outer.getMax() < 0) {
			newMax = -1;
		} else if (outer.getMax() == 0) {
			assert false;
		} else {
			newMax = outer.getMax() * inner.getMax();
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
