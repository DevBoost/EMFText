SYNTAXDEF empty_prefix_quoted_token
FOR <http://www.emftext.org/test/empty_prefix_quoted_token> <empty_prefix_quoted_token.genmodel>
START Main

OPTIONS {
	usePredefinedTokens = "false";
}

RULES {
	Main ::= "Main" name['','"'];
}