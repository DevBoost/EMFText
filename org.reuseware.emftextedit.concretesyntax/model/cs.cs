SYNTAXDEF cs 
FOR       <http://www.reuseware.org/emftextedit/concretesyntax>
START     ConcreteSyntax

RULES {

  ConcreteSyntax ::= "SYNTAXDEF" name ! "FOR" "<" #0 package #0 ">" ! "START" startSymbols ("," startSymbols)* ! ! ("IMPORTS" "{" ( !2 imports)* ! "}")? ! ! "RULES" "{" ( !2 rules+) ! "}";

  Import         ::= prefix ":" "<" #0 package #0 ">" ("WITH" "SYNTAX" concreteSyntax)?;

  Rule           ::= metaclass "::=" definition #0 ";";
  
  Sequence       ::= parts+;

  Choice         ::= options ("|" options)* #0;	

  CsString       ::= ('"' #0 value #0 '"') | ("'" #0 value #0 "'");
  
  Terminal      ::= feature #0 cardinality?;
  
  CompoundDefinition ::= "(" definitions ")" #0 cardinality?;

  PLUS ::= "+";
  STAR ::= "*";   
  QUESTIONMARK ::= "?";
  
  WhiteSpaces    ::= "#" ammount?;
  LineBreak      ::= "!" tab?;

}