/**
 * 
 */
package org.emftext.sdk;

import org.emftext.runtime.resource.EProblemType;
import org.emftext.runtime.resource.IProblem;

public class CsProblem implements IProblem {
	
	private String message;
	private ECsProblemType type;

	public CsProblem(String message, ECsProblemType type) {
		this.message = message;
		this.type = type;
	}

	public EProblemType getType() {
		return type.getProblemType();
	}

	public ECsProblemType getCsType() {
		return type;
	}

	public String getMessage() {
		return message;
	}
}