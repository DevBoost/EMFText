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

  ConcreteSyntax ::= "SYNTAXDEF" name[] !0 "FOR" package['<','>']  !0 "START" startSymbols[] ("," startSymbols[])* !0 !0 ("IMPORTS" "{" !2 (imports)* !0 "}")? !0 !0 ("TOKENS" "{" ( !2 tokens ";")* !0 "}")? !0!0 "RULES" "{" ( !2 rules+) !0"}";

  Import         ::=  prefix[] ":" package['<','>'] ("WITH" "SYNTAX" concreteSyntax[])? !0;

  Rule           ::= !0 ( metaclass[] | metaclass[QNAME] ) "::=" definition ";" !0;
 
  Sequence       ::= parts+;
 
  Choice         ::= options ("|" options)* #0;	

  CsString       ::= value['"','"'];
  
  DefinedPlaceholder ::= feature[] "["  token[] "]" cardinality?;
  
  DerivedPlaceholder ::=  feature[] "[" ( prefix['\'','\''] ("," suffix['\'','\''] )? )? "]" #0 cardinality?;
  
  Containment ::=  feature[] cardinality?;
  
  CompoundDefinition ::= "(" definitions ")" cardinality?;

  PLUS ::= "+";
  STAR ::= "*";   
  QUESTIONMARK ::= "?";
  
  WhiteSpaces    ::= ammount['#'];
  LineBreak      ::= tab['!'];
  
  NormalToken ::= "DEFINE" name[] regex['$','$'];
  DecoratedToken ::= "DEFINE" name[] ( "[" ( prefix['\'','\''] ) "]" ) regex['$','$']  ( "[" ( suffix['\'','\'']) "]" );
  PreDefinedToken ::= "PREDEFINED" name[];

}