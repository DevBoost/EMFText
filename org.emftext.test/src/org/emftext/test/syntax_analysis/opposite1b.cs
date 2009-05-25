SYNTAXDEF opposite
FOR <http://www.emftext.org/test/opposite1> <opposite1.genmodel>
START Root

OPTIONS {
	usePredefinedTokens = "false";
	defaultTokenName = "TEXT";
}

TOKENS {
	DEFINE TEXT $('a'..'z')*$;
}

RULES {
	Root ::= "ROOT" classes*;
	
	// here we should get one warning
	//
	// we should NOT get a warning, because the reference a is
	// defined in ClassB
	//
	// we should get a warning that a has a nc-opposite
	ClassA ::= "A";
	ClassB ::= "B" (a[]);
}