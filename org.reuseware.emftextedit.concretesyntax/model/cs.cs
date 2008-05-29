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

  ConcreteSyntax ::= "SYNTAXDEF" #0 name[] !0 "FOR" #0 package['<','>']  !0 "START" #0 startSymbols[] ("," startSymbols[])* !0 !0 ("IMPORTS" "{" ( !2 imports)* !0 "}")? !0 !0 ("TOKENS" "{" ( !2 tokens ";")* !0 "}")? !0!0 "RULES" "{" ( !2 rules+) !0"}";

  Import         ::=  prefix[] ":" package['<','>'] ("WITH" "SYNTAX" concreteSyntax[])?;

  Rule           ::= !0 ( metaclass[] | metaclass[QNAME] ) "::=" definition ";" !0;
 
  Sequence       ::= parts+;
 
  Choice         ::= options ("|" options)* #0;	

  CsString       ::= #0 value['"','"'] #0 ;
  
  DefinedPlaceholder ::= feature[] "["  token[] "]" cardinality?;
  
  DerivedPlaceholder ::=  feature[] "[" ( prefix['\'','\''] ("," suffix['\'','\''] )? )? "]" #0 cardinality?;
  
  Containment ::=  ( feature[] cardinality | feature[] ) #0 ;
  
  CompoundDefinition ::= "(" definitions ")" cardinality?;

  PLUS ::= "+";
  STAR ::= "*";   
  QUESTIONMARK ::= "?";
  
  WhiteSpaces    ::= ammount['#'] #0;
  LineBreak      ::= tab['!'] #0;
  
  NormalToken ::= "DEFINE" #0 name[] regex['$','$'];
  DecoratedToken ::= "DEFINE" #0 name[] ( "[" ( prefix['\'','\''] ) "]" ) regex['$','$']  ( "[" ( suffix['\'','\'']) "]" );
  PreDefinedToken ::= "PREDEFINED" #0 name[];

}