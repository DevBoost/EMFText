SYNTAXDEF eocl
FOR <http://www.emftext.org/language/eocl> <eocl.genmodel>
START EPackage
IMPORTS {
	ecore : <http://www.eclipse.org/emf/2002/Ecore> // WITH SYNTAX ecore <../../org.emftext.language.ecore.resource.text/metamodel/text.ecore.cs>
	ocl : <http://www.tu-dresden.de/ocl20/pivot/language/ocl> <OCL.genmodel> WITH SYNTAX ocl <../../tudresden.ocl20.pivot.language.ocl/metamodel/OCL.cs>
}

OPTIONS {
	reloadGeneratorModel = "true";
	usePredefinedTokens = "false";
	overrideTextResource = "false";
	overrideManifest = "false";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
}

TOKENS {
	DEFINE T_ABSTRACT $'abstract'$;
	DEFINE T_DERIVED $'derived'$;
	DEFINE T_VOLATILE $'volatile'$;
	DEFINE T_UNIQUE $'unique'$;
	DEFINE T_ORDERED $'ordered'$;
	DEFINE T_UNSETTABLE $'unsettable'$;
	DEFINE T_UNCHANGEABLE $'unchangeable'$;
	DEFINE T_TRANSIENT $'transient'$;
	DEFINE T_ID $'iD'$;
	DEFINE T_RESOLVEPROXIES $'resolveProxies'$;
	DEFINE T_INTERFACE_OR_CLASS $'interface'|'class'$;
	DEFINE T_SERIALIZABLE $'serializable'$;
	DEFINE T_CONTAINMENT $'containment'$;

	PRIORITIZE NOT_OPERATOR;
	PRIORITIZE AND_OPERATOR;
	PRIORITIZE OR_OPERATOR;
	PRIORITIZE XOR_OPERATOR;
	PRIORITIZE IMPLIES_OPERATOR;
	PRIORITIZE BOOLEAN_LITERAL;
	PRIORITIZE COLLECTION_TYPES;
	PRIORITIZE ITERATOR_NAME;
	PRIORITIZE STATIC;
	PRIORITIZE INTEGER_0;
	PRIORITIZE INTEGER_LITERAL;
	//PRIORITIZE ocl.SIMPLE_NAME;
	//PRIORITIZE SL_COMMENT;
	//PRIORITIZE ML_COMMENT;
	DEFINE SL_COMMENT $'//'(~('\n'|'\r'|'\uffff'))* $ ;
	
	REDEFINE ocl.SL_COMMENT AS OCLSLC $ '--'(~('\n'|'\r'|'\uffff'))* $ ;
	REDEFINE ocl.ML_COMMENT AS OCLMLC $'/*'.*'*/'$ ;
	
	//REDEFINE ocl.SIMPLE_NAME AS NEWSIMPLENAME $ ('A'..'Z'|'a'..'z'|'_'|'0'..'9') ('A'..'Z'|'a'..'z'|'0'..'9'|'_')*$;
}

TOKENSTYLES {
	"T_ABSTRACT" COLOR #7F0055, BOLD;
	"T_DERIVED" COLOR #7F0055, BOLD;
	"T_VOLATILE" COLOR #7F0055, BOLD;
	"T_UNIQUE" COLOR #7F0055, BOLD;
	"T_ORDERED" COLOR #7F0055, BOLD;
	"T_UNSETTABLE" COLOR #7F0055, BOLD;
	"T_UNCHANGEABLE" COLOR #7F0055, BOLD;
	"T_TRANSIENT" COLOR #7F0055, BOLD;
	"T_ID" COLOR #7F0055, BOLD;
	"T_RESOLVEPROXIES" COLOR #7F0055, BOLD;
	"T_INTERFACE_OR_CLASS" COLOR #7F0055, BOLD;
	"T_SERIALIZABLE" COLOR #7F0055, BOLD;
	"T_CONTAINMENT" COLOR #7F0055, BOLD;
	"SL_COMMENT"  COLOR #00bb00;
	"OCLMLC"  COLOR #00bb00;
	
	"package" COLOR #7F0055, BOLD;
	"attribute" COLOR #7F0055, BOLD;
	"reference" COLOR #7F0055, BOLD;
	"operation" COLOR #7F0055, BOLD;
	"datatype" COLOR #7F0055, BOLD;
	"extends" COLOR #7F0055, BOLD;
	"opposite" COLOR #7F0055, BOLD;
}
 
