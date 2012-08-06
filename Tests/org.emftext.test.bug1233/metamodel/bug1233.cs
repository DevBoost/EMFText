SYNTAXDEF bug1233
FOR <http://www.emftext.org/test/bug1233>
START Root

OPTIONS {
	generateUIPlugin = "false";
	licenceHeader = "../../org.dropsbox/licence.txt";
}

RULES {
	Root ::= "Root" reference[];
}