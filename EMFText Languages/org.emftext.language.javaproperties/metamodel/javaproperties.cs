SYNTAXDEF properties
FOR <http://www.emftext.org/language/javaproperties>
START PropertySet

OPTIONS {
	usePredefinedTokens = "false";
	overrideDynamicTokenStyler = "false";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
	licenceHeader = "../../org.dropsbox/licence.txt";
}

TOKENS {
	DEFINE COMMENT1 $(' '|'/t'|'/f')*'#'(~('\n'|'\r'|'\uffff'))*('\r\n'|'\r'|'\n')$;
	DEFINE COMMENT2 $'!'(~('\n'|'\r'|'\uffff'))*('\r\n'|'\r'|'\n')$;
	DEFINE KEY $('a'..'z'|'A'..'Z'|'0'..'9')(~(' '|'\t'|'\f'|'='|':'|'#'|'\r\n'|'\r'|'\n'))+$;
	DEFINE VALUE $(('='|':'|' '|'\t'|'\f')+)(('\\'('\r\n'|'\r'|'\n'))|('\\''\\')|~('\r\n'|'\u001C'|'\r'|'\n'|'\\'))*('\r\n'|'\r'|'\n'|'\u001C')$;
	DEFINE WHITESPACE $(' '|'\t'|'f')$;
	DEFINE LINEBREAK $('\r\n'|'\r'|'\n')$;
}

TOKENSTYLES {
	"KEY"   COLOR #07a8ec, BOLD;
	"VALUE" COLOR #9807ec, BOLD;
	"COMMENT1"   COLOR #06bd0e, ITALIC;
	"COMMENT2"   COLOR #06bd0e, ITALIC;
}

RULES {
	PropertySet  ::= properties*;
	KeyValuePair ::= key[KEY] (#1 value[VALUE])? | key[VALUE];
}