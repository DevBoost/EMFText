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

SYNTAXDEF formular
FOR <http://www.emftext.org/language/formular>
START Formular

OPTIONS {	
	licenceHeader = "../../org.dropsbox/licence.txt";
	overrideBuilder = "false";
	tokenspace = "1";
	additionalDependencies = "org.emftext.language.formular.generator";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
}

TOKENSTYLES {
	"TEXT" COLOR #da0000;
	"FORMULAR" COLOR #000000, BOLD;
	"FRAGE" COLOR #000000, BOLD;
	"AUSWAHL" COLOR #000000, BOLD;
	"NUR" COLOR #da0000, BOLD;
	"BEI" COLOR #da0000, BOLD;
	"DATUM" COLOR #000000, BOLD;
	"FREITEXT" COLOR #000000, BOLD;
	"ZAHL" COLOR #000000, BOLD;
	"ENTSCHEIDUNG" COLOR #000000, BOLD;
	"GRUPPE" COLOR #000000, BOLD;
	"ENTSCHEIDUNG" COLOR #000000, BOLD;
}
  
RULES {
	Formular ::= "FORMULAR" titel['"','"'] gruppen*;
	Gruppe ::= "GRUPPE" name['"','"'] fragen*;
	Frage ::= "FRAGE" text['"','"'] ( erklaerung['"','"'] )? ("NUR" "BEI" abhaengigVon[])? ":" antwortTyp;
	Auswahl ::= "AUSWAHL" (mehrfach[])? "(" optionen ("," optionen)* ")";
	Option ::= ( id[] ":")? text['"','"'];
	Datum ::= "DATUM";
	Freitext ::= "FREITEXT";
	Zahl ::= "ZAHL";
	Entscheidung ::=  "ENTSCHEIDUNG" "(" optionen "," optionen ")"; 
}