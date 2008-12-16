package org.emftext.runtime.resource.impl;

import org.eclipse.emf.ecore.EObject;
import org.emftext.runtime.resource.ITextDiagnostic;

public abstract class AbstractTextDiagnostic implements ITextDiagnostic {

	private TextDiagnosticType type;
	
	public AbstractTextDiagnostic(TextDiagnosticType type) {
		super();
		this.type = type;
	}

	public TextDiagnosticType getType() {
		return type;
	}
	
	public boolean wasCausedBy(EObject element) {
		return false;
	}
}
