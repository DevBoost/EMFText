SYNTAXDEF cct2 // == code completion test2
FOR <http://www.emftext.org/test/cct2>
START Sequence, StarSequence, OptionalSequence, PlusSequence, Containment

OPTIONS {
	reloadGeneratorModel = "true";
	usePredefinedTokens = "false";
	licenceHeader = "../../org.dropsbox/licence.txt";
}

TOKENS {
	DEFINE COMMENT    $'//'(~('\n'|'\r'))*$;
	DEFINE WHITESPACE $(' '|'\t'|'\f')$;
	DEFINE LINEBREAK  $('\r\n'|'\r'|'\n')$;
}

RULES {
	StarSequence ::= "SS" ("a" "b")* "end1";
	OptionalSequence ::= "OS" ("c" "d")? "end2";
	Sequence ::= "S" "e" "f" "end3";
	PlusSequence ::= "PS" ("g" "h")+ "end4";
	
	Containment ::= "CM" feature;
	ContainmentA ::= "CA";
	ContainmentB ::= "CB";
}