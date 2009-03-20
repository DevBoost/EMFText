SYNTAXDEF opposite
FOR <http://www.emftext.org/test/opposite2> <opposite2.genmodel>
START Root

OPTIONS {
	usePredefinedTokens = "false";
	defaultTokenName = "TEXT";
}

TOKENS {
	DEFINE TEXT $('a'..'z')*$;
}

RULES {
	Root ::= "ROOT" theAs* theBs*;
	
	// here we should NOT get a warning, because the reference 'toA' is
	// defined in all concrete subclasses of AbstractClassB
	EndA ::= "A";
	ConcreteEndB1 ::= "B1" toA[]*;
	ConcreteEndB2 ::= "B2" toA[]*;
}
