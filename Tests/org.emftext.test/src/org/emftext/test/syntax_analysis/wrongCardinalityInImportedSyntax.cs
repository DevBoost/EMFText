@SuppressWarnings(unreachableRule)
SYNTAXDEF wrongCardinalityInImportedSyntax
FOR <http://www.emftext.org/test/wrongCardinalityInImportedSyntax> <wrongCardinalityInImportedSyntax.genmodel>

START Root

IMPORTS {
	wrongCardinalityInImportedSyntax_import : <http://www.emftext.org/test/wrongCardinalityInImportedSyntax_import> <wrongCardinalityInImportedSyntax_import.genmodel> 
	WITH SYNTAX wrongCardinalityInImportedSyntax_import <wrongCardinalityInImportedSyntax_import.cs>
}

OPTIONS {
	usePredefinedTokens = "false";
}

RULES {
	Root ::= "ROOT";
}