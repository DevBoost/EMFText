grammar Bug1492a;

options {
	superClass = AbstractParser;
}

@lexer::header{
	package org.emftext.antlr;
}

@lexer::members{
	public java.util.List<org.antlr.runtime3_4_0.RecognitionException> lexerExceptions = new java.util.ArrayList<org.antlr.runtime3_4_0.RecognitionException>();
	
	public void reportError(org.antlr.runtime3_4_0.RecognitionException e) {
		lexerExceptions.add(e);
	}
} 

@header{
	package org.emftext.antlr; 
}

@members{
	public java.util.List<RecognitionException> getErrors() {
		java.util.List<RecognitionException> allErrors = new java.util.ArrayList<RecognitionException>();
		allErrors.addAll(errors);
		allErrors.addAll(((Bug1492aLexer) getTokenStream().getTokenSource()).lexerExceptions);
		return allErrors;
	}
}

// Rules
root returns [String s] 
@init{s = "";} : 
	IDENTIFIER IDENTIFIER { s = "ok"; }	
;

// Token Definitions

IDENTIFIER:
('a'..'z'|'A'..'Z')(('a'..'z'|'A'..'Z')|('0'..'9'))*;

// this token is problematic since the channel instruction is applied to the last
// alternative only. without the parenthesis around the regular expression, input
// containing ' ' or '\t' will not be parsed.
WHITESPACE:
(' '|'\t'|'\f')
{ _channel = 99; }
;
