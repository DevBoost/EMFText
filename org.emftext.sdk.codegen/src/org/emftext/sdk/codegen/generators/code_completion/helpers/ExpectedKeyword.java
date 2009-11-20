package org.emftext.sdk.codegen.generators.code_completion.helpers;

public class ExpectedKeyword implements IExpectedElement {

	private String keyword;
	private String scopeID;
	private String message;

	public ExpectedKeyword(String keyword, String scopeID, String message) {
		this.keyword = keyword;
		this.scopeID = scopeID;
		this.message = message;
	}
	
	public String toString() {
		return keyword;
	}
}
