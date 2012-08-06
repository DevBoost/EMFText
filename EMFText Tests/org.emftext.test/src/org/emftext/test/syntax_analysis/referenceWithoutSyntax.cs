SYNTAXDEF referenceWithoutSyntax
FOR <http://www.emftext.org/test/referenceWithoutSyntax> <referenceWithoutSyntax.genmodel>
START Root

OPTIONS {
	usePredefinedTokens = "false";
}

RULES {
	// here we should get an error, because the type of reference 
	// 'referenceWithoutSyntax' is 'ClassWithoutSyntax', which has 
	// no defined syntax.
	Root ::= "ROOT" referenceWithoutSyntax*;
}