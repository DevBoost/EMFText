package org.reuseware.emftextedit.resource;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;

public class TokenConversionException extends RecognitionException{
	
	private static final long serialVersionUID = 1L;
	private String message;
	
	public TokenConversionException(Token token, String message){
		this.message = message;
		super.token = token;
		super.charPositionInLine = token.getCharPositionInLine();
		super.line = token.getLine();
		super.index = token.getTokenIndex();
	}
	
	public String getMessage(){
		return message;
	}
	
}
