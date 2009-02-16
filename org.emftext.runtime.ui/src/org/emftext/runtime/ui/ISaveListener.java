package org.emftext.runtime.ui;

import org.eclipse.emf.ecore.resource.Resource;

/**
 * Implementors of this interfaces can be notified when a 
 * text resource is saved.
 */
public interface ISaveListener {
	public void savePerformed(Resource resource);
}
