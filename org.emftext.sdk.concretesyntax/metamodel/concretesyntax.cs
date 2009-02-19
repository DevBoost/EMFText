SYNTAXDEF cs 
FOR       <http://www.emftext.org/sdk/concretesyntax> <concretesyntax.genmodel>
START     ConcreteSyntax

OPTIONS {
	tokenspace = "0";
	defaultTokenName = "QUALIFIED_NAME";
	usePredefinedTokens = "false";
}

TOKENS {
	DEFINE COMMENTS $'//'(~('\n'|'\r'))*$;
	DEFINE QUALIFIED_NAME $('A'..'Z'|'a'..'z'|'_')('A'..'Z'|'a'..'z'|'_'|'-'|'0'..'9')*('.'('A'..'Z'|'a'..'z'|'_'|'-'|'0'..'9')+)*$;
	DEFINE NUMBER $('0'..'9')+$;
	DEFINE WHITESPACE $(' '|'\t'|'\f')$;
	DEFINE LINEBREAK $('\r\n'|'\r'|'\n')$;
}

RULES {

  ConcreteSyntax ::= 
    modifier? #1
    "SYNTAXDEF" #1 name[] !0 
    "FOR" #1 package['<','>'] (#1 packageLocationHint['<','>'])? !0 
    ("START" #1 (startSymbols[]) ("," (startSymbols[]))*)? 
    (!0 !0 "IMPORTS" "{" ( !2 imports)* !0 "}")? 
    (!0 !0 "OPTIONS" "{" (!2 options ";" )*  !0 "}")? 
    (!0 !0 "TOKENS" "{" ( !2 tokens ";")* !0 "}")? 
    !0 !0 "RULES" "{" ( !2 rules+) !0"}"
    ;

  Import         ::=  prefix[] ":" package['<','>'] (#1 packageLocationHint['<','>'])? ( #1 "WITH" #1 "SYNTAX" #1 concreteSyntax[] (#1 csLocationHint['<','>'])?)?;
 
  //Note: There are additional OCL expressions in the model which check whether an option is allowed
  
  Option 		::= name[] "=" value['"','"'];
 
  Rule           ::= !0 ( metaclass[] ) "::=" definition ";" !0;
 
  Sequence       ::= parts+;
 
  Choice         ::= options ("|" options)* #1;	

  CsString       ::= #1 value['"','"'] #1 ;
  
  DefinedPlaceholder ::= feature[] "["  token[] "]" cardinality?;
  
  DerivedPlaceholder ::=  feature[] "[" ( prefix['\'','\''] ("," suffix['\'','\''] )? )? "]" #1 cardinality?;
  
  Containment ::=  feature[] (":" types[] ("," types[])*)? cardinality? #1 ;
  
  CompoundDefinition ::= "(" definitions ")" cardinality?;

  PLUS ::= "+";
  STAR ::= "*";   
  QUESTIONMARK ::= "?";
  
  WhiteSpaces    ::= "#" amount[NUMBER] #1;
  LineBreak      ::= "!" tab[NUMBER] #1;
  
  NormalToken ::= "DEFINE" #1 name[] regex['$','$'] ("COLLECT" "IN" attributeName[])?;
  DecoratedToken ::= "DEFINE" #1 name[] ( "[" ( prefix['\'','\''] ) "]" ) regex['$','$']  ( "[" ( suffix['\'','\'']) "]" ) ("COLLECT" "IN" attributeName[])?;
  PreDefinedToken ::= "PREDEFINED" #1 name[] ("COLLECT" "IN" attributeName[])?;

  Abstract ::= "ABSTRACT";
}