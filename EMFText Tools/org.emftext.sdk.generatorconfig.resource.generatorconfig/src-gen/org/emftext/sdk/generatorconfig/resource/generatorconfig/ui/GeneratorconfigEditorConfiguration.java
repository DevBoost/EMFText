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

// This class provides the configuration for the generated editor. It registers
// content assistance and syntax highlighting.
public class GeneratorconfigEditorConfiguration extends org.eclipse.jface.text.source.SourceViewerConfiguration {

	private org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigColorManager colorManager;
	private org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigEditor theEditor;

	// Create a new editor configuration.
	//
	// @param editor
	// @param colorManager
	///
	public GeneratorconfigEditorConfiguration(org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigEditor editor, org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigColorManager colorManager) {
		this.theEditor = editor;
		this.colorManager = colorManager;
	}

	public org.eclipse.jface.text.contentassist.IContentAssistant getContentAssistant(org.eclipse.jface.text.source.ISourceViewer sourceViewer) {

		org.eclipse.jface.text.contentassist.ContentAssistant assistant = new org.eclipse.jface.text.contentassist.ContentAssistant();
		assistant.setContentAssistProcessor(new org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigCompletionProcessor(theEditor), org.eclipse.jface.text.IDocument.DEFAULT_CONTENT_TYPE);
		assistant.enableAutoActivation(true);
		assistant.setAutoActivationDelay(500);
		assistant.setProposalPopupOrientation(org.eclipse.jface.text.contentassist.IContentAssistant.PROPOSAL_OVERLAY);
		assistant.setContextInformationPopupOrientation(org.eclipse.jface.text.contentassist.IContentAssistant.CONTEXT_INFO_ABOVE);

		return assistant;
	}

	public String[] getConfiguredContentTypes(org.eclipse.jface.text.source.ISourceViewer sourceViewer) {
		return new String[] {
			org.eclipse.jface.text.IDocument.DEFAULT_CONTENT_TYPE,
		};
	}

	// @param fileExtension
	// @return
	protected org.eclipse.jface.text.rules.ITokenScanner getScanner(String fileName) {
		return new org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigTokenScanner(colorManager);
	}

	public org.eclipse.jface.text.presentation.IPresentationReconciler getPresentationReconciler(org.eclipse.jface.text.source.ISourceViewer sourceViewer) {

		org.eclipse.jface.text.presentation.PresentationReconciler reconciler = new org.eclipse.jface.text.presentation.PresentationReconciler();
		String fileName = theEditor.getEditorInput().getName();

		org.eclipse.jface.text.rules.DefaultDamagerRepairer repairer = new org.eclipse.jface.text.rules.DefaultDamagerRepairer(getScanner(fileName));
		reconciler.setDamager(repairer, org.eclipse.jface.text.IDocument.DEFAULT_CONTENT_TYPE);
		reconciler.setRepairer(repairer, org.eclipse.jface.text.IDocument.DEFAULT_CONTENT_TYPE);

		return reconciler;
	}

	public org.eclipse.jface.text.source.IAnnotationHover getAnnotationHover(org.eclipse.jface.text.source.ISourceViewer sourceViewer) {
		return new org.eclipse.jface.text.source.DefaultAnnotationHover();
	}

	public org.eclipse.jface.text.ITextHover getTextHover(org.eclipse.jface.text.source.ISourceViewer sourceViewer, String contentType) {
		return new org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigTextHover(theEditor);
	}

	public org.eclipse.jface.text.hyperlink.IHyperlinkDetector[] getHyperlinkDetectors(org.eclipse.jface.text.source.ISourceViewer sourceViewer) {
		if (sourceViewer == null) {
			return null;
		}
		return new org.eclipse.jface.text.hyperlink.IHyperlinkDetector[] { new org.emftext.sdk.generatorconfig.resource.generatorconfig.ui.GeneratorconfigHyperlinkDetector(theEditor.getResource()) };
	}

}
