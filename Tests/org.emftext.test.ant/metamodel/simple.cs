SYNTAXDEF simple 
FOR       <http://www.emftext.org/test/ant/simple> <simple.genmodel>
START     Root


OPTIONS {
	licenceHeader = "../../org.dropsbox/licence.txt";
}

RULES {
	Root ::= "ROOT" nodes*;
	Node ::= "NODE" (friends[])*;
}