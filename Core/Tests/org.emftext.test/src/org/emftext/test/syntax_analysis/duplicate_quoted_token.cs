SYNTAXDEF duplicate_quoted_token
FOR <http://www.emftext.org/test/duplicate_quoted_token> <duplicate_quoted_token.genmodel>
START Root

OPTIONS {
	usePredefinedTokens = "false";
}

RULES {
	// here we should not get a warning
	// the quoted token is defined twice, but
	// is should be added only once to the syntax
	Root ::= "ROOT" att1['"','"'] att2['"','"'];
}