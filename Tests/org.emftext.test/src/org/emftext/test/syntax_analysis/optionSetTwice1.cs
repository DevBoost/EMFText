SYNTAXDEF optionSetTwice1
FOR <http://www.emftext.org/test/optionSetTwice> <optionSetTwice.genmodel>
START Root

OPTIONS {
	usePredefinedTokens = "false";
	// here we should get a warning, because the option 'overrideBuilder'
	// is set twice (with the same value)
	overrideBuilder = "false";
	overrideBuilder = "false";
}

RULES {
	Root ::= "root";
}