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
package org.emftext.runtime.ui;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.runtime.resource.ITextDiagnostic;

/**
 * Helper class to add markers to test files based on EMF's <code>Resource.Diagnostic</code>.
 * If a resource contains <code>TextDiagnostic</code>s it uses the more precise information of
 * this extended diagnostic type.
 * 
 * @author Jendrik Johannes
 */
public class MarkerHelper {
    
    public static final String MARKER_TYPE = "org.emftext.runtime.ui.problem";
    
    /**
     * Marks a file with markers.
     * 
     * @param resource The resource that is the file to mark.
     * @throws CoreException 
     */
    public static void mark(Resource resource) throws CoreException {
    	if (resource == null) return;
    	
        IFile file = (IFile) ResourcesPlugin.getWorkspace().getRoot().findMember(resource.getURI().toPlatformString(true));
        
        //URI might not point at a platform file
        if (file == null) {
        	return;
        }
        	
        createMarkersFromDiagnostics(resource, file, resource.getErrors(), IMarker.SEVERITY_ERROR);
        createMarkersFromDiagnostics(resource, file, resource.getWarnings(), IMarker.SEVERITY_WARNING);
    }

	private static void createMarkersFromDiagnostics(Resource resource,
			IFile file, List<Resource.Diagnostic> diagnostics, int markerSeverity) throws CoreException {

		// create a copy because the diagnostics list is modified concurrently
		// by the background parsing strategy
		Resource.Diagnostic[] copy = diagnostics.toArray(new Resource.Diagnostic[diagnostics.size()]);
		for (int i = 0; i < copy.length; i++) {
			Resource.Diagnostic diagnostic = copy[i];
			IMarker marker = file.createMarker(MARKER_TYPE);
            marker.setAttribute(IMarker.SEVERITY, markerSeverity);
            marker.setAttribute(IMarker.MESSAGE, diagnostic.getMessage());
            try {
            	if (diagnostic instanceof ITextDiagnostic) {
            		ITextDiagnostic textDiagnostic = (ITextDiagnostic) diagnostic;
    				marker.setAttribute(IMarker.LINE_NUMBER, textDiagnostic.getLine());
                    marker.setAttribute(IMarker.CHAR_START, textDiagnostic.getCharStart());
                    marker.setAttribute(IMarker.CHAR_END, textDiagnostic.getCharEnd() + 1);		
            	}
            	else {
                    marker.setAttribute(IMarker.CHAR_START, 0);
                    marker.setAttribute(IMarker.CHAR_END, 1);
            	}
			} catch (CoreException ce) {
				if (ce.getMessage().matches("Marker.*not found.")) {
					// ignore
				} else {
					ce.printStackTrace();
				}
			}
        }
	}
    
    /**
     * Removes all markers from a file.
     * 
     * @param resource The resource that is the file.
     * @throws CoreException
     */
    public static void unmark(Resource resource) throws CoreException {
        IFile file = (IFile) ResourcesPlugin.getWorkspace().getRoot().findMember(resource.getURI().toPlatformString(true));
        file.deleteMarkers(MarkerHelper.MARKER_TYPE, false, IResource.DEPTH_ZERO);    
    }
}
