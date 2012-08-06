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

SYNTAXDEF topf
FOR <http://org.emftext.languages/plugin>
START ToolProductFamily

OPTIONS {	
	licenceHeader ="../../org.dropsbox/licence.txt";
	tokenspace = "1"; 
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
}

TOKENS {
	DEFINE COMMENT$'//'(~('\n'|'\r'))*$;
	DEFINE INTEGER$('-')?('1'..'9')('0'..'9')*|'0'$;
	DEFINE FLOAT$('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ $;
}

RULES{
		
		ToolProductFamily::= "ToolProductFamily" ":" name['"','"'] "plugins" "{" ( plugins  )* "}"  ;
		
		Plugin::= pluginId['\'','\''] ";";
		
}