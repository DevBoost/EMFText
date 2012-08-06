ABSTRACT SYNTAXDEF abstractNCReferenceWithoutSubclass2
FOR <http://www.emftext.org/test/abstractNCReferenceWithoutSubclass2> <abstractNCReferenceWithoutSubclass2.genmodel>

OPTIONS {
	usePredefinedTokens = "false";
}

RULES {
	// here we should NOT get an error. The type of NC reference 
	// 'referenceToAbstractClass' is 'AbstractClass', which has 
	// concrete subclasses, which normally causes an error, but
	// since this syntax is abstract it is ok.
	Root ::= "ROOT" referenceToAbstractClass['"','"'];
}