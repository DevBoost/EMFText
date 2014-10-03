/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.mopp;


public class Cct5TaskItem {
	
	private String keyword;
	
	private String message;
	
	private int line;
	
	private int charStart;
	
	private int charEnd;
	
	public Cct5TaskItem(String keyword, String message, int line, int charStart, int charEnd) {
		super();
		this.keyword = keyword;
		this.message = message;
		this.line = line;
		this.charStart = charStart;
		this.charEnd = charEnd;
	}
	
	public String getKeyword() {
		return keyword;
	}
	
	public String getMessage() {
		return message;
	}
	
	public int getLine() {
		return line;
	}
	
	public int getCharStart() {
		return charStart;
	}
	
	public int getCharEnd() {
		return charEnd;
	}
	
}
