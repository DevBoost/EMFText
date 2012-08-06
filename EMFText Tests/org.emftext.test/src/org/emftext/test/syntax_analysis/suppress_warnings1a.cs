SYNTAXDEF suppress_warnings1a
FOR <http://www.emftext.org/test/suppress_warnings1> <suppress_warnings1.genmodel>

START Root

OPTIONS {
	usePredefinedTokens = "false";
}

RULES {
	// Here we should get a warnings, because @SuppressWarnings is set
	@SuppressWarnings
	Root ::= "ROOT";
}