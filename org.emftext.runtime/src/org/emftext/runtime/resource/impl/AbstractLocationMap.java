package org.emftext.runtime.resource.impl;

import org.eclipse.emf.ecore.EObject;
import org.emftext.runtime.resource.ILocationMap;

/**
 * Abstract super class for all location maps. This class provides
 * internal functionality used to associate text resource and location
 * maps.
 */
public abstract class AbstractLocationMap implements ILocationMap {
	
	private EObject root;

	public void setRoot(EObject root) {
		this.root = root;
	}

	public EObject getRoot() {
		return root;
	}
}
