package org.emftext.sdk.codegen.generators.code_completion.helpers;

/**
 * ExpectedKeywords are used to denote that a follow set of
 * a syntax element contains a keyword (i.e., a fixed string 
 * in the syntax definition).
 */
public class ExpectedKeyword implements IExpectedElement {

	private String keyword;

	public ExpectedKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	public String getKeyword() {
		return keyword;
	}

	public String toString() {
		return keyword;
	}
}
