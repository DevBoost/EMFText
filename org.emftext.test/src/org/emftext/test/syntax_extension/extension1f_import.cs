SYNTAXDEF extension1f
FOR <http://www.emftext.org/test/extension1> <extension1.genmodel>
START Root

OPTIONS {
	defaultTokenName = "IDENTIFIER";
	usePredefinedTokens = "false";
}

TOKENS {
	DEFINE IDENTIFIER $'#'('A'..'Z')*$;
}

RULES {
	Child ::= "C" name[];
}