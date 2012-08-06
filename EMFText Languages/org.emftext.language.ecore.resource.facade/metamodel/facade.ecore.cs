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

SYNTAXDEF facade.ecore
FOR       <http://www.eclipse.org/emf/2002/Ecore>
START     EPackage

OPTIONS {
 	licenceHeader ="../../org.dropsbox/licence.txt";
	//memoize = "true";
	//tokenspace = "1";
	resourcePluginID = "org.emftext.language.ecore.resource.facade";
	basePackage = "org.emftext.language.ecore.resource.facade";
	resourceUIPluginID = "org.emftext.language.ecore.resource.facade.ui";
	uiBasePackage = "org.emftext.language.ecore.resource.facade.ui";
	
	baseResourcePlugin = "org.emftext.language.ecore.resource";
	saveChangedResourcesOnly = "true";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
}

TOKENS {
	DEFINE SL_COMMENT $'//'(~('\n'|'\r'|'\uffff'))* $ ;
	DEFINE ML_COMMENT $'/*'.*'*/'$ ;

	DEFINE T_INTERFACE_OR_CLASS $'interface'|'class'$;
}

TOKENSTYLES {
	"TEXT" COLOR #000000;
	
	"SL_COMMENT"  COLOR #00bb00;
	"ML_COMMENT"  COLOR #00bb00;
	
	"T_INTERFACE_OR_CLASS" COLOR #7F0055, BOLD;
	"annotate" COLOR #7F0055, BOLD;
	"package" COLOR #7F0055, BOLD;
	"attribute" COLOR #7F0055, BOLD;
	"reference" COLOR #7F0055, BOLD;
	"operation" COLOR #7F0055, BOLD;
	"datatype" COLOR #7F0055, BOLD;
}
 
RULES {
	EPackage ::= "annotate" #1 nsURI['"', '"'] #1
	(eAnnotations)* "package" name[] "{" ( eClassifiers )* eSubpackages* !0 "}";
	
	EClass ::=  (eAnnotations)* !1 interface[T_INTERFACE_OR_CLASS] 
				#1 name[] 
				#1 "{" ( eStructuralFeatures | eOperations )* !1"}"
				!0;	
				
	EAttribute ::= (eAnnotations)*
				   !2 "attribute" #1 name[] ";";
	
	EParameter ::= (eAnnotations)* name[];
	
	EReference ::= (eAnnotations)* 
					!2 "reference" #1 name[] ";";
	
	EOperation ::= (eAnnotations)* !2 "operation" #1
				name[] 
				"(" (eParameters ("," #1 eParameters)* )? ")" ";";
	
	EEnum ::=  (eAnnotations)* !2 "enum" #1 name[]
					#1 "{" (eLiterals)* !0 "}" 
					; 

	EEnumLiteral ::= !3 (eAnnotations)* name[] ";";


	EAnnotation ::= !1 "@" source['"','"'] ("(" details ("," #1 details)* ")")? ;
	
	EStringToStringMapEntry ::= key['"','"'] "=" value['"','"'];
	
	EDataType ::= (eAnnotations)* "datatype" name[] ";";
	
	//TODO reintegrate type parameters
}
