SYNTAXDEF bug1405
FOR <http://www.emftext.org/language/bug1405> <bug1405.genmodel>
START Root

OPTIONS {
	usePredefinedTokens = "false";
}

RULES {
	// here we should get a warning about the feature 'containment'
	// because it is used twice with optional cardinality, which
	// can cause problem while printing
	Root ::= "Root" (containment)* (containment)*;
	
	Sub ::= "Sub";
}