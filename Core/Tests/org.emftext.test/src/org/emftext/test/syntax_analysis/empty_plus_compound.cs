SYNTAXDEF empty_plus_compound
FOR <http://www.emftext.org/test/empty_plus_compound> <empty_plus_compound.genmodel>
START Root

OPTIONS {
	usePredefinedTokens = "false";
}

RULES {
	// here we should get an error, because the outer compound is potentially
	// empty, which causes ANTLR to parse forever
	Root ::= ( ("a")? ("b")? )+;
}