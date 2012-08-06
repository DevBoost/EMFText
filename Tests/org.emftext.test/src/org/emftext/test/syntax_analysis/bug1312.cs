SYNTAXDEF bug1312
FOR <http://www.emftext.org/test/bug1312> <bug1312.genmodel>
START Root

OPTIONS {
	usePredefinedTokens = "false";
}

RULES {
	// here we should not get a warning about the minimal cardinality of
	// feature a, because the alternative lower the minimal cardinality
	//
	// we do however get a warning about the fact that explicit alternatives
	// are not represented in models
	Root ::= blist+ | clist+;
	B    ::= "b";
	C    ::= "c";
}