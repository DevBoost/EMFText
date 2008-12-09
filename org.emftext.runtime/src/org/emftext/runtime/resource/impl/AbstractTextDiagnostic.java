package org.emftext.runtime.resource.impl;

import org.emftext.runtime.resource.TextDiagnostic;

public abstract class AbstractTextDiagnostic implements TextDiagnostic {

	private TextDiagnosticType type;
	
	public AbstractTextDiagnostic(TextDiagnosticType type) {
		super();
		this.type = type;
	}

	public TextDiagnosticType getType() {
		return type;
	}
}
