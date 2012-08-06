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

SYNTAXDEF closure 
FOR <http://www.emftext.org/language/java/closures>
START java.Containers.CompilationUnit, java.Containers.EmptyModel
 
IMPORTS {
	java : <http://www.emftext.org/java> WITH SYNTAX java <../../org.emftext.language.java/metamodel/java.cs>
}

OPTIONS {	
	licenceHeader ="../../org.dropsbox/licence.txt";
	defaultTokenName = "IDENTIFIER";
	usePredefinedTokens = "false";
	reloadGeneratorModel = "false" ;
	overrideBuilder="false";
	resolveProxyElementsAfterParsing = "false";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
}

RULES { 
 	Closure ::= //( annotationsAndModifiers )* !1 
 			// function type declaration
 			"{" (parameterTypes arrayDimensionsBefore? ("," parameterTypes arrayDimensionsBefore? )*)? 
 			"=>" valueType valueTypeArrayDimension* "}"
 			// super type
 			!1 typeReference? ":" name[]? ( "="
 			// parameter declaration 
 			!1 "{" (parameters ("," parameters ?)*)?
 			// function body 
 			"=>" !2 statements+ "}" 
 			//( !1 "." #0 methodName[] #0 "(" (arguments ("," arguments)*)? ")" #0 )? 
 			//( !1 "." #0 next )? ";"   ;
 			)?
 			;
}

