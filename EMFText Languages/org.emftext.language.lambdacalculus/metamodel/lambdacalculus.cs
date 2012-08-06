SYNTAXDEF lambda
FOR <http://www.emftext.org/language/lambdacalculus>
START Root

OPTIONS {
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
	licenceHeader = "../../org.dropsbox/licence.txt";
}

TOKENSTYLES {
	"(" COLOR #A00000, BOLD;
	"(\\" COLOR #A00000, BOLD;
	")" COLOR #A00000, BOLD;
	"." COLOR #A00000, BOLD;
}

RULES {

	Root ::= expression;
	
	BoundVar ::= name[];

	FreeVar ::= name[];

	//@Operator(superclass="Expr", weight="1", type="binary_left_associative")
	Appl ::= "(" function argument ")";

	//@Operator(superclass="Expr", weight="1", type="binary_left_associative")
	Abstr ::= "(\\" boundVar "." body ")";
	
	//@Operator(superclass="Expr", weight="1", type="primitive")
	Ref ::= refersTo[];
}