SYNTAXDEF opposite
FOR <http://www.emftext.org/test/opposite2> <opposite2.genmodel>
START Root

RULES {
	Root ::= "ROOT" theAs* theBs*;
	
	// here we should get two warnings, because the reference 'toA' is not
	// defined in all concrete subclasses of AbstractClassB
	// it is defined in ConcreteEndB1, but missing in ConcreteEndB2
	EndA ::= "A";
	ConcreteEndB1 ::= "B1" toA[]*;
	ConcreteEndB2 ::= "B2";
}