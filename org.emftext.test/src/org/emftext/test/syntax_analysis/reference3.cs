SYNTAXDEF opposite
FOR <http://www.emftext.org/test/references> <references.genmodel>
START Root

RULES {
	// here we should get an error, because the reference 
	// 'toAbstract' is not a containment reference.
	Root ::= "ROOT" toAbstract*;
}