SYNTAXDEF content3
FOR <http://www.emftext.org/test/content3>
START Root

RULES {
	Root   ::= "ROOT" #1 referenceToAbstractClass;
	ConcreteClass ::= "CONCRETE";
}