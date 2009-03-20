SYNTAXDEF extension1f
FOR <http://www.emftext.org/test/extension1> <extension1.genmodel>
START Root

IMPORTS {
	imp : <http://www.emftext.org/test/extension1> <extension1.genmodel> WITH SYNTAX extension1e <extension1f_import.cs>
}

OPTIONS {
	defaultTokenName = "IDENTIFIER";
	usePredefinedTokens = "false";
}

RULES {
	// this is a check whether the default token (IDENTIFIER) that is resolve in the
	// imported syntax as well
	Root ::= "R" childs[];
}