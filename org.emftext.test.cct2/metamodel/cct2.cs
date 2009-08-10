SYNTAXDEF cct2 // == code completion test2
FOR <http://www.emftext.org/test/cct2>
START Sequence, StarSequence, OptionalSequence, PlusSequence

OPTIONS {
	reloadGeneratorModel = "true";
	usePredefinedTokens = "false";
}

TOKENS {
	DEFINE COMMENT $'//'(~('\n'|'\r'))*$;
	DEFINE WHITESPACE $(' '|'\t'|'\f')$;
	DEFINE LINEBREAK $('\r\n'|'\r'|'\n')$;
}

RULES {
	StarSequence ::= "SS" ("a" "b")* "end";
	OptionalSequence ::= "OS" ("c" "d")? "end";
	Sequence ::= "S" "e" "f" "end";
	PlusSequence ::= "PS" ("g" "h")+ "end";
}