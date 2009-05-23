SYNTAXDEF duplicat_tokenstyle
FOR <http://www.emftext.org/test/duplicate_tokenstyle> <duplicate_tokenstyle.genmodel>
START Root

OPTIONS {
	usePredefinedTokens = "false";
}

TOKENSTYLES {
	// here we should get a warning, because two styles refer to the same token
	"TEXT" COLOR #000000;
	"TEXT" COLOR #FF0000;
}

RULES {
	Root ::= "ROOT";
}