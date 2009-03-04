SYNTAXDEF java
FOR <http://www.reuseware.org/test/options>
START Dummy

OPTIONS {
	tokenspace = "1";
	autofixSimpleLeftrecursion = "false";
	forceEOF = "true"; 
	standardTextTokenName = "TEXT";
	usePredefinedTokens = "false";
}

TOKENS {
}

RULES {
	Dummy ::= "DUMMY";
}