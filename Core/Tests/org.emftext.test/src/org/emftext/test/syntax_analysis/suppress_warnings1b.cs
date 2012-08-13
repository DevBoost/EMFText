SYNTAXDEF suppress_warnings1b
FOR <http://www.emftext.org/test/suppress_warnings1> <suppress_warnings1.genmodel>

START Root

OPTIONS {
	usePredefinedTokens = "false";
}

RULES {
	// Here we should get 1 warning (optional keyword), because @SuppressWarnings 
	// is only set for warnings of type 'featureWithoutSyntax'
	@SuppressWarnings(featureWithoutSyntax)
	Root ::= "ROOT" ("somethingOptional")?;
}