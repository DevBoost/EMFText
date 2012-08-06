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

SYNTAXDEF office2
FOR <http://reuseware.org/coconut/office2>
START OfficeModel

OPTIONS {
	licenceHeader ="../../org.dropsbox/licence.txt";
	
	generateCodeFromGeneratorModel = "true";
	overrideBuilder = "false";
}

RULES { 
	OfficeModel ::= "officemodel" name[] currentTime['(',')']
					"{" (!1 elements !0)* !0 "}" ;
	
	Office ::= "office" name[];
	
	Employee ::= "employee" name[] 
				 (!1 "works" "in" worksIn[])?
				 (!1 "works" "with" 
				 worksWith[] ("," worksWith[])*)?
				 (!1 "currently" "in" currentlyIn[])?;
				 
	LeisureRoom ::= "leisure" name[];
}