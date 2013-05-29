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

public class CsToggleCommentHandler extends org.eclipse.core.commands.AbstractHandler {
	
	public static String[] COMMENT_PREFIXES = new String[] { "//" };
	
	private org.eclipse.jface.text.IDocument document;
	private org.eclipse.jface.text.ITextOperationTarget operationTarget;
	private java.util.Map<String, String[]> prefixesMap;
	
	@Override	
	public boolean isEnabled() {
		org.eclipse.ui.IEditorPart activeEditor = org.eclipse.ui.PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if (activeEditor instanceof org.emftext.sdk.concretesyntax.resource.cs.ui.CsEditor) {
			org.eclipse.jface.text.ITextOperationTarget operationTarget = (org.eclipse.jface.text.ITextOperationTarget) activeEditor.getAdapter(org.eclipse.jface.text.ITextOperationTarget.class);
			return (operationTarget != null && operationTarget.canDoOperation(org.eclipse.jface.text.ITextOperationTarget.PREFIX) && operationTarget.canDoOperation(org.eclipse.jface.text.ITextOperationTarget.STRIP_PREFIX));
		}
		return false;
	}
	
	@Override	
	public Object execute(org.eclipse.core.commands.ExecutionEvent event) throws org.eclipse.core.commands.ExecutionException {
		org.eclipse.ui.IEditorPart editorPart = org.eclipse.ui.handlers.HandlerUtil.getActiveEditor(event);
		org.emftext.sdk.concretesyntax.resource.cs.ui.CsEditor editor = null;
		
		if (editorPart instanceof org.emftext.sdk.concretesyntax.resource.cs.ui.CsEditor) {
			editor = (org.emftext.sdk.concretesyntax.resource.cs.ui.CsEditor) editorPart;
			operationTarget = (org.eclipse.jface.text.ITextOperationTarget) editorPart.getAdapter(org.eclipse.jface.text.ITextOperationTarget.class);
			document = editor.getDocumentProvider().getDocument(editor.getEditorInput());
		}
		if (editor == null || operationTarget == null || document == null) {
			return null;
		}
		
		prefixesMap = new java.util.LinkedHashMap<String, String[]>();
		prefixesMap.put(org.eclipse.jface.text.IDocument.DEFAULT_CONTENT_TYPE, COMMENT_PREFIXES);
		
		org.eclipse.jface.viewers.ISelection currentSelection = org.eclipse.ui.handlers.HandlerUtil.getCurrentSelection(event);
		final int operationCode;
		if (isSelectionCommented(currentSelection)) {
			operationCode = org.eclipse.jface.text.ITextOperationTarget.STRIP_PREFIX;
		} else {
			operationCode = org.eclipse.jface.text.ITextOperationTarget.PREFIX;
		}
		
		if (!operationTarget.canDoOperation(operationCode)) {
			return null;
		}
		
		org.eclipse.swt.widgets.Shell shell = editorPart.getSite().getShell();
		org.eclipse.swt.widgets.Display display = null;
		if (shell != null && !shell.isDisposed()) {
			display = shell.getDisplay();
		}
		
		org.eclipse.swt.custom.BusyIndicator.showWhile(display, new  Runnable() {
			public void run() {
				operationTarget.doOperation(operationCode);
			}
		});
		
		return null;
	}
	
	// Parts of the implementation below have been copied from
	// org.eclipse.jdt.internal.ui.javaeditor.ToggleCommentAction.
	private boolean isSelectionCommented(org.eclipse.jface.viewers.ISelection selection) {
		if (!(selection instanceof org.eclipse.jface.text.ITextSelection)) {
			return false;
		}
		org.eclipse.jface.text.ITextSelection textSelection = (org.eclipse.jface.text.ITextSelection) selection;
		if (textSelection.getStartLine() < 0 || textSelection.getEndLine() < 0) {
			return false;
		}
		try {
			org.eclipse.jface.text.IRegion block = getTextBlockFromSelection(textSelection, document);
			org.eclipse.jface.text.ITypedRegion[] regions = org.eclipse.jface.text.TextUtilities.computePartitioning(document, org.eclipse.jface.text.IDocumentExtension3.DEFAULT_PARTITIONING, block.getOffset(), block.getLength(), false);
			int[] lines = new int[regions.length * 2]; // [startline, endline, startline, endline, ...]
			for (int i = 0, j = 0; i < regions.length; i++, j+= 2) {
				// start line of region
				lines[j] = getFirstCompleteLineOfRegion(regions[i], document);
				// end line of region
				int length = regions[i].getLength();
				int offset = regions[i].getOffset() + length;
				if (length > 0) {
					offset--;
				}
				lines[j + 1] = (lines[j] == -1 ? -1 : document.getLineOfOffset(offset));
			}
			// Perform the check
			for (int i = 0, j = 0; i < regions.length; i++, j += 2) {
				String[] prefixes = prefixesMap.get(regions[i].getType());
				if (prefixes != null && prefixes.length > 0 && lines[j] >= 0 && lines[j + 1] >= 0) {
					if (!isBlockCommented(lines[j], lines[j + 1], prefixes, document)) {
						return false;
					}
				}
			}
			return true;
		} catch (org.eclipse.jface.text.BadLocationException x) {
			// should not happen
		}
		return false;
	}
	
	private org.eclipse.jface.text.IRegion getTextBlockFromSelection(org.eclipse.jface.text.ITextSelection selection, org.eclipse.jface.text.IDocument document) {
		try {
			org.eclipse.jface.text.IRegion line = document.getLineInformationOfOffset(selection.getOffset());
			int length = selection.getLength() == 0 ? line.getLength() : selection.getLength() + (selection.getOffset() - line.getOffset());
			return new org.eclipse.jface.text.Region(line.getOffset(), length);
		} catch (org.eclipse.jface.text.BadLocationException x) {
			// should not happen
		}
		return null;
	}
	
	private int getFirstCompleteLineOfRegion(org.eclipse.jface.text.IRegion region, org.eclipse.jface.text.IDocument document) {
		try {
			final int startLine = document.getLineOfOffset(region.getOffset());
			int offset = document.getLineOffset(startLine);
			if (offset >= region.getOffset()) {
				return startLine;
			}
			final int nextLine = startLine + 1;
			if (nextLine == document.getNumberOfLines()) {
				return -1;
			}
			offset = document.getLineOffset(nextLine);
			return (offset > region.getOffset() + region.getLength() ? -1 : nextLine);
		} catch (org.eclipse.jface.text.BadLocationException x) {
			// should not happen
		}
		return -1;
	}
	
	private boolean isBlockCommented(int startLine, int endLine, String[] prefixes, org.eclipse.jface.text.IDocument document) {
		try {
			// check for occurrences of prefixes in the given lines
			for (int i = startLine; i <= endLine; i++) {
				org.eclipse.jface.text.IRegion line = document.getLineInformation(i);
				String text = document.get(line.getOffset(), line.getLength());
				int[] found = org.eclipse.jface.text.TextUtilities.indexOf(prefixes, text, 0);
				if (found[0] == -1) {
					// found a line which is not commented
					return false;
				}
				String s = document.get(line.getOffset(), found[0]);
				s = s.trim();
				if (s.length() != 0) {
					// found a line which is not commented
					return false;
				}
			}
			return true;
		} catch (org.eclipse.jface.text.BadLocationException x) {
			// should not happen
		}
		return false;
	}
	
}
