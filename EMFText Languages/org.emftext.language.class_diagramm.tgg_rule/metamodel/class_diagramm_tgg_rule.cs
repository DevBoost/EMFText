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

SYNTAXDEF class_diagramm_tgg_rule 
FOR <http://www.emftext.org/language/class_diagramm_tgg_rule>
START AnnotatedPackage,Package
 
IMPORTS {
    class_diagramm : <http://www.emftext.org/language/class_diagramm> WITH SYNTAX class_diagramm <../../org.emftext.language.class_diagramm/metamodel/class_diagramm.cs>
}

OPTIONS {
    licenceHeader ="platform:/resource/org.reuseware/licence.txt";
    reloadGeneratorModel = "true";
    //generateCodeFromGeneratorModel = "true";
    resourcePluginID = "org.emftext.language.class_diagramm.tgg_rule.resource.class_diagramm.tgg_rule";
    basePackage = "org.emftext.language.class_diagramm.tgg_rule.resource.class_diagramm.tgg_rule";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
}

TOKENS {
    DEFINE COMMENT $'//'(~('\n'|'\r'|'\uffff'))*$;  
    DEFINE T_TYPE $'++'|'!'|'/'$;
    DEFINE IDENT $'@'('A'..'Z'|'a'..'z'|'0'..'9'|'_')+$;
    DEFINE T_MODIFIER $'public'|'static'|'final'|'private'|'protected'|'abstract'$;
 
}

TOKENSTYLES {
    "IDENT" COLOR #000000, BOLD;
    "T_TYPE" COLOR #00BB00, BOLD;
    "COMMENT" COLOR #008000;
    "T_MODIFIER" COLOR #00BB00, BOLD; 
}

RULES {
    TGGRuleAnnotation ::= (identifiers[IDENT])+ (type[T_TYPE]);   
    AnnotatedPackage ::= annotation body ;
    AnnotatedDataType      ::= annotation body ;
    AnnotatedMethod     ::= annotation body ;
    AnnotatedAttribute     ::= annotation body ;
    AnnotatedClass    ::= annotation body ;
    AnnotatedAssociation    ::= annotation body ;  
    AnnotatedParameter    ::= annotation body ;
}