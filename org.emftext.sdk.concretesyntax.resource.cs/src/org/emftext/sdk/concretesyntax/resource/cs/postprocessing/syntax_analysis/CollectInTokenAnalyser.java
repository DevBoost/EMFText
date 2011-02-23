/*******************************************************************************
 * Copyright (c) 2006-2011
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
package org.emftext.sdk.concretesyntax.resource.cs.postprocessing.syntax_analysis;

import java.util.Collection;

import org.emftext.sdk.concretesyntax.CompleteTokenDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.Placeholder;
import org.emftext.sdk.concretesyntax.ReferencableTokenDefinition;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsAnalysisProblemType;
import org.emftext.sdk.concretesyntax.resource.cs.postprocessing.AbstractPostProcessor;
import org.emftext.sdk.concretesyntax.resource.cs.util.CsEObjectUtil;

public class CollectInTokenAnalyser extends AbstractPostProcessor {

	private static final String COLLECT_IN_TOKEN_USED_IN_RULE_WARNING = 
		"Token %s will never be matched here, since it is a collect-in token.";
	
	@Override
	public void analyse(ConcreteSyntax syntax) {
		for (Rule rule : syntax.getAllRules()) {
			Collection<Placeholder> placeholders = CsEObjectUtil.getObjectsByType(rule.eAllContents(), ConcretesyntaxPackage.eINSTANCE.getPlaceholder());
			for (Placeholder placeholder : placeholders) {
				ReferencableTokenDefinition token = placeholder.getToken();
				if (token == null) {
					continue;
				}
				if (token instanceof CompleteTokenDefinition) {
					CompleteTokenDefinition completeDefinition = (CompleteTokenDefinition) token;
					if (completeDefinition.getAttributeName() != null) {
						addProblem(
								CsAnalysisProblemType.COLLECT_IN_TOKEN_USED_IN_RULE,
								String.format(COLLECT_IN_TOKEN_USED_IN_RULE_WARNING, token.getName()),
								placeholder);
					}
				}
			}
		}
	}

}
