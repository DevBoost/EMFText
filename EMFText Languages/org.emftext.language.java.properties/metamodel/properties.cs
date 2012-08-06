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

SYNTAXDEF propjava
FOR <http://www.emftext.org/language/java/properties>
START java.Containers.CompilationUnit

IMPORTS {
	java : <http://www.emftext.org/java> WITH SYNTAX 
	java <../../org.emftext.language.java/metamodel/java.cs>
}

OPTIONS {	
	licenceHeader ="../../org.dropsbox/licence.txt";
	defaultTokenName = "IDENTIFIER";
	usePredefinedTokens = "false";
	overrideBuilder = "false";
	resolveProxyElementsAfterParsing = "false";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
}

TOKENS {
	DEFINE T_READONLY $'readonly'$;
}
TOKENSTYLES {
	"T_READONLY" COLOR #7F0055, BOLD;
}
RULES {
	Property ::= (readonly[T_READONLY])? "property" typeReference arrayDimensionsBefore* name[] ";" ;
}