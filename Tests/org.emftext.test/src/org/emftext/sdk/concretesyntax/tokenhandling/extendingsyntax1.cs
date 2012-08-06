SYNTAXDEF extendingsyntax1
FOR <http://www.emftext.org/test/extendingsyntax1> <extendingsyntax1.genmodel>
START E1

IMPORTS {
	basesyntax1 : <http://www.emftext.org/test/basesyntax1> <basesyntax1.genmodel> WITH SYNTAX basesyntax1 <./basesyntax1.cs>
}

OPTIONS {
	usePredefinedTokens = "false";
}

// this is a test to override an existing token of an imported syntax
TOKENS {
	REDEFINE basesyntax1.T1 AS T1 $('0'..'9'|'a'..'z')+$;
}

RULES {
	E1 ::= "e1" b1;
}