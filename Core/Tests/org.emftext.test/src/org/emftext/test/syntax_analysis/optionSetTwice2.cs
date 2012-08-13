SYNTAXDEF optionSetTwice2
FOR <http://www.emftext.org/test/optionSetTwice> <optionSetTwice.genmodel>
START Root

OPTIONS {
	usePredefinedTokens = "false";
	// here we should get an error, because the option 'overrideBuilder'
	// is set twice (with a different value)
	overrideBuilder = "false";
	overrideBuilder = "true";
}

RULES {
	Root ::= "root";
}