package org.emftext.runtime.resource;

import org.eclipse.emf.ecore.EObject;

public interface IElementMapping extends IReferenceMapping {

	public EObject getTargetElement();
}
