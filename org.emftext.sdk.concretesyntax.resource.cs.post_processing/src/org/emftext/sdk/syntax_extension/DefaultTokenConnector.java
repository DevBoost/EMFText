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
package org.emftext.sdk.syntax_extension;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.codegen.EPredefinedTokens;
import org.emftext.sdk.codegen.OptionManager;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.OptionTypes;
import org.emftext.sdk.concretesyntax.PlaceholderUsingDefaultToken;
import org.emftext.sdk.concretesyntax.TokenDefinition;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResource;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.ECsProblemType;

/**
 * The DefaultTokenConnector looks for PlaceholderUsingDefaultToken. 
 * For each PlaceholderUsingDefaultToken that is found in the resource, 
 * the 'token' reference is set.
 */
public class DefaultTokenConnector extends AbstractPostProcessor {

	@Override
	public void analyse(CsResource resource, ConcreteSyntax syntax) {
		String standardTokenName = OptionManager.INSTANCE.getStringOptionValue(syntax, OptionTypes.DEFAULT_TOKEN_NAME);
		if (standardTokenName == null) {
			standardTokenName = EPredefinedTokens.STANDARD.getTokenName();
		}
		
		TreeIterator<EObject> allObjectsIterator = syntax.eAllContents();
		while (allObjectsIterator.hasNext()) {
			EObject next = allObjectsIterator.next();
			if (next instanceof PlaceholderUsingDefaultToken) {
				PlaceholderUsingDefaultToken placeholder = (PlaceholderUsingDefaultToken) next;
				// this placeholder must use the standard token
				TokenDefinition definition = findToken(syntax, standardTokenName);
				if (definition == null) {
					addProblem(resource, ECsProblemType.DEFAULT_TOKEN_NOT_DEFINED, "There is no token definition for the default token \"" + standardTokenName + "\".", placeholder);
				} else {
					placeholder.setToken(definition);
				}
			}
		}
	}

	private TokenDefinition findToken(ConcreteSyntax syntax,
			String standardTokenName) {
		for (TokenDefinition next : syntax.getActiveTokens()) {
			if (standardTokenName.equals(next.getName())) {
				return next;
			}
		}
		return null;
	}
}
