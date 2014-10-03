/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.ui.debug;

import org.eclipse.core.resources.IFile;
import org.eclipse.debug.core.model.ILineBreakpoint;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.ui.IDebugModelPresentation;
import org.eclipse.debug.ui.IValueDetailListener;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.part.FileEditorInput;

public class Cct5DebugModelPresentation implements IDebugModelPresentation {
	
	public Cct5DebugModelPresentation() {
		super();
	}
	
	public void addListener(ILabelProviderListener listener) {
		// do nothing
	}
	
	public void dispose() {
		// do nothing
	}
	
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}
	
	public void removeListener(ILabelProviderListener listener) {
		// do nothing
	}
	
	public IEditorInput getEditorInput(Object element) {
		if (element instanceof IFile) {
			return new FileEditorInput((IFile) element);
		} else if (element instanceof ILineBreakpoint) {
			return new FileEditorInput((IFile) ((ILineBreakpoint) element).getMarker().getResource());
		} else {
			return null;
		}
	}
	
	public String getEditorId(IEditorInput input, Object element) {
		if (element instanceof IFile || element instanceof ILineBreakpoint) {
			return org.emftext.test.cct5.resource.cct5.ui.Cct5UIPlugin.EDITOR_ID;
		}
		return null;
	}
	
	public void setAttribute(String attribute, Object value) {
		// not supported
	}
	
	public Image getImage(Object element) {
		return null;
	}
	
	public String getText(Object element) {
		return null;
	}
	
	public void computeDetail(IValue value, IValueDetailListener listener) {
		// listener.detailComputed(value, "detail");
	}
	
}
