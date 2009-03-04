/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
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
