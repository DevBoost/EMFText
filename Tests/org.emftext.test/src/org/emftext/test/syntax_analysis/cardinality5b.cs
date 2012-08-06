SYNTAXDEF cardinality5b
FOR <http://www.emftext.org/test/cardinality5> <cardinality5.genmodel>
START Root

OPTIONS {
	usePredefinedTokens = "false";
}

RULES {
	
	// here we should get a warning because one alternative
	// is using reference once and the cardinality of feature 
	// reference is 2..5
	Root ::= 
		(reference reference) | 
		((reference reference reference reference reference) | (reference));
		
	A    ::= "A";
}