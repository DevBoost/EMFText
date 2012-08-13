SYNTAXDEF cardinality5a
FOR <http://www.emftext.org/test/cardinality5> <cardinality5.genmodel>
START Root

OPTIONS {
	usePredefinedTokens = "false";
}

RULES {
	
	// here we should not get a warning because one alternative
	// is using reference twice and the other is using it five 
	// times
	Root ::= 
		(reference reference) | 
		(reference reference reference reference reference);
		
	A    ::= "A";
}