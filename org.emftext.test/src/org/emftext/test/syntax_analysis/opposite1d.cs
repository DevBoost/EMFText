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
	// here we should NOT get a warning, because the reference b is
	// defined in ClassA and a is defined in ClassB
	ClassA ::= "A" (b[]);
	ClassB ::= "B" (a[]);
}