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

import org.emftext.runtime.resource.ITextResource;
import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.TokenStyle;

/**
 * An analyser that checks whether multiple token styles refer to the
 * same token. If duplicate definitions are found a warning is added to
 * the CS resource.
 */
public class DuplicateTokenStyleAnalyser extends AbstractPostProcessor {

	@Override
	public void analyse(ITextResource resource, ConcreteSyntax syntax) {
		List<String> tokenNames = new ArrayList<String>();
		List<TokenStyle> duplicates = new ArrayList<TokenStyle>();
		
		// search for duplicate
		List<TokenStyle> allTokenStyles = syntax.getAllTokenStyles();
		for (TokenStyle nextStyle : allTokenStyles) {
			String nextName = nextStyle.getTokenName();
			if (tokenNames.contains(nextName)) {
				// found duplicate
				duplicates.add(nextStyle);
			} else {
				tokenNames.add(nextName);
			}
		}
		
		// add warnings
		for (TokenStyle nextDuplicate : duplicates) {
			resource.addWarning("Style for \"" + nextDuplicate.getTokenName() + "\" is already defined (potentially in imported syntax).", nextDuplicate);
		}
	}
}
