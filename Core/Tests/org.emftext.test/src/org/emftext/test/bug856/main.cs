SYNTAXDEF main
FOR <http://www.emftext.org/test/main> <main.genmodel>
START ClassInMainPackage

IMPORTS {
	selfImport : <http://www.emftext.org/test/main> <main.genmodel> 
	WITH SYNTAX main <main.cs>
}

OPTIONS {
	usePredefinedTokens = "false";
}

RULES {
	ClassInMainPackage ::= "Main";
}