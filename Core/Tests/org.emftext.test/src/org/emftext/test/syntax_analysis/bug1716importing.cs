SYNTAXDEF bug1716importing
FOR <http://www.emftext.org/test/bug1716importing> <bug1716importing.genmodel>
START ImportingClass

IMPORTS {
	imported : <http://www.emftext.org/test/bug1716imported> <bug1716imported.genmodel>
	WITH SYNTAX bug1716imported <bug1716imported.cs>
}

OPTIONS {
	usePredefinedTokens = "false";
}

RULES {
	ImportingClass ::= "importing" imported*;
}