SYNTAXDEF token_import1
FOR <http://www.emftext.org/test/token_import1> <token_import1.genmodel>
START Root

IMPORTS {
	token_import1_import : <http://www.emftext.org/test/token_import1_import> <token_import1_import.genmodel> 
	WITH SYNTAX token_import1_import <token_import1_import.cs>
}

OPTIONS {
	usePredefinedTokens = "false";
}

TOKENS {
	PRIORITIZE TOKEN_IN_IMPORT;
}

RULES {
	Root ::= "ROOT";
}