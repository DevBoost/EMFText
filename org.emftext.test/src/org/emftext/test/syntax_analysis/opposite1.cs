SYNTAXDEF opposite
FOR <http://www.emftext.org/test/opposite> <opposite.genmodel>
START Root

RULES {
	Root ::= "ROOT" classes*;
	// here we should get a warning, because the references a,b are not
	// defined at all
	ClassA ::= "A";
	ClassB ::= "B";
}