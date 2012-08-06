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

SYNTAXDEF customer
FOR <http://www.emftext.org/language/customer>
START Customer

OPTIONS {
 	licenceHeader ="../../org.dropsbox/licence.txt";
	reloadGeneratorModel = "true";
	generateCodeFromGeneratorModel = "true";
	tokenspace = "1";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
}

TOKENS {
	DEFINE T_VEGETARIAN $'vegetarian'$;
}

TOKENSTYLES {
	"CUSTOMER" COLOR #009bd3, BOLD;
	"WANTS" COLOR #009bd3, BOLD;
	"SOMETHING" COLOR #009bd3, BOLD;
	"TEXT" COLOR #202020;
}

RULES {
	Customer ::= "CUSTOMER" name ("(" isVegetarian ")")? "WANTS" requests*;
	ExtraIngredient ::= name;
	IsVegetarian ::= value[T_VEGETARIAN];
	Name ::= value[];
}