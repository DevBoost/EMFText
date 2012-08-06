SYNTAXDEF bug1844
FOR <http://www.emftext.org/test/bug1844>
START Root

RULES {
	Root ::= expression;

	@Operator(type="binary_left_associative", weight="1", superclass="Expression") 
	Plus ::= left "+" right;
	
	@Operator(type="unary_prefix", weight="1", superclass="Expression") 
	Negation ::= "!" body;
	
	@Operator(type="primitive", weight="3", superclass="Expression")
	Number ::= value[];
}
