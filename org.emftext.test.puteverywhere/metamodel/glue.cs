SYNTAXDEF gluetest
FOR <http://www.emftext.org/test/puteverywhere>
START Root

OPTIONS {
}

TOKENS {
}

RULES {
	Root    ::= parts*;
	Pair    ::= "left" "right";
	Triple  ::= "one" "two" "three";
	Comment ::= "COMMENT";
	NewLine ::= "NL";
}