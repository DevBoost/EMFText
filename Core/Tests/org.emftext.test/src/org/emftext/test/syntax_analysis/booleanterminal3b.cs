SYNTAXDEF booleanterminal3
FOR <http://www.emftext.org/test/booleanterminal3> <booleanterminal3.genmodel>
START Root

OPTIONS {
	usePredefinedTokens = "false";
}

RULES {
	// here we should get an error, because both literals are empty
	Root ::= "root" a["" : ""];
}