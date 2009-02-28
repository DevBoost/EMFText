package org.emftext.sdk.analysis;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Import;
import org.emftext.sdk.concretesyntax.TokenDefinition;

/**
 * A class that can be used to analyse collect-in features. This class
 * is required by the code generation of post-processors.
 */
public class CollectInFeatureHelper {
	
	/**
	 * Checks whether the given feature is defined as a collect-in
	 * feature. Note that the feature may also be defined as collect-in
	 * token in imported syntaxes. 
	 * 
	 * @see DefinedPlaceholderTokenReferenceResolver
	 * 
	 * @param feature the feature to check
	 * @param syntax the syntax containing the reference to the feature
	 * 
	 * @return true if the feature is a collect-in feature
	 */
	public boolean isCollectInFeature(ConcreteSyntax syntax, EStructuralFeature feature) {
		for (Import importElement : syntax.getImports()) {
			ConcreteSyntax importedSyntax = importElement.getConcreteSyntax();
			if (importedSyntax == null) {
				continue;
			}
			boolean isCollectInInImport = isCollectInFeatureWithoutImports(importedSyntax, feature);
			if (isCollectInInImport) {
				return true;
			}
		}
		return isCollectInFeatureWithoutImports(syntax, feature);
	}

	private boolean isCollectInFeatureWithoutImports(ConcreteSyntax syntax, EStructuralFeature feature) {
		for (TokenDefinition tokenDefinition : syntax.getTokens()) {
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
