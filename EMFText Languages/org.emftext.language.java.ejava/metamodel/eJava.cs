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

SYNTAXDEF ejava
FOR <http://www.emftext.org/language/eJava>
START EPackageWrapper
 
IMPORTS {
	java : <http://www.emftext.org/java> WITH SYNTAX java <../../org.emftext.language.java/metamodel/java.cs>
}

OPTIONS {	
	licenceHeader ="../../org.dropsbox/licence.txt";
	defaultTokenName = "IDENTIFIER";
	usePredefinedTokens = "false";
	
	overrideBuilder = "false";
	overrideBuilderAdapter = "false";
	resolveProxyElementsAfterParsing = "false";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
	ignoreTypeRestrictionsForPrinting = "true";
	overrideNewFileContentProvider = "false";
	overrideNewFileWizardPage = "false";
	overrideNewFileWizard = "false";
	
	additionalUIDependencies = "org.eclipse.jdt.core";
}

RULES {
	EPackageWrapper
	   ::=	("epackage" namespaces[] ("." namespaces[])*  ";" )?
	        !0 !0
	        (imports !0 )*
	        (";" !0)*
	        !0
	        (classifiers:EClassifierClassWrapper (";")* !0 !0)*
	        ("\\u001a")?
		;
		
	EClassifierClassWrapper
		::= 	  
			"eclass" name[] 
	        "{" 
	        	(!1 members:EOperationWrapper)* !0
	        "}"
	    ;    
	EOperationWrapper
		::= 	  
			 name[] "(" ")" "{" (!2 statements)* !1 "}"
	    ;
	    
	EObjectInstantiation ::= "#"  typeReference;
}