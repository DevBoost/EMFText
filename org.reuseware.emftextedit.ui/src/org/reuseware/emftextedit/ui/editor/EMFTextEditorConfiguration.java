package org.reuseware.emftextedit.ui.editor;

import java.util.Map;

import org.antlr.runtime.Lexer;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.rules.ITokenScanner;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.reuseware.emftextedit.resource.TextResource;


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
    	ResourceSet rs = new ResourceSetImpl();
    	Resource tempResource = rs.createResource(URI.createURI(fileName));
    	
    	TextResource tr = (TextResource) tempResource;
        
        return new AntlrTokenScanner(tr, fileName.substring(fileName.lastIndexOf(".") + 1), colorManager);
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

}