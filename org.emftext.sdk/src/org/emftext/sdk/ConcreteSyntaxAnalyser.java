package org.emftext.sdk;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.TokenDefinition;

public class ConcreteSyntaxAnalyser {

	public boolean isCollectInFeature(Rule rule, EStructuralFeature feature) {
		for (TokenDefinition tokenDefinition : rule.getSyntax().getTokens()) {
			final String attributeName = tokenDefinition.getAttributeName();
			final boolean isCollectToken = attributeName != null;
			if (!isCollectToken) {
				continue;
			}
			final boolean namesMatch = attributeName.equals(feature.getName());
			if (namesMatch) {
				return true;
			}
		}
		return false;
	}
}
