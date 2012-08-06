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

SYNTAXDEF c
FOR <http://www.emftext.org/language/simplec>
START CompilationUnit

OPTIONS {	
	licenceHeader ="../../org.dropsbox/licence.txt";
	tokenspace = "1";
	autofixSimpleLeftrecursion = "false";
	tokenspace = "1";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
}

TOKENS {
}

RULES {
	CompilationUnit ::= definitions* ;
	
	Method ::= "void" name[] "(" ")" "{" statements* "}" ;
	
	Variable ::= "int" name[] ";" ;

	Struct ::= "struct" name[] "{" "}" ;
	
	Statement ::= "return" ";";
}