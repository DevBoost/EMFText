SYNTAXDEF extendingsyntax4
FOR <http://www.emftext.org/test/extendingsyntax4> <extendingsyntax4.genmodel>
START E4

IMPORTS {
	basesyntax1 : <http://www.emftext.org/test/basesyntax1> <basesyntax1.genmodel> WITH SYNTAX basesyntax1 <./basesyntax1.cs>
	basesyntax4 : <http://www.emftext.org/test/basesyntax4> <basesyntax4.genmodel> WITH SYNTAX basesyntax4 <./basesyntax4.cs>
}

OPTIONS {
	usePredefinedTokens = "false";
}

// this is a test where the imported syntaxes contain two
// tokens with the same name, but different (conflicting) expressions. 
// to use the tokens anyway, one of the tokens is overridden with
// the regular expression of the other one.

TOKENS {
	// this is equal to basesyntax1.T1
	REDEFINE basesyntax4.T1 AS NEWT1 $('a'..'z')+$;
}

RULES {
	E4 ::= "e4" b1 b4;
}