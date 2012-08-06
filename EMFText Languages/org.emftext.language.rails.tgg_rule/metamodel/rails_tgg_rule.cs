//*******************************************************************************
// Copyright (c) 2006-2009 
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

SYNTAXDEF rails_tgg_rule
FOR <http://www.emftext.org/language/rails/tgg_rule>
START AnnotatedProject,Project

IMPORTS {
    project : <http://www.emftext.org/language/rails> WITH SYNTAX rails <../../org.emftext.language.rails/metamodel/rails.cs>
}

OPTIONS {	
	licenceHeader ="platform:/resource/org.reuseware/licence.txt";
	//reloadGeneratorModel = "true";
	//generateCodeFromGeneratorModel = "true";
	resourcePluginID = "org.emftext.language.rails.tgg_rule.resource.rails.tgg_rule";
	basePackage = "org.emftext.language.rails.tgg_rule.resource.rails.tgg_rule";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
}

TOKENS {
	DEFINE COMMENT $'//'(~('\n'|'\r'|'\uffff'))*$;
    DEFINE T_TYPE $'++'|'!'|'/'$;
    DEFINE IDENT $'@'('A'..'Z'|'a'..'z'|'0'..'9'|'_')+$;
}

TOKENSTYLES {
    "IDENT" COLOR #000000, BOLD;
	"T_TYPE" COLOR #00BB00, BOLD;
    "COMMENT" COLOR #008000;
   
}

RULES {
	TGGRuleAnnotation ::= (identifiers[IDENT])+ (type[T_TYPE]);
    AnnotatedProject    ::= annotation body ;
    AnnotatedConnection ::= annotation body ;
    AnnotatedTrain      ::= annotation body ;
    AnnotatedPort       ::= annotation body ;
    AnnotatedComponent  ::= annotation body ;
}