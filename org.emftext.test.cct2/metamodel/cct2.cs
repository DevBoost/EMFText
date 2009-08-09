SYNTAXDEF cct2 // == code completion test2
FOR <http://www.emftext.org/test/cct2>
START StarSequence

OPTIONS {
	reloadGeneratorModel = "true";
}

TOKENS {
	DEFINE COMMENT $'//'(~('\n'|'\r'))*$;
}

RULES {
	StarSequence ::= ("a" "b")* "end";
}