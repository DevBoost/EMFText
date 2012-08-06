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
    import java.io.*;
}

/** Break up an input text stream into chunks of either plain text
 *  or template actions in "<...>".  Treat IF and ENDIF tokens
 *  specially.
 */
class AngleBracketTemplateLexer extends Lexer;

options {
    importVocab=TemplateParser;
    k=7; // see "<endif>"
    charVocabulary = '\u0001'..'\uFFFE';
}

{
protected String currentIndent = null;
protected StringTemplate self;

public AngleBracketTemplateLexer(StringTemplate self, Reader r) {
	this(r);
	this.self = self;
}

public void reportError(RecognitionException e) {
	self.error("<...> chunk lexer error", e);
}

protected boolean upcomingELSE(int i) throws CharStreamException {
 	return LA(i)=='<'&&LA(i+1)=='e'&&LA(i+2)=='l'&&LA(i+3)=='s'&&LA(i+4)=='e'&&
 	       LA(i+5)=='>';
}

protected boolean upcomingENDIF(int i) throws CharStreamException {
	return LA(i)=='<'&&LA(i+1)=='e'&&LA(i+2)=='n'&&LA(i+3)=='d'&&LA(i+4)=='i'&&
	       LA(i+5)=='f'&&LA(i+6)=='>';
}

protected boolean upcomingAtEND(int i) throws CharStreamException {
	return LA(i)=='<'&&LA(i+1)=='@'&&LA(i+2)=='e'&&LA(i+3)=='n'&&LA(i+4)=='d'&&LA(i+5)=='>';
}

protected boolean upcomingNewline(int i) throws CharStreamException {
	return (LA(i)=='\r'&&LA(i+1)=='\n')||LA(i)=='\n';
}
}

LITERAL
    :   {LA(1)!='\r'&&LA(1)!='\n'}?
        ( options { generateAmbigWarnings=false; }
          {
          int loopStartIndex=text.length();
          int col=getColumn();
          }
        : '\\'! '<'  // allow escaped delimiter
        | '\\'! '>'
        | '\\'! '\\' // always replace \\ with \
        | '\\' ~('<'|'>')   // otherwise ignore escape char
        | ind:INDENT
          {
          if ( col==1 && LA(1)=='<' ) {
              // store indent in ASTExpr not in a literal
              currentIndent=ind.getText();
			  text.setLength(loopStartIndex); // reset length to wack text
          }
          else currentIndent=null;
          }
        | ~('<'|'\r'|'\n')
        )+
        {if (($getText).length()==0) {$setType(Token.SKIP);}} // pure indent?
    ;

protected
INDENT
    :   ( options {greedy=true;}: ' ' | '\t')+
    ;

NEWLINE
    :	('\r')? '\n' {newline(); currentIndent=null;}
    ;

