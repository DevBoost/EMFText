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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.EPredefinedTokens;
import org.emftext.sdk.OptionManager;
import org.emftext.sdk.concretesyntax.AtomicRegex;
import org.emftext.sdk.concretesyntax.CompleteTokenDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxFactory;
import org.emftext.sdk.concretesyntax.NormalTokenDefinition;
import org.emftext.sdk.concretesyntax.OptionTypes;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResource;

/**
 * The PreDefinedTokenAdder adds all predefined tokens to the syntax
 * unless the option to disable the usage of predefined tokens was set.
 */
public class PredefinedTokenAdder extends AbstractPostProcessor {

	/**
	 * We override process() because we do not want to resolve all proxies before
	 * running this processor.
	 */
	@Override
	public void process(CsResource resource) {
		EList<EObject> objects = resource.getContents();
		for (EObject next : objects) {
			if (next instanceof ConcreteSyntax) {
				analyse(resource, (ConcreteSyntax) next);
			}
		}
	}
	
	public void analyse(CsResource resource, ConcreteSyntax syntax) {
		boolean usePredefinedTokens = OptionManager.INSTANCE.getBooleanOptionValue(syntax, OptionTypes.USE_PREDEFINED_TOKENS);
		if (!usePredefinedTokens) {
			return;
		}
		
		for (EPredefinedTokens predefinedToken : EPredefinedTokens.values()) {
			// first look whether there is a PreDefinedToken
			boolean found = searchForPredefinedTokenDeclaration(syntax, predefinedToken);
			if (found) {
				continue;
			}
			
			// if not create one and add it to the end of the token list
			NormalTokenDefinition definition = ConcretesyntaxFactory.eINSTANCE.createNormalTokenDefinition();
			definition.setName(predefinedToken.getTokenName());
			
			AtomicRegex regex = ConcretesyntaxFactory.eINSTANCE.createAtomicRegex();
			regex.setAtomicExpression(predefinedToken.getExpression());
			definition.getRegexParts().add(regex);
			syntax.getSyntheticTokens().add(definition);
		}
	}

	private boolean searchForPredefinedTokenDeclaration(ConcreteSyntax syntax,
			EPredefinedTokens predefinedToken) {
		for (CompleteTokenDefinition next : syntax.getActiveTokens()) {
			if (predefinedToken.getTokenName().equals(next.getName())) {
				// found a declaration for the predefined token
				return true;
			}
		}
		return false;
	}

	protected boolean doResolveProxiesBeforeAnalysis() {
		return false;
	}
}
