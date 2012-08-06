SYNTAXDEF ignore_predefined_token_directive
FOR <http://www.emftext.org/test/ignore_predefined_token_directive> <ignore_predefined_token_directive.genmodel>
START Root

RULES {
	// some syntax that uses all tokens
	Root ::= "ROOT" text[TEXT] whitespace[WHITESPACE] linebreak[LINEBREAK];
}