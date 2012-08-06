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

SYNTAXDEF bool // == Basic Object-Oriented Language
FOR <http://www.emftext.org/language/bool>
START Class

OPTIONS {
 	licenceHeader ="../../org.dropsbox/licence.txt";
	reloadGeneratorModel = "true";
	generateCodeFromGeneratorModel = "true";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
}

TOKENS {
	DEFINE COMMENT $'//'(~('\n'|'\r'))*$;
}

TOKENSTYLES {
	"class" COLOR #7F0055, BOLD;
	"void" COLOR #7F0055, BOLD;
}

RULES {
	Class  ::= "class" name "{" members* "}";

	Field  ::= type[] name ";";

	Method ::= "void" name "(" ")" "{" "}";

	Name ::= value[];
}