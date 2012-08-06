SYNTAXDEF basesyntax2
FOR <http://www.emftext.org/test/basesyntax2> <basesyntax2.genmodel>
START B2

OPTIONS {
	usePredefinedTokens = "false";
}

TOKENS {
	DEFINE T2 $('a'..'z')+$;
}

RULES {
	B2 ::= "B2" name[T2];
}