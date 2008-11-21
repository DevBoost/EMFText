package org.reuseware.emftextedit.runtime.ui;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.rules.ITokenScanner;
import org.eclipse.jface.text.source.DefaultAnnotationHover;
import org.eclipse.jface.text.source.IAnnotationHover;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.ui.part.FileEditorInput;
import org.reuseware.emftextedit.runtime.resource.TextResource;
import org.reuseware.emftextedit.runtime.ui.editor.EMFTextEditor;


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
		FileEditorInput input = (FileEditorInput) theEditor.getEditorInput();
		String path = input.getFile().getFullPath().toString();
		TextResource thisFile = (TextResource) theEditor.getResourceSet().getResource(URI.createPlatformResourceURI(path, true), true);
        
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
		//		return new IAnnotationHover() {
//
//				public String getHoverInfo(ISourceViewer sourceViewer, int lineNumber) {
//					String[] messages = getMessagesForLine(sourceViewer, lineNumber);
//
//					if (messages.length == 0)
//						return null;
//
//					StringBuffer buffer = new StringBuffer();
//					for (int i = 0; i < messages.length; i++) {
//						buffer.append(messages[i]);
//						if (i < messages.length - 1)
//							buffer.append(System.getProperty("line.separator")); //$NON-NLS-1$
//					}
//					return buffer.toString();
//				}
//
//				private String[] getMessagesForLine(ISourceViewer viewer, int line) {
//					IDocument document = viewer.getDocument();
//					IAnnotationModel model = viewer.getAnnotationModel();
//
//					if (model == null)
//						return new String[0];
//
//					ArrayList messages = new ArrayList();
//
//					Iterator iter = model.getAnnotationIterator();
//					while (iter.hasNext()) {
//						Object object = iter.next();
//						if (object instanceof MarkerAnnotation) {
//							MarkerAnnotation annotation = (MarkerAnnotation) object;
//							if (compareRulerLine(model.getPosition(annotation), document, line)) {
//								IMarker marker = annotation.getMarker();
//								String message = marker.getAttribute(IMarker.MESSAGE, (String) null);
//								if (message != null && message.trim().length() > 0)
//									messages.add(message);
//							}
//						}
//					}
//					return (String[]) messages.toArray(new String[messages.size()]);
//				}
//
//				private boolean compareRulerLine(Position position, IDocument document, int line) {
//
//					try {
//						if (position.getOffset() > -1 && position.getLength() > -1) {
//							return document.getLineOfOffset(position.getOffset()) == line;
//						}
//					} catch (BadLocationException e) {
//					}
//					return false;
//				}
//		};
	}

}