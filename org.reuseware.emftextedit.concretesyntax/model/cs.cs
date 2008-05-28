SYNTAXDEF cs 
FOR       <http://www.reuseware.org/emftextedit/concretesyntax>
START     ConcreteSyntax

TOKENS{
	DEFINE COMMENTS $'//'(~('\n'|'\r'))*$; 
	PREDEFINED TEXT;
	DEFINE QNAME $('A'..'Z'|'a'..'z'|'_')+('.'('A'..'Z'|'a'..'z'|'_'|'-'|'0'..'9')+)+$;
}
//comment


RULES {

  ConcreteSyntax ::= "SYNTAXDEF" name[] !0 "FOR" package['<','>']  !0 "START" startSymbols[] ("," startSymbols[])* !0 !0 ("IMPORTS" "{" ( !2 imports)* !0 "}")? !0 !0 ("TOKENS" "{" ( !2 tokens ";")* !0 "}")? !0!0 "RULES" "{" ( !2 rules+) !0"}";

  Import         ::= prefix[] ":" package['<','>'] ("WITH" "SYNTAX" concreteSyntax[])?;

  Rule           ::= ( metaclass[] | metaclass[QNAME] ) "::=" definition #0 ";";
 
  Sequence       ::= parts+;
 
  Choice         ::= options ("|" options)* #0;	

  CsString       ::= value['"','"'];
  
  DefinedPlaceholder ::= feature[] "["  #0 token[] #0  "]" #0 cardinality?;
  
  DerivedPlaceholder ::=  feature[] "[" ( prefix['\'','\''] ("," #0 suffix['\'','\''] )? #0)? "]" #0 cardinality?;
  
  Containment ::=  feature[] #0 cardinality?;
  
  CompoundDefinition ::= "(" definitions ")" #0 cardinality?;

  PLUS ::= "+";
  STAR ::= "*";   
  QUESTIONMARK ::= "?";
  
  WhiteSpaces    ::= ammount['#'];
  LineBreak      ::= tab['!'];
  
  NormalToken ::= "DEFINE" name[] regex['$','$'] !0;
  DecoratedToken ::= "DEFINE" name[] ( "[" #0 ( prefix['\'','\''] ) #0  "]" ) regex['$','$']  ( "[" #0 ( suffix['\'','\'']) #0 "]" ) !0;
  PreDefinedToken ::= "PREDEFINED" name[];

}