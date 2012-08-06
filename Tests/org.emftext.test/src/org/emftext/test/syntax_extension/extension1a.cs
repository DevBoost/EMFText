SYNTAXDEF extension1a
FOR <http://www.emftext.org/test/extension1> <extension1.genmodel>
START Root

RULES {
	// here we check whether the reference to the default token is added correctly
	Root  ::= "ROOT" childs[]*;
	Child ::= "C";
}