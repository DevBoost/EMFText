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
package org.reuseware.emftextedit.sdk.concretesyntax.resource.cs;

}

T15 : 'SYNTAXDEF' ;
T16 : 'FOR' ;
T17 : 'START' ;
T18 : ',' ;
T19 : 'IMPORTS' ;
T20 : '{' ;
T21 : '}' ;
T22 : 'OPTIONS' ;
T23 : ';' ;
T24 : 'TOKENS' ;
T25 : 'RULES' ;
T26 : ':' ;
T27 : 'WITH' ;
T28 : 'SYNTAX' ;
T29 : '=' ;
T30 : '::=' ;
T31 : '|' ;
T32 : '[' ;
T33 : ']' ;
T34 : '(' ;
T35 : ')' ;
T36 : '+' ;
T37 : '*' ;
T38 : '?' ;
T39 : 'DEFINE' ;
T40 : 'PREDEFINED' ;

// $ANTLR src "C:\Users\svenhart\workspaces\reuseware-development-st3\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\src\org\reuseware\emftextedit\sdk\concretesyntax\resource\cs\Cs.g" 496
COMMENTS
:
	'//'(~('\n'|'\r'))*{ channel=99; }
;
// $ANTLR src "C:\Users\svenhart\workspaces\reuseware-development-st3\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\src\org\reuseware\emftextedit\sdk\concretesyntax\resource\cs\Cs.g" 500
TEXT
:
	('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' )+
;
// $ANTLR src "C:\Users\svenhart\workspaces\reuseware-development-st3\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\src\org\reuseware\emftextedit\sdk\concretesyntax\resource\cs\Cs.g" 504
QNAME
:
	('A'..'Z'|'a'..'z'|'_')+('.'('A'..'Z'|'a'..'z'|'_'|'-'|'0'..'9')+)+
;
// $ANTLR src "C:\Users\svenhart\workspaces\reuseware-development-st3\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\src\org\reuseware\emftextedit\sdk\concretesyntax\resource\cs\Cs.g" 508
TEXT_33_
:
	('!')('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' )+
;
// $ANTLR src "C:\Users\svenhart\workspaces\reuseware-development-st3\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\src\org\reuseware\emftextedit\sdk\concretesyntax\resource\cs\Cs.g" 512
LB
:
	('\r\n' | '\r' | '\n'){ channel=99; }
;
// $ANTLR src "C:\Users\svenhart\workspaces\reuseware-development-st3\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\src\org\reuseware\emftextedit\sdk\concretesyntax\resource\cs\Cs.g" 516
TEXT_35_
:
	('#')('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' )+
;
// $ANTLR src "C:\Users\svenhart\workspaces\reuseware-development-st3\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\src\org\reuseware\emftextedit\sdk\concretesyntax\resource\cs\Cs.g" 520
WS
:
	(' ' | '\t' | '\f'){ channel=99; }
;
// $ANTLR src "C:\Users\svenhart\workspaces\reuseware-development-st3\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\src\org\reuseware\emftextedit\sdk\concretesyntax\resource\cs\Cs.g" 524
QUOTED_60_62
:
	('<')(~('>')|('\\''>'))*('>')
;
// $ANTLR src "C:\Users\svenhart\workspaces\reuseware-development-st3\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\src\org\reuseware\emftextedit\sdk\concretesyntax\resource\cs\Cs.g" 528
QUOTED_39_39
:
	('\'')(~('\'')|('\\''\''))*('\'')
;
// $ANTLR src "C:\Users\svenhart\workspaces\reuseware-development-st3\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\src\org\reuseware\emftextedit\sdk\concretesyntax\resource\cs\Cs.g" 532
QUOTED_36_36
:
	('$')(~('$')|('\\''$'))*('$')
;
// $ANTLR src "C:\Users\svenhart\workspaces\reuseware-development-st3\org.reuseware.emftextedit.sdk.concretesyntax.resource.cs\src\org\reuseware\emftextedit\sdk\concretesyntax\resource\cs\Cs.g" 536
QUOTED_34_34
:
	('"')(~('"')|('\\''"'))*('"')
;
