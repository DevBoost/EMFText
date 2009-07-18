package org.emftext.runtime.resource;

public interface ITextLexer {

	public void setText(String text);
	public ITextToken getNextToken();
}
