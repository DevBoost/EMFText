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

SYNTAXDEF rails
FOR <http://www.emftext.org/language/rails>
START Project

OPTIONS {	
	licenceHeader ="../../org.dropsbox/licence.txt";
	generateCodeFromGeneratorModel = "true";
	reloadGeneratorModel = "true";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
}

TOKENS {
	DEFINE COMMENT $'//'(~('\n'|'\r'))*$;
}

TOKENSTYLES {
	"project", "train", "track", "switch", "connect", "out:", "in:", "->" COLOR #000080, BOLD;
	"COMMENT" COLOR #008000;
}

RULES {
	
	Project ::= "project" (name[])? "{" 
			components* connections*
		"}";
	
	Train ::= "train" (name[])? ; 
	
	Track ::= "track" (name[])? 
		"{" 
			ports* 
			trains* 
		"}" ;
	
	Switch ::= "switch" (name[])?
		"{" 
			ports*
			trains* 
		"}" ;
	
	Connection ::= "connect" (name[])? from[] "->" to[] ;
	
	Out ::= "out:" (name[])? ;
	
	In  ::= "in:"  (name[])? ;
}