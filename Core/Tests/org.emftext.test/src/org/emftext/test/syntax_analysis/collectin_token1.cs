SYNTAXDEF collectin_token1
FOR <http://www.emftext.org/test/collectin_token1> <collectin_token1.genmodel>
START Root

OPTIONS {
	usePredefinedTokens = "false";
}

TOKENS {
	// we should also get a warning here, because COLLECT IN tokens are 
	// deprecated as of version 1.4.1 of EMFText
	DEFINE T1 $'0'..'9'$ COLLECT IN collAtt;
}

RULES {
	// here we should get a warning because T1 is an collect-in
	// token and therefore sent to channel 99. it can therefore
	// never be matched here.
	Root ::= "Root" attribute[T1];
}