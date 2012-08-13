SYNTAXDEF extendingsyntax2
FOR <http://www.emftext.org/test/extendingsyntax2> <extendingsyntax2.genmodel>
START E2

IMPORTS {
	basesyntax1 : <http://www.emftext.org/test/basesyntax1> <basesyntax1.genmodel> WITH SYNTAX basesyntax1 <./basesyntax1.cs>
	basesyntax2 : <http://www.emftext.org/test/basesyntax2> <basesyntax2.genmodel> WITH SYNTAX basesyntax2 <./basesyntax2.cs>
}

OPTIONS {
	usePredefinedTokens = "false";
}

// this is a test where the imported syntaxes contain two
// tokens with different names, but the same regular expression
RULES {
	E2 ::= "e2" b1 b2;
}