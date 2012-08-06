@SuppressWarnings(unreachableRule)
SYNTAXDEF bug1404a
FOR <http://www.emftext.org/test/bug1404> <bug1404.genmodel>
START Root

OPTIONS {
	usePredefinedTokens = "false";
}

RULES {
	// here we should NOT get a warning about the fact that SubA (and none of
	// its subclasses) has syntax, because SubSubA is a subclass of SubA and
	// it has syntax
	Root ::= as : SubA;
	A    ::= "a";
	SubSubA ::= "subsuba";
}