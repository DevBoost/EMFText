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

SYNTAXDEF conference
FOR <http://www.emftext.org/language/conference>

START Conference

OPTIONS {
 	licenceHeader ="../../org.dropsbox/licence.txt";
	reloadGeneratorModel = "true";
	generateCodeFromGeneratorModel = "true";
	tokenspace = "1";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
}

TOKENSTYLES {
	"QUOTED_34_34" COLOR #404040;
}

RULES {
	Conference ::= 
		"CONFERENCE" #1 name['"','"'] #1 
		"(" organizers['"','"'] ("," #1 organizers['"','"'])* ")"
	    !0 ( !0 elements )* 
	    !0 "REGISTERED" "SPEAKERS" ":" !0 speakers ("," !0 speakers)*;
		
	Participant ::= name['"','"'] #1 "FROM" #1 country [];
		
	Talk ::= "TALK" #1 name['"','"'] #1 "PRESENTED" "BY" presenter['"','"'] !0;
		
	Track ::= "TRACK" #1 name['"','"'] ":" !0 (slots)*;
		
	Slot ::= "AT" #1 hour[] #0 ":" #0 minute[] ":" #1 talk;
	
	Lunch ::= "AT" hour[] #0 ":" #0 minute[] #1 "LUNCH" !0;
}