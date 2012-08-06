/*******************************************************************************
 * Copyright (c) 2006-2012
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
package org.emftext.sdk.generatorconfig.resource.generatorconfig.ui;

public class GeneratorconfigCompletionProcessor implements org.eclipse.jface.text.contentassist.IContentAssistProcessor {

	private org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigEditor editor;

	public GeneratorconfigCompletionProcessor(org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigEditor editor) {
		this.editor = editor;
	}

	public org.eclipse.jface.text.contentassist.ICompletionProposal[] computeCompletionProposals(org.eclipse.jface.text.ITextViewer viewer, int offset) {

		org.eclipse.emf.ecore.resource.Resource resource = editor.getResource();
		org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTextResource textResource = (org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigTextResource) resource;
		String content = viewer.getDocument().get();
		org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigCodeCompletionHelper helper = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigCodeCompletionHelper();
		org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigCompletionProposal[] proposals = helper.computeCompletionProposals(textResource, content, offset);

		org.eclipse.jface.text.contentassist.ICompletionProposal[] result = new org.eclipse.jface.text.contentassist.ICompletionProposal[proposals.length];
		int i = 0;
		for (org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigCompletionProposal proposal : proposals) {
			String proposalString = proposal.getInsertString();
			String prefix = proposal.getPrefix();
			org.eclipse.jface.text.contentassist.IContextInformation info = new org.eclipse.jface.text.contentassist.ContextInformation(proposalString, proposalString);
			int begin = offset - prefix.length();
			result[i++] = new org.eclipse.jface.text.contentassist.CompletionProposal(proposalString, begin, prefix.length(), proposalString.length(), null, proposalString, info, proposalString);
		}
		return result;
	}

	public org.eclipse.jface.text.contentassist.IContextInformation[] computeContextInformation(org.eclipse.jface.text.ITextViewer viewer, int offset) {
		return null;
	}

	public char[] getCompletionProposalAutoActivationCharacters() {
		return null;
	}

	public char[] getContextInformationAutoActivationCharacters() {
		return null;
	}

	public org.eclipse.jface.text.contentassist.IContextInformationValidator getContextInformationValidator() {
		return null;
	}

	public String getErrorMessage() {
		return null;
	}
}
