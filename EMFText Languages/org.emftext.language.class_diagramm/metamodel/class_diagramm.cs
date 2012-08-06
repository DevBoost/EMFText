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

SYNTAXDEF class_diagramm
FOR <http://www.emftext.org/language/class_diagramm>
START Package

OPTIONS{
    //generateCodeFromGeneratorModel = "true";
    //reloadGeneratorModel = "true";
    //overrideManifest = "false";
	licenceHeader ="platform:/resource/org.reuseware/licence.txt"; 
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
}

TOKENS{
		DEFINE COMMENT $'//'(~('\n'|'\r'))*$;
		DEFINE T_MODIFIER $'public'|'static'|'final'|'private'|'protected'|'abstract'$;
}

TOKENSTYLES {
    "package" COLOR #0000CC, BOLD;  
    "void" COLOR #0000CC, BOLD;
    "class" COLOR #0000CC, BOLD;
    "extends" COLOR #0000CC, BOLD; 
    "attribute" COLOR #0000CC, BOLD;
    "method" COLOR #0000CC, BOLD;
    "association" COLOR #0000CC, BOLD;
    "->" COLOR #0000CC, BOLD;
    ".." COLOR #0000CC, BOLD;
    ":" COLOR #0000CC, BOLD;
    "T_MODIFIER" COLOR #00BB00, BOLD;
}

RULES{
		
		Package::= "package"  name[]
		                  "{" 
		                          classes*
		                          associations* 
		                  		  
		                  "}"  ;
		
		Method::=	modifier[T_MODIFIER]* 
		            "method" 
		            name[]
		          	"("
		          	    (parameters ("," parameters)*)? 
		          	")" 
		          	":"
		          	(return[] | "void" | primitive_return )
		          	;
		
		Attribute::=  modifier[T_MODIFIER]* 
		              "attribute"
					  name[]
		              ":"
		              ( type[] | primitive_type )
		              ;
		              
		Parameter::=  name[] ":" ( type[] | primitive_type ) ; 
		
		Class::=  modifier[T_MODIFIER]* 
		            "class"
					name[]
                    ("extends" parent[])?
                    "{"
                         attributes* 
                         methods*
                   	"}"
                    ;
		
		Association::= "association"
		                  name[]
		                  isAggregation['"','"']
		                  "("
		                      source[] "->" target[] 
		                      ":"
		                      minCardinality['"','"']
		                      ".."
		                      maxCardinality['"','"'] 
		                  ")" ;
		                  
        DataType ::= name[] ; 

		
}