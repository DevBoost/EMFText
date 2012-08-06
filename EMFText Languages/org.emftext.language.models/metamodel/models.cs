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

SYNTAXDEF model
FOR <http://www.emftext.org/language/models>
START Model

OPTIONS {	
	licenceHeader ="../../org.dropsbox/licence.txt";
	usePredefinedTokens = "false";
	tokenspace = "1";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
}

TOKENS {
	DEFINE SL_COMMENT $'//'(~('\n'|'\r'|'\uffff'))* $ COLLECT IN comments;
	DEFINE ML_COMMENT $'/*'.*'*/'$ COLLECT IN comments;
	DEFINE TEXT $('a'..'z')+$;
	DEFINE NUMBER $('0'..'9')+$;

	DEFINE WHITESPACE $(' '|'\t'|'\f')$;
	DEFINE LINEBREAKS $('\r\n'|'\r'|'\n')$;
}

TOKENSTYLES {
	"SL_COMMENT" COLOR #3a732e;
	"ML_COMMENT" COLOR #3a732e;
	"QUOTED_34_34" COLOR #09096b, BOLD;
	"TEXT" COLOR #400080, BOLD;
	"prototype" COLOR #000000, BOLD;
	"NUMBER" COLOR #000000;
	"hair" COLOR #000000, BOLD;
	"eyes" COLOR #000000, BOLD;
	"lips" COLOR #000000, BOLD;
	"legs" COLOR #000000, BOLD;
}

RULES {
	Model ::= 
		"prototype" name['"','"'] "[" size1[NUMBER] "," size2[NUMBER] "," size3[NUMBER] "]" "{"
			hair[TEXT] "hair" ";"
			eyes[TEXT] "eyes" ";"
			lips[TEXT] "lips" ";"
			legs[TEXT] "legs" ";"
		"}"
	;
}