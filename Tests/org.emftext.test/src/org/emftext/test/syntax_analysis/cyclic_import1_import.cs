SYNTAXDEF cyclic_import1
FOR <http://www.emftext.org/test/cyclic_import1> <cyclic_import1.genmodel>
START Main

IMPORTS {
	cyclic_import1 : <http://www.emftext.org/test/cyclic_import1> <cyclic_import1.genmodel> 
	WITH SYNTAX cyclic_import1 <cyclic_import1.cs>
}

OPTIONS {
	usePredefinedTokens = "false";
}

RULES {
	ClassInImportedPackage ::= "Imported";
}