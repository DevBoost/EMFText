package org.emftext.runtime.ui.editor.bg_parsing;

import org.eclipse.jface.text.DocumentEvent;

/**
 * Implementation of this interface can be used to determine whether
 * background parsing is required depending of the change made to a 
 * text document.
 */
public interface IBackgroundParsingStrategy {
	
	/**
	 * Implementations of this method must decide whether the
	 * given event should trigger a complete parse of the 
	 * text resource.
	 * 
	 * @param event
	 * @return
	 */
	public boolean isParsingRequired(DocumentEvent event);
}
