package org.emftext.runtime.ui.editor.bg_parsing;

import org.eclipse.jface.text.DocumentEvent;

/**
 * A simple parsing strategy that never triggers background parsing.
 */
public class NoBackgroundParsingStrategy implements IBackgroundParsingStrategy {

	public boolean isParsingRequired(DocumentEvent event) {
		return false;
	}

}
