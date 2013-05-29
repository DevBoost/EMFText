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

/**
 * This class provides the configuration for the generated editor. It registers
 * content assistance and syntax highlighting.
 */
public class CsSourceViewerConfiguration extends org.eclipse.ui.editors.text.TextSourceViewerConfiguration {
	
	private org.emftext.sdk.concretesyntax.resource.cs.ui.CsColorManager colorManager;
	private org.emftext.sdk.concretesyntax.resource.cs.ICsResourceProvider resourceProvider;
	private org.emftext.sdk.concretesyntax.resource.cs.ui.ICsAnnotationModelProvider annotationModelProvider;
	private org.emftext.sdk.concretesyntax.resource.cs.ui.CsQuickAssistAssistant quickAssistAssistant;
	
	/**
	 * Creates a new editor configuration.
	 * 
	 * @param resourceProvider the provider for the resource (usually this is the
	 * editor)
	 * @param colorManager the color manager to use
	 */
	public CsSourceViewerConfiguration(org.emftext.sdk.concretesyntax.resource.cs.ICsResourceProvider resourceProvider, org.emftext.sdk.concretesyntax.resource.cs.ui.ICsAnnotationModelProvider annotationModelProvider, org.emftext.sdk.concretesyntax.resource.cs.ui.CsColorManager colorManager) {
		super(org.emftext.sdk.concretesyntax.resource.cs.ui.CsUIPlugin.getDefault().getPreferenceStore());
		this.fPreferenceStore.setDefault(org.eclipse.ui.texteditor.spelling.SpellingService.PREFERENCE_SPELLING_ENABLED, true);
		this.fPreferenceStore.setDefault(org.eclipse.ui.texteditor.AbstractDecoratedTextEditorPreferenceConstants.EDITOR_TAB_WIDTH, 4);
		this.fPreferenceStore.setDefault(org.eclipse.ui.texteditor.AbstractDecoratedTextEditorPreferenceConstants.EDITOR_HYPERLINK_KEY_MODIFIER, org.eclipse.jface.action.Action.findModifierString(org.eclipse.swt.SWT.MOD1));
		this.resourceProvider = resourceProvider;
		this.annotationModelProvider = annotationModelProvider;
		this.colorManager = colorManager;
	}
	
	/**
	 * Returns an instance of class
	 * org.emftext.sdk.concretesyntax.resource.cs.ui.CsAutoEditStrategy.
	 */
	public org.eclipse.jface.text.IAutoEditStrategy[] getAutoEditStrategies(org.eclipse.jface.text.source.ISourceViewer sourceViewer, String contentType) {
		return new org.eclipse.jface.text.IAutoEditStrategy[] {new org.emftext.sdk.concretesyntax.resource.cs.ui.CsAutoEditStrategy()};
	}
	
