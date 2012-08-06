SYNTAXDEF unchangeable_reference
FOR <http://www.emftext.org/test/unchangeable_reference> <unchangeable_reference.genmodel>

START Root

OPTIONS {
	usePredefinedTokens = "false";
}

RULES {
	// here we should get an error, because the reference 'unchangeable'
	// is not changeable
	Root ::= "ROOT" unchangeable;
	Child ::= "CHILD";
}