SYNTAXDEF webtest
FOR <http://www.emftext.org/language/webtest>
START TestScript


OPTIONS {
	licenceHeader ="../../org.dropsbox/licence.txt";
	usePredefinedTokens = "false";
	defaultTokenName = "IDENTIFIER";
	additionalDependencies = "org.emftext.language.webtest.htmlunit";
	additionalExports = "org.emftext.language.webtest.resource.webtest.interpreter";
	overrideLaunchConfigurationDelegate = "false";
}


TOKENS {
	DEFINE IDENTIFIER $('A'..'Z' | 'a'..'z' | '-'| '_')('A'..'Z' | 'a'..'z' | '0'..'9' | '-'| '_')*$;
	DEFINE WHITESPACE $(' ' | '\t' | '\f')$;
	DEFINE LINEBREAK $('\r\n' | '\r' | '\n')$;
	DEFINE INTEGER $('-')?('1'..'9')('0'..'9')*|'0'$;
	DEFINE FLOAT $('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ $;
	DEFINE SL_COMMENT $'//'(~('\n'|'\r'|'\uffff'))*$;
}


RULES {
	TestScript ::= "testScript" commands*;
	Load ::= "load" url['<','>'];
	Submit ::= "submit" form[] button[];
	Input ::= "input" form[] field[] value['"','"'];
	AssertTitle ::= "assertTitle" expected['"','"'];
	AssertText  ::= "assertText" expected['"','"'];
}