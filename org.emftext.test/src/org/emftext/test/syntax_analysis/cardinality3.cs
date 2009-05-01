SYNTAXDEF cardinality3
FOR <http://www.emftext.org/test/cardinality3> <cardinality3.genmodel>
START Root

OPTIONS {
	usePredefinedTokens = "false";
}

RULES {
	// here we should get a warning, because the reference 'reference'
	// has an upper bound of 2, but is defined mandatory three times 
	// in the syntax
	Root ::= "ROOT" reference "," reference "," reference;
	A    ::= "A";
}