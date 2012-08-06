SYNTAXDEF nameWith.OneDot
FOR <http://www.emftext.org/test/nameWithDot> <nameWithDot.genmodel>
START Root

OPTIONS {
	usePredefinedTokens = "false";
	
	baseResourcePlugin = "xyz"; //the option's value is currently not validated - plugin might be out of scope
}

RULES{
	Root::= "Root"  "{"  "}"  ;
}