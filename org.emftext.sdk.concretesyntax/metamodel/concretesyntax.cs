SYNTAXDEF cs 
FOR       <http://www.emftext.org/sdk/concretesyntax> <concretesyntax.genmodel>
START     ConcreteSyntax

OPTIONS {	
	licenceHeader ="platform:/resource/org.reuseware/licence.txt";
	tokenspace = "0";
	defaultTokenName = "QUALIFIED_NAME";
	usePredefinedTokens = "false";
	overrideManifest = "false";
	overrideHoverTextProvider = "false";
	overrideProblemClass = "false";
	disableBuilder = "true";
	// we need to disable the use of the EMF validation framework, because
	// it does not run outside of Eclipse properly, which conflicts with
	// the EMFText ANT task 
	disableEMFValidationConstraints = "true";
	// we also need to disable the EValidators since they do cause problems
	// as well 
	disableEValidators = "true";
}

TOKENS {
	DEFINE COMMENTS $'//'(~('\n'|'\r'))*$;
	DEFINE QUALIFIED_NAME $('A'..'Z'|'a'..'z'|'_')('A'..'Z'|'a'..'z'|'_'|'-'|'0'..'9')*('.'('A'..'Z'|'a'..'z'|'_'|'-'|'0'..'9')+)*$;
	DEFINE NUMBER $('0'..'9')+$;
	DEFINE HEXNUMBER $'#'('0'..'9'|'A'..'F'|'a'..'f')+$;
	DEFINE STRING $'"'('\\'('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')|('\\''u'('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F')('0'..'9'|'a'..'f'|'A'..'F'))|'\\'('0'..'7')|~('\\'|'"'))*'"'$;
	DEFINE WHITESPACE $(' '|'\t'|'\f')$;
	DEFINE LINEBREAK $('\r\n'|'\r'|'\n')$;
}

TOKENSTYLES {
	"NUMBER" COLOR #00D0FF;
	"HEXNUMBER" COLOR #00D0FF;
	"DEFINE" COLOR #FF9000, BOLD;
	"FRAGMENT" COLOR #FF9000, BOLD;
	"COLLECT" COLOR #FF9000, BOLD;
	"IN" COLOR #FF9000, BOLD;
	"COLOR" COLOR #FF9000, BOLD;
	"PRIORITIZE" COLOR #FF9000, BOLD;
	"COMMENTS" COLOR #008000;

	"ABSTRACT" COLOR #800040, BOLD;
	"SYNTAXDEF" COLOR #800040, BOLD;
	"FOR" COLOR #800040, BOLD;
	"START" COLOR #800040, BOLD;
	"IMPORTS" COLOR #800040, BOLD;
	"OPTIONS" COLOR #800040, BOLD;
	"TOKENS" COLOR #800040, BOLD;
	"TOKENSTYLES" COLOR #800040, BOLD;
	"RULES" COLOR #800040, BOLD;
	
	"STRING" COLOR #2A00FF;
	"QUOTED_60_62" COLOR #000000;
	"QUOTED_39_39_92" COLOR #2A00FF;
}

RULES {

	ConcreteSyntax ::= 
		(annotations !0)* 
		(modifier #1)?
		"SYNTAXDEF" #1 name[] !0 
		"FOR" #1 package['<','>'] (#1 packageLocationHint['<','>'])? !0 
		("START" #1 (startSymbols[]) ("," (startSymbols[]))*)? 
		(!0 !0 "IMPORTS" #1 "{" ( !1 imports)* !0 "}")? 
		(!0 !0 "OPTIONS" #1 "{" (!1 options ";" )*  !0 "}")? 
		(!0 !0 "TOKENS" #1 "{" ( !1 tokens ";")* !0 "}")? 
		(!0 !0 "TOKENSTYLES" #1 "{" ( !1 tokenStyles)* !0 "}")? 
		 !0 !0 "RULES" #1 "{" (!1 rules)* !0 "}"
		;

	Import         ::= prefix[] ":" package['<','>'] (#1 packageLocationHint['<','>'])? ( #1 "WITH" #1 "SYNTAX" #1 concreteSyntax[] (#1 csLocationHint['<','>'])?)?;
 
	Option 	       ::= type[] "=" value[STRING];
 
	@Foldable
	Rule           ::= (!0 annotations)* !0 metaclass[] "::=" children : Choice ";" !0;
 
	Sequence       ::= children : Definition +;
 
	Choice         ::= children : Sequence ("|" children : Sequence)* #1;	

	CsString       ::= #1 value[STRING] #1 ;
	
	PlaceholderUsingSpecifiedToken ::= feature[] "[" token[] "]" cardinality?;
	PlaceholderUsingDefaultToken   ::= feature[] "[" "]" cardinality?;
	PlaceholderInQuotes            ::= feature[] "[" prefix['\'','\'','\\'] "," suffix['\'','\'','\\'] ("," escapeCharacter['\'','\'','\\'])? "]" #1 cardinality?;
	
	Containment        ::=  feature[] (":" types[] ("," types[])*)? cardinality? #1 ;
	
	CompoundDefinition ::= "(" children : Choice ")" cardinality?;

	WhiteSpaces  ::= amount[HEXNUMBER] #1;
	LineBreak    ::= "!" tab[NUMBER] #1;
	
	NormalTokenDefinition  ::= (annotations !0)* "DEFINE" #1 name[] #1 regexParts (#1 "+" #1 regexParts)* (#1 "COLLECT" #1 "IN" #1 attributeName[])?;
	PartialTokenDefinition ::= "DEFINE" #1 "FRAGMENT" #1 name[] #1 regexParts (#1 "+" #1 regexParts)*;
	TokenPriorityDirective ::= "PRIORITIZE" #1 token[];
	
	AtomicRegex    ::= atomicExpression['$','$'];
	RegexReference ::= target[];

	PLUS         ::= "+";
	STAR         ::= "*";   
	QUESTIONMARK ::= "?";
	
	Abstract ::= "ABSTRACT";
	
	TokenStyle ::= tokenName[STRING] #1 "COLOR" #1 rgb[HEXNUMBER] ("," #1 fontStyles[])* ";";
	
	Annotation ::= "@" type[] ("(" parameters ("," parameters)* ")")?;
	
	KeyValuePair ::= key[] ("=" value[STRING])?;
}