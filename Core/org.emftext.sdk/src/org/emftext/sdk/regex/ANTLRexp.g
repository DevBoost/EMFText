/*
 [The "BSD licence"]
 Copyright (c) 2005-2007 Terence Parr
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

/** ANTLR pure ebnf/regex grammar extracted from ANTLRv3 grammar.
Needs to be further testing since antlr uses the same sublanguage for ebnf and regex!*/


grammar ANTLRexp;
@rulecatch { catch (RecognitionException e) { recExceptions.add(e); } } 

@lexer::header{
package org.emftext.sdk.regex; 

}

@lexer::members{
  public java.util.List<RecognitionException> lexerExceptions  = new java.util.ArrayList<RecognitionException>();

  public void reportError(RecognitionException e) {
     lexerExceptions.add(e);
	}
	
 
} 

@header{
package org.emftext.sdk.regex; 

import java.util.List;
import java.util.ArrayList;
}

@members{
 private StringBuffer regExpression = new StringBuffer();
 private List<String> errorMessages = new ArrayList<String>();
 
 public void emitErrorMessage(String msg) {
 	errorMessages.add(msg);
 }
 
 public List<String> getErrorMessages() {
 	return errorMessages;
 }
 
 
 public String getRegExpressionString() {
 		return regExpression.toString();
 }
 
 private String transformIntoRegExpQuotes(String st) {
 		String test = st;
		String subString = test.substring(1, test.length()-1);
		
	
		String resultString = subString;
		resultString = resultString.replace("^", "\\^");
		resultString = resultString.replace("+", "\\+");
		resultString = resultString.replace("?", "\\?");
		resultString = resultString.replace("*", "\\*");
		resultString = resultString.replace("-", "\\-");
		resultString = resultString.replace("$", "\\$");
		resultString = resultString.replace(".", "\\.");
		resultString = resultString.replace("~", "^");
		resultString = resultString.replace("(", "\\(");
		resultString = resultString.replace(")", "\\)");
		resultString = resultString.replace("{", "\\{");
		resultString = resultString.replace("}", "\\}");
		resultString = resultString.replace("[", "\\[");
		resultString = resultString.replace("]", "\\]");
		
		
		return resultString;
 }
 
 private String removeTicks(String st) {
 		String test = st;
		String subString = test.substring(1, test.length()-1);
		return subString;
 }
 
 public java.util.List<RecognitionException> recExceptions = ((ANTLRexpLexer)getTokenStream().getTokenSource()).lexerExceptions;



}

/** Matches ENBF blocks (and token sets via block rule) */
root returns [StringBuffer buf] 
@init {
	buf = new StringBuffer();
}

: alternative1 = alternative {buf.append($alternative1.buf);} ( '|' alternative2 = alternative {buf.append("|" + $alternative2.buf);})*
EOF; 


ebnf returns [StringBuffer buf]  
@init{
	buf = new StringBuffer();
}

:	bl = block  {buf.append($bl.buf);} (	sign='?'  	| sign='*'	|	sign='+'  |   sign='^'	|   sign='!'  )?
{
if ($sign != null) {
	buf.append($sign.text);
}
}
;

range returns [StringBuffer buf]
@init{
	buf = new StringBuffer();
}


	:	first=CHAR_LITERAL '..' second=CHAR_LITERAL
{
	buf.append("["); buf.append(removeTicks($first.text)); buf.append("-"); buf.append(removeTicks($second.text)); buf.append("]");
}


;

terminal returns [StringBuffer buf]    
@init {
	buf = new StringBuffer();
}


:   (	signTerminal = CHAR_LITERAL	|   signTerminal = STRING_LITERAL |   signTerminalDot = '.' )  
{
	if ($signTerminal != null) {
		String resultString = transformIntoRegExpQuotes($signTerminal.text);
		buf.append(resultString);
	} else if ($signTerminalDot != null) {
		buf.append($signTerminalDot.text);
	}
}
;

ebnfSuffix returns [StringBuffer buf] 
@init {
	buf = new StringBuffer();
}
@after {
	return buf;
}


:	(sign='?' | sign='*'	|sign='+')
{
buf.append($sign.text);
}
;

block returns [StringBuffer buf]  
@init {
	buf = new StringBuffer();
}


:   '(' alternative1=alternative   {buf.append("(" + $alternative1.buf);} ( '|'  alternative2=alternative  {buf.append("|" + $alternative2.buf);} )* ')'  {buf.append(")");};

alternative returns [StringBuffer buf] 
@init {
	buf = new StringBuffer();
}

: ( ele = element {buf.append($ele.buf);})*  
;

element returns [StringBuffer buf]
@init {
	buf = new StringBuffer();
}

 : ele = elementNoOptionSpec
{
buf.append($ele.buf);
}
;

elementNoOptionSpec returns [StringBuffer buf] 
@init {
	buf = new StringBuffer();
}
:	at = atom  (	suf = ebnfSuffix )	? 
{
buf.append($at.buf);
if ($suf.buf != null) {
buf.append($suf.buf);
}
}
|	eb = ebnf
{
buf.append($eb.buf);
}
;

atom returns [StringBuffer buf]
@init {
	buf = new StringBuffer();
}

: ( exp =  range   |  exp = terminal   |	exp = notSet  )  (sign= '^' | sign =  '!'  ) ? 
{
buf.append($exp.buf);
if ($sign != null) {
	buf.append($sign.text);
}
}
;

notSet returns [StringBuffer buf] 
@init {
	buf = new StringBuffer();
}

:	sign = '~' 	( bl = block) 	
{
buf.append("[");
buf.append("^");
buf.append($bl.buf);
buf.append("]");
return buf;
}

;


// L E X I C A L   R U L E S

CHAR_LITERAL	:	'\'' LITERAL_CHAR '\'' ;

STRING_LITERAL :	'\'' LITERAL_CHAR LITERAL_CHAR* '\'';

fragment LITERAL_CHAR :	ESC  |	~( '\'' | '\\' );

fragment ESC	:	'\\' (	'n' 	|	'r'  |	't'   |	'b' |	'f' |	'"'|	'\''	|	'\\' |	'>' |	'u' XDIGIT XDIGIT XDIGIT XDIGIT |	. );

fragment XDIGIT : '0' .. '9' |	'a' .. 'f' 	|	'A' .. 'F';

WS	:	(	' ' | '\t'|	'\r'? '\n' )+ {$channel=HIDDEN;};
