package org.emftext.runtime.resource;

public interface ITextToken {

	public String getName();
	public int getOffset();
	public int getLength();
	public boolean canBeUsedForSyntaxHighlighting();
}
