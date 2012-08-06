SYNTAXDEF petrinets
FOR <http://www.emftext.org/language/petrinets>
START PetriNet

OPTIONS {
	overrideBuilder = "false";	
	overrideManifest = "false";
	reloadGeneratorModel = "true";
	usePredefinedTokens = "false";
	overridePluginXML = "false";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
	overrideDefaultResolverDelegate = "false";
}

TOKENS {
 	DEFINE SL_COMMENT $'//'(~('\n'|'\r'|'\uffff'))* $;
	DEFINE ML_COMMENT $'/*'.*'*/'$;
	DEFINE PLIST $'PList'$;
	
	DEFINE BOOLEAN_OPERATOR $('&&'|'||')$;
	DEFINE IDENTIFIER $('A'..'Z' | 'a'..'z'| '_' | '-' )('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' | '::')*$;
	
	DEFINE WHITESPACE $(' '|'\t'|'\f')$;
	DEFINE LINEBREAKS $('\r\n'|'\r'|'\n')$;
	
	
	DEFINE STRING_LITERAL $'"'('\\'('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')|('\\''u'('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F'))|'\\'('0'..'7')|~('\\'|'"'))*'"'$;
	DEFINE DECIMAL_FLOAT_LITERAL $('0'..'9')+ '.' ('0'..'9')* (('e'|'E'|'p'|'P') ('+'|'-')? ('0'..'9')+)? ('f'|'F') | ('.' ('0'..'9')+ (('e'|'E'|'p'|'P') ('+'|'-')? ('0'..'9')+)?) ('f'|'F') | (('0'..'9')+ (('e'|'E'|'p'|'P') ('+'|'-')? ('0'..'9')+) ('f'|'F') | ('0'..'9')+ ('f'|'F'))$;
	DEFINE DECIMAL_DOUBLE_LITERAL $('0'..'9')+ '.' ('0'..'9')* (('e'|'E'|'p'|'P') ('+'|'-')? ('0'..'9')+)? ('d'|'D')? | ('.' ('0'..'9')+ (('e'|'E'|'p'|'P') ('+'|'-')? ('0'..'9')+)?) ('d'|'D')? | (('0'..'9')+ (('e'|'E'|'p'|'P') ('+'|'-')? ('0'..'9')+) ('d'|'D')? | ('0'..'9')+ ('d'|'D'))$;
	DEFINE DECIMAL_LONG_LITERAL $('0'|'1'..'9''0'..'9'*)('l'|'L')$;
	DEFINE DECIMAL_INTEGER_LITERAL $('0'|'1'..'9''0'..'9'*)$;
	
}

TOKENSTYLES {
	"ML_COMMENT" COLOR #008000, ITALIC;
	"SL_COMMENT" COLOR #000080, ITALIC;
	"library" COLOR #7F0055, BOLD;
	"autoinit" COLOR #7F0055, BOLD;
	"abstract" COLOR #7F0055, BOLD;
	
}  
 
RULES { 
	PetriNet ::= ("package" pkg[IDENTIFIER] ("." pkg[IDENTIFIER])* ";")? !0 (abstrct["abstract":""])? "petrinet" name[IDENTIFIER]? !0
				("types" #1 ePackages['<','>'] #1 genModels['<','>'] ";" !0)*
				("import" imports['<','>']";" !0)*
				("FUNCTIONS:" "{" !1 (functions !0)* "}")?
				"{" (!1 components | !1 arcs)* "}";
				
	Place ::= autoinit["autoinit" : ""] "place" #1 name[IDENTIFIER]? #1 ":" type[IDENTIFIER]?;
	
	Transition ::= "transition"  name[IDENTIFIER] ( "->" alias[IDENTIFIER] )? (!1 "if" "(" !1 guard ")")? 
				!1"do" 
				"{" (!1 statements:Statement,Expression ";")*
				"}"; 
				
	BasicFunction ::= library["library": ""]?  "function" type[IDENTIFIER] context[IDENTIFIER]"."name[IDENTIFIER] "(" (parameters ("," parameters)*)? ")";
	ListFunction ::= library["library": ""]? "function" (type[IDENTIFIER] | type[PLIST] "[" returnListType[IDENTIFIER] "]") context[PLIST] "[" listTypeDef "]" "."name[IDENTIFIER] "(" (parameters ("," parameters)*)? ")";
	PGenericType ::= name[IDENTIFIER];
	
	Parameter ::= type[IDENTIFIER] name[IDENTIFIER];
	
	ConsumingArc ::= in[IDENTIFIER] "-" freeVariable "->" out[IDENTIFIER] ;

	FreeVariable ::= name[IDENTIFIER]; 
		
	ProducingArc ::= in[IDENTIFIER] "-" output[IDENTIFIER] "(" settings? ("," settings)* ")" "->" out[IDENTIFIER];	
	
	Setting ::= feature[IDENTIFIER] #1 settingOperator[assign : ":=", add : "+="] value[IDENTIFIER] ; 
	
	InitialisedVariable ::= name[IDENTIFIER] "=" initialisation; 
	
	
	@Operator(type="binary_right_associative", weight="1", superclass="Expression")
	BooleanExpression ::= left (operator[BOOLEAN_OPERATOR]) right;

	@Operator(type="unary_postfix", weight="2", superclass="Expression")
	MemberCallExpression ::= target "." calls ("." calls)*;
 	FunctionCall ::= function[IDENTIFIER] "(" ( parameters ("," parameters)*)?")" ;
	
	@Operator(type="unary_prefix", weight="3", superclass="Expression")	
	UnaryMinus ::= minus["-":""] #1 expression;
	
	
	@Operator(type="primitive", weight="5", superclass="Expression")
	VariableCall ::= variable[IDENTIFIER];
	
	@Operator(type="primitive", weight="5", superclass="Expression")
	ConstructorCall ::= "new" type[IDENTIFIER]"(" settings? ("," settings)* ")";
	
	@Operator(type="primitive", weight="5", superclass="Expression")
	Cast ::= "(" type[IDENTIFIER] ")" expression;
	
	@Operator(type="primitive", weight="5", superclass="Expression")
	NestedExpression ::= "(" expression ")" ;
				
	@Operator(type="primitive", weight="5", superclass="Expression")
	StringLiteral ::= value[STRING_LITERAL];
	
	@Operator(type="primitive", weight="5", superclass="Expression")
	IntegerLiteral ::= value[DECIMAL_INTEGER_LITERAL];
	
	@Operator(type="primitive", weight="5", superclass="Expression")
	FloatLiteral ::= value[DECIMAL_FLOAT_LITERAL];
	
	@Operator(type="primitive", weight="5", superclass="Expression")
	DoubleLiteral ::= value[DECIMAL_DOUBLE_LITERAL] ;
	
	@Operator(type="primitive", weight="5", superclass="Expression")
	LongLiteral ::= value[DECIMAL_LONG_LITERAL] ;
	
	@Operator(type="primitive", weight="5", superclass="Expression")
	BooleanLiteral ::= value["true":"false"] ;
	
	@Operator(type="primitive", weight="5", superclass="Expression")
	EClassLiteral ::= "@" clazz[IDENTIFIER];
	

}