SYNTAXDEF myFileExtension
FOR <http://www.some-domain.org/myLanguage> <optional/path/to/myLanguage.genmodel>
START StartMetaClass

OPTIONS {
	reloadGeneratorModel = "true";
}

RULES {
	// syntax definition for class 'StartMetaClass'
	StartMetaClass   ::= "myKeyword" attributeOfStartMetaClass[] aContainmentReference* ;
	
	// syntax definition for class 'AnotherMetaClass'
	AnotherMetaClass ::= "otherKeyword" aNonContainmentReference[];
}