	public org.eclipse.jface.text.contentassist.IContentAssistant getContentAssistant(org.eclipse.jface.text.source.ISourceViewer sourceViewer) {
		
		org.eclipse.jface.text.contentassist.ContentAssistant assistant = new org.eclipse.jface.text.contentassist.ContentAssistant();
		assistant.setContentAssistProcessor(new org.emftext.sdk.concretesyntax.resource.cs.ui.CsCompletionProcessor(resourceProvider), org.eclipse.jface.text.IDocument.DEFAULT_CONTENT_TYPE);
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
	
	protected org.eclipse.jface.text.rules.ITokenScanner getScanner() {
		return new org.emftext.sdk.concretesyntax.resource.cs.ui.CsUIMetaInformation().createTokenScanner(resourceProvider.getResource(), colorManager);
	}
	
	public org.eclipse.jface.text.presentation.IPresentationReconciler getPresentationReconciler(org.eclipse.jface.text.source.ISourceViewer sourceViewer) {
		
		org.eclipse.jface.text.presentation.PresentationReconciler reconciler = new org.eclipse.jface.text.presentation.PresentationReconciler();
		org.eclipse.jface.text.rules.DefaultDamagerRepairer repairer = new org.eclipse.jface.text.rules.DefaultDamagerRepairer(getScanner());
		reconciler.setDamager(repairer, org.eclipse.jface.text.IDocument.DEFAULT_CONTENT_TYPE);
		reconciler.setRepairer(repairer, org.eclipse.jface.text.IDocument.DEFAULT_CONTENT_TYPE);
		
		return reconciler;
	}
	
	public org.eclipse.jface.text.source.IAnnotationHover getAnnotationHover(org.eclipse.jface.text.source.ISourceViewer sourceViewer) {
		return new org.eclipse.jface.text.source.DefaultAnnotationHover();
	}
	
	public org.eclipse.jface.text.ITextHover getTextHover(org.eclipse.jface.text.source.ISourceViewer sourceViewer, String contentType) {
		return new org.emftext.sdk.concretesyntax.resource.cs.ui.CsTextHover(resourceProvider);
	}
	
	public org.eclipse.jface.text.hyperlink.IHyperlinkDetector[] getHyperlinkDetectors(org.eclipse.jface.text.source.ISourceViewer sourceViewer) {
		if (sourceViewer == null) {
			return null;
		}
		return new org.eclipse.jface.text.hyperlink.IHyperlinkDetector[] { new org.emftext.sdk.concretesyntax.resource.cs.ui.CsHyperlinkDetector(resourceProvider.getResource()) };
	}
	
	public org.eclipse.jface.text.quickassist.IQuickAssistAssistant getQuickAssistAssistant(org.eclipse.jface.text.source.ISourceViewer sourceViewer) {
		if (quickAssistAssistant == null) {
			quickAssistAssistant = new org.emftext.sdk.concretesyntax.resource.cs.ui.CsQuickAssistAssistant(resourceProvider, annotationModelProvider);
		}
		return quickAssistAssistant;
	}
	
	public org.eclipse.jface.text.reconciler.IReconciler getReconciler(final org.eclipse.jface.text.source.ISourceViewer sourceViewer) {
		if (fPreferenceStore == null || !fPreferenceStore.getBoolean(org.eclipse.ui.texteditor.spelling.SpellingService.PREFERENCE_SPELLING_ENABLED)) {
			return null;
		}
		
		org.eclipse.ui.texteditor.spelling.SpellingService spellingService = org.eclipse.ui.editors.text.EditorsUI.getSpellingService();
		if (spellingService.getActiveSpellingEngineDescriptor(fPreferenceStore) == null) {
			return null;
		}
		
		org.eclipse.jface.text.reconciler.IReconcilingStrategy strategy = new org.eclipse.ui.texteditor.spelling.SpellingReconcileStrategy(sourceViewer, spellingService) {
			
			@Override			
			protected org.eclipse.ui.texteditor.spelling.ISpellingProblemCollector createSpellingProblemCollector() {
				final org.eclipse.ui.texteditor.spelling.ISpellingProblemCollector collector = super.createSpellingProblemCollector();
				
				return new org.eclipse.ui.texteditor.spelling.ISpellingProblemCollector() {
					
					public void accept(org.eclipse.ui.texteditor.spelling.SpellingProblem problem) {
						int offset = problem.getOffset();
						int length = problem.getLength();
						if (sourceViewer == null) {
							return;
						}
						org.eclipse.jface.text.IDocument document = sourceViewer.getDocument();
						if (document == null) {
							return;
						}
						String text;
						try {
							text = document.get(offset, length);
						} catch (org.eclipse.jface.text.BadLocationException e) {
							return;
						}
						if (new org.emftext.sdk.concretesyntax.resource.cs.ui.CsIgnoredWordsFilter().ignoreWord(text)) {
							return;
						}
						collector.accept(problem);
					}
					
					public void beginCollecting() {
						collector.beginCollecting();
					}
					
					public void endCollecting() {
						collector.endCollecting();
					}
				};
			}
		};
		
		org.eclipse.jface.text.reconciler.MonoReconciler reconciler = new org.eclipse.jface.text.reconciler.MonoReconciler(strategy, false);
		reconciler.setDelay(500);
		return reconciler;
	}
	
	@Override	
	public String[] getDefaultPrefixes(org.eclipse.jface.text.source.ISourceViewer sourceViewer, String contentType) {
		return new String[] { "//" };
	}
	
}
