SYNTAXDEF opposite
FOR <http://www.emftext.org/test/references> <references.genmodel>
START Root

OPTIONS {
	usePredefinedTokens = "false";
}

RULES {
	// here we should get an error, because the reference 
	// 'toAbstract' is a containment reference and we use
	// it ase if it were a non-containment.
	Root ::= "ROOT" toAbstract['"','"']*;
}