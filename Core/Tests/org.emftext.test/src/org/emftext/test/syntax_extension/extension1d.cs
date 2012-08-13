SYNTAXDEF extension1a
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
	// here we check whether the duplicate usage of the quoted token does
	// not lead to two token definitions
	Root  ::= "ROOT" childs[];
	Child ::= "C";
}