SYNTAXDEF text
FOR <http://org.emftext/text.text.ecore>
START Document

OPTIONS {
	licenceHeader ="../../org.dropsbox/licence.txt";
	
	usePredefinedTokens = "false";
	defaultTokenName = "TEXT";
}

TOKENS {

	DEFINE TEXT $~('\n'|'\r'|'\uffff'|' '|'\t'|'\f'|'\r\n')+$ ;
	DEFINE WHITESPACE $(' '|'\t'|'\f')$;
	DEFINE LINEBREAKS $('\r\n'|'\r'|'\n')$;
}


RULES {
	Document ::= (parts)*;
	Paragraph ::= tokens:Whitespace* ((tokens:Word tokens:Whitespace* tokens:Linebreak? tokens:Whitespace*))* end:Linebreak;
	Word ::= text[TEXT];
	Whitespace ::= text[WHITESPACE];
	Linebreak ::= text[LINEBREAKS];
}