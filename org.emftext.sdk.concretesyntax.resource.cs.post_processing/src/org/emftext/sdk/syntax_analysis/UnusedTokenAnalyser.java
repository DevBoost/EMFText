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
package org.emftext.sdk.syntax_analysis;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.CsString;
import org.emftext.sdk.concretesyntax.TokenDefinition;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResource;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.ECsProblemType;

/**
 * The HiddenTokenAnalyser searches for unused token definitions
 * in a syntax and adds a warning for each unused definition.
 */
public class UnusedTokenAnalyser extends AbstractPostProcessor {

	@Override
	public void analyse(CsResource resource, ConcreteSyntax syntax) {
		List<TokenDefinition> activeTokens = syntax.getActiveTokens();
		TreeIterator<EObject> allContents = syntax.eAllContents();
		List<String> keywordTokens = new ArrayList<String>();
		while (allContents.hasNext()) {
			EObject object = (EObject) allContents.next();
			if (object instanceof CsString) {
				CsString s = (CsString) object;
				keywordTokens.add(s.getValue());
			}
		}
		for (TokenDefinition definition : activeTokens) {
			String regex = definition.getRegex();
			if (regex.length() < 2) {
				continue;
			}
			String assumeKeyword = regex.substring(1, regex.length() - 1);
			
			if (!definition.isUsed() && !keywordTokens.contains(assumeKeyword)) {
				addProblem(resource, ECsProblemType.UNUSED_TOKEN, "Token " + definition.getName() + " is not used and will be discarded during parsing.", definition);
			}
		}
	}
}
