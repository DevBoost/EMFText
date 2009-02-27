SYNTAXDEF opposite
FOR <http://www.emftext.org/test/simple> <simple.genmodel>
START Root

RULES {
	Root ::= "ROOT" classes*;
	// here we should NOT get a warning, because the reference b is
	// defined in ClassA
	ClassA ::= "A" (b[])*;
	ClassB ::= "B";
}