SYNTAXDEF extendingsyntax5
FOR <http://www.emftext.org/test/extendingsyntax5> <extendingsyntax5.genmodel>
START E5

IMPORTS {
	basesyntax1 : <http://www.emftext.org/test/basesyntax1> <basesyntax1.genmodel> WITH SYNTAX basesyntax1 <./basesyntax1.cs>
	basesyntax4 : <http://www.emftext.org/test/basesyntax4> <basesyntax4.genmodel> WITH SYNTAX basesyntax4 <./basesyntax4.cs>
}

OPTIONS {
	usePredefinedTokens = "false";
}

// this is a test where the imported syntaxes contain two
// tokens with the same name, but different (conflicting) expressions. 
// to use the tokens anyway, both tokens are overridden, but they
// are given the same name. This should be detected and trigger a
// merge of the two tokens.

TOKENS {
	REDEFINE basesyntax1.T1 AS NEWT1 $('x'..'y')+$;
	REDEFINE basesyntax4.T1 AS NEWT1 $('x'..'y')+$;
}

RULES {
	E5 ::= "e5" b1 b4;
}