ACTION
options {
   		generateAmbigWarnings=false; // <EXPR> is ambig with <!..!>
}
{
    int startCol = getColumn();
}
    :   LINE_BREAK {$setType(Token.SKIP);}
    |   // Match escapes not in a string like <\n\ufea5>
		{StringBuffer buf = new StringBuffer(); char uc = '\u0000';}
    	'<'! (uc=ESC_CHAR {buf.append(uc);} )+'>'!
    	{$setText(buf.toString()); $setType(LITERAL);}
    | 	COMMENT    {$setType(Token.SKIP);}
    |   (
    	options {
    		generateAmbigWarnings=false; // $EXPR$ is ambig with $endif$ etc...
		}
	:	'<'! "if" (' '!)* "(" IF_EXPR ")" '>'! {$setType(TemplateParser.IF);}
        ( ('\r'!)? '\n'! {newline();})? // ignore any newline right after an IF
	|	'<'! "elseif" (' '!)* "(" IF_EXPR ")" '>'! {$setType(TemplateParser.ELSEIF);}
        ( ('\r'!)? '\n'! {newline();})? // ignore any newline right after an IF
    |   '<'! "else" '>'!         {$setType(TemplateParser.ELSE);}
        ( ('\r'!)? '\n'! {newline();})? // ignore any newline right after an ELSE
    |   '<'! "endif" '>'!        {$setType(TemplateParser.ENDIF);}
        ( {startCol==1}? ('\r'!)? '\n'! {newline();})? // ignore after ENDIF if on line by itself

    |   // match <@foo()> => foo
    	// match <@foo>...<@end> => foo::=...
        '<'! '@'! (~('>'|'('))+
    	(	"()"! '>'! {$setType(TemplateParser.REGION_REF);}
    	|   '>'!
    		{
    		$setType(TemplateParser.REGION_DEF);
    		String t=$getText;
    		$setText(t+"::=");
    		}
        	( options {greedy=true;} : ('\r'!)? '\n'! {newline();})?
    		{boolean atLeft = false;}
        	(
        		options {greedy=true;} // handle greedy=false with predicate
        	:	{!(upcomingAtEND(1)||(upcomingNewline(1)&&upcomingAtEND(2)))}?
        		(	('\r')? '\n' {newline(); atLeft = true;}
       			|	. {atLeft = false;}
       			)
       		)+
        	( ('\r'!)? '\n'! {newline(); atLeft = true;} )?
			( "<@end>"!
			| . {self.error("missing region "+t+" <@end> tag");}
			)
        	( {atLeft}? ('\r'!)? '\n'! {newline();})?
        )

    |   '<'! EXPR '>'!
    	)
    	{
        ChunkToken t = new ChunkToken(_ttype, $getText, currentIndent);
        $setToken(t);
    	}
    ;

protected
EXPR:   ( ESC
        | ('\r')? '\n' {newline();}
        | SUBTEMPLATE
        | ('='|'+') TEMPLATE
        | ('='|'+') SUBTEMPLATE
        | ('='|'+') ~('"'|'<'|'{')
        | ~'>'
        )+
    ;

protected
TEMPLATE
	:	'"' ( ESC | ~'"' )* '"'
	|	"<<"
	 	(options {greedy=true;}:('\r'!)?'\n'! {newline();})? // consume 1st \n
		(	options {greedy=false;}  // stop when you see the >>
		:	{LA(3)=='>'&&LA(4)=='>'}? '\r'! '\n'! {newline();} // kill last \r\n
		|	{LA(2)=='>'&&LA(3)=='>'}? '\n'! {newline();}       // kill last \n
		|	('\r')? '\n' {newline();}                          // else keep
		|	.
		)*
        ">>"
	;

protected
IF_EXPR:( ESC
        | ('\r')? '\n' {newline();}
        | SUBTEMPLATE
        | NESTED_PARENS
        | ~')'
        )+
    ;

protected
ESC_CHAR returns [char uc='\u0000']
	:	"\\n"! {uc = '\n';}
	|	"\\r"! {uc = '\r';}
	|	"\\t"! {uc = '\t';}
	|	"\\ "! {uc = ' ';}
	|	"\\u"! a:HEX! b:HEX! c:HEX! d:HEX!
		{uc = (char)Integer.parseInt(a.getText()+b.getText()+c.getText()+d.getText(), 16);}
	;

// just used to skip stuff (not part of unicode escape stuff)
protected
ESC :   '\\' . // ('<'|'>'|'n'|'t'|'"'|'\''|':'|'{'|'}'|'\\')
    ;

protected
HEX	:	'0'..'9'|'A'..'F'|'a'..'f'
	;

protected
SUBTEMPLATE
    :    '{' (SUBTEMPLATE|ESC|~'}')* '}'
    ;

protected
NESTED_PARENS
    :    '(' (options {greedy=false;}:NESTED_PARENS|ESC|~')')+ ')'
    ;

protected
COMMENT
{
    int startCol = getColumn();
}
    :   "<!"
    	(	options {greedy=false;}
    	:	('\r')? '\n' {newline();}
    	|	.
    	)*
    	"!>" ( {startCol==1}? ('\r')? '\n' {newline();} )?
    ;

protected
LINE_BREAK
    :   "<\\\\>" (INDENT)? ('\r')? '\n' {newline();} (INDENT)?
    ;
