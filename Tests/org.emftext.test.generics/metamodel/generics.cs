SYNTAXDEF generics
FOR <http://www.emftext.org/test/generics>
START GenericsTestModel

OPTIONS {
	licenceHeader ="../../org.dropsbox/licence.txt";

	generateUIPlugin = "false";
}

RULES {
	GenericsTestModel ::= types*;
	
	ConcreteTypeWithAttribute1 ::= "ctype1" name[];
	ConcreteTypeWithAttribute2 ::= "ctype2" name[];
	
	ConcreteTypeWithNCReference1 ::= "ncreftype1" ref[];
	ConcreteTypeWithNCReference2 ::= "ncreftype2" ref[];
	
	BasicType1 ::= "basictype1";
	BasicType2 ::= "basictype2";
	
	ConcreteTypeWithContainmentReference1 ::= "ccreftype1" ref;
	ConcreteTypeWithContainmentReference2 ::= "ccreftype1" ref : BasicType2;
}