SYNTAXDEF cardinality6
FOR <http://www.emftext.org/test/cardinality6> <cardinality6.genmodel>
START Root

OPTIONS {
	usePredefinedTokens = "false";
}

RULES {
	
	Root ::= as (bs | "keyword");
		
	A    ::= "a";

	B    ::= "b";
}