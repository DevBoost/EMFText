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
package org.emftext.sdk.syntax_extension;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.EPredefinedTokens;
import org.emftext.sdk.OptionManager;
import org.emftext.sdk.concretesyntax.CompleteTokenDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.OptionTypes;
import org.emftext.sdk.concretesyntax.PlaceholderUsingDefaultToken;
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
				CompleteTokenDefinition definition = findToken(syntax, standardTokenName);
				if (definition == null) {
					addProblem(resource, ECsProblemType.DEFAULT_TOKEN_NOT_DEFINED, "There is no token definition for the default token \"" + standardTokenName + "\".", placeholder);
				} else {
					placeholder.setToken(definition);
				}
			}
		}
	}

	private CompleteTokenDefinition findToken(ConcreteSyntax syntax,
			String standardTokenName) {
		for (CompleteTokenDefinition next : syntax.getActiveTokens()) {
			if (standardTokenName.equals(next.getName())) {
				return next;
			}
		}
		return null;
	}
}
