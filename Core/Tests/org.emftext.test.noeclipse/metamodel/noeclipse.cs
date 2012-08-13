SYNTAXDEF noeclipse
FOR <http://www.emftext.org/language/noeclipse>
START Root

OPTIONS {
	licenceHeader ="../../org.dropsbox/licence.txt";
	
	removeEclipseDependentCode = "true";
	generateUIPlugin = "false";
}

RULES {
	Root ::= "root";
}