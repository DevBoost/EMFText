//*******************************************************************************
// Copyright (c) 2006-2012 
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

SYNTAXDEF quml 
FOR <http://www.eclipse.org/uml2/4.0.0/UML>
START Model
 
OPTIONS {	
	licenceHeader ="../../org.dropsbox/licence.txt";
 	resourcePluginID = "org.emftext.language.quickuml.resource.quml";
	basePackage = "org.emftext.language.quickuml.resource.quml";
 	resourceUIPluginID = "org.emftext.language.quickuml.resource.quml.ui";
	uiBasePackage = "org.emftext.language.quickuml.resource.quml.ui";
	tokenspace = "1";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
}

TOKENSTYLES {
	"m" COLOR #000000, BOLD;
	"p" COLOR #000000, BOLD;
	"c" COLOR #000000, BOLD;
	"o" COLOR #000000, BOLD;
	"a" COLOR #000000, BOLD;
	"TEXT" COLOR #0000A0, BOLD;
}

RULES {
	
	Model ::= "m" name[] "{" (!1 packagedElement)* !0 "}";

	Package ::= "p" name[] "{" (!1 packagedElement)* !0 "}";

	Class ::= "c" name[] "{" ( !1 (ownedAttribute | ownedOperation))* !0 "}";

	Operation ::= "o" name[] "(" #0 (ownedParameter #0 ("," ownedParameter)*)? #0 ")";

	Property ::= "a" name[] ":" type[] (lower[] ".." upper[])?; 

	Parameter ::= "p" name[] ":" type[];
	
	Association ::= "a" name[] "{" ownedEnd ownedEnd "}";
}