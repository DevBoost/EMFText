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
package org.reuseware.emftextedit.concretesyntax.resource.cs;

}

T15 : 'SYNTAXDEF' ;
T16 : 'FOR' ;
T17 : 'START' ;
T18 : ',' ;
T19 : 'IMPORTS' ;
T20 : '{' ;
T21 : '}' ;
T22 : 'TOKENS' ;
T23 : ';' ;
T24 : 'RULES' ;
T25 : ':' ;
T26 : 'WITH' ;
T27 : 'SYNTAX' ;
T28 : '::=' ;
T29 : '|' ;
T30 : '[' ;
T31 : ']' ;
T32 : '(' ;
T33 : ')' ;
T34 : '+' ;
T35 : '*' ;
T36 : '?' ;
T37 : 'DEFINE' ;
T38 : 'PREDEFINED' ;

// $ANTLR src "C:\Dokumente und Einstellungen\skarol\reuseware2\org.reuseware.emftextedit.concretesyntax.resource.cs\src\org\reuseware\emftextedit\concretesyntax\resource\cs\Cs.g" 525
COMMENTS
:
	'//'(~('\n'|'\r'))*{ channel=99; }
;
// $ANTLR src "C:\Dokumente und Einstellungen\skarol\reuseware2\org.reuseware.emftextedit.concretesyntax.resource.cs\src\org\reuseware\emftextedit\concretesyntax\resource\cs\Cs.g" 529
TEXT
:
	('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' )+
;
// $ANTLR src "C:\Dokumente und Einstellungen\skarol\reuseware2\org.reuseware.emftextedit.concretesyntax.resource.cs\src\org\reuseware\emftextedit\concretesyntax\resource\cs\Cs.g" 533
QNAME
:
	('A'..'Z'|'a'..'z'|'_')+('.'('A'..'Z'|'a'..'z'|'_'|'-'|'0'..'9')+)+
;
// $ANTLR src "C:\Dokumente und Einstellungen\skarol\reuseware2\org.reuseware.emftextedit.concretesyntax.resource.cs\src\org\reuseware\emftextedit\concretesyntax\resource\cs\Cs.g" 537
TEXT_33_
:
	('!')('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' )+
;
// $ANTLR src "C:\Dokumente und Einstellungen\skarol\reuseware2\org.reuseware.emftextedit.concretesyntax.resource.cs\src\org\reuseware\emftextedit\concretesyntax\resource\cs\Cs.g" 541
LB
:
	('\r\n' | '\r' | '\n'){ channel=99; }
;
// $ANTLR src "C:\Dokumente und Einstellungen\skarol\reuseware2\org.reuseware.emftextedit.concretesyntax.resource.cs\src\org\reuseware\emftextedit\concretesyntax\resource\cs\Cs.g" 545
TEXT_35_
:
	('#')('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' )+
;
// $ANTLR src "C:\Dokumente und Einstellungen\skarol\reuseware2\org.reuseware.emftextedit.concretesyntax.resource.cs\src\org\reuseware\emftextedit\concretesyntax\resource\cs\Cs.g" 549
WS
:
	(' ' | '\t' | '\f'){ channel=99; }
;
// $ANTLR src "C:\Dokumente und Einstellungen\skarol\reuseware2\org.reuseware.emftextedit.concretesyntax.resource.cs\src\org\reuseware\emftextedit\concretesyntax\resource\cs\Cs.g" 553
QUOTED_60_62
:
	('<')(~('>')|('\\''>'))*('>')
;
// $ANTLR src "C:\Dokumente und Einstellungen\skarol\reuseware2\org.reuseware.emftextedit.concretesyntax.resource.cs\src\org\reuseware\emftextedit\concretesyntax\resource\cs\Cs.g" 557
QUOTED_39_39
:
	('\'')(~('\'')|('\\''\''))*('\'')
;
// $ANTLR src "C:\Dokumente und Einstellungen\skarol\reuseware2\org.reuseware.emftextedit.concretesyntax.resource.cs\src\org\reuseware\emftextedit\concretesyntax\resource\cs\Cs.g" 561
QUOTED_36_36
:
	('$')(~('$')|('\\''$'))*('$')
;
// $ANTLR src "C:\Dokumente und Einstellungen\skarol\reuseware2\org.reuseware.emftextedit.concretesyntax.resource.cs\src\org\reuseware\emftextedit\concretesyntax\resource\cs\Cs.g" 565
QUOTED_34_34
:
	('"')(~('"')|('\\''"'))*('"')
;
