package org.emftext.runtime.ui.editor.bg_parsing;

import org.eclipse.emf.ecore.resource.Resource;

/**
 * A background parsing listener that does nothing.
 */
public class NoBackgroundParsingListener implements IBackgroundParsingListener {

	public void parsingCompleted(Resource resource) {
		// do nothing
	}
}
