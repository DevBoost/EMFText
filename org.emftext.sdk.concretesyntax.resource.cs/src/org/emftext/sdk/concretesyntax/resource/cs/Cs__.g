lexer grammar Cs;

@members {
	public java.util.List<RecognitionException> lexerExceptions  = new java.util.ArrayList<RecognitionException>();
	public java.util.List<Integer> lexerExceptionsPosition       = new java.util.ArrayList<Integer>();

	public void reportError(RecognitionException e) {
		lexerExceptions.add(e);

		lexerExceptionsPosition.add(((ANTLRStringStream)input).index());
	}
}
@header {
package org.emftext.sdk.concretesyntax.resource.cs;

}

T__15 : 'SYNTAXDEF' ;
T__16 : 'FOR' ;
T__17 : 'START' ;
T__18 : ',' ;
T__19 : 'IMPORTS' ;
T__20 : '{' ;
T__21 : '}' ;
T__22 : 'OPTIONS' ;
T__23 : ';' ;
T__24 : 'TOKENS' ;
T__25 : 'RULES' ;
T__26 : ':' ;
T__27 : 'WITH' ;
T__28 : 'SYNTAX' ;
T__29 : '=' ;
T__30 : '::=' ;
T__31 : '|' ;
T__32 : '[' ;
T__33 : ']' ;
T__34 : '(' ;
T__35 : ')' ;
T__36 : '+' ;
T__37 : '*' ;
T__38 : '?' ;
T__39 : 'DEFINE' ;
T__40 : 'COLLECT' ;
T__41 : 'IN' ;
T__42 : 'PREDEFINED' ;

// $ANTLR src "./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g" 389
COMMENTS
:
	'//'(~('\n'|'\r'))*{ _channel=99; }
;
// $ANTLR src "./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g" 393
TEXT
:
	('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' )+
;
// $ANTLR src "./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g" 397
QNAME
:
	('A'..'Z'|'a'..'z'|'_')+('.'('A'..'Z'|'a'..'z'|'_'|'-'|'0'..'9')+)+
;
// $ANTLR src "./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g" 401
TEXT_33_
:
	('!')('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' )+
;
// $ANTLR src "./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g" 405
LB
:
	('\r\n' | '\r' | '\n'){ _channel=99; }
;
// $ANTLR src "./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g" 409
TEXT_35_
:
	('#')('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' )+
;
// $ANTLR src "./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g" 413
WS
:
	(' ' | '\t' | '\f'){ _channel=99; }
;
// $ANTLR src "./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g" 417
QUOTED_60_62
:
	('<')(~('>')|('\\''>'))*('>')
;
// $ANTLR src "./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g" 421
QUOTED_39_39
:
	('\'')(~('\'')|('\\''\''))*('\'')
;
// $ANTLR src "./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g" 425
QUOTED_36_36
:
	('$')(~('$')|('\\''$'))*('$')
;
// $ANTLR src "./src/org/emftext/sdk/concretesyntax/resource/cs/Cs.g" 429
QUOTED_34_34
:
	('"')(~('"')|('\\''"'))*('"')
;
