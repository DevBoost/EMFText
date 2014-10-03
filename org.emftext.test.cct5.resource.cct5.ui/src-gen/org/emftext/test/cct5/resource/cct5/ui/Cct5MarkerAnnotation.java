/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.ui;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.quickassist.IQuickFixableAnnotation;
import org.eclipse.ui.texteditor.MarkerAnnotation;

public class Cct5MarkerAnnotation extends MarkerAnnotation implements IQuickFixableAnnotation {
	
	// private boolean isQuickFixable;
	
	public Cct5MarkerAnnotation(IMarker marker) {
		super(marker);
	}
	
	public void setQuickFixable(boolean state) {
		// this.isQuickFixable = state;
	}
	
	public boolean isQuickFixableStateSet() {
		return true;
	}
	
	public boolean isQuickFixable() {
		try {
			return getMarker().getAttribute(IMarker.SOURCE_ID) != null;
		} catch (CoreException e) {
			// ignore
		}
		return false;
	}
	
}
