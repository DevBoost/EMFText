SYNTAXDEF tests 
FOR <http://www.emftext.org/test>
START Container  


IMPORTS {
  ecore : <http://www.eclipse.org/emf/2002/Ecore> 
   WITH SYNTAX text.ecore <platform:/resource/
   	org.emftext.language.ecore.resource.text/metamodel/text.ecore.cs>
}

OPTIONS {
	reloadGeneratorModel = "true";
	usePredefinedTokens = "false";
}

RULES {
	Container ::= "c" classifiers*;
}