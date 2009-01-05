package org.emftext.runtime.ui;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.rules.ITokenScanner;
import org.eclipse.jface.text.source.DefaultAnnotationHover;
import org.eclipse.jface.text.source.IAnnotationHover;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.ui.part.FileEditorInput;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.ui.editor.EMFTextEditor;


public class EMFTextEditorConfiguration extends SourceViewerConfiguration {

	private ColorManager colorManager;
    private EMFTextEditor theEditor; 
    
    /**
     * 
     * @param editor
     * @param colorManager
     */
	public EMFTextEditorConfiguration(EMFTextEditor editor, ColorManager colorManager) {
		this.theEditor = editor;
        this.colorManager = colorManager;      
	}
    
	public IContentAssistant getContentAssistant(ISourceViewer sourceViewer) {

		ContentAssistant assistant= new ContentAssistant();
		assistant.setContentAssistProcessor(new EMFTextEditorCompletionProcessor(theEditor), IDocument.DEFAULT_CONTENT_TYPE);
		assistant.enableAutoActivation(true);
		assistant.setAutoActivationDelay(500);
		assistant.setProposalPopupOrientation(IContentAssistant.PROPOSAL_OVERLAY);
		assistant.setContextInformationPopupOrientation(IContentAssistant.CONTEXT_INFO_ABOVE);
		//assistant.setContextInformationPopupBackground(new Color(new RGB(255, 0, 0)));

		return assistant;
	}
	
	/**
	 * 
	 */
	public String[] getConfiguredContentTypes(ISourceViewer sourceViewer) {
		return new String[] {
			IDocument.DEFAULT_CONTENT_TYPE,
		 };
	}

	/**
	 * 
	 * @param fileExtension
	 * @return
	 */
    protected ITokenScanner getScanner(String fileName) {
		FileEditorInput input = (FileEditorInput) theEditor.getEditorInput();
		String path = input.getFile().getFullPath().toString();
		ITextResource thisFile = (ITextResource) theEditor.getResourceSet().getResource(URI.createPlatformResourceURI(path, true), true);
        
        return new AntlrTokenScanner(thisFile, fileName.substring(fileName.lastIndexOf(".") + 1), colorManager);
    }

    /**
     * 
     */
	public IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer) {
        
		PresentationReconciler reconciler = new PresentationReconciler();
        String fileName = theEditor.getEditorInput().getName();
        
		DefaultDamagerRepairer dr =
			new DefaultDamagerRepairer(getScanner(fileName));
        reconciler.setDamager(dr, IDocument.DEFAULT_CONTENT_TYPE);
        reconciler.setRepairer(dr, IDocument.DEFAULT_CONTENT_TYPE);

		return reconciler;
	}
	
	@Override
	public IAnnotationHover getAnnotationHover(ISourceViewer sourceViewer) {
		return new DefaultAnnotationHover();

	}

}