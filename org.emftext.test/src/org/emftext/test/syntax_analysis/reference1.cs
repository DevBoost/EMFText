SYNTAXDEF opposite
FOR <http://www.emftext.org/test/references> <references.genmodel>
START Root

OPTIONS {
	usePredefinedTokens = "false";
	defaultTokenName = "TEXT";
}

TOKENS {
	DEFINE TEXT $('a'..'z')*$;
}

RULES {
	// here we should get an error, because the type of reference 
	// 'toAbstract' is AbstractClassA, which has no concrete sub classes.
	Root ::= "ROOT" (toAbstract[])*;
}