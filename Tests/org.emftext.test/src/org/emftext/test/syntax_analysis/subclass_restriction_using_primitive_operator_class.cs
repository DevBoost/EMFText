@SuppressWarnings(unreachableRule)
SYNTAXDEF subclass_restriction_using_primitive_operator_class
FOR <http://www.emftext.org/test/subclass_restriction_using_operator_class> <subclass_restriction_using_operator_class.genmodel>

START Root

OPTIONS {
	usePredefinedTokens = "false";
}

RULES {
	Root ::= "ROOT" exp:Constant;
	
	@Operator(type="binary_left_associative", superclass="Expression", weight="1")
	BinaryOperation ::= left "+" right;

	@Operator(type="primitive", superclass="Expression", weight="2")
	Constant ::= "C";
}