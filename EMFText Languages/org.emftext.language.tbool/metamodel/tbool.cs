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

SYNTAXDEF tbool
FOR <http://www.emftext.org/language/tbool>
START ClassTemplate

IMPORTS {
	bool : <http://www.emftext.org/language/bool> <../../org.emftext.language.bool/metamodel/bool.genmodel> 
		WITH SYNTAX bool <../../org.emftext.language.bool/metamodel/bool.cs>
}

OPTIONS {	
	licenceHeader ="../../org.dropsbox/licence.txt";
	usePredefinedTokens = "false";
	generateCodeFromGeneratorModel = "true";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
}

TOKENSTYLES {
	"class" COLOR #7F0055, BOLD;
	"void" COLOR #7F0055, BOLD;
	"<%TEMPLATE" COLOR #C00000, BOLD; 
	"INPUT=" COLOR #C00000, BOLD;
	"<%IF" COLOR #C00000, BOLD;
	"<%FOR" COLOR #C00000, BOLD;
	"<%=" COLOR #C00000, BOLD;
	"%>" COLOR #C00000, BOLD;
	"<%ENDFOR%>" COLOR #C00000, BOLD;
	"<%ENDIF%>" COLOR #C00000, BOLD;
	"COMMENT" COLOR #00A000, ITALIC;
}

RULES {
	ClassTemplate ::= "<%TEMPLATE" "INPUT=" inputMetaClass['"','"'] "%>" body;
	PhNamedElementName ::= "<%=" expression['"','"'] "%>";
	IfClassMembers ::= "<%IF" expression['"','"'] "%>" body "<%ENDIF%>";
	ForClassMembers ::= "<%FOR" (variable[] ":")? expression['"','"'] "%>" body+ "<%ENDFOR%>";
}