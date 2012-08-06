//*******************************************************************************
// Copyright (c) 2006-2011 
// Software Technology Group, Dresden University of Technology
// 
// All rights reserved. This program and the accompanying materials
// are made available under the terms of the Eclipse Public License v1.0 
// which accompanies this distribution, and is available at
// http://www.eclipse.org/legal/epl-v10.html
// 
// Contributors:
//   Software Technology Group - TU Dresden, Germany 
//      - initial API and implementation
// ******************************************************************************/

SYNTAXDEF text.ecore
FOR       <http://www.eclipse.org/emf/2002/Ecore>
START     EPackage

OPTIONS {
 	licenceHeader ="../../org.dropsbox/licence.txt";
	
	resourcePluginID = "org.emftext.language.ecore.resource.text";
	basePackage = "org.emftext.language.ecore.resource.text";
	resourceUIPluginID = "org.emftext.language.ecore.resource.text.ui";
	uiBasePackage = "org.emftext.language.ecore.resource.text.ui";

	baseResourcePlugin = "org.emftext.language.ecore.resource";
	
	usePredefinedTokens = "false";
	saveChangedResourcesOnly = "true";
	overrideManifest = "false";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
}

TOKENS {
	DEFINE SL_COMMENT $'//'(~('\n'|'\r'|'\uffff'))* $ ;
	DEFINE ML_COMMENT $'/*'.*'*/'$ ;

	DEFINE STRING_LITERAL $'"'('\\'('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')|('\\''u'('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F'))|'\\'('0'..'7')|~('\\'|'"'))*'"'$;
	
	DEFINE WHITESPACE $(' '|'\t'|'\f')$;
	DEFINE LINEBREAKS $('\r\n'|'\r'|'\n')$;
		
	DEFINE TEXT $('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' | '::')+$;
}

TOKENSTYLES {
	"TEXT" COLOR #000000;
	
	"abstract", "derived", "volatile", "ununique", "unordered",
	"unsettable", "unchangeable", "transient", "iD",
	"notResolveProxies", "interface", "class", "serializable", 
	"containment" COLOR #7F0055, BOLD;
	
	"SL_COMMENT", "ML_COMMENT" COLOR #00bb00;
	
	"STRING_LITERAL" COLOR #2A00FF;
	
	"package", "attribute", "reference", "operation",
	"datatype", "extends", "opposite" COLOR #7F0055, BOLD;
}
 
RULES {
	EPackage ::= (eAnnotations)* "package" #1 name[] (#1 nsPrefix[])? (#1 nsURI[STRING_LITERAL])? #1 "{" !0 ( eClassifiers )* !0 eSubpackages* "}";
	
	EClass ::=  (eAnnotations)* !1 
				(abstract["abstract" : ""] #1)? 
				interface["interface" : "class"] #1 
				("<" eTypeParameters ("," eTypeParameters)* ">")? 
				name[] 
				(#1 instanceTypeName[STRING_LITERAL])? (#1 "extends" #1 eSuperTypes[] ("," #1 eSuperTypes[])*)? 
				#1 "{" ( eStructuralFeatures | eOperations )* !0"}"
				!0;
	
	EAttribute ::= !2 (eAnnotations)* 
					(
					(derived["derived" : ""] |
					 volatile["volatile" : ""] |
					 unique["" : "ununique"] |
					 ordered["" : "unordered"]|
					 unsettable["unsettable" : ""] |
					 changeable["" : "unchangeable"] |
					 transient["transient" : ""] | 
					 iD["iD" : ""]) #1
					)* 
					"attribute" #1 (eType[] | eGenericType) #1 name[] ("=" defaultValueLiteral[STRING_LITERAL])? ( #1 "(" lowerBound[] ".." upperBound[] ")" )? ";";
	
	EParameter ::= 	(eAnnotations)*
					(
					(ordered["" : "unordered"] |
					 unique["" : "ununique"]
					) #1
					)* 
					eType[] #1 name[] ( #1 "(" lowerBound[] ".." upperBound[] ")" )? ;
	
	EReference ::= 	(eAnnotations)* !2 
					(
					(containment["containment" : ""] | 
					 derived["derived" : ""] |
					 transient["transient" : ""] |
					 volatile["volatile" : ""] |
					 unique["" : "ununique"] |
					 ordered["" : "unordered"] |
					 unsettable["unsettable" : ""] | 
					 changeable["" : "unchangeable"] |
					 resolveProxies["" : "notResolveProxies"]
					) #1
					)* 
					"reference" #1 (eType[] | eGenericType) #1 name[] ("=" defaultValueLiteral[STRING_LITERAL]) ?
					( #1 "(" lowerBound[] ".." upperBound[] ")" )?  (#1 "opposite" #1 eOpposite[])?";";
	
	EOperation ::=  (eAnnotations)* !2
					(
					(ordered["" : "unordered"] |
					unique["" : "ununique"]
					) #1
					)* 
				"operation" #1  ("void" | eType[]) 
				( #1 "(" lowerBound[] ".." upperBound[] ")" )? #1 
				("<" eTypeParameters ("," eTypeParameters)* ">")? 
				name[] #1 
				"(" (eParameters ("," #1 eParameters)* )? ")"
				("throws" #1 eExceptions[] ("," #1 eExceptions[])*)? ";";
	
	EEnum ::=  (eAnnotations)* !2 (serializable["serializable" : ""] #1)? "enum" #1 name[] #1 instanceTypeName[STRING_LITERAL]?
					#1 "{" (eLiterals)* !0 "}" 
					!0 ; 

	EEnumLiteral ::=  (eAnnotations)* !3 value[] #1 ":" #1 name[] #1 "=" #1 literal[STRING_LITERAL]  ";";


	EAnnotation ::= !1 "@" source[STRING_LITERAL] ("(" details ("," #1 details)* ")")?;
	
	EStringToStringMapEntry ::= key[STRING_LITERAL] "=" value[STRING_LITERAL];
	
	EDataType ::= (eAnnotations)* (serializable["serializable" : ""])? "datatype" #1 name[] #1 instanceTypeName[STRING_LITERAL];
	
	ETypeParameter ::= (eAnnotations)* name[];
	
	EGenericType ::=
		"typed"  
		("<" (eTypeParameter[] | "?" #1 "extends" #1 eUpperBound | "?" #1 "super" #1 eLowerBound) ">")?
		eClassifier[] 
		("<" (eTypeArguments | "?") ("," (eTypeArguments | "?"))* ">")?
		;
}
