SYNTAXDEF main
FOR <http://www.emftext.org/test/main> <main.genmodel>
START ClassInMainPackage

OPTIONS {
	usePredefinedTokens = "false";
}

RULES {
	ClassInMainPackage ::= "Main";
}