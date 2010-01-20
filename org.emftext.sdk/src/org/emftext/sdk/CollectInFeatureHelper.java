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
package org.emftext.sdk;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Import;
import org.emftext.sdk.concretesyntax.CompleteTokenDefinition;

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
		for (CompleteTokenDefinition tokenDefinition : syntax.getActiveTokens()) {
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
