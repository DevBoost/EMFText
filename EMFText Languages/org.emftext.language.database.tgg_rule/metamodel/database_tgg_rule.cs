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

SYNTAXDEF database_tgg_rule 
FOR <http://www.emftext.org/language/database_tgg_rule>
START AnnotatedDatabase,Database
 
IMPORTS {
    database : <http://www.emftext.org/language/database> WITH SYNTAX database <../../org.emftext.language.database/metamodel/database.cs>
}

OPTIONS {
	licenceHeader ="platform:/resource/org.reuseware/licence.txt";
    //reloadGeneratorModel = "true";
    //generateCodeFromGeneratorModel = "true";
    resourcePluginID = "org.emftext.language.database.tgg_rule.resource.database.tgg_rule";
    basePackage = "org.emftext.language.database.tgg_rule.resource.database.tgg_rule";
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
    AnnotatedDatabase ::= annotation body ;
    AnnotatedColumn      ::= annotation body ;
    AnnotatedFKey     ::= annotation body ;
    AnnotatedPKey    ::= annotation body ;
    AnnotatedType    ::= annotation body ;
    AnnotatedTable    ::= annotation body ;
    AnnotatedParameter    ::= annotation body ;
    AnnotatedProcedure    ::= annotation body ;
}