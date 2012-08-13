SYNTAXDEF suppress_warnings1b
FOR <http://www.emftext.org/test/suppress_warnings1> <suppress_warnings1.genmodel>

START Root

OPTIONS {
	usePredefinedTokens = "false";
}

RULES {
	// Here we should get an error, because 'foo' is not a valid 
	// warning type
	@SuppressWarnings(foo)
	Root ::= "ROOT" att['"','"'];
}