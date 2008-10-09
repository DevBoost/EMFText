SYNTAXDEF simpletemplate
FOR <http://www.reuseware.org/simple_template>
START Template

RULES {
	Template ::= content;
	
	Condition ::= "<%" "if" "(" value[] ")" "{" "%>" body "<%" "}" "%>" ;
	
	Loop ::= "<%" "for" "(" count[] ")" "{" "%>" body "<%" "}" "%>" ;
	
	Placeholder ::= "<%=" pathToInputModelElement[] "%>" ;
	
	CompoundSection ::= contents* ;
	
	Static ::= text[];
}