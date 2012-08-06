SYNTAXDEF opposite
FOR <http://www.emftext.org/test/cardinality> <cardinality.genmodel>
START Root

OPTIONS {
	usePredefinedTokens = "false";
}

RULES {
	// here we should get an error, because the reference 'maxOneReference'
	// has an upper bound of 1, but is defined with cardinality STAR
	Root ::= "ROOT" maxOneReference*;
	Child ::= "C";
}