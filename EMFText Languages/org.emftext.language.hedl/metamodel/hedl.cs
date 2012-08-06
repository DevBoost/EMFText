@SuppressWarnings(noRuleForMetaClass)

SYNTAXDEF hedl
FOR <http://www.emftext.org/language/hedl>
START EntityModel

OPTIONS {
	licenceHeader ="../../org.dropsbox/licence.txt";
	
	disableLaunchSupport = "true";
	disableDebugSupport = "true";
	usePredefinedTokens = "false";
	overrideBuilder = "false";
	overrideIgnoredWordsFilter = "false";
	overrideDynamicTokenStyler = "false";
	additionalDependencies = "org.eclipse.emf.workspace,org.emftext.language.hedl.codegen";
}

TOKENS {
	DEFINE UPPER $('A'..'Z')('A'..'Z'|'a'..'z'|'0'..'9'|'_'|'.')*$;
	DEFINE LOWER $('a'..'z')('A'..'Z'|'a'..'z'|'0'..'9'|'_'|'.')*$;
	
	DEFINE WHITESPACE $(' '|'\t'|'\f')+$;
	DEFINE LINEBREAK  $('\r'|'\n')+$;
	DEFINE COMMENT $'//'(~('\n'|'\r'))*$;
	DEFINE ML_COMMENT $'/**'.*'*/'$;
}

TOKENSTYLES {
	"UPPER" COLOR #000000, BOLD;
	"ML_COMMENT" COLOR #3F5FBF;
	"COMMENT" COLOR #3F7F5F;
}

RULES {
	EntityModel ::= (options !0)* !0 ((entities | enums) !0 !0)*;
	
	Option ::= key[
				PreserveTableNames : "preserveTableNames" ,
				PreserveColumnNames : "preserveColumnNames"] 
				"=" value[LOWER];
	
	Entity ::= 
		comment[ML_COMMENT]? 
		name[UPPER] 
		("extends" superType[UPPER])? 
		("implements" implementedInterfaces[LOWER] ("," implementedInterfaces[LOWER])*)? 
		"{" (!1 properties)* (!1 constraints)* !0 "}";
	
	Property ::=
		comment[ML_COMMENT]?  
		readonly["readonly" : ""] 
		nullable["nullable" : ""] 
		unique["unique" : ""] 
		persist["persist" : ""] 
		refresh["refresh" : ""] 
		eager["eager" : ""] 
		type[UPPER]
		fromMultiplicity["*" : ""]
		name[LOWER] 
		toMultiplicity["*" : ""]
		("<=" mappedBy[LOWER])?
		";";
		
	Enum ::= comment[ML_COMMENT]? "enum" name[UPPER] "{" literals* "}";
	
	EnumLiteral ::= comment[ML_COMMENT]? name[UPPER];
	
	UniqueConstraint ::= "unique" "(" properties[LOWER] properties[LOWER]+ ")";
}