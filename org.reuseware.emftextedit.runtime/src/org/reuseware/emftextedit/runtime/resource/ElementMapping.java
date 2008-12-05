package org.reuseware.emftextedit.runtime.resource;

import org.eclipse.emf.ecore.EObject;

public interface ElementMapping extends ReferenceMapping {

	public EObject getTargetElement();
}
