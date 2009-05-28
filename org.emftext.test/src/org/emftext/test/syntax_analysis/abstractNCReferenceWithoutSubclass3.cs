SYNTAXDEF abstractNCReferenceWithoutSubclass3
FOR <http://www.emftext.org/test/abstractNCReferenceWithoutSubclass3> <abstractNCReferenceWithoutSubclass3.genmodel>
START Root

OPTIONS {
	usePredefinedTokens = "false";
}

RULES {
	// here we should get an error, because the type of NC reference 
	// 'referenceToAbstractClass' is 'AbstractClass', which has 
	// a subclass 'SubAbstractClass', but it is abstract and
	// can therefore not be used to create a proxy object.
	Root ::= "ROOT" referenceToAbstractClass['"','"'];
}