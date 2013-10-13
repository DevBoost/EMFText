/*******************************************************************************
 * Copyright (c) 2006-2013
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/

package org.emftext.sdk.concretesyntax.resource.cs.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ContextInformation;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;
import org.eclipse.swt.graphics.Image;

public class CsCompletionProcessor implements IContentAssistProcessor {
	
	private org.emftext.sdk.concretesyntax.resource.cs.ICsResourceProvider resourceProvider;
	
	public CsCompletionProcessor(org.emftext.sdk.concretesyntax.resource.cs.ICsResourceProvider resourceProvider) {
		super();
		this.resourceProvider = resourceProvider;
	}
	
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int offset) {
		org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource textResource = resourceProvider.getResource();
		if (textResource == null) {
			return new ICompletionProposal[0];
		}
		String content = viewer.getDocument().get();
		org.emftext.sdk.concretesyntax.resource.cs.ui.CsCodeCompletionHelper helper = new org.emftext.sdk.concretesyntax.resource.cs.ui.CsCodeCompletionHelper();
		org.emftext.sdk.concretesyntax.resource.cs.ui.CsCompletionProposal[] computedProposals = helper.computeCompletionProposals(textResource, content, offset);
		
		// call completion proposal post processor to allow for customizing the proposals
		org.emftext.sdk.concretesyntax.resource.cs.ui.CsProposalPostProcessor proposalPostProcessor = new org.emftext.sdk.concretesyntax.resource.cs.ui.CsProposalPostProcessor();
		List<org.emftext.sdk.concretesyntax.resource.cs.ui.CsCompletionProposal> computedProposalList = Arrays.asList(computedProposals);
		List<org.emftext.sdk.concretesyntax.resource.cs.ui.CsCompletionProposal> extendedProposalList = proposalPostProcessor.process(computedProposalList);
		if (extendedProposalList == null) {
			extendedProposalList = Collections.emptyList();
		}
		List<org.emftext.sdk.concretesyntax.resource.cs.ui.CsCompletionProposal> finalProposalList = new ArrayList<org.emftext.sdk.concretesyntax.resource.cs.ui.CsCompletionProposal>();
		for (org.emftext.sdk.concretesyntax.resource.cs.ui.CsCompletionProposal proposal : extendedProposalList) {
			if (proposal.isMatchesPrefix()) {
				finalProposalList.add(proposal);
			}
		}
		ICompletionProposal[] result = new ICompletionProposal[finalProposalList.size()];
		int i = 0;
		for (org.emftext.sdk.concretesyntax.resource.cs.ui.CsCompletionProposal proposal : finalProposalList) {
			String proposalString = proposal.getInsertString();
			String displayString = (proposal.getDisplayString()==null)?proposalString:proposal.getDisplayString();
			String prefix = proposal.getPrefix();
			Image image = proposal.getImage();
			IContextInformation info;
			info = new ContextInformation(image, displayString, proposalString);
			int begin = offset - prefix.length();
			int replacementLength = prefix.length();
			result[i++] = new CompletionProposal(proposalString, begin, replacementLength, proposalString.length(), image, displayString, info, proposalString);
		}
		return result;
	}
	
	public IContextInformation[] computeContextInformation(ITextViewer viewer, int offset) {
		return null;
	}
	
	public char[] getCompletionProposalAutoActivationCharacters() {
		return null;
	}
	
	public char[] getContextInformationAutoActivationCharacters() {
		return null;
	}
	
	public IContextInformationValidator getContextInformationValidator() {
		return null;
	}
	
	public String getErrorMessage() {
		return null;
	}
}
