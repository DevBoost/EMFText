SYNTAXDEF cardinality4
FOR <http://www.emftext.org/test/cardinality4> <cardinality4.genmodel>
START Root

OPTIONS {
	usePredefinedTokens = "false";
}

RULES {
	// here we should only get one warning about the explicit syntax
	// choice. the cardinality of reference 'reference' is 1..1.
	// there is two alternatives, each containing 'reference' once
	// so EMFText should not complain about the cardinalities
	Root ::= ("ROOT" reference) | reference;
	A    ::= "A";
}