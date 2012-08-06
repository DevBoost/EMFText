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

SYNTAXDEF ucinv
FOR <http://www.emftext.org/language/UseCaseInvariant>
START UseCaseModel

OPTIONS {	
	licenceHeader ="../../org.dropsbox/licence.txt";
	reloadGeneratorModel = "true";
	tokenspace = "1";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
}

TOKENS {
	DEFINE T_INCLUDING $'set' (' ' | '\t' | '\f')+ 'including'$;
}

TOKENSTYLES {
	"TEXT" COLOR #000000;
	
	"invariants" COLOR #7F0055, BOLD;
	"actor" COLOR #7F0055, BOLD;
	"counter" COLOR #7F0055, BOLD;
	"T_INCLUDING" COLOR #7F0055, BOLD;
}

RULES {

UseCaseModel 
   ::=
        "invariants" "for" name[] ":" (!1 invariants)* !0 "."
	;

NormalActor
   ::=
        "actor" name[] ":" "[" (valuesBefore (#0 "," valuesBefore)*)? "]" "-->" "[" (valuesAfter (#0 "," valuesAfter)*)? "]" "."
	;

CounterActor
   ::=
        "counter" name[] ":" "[" (valuesBefore (#0 "," valuesBefore)*)? "]" "-->" "[" (valuesAfter (#0 "," valuesAfter)*)? "]" "."
	;

Value 
   ::=
        type[]  (inSet[T_INCLUDING])? ID[]
	;
}