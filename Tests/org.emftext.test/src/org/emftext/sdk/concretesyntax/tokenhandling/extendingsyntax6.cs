SYNTAXDEF extendingsyntax6
FOR <http://www.emftext.org/test/extendingsyntax6> <extendingsyntax6.genmodel>
START E6

IMPORTS {
	basesyntax4 : <http://www.emftext.org/test/basesyntax4> <basesyntax4.genmodel> WITH SYNTAX basesyntax4 <./basesyntax4.cs>
}

OPTIONS {
	usePredefinedTokens = "false";
}

// this is a test where the imported syntax contains a token, 
// which is more specific than the token defined below.
// to use the tokens anyway, the tokens must be correctly sorted
// by the token merger.

TOKENS {
	DEFINE TE1 $('0'..'9'|'a'..'z')+$;
}

RULES {
	E6 ::= "e6" b4;
}