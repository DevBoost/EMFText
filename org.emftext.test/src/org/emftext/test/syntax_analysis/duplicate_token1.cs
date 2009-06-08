SYNTAXDEF duplicate_token1
FOR <http://www.emftext.org/test/duplicate_token1> <duplicate_token1.genmodel>
START ClassInMainModel

IMPORTS {
	duplicate_token1_super : <http://www.emftext.org/test/duplicate_token1_super> <duplicate_token1_super.genmodel> WITH SYNTAX duplicate_token1_super <duplicate_token1_super.cs>
}

RULES {
	ClassInMainModel ::= "CIMM" name[] whitespace[WHITESPACE] linebreak[LINEBREAK];
}