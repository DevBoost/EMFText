SYNTAXDEF cs 
FOR       <http://www.emftext.org/sdk/concretesyntax>
START     cs.ConcreteSyntax

IMPORTS{
	cs:<http://www.emftext.org/sdk/concretesyntax>
} 

OPTIONS{
	tokenspace=0;
}

TOKENS{
	DEFINE COMMENTS $'//'(~('\n'|'\r'))*$; 
	PREDEFINED TEXT;
	DEFINE QNAME $('A'..'Z'|'a'..'z'|'_')+('.'('A'..'Z'|'a'..'z'|'_'|'-'|'0'..'9')+)+$;
}


RULES {

  ConcreteSyntax ::= "SYNTAXDEF" #1 name[] !0 "FOR" #1 package['<','>']  !0 "START" #1 (startSymbols[] | startSymbols[QNAME]) ("," (startSymbols[] | startSymbols[QNAME]))* ( !0 !0  "IMPORTS" "{" ( !2 imports)* !0 "}")? ( !0 !0 "OPTIONS" "{" (!2 options ";" )*  !0 "}")?   (!0 !0 "TOKENS" "{" ( !2 tokens ";")* !0 "}")? !0!0 "RULES" "{" ( !2 rules+) !0"}";

  Import         ::=  prefix[] ":" package['<','>'] ( #1 "WITH" #1 "SYNTAX" #1 concreteSyntax[])?;
 
  //Note: There is an additional OCL expression in the model which checks whether an option is allowed
  //Currently allowed are:
  //		 tokenspace = 0..x
  
  Option 		::= name[] "=" value[];
 
  Rule           ::= !0 ( metaclass[] | metaclass[QNAME] ) "::=" definition ";" !0;
 
  Sequence       ::= parts+;
 
  Choice         ::= options ("|" options)* #1;	

  CsString       ::= #1 value['"','"'] #1 ;
  
  DefinedPlaceholder ::= feature[] "["  token[] "]" cardinality?;
  
  DerivedPlaceholder ::=  feature[] "[" ( prefix['\'','\''] ("," suffix['\'','\''] )? )? "]" #1 cardinality?;
  
  Containment ::=  ( feature[] cardinality | feature[] ) #1 ;
  
  CompoundDefinition ::= "(" definitions ")" cardinality?;

  PLUS ::= "+";
  STAR ::= "*";   
  QUESTIONMARK ::= "?";
  
  WhiteSpaces    ::= amount['#'] #1;
  LineBreak      ::= tab['!'] #1;
  
  NormalToken ::= "DEFINE" #1 name[] regex['$','$'] ("COLLECT" "IN" attributeName[])?;
  DecoratedToken ::= "DEFINE" #1 name[] ( "[" ( prefix['\'','\''] ) "]" ) regex['$','$']  ( "[" ( suffix['\'','\'']) "]" ) ("COLLECT" "IN" attributeName[])?;
  PreDefinedToken ::= "PREDEFINED" #1 name[] ("COLLECT" "IN" attributeName[])?;

}