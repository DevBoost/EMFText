/**
 * 
 */
package org.emftext.sdk.concretesyntax.resource.cs.mopp;

import org.emftext.sdk.concretesyntax.resource.cs.CsEProblemType;
import org.emftext.sdk.concretesyntax.resource.cs.ICsProblem;

public class CsProblem implements ICsProblem {
	
	private String message;
	private ECsProblemType csProblemType;
	private CsEProblemType problemType;

	public CsProblem(String message, ECsProblemType type) {
		this.message = message;
		this.csProblemType = type;
		this.problemType = csProblemType.getProblemType();
	}

	public CsProblem(String message, CsEProblemType type) {
		this.message = message;
		this.problemType = type;
	}

	public CsEProblemType getType() {
		return problemType;
	}

	public ECsProblemType getCsType() {
		return csProblemType;
	}

	public String getMessage() {
		return message;
	}
}