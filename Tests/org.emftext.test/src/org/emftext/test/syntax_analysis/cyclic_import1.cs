SYNTAXDEF cyclic_import1
FOR <http://www.emftext.org/test/cyclic_import1> <cyclic_import1.genmodel>
START Main

IMPORTS {
	cyclic_import1_import : <http://www.emftext.org/test/cyclic_import1_import> <cyclic_import1_import.genmodel> 
	WITH SYNTAX cyclic_import1_import <cyclic_import1_import.cs>
}

OPTIONS {
	usePredefinedTokens = "false";
}

RULES {
	Main ::= "Main";
}