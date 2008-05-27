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

// $ANTLR src "C:\Dokumente und Einstellungen\skarol\runtime-New_configuration\org.reuseware.emftextedit.concretesyntax.resource.cs\src\org\reuseware\emftextedit\concretesyntax\resource\cs\Cs.g" 461
COMMENTS
:
	'//'(~('\n'|'\r'))*{ channel=99; }
;
// $ANTLR src "C:\Dokumente und Einstellungen\skarol\runtime-New_configuration\org.reuseware.emftextedit.concretesyntax.resource.cs\src\org\reuseware\emftextedit\concretesyntax\resource\cs\Cs.g" 465
TEXT
:
	('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' )+
;
// $ANTLR src "C:\Dokumente und Einstellungen\skarol\runtime-New_configuration\org.reuseware.emftextedit.concretesyntax.resource.cs\src\org\reuseware\emftextedit\concretesyntax\resource\cs\Cs.g" 469
QNAME
:
	('A'..'Z'|'a'..'z'|'_')('.'('A'..'Z'|'a'..'z'|'_'|'-'|'0'..'9')+)+
;
// $ANTLR src "C:\Dokumente und Einstellungen\skarol\runtime-New_configuration\org.reuseware.emftextedit.concretesyntax.resource.cs\src\org\reuseware\emftextedit\concretesyntax\resource\cs\Cs.g" 473
TEXT_33_
:
	('!')('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' )+
;
// $ANTLR src "C:\Dokumente und Einstellungen\skarol\runtime-New_configuration\org.reuseware.emftextedit.concretesyntax.resource.cs\src\org\reuseware\emftextedit\concretesyntax\resource\cs\Cs.g" 477
LB
:
	('\r\n' | '\r' | '\n'){ channel=99; }
;
// $ANTLR src "C:\Dokumente und Einstellungen\skarol\runtime-New_configuration\org.reuseware.emftextedit.concretesyntax.resource.cs\src\org\reuseware\emftextedit\concretesyntax\resource\cs\Cs.g" 481
TEXT_35_
:
	('#')('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' )+
;
// $ANTLR src "C:\Dokumente und Einstellungen\skarol\runtime-New_configuration\org.reuseware.emftextedit.concretesyntax.resource.cs\src\org\reuseware\emftextedit\concretesyntax\resource\cs\Cs.g" 485
WS
:
	(' ' | '\t' | '\f'){ channel=99; }
;
// $ANTLR src "C:\Dokumente und Einstellungen\skarol\runtime-New_configuration\org.reuseware.emftextedit.concretesyntax.resource.cs\src\org\reuseware\emftextedit\concretesyntax\resource\cs\Cs.g" 489
QUOTED_60_62
:
	('<')(~('>')|('\\''>'))*('>')
;
// $ANTLR src "C:\Dokumente und Einstellungen\skarol\runtime-New_configuration\org.reuseware.emftextedit.concretesyntax.resource.cs\src\org\reuseware\emftextedit\concretesyntax\resource\cs\Cs.g" 493
QUOTED_39_39
:
	('\'')(~('\'')|('\\''\''))*('\'')
;
// $ANTLR src "C:\Dokumente und Einstellungen\skarol\runtime-New_configuration\org.reuseware.emftextedit.concretesyntax.resource.cs\src\org\reuseware\emftextedit\concretesyntax\resource\cs\Cs.g" 497
QUOTED_36_36
:
	('$')(~('$')|('\\''$'))*('$')
;
// $ANTLR src "C:\Dokumente und Einstellungen\skarol\runtime-New_configuration\org.reuseware.emftextedit.concretesyntax.resource.cs\src\org\reuseware\emftextedit\concretesyntax\resource\cs\Cs.g" 501
QUOTED_34_34
:
	('"')(~('"')|('\\''"'))*('"')
;
