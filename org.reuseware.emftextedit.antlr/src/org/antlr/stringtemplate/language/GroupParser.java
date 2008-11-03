// $ANTLR 2.7.7 (2006-01-29): "group.g" -> "GroupParser.java"$

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

/** Match a group of template definitions beginning
 *  with a group name declaration.  Templates are enclosed
 *  in double-quotes or <<...>> quotes for multi-line templates.
 *  Template names have arg lists that indicate the cardinality
 *  of the attribute: present, optional, zero-or-more, one-or-more.
 *  Here is a sample group file:

	group nfa;

	// an NFA has edges and states
	nfa(states,edges) ::= <<
	digraph NFA {
	rankdir=LR;
	<states; separator="\\n">
	<edges; separator="\\n">
	}
	>>

	state(name) ::= "node [shape = circle]; <name>;"

 */
public class GroupParser extends antlr.LLkParser       implements GroupParserTokenTypes
 {

protected StringTemplateGroup group;

public void reportError(RecognitionException e) {
	if ( group!=null ) {
	    group.error("template group parse error", e);
	}
	else {
	    System.err.println("template group parse error: "+e);
	    e.printStackTrace(System.err);
	}
}

protected GroupParser(TokenBuffer tokenBuf, int k) {
  super(tokenBuf,k);
  tokenNames = _tokenNames;
}

public GroupParser(TokenBuffer tokenBuf) {
  this(tokenBuf,3);
}

protected GroupParser(TokenStream lexer, int k) {
  super(lexer,k);
  tokenNames = _tokenNames;
}

public GroupParser(TokenStream lexer) {
  this(lexer,3);
}

public GroupParser(ParserSharedInputState state) {
  super(state,3);
  tokenNames = _tokenNames;
}

	public final void group(
		StringTemplateGroup g
	) throws RecognitionException, TokenStreamException {
		
		Token  name = null;
		Token  s = null;
		Token  i = null;
		Token  i2 = null;
		
		this.group = g;
		
		
		try {      // for error handling
			match(LITERAL_group);
			name = LT(1);
			match(ID);
			g.setName(name.getText());
			{
			switch ( LA(1)) {
			case COLON:
			{
				match(COLON);
				s = LT(1);
				match(ID);
				g.setSuperGroup(s.getText());
				break;
			}
			case LITERAL_implements:
			case SEMI:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			{
			switch ( LA(1)) {
			case LITERAL_implements:
			{
				match(LITERAL_implements);
				i = LT(1);
				match(ID);
				g.implementInterface(i.getText());
				{
				_loop5:
				do {
					if ((LA(1)==COMMA)) {
						match(COMMA);
						i2 = LT(1);
						match(ID);
						g.implementInterface(i2.getText());
					}
					else {
						break _loop5;
					}
					
				} while (true);
				}
				break;
			}
			case SEMI:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			match(SEMI);
			{
			int _cnt7=0;
			_loop7:
			do {
				if ((LA(1)==ID||LA(1)==AT) && (LA(2)==ID||LA(2)==LPAREN||LA(2)==DEFINED_TO_BE) && (LA(3)==ID||LA(3)==DOT||LA(3)==RPAREN)) {
					template(g);
				}
				else if ((LA(1)==ID) && (LA(2)==DEFINED_TO_BE) && (LA(3)==LBRACK)) {
					mapdef(g);
				}
				else {
					if ( _cnt7>=1 ) { break _loop7; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt7++;
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_0);
		}
	}
	
	public final void template(
		StringTemplateGroup g
	) throws RecognitionException, TokenStreamException {
		
		Token  scope = null;
		Token  region = null;
		Token  name = null;
		Token  t = null;
		Token  bt = null;
		Token  alias = null;
		Token  target = null;
		
		Map formalArgs = null;
		StringTemplate st = null;
		boolean ignore = false;
		String templateName=null;
		int line = LT(1).getLine();
		
		
		try {      // for error handling
			if ((LA(1)==ID||LA(1)==AT) && (LA(2)==ID||LA(2)==LPAREN)) {
				{
				switch ( LA(1)) {
				case AT:
				{
					match(AT);
					scope = LT(1);
					match(ID);
					match(DOT);
					region = LT(1);
					match(ID);
					
								templateName=g.getMangledRegionName(scope.getText(),region.getText());
						    	if ( g.isDefinedInThisGroup(templateName) ) {
						        	g.error("group "+g.getName()+" line "+line+": redefinition of template region: @"+
						        		scope.getText()+"."+region.getText());
									st = new StringTemplate(); // create bogus template to fill in
								}
								else {
									boolean err = false;
									// @template.region() ::= "..."
									StringTemplate scopeST = g.lookupTemplate(scope.getText());
									if ( scopeST==null ) {
										g.error("group "+g.getName()+" line "+line+": reference to region within undefined template: "+
											scope.getText());
										err=true;
									}
									if ( !scopeST.containsRegionName(region.getText()) ) {
										g.error("group "+g.getName()+" line "+line+": template "+scope.getText()+" has no region called "+
											region.getText());
										err=true;
									}
									if ( err ) {
										st = new StringTemplate();
									}
									else {
										st = g.defineRegionTemplate(scope.getText(),
																	region.getText(),
																	null,
																	StringTemplate.REGION_EXPLICIT);
									}
								}
								
					break;
				}
				case ID:
				{
					name = LT(1);
					match(ID);
					templateName = name.getText();
					
								if ( g.isDefinedInThisGroup(templateName) ) {
									g.error("redefinition of template: "+templateName);
									st = new StringTemplate(); // create bogus template to fill in
								}
								else {
									st = g.defineTemplate(templateName, null);
								}
								
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				if ( st!=null ) {st.setGroupFileLine(line);}
				match(LPAREN);
				{
				switch ( LA(1)) {
				case ID:
				{
					args(st);
					break;
				}
				case RPAREN:
				{
					st.defineEmptyFormalArgumentList();
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				match(RPAREN);
				match(DEFINED_TO_BE);
				{
				switch ( LA(1)) {
				case STRING:
				{
					t = LT(1);
					match(STRING);
					st.setTemplate(t.getText());
					break;
				}
				case BIGSTRING:
				{
					bt = LT(1);
					match(BIGSTRING);
					st.setTemplate(bt.getText());
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
			}
			else if ((LA(1)==ID) && (LA(2)==DEFINED_TO_BE)) {
				alias = LT(1);
				match(ID);
				match(DEFINED_TO_BE);
				target = LT(1);
				match(ID);
				g.defineTemplateAlias(alias.getText(), target.getText());
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_1);
		}
	}
	
	public final void mapdef(
		StringTemplateGroup g
	) throws RecognitionException, TokenStreamException {
		
		Token  name = null;
		
		Map m=null;
		
		
		try {      // for error handling
			name = LT(1);
			match(ID);
			match(DEFINED_TO_BE);
			m=map();
			
				    if ( g.getMap(name.getText())!=null ) {
				        g.error("redefinition of map: "+name.getText());
				    }
				    else if ( g.isDefinedInThisGroup(name.getText()) ) {
				        g.error("redefinition of template as map: "+name.getText());
				    }
				    else {
				    	g.defineMap(name.getText(), m);
				    }
				
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_1);
		}
	}
	
	public final void args(
		StringTemplate st
	) throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			arg(st);
			{
			_loop14:
			do {
				if ((LA(1)==COMMA)) {
					match(COMMA);
					arg(st);
				}
				else {
					break _loop14;
				}
				
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_2);
		}
	}
	
	public final void arg(
		StringTemplate st
	) throws RecognitionException, TokenStreamException {
		
		Token  name = null;
		Token  s = null;
		Token  bs = null;
		
			StringTemplate defaultValue = null;
		
		
		try {      // for error handling
			name = LT(1);
			match(ID);
			{
			if ((LA(1)==ASSIGN) && (LA(2)==STRING)) {
				match(ASSIGN);
				s = LT(1);
				match(STRING);
				
							defaultValue=new StringTemplate("$_val_$");
							defaultValue.setAttribute("_val_", s.getText());
							defaultValue.defineFormalArgument("_val_");
							defaultValue.setName("<"+st.getName()+"'s arg "+name.getText()+" default value subtemplate>");
							
			}
			else if ((LA(1)==ASSIGN) && (LA(2)==ANONYMOUS_TEMPLATE)) {
				match(ASSIGN);
				bs = LT(1);
				match(ANONYMOUS_TEMPLATE);
				
							defaultValue=new StringTemplate(st.getGroup(), bs.getText());
							defaultValue.setName("<"+st.getName()+"'s arg "+name.getText()+" default value subtemplate>");
							
			}
			else if ((LA(1)==COMMA||LA(1)==RPAREN)) {
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
			}
			st.defineFormalArgument(name.getText(), defaultValue);
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_3);
		}
	}
	
	public final Map  map() throws RecognitionException, TokenStreamException {
		Map mapping=new HashMap();
		
		
		try {      // for error handling
			match(LBRACK);
			mapPairs(mapping);
			match(RBRACK);
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_1);
		}
		return mapping;
	}
	
	public final void mapPairs(
		Map mapping
	) throws RecognitionException, TokenStreamException {
		
		
		try {      // for error handling
			switch ( LA(1)) {
			case STRING:
			{
				keyValuePair(mapping);
				{
				_loop21:
				do {
					if ((LA(1)==COMMA) && (LA(2)==STRING)) {
						match(COMMA);
						keyValuePair(mapping);
					}
					else {
						break _loop21;
					}
					
				} while (true);
				}
				{
				switch ( LA(1)) {
				case COMMA:
				{
					match(COMMA);
					defaultValuePair(mapping);
					break;
				}
				case RBRACK:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				break;
			}
			case LITERAL_default:
			{
				defaultValuePair(mapping);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_4);
		}
	}
	
	public final void keyValuePair(
		Map mapping
	) throws RecognitionException, TokenStreamException {
		
		Token  key = null;
		
		StringTemplate v = null;
		
		
		try {      // for error handling
			key = LT(1);
			match(STRING);
			match(COLON);
			v=keyValue();
			mapping.put(key.getText(), v);
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_5);
		}
	}
	
	public final void defaultValuePair(
		Map mapping
	) throws RecognitionException, TokenStreamException {
		
		
		StringTemplate v = null;
		
		
		try {      // for error handling
			match(LITERAL_default);
			match(COLON);
			v=keyValue();
			mapping.put(ASTExpr.DEFAULT_MAP_VALUE_NAME, v);
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_4);
		}
	}
	
	public final StringTemplate  keyValue() throws RecognitionException, TokenStreamException {
		StringTemplate value=null;
		
		Token  s1 = null;
		Token  s2 = null;
		Token  k = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case BIGSTRING:
			{
				s1 = LT(1);
				match(BIGSTRING);
				value = new StringTemplate(group,s1.getText());
				break;
			}
			case STRING:
			{
				s2 = LT(1);
				match(STRING);
				value = new StringTemplate(group,s2.getText());
				break;
			}
			case ID:
			{
				k = LT(1);
				match(ID);
				if (!(k.getText().equals("key")))
				  throw new SemanticException("k.getText().equals(\"key\")");
				value = ASTExpr.MAP_KEY_VALUE;
				break;
			}
			case COMMA:
			case RBRACK:
			{
				value = null;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			recover(ex,_tokenSet_5);
		}
		return value;
	}
	
	
	public static final String[] _tokenNames = {
		"<0>",
		"EOF",
		"<2>",
		"NULL_TREE_LOOKAHEAD",
		"\"group\"",
		"ID",
		"COLON",
		"\"implements\"",
		"COMMA",
		"SEMI",
		"AT",
		"DOT",
		"LPAREN",
		"RPAREN",
		"DEFINED_TO_BE",
		"STRING",
		"BIGSTRING",
		"ASSIGN",
		"ANONYMOUS_TEMPLATE",
		"LBRACK",
		"RBRACK",
		"\"default\"",
		"STAR",
		"PLUS",
		"OPTIONAL",
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
		long[] data = { 1058L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	private static final long[] mk_tokenSet_2() {
		long[] data = { 8192L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
	private static final long[] mk_tokenSet_3() {
		long[] data = { 8448L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());
	private static final long[] mk_tokenSet_4() {
		long[] data = { 1048576L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());
	private static final long[] mk_tokenSet_5() {
		long[] data = { 1048832L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_5 = new BitSet(mk_tokenSet_5());
	
	}
