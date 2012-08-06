SYNTAXDEF bug1193
FOR <http://www.emftext.org/language/bug1193> <bug1193.genmodel>
START Root

OPTIONS {
	usePredefinedTokens = "false";
}

RULES {
	// here we should get a warning about left recursion, because the
	// type of 'containment' is 'SuperClass', which is a superclass of
	// 'Root'
	Root ::= !1 containment !0 (!1 containment )* !0;
}