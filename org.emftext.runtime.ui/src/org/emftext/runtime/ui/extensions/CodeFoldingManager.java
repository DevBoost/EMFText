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
package org.emftext.runtime.ui.extensions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.projection.ProjectionAnnotation;
import org.eclipse.jface.text.source.projection.ProjectionAnnotationModel;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.jface.util.SafeRunnable;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.XMLMemento;
import org.emftext.runtime.ui.editor.EMFTextEditor;
import org.osgi.framework.Bundle;

/**
 * 
 * This manager adds new ProjectionAnnotation for the code folding and deletes
 * old ProjectionAnnotation with lines < 3. It is needed to hold the toggle
 * states. It provides the ability to restore the toggle states between Eclipse
 * sessions and after closing, opening as well.
 * 
 * @author Hoang-Kim, Tan-Ky
 */
public class CodeFoldingManager {

	static final String PLUGIN_ID = "org.emftext.runtime.ui";
	static final String VERIFY_KEY = "verify_key";

	protected List<Annotation> oldAnnotations = new ArrayList<Annotation>();
	protected List<Annotation> deletions = new ArrayList<Annotation>();
	protected Map<Annotation, Position> additions = new HashMap<Annotation, Position>();

	protected ProjectionAnnotationModel projectionAnnotationModel;
	protected ProjectionViewer sourceViewer;
	protected EMFTextEditor emfTextEditor;

	/**
	 * Creates a code folding manager to handle the
	 * <code>ProjectionAnnotation</code>.
	 * 
	 * @param sourceViewer
	 *            the source viewer to calculate the element lines
	 * @param emfTextEditor
	 */
	public CodeFoldingManager(ProjectionViewer sourceViewer,
			EMFTextEditor emfTextEditor) {
		this.projectionAnnotationModel = sourceViewer
				.getProjectionAnnotationModel();
		this.sourceViewer = sourceViewer;
		this.emfTextEditor = emfTextEditor;
		addCloseListener(emfTextEditor);
	}

	private class EditorOnCloseListener implements IPartListener2 {

		private String uri;

		public EditorOnCloseListener(String uri) {
			this.uri = uri;
		}

		public void partActivated(IWorkbenchPartReference partRef) {
		}

		public void partBroughtToTop(IWorkbenchPartReference partRef) {
		}

		public void partClosed(IWorkbenchPartReference partRef) {
			if (partRef.isDirty())
				return;
			IWorkbenchPart workbenchPart = partRef.getPart(false);
			if (workbenchPart instanceof EMFTextEditor) {

				EMFTextEditor editor = (EMFTextEditor) workbenchPart;
				String uri = editor.getResource().getURI().toString();
				if (uri.equals(this.uri)) {
					saveCodeFoldingStateFile(uri);
					editor.getSite().getPage().removePartListener(this);
				}
			}

		}

		public void partDeactivated(IWorkbenchPartReference partRef) {
		}

		public void partHidden(IWorkbenchPartReference partRef) {
		}

		public void partInputChanged(IWorkbenchPartReference partRef) {
		}

		public void partOpened(IWorkbenchPartReference partRef) {
		}

		public void partVisible(IWorkbenchPartReference partRef) {
		}

	}

	private void addCloseListener(final EMFTextEditor emfTextEditor) {
		String uri = emfTextEditor.getResource().getURI().toString();
		emfTextEditor.getSite().getPage().addPartListener(
				new EditorOnCloseListener(uri));
	}

	/**
	 * Checks whether it is in the <code>ProjectionAnnotationModel</code> or in
	 * the addition set. If not it tries to add into <code>additions</code>.
	 * Deletes old ProjectionAnnotation with line count < 2.
	 * 
	 * @param positions
	 *            a list of available foldable positions
	 */
	public void updateCodefolding(List<Position> positions) {
		IDocument document = sourceViewer.getDocument();
		if (document == null)
			return;
		// Add new Position with a unique line offset
		oldAnnotations = new ArrayList<Annotation>();
		for (Iterator<?> annotationsIterator = projectionAnnotationModel
				.getAnnotationIterator(); annotationsIterator.hasNext();) {
			oldAnnotations.add((ProjectionAnnotation) annotationsIterator
					.next());
		}
		for (Position position : positions) {
			if (!isInModel(position) && !isInAdditions(position)) {
				addPosition(position);
			}
		}
		// Delete old Position with line count < 3.
		for (Annotation oldAnnotation : oldAnnotations) {
			Position modelPosition = projectionAnnotationModel
					.getPosition(oldAnnotation);
			int lines = 0;
			try {
				lines = document.getNumberOfLines(modelPosition.offset,
						modelPosition.length);
			} catch (BadLocationException e) {
				e.printStackTrace();
			}
			if (lines < 3) {
				deletions.add(oldAnnotation);
			}
		}
		projectionAnnotationModel.modifyAnnotations(deletions
				.toArray(new Annotation[0]), additions, null);
		deletions.clear();
		additions.clear();
	}

