SYNTAXDEF bug1709
FOR <http://www.emftext.org/test/bug1709>
START Root

OPTIONS {
	generateUIPlugin = "false";
	licenceHeader = "../../org.dropsbox/licence.txt";
}

RULES {
	Root ::= "root" elements*;
	TypeA ::= "typeA" name[];
	TypeB ::= "typeB" name['"','"'];
	TypeC ::= "typeC" name[] att[_IN : "in", OUT : "out"];
}