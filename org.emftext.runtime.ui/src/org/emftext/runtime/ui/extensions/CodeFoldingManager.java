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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.projection.ProjectionAnnotation;
import org.eclipse.jface.text.source.projection.ProjectionAnnotationModel;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.jface.util.SafeRunnable;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.XMLMemento;
import org.emftext.runtime.resource.ILocationMap;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.ui.IBackgroundParsingListener;
import org.emftext.runtime.ui.editor.EMFTextEditor;
import org.osgi.framework.Bundle;

/**
 * This manager adds new ProjectionAnnotation for the code folding and deletes
 * old ProjectionAnnotation with lines < 3. It is needed to hold the toggle
 * states. It provides the ability to restore the toggle states between Eclipse
 * sessions and after closing, opening as well.
 * 
 * @author Hoang-Kim, Tan-Ky
 */
public class CodeFoldingManager {

	// TODO replace this with the id of the generated plug-in
	static final String PLUGIN_ID = "org.emftext.runtime.ui";
	static final String VERIFY_KEY = "verify_key";
	private static final String ANNOTATION = "ANNOTATION";
	private static final String IS_COLLAPSED = "IS_COLLAPED";
	private static final String OFFSET = "OFFSET";
	private static final String LENGTH = "LENGTH";
	private static final String MODEL = "MODEL";

	protected List<ProjectionAnnotation> oldAnnotations = new ArrayList<ProjectionAnnotation>();
	protected Map<ProjectionAnnotation, Position> additions = new HashMap<ProjectionAnnotation, Position>();

