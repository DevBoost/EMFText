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
package org.reuseware.emftextedit.codegen.regex; 

}

@lexer::members{
  public java.util.List<RecognitionException> lexerExceptions  = new java.util.ArrayList<RecognitionException>();

  public void reportError(RecognitionException e) {
     lexerExceptions.add(e);
	}
	
 
} 

@header{
package org.reuseware.emftextedit.codegen.regex; 
}

@members{
 public java.util.List<RecognitionException> recExceptions = ((ANTLRexpLexer)getTokenStream().getTokenSource()).lexerExceptions;

public void recoverFromMismatchedSet(IntStream input, RecognitionException e, BitSet follow)
  throws RecognitionException
{
}

}

/** Matches ENBF blocks (and token sets via block rule) */
root : alternative ( '|' alternative )*;

ebnf :	block  (	'?'  	|'*'	|	'+'  |   '^'	|   '!'  )?;

range	:	CHAR_LITERAL '..' CHAR_LITERAL;

terminal    :   (	CHAR_LITERAL	|   STRING_LITERAL |   '.' )  ;

ebnfSuffix :	'?' | '*'	|'+';

block  :   '(' alternative( '|' alternative )* ')' ;

alternative : element*  ;

element : elementNoOptionSpec;

elementNoOptionSpec :	atom  (	ebnfSuffix )	? |	ebnf;

atom:  (  range   |   terminal   |	notSet  )  ( '^' |  '!'  ) ? ;

notSet:	'~' 	( block) 	;


// L E X I C A L   R U L E S

CHAR_LITERAL	:	'\'' LITERAL_CHAR '\'' ;

STRING_LITERAL :	'\'' LITERAL_CHAR LITERAL_CHAR* '\'';

fragment LITERAL_CHAR :	ESC  |	~( '\'' | '\\' );

fragment ESC	:	'\\' (	'n' 	|	'r'  |	't'   |	'b' |	'f' |	'"'|	'\''	|	'\\' |	'>' |	'u' XDIGIT XDIGIT XDIGIT XDIGIT |	. );

fragment XDIGIT : '0' .. '9' |	'a' .. 'f' 	|	'A' .. 'F';

WS	:	(	' ' | '\t'|	'\r'? '\n' )+ {$channel=HIDDEN;};
