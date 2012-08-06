SYNTAXDEF basesyntax3
FOR <http://www.emftext.org/test/basesyntax3> <basesyntax3.genmodel>
START B2

OPTIONS {
	usePredefinedTokens = "false";
}

TOKENS {
	DEFINE T3 $('A'..'Z'|'a'..'z')+$;
}

RULES {
	B3 ::= "B3" name[T3];
}