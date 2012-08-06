SYNTAXDEF formsembedded
FOR <http://www.emftext.org/language/formsembedded>
START java.Containers.CompilationUnit

IMPORTS {
	forms : <http://www.emftext.org/language/forms> WITH SYNTAX forms <../../org.emftext.language.forms/metamodel/forms.cs>
	java : <http://www.emftext.org/java> WITH SYNTAX java <../../org.emftext.language.java/metamodel/java.cs>
}

OPTIONS {
	licenceHeader ="../../org.dropsbox/licence.txt";
	usePredefinedTokens = "false";
	generateCodeFromGeneratorModel = "false"; 
	defaultTokenName = "IDENTIFIER";
	tokenspace = "1";
	overrideBuilder = "false" ;
	disableLaunchSupport = "true";

	disableDebugSupport = "true";

}

TOKENS {
	REDEFINE forms.QUOTED_34_34 AS STRING_LITERAL java.STRING_LITERAL;
	REDEFINE forms.TEXT AS IDENTIFIER java.IDENTIFIER;
}

RULES {

	@SuppressWarnings(featureWithoutSyntax)
	EmbeddedForm ::= "#form" "{" form "}";
}