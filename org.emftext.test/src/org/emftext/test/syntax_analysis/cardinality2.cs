SYNTAXDEF cardinality2
FOR <http://www.emftext.org/test/cardinality2> <cardinality2.genmodel>
START Root

OPTIONS {
	usePredefinedTokens = "false";
}

RULES {
	// here we should get a warning, because the reference 'reference'
	// has an lower bound of 0, but is defined mandatory in the syntax
	Root ::= "ROOT" reference ("," reference)*;
	A    ::= "A";
}