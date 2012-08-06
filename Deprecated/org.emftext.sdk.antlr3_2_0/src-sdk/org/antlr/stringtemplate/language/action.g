header {
/*
 [The "BSD licence"]
 Copyright (c) 2003-2004 Terence Parr
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions
 are met:
 1. Redistributions of source code must retain the above copyright
    notice, this list of conditions and the following disclaimer.
 2. Redistributions in binary form must reproduce the above copyright
    notice, this list of conditions and the following disclaimer in the
    documentation and/or other materials provided with the distribution.
 3. The name of the author may not be used to endorse or promote products
    derived from this software without specific prior written permission.

 THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package org.antlr.stringtemplate.language;
import org.antlr.stringtemplate.*;
import java.util.*;
}

/** Parse the individual attribute expressions */
class ActionParser extends Parser;
options {
	k = 2;
    buildAST = true;
    ASTLabelType = "org.antlr.stringtemplate.language.StringTemplateAST";
}

tokens {
    APPLY;  // template application
    MULTI_APPLY;  // parallel array template application
    ARGS;   // subtree is a list of (possibly empty) arguments
    INCLUDE;// isolated template include (no attribute)
    CONDITIONAL="if";
    VALUE;  // used for (foo): #(VALUE foo)
    TEMPLATE;
    FUNCTION;
    SINGLEVALUEARG;
    LIST; // [a,b,c]
    NOTHING; // empty list element [a, ,c]
}

{
    protected StringTemplate self = null;

    public ActionParser(TokenStream lexer, StringTemplate self) {
        this(lexer, 2);
        this.self = self;
    }

	public void reportError(RecognitionException e) {
        StringTemplateGroup group = self.getGroup();
        if ( group==StringTemplate.defaultGroup ) {
            self.error("action parse error; template context is "+self.getEnclosingInstanceStackString(), e);
        }
        else {
            self.error("action parse error in group "+self.getGroup().getName()+" line "+self.getGroupFileLine()+"; template context is "+self.getEnclosingInstanceStackString(), e);
        }
	}
}

action returns [Map opts=null]
	:	templatesExpr (SEMI! opts=optionList)?
	|	"if"^ LPAREN! ifCondition RPAREN!
	|	"elseif"! LPAREN! ifCondition RPAREN! // return just conditional
	;

optionList! returns [Map opts=new HashMap()]
    :   option[opts] (COMMA option[opts])*
    ;

option[Map opts]
{
Object v=null;
}
	:	i:ID
		( ASSIGN e:nonAlternatingTemplateExpr {v=#e;}
		| {v=ASTExpr.EMPTY_OPTION;}
		)
		{opts.put(#i.getText(),v);}
	;

templatesExpr
    :   (parallelArrayTemplateApplication)=> parallelArrayTemplateApplication
    |	expr
    	(	c:COLON^ {#c.setType(APPLY);} template (COMMA! template)*
    	)*
    ;

parallelArrayTemplateApplication
	:	expr (COMMA! expr)+ c:COLON anonymousTemplate
        {#parallelArrayTemplateApplication =
        	#(#[MULTI_APPLY,"MULTI_APPLY"],parallelArrayTemplateApplication);}
	;

ifCondition
	:   ifAtom
	|   NOT^ ifAtom
	;

ifAtom
    :   templatesExpr
    ;

expr:   primaryExpr (PLUS^ primaryExpr)*
    ;

primaryExpr
    :	(templateInclude)=>templateInclude  // (see past parens to arglist)
    |	atom
    	( DOT^ // ignore warning on DOT ID
     	  ( ID
          | valueExpr
          )
     	)*
    |   function
    	( DOT^
     	  ( ID
          | valueExpr
          )
     	)*
    |   valueExpr
    |	list
    ;

valueExpr
	:   eval:LPAREN^ templatesExpr RPAREN!
        {#eval.setType(VALUE); #eval.setText("value");}
    ;

nonAlternatingTemplateExpr
    :   expr ( c:COLON^ {#c.setType(APPLY);} template )*
    ;

function
	:	(	"first"
   	 	|	"rest"
    	|	"last"
    	|	"length"
    	|	"strip"
    	|	"trunc"
    	)
    	singleArg
        {#function = #(#[FUNCTION],function);}
	;

template
    :   (   namedTemplate       	// foo()
        |   anonymousTemplate   	// {foo}
        )
        {#template = #(#[TEMPLATE],template);}
    ;

namedTemplate
	:	ID argList
	|   "super"! DOT! qid:ID {#qid.setText("super."+#qid.getText());} argList
    |   indirectTemplate
	;

anonymousTemplate
	:	t:ANONYMOUS_TEMPLATE
        {
        StringTemplate anonymous = new StringTemplate();
        anonymous.setGroup(self.getGroup());
        anonymous.setEnclosingInstance(self);
        anonymous.setTemplate(t.getText());
        anonymous.defineFormalArguments(((StringTemplateToken)t).args);
        #t.setStringTemplate(anonymous);
        }
	;

atom:   ID
	|	STRING
    |   INT
    |	ANONYMOUS_TEMPLATE
    ;

list:	lb:LBRACK^ {#lb.setType(LIST); #lb.setText("value");}
          listElement (COMMA! listElement)*
        RBRACK!
    ;

listElement
    :   nonAlternatingTemplateExpr
    |   {#listElement = #[NOTHING, "NOTHING"];}
    ;

templateInclude
	:	(   id:ID argList
	    |   "super"! DOT! qid:ID {#qid.setText("super."+#qid.getText());} argList
        |   indirectTemplate
	    )
        {#templateInclude = #(#[INCLUDE,"include"], templateInclude);}
    ;

/** Match (foo)() and (foo+".terse")() */
indirectTemplate!
    :   LPAREN e:templatesExpr RPAREN args:argList
        {#indirectTemplate = #(#[VALUE,"value"],e,args);}
	;

argList
	:!	LPAREN! RPAREN! {#argList = #[ARGS,"ARGS"];}  // view()
	|	(singleArg)=>singleArg						  // bold(name)
	|	LPAREN! argumentAssignment (COMMA! argumentAssignment)* RPAREN!
        {#argList = #(#[ARGS,"ARGS"],#argList);}
	;

singleArg
	:	LPAREN! nonAlternatingTemplateExpr RPAREN!
        {#singleArg = #(#[SINGLEVALUEARG,"SINGLEVALUEARG"],#singleArg);}
    ;

argumentAssignment
	:	ID ASSIGN^ nonAlternatingTemplateExpr
	|	DOTDOTDOT
	;


class ActionLexer extends Lexer;

options {
    k=2;
	charVocabulary = '\003'..'\uFFFE';
    testLiterals=false;
}

ID
options {
    testLiterals=true;
}
    :	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_'|'/')*
	;

INT :   ('0'..'9')+ ;

STRING
	:	'"'! (ESC_CHAR[true] | ~'"')* '"'!
	;

ANONYMOUS_TEMPLATE
{
List args=null;
StringTemplateToken t = null;
}
	:	'{'!
	        ( (TEMPLATE_ARGS)=> args=TEMPLATE_ARGS (options{greedy=true;}:WS_CHAR!)?
	          {
	          // create a special token to track args
	          t = new StringTemplateToken(ANONYMOUS_TEMPLATE,$getText,args);
	          $setToken(t);
	          }
	        |
	        )
	        ('\\'! '{' | '\\'! '}' | ESC_CHAR[false] | NESTED_ANONYMOUS_TEMPLATE | ~'}')*
	        {
	        if ( t!=null ) {
	        	t.setText($getText);
	        }
	        }
	    '}'!
	;

protected
TEMPLATE_ARGS returns [List args=new ArrayList()]
	:!	(WS_CHAR)? a:ID {args.add(a.getText());}
	    (options{greedy=true;}:(WS_CHAR)? ',' (WS_CHAR)? a2:ID {args.add(a2.getText());})*
	    (WS_CHAR)? '|'
	;

protected
NESTED_ANONYMOUS_TEMPLATE
	:	'{' ('\\'! '{' | '\\'! '}' | ESC_CHAR[false] | NESTED_ANONYMOUS_TEMPLATE | ~'}')* '}'
	;

/** Match escape sequences, optionally translating them for strings, but not
 *  for templates.  Do \} only when in {...} templates.
 */
protected
ESC_CHAR[boolean doEscape]
	:	'\\'
		(	options {generateAmbigWarnings=false;} // . ambig with others
		:   'n' {if (doEscape) { $setText("\n"); }}
		|	'r' {if (doEscape) { $setText("\r"); }}
		|	't' {if (doEscape) { $setText("\t"); }}
		|	'b' {if (doEscape) { $setText("\b"); }}
		|	'f' {if (doEscape) { $setText("\f"); }}
		|   c:. {if (doEscape) {$setText(String.valueOf(c));}}
		)
	;

LBRACK: '[' ;
RBRACK: ']' ;
LPAREN : '(' ;
RPAREN : ')' ;
COMMA  : ',' ;
DOT    : '.' ;
ASSIGN : '=' ;
COLON  : ':' ;
PLUS   : '+' ;
SEMI   : ';' ;
NOT	   : '!' ;
DOTDOTDOT : "..." ;

WS	:	(' '|'\t'|'\r'|'\n'{newline();})+ {$setType(Token.SKIP);}
	;

protected
WS_CHAR
	:	' '|'\t'|'\r'|'\n'{newline();}
	;
