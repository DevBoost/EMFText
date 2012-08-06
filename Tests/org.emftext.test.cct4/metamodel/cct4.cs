SYNTAXDEF cct4
FOR <http://www.emftext.org/test/cct4>
START Root1, Root2, Root3, Root4


OPTIONS {
	licenceHeader = "../../org.dropsbox/licence.txt";
}

RULES {
	// a test for nest containers without syntax at the head of the syntax rules
	Root1       ::= "ROOT1" name[] child;
	Child       ::= subChild;
	SubChild    ::= subSubChild;
	SubSubChild ::= root[];

	Root2       ::= "ROOT2" children*;
	Target      ::= "TARGET" name[];
	Reference   ::= "REFERENCE" reference[];

	// a test for resolving nc-references in quoted tokens
	Root3       ::= "ROOT3" targets+ reference['<','>'];

	// a test for resolving enumerations in quoted tokens
	Root4       ::= "ROOT4" enumAttribute['<','>'];
}