SYNTAXDEF duplicate_feature1
FOR <http://www.emftext.org/language/duplicate_feature1> <duplicate_feature1.genmodel>
START Root

OPTIONS {
	usePredefinedTokens = "false";
}

RULES {
	// here we should NOT get a warning about the feature 'containment'
	// because it is used twice, but there is only one possible result of 
	// printing 
	Root ::= "Root" (containment (containment)*)?;
	
	Sub ::= "Sub";
}