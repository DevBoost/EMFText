grammar Bug1492b;

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
		allErrors.addAll(((Bug1492bLexer) getTokenStream().getTokenSource()).lexerExceptions);
		return allErrors;
	}
}

// Rules
root returns [String s] 
@init{s = "";} : 
	IDENTIFIER (EQUALS | PLUS_EQUALS) IDENTIFIER { s = "ok"; }	
;

// Token Definitions

LONG:
	(('-')?('0'..'9')+)
;
DOUBLE:
	(('-')?('0'..'9')+'.'('0'..'9')+)
;
DATE:
	(('0'..'1')'0'..'9''.''0'..'3''0'..'9''.' '0'..'9''0'..'9''0'..'9''0'..'9')
;
PLUS_EQUALS:
	('+''=')
;
EQUALS:
	('=')
;
BOOLEAN:
	('true'|'false')
;
STRING:
	(('"')(('\\''"')|('\\''\\')|~('"'|'\\'))*('"'))
;
IDENTIFIER:
	(('A'..'Z'|'a'..'z'|'_')('A'..'Z'|'a'..'z'|'0'..'9'|'_'|'-')*)
;
WHITESPACE:
	((' '|'\t'|'\f'))
	
	{ _channel = 99; }
;
LINEBREAKS:
	(('\r\n'|'\r'|'\n'))
	
	{ _channel = 99; }
;
SL_COMMENT:
	('//'(~('\n'|'\r'|'\uffff'))*)
	
	{ _channel = 99; }
;