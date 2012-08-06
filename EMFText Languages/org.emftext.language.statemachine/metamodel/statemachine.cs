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

SYNTAXDEF statemachine FOR <http://www.eclipse.org/uml2/4.0.0/UML> START StateMachine

OPTIONS {	
	licenceHeader ="../../org.dropsbox/licence.txt";
	tokenspace = "1";
	resourcePluginID = "org.emftext.language.statemachine.resource.statemachine";
	basePackage = "org.emftext.language.statemachine.resource.statemachine";
	resourceUIPluginID = "org.emftext.language.statemachine.resource.statemachine.ui";
	uiBasePackage = "org.emftext.language.statemachine.resource.statemachine.ui";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
}

TOKENS {
	DEFINE PSEUDOKIND $'initial'|'join'|'fork'$ ;
}

RULES{	
  StateMachine  ::= "StateMachine" #1 name[] "{" !1 region !0 "}" ;	
  Region        ::= (subvertex !0 !0)* "transitions" "{" !1 (transition !0)* !0 "}";
  
  State         ::= ("state" name[] "{" !1 
  						("entry" ":" entry !0)? 
  						("exit" ":" exit !0)? 
                    	"do" ":" doActivity !0 
                    	(region)?
                    !0 "}" ";");
  Pseudostate   ::=  kind[PSEUDOKIND] "state" name[] ";";
  FinalState    ::= "final" "state" name[] "{" !1 ("entry" ":" entry !0)? ("exit" ":" exit !0)?
                    "do" ":" doActivity !0"}" ";"; 					
  
  Transition    ::= source[] "->" target[] "when" trigger 
                    ( "do" ":" effect )? ";";		
  Trigger       ::= name['"','"'];	
  Activity      ::= name['"','"'];										
}