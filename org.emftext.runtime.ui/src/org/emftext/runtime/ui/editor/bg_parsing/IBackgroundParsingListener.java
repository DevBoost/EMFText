package org.emftext.runtime.ui.editor.bg_parsing;

import org.eclipse.emf.ecore.resource.Resource;

/**
 * A listener interface for classes that need notification
 * when a background parsing pass has completed.
 */
public interface IBackgroundParsingListener {

	public void parsingCompleted(Resource resource);
}