	protected ProjectionAnnotationModel projectionAnnotationModel;
	protected ProjectionViewer sourceViewer;
	protected EMFTextEditor editor;

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
		this.projectionAnnotationModel = sourceViewer.getProjectionAnnotationModel();
		this.sourceViewer = sourceViewer;
		this.editor = emfTextEditor;
		addCloseListener(emfTextEditor);
		try {
			restoreCodeFoldingStateFromFile(editor.getResource().getURI().toString());
		} catch (Exception e) {
			calculatePositions();
		}
	}

	private class FoldingUpdateListener implements IBackgroundParsingListener {
		public void parsingCompleted(Resource resource) {
			calculatePositions();
		}
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
			if (partRef.isDirty()) {
				return;
			}
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
		emfTextEditor.getSite().getPage().addPartListener(new EditorOnCloseListener(uri));
		emfTextEditor.addBackgroundParsingListener(new FoldingUpdateListener());
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
		if (document == null) {
			return;
		}
		oldAnnotations.clear();
		Iterator<?> annotationIterator = projectionAnnotationModel.getAnnotationIterator();
		while(annotationIterator.hasNext()) {
			oldAnnotations.add((ProjectionAnnotation) annotationIterator.next());
		}
		// Add new Position with a unique line offset
		for (Position position : positions) {
			if (!isInAdditions(position)) {
				addPosition(position);
			}
		}
		projectionAnnotationModel.modifyAnnotations(oldAnnotations.toArray(new Annotation[0]), additions, null);
		additions.clear();
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
			Position additionPosition = additions.get(addition);
			if (position.offset == additionPosition.offset && position.length == additionPosition.length) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Tries to add this position into the model. Only positions with more than
	 * 3 lines can be taken in. If more positions exist on the same line, the
	 * longer one will be chosen. The shorter one in additions will be deleted.
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

		// if a position to add existed on the same line, the longer one will be
		// chosen
		try {
			for (ProjectionAnnotation annotationToAdd : additions.keySet()) {
				Position positionToAdd = additions.get(annotationToAdd);
				if (document.getLineOfOffset(position.offset) == document.getLineOfOffset(positionToAdd.offset)) {
					if (positionToAdd.length < position.length) {
						additions.remove(annotationToAdd);
					} else {
						return;
					}
				}
			}
		} catch (BadLocationException e) {
			return;
		}
		for (ProjectionAnnotation annotationInModel : oldAnnotations) {
			Position positionInModel = projectionAnnotationModel.getPosition(annotationInModel);
			if (position.offset == positionInModel.offset && position.length == positionInModel.length) {
				oldAnnotations.remove(annotationInModel);
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
		Iterator<?> annotationIt = projectionAnnotationModel.getAnnotationIterator();
		while (annotationIt.hasNext()) {
			ProjectionAnnotation annotation = (ProjectionAnnotation) annotationIt.next();
			IMemento annotationMemento = memento.createChild(ANNOTATION);
			Position position = projectionAnnotationModel.getPosition(annotation);
			annotationMemento.putBoolean(IS_COLLAPSED, annotation.isCollapsed());
			annotationMemento.putInteger(OFFSET, position.offset);
			annotationMemento.putInteger(LENGTH, position.length);
		}
	}

	/**
	 * Restore the code folding state information from the given memento.
	 * 
	 * @param memento
	 */
	public void restoreCodeFolding(IMemento memento) {
		if (memento == null) {
			return;
		}
		IMemento[] annotationMementos = memento.getChildren(ANNOTATION);
		if (annotationMementos == null) {
			return;
		}
		Map<ProjectionAnnotation, Boolean> collapsedStates = new LinkedHashMap<ProjectionAnnotation, Boolean>();
		for (IMemento annotationMemento : annotationMementos) {
			ProjectionAnnotation annotation = new ProjectionAnnotation();
			collapsedStates.put(annotation, annotationMemento.getBoolean(IS_COLLAPSED));
			int offset = annotationMemento.getInteger(OFFSET);
			int length = annotationMemento.getInteger(LENGTH);
			Position position = new Position(offset, length);
			projectionAnnotationModel.addAnnotation(annotation, position);
		}
		// postset collapse state to prevent wrong displaying folding code.
		for (ProjectionAnnotation annotation : collapsedStates.keySet()) {
			if (collapsedStates.get(annotation)) {
				projectionAnnotationModel.collapse(annotation);
			}
		}
	}

	/**
	 * Restores the code folding state from a XML file in the state location.
	 * 
	 * @param uriString
	 *            the key to determine the file name
	 */
	public void restoreCodeFoldingStateFromFile(String uriString) {
		final File stateFile = getCodeFoldingStateFile(uriString);
		if (stateFile == null || !stateFile.exists()) {
			calculatePositions();
			return;
		}
		SafeRunner.run(new SafeRunnable("Unable to read code folding state. The state will be reset.") {
			public void run() throws Exception {
				FileInputStream input = new FileInputStream(stateFile);
				BufferedReader reader = new BufferedReader(new InputStreamReader(input, "utf-8"));
				IMemento memento = XMLMemento.createReadRoot(reader);
				reader.close();
				String sourceText = sourceViewer.getDocument().get();
				if (memento.getString(VERIFY_KEY).equals(makeMD5(sourceText))) {
					restoreCodeFolding(memento);
				} else {
					calculatePositions();
				}
			}
		});
	}

	/**
	 * Saves the code folding state to a XML file in the state location.
	 * 
	 * @param uriString
	 *            the key to determine the file name to save
	 */
	public void saveCodeFoldingStateFile(String uriString) {
		IDocument document = sourceViewer.getDocument();
		if (document == null) {
			return;
		}
		XMLMemento codeFoldingMemento = XMLMemento.createWriteRoot(MODEL);
		codeFoldingMemento.putString(VERIFY_KEY, makeMD5(document.get()));
		saveCodeFolding(codeFoldingMemento);
		File stateFile = getCodeFoldingStateFile(uriString);
		if (stateFile == null) {
			return;
		}
		try {
			FileOutputStream stream = new FileOutputStream(stateFile);
			OutputStreamWriter writer = new OutputStreamWriter(stream, "utf-8");
			codeFoldingMemento.save(writer);
			writer.close();
		} catch (IOException e) {
			stateFile.delete();
			MessageDialog.openError((Shell) null, "Saving Problems", "Unable to save code folding state.");
		}
	}

	private File getCodeFoldingStateFile(String uriString) {
		Bundle bundle = Platform.getBundle(PLUGIN_ID);
		IPath path = Platform.getStateLocation(bundle);
		if (path == null) {
			return null;
		}
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
			// TODO write this to the error log
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

	protected void calculatePositions() {
		ITextResource textResource = (ITextResource) editor.getResource();
		IDocument document = sourceViewer.getDocument();
		if (textResource == null || document == null) {
			return;
		}
		EList<?> errorList = textResource.getErrors();
		if (errorList != null && errorList.size() > 0) {
			return;
		}
		final List<Position> positions = new ArrayList<Position>();
		ILocationMap locationMap = textResource.getLocationMap();
		EClass[] foldableClasses = textResource.getMetaInformation().getFoldableClasses();
		if (foldableClasses == null) {
			return;
		}
		if (foldableClasses.length < 1) {
			return;
		}
		List<EObject> contents = textResource.getContents();
		EObject[] contentArray = contents.toArray(new EObject[0]);
		List<EObject> allContents = getAllContents(contentArray);
		for (EObject nextObject : allContents) {
			boolean isFoldable = false;
			for (EClass eClass : foldableClasses) {
				if (nextObject.eClass().equals(eClass)) {
					isFoldable = true;
					break;
				}
			}
			if (!isFoldable) {
				continue;
			}
			int offset = locationMap.getCharStart(nextObject);
			int length = locationMap.getCharEnd(nextObject) + 1 - offset;
			try {
				int lines = document.getNumberOfLines(offset, length);
				if (lines < 2) {
					continue;
				}
			} catch (BadLocationException e) {
				continue;
			}
			length = getOffsetOfNextLine(document, length + offset) - offset;
			if (offset >= 0 && length > 0) {
				positions.add(new Position(offset, length));
			}
		}
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				updateCodefolding(positions);
			}
		});
	}

	private List<EObject> getAllContents(EObject[] contentArray) {
		List<EObject> result = new ArrayList<EObject>();
		for (EObject eObject : contentArray) {
			result.add(eObject);
			result.addAll(getAllContents(eObject.eContents().toArray(new EObject[0])));
		}
		return result;
	}

	private int getOffsetOfNextLine(IDocument document, int offset) {
		int end = document.getLength();
		int nextLineOffset = offset;
		if (offset < 0 || offset > end) {
			return -1;
		}
		while (nextLineOffset < end) {
			String charAtOffset = "";
			try {
				charAtOffset += document.getChar(nextLineOffset);
			} catch (BadLocationException e) {
				return -1;
			}
			if (charAtOffset.matches("\\S")) {
				return nextLineOffset;
			}
			if (charAtOffset.equals("\n")) {
				return nextLineOffset + 1;
			}
			nextLineOffset++;
		}
		return offset;
	}

}