	/**
	 * Checks the offset of this <code>Position</code> with the
	 * <code>Position</code>s in the <code>ProjectionAnnotationModel</code> to
	 * determine the existence.
	 * 
	 * @param position
	 *            the position to check
	 * @return <code>true</code> if it is in the
	 *         <code>ProjectionAnnotationModel</code>
	 */
	private boolean isInModel(Position position) {
		for (Annotation oldAnnotation : oldAnnotations) {
			if (projectionAnnotationModel.getPosition(oldAnnotation).offset == position.offset) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks the offset of this <code>Position</code> with the
	 * <code>Position</code>s in <code>additions</code> to determine the
	 * existence.
	 * 
	 * @param position
	 *            the position to check
	 * @return <code>true</code> if it is in the <code>additions</code>
	 */
	private boolean isInAdditions(Position position) {
		for (Annotation addition : additions.keySet()) {
			if (additions.get(addition).offset == position.offset) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Tries to add this position into the model. If more positions exist on the
	 * same line, the longer one will be chosen. The position will be exchanged
	 * if it is in the additions, when the to be deleted <code>Annotation</code>
	 * existed in deletions. Else, just exchange the Position in additions, if
	 * there is a shorter one.
	 * 
	 * TODO hoang-kim test with JUnit
	 * 
	 * @param position
	 *            the position to be added.
	 */
	private void addPosition(Position position) {
		IDocument document = sourceViewer.getDocument();
		int lines = 0;
		try {
			lines = document.getNumberOfLines(position.offset, position.length);
		} catch (BadLocationException e) {
			e.printStackTrace();
			return;
		}
		if (lines < 3) {
			return;
		}

		for (Annotation oldAnnotation : oldAnnotations) {
			Position modelPosition = projectionAnnotationModel
					.getPosition(oldAnnotation);
			try {
				if (document.getLineOfOffset(position.offset) == document
						.getLineOfOffset(modelPosition.offset)) {
					if (modelPosition.length >= position.length) {
						return;
					} else {
						for (Annotation annotationToDelete : deletions) {
							if (annotationToDelete.equals(oldAnnotation)) {
								for (Annotation annotationToAdd : additions
										.keySet().toArray(new Annotation[0])) {
									Position addPosition = additions
											.get(annotationToAdd);
									if (document
											.getLineOfOffset(position.offset) == document
											.getLineOfOffset(addPosition.offset)) {
										if (addPosition.length < position.length) {
											additions.remove(annotationToAdd);
											additions.put(
													new ProjectionAnnotation(),
													position);
											return;
										}
									}
								}
							}
						}
						for (Annotation annotationToAdd : additions.keySet()
								.toArray(new Annotation[0])) {
							Position addPosition = additions
									.get(annotationToAdd);
							if (document.getLineOfOffset(position.offset) == document
									.getLineOfOffset(addPosition.offset)) {
								if (addPosition.length < position.length) {
									additions.remove(annotationToAdd);
									additions.put(new ProjectionAnnotation(),
											position);
									deletions.add(oldAnnotation);
									return;
								}
							}
						}
					}
				}
			} catch (BadLocationException e) {
				e.printStackTrace();
				return;
			}
		}
		additions.put(new ProjectionAnnotation(), position);
	}

	/**
	 * Saves the code folding state into the given memento.
	 * 
	 * @param memento
	 */
	public void saveCodeFolding(IMemento memento) {
		for (Iterator<?> annotationIterator = projectionAnnotationModel
				.getAnnotationIterator(); annotationIterator.hasNext();) {
			ProjectionAnnotation annotation = (ProjectionAnnotation) annotationIterator
					.next();
			IMemento annotationMemento = memento
					.createChild(ExtensionConstants.CodeFolding.ANNOTATION
							.toString());
			Position position = projectionAnnotationModel
					.getPosition(annotation);
			annotationMemento.putBoolean(
					ExtensionConstants.CodeFolding.IS_COLLAPSED.toString(),
					annotation.isCollapsed());
			annotationMemento.putInteger(ExtensionConstants.CodeFolding.OFFSET
					.toString(), position.offset);
			annotationMemento.putInteger(ExtensionConstants.CodeFolding.LENGTH
					.toString(), position.length);
		}
	}

	/**
	 * Restore the code folding state information which is in the given memento.
	 * 
	 * @param memento
	 */
	public void restoreCodeFolding(IMemento memento) {
		if (memento == null)
			return;
		IMemento[] annotationMementos = memento
				.getChildren(ExtensionConstants.CodeFolding.ANNOTATION
						.toString());
		if (annotationMementos == null)
			return;
		for (IMemento annotationMemento : annotationMementos) {
			boolean isCollapsed = annotationMemento
					.getBoolean(ExtensionConstants.CodeFolding.IS_COLLAPSED
							.toString());
			ProjectionAnnotation annotation = new ProjectionAnnotation(
					isCollapsed);
			int offset = annotationMemento
					.getInteger(ExtensionConstants.CodeFolding.OFFSET
							.toString());
			int length = annotationMemento
					.getInteger(ExtensionConstants.CodeFolding.LENGTH
							.toString());
			Position position = new Position(offset, length);
			projectionAnnotationModel.addAnnotation(annotation, position);
		}
	}

	/**
	 * Restores the code folding state from a XML file in the state location.
	 * 
	 * @param mementoToRestoreCodeFolding
	 *            the memento to restore the code folding state
	 * @param key
	 *            the key to determine the file
	 * @param timeStamp
	 *            the time stamp of the last saving
	 * @return <code>true</code> if restore successful
	 */
	public boolean restoreCodeFoldingStateFromFile(
			final IMemento mementoToRestoreCodeFolding, String uriString) {
		final File stateFile = getCodeFoldingStateFile(uriString);
		if (stateFile == null || !stateFile.exists())
			return false;
		SafeRunner.run(new SafeRunnable(
				"Unable to read code folding state. The state will be reset.") {
			public void run() throws Exception {
				FileInputStream input = new FileInputStream(stateFile);
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(input, "utf-8")); //$NON-NLS-1$
				IMemento memento = XMLMemento.createReadRoot(reader);
				mementoToRestoreCodeFolding.putMemento(memento);
				reader.close();
			}
		});
		String sourceText = sourceViewer.getDocument().get();
		if (!mementoToRestoreCodeFolding.getString(VERIFY_KEY).equals(
				makeMD5(sourceText)))
			return false;
		return true;
	}

	/**
	 * Saves the code folding state to a XML file in the state location.
	 * 
	 * @param key
	 *            the key to determine the file
	 * @param timeStamp
	 *            the time stamp of the last saving
	 */
	public void saveCodeFoldingStateFile(String uriString) {
		XMLMemento codeFoldingMemento = XMLMemento
				.createWriteRoot(ExtensionConstants.CodeFolding.MODEL
						.toString());
		String sourceText = sourceViewer.getDocument().get();
		codeFoldingMemento.putString(VERIFY_KEY, makeMD5(sourceText));
		saveCodeFolding(codeFoldingMemento);
		File stateFile = getCodeFoldingStateFile(uriString);
		if (stateFile == null)
			return;
		try {
			FileOutputStream stream = new FileOutputStream(stateFile);
			OutputStreamWriter writer = new OutputStreamWriter(stream, "utf-8"); //$NON-NLS-1$
			codeFoldingMemento.save(writer);
			writer.close();
		} catch (IOException e) {
			stateFile.delete();
			MessageDialog.openError((Shell) null, "Saving Problems",
					"Unable to save code folding state.");
			return;
		}
	}

	private File getCodeFoldingStateFile(String uriString) {
		Bundle bundle = Platform.getBundle(PLUGIN_ID);
		IPath path = Platform.getStateLocation(bundle);
		if (path == null)
			return null;
		path = path.append(makeMD5(uriString) + ".xml");
		return path.toFile();
	}

	private String makeMD5(String text) {
		MessageDigest md = null;
		byte[] encryptMsg = null;
		try {
			md = MessageDigest.getInstance("MD5");
			encryptMsg = md.digest(text.getBytes());
		} catch (NoSuchAlgorithmException e) {
			System.out.println("No Such Algorithm Exception!");
		}
		String swap = "";
		String byteStr = "";
		StringBuffer strBuf = new StringBuffer();
		for (int i = 0; i <= encryptMsg.length - 1; i++) {
			byteStr = Integer.toHexString(encryptMsg[i]);
			switch (byteStr.length()) {
			case 1:
				// if hex-number length is 1, add a '0' before
				swap = "0" + Integer.toHexString(encryptMsg[i]);
				break;
			case 2:
				// correct hex-letter
				swap = Integer.toHexString(encryptMsg[i]);
				break;
			case 8:
				// get the correct substring
				swap = (Integer.toHexString(encryptMsg[i])).substring(6, 8);
				break;
			}
			strBuf.append(swap);
			// appending swap to get complete hash-key
		}
		return strBuf.toString();
	}
}
