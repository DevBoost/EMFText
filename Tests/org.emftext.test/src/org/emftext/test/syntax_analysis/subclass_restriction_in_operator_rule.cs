SYNTAXDEF subclass_restriction_in_operator_rule
FOR <http://www.emftext.org/test/subclass_restriction_in_operator_rule> <subclass_restriction_in_operator_rule.genmodel>

START Root

OPTIONS {
	usePredefinedTokens = "false";
}

RULES {
	Root ::= "ROOT" exp;
	
	@Operator(type="binary_left_associative", superclass="Expression", weight="1")
	BinaryOperation ::= left "+" right;

	@Operator(type="primitive", superclass="Expression", weight="2")
	BrackerExp ::= "(" body : BinaryOperation ")";

	@Operator(type="primitive", superclass="Expression", weight="3")
	Constant ::= "C";
}