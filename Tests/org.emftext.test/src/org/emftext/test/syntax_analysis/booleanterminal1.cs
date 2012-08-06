SYNTAXDEF booleanterminal1
FOR <http://www.emftext.org/test/booleanterminal1> <booleanterminal1.genmodel>
START Root

OPTIONS {
	usePredefinedTokens = "false";
}

RULES {
	// here we should get an error, because the attribute 'a'
	// is not boolean
	Root ::= "root" a["yes" : "no"];
}