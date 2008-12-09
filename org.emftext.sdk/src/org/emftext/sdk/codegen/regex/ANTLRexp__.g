lexer grammar ANTLRexp;
@members {
  public java.util.List<RecognitionException> lexerExceptions  = new java.util.ArrayList<RecognitionException>();

  public void reportError(RecognitionException e) {
     lexerExceptions.add(e);
	}
	
 
}
@header {
package org.reuseware.emftextedit.codegen.regex; 

}

T10 : '|' ;
T11 : '?' ;
T12 : '*' ;
T13 : '+' ;
T14 : '^' ;
T15 : '!' ;
T16 : '..' ;
T17 : '.' ;
T18 : '(' ;
T19 : ')' ;
T20 : '~' ;

// $ANTLR src "src/org/emftext/codegen/regex/ANTLRexp.g" 91
CHAR_LITERAL	:	'\'' LITERAL_CHAR '\'' ;

// $ANTLR src "src/org/emftext/codegen/regex/ANTLRexp.g" 93
STRING_LITERAL :	'\'' LITERAL_CHAR LITERAL_CHAR* '\'';

// $ANTLR src "src/org/emftext/codegen/regex/ANTLRexp.g" 95
fragment LITERAL_CHAR :	ESC  |	~( '\'' | '\\' );

// $ANTLR src "src/org/emftext/codegen/regex/ANTLRexp.g" 97
fragment ESC	:	'\\' (	'n' 	|	'r'  |	't'   |	'b' |	'f' |	'"'|	'\''	|	'\\' |	'>' |	'u' XDIGIT XDIGIT XDIGIT XDIGIT |	. );

// $ANTLR src "src/org/emftext/codegen/regex/ANTLRexp.g" 99
fragment XDIGIT : '0' .. '9' |	'a' .. 'f' 	|	'A' .. 'F';

// $ANTLR src "src/org/emftext/codegen/regex/ANTLRexp.g" 101
WS	:	(	' ' | '\t'|	'\r'? '\n' )+ {$channel=HIDDEN;};
