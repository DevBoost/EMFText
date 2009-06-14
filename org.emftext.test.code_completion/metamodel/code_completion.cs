SYNTAXDEF cct // == code completion test
FOR <http://www.emftext.org/test/code_completion>
START Class

OPTIONS {
	reloadGeneratorModel = "true";
}

TOKENS {
	DEFINE COMMENT $'//'(~('\n'|'\r'))*$;
}

RULES {
	
	Class  ::= visibility[] "class" name[] "{" members* "}";
		
	Field  ::= visibility[] type[] name[] ";";
		
	Method ::= visibility[] "void" name[] "(" ")" "{" "}";	
}