SYNTAXDEF token_import1_import
FOR <http://www.emftext.org/test/token_import1_import> <token_import1_import.genmodel>
START RootInImport

OPTIONS {
	usePredefinedTokens = "false";
}

TOKENS {
	DEFINE TOKEN_IN_IMPORT $'a'..'z'$;
}

RULES {
	RootInImport ::= "ROOT" a1[TOKEN_IN_IMPORT];
}