SYNTAXDEF opposite
FOR <http://www.emftext.org/test/startWithoutSyntax> <startWithoutSyntax.genmodel>

// here we should get an error, because there is no syntax of
// meta class 'StartSymbolWithoutSyntax'
START StartSymbolWithSyntax, StartSymbolWithoutSyntax

OPTIONS {
	usePredefinedTokens = "false";
}

RULES {
	StartSymbolWithSyntax ::= "START";
}