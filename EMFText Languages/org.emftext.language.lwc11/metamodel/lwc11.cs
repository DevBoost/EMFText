SYNTAXDEF lwc11
FOR <http://www.emftext.org/language/lwc11>
START EntityModel

OPTIONS {
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
	licenceHeader = "../../org.dropsbox/licence.txt";
}

RULES {
	EntityModel ::= ("import" imports['<','>'])* entities*;
	Entity      ::= "entity" name[] "{" features* "}";
	Feature     ::= type[] name[];
}