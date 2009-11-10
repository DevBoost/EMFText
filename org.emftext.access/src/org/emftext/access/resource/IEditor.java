package org.emftext.access.resource;

import org.eclipse.jface.text.ITextPresentationListener;

public interface IEditor {

	public IResource getResource();
	public void registerTextPresentationListener(ITextPresentationListener listener);
	public void invalidateTextRepresentation();
}
