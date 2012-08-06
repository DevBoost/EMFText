SYNTAXDEF opposite
FOR <http://www.emftext.org/test/references> <references.genmodel>
START Root

OPTIONS {
	usePredefinedTokens = "false";
}

RULES {
	// here we should get a warning, because the reference 
	// 'toAbstract' has no concrete syntax.
	Root ::= "ROOT" ;
}