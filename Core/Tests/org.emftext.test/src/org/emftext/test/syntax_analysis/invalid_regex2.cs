SYNTAXDEF invalid_regex2
FOR <http://www.emftext.org/test/invalid_regex2> <invalid_regex2.genmodel>
START Main

OPTIONS {
	usePredefinedTokens = "false";
	disableTokenSorting = "true";
}

TOKENS {
	// there must be an error here because complete tokens must be valid
	//
	// this test checks whether addition characters at the end of valid
	// expressions are detected
	DEFINE INVALID_COMPLETE_TOKEN $'a')$;
}

RULES {
	Main ::= "Main" attribute[INVALID_COMPLETE_TOKEN];
}