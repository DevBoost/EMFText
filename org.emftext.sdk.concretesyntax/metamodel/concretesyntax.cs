SYNTAXDEF cs 
FOR       <http://www.emftext.org/sdk/concretesyntax> <concretesyntax.genmodel>
START     ConcreteSyntax

OPTIONS {
	tokenspace = "0";
	defaultTokenName = "QUALIFIED_NAME";
	usePredefinedTokens = "false";
	overrideManifest = "false";
	overrideNewFileWizard = "false";
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
	"NUMBER" COLOR #00D0FF;
	"HEXNUMBER" COLOR #00D0FF;
	"DEFINE" COLOR #FF9000, BOLD;
	"PRIORITIZE" COLOR #FF9000, BOLD;
	"COMMENTS" COLOR #008000;
}

RULES {

  ConcreteSyntax ::= 
    modifier? #1
    "SYNTAXDEF" #1 name[] !0 
    "FOR" #1 package['<','>'] (#1 packageLocationHint['<','>'])? !0 
    ("START" #1 (startSymbols[]) ("," (startSymbols[]))*)? 
    (!0 !0 "IMPORTS" "{" ( !1 imports)* !0 "}")? 
    (!0 !0 "OPTIONS" "{" (!1 options ";" )*  !0 "}")? 
    (!0 !0 "TOKENS" "{" ( !1 tokens ";")* !0 "}")? 
    (!0 !0 "TOKENSTYLES" "{" ( !1 tokenStyles)* !0 "}")? 
    !0 !0 "RULES" "{" ( !1 rules+) !0"}"
    ;

  Import         ::= prefix[] ":" package['<','>'] (#1 packageLocationHint['<','>'])? ( #1 "WITH" #1 "SYNTAX" #1 concreteSyntax[] (#1 csLocationHint['<','>'])?)?;
 
  //Note: There are additional OCL expressions in the model which check whether an option is allowed
  
  Option 		 ::= type[] "=" value['"','"'];
 
  Rule           ::= (!0 annotations)* !0 metaclass[] "::=" definition ";" !0;
 
  Sequence       ::= parts+;
 
  Choice         ::= options ("|" options)* #1;	

  CsString       ::= #1 value['"','"'] #1 ;
  
  PlaceholderUsingSpecifiedToken ::= feature[] "[" token[] "]" cardinality?;
  PlaceholderUsingDefaultToken ::= feature[] "[" "]" cardinality?;
  PlaceholderInQuotes ::= feature[] "[" prefix['\'','\''] "," suffix['\'','\''] "]" #1 cardinality?;
  
  Containment        ::=  feature[] (":" types[] ("," types[])*)? cardinality? #1 ;
  
  CompoundDefinition ::= "(" definitions ")" cardinality?;

  WhiteSpaces  ::= amount[HEXNUMBER] #1;
  LineBreak    ::= "!" tab[NUMBER] #1;
  
  NormalToken     ::= (annotations !0)* "DEFINE" #1 name[] regex['$','$'] ("COLLECT" "IN" attributeName[])?;
  TokenPriorityDirective ::= "PRIORITIZE" #1 token[];

  PLUS         ::= "+";
  STAR         ::= "*";   
  QUESTIONMARK ::= "?";
  
  Abstract ::= "ABSTRACT";
  
  TokenStyle ::= tokenName['"','"'] "COLOR" rgb[HEXNUMBER] ("," fontStyles[])* ";";
  
  Annotation ::= "@" type[] ("(" parameters ("," parameters)* ")")?;
  
  KeyValuePair ::= key[] ("=" value['"','"'])?;
}