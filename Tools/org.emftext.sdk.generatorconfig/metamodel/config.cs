SYNTAXDEF generatorconfig
FOR <http://www.emftext.org/sdk/generatorconfig>
START GeneratorConfig

IMPORTS{
	concretesyntax : <http://www.emftext.org/sdk/concretesyntax> WITH SYNTAX concretesyntax <platform:/plugin/org.emftext.sdk.concretesyntax/metamodel/concretesyntax.cs> 
}

OPTIONS {	
	licenceHeader ="platform:/resource/org.reuseware/licence.txt";
	defaultTokenName = "QUALIFIED_NAME";
	usePredefinedTokens = "false";
	disableBuilder = "true";
}

TOKENS {
	DEFINE COMMENTS $'//'(~('\n'|'\r'))*$;
	DEFINE QUALIFIED_NAME $('A'..'Z'|'a'..'z'|'_')('A'..'Z'|'a'..'z'|'_'|'-'|'0'..'9')*('.'('A'..'Z'|'a'..'z'|'_'|'-'|'0'..'9')+)*$;
	DEFINE NUMBER $('0'..'9')+$;
	DEFINE HEXNUMBER $'#'('0'..'9'|'A'..'F'|'a'..'f')+$;
	DEFINE WHITESPACE $(' '|'\t'|'\f')$;
	DEFINE LINEBREAK $('\r\n'|'\r'|'\n')$;
}

TOKENSTYLES {
	"GeneratorConfig" COLOR #7F0055, BOLD;
	"rules" COLOR #7F0055, BOLD;
	"Rule" COLOR #7F0055, BOLD;
	"name" COLOR #7F0055, BOLD;
	"definition" COLOR #7F0055, BOLD;
	"UnresolvedReferenceToken" COLOR #7F0055, BOLD;
	"value" COLOR #7F0055, BOLD;
	"RuleReferenceToken" COLOR #7F0055, BOLD;
	"rule" COLOR #7F0055, BOLD;
}

RULES{
	
	GeneratorConfig::= (classRules | featureRules)*;	
	GeneratorRule::= name[] "::="  definition ";";
			
	ClassRule ::= "ClassRule" name[] "::="  definition ";";
	FeatureRule ::= "FeatureRule" name[] "::="  definition ";";
	
	FeatureReference ::= "FEATURE" "(" featureName[] ")";
	ClassName ::= "CLASSNAME";
	Features ::= "FEATURES";
	
	ClassRuleReference ::= rule[];
	FeatureRuleReference ::= rule[];
	
	FeatureName ::= "FEATURENAME";
	Feature ::= "FEATURE";	
}