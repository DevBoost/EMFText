SYNTAXDEF booleanterminal3
FOR <http://www.emftext.org/test/booleanterminal3> <booleanterminal3.genmodel>
START Root

OPTIONS {
	usePredefinedTokens = "false";
}

RULES {
	// here we should get an error, because the boolean terminal
	// refers to the anonymous feature
	Root ::= "root" a['"','"'] _["" : ""];
}