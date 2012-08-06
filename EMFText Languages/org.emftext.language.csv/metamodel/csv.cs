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

SYNTAXDEF csv
FOR <http://www.emftext.org/language/csv>
START CSVDocument

OPTIONS {
 	licenceHeader ="../../org.dropsbox/licence.txt";
	reloadGeneratorModel = "true";
	usePredefinedTokens = "false";
	//disableTokenSorting = "true";
	tokenspace = "0";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
	resolveProxyElementsAfterParsing = "false";
	
	overridePrinter2 = "false";
}

TOKENS {
	DEFINE LINEBREAK $('\r\n'|'\r'|'\n')$;
	DEFINE COMMA $(','|';')$;
	
	DEFINE UNQUOTED_VALUE $(~('"'|','|';'|'\r\n'|'\r'|'\n'))+$;
}

RULES {
	CSVDocument ::= rows* linebreaks[LINEBREAK]*;

	Row ::= (values)+ _[LINEBREAK]?;
	
	Value ::= ( _[COMMA] (text['"','"','\\'] | text[UNQUOTED_VALUE])) | (text['"','"','\\'] | text[UNQUOTED_VALUE]) | text[COMMA];
}