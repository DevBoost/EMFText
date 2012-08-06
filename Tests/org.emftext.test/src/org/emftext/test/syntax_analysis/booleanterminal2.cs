SYNTAXDEF booleanterminal2
FOR <http://www.emftext.org/test/booleanterminal2> <booleanterminal2.genmodel>
START Root

OPTIONS {
	usePredefinedTokens = "false";
}

RULES {
	// here we should get an error, because the attribute 'a'
	// is boolean, but has an upper bound other than 1
	Root ::= "root" a["yes" : "no"];
}