package org.emftext.runtime.resource.impl;

import org.eclipse.emf.ecore.EObject;
import org.emftext.runtime.resource.ILocationMap;

public abstract class AbstractLocationMap implements ILocationMap {
	
	private EObject root;

	public void setRoot(EObject root) {
		this.root = root;
	}

	public EObject getRoot() {
		return root;
	}
}
