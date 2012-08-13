SYNTAXDEF cyclic_token_definition1
FOR <http://www.emftext.org/test/cyclic_token_definition1> <cyclic_token_definition1.genmodel>
START Main

OPTIONS {
	usePredefinedTokens = "false";
}

TOKENS {
	DEFINE TRANSITIVECYCLIC1 $'b'$ + TRANSITIVECYCLIC2;
	DEFINE TRANSITIVECYCLIC2 $'a'$ + TRANSITIVECYCLIC1;
}

RULES {
	Main ::= "Main";
}