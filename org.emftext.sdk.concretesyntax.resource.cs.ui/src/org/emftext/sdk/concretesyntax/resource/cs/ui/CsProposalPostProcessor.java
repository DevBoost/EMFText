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

package org.emftext.sdk.concretesyntax.resource.cs.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.sdk.OptionManager;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.Option;
import org.emftext.sdk.concretesyntax.OptionTypes;

/**
 * A class which can be overridden to customize code completion proposals.
 */
public class CsProposalPostProcessor {
	
	public CsCompletionProposal[] process(CsCompletionProposal[] proposals) {
		List<CsCompletionProposal> newProposals = new ArrayList<CsCompletionProposal>();
		// change proposal for boolean options from "someValue" to "true"
		for (int i = 0; i < proposals.length; i++) {
			CsCompletionProposal proposal = proposals[i];
			newProposals.add(proposal);
			EStructuralFeature feature = proposal.getStructuralFeature();
			EObject container = proposal.getContainer();
			if (ConcretesyntaxPackage.eINSTANCE.getOption_Value() == feature) {
				if (container instanceof Option) {
					Option option = (Option) container;
					OptionTypes type = option.getType();
					if (OptionManager.INSTANCE.getBooleanOptions().contains(type)) {
						newProposals.remove(newProposals.size() - 1);
						newProposals.add(new CsCompletionProposal(
								"\"true\"",
								proposal.getPrefix(), 
								proposal.getStartsWithPrefix(), 
								feature, 
								container 
						));
						newProposals.add(new CsCompletionProposal(
								"\"false\"",
								proposal.getPrefix(), 
								proposal.getStartsWithPrefix(), 
								feature, 
								container 
						));
					}
				}
			} else if (ConcretesyntaxPackage.eINSTANCE.getCsString_Value() == feature) {
				newProposals.remove(newProposals.size() - 1);
				newProposals.add(new CsCompletionProposal(
						"\"keyword\"",
						proposal.getPrefix(), 
						proposal.getStartsWithPrefix(), 
						feature, 
						container 
				));
			}
		}
		return newProposals.toArray(new CsCompletionProposal[newProposals.size()]);
	}
}
