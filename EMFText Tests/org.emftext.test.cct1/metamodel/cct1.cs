SYNTAXDEF cct1 // == code completion test 1
FOR <http://www.emftext.org/test/cct1>
START Class

OPTIONS {
	reloadGeneratorModel = "true";
	licenceHeader = "../../org.dropsbox/licence.txt";
}

TOKENS {
	DEFINE COMMENT $'//'(~('\n'|'\r'))*$;
}

TOKENSTYLES {
	"class" COLOR #FF0000, BOLD;
	"void" COLOR #FF0000, BOLD;
}

RULES {
	
	Class  ::= visibility[] "class" name[] "{" members* "}";
		
	Field  ::= visibility[] type[] name[] ";";
	
	@Foldable	
	Method ::= visibility[] "void" name[] "(" ")" "{" "}";	
}