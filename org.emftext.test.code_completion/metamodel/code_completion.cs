SYNTAXDEF cct // == code completion test
FOR <http://www.emftext.org/test/code_completion>
START Class

OPTIONS {
	reloadGeneratorModel = "true";
}

TOKENS {
	DEFINE COMMENT $'//'(~('\\n'|'\\r'))*$;
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