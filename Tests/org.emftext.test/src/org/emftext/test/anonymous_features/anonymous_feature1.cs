SYNTAXDEF anonymous_feature1
FOR <http://www.emftext.org/test/anonymous_feature1> <anonymous_feature1.genmodel>
START Main

OPTIONS {
	usePredefinedTokens = "false";
}

TOKENS {
	DEFINE IDENT $('a'..'z')+$;
}

RULES {
	Main ::= "Main" _[IDENT] "End";
}