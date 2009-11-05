/*******************************************************************************
 * Copyright (c) 2006-2009
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * Software Technology Group - TU Dresden, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.concretesyntax.resource.cs.ui;

public class CsCompletionProcessor implements org.eclipse.jface.text.contentassist.IContentAssistProcessor {
	
	private org.emftext.sdk.concretesyntax.resource.cs.ui.CsEditor editor;
	
	public CsCompletionProcessor(org.emftext.sdk.concretesyntax.resource.cs.ui.CsEditor editor) {
		this.editor = editor;
	}
	
	public org.eclipse.jface.text.contentassist.ICompletionProposal[] computeCompletionProposals(org.eclipse.jface.text.ITextViewer viewer, int offset) {
		
		org.eclipse.emf.ecore.resource.Resource resource = editor.getResource();
		org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource textResource = (org.emftext.sdk.concretesyntax.resource.cs.ICsTextResource) resource;
		String content = viewer.getDocument().get();
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsCodeCompletionHelper helper = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsCodeCompletionHelper();
		java.util.Collection<String> proposals = helper.computeCompletionProposals(textResource.getMetaInformation(), content, offset);
		
		org.eclipse.jface.text.contentassist.ICompletionProposal[] result = new org.eclipse.jface.text.contentassist.ICompletionProposal[proposals.size()];
		int i = 0;
		for (String proposal : proposals) {
			org.eclipse.jface.text.contentassist.IContextInformation info = new org.eclipse.jface.text.contentassist.ContextInformation(proposal, proposal);
			String contentBefore = content.substring(0, offset);
			String insertString = org.emftext.sdk.concretesyntax.resource.cs.util.CsStringUtil.getMissingTail(contentBefore, proposal);
			result[i++] = new org.eclipse.jface.text.contentassist.CompletionProposal(insertString, offset, 0, insertString.length(), null, proposal, info, proposal);
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
