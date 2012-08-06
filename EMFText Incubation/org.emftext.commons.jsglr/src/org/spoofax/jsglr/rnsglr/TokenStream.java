package org.spoofax.jsglr.rnsglr;

import org.spoofax.jsglr.NotImplementedException;

public class TokenStream {

	private int position;
	private String input;

	public TokenStream(String input) {
		this.input = input;
		this.position = 0;
	}
	
	public int peek() {
		return input.charAt(position);
	}

	public boolean isEmpty() {
		return input.length() == 0;
	}

	public Token readNextToken() {
		return new Token(input.charAt(position++));
	}

	public boolean endOfStream() {
		return position >= input.length();
	}

	public int tokensRead() {
		return position;
	}

	public int length() {
		return input.length();
	}

	public Token getCurrentToken() {
		return new Token(input.charAt(position));
	}

	public void saveState() {
		throw new NotImplementedException();
	}

	public void loadState() {
		throw new NotImplementedException();
	}

}
