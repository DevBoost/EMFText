SYNTAXDEF invalid_regex1
FOR <http://www.emftext.org/test/invalid_regex1> <invalid_regex1.genmodel>
START Main

OPTIONS {
	usePredefinedTokens = "false";
	disableTokenSorting = "true";
}

TOKENS {
	// there should be no error here because partial tokens can be invalid
	DEFINE FRAGMENT INVALID_PARTIAL_TOKEN $('b'$;
	// there must be an error here because complete tokens must be valid
	DEFINE INVALID_COMPLETE_TOKEN $('a'$;
}

RULES {
	Main ::= "Main";
}