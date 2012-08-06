//*******************************************************************************
// Copyright (c) 2006-2010 
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
@SuppressWarnings(featureWithoutSyntax)
SYNTAXDEF rolecore
FOR <http://www.emftext.org/language/rolecore>
START RCPackage

OPTIONS {
	licenceHeader ="platform:/resource/org.reuseware/licence.txt";
	overrideBuilder = "false";
	//additionalDependencies = "org.emftext.language.rolecore.ecore_compiler";
	usePredefinedTokens = "false";
	defaultTokenName = "IDENTIFIER";
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
	DEFINE T_CHANGEABLE $'changeable'$;
	DEFINE T_TRANSIENT $'transient'$;
	DEFINE T_ID $'iD'$;
	DEFINE T_CONTAINMENT $'containment'$;
	DEFINE T_RESOLVEPROXIES $'resolveProxies'$;
	DEFINE COMMENT $'//'(~('\n'|'\r'|'\uffff'))*$;
	
	//DEFINE REFTYPE $'type:'(('A'..'Z'|'a'..'z'|'0'..'9'|'_')+'->')?('A'..'Z'|'a'..'z'|'0'..'9'|'-'|'_')+$;

	DEFINE INTEGER $('0'..'9')+|'*'$;
	DEFINE IDENTIFIER $('A'..'Z'|'a'..'z'|'_')('A'..'Z'|'a'..'z'|'_'|'-'|'0'..'9')*('.'('A'..'Z'|'a'..'z'|'_'|'-'|'0'..'9')+)*$;
	DEFINE WHITESPACE $(' '|'\t'|'\f')$;
	DEFINE LINEBREAK $('\r\n'|'\r'|'\n')$;
}

TOKENSTYLES {
	// keywords
	"RCPackage", "Natural", "Role",
	"reference", "extends", "attribute", "operation", "void", "opposite", "throws",

	// boolean modifiers
	"T_ABSTRACT",
	"T_DERIVED",
	"T_VOLATILE",
	"T_UNIQUE",
	"T_ORDERED",
	"T_UNSETTABLE",
	"T_CHANGEABLE",
	"T_TRANSIENT",
	"T_ID",
	"T_CONTAINMENT",
	"T_RESOLVEPROXIES" COLOR #00b4dd, BOLD;

	"QUOTED_34_34" COLOR #9d9d9d;
	"COMMENT" COLOR #008000;
}

RULES {
	RCPackage ::= 
		"RCPackage" name[] 
		(#1 nsPrefix[])? (#1 nsURI['"', '"'])? !0
		("Imports" "{" !0 (imports)+ !0	"}")? #1
		"{"
			naturals* 
			roles*
		"}";
	
	Import ::= "prefix" ":" prefix[] #1 importedPackage['<','>'] ( #1 rcPackageLocationHint['<','>'])?;
	
	@Foldable
	RoleType      ::= 
		"Role" name[] ( "(" lowerBound[INTEGER] ".." upperBound[INTEGER] ")" )?
		"{" ( eStructuralFeatures | eOperations )* !0 "}";
	
	@Foldable	
	NaturalType ::= 
		"Natural" name[] (#1 "extends" #1 eSuperTypes[] )? #1
		"{" ( eStructuralFeatures | eOperations )* !0 "}";

	EAttribute ::= 
		(
			derived[T_DERIVED] | 
			volatile[T_VOLATILE] |
			unique[T_UNIQUE] |
			ordered[T_ORDERED] |
			unsettable[T_UNSETTABLE] | 
			changeable[T_CHANGEABLE] | 
			transient[T_TRANSIENT] | 
			iD[T_ID] 
		#1)* 
		"attribute" #1 eType[] #1 name[] ( #1 "(" lowerBound[INTEGER] ".." upperBound[INTEGER] ")" )? ";";
	
	EParameter ::= 
		//(eAnnotations)* 
		(
			ordered[T_ORDERED] |
			unique[T_UNIQUE]
		#1)* eType[] #1 name[] ( #1 "(" lowerBound[INTEGER] ".." upperBound[INTEGER] ")" )? ;
	
	EReference ::= 
		(
			containment[T_CONTAINMENT] |
			derived[T_DERIVED] |
			transient[T_TRANSIENT] |
			volatile[T_VOLATILE] |
			unique[T_UNIQUE] |
			ordered[T_ORDERED] |
			unsettable[T_UNSETTABLE] |
			changeable[T_CHANGEABLE] |
			resolveProxies[T_RESOLVEPROXIES]
		)* 
		"reference" #1 eType[] name[]  
		( #1 "(" lowerBound[INTEGER] ".." upperBound[INTEGER] ")" )?  (#1 "opposite" #1 eOpposite[])? ";";
	
	EOperation ::=
		(
			ordered[T_ORDERED] |
			unique[T_UNIQUE]
		#1 )*  
		"operation" #1 ("void" | eType[]) 
		( #1 "(" lowerBound[INTEGER] ".." upperBound[INTEGER] ")" )? #1 
		//("<" eTypeParameters ("," eTypeParameters)* ">")? 
		name[] #1 
		"(" (eParameters ("," #1 eParameters)* )? ")"
		("throws" #1 eExceptions[] ("," #1 eExceptions[])*)? ";";
}