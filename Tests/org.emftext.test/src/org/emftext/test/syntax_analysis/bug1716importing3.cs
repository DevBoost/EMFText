SYNTAXDEF bug1716importing3
FOR <http://www.emftext.org/test/bug1716importing> <bug1716importing.genmodel>
START ImportingClass

IMPORTS {
	@SuppressWarnings(tokenOverlapping)
	imported : <http://www.emftext.org/test/bug1716imported> <bug1716imported.genmodel>
	WITH SYNTAX bug1716imported2 <bug1716imported2.cs>
}

OPTIONS {
	usePredefinedTokens = "false";
}

RULES {
	ImportingClass ::= "importing" imported*;
}