SYNTAXDEF n3_turtle
FOR <http://emftext.org/n3_turtle>
START N3Doc

OPTIONS {
	licenceHeader ="platform:/resource/org.reuseware/licence.txt";
	generateCodeFromGeneratorModel = "true";
	overrideManifest = "false";
	overrideBuildProperties = "false";
	overrideClasspath = "false";
	overrideProjectFile = "false";
	reloadGeneratorModel = "true";
	tokenspace = "1";
	//memoize = "true";
	usePredefinedTokens = "false";  
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
}

TOKENS {
	DEFINE COMMENT $'#'(~('\n'|'\r'|'\uffff'))* $;
	DEFINE NUMBERLITERALTOKEN $('+'|'-')? ('0'..'9')+ ('.' ('0'..'9')+ )?$;
	//DEFINE INT $('+'|'-')?('0'..'9')+$;
	//DEFINE QUOTEDSTRINGTOKEN $('\"' (~'\"')* '\"') | ('\'' (~'\'')* '\'')$;
	//DEFINE URIREFTOKEN $'<' (~('>'|'<'))* '>'$;
	DEFINE NAMETOKEN $('A'..'Z' | '_' | 'a'..'z') ('A'..'Z' | '_' | 'a'..'z' | '-' | '0'..'9')*$;
	//DEFINE FLOAT $('0'..'9')+ '.' ('0'..'9')* (('e'|'E'|'p'|'P') ('+'|'-')? ('0'..'9')+)? ('f'|'F') 
	//			| ('.' ('0'..'9')+ (('e'|'E'|'p'|'P') ('+'|'-')? ('0'..'9')+)?) ('f'|'F') 
	//			| (('0'..'9')+ (('e'|'E'|'p'|'P') ('+'|'-')? ('0'..'9')+) ('f'|'F') 
	//			| ('0'..'9')+ ('f'|'F'))$;
	//DEFINE FACETKINDS $'length'|'minLength'|'maxLength'
	//					|'pattern'|'langPattern'|'<='|'<'
	//					|'>'|'>='$;
	//DEFINE CHARACTERISTICS $'Functional'|'InverseFunctional'|'Reflexive'
	//					|'Irreflexive'|'Symmetric'|'Asymmetric'|'Transitive'$; 
	//DEFINE IRI $(('<')(~('>')|('\\''>'))*('>'))|(('A'..'Z' | ':' | 'a'..'z' | '0'..'9' | '_' | '-' )+)$;
 	DEFINE WHITESPACE $(' '|'\t'|'\f')$;
	DEFINE LINEBREAKS $('\r\n'|'\r'|'\n')$;
	}
	
	
TOKENSTYLES {
   "COMMENT" COLOR #33AA33, ITALIC;
   "@prefix" COLOR #444444;
   "a" COLOR #0000FF, BOLD;
   "IRI" COLOR #000000;
}

RULES {

// warum statements? (plural?) )und muss es  mindestens ein Statement geben? Abweichend von turtle EBNF!
// EBENF ist aber seltsam tripleS (plural) vs. directive (singular)
N3Doc       ::= (statements ".")+;


Directive   ::= "@prefix" prefixName? ":" uriref;



Triple      ::= subject predicateObjectList (";" predicateObjectList)* (";")? ; 
// ; optional? should this also be the case for object lists? like this: (would be different to  turtle EBNF))
PredicateObject ::= verb objectList ("," objectList)* (",")? ;
//PredicateObject ::= verb objectList ("," objectList)*;

Predicate   ::= resource;

DatatypeString ::= type  "^^" resource;
// are literals without ^^ not allowed?
NumberLiteral  ::= value[NUMBERLITERALTOKEN]; // value[("+"|"-")? ("0".."9")+ ("." ("0".."9")+ )?];
BTRUE       ::= "true";
BFALSE      ::= "false";


PredicateObjectList ::= "[" predicateObjects (";" predicateObjects)*  "]";
EmptyList   ::= "[" "]";
ItemList    ::= obj+;
Collection  ::= "(" itemList? ")";

NodeID      ::= "_:" name;

Qname       ::= prefix? ":" name?;



IsA         ::= "a";
Uriref      ::= value['<','>']; //value["<" (~(">"|"<"))* ">"];
Name        ::= value[NAMETOKEN];//value[("A".."Z" | "_" | "a".."z") ("A".."Z" | "_" | "a".."z" | "-" | "0".."9")*];
QuotedString ::= value['"','"'] | value['\'','\'']; //value[(""" (~""")* """) | ("\'" (~"\'")* "\'")];
}