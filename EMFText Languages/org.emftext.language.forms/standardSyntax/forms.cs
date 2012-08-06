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

SYNTAXDEF forms
FOR <http://www.emftext.org/language/forms>
START Form
OPTIONS {
	licenceHeader ="../../org.dropsbox/licence.txt";
}

TOKENS {
	DEFINE MULTIPLE $'multiple'|'MULTIPLE'$;
}

TOKENSTYLES {
	"TEXT" COLOR #da0000;
	"FORM" COLOR #000000, BOLD;
	"ITEM" COLOR #000000, BOLD;
	"CHOICE" COLOR #000000, BOLD;
	"ONLY" COLOR #da0000, BOLD;
	"IF" COLOR #da0000, BOLD;
	"DATE" COLOR #000000, BOLD;
	"FREETEXT" COLOR #000000, BOLD;
	"NUMBER" COLOR #000000, BOLD;
	"DECISION" COLOR #000000, BOLD;
	"GROUP" COLOR #000000, BOLD;
}
  
RULES {
	Form ::= "FORM" caption['"','"'] groups*;
	Group ::= "GROUP" name['"','"'] items*;
	Item ::= "ITEM" text['"','"'] ( explanation['"','"'] )? ("ONLY" "IF" dependentOf[])? ":" itemType;
	Choice ::= "CHOICE" (multiple[MULTIPLE])? "(" options ("," options)* ")";
	Option ::= ( id[] ":")? text['"','"'];
	Date ::= "DATE";
	FreeText ::= "FREETEXT";
	Number ::= "NUMBER";
	Decision ::=  "DECISION" "(" options "," options ")"; 
}