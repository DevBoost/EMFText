SYNTAXDEF multicharsuffix
FOR <http://www.emftext.org/language/multicharsuffix>
START NamedElement

OPTIONS {
	licenceHeader ="../../org.dropsbox/licence.txt";
	usePredefinedTokens = "false";
	generateUIPlugin = "false";
}

// this is a test syntax for bug 992
RULES {
	
	@SuppressWarnings(explicitSyntaxChoice)
	NamedElement ::= 
		// prefix and suffix with multiple characters, no escape character
		("variant1" name['{{','}}'] ";") |
		// prefix and suffix with one character, single escape character
		("variant2" name['<','>','-'] ";") |
		// prefix and suffix with one character, escape character sequence
		("variant3" name['(',')','##'] ";") |
		// prefix and suffix with multiple characters, escape character sequence
		("variant4" name['abc','def','***'] ";")
		;
}