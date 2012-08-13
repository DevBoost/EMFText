grammar Bug1499;

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
		allErrors.addAll(((Bug1499Lexer) getTokenStream().getTokenSource()).lexerExceptions);
		return allErrors;
	}
}

// Rules
root returns [String s] 
@init{s = "";} : 
	CHOICE { s = "ok"; }	
;

// Token Definitions

CHOICE:
	(('[]'|('|''~''|')))
;

WHITESPACE:
	((' '|'\t'|'\f'))
	
	{ _channel = 99; }
;

LINEBREAKS:
	(('\r\n'|'\r'|'\n'))
	
	{ _channel = 99; }
;
