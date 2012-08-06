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

SYNTAXDEF formsfamily
FOR <http://www.emftext.org/language/formsfamily>
START Form

OPTIONS {
	licenceHeader ="../../org.dropsbox/licence.txt";
	
	overrideBuilder = "false";
	additionalDependencies = "org.emftext.language.forms.generator";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
}

TOKENS {
	DEFINE MULTIPLE $'multiple'|'MULTIPLE'$;
}

TOKENSTYLES {
	"TEXT" COLOR #da0000;
	"FORM", "ITEM", "CHOICE", "DATE", "FREETEXT", "NUMBER", "DECISION", "GROUP" COLOR #000000, BOLD;
	"ONLY", "IF" COLOR #da0000, BOLD;
}

RULES {
	Form      ::= "FORM" caption['"','"'] !1 groups+;
	Group     ::= !0 "GROUP" name['"','"'] !0 items+;
	BasicItem ::= "ITEM" text['"','"'] ( explanation['"','"'] )? 
				  ("ONLY" "IF" dependentOf[])? ":" 
				  itemType !0;
	Choice    ::= "CHOICE" (multiple[MULTIPLE])? "(" options ("," options)* ")";
	Option    ::= ( id[] ":")? text['"','"'];
	Date      ::= "DATE";
	FreeText  ::= "FREETEXT";
	Number    ::= "NUMBER";
	Decision  ::= "DECISION" "(" options "," options ")"; 
	LikertScale  ::= "LIKERTSCALE" text['"','"'] ( explanation['"','"'] )?
	                 "(" options ("," options)* ")";
	GuttmanScale ::= "GUTTMANSCALE" text['"','"'] ( explanation['"','"'] )?
	                 "(" options ("," options)* ")";
}