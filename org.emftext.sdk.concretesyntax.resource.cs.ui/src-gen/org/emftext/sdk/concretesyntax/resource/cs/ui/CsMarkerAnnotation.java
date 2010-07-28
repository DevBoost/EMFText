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

public class CsMarkerAnnotation extends org.eclipse.ui.texteditor.MarkerAnnotation implements org.eclipse.jface.text.quickassist.IQuickFixableAnnotation {
	
	boolean quickFixableState;
	boolean isQuickFixable;
	
	public CsMarkerAnnotation(org.eclipse.core.resources.IMarker marker) {
		super(marker);
	}
	
	public void setQuickFixable(boolean state) {
		isQuickFixable = state;
		quickFixableState = true;
	}
	
	public boolean isQuickFixableStateSet() {
		return true;
		//return quickFixableState;
	}
	
	public boolean isQuickFixable() {
		try {
			return getMarker().getAttribute(org.eclipse.core.resources.IMarker.SOURCE_ID) != null;
		} catch (org.eclipse.core.runtime.CoreException e) {
			// ignore
		}
		return false;
	}
	
}
