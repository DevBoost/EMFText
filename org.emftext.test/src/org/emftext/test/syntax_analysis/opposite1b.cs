SYNTAXDEF opposite
FOR <http://www.emftext.org/test/opposite1> <opposite1.genmodel>
START Root

RULES {
	Root ::= "ROOT" classes*;
	// here we should NOT get a warning, because the reference a is
	// defined in ClassB
	ClassA ::= "A";
	ClassB ::= "B" (a[])*;
}