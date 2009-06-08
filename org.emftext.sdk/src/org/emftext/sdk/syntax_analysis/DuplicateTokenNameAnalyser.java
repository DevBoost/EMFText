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
package org.emftext.sdk.syntax_analysis;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.TokenDefinition;

/**
 * An analyser that checks that each token name is used at most once.
 */
public class DuplicateTokenNameAnalyser extends AbstractPostProcessor {

	public void analyse(ITextResource resource, ConcreteSyntax syntax) {
		List<TokenDefinition> duplicateDefinitions = getDuplicateTokenDefinitions(syntax);
		for (TokenDefinition duplicate : duplicateDefinitions) {
			resource.addError("Duplicate token name " + duplicate.getName() + " (names are not case sensitive).", duplicate);
		}
	}

	public List<TokenDefinition> getDuplicateTokenDefinitions(ConcreteSyntax syntax) {
		List<TokenDefinition> duplicateTokens = new ArrayList<TokenDefinition>();
		
		List<String> foundTokenNames = new ArrayList<String>();
		EList<TokenDefinition> tokens = syntax.getActiveTokens();
		for (int i = 0; i < tokens.size(); i++) {
			TokenDefinition token_i = tokens.get(i);
			String token_i_name = token_i.getName();
			if (foundTokenNames.contains(token_i_name.toLowerCase())) {
				continue;
			}
			
			foundTokenNames.add(token_i_name.toLowerCase());
			
			boolean foundDuplicate = false;
			// name was not found before
			for (int j = i + 1; j < tokens.size(); j++) {
				TokenDefinition token_j = tokens.get(j);
				if (token_j.getName().equalsIgnoreCase(token_i_name)) {
					duplicateTokens.add(token_j);
					foundDuplicate = true;
				}
			}
			if (foundDuplicate) {
				duplicateTokens.add(token_i);
			}
		}
		return duplicateTokens;
	}
}
