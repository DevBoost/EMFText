SYNTAXDEF resolving
FOR <http://www.emftext.org/test/resolving>
START Object, Import

OPTIONS {
	licenceHeader ="../../org.dropsbox/licence.txt";
	
	generateUIPlugin = "false";
}

RULES {
	Object ::= "object" id[] number[] 
	           ("->" ref[])?       // this reference uses the default resolver
	           ("=>" customRef[])? // this reference uses a custom resolver
	           "{" children* "}";
	Import ::= "import" importedObject['<','>'] children*;
	
	EcoreImport ::= "ecoreimport" ePackage['<','>'];

	GenModelImport ::= "genmodelimport" genModel['<','>'];
}