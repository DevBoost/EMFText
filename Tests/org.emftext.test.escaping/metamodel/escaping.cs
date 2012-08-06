SYNTAXDEF escaping
FOR <http://www.emftext.org/test/escaping>
START DoubleQuote,LineBreak,Backslash

OPTIONS {
	reloadGeneratorModel = "true";
	usePredefinedTokens = "false";
	generateUIPlugin = "false";
	licenceHeader = "../../org.dropsbox/licence.txt";
}

TOKENS {
	DEFINE COMMENT    $'//'(~('\n'|'\r'))*$;
	DEFINE WHITESPACE $(' '|'\t'|'\f')$;
	//DEFINE LINEBREAK  $('\r\n'|'\r'|'\n')$;
}

RULES {
	DoubleQuote ::= "DoubleQuote" "\"";
	LineBreak ::= "LineBreak" "\n";
	Backslash ::= "Backslash" "\\";
}