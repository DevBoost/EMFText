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
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.OptionManager;
import org.emftext.sdk.concretesyntax.CompleteTokenDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.CsString;
import org.emftext.sdk.concretesyntax.NormalTokenDefinition;
import org.emftext.sdk.concretesyntax.OptionTypes;
import org.emftext.sdk.concretesyntax.resource.cs.ICsQuickFix;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.ECsProblemType;
import org.emftext.sdk.quickfixes.AddSuppressWarningsAnnotationQuickFix;
import org.emftext.sdk.quickfixes.RemoveElementQuickFix;

/**
 * The HiddenTokenAnalyser searches for unused token definitions
 * in a syntax and adds a warning for each unused definition.
 */
public class UnusedTokenAnalyser extends AbstractPostProcessor {

	@Override
	public void analyse(ConcreteSyntax syntax) {
		boolean useClassicPrinter = OptionManager.INSTANCE.getBooleanOptionValue(syntax, OptionTypes.USE_CLASSIC_PRINTER);
		if (!useClassicPrinter) {
			// the modern printer (printer2) does not discard unused tokens.
			// therefore we do not need to emit warnings in this case.
			return;
		}
		List<CompleteTokenDefinition> activeTokens = syntax.getActiveTokens();
		TreeIterator<EObject> allContents = syntax.eAllContents();
		List<String> keywordTokens = new ArrayList<String>();
		while (allContents.hasNext()) {
			EObject object = (EObject) allContents.next();
			if (object instanceof CsString) {
				CsString s = (CsString) object;
				keywordTokens.add(s.getValue());
			}
		}
		for (CompleteTokenDefinition definition : activeTokens) {
			if (!(definition instanceof NormalTokenDefinition)) {
				continue;
			}
			NormalTokenDefinition normalToken = (NormalTokenDefinition) definition;
			String regex = definition.getRegex();
			if (regex.length() < 2) {
				continue;
			}
			String assumeKeyword = regex.substring(1, regex.length() - 1);
			
			if (!definition.isUsed() && !keywordTokens.contains(assumeKeyword)) {
				ECsProblemType problemType = ECsProblemType.UNUSED_TOKEN;
				// create quick fixes
				Collection<ICsQuickFix> quickFixes = new ArrayList<ICsQuickFix>(2);
				quickFixes.add(new RemoveElementQuickFix("Remove token definition.", definition));
				quickFixes.add(new AddSuppressWarningsAnnotationQuickFix(normalToken, problemType));
				// add warnings
				addProblem(
						problemType, 
						"Token " + definition.getName() + " is not used and will be discarded during parsing.", 
						definition,
						quickFixes
				);
			}
		}
	}
}
