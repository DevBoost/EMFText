package org.emftext.runtime.ui;

import java.util.Collection;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ContextInformation;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.resource.impl.CodeCompletionHelper;
import org.emftext.runtime.ui.editor.EMFTextEditor;
import org.emftext.runtime.util.StringUtil;

public class EMFTextEditorCompletionProcessor2 implements
	IContentAssistProcessor {

	private EMFTextEditor editor;

	public EMFTextEditorCompletionProcessor2(EMFTextEditor editor) {
		this.editor = editor;
	}

	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer,
			int offset) {

		Resource resource = editor.getResource();
		ITextResource textResource = (ITextResource) resource;
		String content = viewer.getDocument().get();
		CodeCompletionHelper helper = new CodeCompletionHelper();
		Collection<String> proposals = helper.computeCompletionProposals(textResource.getMetaInformation(), content, offset);
		
		ICompletionProposal[] result = new ICompletionProposal[proposals.size()];
		int i = 0;
		for (String proposal : proposals) {
			IContextInformation info = new ContextInformation(proposal,
					proposal);
			String contentBefore = content.substring(0, offset);
			String insertString = StringUtil.getMissingTail(contentBefore, proposal);
			result[i++] = new CompletionProposal(insertString, offset,
					0, insertString.length(), null, proposal, info,
					proposal);
		}
		return result;
	}

	public IContextInformation[] computeContextInformation(ITextViewer viewer,
			int offset) {
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
