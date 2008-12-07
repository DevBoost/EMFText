package org.emftext.runtime.ui.editor.bg_parsing;

import org.eclipse.jface.text.DocumentEvent;

public class NoBackgroundParsingStrategy implements IBackgroundParsingStrategy {

	public boolean isParsingRequired(DocumentEvent event) {
		return false;
	}

}
