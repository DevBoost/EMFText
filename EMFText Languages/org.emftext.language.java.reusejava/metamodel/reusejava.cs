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

SYNTAXDEF reusejava
FOR <http://www.emftext.org/reusejava>
START java.Containers.CompilationUnit, java.Containers.Package, StatementUnit

IMPORTS {
	java : <http://www.emftext.org/java> WITH SYNTAX java <../../org.emftext.language.java/metamodel/java.cs>
}

OPTIONS {	
	licenceHeader ="../../org.dropsbox/licence.txt";
	defaultTokenName = "IDENTIFIER";
	usePredefinedTokens = "false";
	resolveProxyElementsAfterParsing = "false";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
}

RULES {
	StatementUnit ::=           "statements" name[] "{" statements "}" ;
	StatementVariationPoint ::=  "<" "<" name[] ">" ">"  ";" ;		
}
