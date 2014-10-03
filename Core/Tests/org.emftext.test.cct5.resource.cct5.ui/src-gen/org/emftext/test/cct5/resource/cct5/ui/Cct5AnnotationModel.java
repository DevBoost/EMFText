/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.ui;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.ui.texteditor.MarkerAnnotation;
import org.eclipse.ui.texteditor.ResourceMarkerAnnotationModel;

public class Cct5AnnotationModel extends ResourceMarkerAnnotationModel {
	
	public Cct5AnnotationModel(IResource resource) {
		super(resource);
	}
	
	protected MarkerAnnotation createMarkerAnnotation(IMarker marker) {
		return new org.emftext.test.cct5.resource.cct5.ui.Cct5MarkerAnnotation(marker);
	}
	
}
