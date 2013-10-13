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

package org.emftext.sdk.concretesyntax.resource.cs.mopp;

import java.io.IOException;
import java.io.InputStream;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * The CsTaskItemBuilder is used to find task items in text documents. The current
 * implementation uses the generated lexer and the TaskItemDetector to detect task
 * items. This class is called by the BuilderAdapter, which runs both this builder
 * and the default builder that is intended to be customized.
 */
public class CsTaskItemBuilder {
	
	public void build(IFile resource, ResourceSet resourceSet, IProgressMonitor monitor) {
		monitor.setTaskName("Searching for task items");
		new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMarkerHelper().removeAllMarkers(resource, IMarker.TASK);
		if (isInBinFolder(resource)) {
			return;
		}
		java.util.List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTaskItem> taskItems = new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTaskItem>();
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTaskItemDetector taskItemDetector = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTaskItemDetector();
		InputStream inputStream = null;
		try {
			inputStream = resource.getContents();
			String charset = resource.getCharset();
			String content = org.emftext.sdk.concretesyntax.resource.cs.util.CsStreamUtil.getContent(inputStream, charset);
			org.emftext.sdk.concretesyntax.resource.cs.ICsTextScanner lexer = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMetaInformation().createLexer();
			lexer.setText(content);
			
			org.emftext.sdk.concretesyntax.resource.cs.ICsTextToken nextToken = lexer.getNextToken();
			while (nextToken != null) {
				String text = nextToken.getText();
				taskItems.addAll(taskItemDetector.findTaskItems(text, nextToken.getLine(), nextToken.getOffset()));
				nextToken = lexer.getNextToken();
			}
		} catch (IOException e) {
			org.emftext.sdk.concretesyntax.resource.cs.mopp.CsPlugin.logError("Exception while searching for task items", e);
		} catch (CoreException e) {
			org.emftext.sdk.concretesyntax.resource.cs.mopp.CsPlugin.logError("Exception while searching for task items", e);
		}
		
		try {
			if (inputStream != null) {
				inputStream.close();
			}
		} catch (IOException e) {
			// Ignore this
		}
		
		for (org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTaskItem taskItem : taskItems) {
			java.util.Map<String, Object> markerAttributes = new java.util.LinkedHashMap<String, Object>();
			markerAttributes.put(IMarker.USER_EDITABLE, false);
			markerAttributes.put(IMarker.DONE, false);
			markerAttributes.put(IMarker.LINE_NUMBER, taskItem.getLine());
			markerAttributes.put(IMarker.CHAR_START, taskItem.getCharStart());
			markerAttributes.put(IMarker.CHAR_END, taskItem.getCharEnd());
			markerAttributes.put(IMarker.MESSAGE, taskItem.getMessage());
			new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMarkerHelper().createMarker(resource, IMarker.TASK, markerAttributes);
		}
	}
	
	public String getBuilderMarkerId() {
		return IMarker.TASK;
	}
	
	public boolean isInBinFolder(IFile resource) {
		IContainer parent = resource.getParent();
		while (parent != null) {
			if ("bin".equals(parent.getName())) {
				return true;
			}
			parent = parent.getParent();
		}
		return false;
	}
	
}
