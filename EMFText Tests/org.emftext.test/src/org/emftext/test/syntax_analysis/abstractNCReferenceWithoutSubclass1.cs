SYNTAXDEF abstractNCReferenceWithoutSubclass1
FOR <http://www.emftext.org/test/abstractNCReferenceWithoutSubclass1> <abstractNCReferenceWithoutSubclass1.genmodel>
START Root

OPTIONS {
	usePredefinedTokens = "false";
}

RULES {
	// here we should get an error, because the type of NC reference 
	// 'referenceToAbstractClass' is 'AbstractClass', which has 
	// concrete subclasses.
	Root ::= "ROOT" referenceToAbstractClass['"','"'];
}