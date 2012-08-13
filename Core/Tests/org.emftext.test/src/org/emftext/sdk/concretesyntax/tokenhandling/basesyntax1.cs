SYNTAXDEF basesyntax1
FOR <http://www.emftext.org/test/basesyntax1> <basesyntax1.genmodel>
START B1

OPTIONS {
	usePredefinedTokens = "false";
}

TOKENS {
	DEFINE T1 $('a'..'z')+$;
}

RULES {
	B1 ::= "B1" name[T1];
}