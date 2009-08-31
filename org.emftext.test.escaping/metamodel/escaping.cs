SYNTAXDEF escaping
FOR <http://www.emftext.org/test/escaping>
START Root

OPTIONS {
	reloadGeneratorModel = "true";
	usePredefinedTokens = "false";
}

TOKENS {
	DEFINE COMMENT    $'//'(~('\n'|'\r'))*$;
	DEFINE WHITESPACE $(' '|'\t'|'\f')$;
	DEFINE LINEBREAK  $('\r\n'|'\r'|'\n')$;
}

RULES {
	Root ::= "Root" "\"";
}