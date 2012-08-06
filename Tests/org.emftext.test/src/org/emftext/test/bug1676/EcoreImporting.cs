SYNTAXDEF importing
FOR <http://emftext.org/language/ecoreimporting>
START SubEPackage

IMPORTS {
  ecore : <http://www.eclipse.org/emf/2002/Ecore> 
   WITH SYNTAX forEcore <forEcore.cs>
} 


TOKENS {
} 

RULES {
   @SuppressWarnings 
   SubEPackage ::= "SubEPackage" 
		eClassifiers
		;
}