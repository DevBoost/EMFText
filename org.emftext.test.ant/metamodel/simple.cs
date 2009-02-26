SYNTAXDEF simple 
FOR       <http://www.emftext.org/test/ant/simple> <simple.genmodel>
START     Root

TOKENS {
}

RULES {
	Root ::= "ROOT" nodes*;
	Node ::= "NODE" (friends[])*;
}