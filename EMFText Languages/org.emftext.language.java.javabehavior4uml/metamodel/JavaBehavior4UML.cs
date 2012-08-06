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

SYNTAXDEF javabehavior
FOR <http://www.emftext.org/javaBehavior4UML>
START JavaMethodBehavior

IMPORTS {
	java : <http://www.emftext.org/java> WITH SYNTAX java <../../org.emftext.language.java/metamodel/java.cs>
}

OPTIONS {	
	licenceHeader ="../../org.dropsbox/licence.txt";
	tokenspace = "1";
	defaultTokenName = "IDENTIFIER";
	usePredefinedTokens = "false";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
}

TOKENSTYLES {
	"ML_COMMENT" COLOR #008000, ITALIC;
	"SL_COMMENT" COLOR #000080, ITALIC;
	"STRING_LITERAL" COLOR #2A00FF;
	"IDENTIFIER" COLOR #000000;
}

RULES{
	JavaMethodBehavior ::=	
        (imports !0 )*
        !0
        javaMethod
    ;
}