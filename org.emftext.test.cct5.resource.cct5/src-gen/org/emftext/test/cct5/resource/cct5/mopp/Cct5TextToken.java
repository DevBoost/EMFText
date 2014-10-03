/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.mopp;


public class Cct5TextToken implements org.emftext.test.cct5.resource.cct5.ICct5TextToken {
	
	private String name;
	
	private String text;
	
	private int offset;
	
	private int length;
	
	private int line;
	
	private int column;
	
	private boolean canBeUsedForSyntaxHighlighting;
	
	public Cct5TextToken(String name, String text, int offset, int length, int line, int column, boolean canBeUsedForSyntaxHighlighting) {
		super();
		this.name = name;
		this.text = text;
		this.offset = offset;
		this.length = length;
		this.line = line;
		this.column = column;
		this.canBeUsedForSyntaxHighlighting = canBeUsedForSyntaxHighlighting;
	}
	
	public String getName() {
		return name;
	}
	
	public String getText() {
		return text;
	}
	
	public int getOffset() {
		return offset;
	}
	
	public int getLength() {
		return length;
	}
	
	public int getLine() {
		return line;
	}
	
	public int getColumn() {
		return column;
	}
	
	public boolean canBeUsedForSyntaxHighlighting() {
		return canBeUsedForSyntaxHighlighting;
	}
	
}
