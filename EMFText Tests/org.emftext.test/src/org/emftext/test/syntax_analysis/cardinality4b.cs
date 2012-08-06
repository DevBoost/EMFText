SYNTAXDEF cardinality4
FOR <http://www.emftext.org/test/cardinality4> <cardinality4.genmodel>
START Root

OPTIONS {
	usePredefinedTokens = "false";
}

RULES {
	// here we should only get two warnings about the explicit syntax
	// choices.
	// the cardinality of reference 'reference' is 1..1.
	// there is three (nested) alternatives, each containing 'reference' once
	// so EMFText should not complain about the cardinalities.
	Root ::= ("ROOT" reference) | (reference | reference);
	A    ::= "A";
}