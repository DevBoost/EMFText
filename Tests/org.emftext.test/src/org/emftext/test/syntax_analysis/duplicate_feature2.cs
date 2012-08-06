SYNTAXDEF duplicate_feature2
FOR <http://www.emftext.org/language/duplicate_feature1> <duplicate_feature1.genmodel>
START Root

OPTIONS {
	usePredefinedTokens = "false";
}

RULES {
	// here we should get a warning about the feature 'containment'
	// because it is used twice and it is not clear whether the
	// first occurrence must be printed or not
	Root ::= "Root" (containment)? (containment)*;
	
	Sub ::= "Sub";
}