SYNTAXDEF bug1640
// here we should get an error that the genmodel was found, but it did not
// contain the package
FOR <http://www.emftext.org/language/wrongURI> <bug1640.genmodel>
START Root

OPTIONS {
	usePredefinedTokens = "false";
}

RULES {
	Root ::= "root";
}