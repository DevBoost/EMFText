SYNTAXDEF gluetest
FOR <http://www.reuseware.org/test/gluetest>
START Root

OPTIONS {
}

TOKENS {
}

RULES {
	Root    ::= parts*;
	Pair    ::= "left" "right";
	Triple  ::= "one" "two" "three";
	Comment ::= "blah";
	NewLine ::= "NL";
}