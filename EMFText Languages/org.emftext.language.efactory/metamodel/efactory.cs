SYNTAXDEF efactory
FOR <http://www.googlecode.com/efactory/EFactory>
START Factory

IMPORTS {
	somePrefix : <http://www.eclipse.org/emf/2002/Ecore>
}

OPTIONS {
	licenceHeader ="../../org.dropsbox/licence.txt";
	
	overrideBuilder = "false";
	usePredefinedTokens = "false";
	disableLaunchSupport = "true";
	disableDebugSupport = "true";

	additionalDependencies = "org.eclipse.emf.ecore.xmi";
}

TOKENS {
	DEFINE LONG $('-')?('0'..'9')+$;
	DEFINE DOUBLE $('-')?('0'..'9')+'.'('0'..'9')+$;
	DEFINE DATE $('0'..'1')'0'..'9''.''0'..'3''0'..'9''.' '0'..'9''0'..'9''0'..'9''0'..'9'$;
	DEFINE PLUS_EQUALS $'+''='$;
	DEFINE EQUALS $'='$;
	DEFINE BOOLEAN $'true'|'false'$;
	DEFINE STRING $('"')(('\\''"')|('\\''\\')|~('"'|'\\'))*('"')$;
	
	@SuppressWarnings(tokenOverlapping)
	DEFINE IDENTIFIER $('A'..'Z'|'a'..'z'|'_')('A'..'Z'|'a'..'z'|'0'..'9'|'_'|'-')*$;
	
	@SuppressWarnings(unusedToken)
	DEFINE WHITESPACE $(' '|'\t'|'\f')$;
	@SuppressWarnings(unusedToken)
	DEFINE LINEBREAKS $('\r\n'|'\r'|'\n')$;
	@SuppressWarnings(unusedToken)
	DEFINE SL_COMMENT $'//'(~('\n'|'\r'|'\uffff'))*$;
}

TOKENSTYLES {
	"SL_COMMENT" COLOR #00A000;
}

RULES {
	Factory ::= epackages+ imports* annotations* roots+;

	PackageImport::= "use" #1 ePackage[STRING] (#1 "as" #1 alias[IDENTIFIER])? !0;

	ModelImport ::= "import" #1 importedModel[STRING] !0;

	GlobalNameMapping ::= "@Name" "{" #1 nameFeature[IDENTIFIER] #1 "}";
	CustomNameMapping ::= "@Name" "{" #1 eClass[IDENTIFIER] #1 "=" #1 nameFeature[IDENTIFIER] #1 "}";
	
	Feature ::= eFeature[IDENTIFIER] (#1 isMany[PLUS_EQUALS] |#0isMany[EQUALS]) #1 value !0;
	
	NewObject ::= "new" #1 eClass[IDENTIFIER] #1 (name[IDENTIFIER])? ("{" !1 features*"}"!0)?;
	
	Reference ::= value[IDENTIFIER];
	Containment ::= value;

	EnumAttribute ::= ":" value[STRING];
	StringAttribute ::= value[STRING];
	IntegerAttribute ::= value[LONG];
	DoubleAttribute ::= value[DOUBLE];
	DateAttribute ::= value[DATE];
	NullAttribute ::= "NULL";

	BooleanAttribute ::= value[BOOLEAN];	
}