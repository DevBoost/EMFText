SYNTAXDEF main
FOR <http://www.emftext.org/test/main> <main.genmodel>
START ClassInMainPackage

IMPORTS {
	imported : <http://www.emftext.org/test/imported> <imported.genmodel> 
}

OPTIONS {
	usePredefinedTokens = "false";
}

RULES {
	ClassInMainPackage ::= "Main";
	// here is the prefix used
	imported.ClassInImportedPackage ::= "Main";
}