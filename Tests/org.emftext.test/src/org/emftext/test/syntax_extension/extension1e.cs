SYNTAXDEF extension1e
FOR <http://www.emftext.org/test/extension1> <extension1.genmodel>
START Root

IMPORTS {
	imp : <http://www.emftext.org/test/extension1> <extension1.genmodel> WITH SYNTAX extension1e <extension1e_import.cs>
}

OPTIONS {
	defaultTokenName = "IDENTIFIER";
	usePredefinedTokens = "false";
}

RULES {
	// this is a check whether the default token (IDENTIFIER) that is defined in an
	// imported syntax is correctly found
	Root ::= "R" childs[];
}