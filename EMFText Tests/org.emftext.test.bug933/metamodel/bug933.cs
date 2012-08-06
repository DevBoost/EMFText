SYNTAXDEF bug933
FOR <http://www.emftext.org/test/bug933>
START Root

OPTIONS {
	usePredefinedTokens = "false";
	generateUIPlugin = "false";
	licenceHeader = "../../org.dropsbox/licence.txt";
}

RULES {
	Root ::= child;
	R    ::= "R" "\r";
	N    ::= "N" "\n";
	RN   ::= "RN" "\r\n";
	SQUOTE   ::= "SQ" "'";
	DQUOTE   ::= "DQ" "\"";
	BACKSLASH ::= "BS" "\\";
}