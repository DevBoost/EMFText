/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
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
import org.emftext.runtime.resource.impl.code_completion.CodeCompletionHelper;
import org.emftext.runtime.ui.editor.EMFTextEditor;
import org.emftext.runtime.util.StringUtil;

public class EMFTextEditorCompletionProcessor implements IContentAssistProcessor {

	private EMFTextEditor editor;

	public EMFTextEditorCompletionProcessor(EMFTextEditor editor) {
		this.editor = editor;
	}

	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int offset) {

		Resource resource = editor.getResource();
		ITextResource textResource = (ITextResource) resource;
		String content = viewer.getDocument().get();
		CodeCompletionHelper helper = new CodeCompletionHelper();
		Collection<String> proposals = helper.computeCompletionProposals(textResource.getMetaInformation(), content, offset);
		
		ICompletionProposal[] result = new ICompletionProposal[proposals.size()];
		int i = 0;
		for (String proposal : proposals) {
			IContextInformation info = new ContextInformation(proposal, proposal);
			String contentBefore = content.substring(0, offset);
			String insertString = StringUtil.getMissingTail(contentBefore, proposal);
			result[i++] = new CompletionProposal(insertString, offset, 0, insertString.length(), null, proposal, info, proposal);
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
