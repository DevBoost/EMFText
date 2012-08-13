ABSTRACT SYNTAXDEF abstractNCReferenceWithoutSubclass1
FOR <http://www.emftext.org/test/abstractNCReferenceWithoutSubclass1> <abstractNCReferenceWithoutSubclass1.genmodel>
START Root

OPTIONS {
	usePredefinedTokens = "false";
}

RULES {
    Root ::= "ROOT" referenceToAbstractClass['"','"'];

}