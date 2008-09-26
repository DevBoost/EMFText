SYNTAXDEF simplegui
FOR <http://www.reuseware.org/simple_gui>
START Frame

RULES {
	Frame ::= "F" "(" name[] ")" "contains" children* ";";
	
	Panel ::= "P" "(" name[] ")" "contains" children* ";";
	
	Button ::= "B" "(" name[] ")";

	Label ::= "L" "(" name[] ")";
	
	Image ::= "I" "(" key[] ")";
}