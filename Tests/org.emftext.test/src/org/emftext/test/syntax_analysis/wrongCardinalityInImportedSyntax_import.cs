SYNTAXDEF wrongCardinalityInImportedSyntax_import
FOR <http://www.emftext.org/test/wrongCardinalityInImportedSyntax_import> <wrongCardinalityInImportedSyntax_import.genmodel>

START ImportedElement

OPTIONS {
	usePredefinedTokens = "false";
}

RULES {
	// here we should get a warning, because feature 'referenceWithMismatchingCardinality'
	// has cardinality 0..1 but is defined mandatory in the syntax
	ImportedElement ::= "PREFIX" referenceWithMismatchingCardinality;
}