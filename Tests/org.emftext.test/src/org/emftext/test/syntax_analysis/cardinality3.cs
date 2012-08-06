SYNTAXDEF cardinality3
FOR <http://www.emftext.org/test/cardinality3> <cardinality3.genmodel>
START Root

OPTIONS {
	usePredefinedTokens = "false";
}

RULES {
	// here we should get two warnings:
	// 1. because the reference 'reference'
	// has an upper bound of 2, but is defined mandatory three times 
	// in the syntax
	// 2. because the reference 'reference'
	// has an lower bound of 0, but is defined mandatory three times
	// in the syntax
	Root ::= "ROOT" reference "," reference "," reference;
	A    ::= "A";
}