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

SYNTAXDEF sandwich
FOR <http://www.emftext.org/language/sandwich>
START Recipe

OPTIONS {	
	licenceHeader ="../../org.dropsbox/licence.txt";
	reloadGeneratorModel = "true";
	generateCodeFromGeneratorModel = "true";
	tokenspace = "1";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
}

TOKENSTYLES {
	"RECIPE" COLOR #000000, BOLD;
	"TOAST" COLOR #9d3838, BOLD;
	"ADD" COLOR #008000, BOLD;
	"CLEAN" COLOR #009bd3, BOLD;

	"TEXT" COLOR #000000;
}

RULES {
	Recipe ::= "RECIPE" name[] ingredients* !0 instructions ("," !0 instructions)*;
	Ingredient ::= name;
	IngredientName ::= value[];
	Clean ::= "CLEAN" using[]?;
	Add ::= "ADD" using[]?;
	Toast ::= "TOAST" using[]?;
}