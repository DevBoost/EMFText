SYNTAXDEF dbschema
FOR <http://www.emftext.org/language/dbschema>
START DBSchema

OPTIONS {
	usePredefinedTokens = "false";
	defaultTokenName = "TEXT";
	
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
	disableNewProjectWizard = "true";
	overrideNewFileWizard = "false";
	
	additionalUIDependencies = "org.emftext.language.dbschema.discovery";
	licenceHeader = "../../org.dropsbox/licence.txt";
}

TOKENS {
	DEFINE TEXT $('A'..'Z' | 'a'..'z' | '0'..'9' | '_' | '-' | '.' )+$;
	DEFINE WHITESPACE $(' ' | '\t' | '\f')$;
	DEFINE LINEBREAK $('\r\n' | '\r' | '\n')$;
	DEFINE COMMENTS $'//'(~('\n'|'\r'))*$;
}

TOKENSTYLES {
	"COMMENTS" COLOR #008000;
	"primary" COLOR #800080, BOLD;
}

RULES {
	DBSchema ::= "schema" name[] (!0 !0 tables)*;
	Table    ::= "table" name[] "(" (!1 columns)* ")";
	AttributeColumn  ::= primary["primary" : ""] name[] type[] "(" size[] ")";
	ForeignKeyColumn ::= primary["primary" : ""] name[] type[] "(" size[] ")" #1 "references" referencedColumn[];
}