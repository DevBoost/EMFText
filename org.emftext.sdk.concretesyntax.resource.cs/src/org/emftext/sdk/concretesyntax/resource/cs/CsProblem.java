package org.emftext.sdk.concretesyntax.resource.cs;

public class CsProblem extends org.emftext.runtime.resource.impl.AbstractProblem {
	
	private java.lang.String message;
	private org.emftext.runtime.resource.EProblemType type;
	
	public CsProblem(java.lang.String message, org.emftext.runtime.resource.EProblemType type) {
		super();
		this.message = message;
		this.type = type;
	}
	
	public org.emftext.runtime.resource.EProblemType getType() {
		return type;
	}
	
	public java.lang.String getMessage() {
		return message;
	}
	
}
