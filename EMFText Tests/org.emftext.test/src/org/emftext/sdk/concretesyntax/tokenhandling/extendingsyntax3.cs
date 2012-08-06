SYNTAXDEF extendingsyntax3
FOR <http://www.emftext.org/test/extendingsyntax3> <extendingsyntax3.genmodel>
START E3

IMPORTS {
	basesyntax1 : <http://www.emftext.org/test/basesyntax1> <basesyntax1.genmodel> WITH SYNTAX basesyntax1 <./basesyntax1.cs>
	basesyntax3 : <http://www.emftext.org/test/basesyntax3> <basesyntax3.genmodel> WITH SYNTAX basesyntax3 <./basesyntax3.cs>
}

OPTIONS {
	usePredefinedTokens = "false";
}

// this is a test where the imported syntaxes contain two
// tokens with different (conflicting) expressions. to use
// the tokens anyway, one of the tokens is overridden with
// the regular expression of the other one. 

TOKENS {
	// this is equal to basesyntax3.T3
	REDEFINE basesyntax1.T1 AS T1 $('A'..'Z'|'a'..'z')+$;
}

RULES {
	E3 ::= "e3" b1 b3;
}