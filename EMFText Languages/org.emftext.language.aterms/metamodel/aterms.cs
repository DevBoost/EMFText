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

SYNTAXDEF aterms
FOR <http://www.emftext.org/language/aterms>
START ATerm, Value

OPTIONS {
	licenceHeader ="../../org.dropsbox/licence.txt";
 	generateCodeFromGeneratorModel = "true";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
}

TOKENS {
	DEFINE COMMENT $'//'(~('\n'|'\r'|'\uffff'))*$;
	DEFINE INTEGER $('-')?('1'..'9')('0'..'9')*|'0'$;
	DEFINE FLOAT $('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ $;
}

TOKENSTYLES {
	"appl" COLOR #7F0055, BOLD;
	"Definition" COLOR #7F0055, BOLD;
	"Symbol" COLOR #7F0055, BOLD;
	"Cardinality" COLOR #7F0055, BOLD;
}

RULES {
	ATerm::= "appl"  "(" definitions ( "," definitions  )* production ")," "["  "[]"  "[" symbols ( "," symbols  )* "]"  "]"  ")"  ;
	
	Value::=literal['"','"']  ;
	
	Reference::= "cf(sort(" name['"','"']  "))"  ;
	
	StarCardinality::= "iter-star-sep"  "(" production separator['"','"']  ")"  ;
}