SYNTAXDEF lwc11
FOR <http://www.emftext.org/language/lwc11>
START EntityModel

RULES {
	EntityModel ::= ("import" imports['<','>'])* entities*;
	Entity      ::= "entity" name[] "{" features* "}";
	Feature     ::= type[] name[];
}