RULES {
	OclAnnotation ::= "#" invariantsOrDefinitions+ "#";

	// these are copied from text.ecore.cs
	EPackage ::= (eAnnotations)* "package" #1 name[SIMPLE_NAME] (#1 nsPrefix[SIMPLE_NAME])? (#1 nsURI['"', '"'])? #1 "{" !0 ( eClassifiers )* !0 eSubpackages* "}";
	
	EClass ::=  (eAnnotations)* !1 (abstract[T_ABSTRACT] #1)? interface[T_INTERFACE_OR_CLASS] #1 
				("<" eTypeParameters ("," eTypeParameters)* ">")? 
				name[SIMPLE_NAME] 
				(#1 instanceTypeName['"','"'])? (#1 "extends" #1 eSuperTypes[SIMPLE_NAME] ("," #1 eSuperTypes[SIMPLE_NAME])*)? 
				#1 "{" ( eStructuralFeatures | eOperations )* !0"}"
				!0;
	
	EAttribute ::= !2 (eAnnotations)* (( derived[T_DERIVED]|volatile[T_VOLATILE]|unique[T_UNIQUE]|ordered[T_ORDERED]|
					unsettable[T_UNSETTABLE]|changeable[T_UNCHANGEABLE]|transient[T_TRANSIENT]|iD[T_ID]) #1)* 
				"attribute" #1 (eType[SIMPLE_NAME] | eGenericType) #1 name[SIMPLE_NAME] ("=" defaultValueLiteral['"','"'])? ( #1 "(" (lowerBound[INTEGER_LITERAL] | lowerBound[MULT_OPERATOR]) ".." (upperBound[INTEGER_LITERAL] | upperBound[MULT_OPERATOR]) ")" )? ";";
	
	EParameter ::= (eAnnotations)* ((ordered[T_ORDERED]|unique[T_UNIQUE]) #1)* eType[SIMPLE_NAME] #1 name[SIMPLE_NAME] ( #1 "(" (lowerBound[INTEGER_LITERAL] | lowerBound[MULT_OPERATOR]) ".." (upperBound[INTEGER_LITERAL] | upperBound[MULT_OPERATOR]) ")" )? ;
	
	EReference ::= (eAnnotations)* !2 (( containment[T_CONTAINMENT]|derived[T_DERIVED]|transient[T_TRANSIENT]
							|volatile[T_VOLATILE]|unique[T_UNIQUE]|ordered[T_ORDERED]
							|unsettable[T_UNSETTABLE]|changeable[T_UNCHANGEABLE]|resolveProxies[T_RESOLVEPROXIES]) #1)* 
					"reference" #1 (eType[SIMPLE_NAME] | eGenericType) #1 name[SIMPLE_NAME] ("=" defaultValueLiteral['"','"']) ?
					( #1 "(" (lowerBound[INTEGER_LITERAL] | lowerBound[MULT_OPERATOR]) ".." (upperBound[INTEGER_LITERAL] | upperBound[MULT_OPERATOR]) ")" )?  (#1 "opposite" #1 eOpposite[SIMPLE_NAME])?";";
	
	EOperation ::=  (eAnnotations)* !2
				(( ordered[T_ORDERED]|unique[T_UNIQUE]) #1)* 
				"operation" #1  ("void" | eType[SIMPLE_NAME]) 
				( #1 "(" (lowerBound[INTEGER_LITERAL] | lowerBound[MULT_OPERATOR]) ".." (upperBound[INTEGER_LITERAL] | upperBound[MULT_OPERATOR]) ")" )? #1 
				("<" eTypeParameters ("," eTypeParameters)* ">")? 
				name[SIMPLE_NAME] #1 
				"(" (eParameters ("," #1 eParameters)* )? ")"
				("throws" #1 eExceptions[SIMPLE_NAME] ("," #1 eExceptions[SIMPLE_NAME])*)? ";";
	
	EEnum ::=  (eAnnotations)* !2 (serializable[T_SERIALIZABLE] #1)? "enum" #1 name[SIMPLE_NAME] #1 instanceTypeName['"','"']?
					#1 "{" (eLiterals)* !0 "}" 
					!0 ; 

	EEnumLiteral ::=  (eAnnotations)* !3 value[INTEGER_LITERAL] #1 ":" #1 name[SIMPLE_NAME] #1 "=" #1 literal['"','"']  ";";


	EAnnotation ::= !1 "@" source['"','"'] ("(" details ("," #1 details)* ")")?;
	
	EStringToStringMapEntry ::= key['"','"'] "=" value['"','"'];
	
	EDataType ::= (eAnnotations)* (serializable[T_SERIALIZABLE])? "datatype" #1 name[SIMPLE_NAME] #1 instanceTypeName['"','"'];
	
	ETypeParameter ::= (eAnnotations)* name[SIMPLE_NAME];
	
	EGenericType ::=
		"typed"  
		("<" (eTypeParameter[SIMPLE_NAME] | "?" #1 "extends" #1 eUpperBound | "?" #1 "super" #1 eLowerBound) ">")?
		eClassifier[SIMPLE_NAME] 
		("<" (eTypeArguments | "?") ("," (eTypeArguments | "?"))* ">")?
		;
}