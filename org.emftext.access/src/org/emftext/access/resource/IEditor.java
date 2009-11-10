package org.emftext.access.resource;

import org.eclipse.jface.text.ITextPresentationListener;

public interface IEditor {

	public ITextResource getResource();
	public void registerTextPresentationListener(ITextPresentationListener listener);
	public void invalidateTextRepresentation();
}
