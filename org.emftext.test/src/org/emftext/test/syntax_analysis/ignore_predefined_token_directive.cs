SYNTAXDEF ignore_predefined_token_directive
FOR <http://www.emftext.org/test/ignore_predefined_token_directive> <ignore_predefined_token_directive.genmodel>
START Root

TOKENS {
	// here we should NOT get any warnings - we basically sort the predefined tokens
	PREDEFINED TEXT;
	PREDEFINED WHITESPACE;
	PREDEFINED LINEBREAK;
}

RULES {
	// some syntax that uses all tokens
	Root ::= "ROOT" text[TEXT] whitespace[WHITESPACE] linebreak[LINEBREAK];
}