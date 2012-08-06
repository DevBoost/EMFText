//*******************************************************************************
// Copyright (c) 2006-2012 
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

SYNTAXDEF dot
FOR <http://www.emftext.org/language/dot>
START Graph

// see: http://www.graphviz.org/doc/info/lang.html

OPTIONS {
	licenceHeader ="../../org.dropsbox/licence.txt";
	reloadGeneratorModel = "true";
	generateCodeFromGeneratorModel = "true";
	usePredefinedTokens = "false";
	tokenspace = "1";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
}

TOKENS {
		DEFINE GRAPHTYPE $ (('g'|'G') ('r'|'R') ('a'|'A') ('p'|'P') ('h'|'H')) |
		                   (('d'|'D') ('i'|'I') ('g'|'G') ('r'|'R') ('a'|'A') ('p'|'P') ('h'|'H')) $;

		DEFINE STRICT $ ('s'|'S') ('t'|'T') ('r'|'R') ('i'|'I') ('c'|'C') ('t'|'T') $;

		DEFINE SUBGRAPHTYPE $ ('s'|'S') ('u'|'U') ('b'|'B') ('g'|'G') ('r'|'R') ('a'|'A') ('p'|'P') ('h'|'H') $;
		
		DEFINE EDGEOP $ '->' | '--' $;
		
		DEFINE CONTEXT $ (('n'|'N') ('o'|'O') ('d'|'D') ('e'|'E')) |
		                 (('e'|'E') ('d'|'D') ('g'|'G') ('e'|'E')) $;
	
	    DEFINE ID $ (('a'..'z'|'A'..'Z'|'_'|'\u0080'..'\u00ff')  ('0'..'9'|'a'..'z'|'A'..'Z'|'_'|'\u0080'..'\u00ff')*) |
		            (('-')? ('.' ('0'..'9')+ ) | (('0'..'9')+ ('.' ('0'..'9')*)?)) |
		            (('"' ('\\\"' | (~('"'|'\uffff')))* '"') ('+' ('"' ('\\\"' | (~('"'|'\uffff')))* '"'))*) |
		            ('<' .* '>') $;   // maybe html tag as model              
                             
	    DEFINE SL_COMMENT $ '//'(~('\n'|'\r'|'\uffff'))* $ COLLECT IN comments;
	    DEFINE ML_COMMENT $ '/*'.*'*/'$ COLLECT IN comments;
		DEFINE PREPROCESSOR $ '#' (~('\n'|'\r'))* $ COLLECT IN comments;
		
		                 
		DEFINE WHITESPACE $ (' '|'\t'|'\f'|'\\\r'|'\\\n'|'\\\r\n') $;
		DEFINE TEXT $ ('A'..'Z'|'a'..'z'|'0'..'9'|'_'|'-')+ $;
		DEFINE LINEBREAKS $ ('\r\n'|'\r'|'\n') $;
}

TOKENSTYLES {
   "GRAPHTYPE" COLOR #912A72, BOLD;
   "STRICT" COLOR #912A72, BOLD;
   "SUBGRAPHTYPE" COLOR #912A72, BOLD;
   "EDGEOP" COLOR #912A72;
   "CONTEXT" COLOR #912A72, BOLD;
   
   "ID" COLOR #000000;
   "TEXT" COLOR #000000;
   "ML_COMMENT" COLOR #008000, ITALIC;
   "SL_COMMENT" COLOR #000080, ITALIC;
   "PREPROCESSOR" COLOR #A0A0A0;
}


RULES{
		
		Graph ::= (strict[STRICT])? type[GRAPHTYPE] (id[ID])? "{"  (statements)? "}" ;
		
		StatementList ::= statement (";")? (tail)? ; 
		
		NodeStatement ::=  node_id (attributes)? ;
		
		EdgeStatement ::= source[ID] target (attributes)? ;
		
		AttributeStatement ::= (context[CONTEXT] | context[GRAPHTYPE]) attributes;
		
		AssignmentStatement ::= left[ID] "=" right[ID];
		
		Subgraph ::= ( type[SUBGRAPHTYPE] (id[ID])? )? "{" (statements)? "}" ;
		
		Target ::= operation[EDGEOP] target[ID] (next_target)? ;  
		
		NodeID ::= id[ID] (port)? ;
		
		AttributeList ::=  "[" list "]" (next)? ;
		 
		AList ::= attribute (",")? (tail)? ;
		
		Attribute ::= key[ID] ( "=" value[ID] )? ;
		 
		Port ::= ":" id[ID] (":" compass[])? |
		         ":" compass[];
		
}
