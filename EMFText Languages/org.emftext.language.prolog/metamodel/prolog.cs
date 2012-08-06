SYNTAXDEF pl
FOR <http://www.emftext.org/language/prolog>
START PrologProgram


OPTIONS {
	usePredefinedTokens = "false";
	//defaultTokenName = "IDENTIFIER";
	reloadGeneratorModel = "true";
}


TOKENS {
	//DEFINE IDENTIFIER $('A'..'Z' | 'a'..'z' | '-'| '_')('A'..'Z' | 'a'..'z' | '0'..'9' | '-'| '_')*$;
	DEFINE WHITESPACE $(' ' | '\t' | '\f')$;
	DEFINE LINEBREAK $('\r\n' | '\r' | '\n')$;
	DEFINE FRAGMENT DIGIT $('0'..'9')$;
	DEFINE FLOAT $('-')?(('1'..'9') ($ + DIGIT + $)* | '0') ('.' ($ + DIGIT + $)+)? $;
	DEFINE FRAGMENT UPPER $('A'..'Z')$;
	DEFINE FRAGMENT LOWER $('a'..'z')$;
	//DEFINE FRAGMENT SPECIAL $('+'|'-'|'*'|'/'|'_')$;
	DEFINE FRAGMENT CHAR $($ + LOWER + $ | $ + UPPER + $ | $ + DIGIT + $)$;
	DEFINE CAPITAL_WORD UPPER + CHAR + $*$;
	DEFINE SMALL_WORD   LOWER + CHAR + $*$;
	DEFINE ANONYMOUS $'_'($ + CAPITAL_WORD + $)?$;
	DEFINE SL_COMMENT $'%'(~('\n'|'\r'|'\uffff'))*$;
}


RULES {
	PrologProgram ::= clauses+;
	Clause ::= predicate ( ":-" conjunction)? ".";
	Conjunction ::= parts ("," parts)*;
	
	//@Operator(type="primitive", weight="10", superclass="Term")
	Predicate ::= name[SMALL_WORD] ("(" terms ("," terms)* ")")?;
	
	@Operator(type="primitive", weight="10", superclass="Term")
	Numeral ::= value[FLOAT];
	
	@Operator(type="primitive", weight="10", superclass="Term")
	Variable ::= name[CAPITAL_WORD];
	
	@Operator(type="primitive", weight="10", superclass="Term")
	AnonymousVariable ::= text[ANONYMOUS];
	
	//@Operator(type="primitive", weight="10", superclass="Term")
	String ::= text['\'','\''];
	
	//@Operator(type="primitive", weight="10", superclass="Term")
	VariableReference ::= variable[CAPITAL_WORD];
	
	@Operator(type="primitive", weight="10", superclass="Term")
	List ::= "[" (headTerms ("," headTerms)* ("|" tail)? )? "]";
	
	Assignment ::= variable "is" term;
	
	@Operator(type="binary_left_associative", weight="1", superclass="Term")
	Additive ::= left operator[plus: "+", minus: "-"] right;
	
	@Operator(type="binary_left_associative", weight="2", superclass="Term")
	Multiplicative ::= left operator[mult: "*", div: "/"] right;

	@Operator(type="binary_right_associative", weight="3", superclass="Term")
	Power ::= base "^" exponent;
	
	@Operator(type="unary_prefix", weight="4", superclass="Term")	
	Negation ::= operator[plus: "+", minus: "-"] body;
	
	@Operator(type="primitive", weight="5", superclass="Term")
	BracketExpression ::= "(" body ")";
	
}