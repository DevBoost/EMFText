package org.reuseware.emftextedit.ui;

import org.eclipse.emf.ecore.resource.Resource;

public interface SaveListener {
	public void savePerformed(Resource resource);
}
