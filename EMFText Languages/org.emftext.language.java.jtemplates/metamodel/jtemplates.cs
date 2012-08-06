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

SYNTAXDEF javatemplate
FOR <http://www.emftext.org/language/java/jtemplates>
START JavaTemplate

IMPORTS {
	java : <http://www.emftext.org/java> <../../org.emftext.language.java/metamodel/java.genmodel> 
		WITH SYNTAX java <../../org.emftext.language.java/metamodel/java.cs>
}

OPTIONS {	
	licenceHeader ="../../org.dropsbox/licence.txt";
	usePredefinedTokens = "false";
	resolveProxyElementsAfterParsing = "false";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
}

TOKENSTYLES {
	"<%TEMPLATE" COLOR #C00000, BOLD; 
	"INPUT=" COLOR #C00000, BOLD;
	"<%IF" COLOR #C00000, BOLD;
	"<%FOR" COLOR #C00000, BOLD;
	"<%=" COLOR #C00000, BOLD;
	"%>" COLOR #C00000, BOLD;
	"<%ENDFOR%>" COLOR #C00000, BOLD;
	"<%ENDIF%>" COLOR #C00000, BOLD;
	"SL_COMMENT" COLOR #00A000, ITALIC;
}

RULES {
	JavaTemplate ::= "<%TEMPLATE" "INPUT=" inputMetaClass[STRING_LITERAL] "%>" body;
}
