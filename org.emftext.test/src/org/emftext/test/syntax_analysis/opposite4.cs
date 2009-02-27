SYNTAXDEF opposite
FOR <http://www.emftext.org/test/opposite> <opposite.genmodel>
START Root

RULES {
	Root ::= "ROOT" classes*;
	// here we should NOT get a warning, because the reference b is
	// defined in ClassA and a is defined in ClassB
	ClassA ::= "A" (b[])*;
	ClassB ::= "B" (a[])*;
}