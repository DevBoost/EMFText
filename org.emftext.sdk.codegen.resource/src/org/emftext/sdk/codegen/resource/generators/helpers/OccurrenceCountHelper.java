package org.emftext.sdk.codegen.resource.generators.helpers;

import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.emftext.sdk.concretesyntax.Cardinality;
import org.emftext.sdk.concretesyntax.CardinalityDefinition;
import org.emftext.sdk.concretesyntax.Choice;
import org.emftext.sdk.concretesyntax.QUESTIONMARK;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.STAR;
import org.emftext.sdk.concretesyntax.SyntaxElement;
import org.emftext.sdk.concretesyntax.Terminal;

/**
 * A helper class to computer the mandatory occurrences of feature in syntax
 * rules.
 */
public class OccurrenceCountHelper {

	public int getMandatoryOccurencesAfter(SyntaxElement syntaxElement, GenFeature feature) {
		Rule rule = syntaxElement.getContainingRule();
		int count = getMandatoryOccurencesAfter(rule, syntaxElement, feature, -1, true);
		return count < 0 ? 0 : count;
	}

	private int getMandatoryOccurencesAfter(SyntaxElement syntaxElement, SyntaxElement startAt, GenFeature feature, int count, boolean mandatory) {
		boolean isMandatory = mandatory && isMandatory(syntaxElement);
		if (syntaxElement instanceof Terminal) {
			Terminal terminal = (Terminal) syntaxElement;
			if (terminal.getFeature() == feature) {
				if (count >= 0 && isMandatory) {
					count++;
				}
			}
		}
		// check children
		for (SyntaxElement child : syntaxElement.getChildren()) {
			int childCount = getMandatoryOccurencesAfter(child, startAt, feature, count, isMandatory);
			if (childCount < 0) {
				// feature was not found yet
			} else {
				if (childCount == 0) {
					count = 0;
				} else {
					if (count < 0) {
						count = 0;
					}
					if (isMandatory) {
						count += childCount;
					}
				}
			}
			if (syntaxElement instanceof Choice) {
				break;
			}
		}
		if (startAt == syntaxElement) {
			count = 0;
		}
		return count;
	}

	private boolean isMandatory(SyntaxElement element) {
		if (element instanceof CardinalityDefinition) {
			CardinalityDefinition cd = (CardinalityDefinition) element;
			Cardinality cardinality = cd.getCardinality();
			if (cardinality instanceof STAR || cardinality instanceof QUESTIONMARK) {
				return false;
			}
		}
		return true;
	}
}
