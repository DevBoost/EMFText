SYNTAXDEF bug1154
FOR <http://www.emftext.org/test/bug1154>
START Root

OPTIONS {
	usePredefinedTokens = "false";
	generateUIPlugin = "false";
	licenceHeader = "../../org.dropsbox/licence.txt";
}

TOKENSTYLES {
	"\\begin" COLOR #FF0000;
}

RULES {
	Root ::= children*;
	
	// instances of this class should have syntax: \begin
	BackslashBegin  ::= "\\begin";

	// instances of this class should have syntax: <linebreak>
	BackslashN  ::= "\n";
	BackslashR  ::= "\r";
	BackslashT  ::= "\t";
	BackslashB  ::= "\b";
	BackslashF  ::= "\f";
	
	// instances of this class should have syntax: "
	DoubleQuote ::= "\"";
	// instances of this class should have syntax: '
	SingleQuote ::= "'";
	
	// instances of this class should have syntax: backslash
	SingleBackslash ::= "\\";
	// instances of this class should have syntax: backslash begin
	BackslashInWord ::= "\\begin";

	Percent ::= "%";
	
	UnicodeFFFF ::= "\uFFFF";
}