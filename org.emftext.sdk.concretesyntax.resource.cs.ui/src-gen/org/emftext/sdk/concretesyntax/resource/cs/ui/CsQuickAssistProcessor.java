/*******************************************************************************
 * Copyright (c) 2006-2010 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/

package org.emftext.sdk.concretesyntax.resource.cs.ui;

public class CsQuickAssistProcessor implements org.eclipse.jface.text.quickassist.IQuickAssistProcessor {
	
	private org.emftext.sdk.concretesyntax.resource.cs.ui.CsEditor editor;
	
	public CsQuickAssistProcessor(org.emftext.sdk.concretesyntax.resource.cs.ui.CsEditor editor) {
		super();
		this.editor = editor;
	}
	
	public boolean canAssist(org.eclipse.jface.text.quickassist.IQuickAssistInvocationContext invocationContext) {
		return false;
	}
	
	public boolean canFix(org.eclipse.jface.text.source.Annotation annotation) {
		org.emftext.sdk.concretesyntax.resource.cs.ICsQuickFix quickFix = getQuickFix(annotation);
		return quickFix != null;
	}
	
	public org.eclipse.jface.text.contentassist.ICompletionProposal[] computeQuickAssistProposals(	org.eclipse.jface.text.quickassist.IQuickAssistInvocationContext invocationContext) {
		org.eclipse.jface.text.source.ISourceViewer sourceViewer = invocationContext.getSourceViewer();
		int offset = -1;
		int length = 0;
		if (invocationContext instanceof org.eclipse.jface.text.source.TextInvocationContext) {
			org.eclipse.jface.text.source.TextInvocationContext textContext = (org.eclipse.jface.text.source.TextInvocationContext) invocationContext;
			offset = textContext.getOffset();
			length = textContext.getLength();
		}
		java.util.List<org.emftext.sdk.concretesyntax.resource.cs.ICsQuickFix> quickFixes = getQuickFixes(sourceViewer, offset, length);
		org.eclipse.jface.text.contentassist.ICompletionProposal[] proposals = new org.eclipse.jface.text.contentassist.ICompletionProposal[quickFixes.size()];
		for (int i = 0; i < proposals.length; i++) {
			proposals[i] = createCompletionProposal(sourceViewer, quickFixes.get(i));
		}
		return proposals;
	}
	
	private org.eclipse.jface.text.contentassist.ICompletionProposal createCompletionProposal(final org.eclipse.jface.text.source.ISourceViewer sourceViewer, final org.emftext.sdk.concretesyntax.resource.cs.ICsQuickFix quickFix) {
		return new org.eclipse.jface.text.contentassist.ICompletionProposal() {
			
			public org.eclipse.swt.graphics.Point getSelection(org.eclipse.jface.text.IDocument document) {
				// TODO Auto-generated method stub
				return null;
			}
			
			public org.eclipse.swt.graphics.Image getImage() {
				// TODO Auto-generated method stub
				return null;
			}
			
			public String getDisplayString() {
				return quickFix.getDisplayString();
			}
			
			public org.eclipse.jface.text.contentassist.IContextInformation getContextInformation() {
				// TODO Auto-generated method stub
				return null;
			}
			
			public String getAdditionalProposalInfo() {
				// TODO Auto-generated method stub
				return null;
			}
			
			public void apply(org.eclipse.jface.text.IDocument document) {
				String currentContent = sourceViewer.getDocument().get();
				String newContent = quickFix.apply(currentContent);
				if (newContent != null) {
					// TODO maybe it is better to replace only the changed
					// part of the document
					sourceViewer.getDocument().set(newContent);
				}
			}
		};
	}
	
	private java.util.List<org.emftext.sdk.concretesyntax.resource.cs.ICsQuickFix> getQuickFixes(org.eclipse.jface.text.source.ISourceViewer sourceViewer, int offset, int length) {
		java.util.List<org.emftext.sdk.concretesyntax.resource.cs.ICsQuickFix> foundFixes = new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.ICsQuickFix>();
		org.eclipse.jface.text.source.IAnnotationModel model = getAnnotationModel();
		
		if (model == null) {
			return foundFixes;
		}
		
		java.util.Iterator<?> iter = model.getAnnotationIterator();
		while (iter.hasNext()) {
			org.eclipse.jface.text.source.Annotation annotation = (org.eclipse.jface.text.source.Annotation) iter.next();
			org.eclipse.jface.text.Position position = model.getPosition(annotation);
			if (offset >= 0) {
				if (!position.overlapsWith(offset, length)) {
					continue;
				}
			}
			org.emftext.sdk.concretesyntax.resource.cs.ICsQuickFix quickFix = getQuickFix(annotation);
			if (quickFix != null) {
				foundFixes.add(quickFix);
			}
		}
		return foundFixes;
	}
	
	private org.eclipse.jface.text.source.IAnnotationModel getAnnotationModel() {
		return editor.getDocumentProvider().getAnnotationModel(editor.getEditorInput());
	}
	
	private org.emftext.sdk.concretesyntax.resource.cs.ICsQuickFix getQuickFix(org.eclipse.jface.text.source.Annotation annotation) {
		
		if (annotation.isMarkedDeleted()) {
			return null;
		}
		
		if (annotation instanceof org.emftext.sdk.concretesyntax.resource.cs.ui.CsMarkerAnnotation) {
			org.emftext.sdk.concretesyntax.resource.cs.ui.CsMarkerAnnotation markerAnnotation = (org.emftext.sdk.concretesyntax.resource.cs.ui.CsMarkerAnnotation) annotation;
			org.eclipse.core.resources.IMarker marker = markerAnnotation.getMarker();
			try {
				Object quickFixValue = marker.getAttribute(org.eclipse.core.resources.IMarker.SOURCE_ID);
				if (quickFixValue != null && quickFixValue instanceof String) {
					String quickFixContext = (String) quickFixValue;
					org.emftext.sdk.concretesyntax.resource.cs.ICsQuickFix quickFix = editor.getResource().getQuickFix(quickFixContext);
					if (quickFix != null) {
						System.out.println("getQuickFixes() found " + quickFix);
						return quickFix;
					}
				}
			} catch (org.eclipse.core.runtime.CoreException ce) {
				if (ce.getMessage().matches("Marker.*not found.")) {
					// ignore
					System.out.println("getQuickFixes() marker not found: " + ce.getMessage());
				} else {
					ce.printStackTrace();
				}
			}
		}
		return null;
	}
	
	public String getErrorMessage() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
