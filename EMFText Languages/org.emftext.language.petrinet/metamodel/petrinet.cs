//*******************************************************************************
// Copyright (c) 2006-2011
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

SYNTAXDEF petrinet
FOR <http://www.emftext.org/language/petrinet>
START PetriNet

OPTIONS {
	licenceHeader ="../../org.dropsbox/licence.txt";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
}

TOKENS {
	DEFINE COMMENT $'//'(~('\n'|'\r'|'\uffff'))*$;
}

TOKENSTYLES {
	"net" COLOR #7F0055, BOLD;
	"arc" COLOR #7F0055, BOLD;
	"transition" COLOR #7F0055, BOLD;
	"place" COLOR #7F0055, BOLD;
	"token" COLOR #7F0055, BOLD;
	"->" COLOR #7F0055, BOLD;
	"COMMENT" COLOR #008000;
}

RULES {
	
	PetriNet::= "net"  (name[])?  "{" nodes* arcs* "}" ;
	
	Arc::= "arc" (name[])? source[] "->" target[] ;
	
	Transition::= "transition" (name[])? ;
	
	@SuppressWarnings(optionalKeyword)
	Place::= "place" (name[])? ("{" marking* "}")? ;
	
	Token::= "token" (name[])? ;
}