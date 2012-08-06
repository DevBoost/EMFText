SYNTAXDEF basesyntax4
FOR <http://www.emftext.org/test/basesyntax4> <basesyntax4.genmodel>
START B1

OPTIONS {
	usePredefinedTokens = "false";
}

TOKENS {
	DEFINE T1 $('0'..'9')+$;
}

RULES {
	B4 ::= "B4" name[T1];
}