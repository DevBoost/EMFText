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
	
	// we should have three warnings alltogether:
	// 
	// we should get two warnings, because the reference 'toA' is not
	// defined in all concrete subclasses of AbstractClassB
	// it is defined in ConcreteEndB1, but missing in ConcreteEndB2
	//
	// we should get a warning that toA has a nc-opposite
	EndA ::= "A";
	ConcreteEndB1 ::= "B1" toA[]*;
	ConcreteEndB2 ::= "B2";
}