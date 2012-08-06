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

 SYNTAXDEF xml
FOR <http://www.emftext.org/xml> <./xml.genmodel>
START Document

OPTIONS {	 
	licenceHeader ="../../org.dropsbox/licence.txt";
 	tokenspace="1";
	defaultTokenName="IDENTIFIER";
	generateCodeFromGeneratorModel="false";
	backtracking="true";
	usePredefinedTokens="false";
	reloadGeneratorModel="true";
	resourcePluginID="org.emftext.language.xml.resource.xml";
	basePackage="org.emftext.language.xml.resource.xml";
	resourceUIPluginID="org.emftext.language.xml.resource.xml.ui";
	uiBasePackage="org.emftext.language.xml.resource.xml.ui";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
}

TOKENS{
	DEFINE T_OPEN $'<'$;
	DEFINE T_CLOSE $'>'$;
	
	
	DEFINE T_EQUALS $'='$;
	DEFINE IDENTIFIER$( 'a'..'z' | 'A'..'Z' | '_' | ':') ('a'..'z'
    | 'A'..'Z' | '0'..'9' | '.' | '-' | '_' | ':')*$;
    
	DEFINE PCDATA $'>' (~('<'|'>'))* '<'$;
	
	DEFINE ATTRDATA $('"' (~('"'))* '"'| '\'' (~('\''))* '\'')$;
	DEFINE WS_LB $(('\r\n'|'\r'|'\n'|' '|'\t'|'\f')+)$;
}

RULES{
	
	Document::= ("<" root ">")? ;
	
	Node::=  start attributes*  ( nodes | pcdata )* "/" end[IDENTIFIER]  ;
	
	PCData ::= value[PCDATA];
	
	EmptyNode::= start attributes*  "/"  ;
	
	Attribute::=name[IDENTIFIER] "=" value[ATTRDATA] ;
	
	Tag::= name[IDENTIFIER] ;
	
}