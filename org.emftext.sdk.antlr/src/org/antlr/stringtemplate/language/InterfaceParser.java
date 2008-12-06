// $ANTLR 2.7.7 (2006-01-29): "interface.g" -> "InterfaceParser.java"$

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

import antlr.TokenBuffer;
import antlr.TokenStreamException;
import antlr.TokenStreamIOException;
import antlr.ANTLRException;
import antlr.LLkParser;
import antlr.Token;
import antlr.TokenStream;
import antlr.RecognitionException;
import antlr.NoViableAltException;
import antlr.MismatchedTokenException;
import antlr.SemanticException;
import antlr.ParserSharedInputState;
import antlr.collections.impl.BitSet;

/** Match an ST group interface.  Just a list of template names with args.
 *  Here is a sample interface file:
 *
 *	interface nfa;
 *	nfa(states,edges);
 *	optional state(name);
 */
public class InterfaceParser extends antlr.LLkParser       implements InterfaceParserTokenTypes
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

protected InterfaceParser(TokenBuffer tokenBuf, int k) {
  super(tokenBuf,k);
  tokenNames = _tokenNames;
}

public InterfaceParser(TokenBuffer tokenBuf) {
  this(tokenBuf,3);
}

protected InterfaceParser(TokenStream lexer, int k) {
  super(lexer,k);
  tokenNames = _tokenNames;
}

public InterfaceParser(TokenStream lexer) {
  this(lexer,3);
}

public InterfaceParser(ParserSharedInputState state) {
  super(state,3);
  tokenNames = _tokenNames;
}

	public final void groupInterface(
		StringTemplateGroupInterface groupI
	) throws RecognitionException, TokenStreamException {
		
		Token  name = null;
		this.groupI = groupI;
		
		try {      // for error handling
			match(LITERAL_interface);
			name = LT(1);
			match(ID);
			groupI.setName(name.getText());
			match(SEMI);
			{
			int _cnt3=0;
			_loop3:
			do {
				if ((LA(1)==ID||LA(1)==LITERAL_optional)) {
					template(groupI);
				}
				else {
					if ( _cnt3>=1 ) { break _loop3; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt3++;
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_0);
		}
	}
	
	public final void template(
		StringTemplateGroupInterface groupI
	) throws RecognitionException, TokenStreamException {
		
		Token  opt = null;
		Token  name = null;
		
		LinkedHashMap formalArgs = new LinkedHashMap(); // leave blank if no args
		String templateName=null;
		
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case LITERAL_optional:
			{
				opt = LT(1);
				match(LITERAL_optional);
				break;
			}
			case ID:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			name = LT(1);
			match(ID);
			match(LPAREN);
			{
			switch ( LA(1)) {
			case ID:
			{
				formalArgs=args();
				break;
			}
			case RPAREN:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(RPAREN);
			match(SEMI);
			
			templateName = name.getText();
			groupI.defineTemplate(templateName, formalArgs, opt!=null);
			
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_1);
		}
	}
	
	public final LinkedHashMap  args() throws RecognitionException, TokenStreamException {
		LinkedHashMap args=new LinkedHashMap();
		
		Token  a = null;
		Token  b = null;
		
		try {      // for error handling
			a = LT(1);
			match(ID);
			args.put(a.getText(), new FormalArgument(a.getText()));
			{
			_loop9:
			do {
				if ((LA(1)==COMMA)) {
					match(COMMA);
					b = LT(1);
					match(ID);
					args.put(b.getText(), new FormalArgument(b.getText()));
				}
				else {
					break _loop9;
				}
				
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_2);
		}
		return args;
	}
	
	
	public static final String[] _tokenNames = {
		"<0>",
		"EOF",
		"<2>",
		"NULL_TREE_LOOKAHEAD",
		"\"interface\"",
		"ID",
		"SEMI",
		"\"optional\"",
		"LPAREN",
		"RPAREN",
		"COMMA",
		"COLON",
		"SL_COMMENT",
		"ML_COMMENT",
		"WS"
	};
	
	private static final long[] mk_tokenSet_0() {
		long[] data = { 2L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = { 162L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	private static final long[] mk_tokenSet_2() {
		long[] data = { 512L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
	
	}
