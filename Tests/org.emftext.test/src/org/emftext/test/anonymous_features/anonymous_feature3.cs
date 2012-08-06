SYNTAXDEF anonymous_feature2
FOR <http://www.emftext.org/test/anonymous_feature1> <anonymous_feature1.genmodel>
START Main

OPTIONS {
	usePredefinedTokens = "false";
}

TOKENS {
	DEFINE IDENT $('a'..'z')+$;
	DEFINE NUMBER $('0'..'9')+$;
}

RULES {
	// here the anonymous feature is used in an explicit syntax choice
	Main ::= "Main" (_[IDENT] | _[NUMBER]) "End";
}