SYNTAXDEF issue49
FOR <http://www.emftext.org/test/issue49>
START Content

OPTIONS {
	reloadGeneratorModel = "true";
	generateCodeFromGeneratorModel = "true";
}

TOKENS {
	DEFINE INTEGER_TOKEN $('0'..'9')+$;
}

RULES {
	//In this example, the operator syntax is actually not required. More complex expressions have been removed
	//for the sake of a more concise minimal example.
	
	//Bug: When generating code, error occurs saying that it is unable to convert from Sign to Not in MultiunaryprefixParser.
	
	Content ::= expressions*;
	
	@Operator(type="unary_prefix", weight="40", superclass="Expression")
	SignedExpression ::= sign operand;
	
	Plus ::= "+";
	Minus ::= "-";
	
	
	@Operator(type="unary_prefix", weight="40", superclass="Expression")
	NotExpression ::= operator operand;
	
	Not ::= "not";
	
	@Operator(type="primitive", weight="50", superclass="Expression")
	AtomicExpression ::= value[INTEGER_TOKEN];
}