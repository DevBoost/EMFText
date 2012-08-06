SYNTAXDEF cyclic_token_definition1
FOR <http://www.emftext.org/test/cyclic_token_definition1> <cyclic_token_definition1.genmodel>
START Main

OPTIONS {
	usePredefinedTokens = "false";
}

TOKENS {
	DEFINE SELFCYCLIC $'a'$ + SELFCYCLIC;
}

RULES {
	Main ::= "Main";
}