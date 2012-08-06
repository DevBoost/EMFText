SYNTAXDEF notes
FOR <http://org.emftext/notes>
START NoteDocument

OPTIONS {
	licenceHeader ="../../org.dropsbox/licence.txt";

	reloadGeneratorModel = "true";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
	usePredefinedTokens = "false";
}

TOKENS {
	DEFINE WHITESPACE $('\t' | '\f')$;
	DEFINE LINEBREAK $('\r\n' | '\r' | '\n')$;
	DEFINE TEXT $('A'..'Z' | 'a'..'z' | '0'..'9' | '-' | ' ' )+$;
}


RULES {
	NoteDocument ::= name[] !0!0 parts*;
	Section ::= "=" name[] id['[',']']? (">" superSection['[',']'])? "=" !0 bullets*;
	BulletPoint ::= "*" textParts+ (!0 " " subPoints)*;
	SimpleText ::= text[TEXT];
	Bold ::= text['_','_'];
	Italic ::= text['#','#'];
	TypeWriter ::= text['@','@'];
}