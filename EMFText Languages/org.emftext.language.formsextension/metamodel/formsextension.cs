@SuppressWarnings(unusedResolverClass)
SYNTAXDEF formsextension
FOR <http://www.emftext.org/language/formsextension> 
START ExtendedForm

IMPORTS {
	forms : <http://www.emftext.org/language/forms> WITH SYNTAX forms <../../org.emftext.language.forms/metamodel/forms.cs>
}

OPTIONS {
	licenceHeader ="../../org.dropsbox/licence.txt";
	
	overrideBuilder = "false";
	usePredefinedTokens ="false";
	resolveProxyElementsAfterParsing = "false";
	additionalDependencies = "org.eclipse.emf.workspace,org.emftext.language.java.resource";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
}

RULES {
	ExtendedForm ::= "JavaFile:" compilationUnit['[',']'] "Method:" javaMethod['[',']'] !0 
					"FORM" caption['"','"'] !1 groups*;
}