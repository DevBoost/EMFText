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

SYNTAXDEF fj 
FOR <http://www.emftext.org/language/featherweightjava>
START Class

OPTIONS {
 	licenceHeader ="../../org.dropsbox/licence.txt";
	reloadGeneratorModel = "true";
	backtracking = "true";
	memoize = "true";
	generateCodeFromGeneratorModel = "true";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
}

TOKENSTYLES {
	"class"   COLOR #7F0055, BOLD;
	"extends" COLOR #7F0055, BOLD;
	"new"     COLOR #7F0055, BOLD;
	"return"  COLOR #7F0055, BOLD;
	"this"    COLOR #7F0055, BOLD;
	"super"   COLOR #7F0055, BOLD;
}

RULES {
	Class  ::= "class" name[] "extends" superclass[] "{" 
			members* 
		"}";
		
	Constructor ::= name[] "(" (parameters ("," parameters)*)? ")" "{" 
			"super" "(" ")" ";"
			initialisations*
		"}";
		
	Parameter ::= type[] name[];
	FieldInitialisiation ::= "this" "." field[] "=" parameter[] ";";
	Method ::= returnType[] name[] "(" (parameters ("," parameters)*)? ")" "{" "return" returnValue ";" "}";
	Field  ::= type[] name[] ";";
	
	// expressions
	ConstructorCall ::= "new" type[] "(" (arguments ("," arguments)*)? ")";
	FieldAccess     ::= expression : FieldAccessChild "." field[];
	MethodCall      ::= method[] "(" ")";
	This            ::= "this";
	ParameterAccess ::= parameter[];
	Cast            ::= "(" type[] ")" expression;
}