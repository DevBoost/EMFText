SYNTAXDEF duplicate_feature3
FOR <http://www.emftext.org/language/duplicate_feature1> <duplicate_feature1.genmodel>
START Root

OPTIONS {
	usePredefinedTokens = "false";
}

RULES {
	// here we should get a warning about the feature 'containment'
	// because it is used three times and the second and third occurrence
	// do not determine where to print elements
	Root ::= "Root" (containment (containment)* containment+)?;
	
	Sub ::= "Sub";
}