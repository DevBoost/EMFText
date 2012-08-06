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

/** Match an ST group interface.  Just a list of template names with args.
 *  Here is a sample interface file:
 *
 *	interface nfa;
 *	nfa(states,edges);
 *	optional state(name);
 */
class InterfaceParser extends Parser;

options {
    k=3;
}

{
protected StringTemplateGroupInterface groupI;

public void reportError(RecognitionException e) {
	if ( groupI!=null ) {
	    groupI.error("template group interface parse error", e);
	}
	else {
	    System.err.println("template group interface parse error: "+e);
	    e.printStackTrace(System.err);
	}
}
}

groupInterface[StringTemplateGroupInterface groupI]
{this.groupI = groupI;}
	:	"interface" name:ID {groupI.setName(name.getText());} SEMI
	    ( template[groupI] )+
    ;

template[StringTemplateGroupInterface groupI]
{
    LinkedHashMap formalArgs = new LinkedHashMap(); // leave blank if no args
    String templateName=null;
}
	:	(opt:"optional")? name:ID LPAREN (formalArgs=args)? RPAREN SEMI
	    {
        templateName = name.getText();
        groupI.defineTemplate(templateName, formalArgs, opt!=null);
        }
	;

args returns [LinkedHashMap args=new LinkedHashMap()]
    :	a:ID {args.put(a.getText(), new FormalArgument(a.getText()));}
        ( COMMA b:ID {args.put(b.getText(), new FormalArgument(b.getText()));} )*
	;


class InterfaceLexer extends Lexer;

options {
	k=2;
	charVocabulary = '\u0000'..'\uFFFE';
}

ID	:	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'-'|'_')*
	;

LPAREN: '(' ;
RPAREN: ')' ;
COMMA:  ',' ;
SEMI:   ';' ;
COLON:  ':' ;

// Single-line comments
SL_COMMENT
    :   "//"
        (~('\n'|'\r'))* (('\r')? '\n')?
        {$setType(Token.SKIP); newline();}
    ;

// multiple-line comments
ML_COMMENT
    :   "/*"
        (   
            options {
                greedy=false;
            }
        :   ('\r')? '\n'    {newline();}
        |   .
        )*
        "*/"
        {$setType(Token.SKIP);}
    ;

// Whitespace -- ignored
WS  :   (   ' '
        |   '\t'
        |   '\f'
        |   ('\r')? '\n' { newline(); }
        )+
        { $setType(Token.SKIP); }
    ;
