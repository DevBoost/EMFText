/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.debug;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.LineBreakpoint;

public class Cct5LineBreakpoint extends LineBreakpoint {
	
	private static final String LINE_BREAKPOINT_MARKER_ID = "org.emftext.test.cct5.resource.cct5.debug.lineBreakpoint.marker";
	
	public Cct5LineBreakpoint() {
		super();
	}
	
	public Cct5LineBreakpoint(final IResource resource, final int lineNumber) throws DebugException {
		this(resource, lineNumber, -1, -1);
	}
	
	public Cct5LineBreakpoint(final IResource resource, final int lineNumber, final int charStart, final int charEnd) throws DebugException {
		IWorkspaceRunnable runnable = new IWorkspaceRunnable() {
			public void run(IProgressMonitor monitor) throws CoreException {
				IMarker marker = resource.createMarker(LINE_BREAKPOINT_MARKER_ID);
				setMarker(marker);
				marker.setAttribute(IBreakpoint.ENABLED, Boolean.TRUE);
				marker.setAttribute(IMarker.LINE_NUMBER, lineNumber);
				marker.setAttribute(IMarker.CHAR_START, charStart);
				marker.setAttribute(IMarker.CHAR_END, charEnd);
				marker.setAttribute(IBreakpoint.ID, getModelIdentifier());
				marker.setAttribute(IMarker.MESSAGE, "Line Breakpoint: " + resource.getName() + " [line: " + lineNumber + "]");
				marker.setAttribute(IMarker.LOCATION, resource.getRawLocation().toPortableString());
			}
		};
		run(getMarkerRule(resource), runnable);
	}
	
	public String getModelIdentifier() {
		return org.emftext.test.cct5.resource.cct5.mopp.Cct5Plugin.DEBUG_MODEL_ID;
	}
	
	public void install(org.emftext.test.cct5.resource.cct5.debug.Cct5DebugTarget target) {
		try {
			String location = (String) getMarker().getAttribute(IMarker.LOCATION);
			target.getDebugProxy().addLineBreakpoint(location, getLineNumber());
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}
	
	public void remove(org.emftext.test.cct5.resource.cct5.debug.Cct5DebugTarget target) {
		try {
			String location = (String) getMarker().getAttribute(IMarker.LOCATION);
			target.getDebugProxy().removeLineBreakpoint(location, getLineNumber());
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}
	
}
