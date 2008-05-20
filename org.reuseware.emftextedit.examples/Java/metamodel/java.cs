SYNTAXDEF java
FOR <http://www.reuseware.org/java>
START CompilationUnit

RULES {

CompilationUnit 
   ::=
        ("package" package[] ("." package[])* ";")?
        ("import" ("static")? imports ";")*
        typeDeclarations+
	;
	
Import
	::= package[] ("." package[])*  "." classifiers[];
	
Class
	::=	modifiers "class" name[] ("<" typeParameters[] ("," typeParameters[])* ">")?
        ("extends" extends[])?
        ("implements" implements[])?
        "{" (members (";")?)* "}"
	;

TypeParameter
	::=	name[] ("extends" bound[] ("&" bound[])*)?
	;
	
Interface
	::=	modifiers "interface" name[] ("<" typeParameters[] ("," typeParameters[])* ">")?
	       ("extends" implements[])? 
	       "{" members* "}"
	;

Block
	::=	modifiers* "{" statements* "}"
	;

Constructor
	::=	modifiers* name[]
	"(" (parameters ("," parameters)* )? ")" 
	("throws" exceptions[] ("," exceptions[]))? body
	;

Method
	::=	modifiers* (type[] | "void") ("<" typeArguments[] ("," typeArguments[])* ">")? name[] 
	"(" (parameters ("," parameters)* )? ")" 
	("throws" exceptions[] ("," exceptions[]))? (body | ";")
	;	
	
Variable
	::= modifiers*  type[] ("<" typeArguments[] ("," typeArguments[])* ">")? name[] 
	;	

Public ::= "public";
Protected ::= "protected";
Private ::= "private" ;

Final ::= "final";
Static ::= "static";

Boolean ::=   "boolean";
Char ::= "char";
Byte ::= "byte";
Short ::= "short";
Int ::= "int";
Long ::= "long";
Float ::= "float";
Double ::= "double";
	
Assert    ::= "assert" expression1 ("::=" expression2)? ";" ;
Condition ::= "if" "(" expression ")" ifStatement ("else" elseStatement)? ;
ForLoop   ::= "for" "(" init? ";" condition? ";" (updates ("," updates)* )? ")" statement;
WhileLoop ::= "while" "(" condition ")" statement;
DoWhileLoop ::= "do" statement "while" "(" condition ")" ";" ;
TryBlock  ::= "try" tryBlock
      (	catches* "finally" finallyBlock
      | catches*
      );
Return ::= "return" expression? ";" ;
Throw  ::= "throw" expression ";" ;
Break  ::= "break"  ";" ;
Continue ::= "continue"  ";" ;
Assignment ::= variable[] "=" value ";" ;
SingleExpression ::= expression ";";
	
CatchClause
	::=	"catch" "(" parameter ")" catchBlock
	;

Instantiation ::= "new" type[] 
    ("<" typeArguments[] ("," typeArguments[])* ">")?
     "(" (arguments ("," arguments)* )? ")";
     
MethodCall    ::=       method[]     "(" (arguments ("," arguments)* )? ")" ("." next)?;
VariableReference ::=   variable[] ("." next)?;

BooleanExpression
	::=	
	left[]
	( "="
    |   "+="
    |   "-="
    |   "*="
    |   "/="
    |   "&="
    |   "|="
    |   "^="
    |   "%="
    |   "<" "<" "="
    |   ">" ">" "="
    |   ">" ">" ">" "=" )
    right[]
	;
}