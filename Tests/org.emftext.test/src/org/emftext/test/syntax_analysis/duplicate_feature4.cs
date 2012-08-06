SYNTAXDEF duplicate_feature4
FOR <http://www.emftext.org/language/duplicate_feature4> <duplicate_feature4.genmodel>
START Root

OPTIONS {
	usePredefinedTokens = "false";
}

RULES {
	// here we should NOT get a warning about the feature 'containment'
	// because it is used three times, but is clear where to print
	// the contained object
	Root ::= "Root" containment (containment (containment)*)?;
	
	Sub ::= "Sub";
}