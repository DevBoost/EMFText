package org.emftext.runtime.resource;

import org.eclipse.emf.ecore.EObject;

public interface IHoverTextProvider {
	
	public String getHoverText(EObject object);
}
