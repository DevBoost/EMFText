SYNTAXDEF opposite
FOR <http://www.emftext.org/test/references> <references.genmodel>
START Root

RULES {
	// here we should get an errors, because the type of reference 
	// 'toAbstract' is AbstractClassA, which has no concrete sub classes.
	Root ::= "ROOT" (toAbstract[])*;
}