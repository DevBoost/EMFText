SYNTAXDEF eag
FOR <http://www.emftext.org/language/eag>
START AttributeGrammar

OPTIONS {
	usePredefinedTokens = "false";
	defaultTokenName = "IDENTIFIER";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
}

TOKENS {
	DEFINE FRAGMENT ALPHA $('a'..'z'|'A'..'Z')$;
	DEFINE FRAGMENT DIGIT $('0'..'9')$;
	
	DEFINE IDENTIFIER ALPHA + $($ + ALPHA + $|$ + DIGIT + $)*$;
	DEFINE INTEGER $($ + DIGIT + $)+$;
	
	DEFINE BIN_OP $'+'|'-'|'*'|'/'$;
	DEFINE BOOL_OP $'=='$;
	DEFINE ASS_OP $'+='|'='$;

	DEFINE COMMENT $'//'(~('\n'|'\r'))*$;
	DEFINE WHITESPACE $(' '|'\t'|'\f')$;
	DEFINE LINEBREAKS $('\r\n'|'\r'|'\n')$;
}

RULES {
	AttributeGrammar ::= 
		(!1 imports)+
		(!1 attributes)+ 
		(!1 computations)+ ;
	
	Import ::= "import" #1 importedPackage['<','>'] #1 ("as" prefix[])?;
	
	Attribute ::= kind[] "attribute" type[] name[];
	
	Computation ::= "computation" context[] #1 "::" #1 targetAttribute[] #1 "{" !1 body !0 "}";

	Assignment ::= left operator[ASS_OP] right ";";

	Variable ::= name[];
	
	@Operator(type="primitive", superclass="Expression", weight="20")
	Reference ::= target[];
	
	ForLoop ::= "for" "(" variable ":" collection ")" "{" body "}";
	
	IfElse ::= "if" "(" condition ")" "{" ifBody "}" ("else" "{" elseBody "}")?;
	
	@Operator(type="binary_left_associative", superclass="Expression", weight="4")
	ExpressionChain ::= previous "." next;
	
	@Operator(type="binary_left_associative", superclass="Expression", weight="2")
	BinaryExpression ::= left operator[BIN_OP] right;
	
	@Operator(type="binary_left_associative", superclass="Expression", weight="3")
	BooleanExpression ::= left operator[BOOL_OP] right;
	
	@Operator(type="primitive", superclass="Expression", weight="20")
	AttributeValue ::= targetAttribute[] "(" expression ")";

	@Operator(type="primitive", superclass="Expression", weight="20")
	ThisReference ::= "this";
	
	@Operator(type="primitive", superclass="Expression", weight="20")
	Value ::= "value";

	@Operator(type="primitive", superclass="Expression", weight="20")
	StringLiteral ::= value['"','"','\\'];

	@Operator(type="primitive", superclass="Expression", weight="20")
	IntegerLiteral ::= value[INTEGER];
}
