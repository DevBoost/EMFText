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

SYNTAXDEF text.valueflow
FOR <http://www.emftext.org/language/valueflow>
START Model

OPTIONS {	
	licenceHeader ="../../org.dropsbox/licence.txt";
	tokenspace = "1";
	
	resourcePluginID = "org.emftext.language.valueflow.resource.valueflow";
	basePackage = "org.emftext.language.valueflow.resource.valueflow";
	resourceUIPluginID = "org.emftext.language.valueflow.resource.valueflow.ui";
	uiBasePackage = "org.emftext.language.valueflow.resource.valueflow.ui";
	baseResourcePlugin = "org.emftext.language.valueflow.resource";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
}

TOKENSTYLES {
	"TEXT" COLOR #000000;
}

RULES{		
		Model::= "flowmodel" name['"','"'] "{" agents* !0 "}";
		
		Agent::= !1 "agent" name['"','"'] "{" states* !0 "}";
		
		GiveState::= !2 "give"  name['"','"'] "value" value['"','"'] ("("#0 ID[] #0 ")")? "to" giveTo['"','"'] ("next" nextState['"','"'])? ";";
		
		TakeState::= !2 "take"  name['"','"'] "from" takeFrom['"','"'] ("next" nextState['"','"'])? ";";	
}