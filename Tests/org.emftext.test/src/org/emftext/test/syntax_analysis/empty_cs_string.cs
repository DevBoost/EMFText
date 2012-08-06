SYNTAXDEF empty_cs_string
FOR <http://www.emftext.org/test/empty_cs_string> <empty_cs_string.genmodel>
START Root

OPTIONS {
	usePredefinedTokens = "false";
}

RULES {
	// here we should get an error, because empty CS strings are not allowed
	Root ::= "ROOT" "";
}