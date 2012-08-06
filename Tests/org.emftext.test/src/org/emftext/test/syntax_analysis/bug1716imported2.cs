SYNTAXDEF bug1716imported2
FOR <http://www.emftext.org/test/bug1716imported> <bug1716imported.genmodel>
START ImportedClass

OPTIONS {
	usePredefinedTokens = "false";
}

TOKENS {
	DEFINE T1 $'a''b'$;
	DEFINE T2 $'a''b'('c')*$;
}

RULES {
	ImportedClass ::= "imported";
}