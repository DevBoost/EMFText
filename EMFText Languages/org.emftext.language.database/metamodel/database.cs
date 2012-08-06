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

SYNTAXDEF database
FOR <http://www.emftext.org/language/database>
START Database 

OPTIONS{
	//generateCodeFromGeneratorModel = "true"; 
 	reloadGeneratorModel = "true"; 
	//tokenspace = "1";
	//overrideManifest = "false";  
	licenceHeader ="platform:/resource/org.reuseware/licence.txt";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
}
TOKENS{
		DEFINE COMMENT $'//'(~('\n'|'\r'))*$; 
}

TOKENSTYLES {
	"table" COLOR #0000CC, BOLD;
	"fkey" COLOR #0000CC, BOLD;
	"column" COLOR #0000CC, BOLD;
	"columns" COLOR #0000CC, BOLD;
	"database" COLOR #0000CC, BOLD;
	"pkey" COLOR #0000CC, BOLD;
	"procedure" COLOR #0000CC, BOLD;
	":" COLOR #0000CC, BOLD;
		
}

RULES{
		
		Database ::=  "database" name[] "{" 
							
							tables* 
							procedures*
							
					  "}" ;
		
		Table ::= "table" name[] "{" 
						
						fkeys* 
						pkeys* 
						columns*  
						
					"}"  ;
		
		FKey ::= "fkey" name[] "table" reference[] "columns" columns[] ("," columns[])*  ; 
		
		PKey ::= "pkey" name[] "columns" columns[] ("," columns[])*  ;
		
		Column ::= "column" name[] ":" type ;
		
		Procedure ::= "procedure" name[] "("  
								
								(parameters ("," parameters)*)? ")" 
								
								":" return? ;
	
		Parameter ::= name[] ":" type ;
		
		Type ::= name[] ;
	

		
		
		
		
		
}