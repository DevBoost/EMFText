// $ANTLR 2.7.7 (2006-01-29): "action.g" -> "ActionParser.java"$

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
import antlr.collections.AST;
import java.util.Hashtable;
import antlr.ASTFactory;
import antlr.ASTPair;
import antlr.collections.impl.ASTArray;

/** Parse the individual attribute expressions */
public class ActionParser extends antlr.LLkParser       implements ActionParserTokenTypes
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

protected ActionParser(TokenBuffer tokenBuf, int k) {
  super(tokenBuf,k);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

public ActionParser(TokenBuffer tokenBuf) {
  this(tokenBuf,2);
}

protected ActionParser(TokenStream lexer, int k) {
  super(lexer,k);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

public ActionParser(TokenStream lexer) {
  this(lexer,2);
}

public ActionParser(ParserSharedInputState state) {
  super(state,2);
  tokenNames = _tokenNames;
  buildTokenTypeASTClassMap();
  astFactory = new ASTFactory(getTokenTypeToASTClassMap());
}

	public final Map  action() throws RecognitionException, TokenStreamException {
		Map opts=null;
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		org.antlr.stringtemplate.language.StringTemplateAST action_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case LPAREN:
			case ID:
			case LITERAL_first:
			case LITERAL_rest:
			case LITERAL_last:
			case LITERAL_length:
			case LITERAL_strip:
			case LITERAL_trunc:
			case LITERAL_super:
			case ANONYMOUS_TEMPLATE:
			case STRING:
			case INT:
			case LBRACK:
			{
				templatesExpr();
				astFactory.addASTChild(currentAST, returnAST);
				{
				switch ( LA(1)) {
				case SEMI:
				{
					match(SEMI);
					opts=optionList();
					astFactory.addASTChild(currentAST, returnAST);
					break;
				}
				case EOF:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
				}
				action_AST = (org.antlr.stringtemplate.language.StringTemplateAST)currentAST.root;
				break;
			}
			case CONDITIONAL:
			{
				org.antlr.stringtemplate.language.StringTemplateAST tmp2_AST = null;
				tmp2_AST = (org.antlr.stringtemplate.language.StringTemplateAST)astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp2_AST);
				match(CONDITIONAL);
				match(LPAREN);
				ifCondition();
				astFactory.addASTChild(currentAST, returnAST);
				match(RPAREN);
				action_AST = (org.antlr.stringtemplate.language.StringTemplateAST)currentAST.root;
				break;
			}
			case LITERAL_elseif:
			{
				match(LITERAL_elseif);
				match(LPAREN);
				ifCondition();
				astFactory.addASTChild(currentAST, returnAST);
				match(RPAREN);
				action_AST = (org.antlr.stringtemplate.language.StringTemplateAST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_0);
			} else {
			  throw ex;
			}
		}
		returnAST = action_AST;
		return opts;
	}
	
	public final void templatesExpr() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		org.antlr.stringtemplate.language.StringTemplateAST templatesExpr_AST = null;
		Token  c = null;
		org.antlr.stringtemplate.language.StringTemplateAST c_AST = null;
		
		try {      // for error handling
			boolean synPredMatched10 = false;
			if (((_tokenSet_1.member(LA(1))) && (_tokenSet_2.member(LA(2))))) {
				int _m10 = mark();
				synPredMatched10 = true;
				inputState.guessing++;
				try {
					{
					parallelArrayTemplateApplication();
					}
				}
				catch (RecognitionException pe) {
					synPredMatched10 = false;
				}
				rewind(_m10);
inputState.guessing--;
			}
			if ( synPredMatched10 ) {
				parallelArrayTemplateApplication();
				astFactory.addASTChild(currentAST, returnAST);
				templatesExpr_AST = (org.antlr.stringtemplate.language.StringTemplateAST)currentAST.root;
			}
			else if ((_tokenSet_1.member(LA(1))) && (_tokenSet_3.member(LA(2)))) {
				expr();
				astFactory.addASTChild(currentAST, returnAST);
				{
				_loop14:
				do {
					if ((LA(1)==COLON)) {
						c = LT(1);
						c_AST = (org.antlr.stringtemplate.language.StringTemplateAST)astFactory.create(c);
						astFactory.makeASTRoot(currentAST, c_AST);
						match(COLON);
						if ( inputState.guessing==0 ) {
							c_AST.setType(APPLY);
						}
						template();
						astFactory.addASTChild(currentAST, returnAST);
						{
						_loop13:
						do {
							if ((LA(1)==COMMA)) {
								match(COMMA);
								template();
								astFactory.addASTChild(currentAST, returnAST);
							}
							else {
								break _loop13;
							}
							
						} while (true);
						}
					}
					else {
						break _loop14;
					}
					
				} while (true);
				}
				templatesExpr_AST = (org.antlr.stringtemplate.language.StringTemplateAST)currentAST.root;
			}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_4);
			} else {
			  throw ex;
			}
		}
		returnAST = templatesExpr_AST;
	}
	
	public final Map  optionList() throws RecognitionException, TokenStreamException {
		Map opts=new HashMap();
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		org.antlr.stringtemplate.language.StringTemplateAST optionList_AST = null;
		
		try {      // for error handling
			option(opts);
			{
			_loop5:
			do {
				if ((LA(1)==COMMA)) {
					org.antlr.stringtemplate.language.StringTemplateAST tmp9_AST = null;
					tmp9_AST = (org.antlr.stringtemplate.language.StringTemplateAST)astFactory.create(LT(1));
					match(COMMA);
					option(opts);
				}
				else {
					break _loop5;
				}
				
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_0);
			} else {
			  throw ex;
			}
		}
		returnAST = optionList_AST;
		return opts;
	}
	
	public final void ifCondition() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		org.antlr.stringtemplate.language.StringTemplateAST ifCondition_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case LPAREN:
			case ID:
			case LITERAL_first:
			case LITERAL_rest:
			case LITERAL_last:
			case LITERAL_length:
			case LITERAL_strip:
			case LITERAL_trunc:
			case LITERAL_super:
			case ANONYMOUS_TEMPLATE:
			case STRING:
			case INT:
			case LBRACK:
			{
				ifAtom();
				astFactory.addASTChild(currentAST, returnAST);
				ifCondition_AST = (org.antlr.stringtemplate.language.StringTemplateAST)currentAST.root;
				break;
			}
			case NOT:
			{
				org.antlr.stringtemplate.language.StringTemplateAST tmp10_AST = null;
				tmp10_AST = (org.antlr.stringtemplate.language.StringTemplateAST)astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp10_AST);
				match(NOT);
				ifAtom();
				astFactory.addASTChild(currentAST, returnAST);
				ifCondition_AST = (org.antlr.stringtemplate.language.StringTemplateAST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_5);
			} else {
			  throw ex;
			}
		}
		returnAST = ifCondition_AST;
	}
	
	public final void option(
		Map opts
	) throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		org.antlr.stringtemplate.language.StringTemplateAST option_AST = null;
		Token  i = null;
		org.antlr.stringtemplate.language.StringTemplateAST i_AST = null;
		org.antlr.stringtemplate.language.StringTemplateAST e_AST = null;
		
		Object v=null;
		
		
		try {      // for error handling
			i = LT(1);
			i_AST = (org.antlr.stringtemplate.language.StringTemplateAST)astFactory.create(i);
			astFactory.addASTChild(currentAST, i_AST);
			match(ID);
			{
			switch ( LA(1)) {
			case ASSIGN:
			{
				org.antlr.stringtemplate.language.StringTemplateAST tmp11_AST = null;
				tmp11_AST = (org.antlr.stringtemplate.language.StringTemplateAST)astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp11_AST);
				match(ASSIGN);
				expr();
				e_AST = (org.antlr.stringtemplate.language.StringTemplateAST)returnAST;
				astFactory.addASTChild(currentAST, returnAST);
				if ( inputState.guessing==0 ) {
					v=e_AST;
				}
				break;
			}
			case EOF:
			case COMMA:
			{
				if ( inputState.guessing==0 ) {
					v=ASTExpr.EMPTY_OPTION;
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			if ( inputState.guessing==0 ) {
				opts.put(i_AST.getText(),v);
			}
			option_AST = (org.antlr.stringtemplate.language.StringTemplateAST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_6);
			} else {
			  throw ex;
			}
		}
		returnAST = option_AST;
	}
	
	public final void expr() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		org.antlr.stringtemplate.language.StringTemplateAST expr_AST = null;
		
		try {      // for error handling
			primaryExpr();
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop22:
			do {
				if ((LA(1)==PLUS)) {
					org.antlr.stringtemplate.language.StringTemplateAST tmp12_AST = null;
					tmp12_AST = (org.antlr.stringtemplate.language.StringTemplateAST)astFactory.create(LT(1));
					astFactory.makeASTRoot(currentAST, tmp12_AST);
					match(PLUS);
					primaryExpr();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop22;
				}
				
			} while (true);
			}
			expr_AST = (org.antlr.stringtemplate.language.StringTemplateAST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_7);
			} else {
			  throw ex;
			}
		}
		returnAST = expr_AST;
	}
	
	public final void parallelArrayTemplateApplication() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		org.antlr.stringtemplate.language.StringTemplateAST parallelArrayTemplateApplication_AST = null;
		Token  c = null;
		org.antlr.stringtemplate.language.StringTemplateAST c_AST = null;
		
		try {      // for error handling
			expr();
			astFactory.addASTChild(currentAST, returnAST);
			{
			int _cnt17=0;
			_loop17:
			do {
				if ((LA(1)==COMMA)) {
					match(COMMA);
					expr();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					if ( _cnt17>=1 ) { break _loop17; } else {throw new NoViableAltException(LT(1), getFilename());}
				}
				
				_cnt17++;
			} while (true);
			}
			c = LT(1);
			c_AST = (org.antlr.stringtemplate.language.StringTemplateAST)astFactory.create(c);
			astFactory.addASTChild(currentAST, c_AST);
			match(COLON);
			anonymousTemplate();
			astFactory.addASTChild(currentAST, returnAST);
			if ( inputState.guessing==0 ) {
				parallelArrayTemplateApplication_AST = (org.antlr.stringtemplate.language.StringTemplateAST)currentAST.root;
				parallelArrayTemplateApplication_AST =
					(org.antlr.stringtemplate.language.StringTemplateAST)astFactory.make( (new ASTArray(2)).add((org.antlr.stringtemplate.language.StringTemplateAST)astFactory.create(MULTI_APPLY,"MULTI_APPLY")).add(parallelArrayTemplateApplication_AST));
				currentAST.root = parallelArrayTemplateApplication_AST;
				currentAST.child = parallelArrayTemplateApplication_AST!=null &&parallelArrayTemplateApplication_AST.getFirstChild()!=null ?
					parallelArrayTemplateApplication_AST.getFirstChild() : parallelArrayTemplateApplication_AST;
				currentAST.advanceChildToEnd();
			}
			parallelArrayTemplateApplication_AST = (org.antlr.stringtemplate.language.StringTemplateAST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_4);
			} else {
			  throw ex;
			}
		}
		returnAST = parallelArrayTemplateApplication_AST;
	}
	
	public final void template() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		org.antlr.stringtemplate.language.StringTemplateAST template_AST = null;
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case LPAREN:
			case ID:
			case LITERAL_super:
			{
				namedTemplate();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case ANONYMOUS_TEMPLATE:
			{
				anonymousTemplate();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			if ( inputState.guessing==0 ) {
				template_AST = (org.antlr.stringtemplate.language.StringTemplateAST)currentAST.root;
				template_AST = (org.antlr.stringtemplate.language.StringTemplateAST)astFactory.make( (new ASTArray(2)).add((org.antlr.stringtemplate.language.StringTemplateAST)astFactory.create(TEMPLATE)).add(template_AST));
				currentAST.root = template_AST;
				currentAST.child = template_AST!=null &&template_AST.getFirstChild()!=null ?
					template_AST.getFirstChild() : template_AST;
				currentAST.advanceChildToEnd();
			}
			template_AST = (org.antlr.stringtemplate.language.StringTemplateAST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_8);
			} else {
			  throw ex;
			}
		}
		returnAST = template_AST;
	}
	
	public final void anonymousTemplate() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		org.antlr.stringtemplate.language.StringTemplateAST anonymousTemplate_AST = null;
		Token  t = null;
		org.antlr.stringtemplate.language.StringTemplateAST t_AST = null;
		
		try {      // for error handling
			t = LT(1);
			t_AST = (org.antlr.stringtemplate.language.StringTemplateAST)astFactory.create(t);
			astFactory.addASTChild(currentAST, t_AST);
			match(ANONYMOUS_TEMPLATE);
			if ( inputState.guessing==0 ) {
				
				StringTemplate anonymous = new StringTemplate();
				anonymous.setGroup(self.getGroup());
				anonymous.setEnclosingInstance(self);
				anonymous.setTemplate(t.getText());
				anonymous.defineFormalArguments(((StringTemplateToken)t).args);
				t_AST.setStringTemplate(anonymous);
				
			}
			anonymousTemplate_AST = (org.antlr.stringtemplate.language.StringTemplateAST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_8);
			} else {
			  throw ex;
			}
		}
		returnAST = anonymousTemplate_AST;
	}
	
	public final void ifAtom() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		org.antlr.stringtemplate.language.StringTemplateAST ifAtom_AST = null;
		
		try {      // for error handling
			expr();
			astFactory.addASTChild(currentAST, returnAST);
			ifAtom_AST = (org.antlr.stringtemplate.language.StringTemplateAST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_5);
			} else {
			  throw ex;
			}
		}
		returnAST = ifAtom_AST;
	}
	
	public final void primaryExpr() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		org.antlr.stringtemplate.language.StringTemplateAST primaryExpr_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case LITERAL_first:
			case LITERAL_rest:
			case LITERAL_last:
			case LITERAL_length:
			case LITERAL_strip:
			case LITERAL_trunc:
			{
				function();
				astFactory.addASTChild(currentAST, returnAST);
				{
				_loop31:
				do {
					if ((LA(1)==DOT)) {
						org.antlr.stringtemplate.language.StringTemplateAST tmp14_AST = null;
						tmp14_AST = (org.antlr.stringtemplate.language.StringTemplateAST)astFactory.create(LT(1));
						astFactory.makeASTRoot(currentAST, tmp14_AST);
						match(DOT);
						{
						switch ( LA(1)) {
						case ID:
						{
							org.antlr.stringtemplate.language.StringTemplateAST tmp15_AST = null;
							tmp15_AST = (org.antlr.stringtemplate.language.StringTemplateAST)astFactory.create(LT(1));
							astFactory.addASTChild(currentAST, tmp15_AST);
							match(ID);
							break;
						}
						case LPAREN:
						{
							valueExpr();
							astFactory.addASTChild(currentAST, returnAST);
							break;
						}
						default:
						{
							throw new NoViableAltException(LT(1), getFilename());
						}
						}
						}
					}
					else {
						break _loop31;
					}
					
				} while (true);
				}
				primaryExpr_AST = (org.antlr.stringtemplate.language.StringTemplateAST)currentAST.root;
				break;
			}
			case LBRACK:
			{
				list();
				astFactory.addASTChild(currentAST, returnAST);
				primaryExpr_AST = (org.antlr.stringtemplate.language.StringTemplateAST)currentAST.root;
				break;
			}
			default:
				boolean synPredMatched25 = false;
				if (((LA(1)==LPAREN||LA(1)==ID||LA(1)==LITERAL_super) && (_tokenSet_9.member(LA(2))))) {
					int _m25 = mark();
					synPredMatched25 = true;
					inputState.guessing++;
					try {
						{
						templateInclude();
						}
					}
					catch (RecognitionException pe) {
						synPredMatched25 = false;
					}
					rewind(_m25);
inputState.guessing--;
				}
				if ( synPredMatched25 ) {
					templateInclude();
					astFactory.addASTChild(currentAST, returnAST);
					primaryExpr_AST = (org.antlr.stringtemplate.language.StringTemplateAST)currentAST.root;
				}
				else if ((_tokenSet_10.member(LA(1))) && (_tokenSet_11.member(LA(2)))) {
					atom();
					astFactory.addASTChild(currentAST, returnAST);
					{
					_loop28:
					do {
						if ((LA(1)==DOT)) {
							org.antlr.stringtemplate.language.StringTemplateAST tmp16_AST = null;
							tmp16_AST = (org.antlr.stringtemplate.language.StringTemplateAST)astFactory.create(LT(1));
							astFactory.makeASTRoot(currentAST, tmp16_AST);
							match(DOT);
							{
							switch ( LA(1)) {
							case ID:
							{
								org.antlr.stringtemplate.language.StringTemplateAST tmp17_AST = null;
								tmp17_AST = (org.antlr.stringtemplate.language.StringTemplateAST)astFactory.create(LT(1));
								astFactory.addASTChild(currentAST, tmp17_AST);
								match(ID);
								break;
							}
							case LPAREN:
							{
								valueExpr();
								astFactory.addASTChild(currentAST, returnAST);
								break;
							}
							default:
							{
								throw new NoViableAltException(LT(1), getFilename());
							}
							}
							}
						}
						else {
							break _loop28;
						}
						
					} while (true);
					}
					primaryExpr_AST = (org.antlr.stringtemplate.language.StringTemplateAST)currentAST.root;
				}
				else if ((LA(1)==LPAREN) && (_tokenSet_1.member(LA(2)))) {
					valueExpr();
					astFactory.addASTChild(currentAST, returnAST);
					primaryExpr_AST = (org.antlr.stringtemplate.language.StringTemplateAST)currentAST.root;
				}
			else {
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_12);
			} else {
			  throw ex;
			}
		}
		returnAST = primaryExpr_AST;
	}
	
	public final void templateInclude() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		org.antlr.stringtemplate.language.StringTemplateAST templateInclude_AST = null;
		Token  id = null;
		org.antlr.stringtemplate.language.StringTemplateAST id_AST = null;
		Token  qid = null;
		org.antlr.stringtemplate.language.StringTemplateAST qid_AST = null;
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case ID:
			{
				id = LT(1);
				id_AST = (org.antlr.stringtemplate.language.StringTemplateAST)astFactory.create(id);
				astFactory.addASTChild(currentAST, id_AST);
				match(ID);
				argList();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case LITERAL_super:
			{
				match(LITERAL_super);
				match(DOT);
				qid = LT(1);
				qid_AST = (org.antlr.stringtemplate.language.StringTemplateAST)astFactory.create(qid);
				astFactory.addASTChild(currentAST, qid_AST);
				match(ID);
				if ( inputState.guessing==0 ) {
					qid_AST.setText("super."+qid_AST.getText());
				}
				argList();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			case LPAREN:
			{
				indirectTemplate();
				astFactory.addASTChild(currentAST, returnAST);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			if ( inputState.guessing==0 ) {
				templateInclude_AST = (org.antlr.stringtemplate.language.StringTemplateAST)currentAST.root;
				templateInclude_AST = (org.antlr.stringtemplate.language.StringTemplateAST)astFactory.make( (new ASTArray(2)).add((org.antlr.stringtemplate.language.StringTemplateAST)astFactory.create(INCLUDE,"include")).add(templateInclude_AST));
				currentAST.root = templateInclude_AST;
				currentAST.child = templateInclude_AST!=null &&templateInclude_AST.getFirstChild()!=null ?
					templateInclude_AST.getFirstChild() : templateInclude_AST;
				currentAST.advanceChildToEnd();
			}
			templateInclude_AST = (org.antlr.stringtemplate.language.StringTemplateAST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_12);
			} else {
			  throw ex;
			}
		}
		returnAST = templateInclude_AST;
	}
	
	public final void atom() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		org.antlr.stringtemplate.language.StringTemplateAST atom_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case ID:
			{
				org.antlr.stringtemplate.language.StringTemplateAST tmp20_AST = null;
				tmp20_AST = (org.antlr.stringtemplate.language.StringTemplateAST)astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp20_AST);
				match(ID);
				atom_AST = (org.antlr.stringtemplate.language.StringTemplateAST)currentAST.root;
				break;
			}
			case STRING:
			{
				org.antlr.stringtemplate.language.StringTemplateAST tmp21_AST = null;
				tmp21_AST = (org.antlr.stringtemplate.language.StringTemplateAST)astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp21_AST);
				match(STRING);
				atom_AST = (org.antlr.stringtemplate.language.StringTemplateAST)currentAST.root;
				break;
			}
			case INT:
			{
				org.antlr.stringtemplate.language.StringTemplateAST tmp22_AST = null;
				tmp22_AST = (org.antlr.stringtemplate.language.StringTemplateAST)astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp22_AST);
				match(INT);
				atom_AST = (org.antlr.stringtemplate.language.StringTemplateAST)currentAST.root;
				break;
			}
			case ANONYMOUS_TEMPLATE:
			{
				org.antlr.stringtemplate.language.StringTemplateAST tmp23_AST = null;
				tmp23_AST = (org.antlr.stringtemplate.language.StringTemplateAST)astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp23_AST);
				match(ANONYMOUS_TEMPLATE);
				atom_AST = (org.antlr.stringtemplate.language.StringTemplateAST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_11);
			} else {
			  throw ex;
			}
		}
		returnAST = atom_AST;
	}
	
	public final void valueExpr() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		org.antlr.stringtemplate.language.StringTemplateAST valueExpr_AST = null;
		Token  eval = null;
		org.antlr.stringtemplate.language.StringTemplateAST eval_AST = null;
		
		try {      // for error handling
			eval = LT(1);
			eval_AST = (org.antlr.stringtemplate.language.StringTemplateAST)astFactory.create(eval);
			astFactory.makeASTRoot(currentAST, eval_AST);
			match(LPAREN);
			templatesExpr();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			if ( inputState.guessing==0 ) {
				eval_AST.setType(VALUE); eval_AST.setText("value");
			}
			valueExpr_AST = (org.antlr.stringtemplate.language.StringTemplateAST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_11);
			} else {
			  throw ex;
			}
		}
		returnAST = valueExpr_AST;
	}
	
	public final void function() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		org.antlr.stringtemplate.language.StringTemplateAST function_AST = null;
		
		try {      // for error handling
			{
			switch ( LA(1)) {
			case LITERAL_first:
			{
				org.antlr.stringtemplate.language.StringTemplateAST tmp25_AST = null;
				tmp25_AST = (org.antlr.stringtemplate.language.StringTemplateAST)astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp25_AST);
				match(LITERAL_first);
				break;
			}
			case LITERAL_rest:
			{
				org.antlr.stringtemplate.language.StringTemplateAST tmp26_AST = null;
				tmp26_AST = (org.antlr.stringtemplate.language.StringTemplateAST)astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp26_AST);
				match(LITERAL_rest);
				break;
			}
			case LITERAL_last:
			{
				org.antlr.stringtemplate.language.StringTemplateAST tmp27_AST = null;
				tmp27_AST = (org.antlr.stringtemplate.language.StringTemplateAST)astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp27_AST);
				match(LITERAL_last);
				break;
			}
			case LITERAL_length:
			{
				org.antlr.stringtemplate.language.StringTemplateAST tmp28_AST = null;
				tmp28_AST = (org.antlr.stringtemplate.language.StringTemplateAST)astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp28_AST);
				match(LITERAL_length);
				break;
			}
			case LITERAL_strip:
			{
				org.antlr.stringtemplate.language.StringTemplateAST tmp29_AST = null;
				tmp29_AST = (org.antlr.stringtemplate.language.StringTemplateAST)astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp29_AST);
				match(LITERAL_strip);
				break;
			}
			case LITERAL_trunc:
			{
				org.antlr.stringtemplate.language.StringTemplateAST tmp30_AST = null;
				tmp30_AST = (org.antlr.stringtemplate.language.StringTemplateAST)astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp30_AST);
				match(LITERAL_trunc);
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
			}
			singleArg();
			astFactory.addASTChild(currentAST, returnAST);
			if ( inputState.guessing==0 ) {
				function_AST = (org.antlr.stringtemplate.language.StringTemplateAST)currentAST.root;
				function_AST = (org.antlr.stringtemplate.language.StringTemplateAST)astFactory.make( (new ASTArray(2)).add((org.antlr.stringtemplate.language.StringTemplateAST)astFactory.create(FUNCTION)).add(function_AST));
				currentAST.root = function_AST;
				currentAST.child = function_AST!=null &&function_AST.getFirstChild()!=null ?
					function_AST.getFirstChild() : function_AST;
				currentAST.advanceChildToEnd();
			}
			function_AST = (org.antlr.stringtemplate.language.StringTemplateAST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_11);
			} else {
			  throw ex;
			}
		}
		returnAST = function_AST;
	}
	
	public final void list() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		org.antlr.stringtemplate.language.StringTemplateAST list_AST = null;
		Token  lb = null;
		org.antlr.stringtemplate.language.StringTemplateAST lb_AST = null;
		
		try {      // for error handling
			lb = LT(1);
			lb_AST = (org.antlr.stringtemplate.language.StringTemplateAST)astFactory.create(lb);
			astFactory.makeASTRoot(currentAST, lb_AST);
			match(LBRACK);
			if ( inputState.guessing==0 ) {
				lb_AST.setType(LIST); lb_AST.setText("value");
			}
			listElement();
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop45:
			do {
				if ((LA(1)==COMMA)) {
					match(COMMA);
					listElement();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop45;
				}
				
			} while (true);
			}
			match(RBRACK);
			list_AST = (org.antlr.stringtemplate.language.StringTemplateAST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_12);
			} else {
			  throw ex;
			}
		}
		returnAST = list_AST;
	}
	
	public final void nonAlternatingTemplateExpr() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		org.antlr.stringtemplate.language.StringTemplateAST nonAlternatingTemplateExpr_AST = null;
		Token  c = null;
		org.antlr.stringtemplate.language.StringTemplateAST c_AST = null;
		
		try {      // for error handling
			expr();
			astFactory.addASTChild(currentAST, returnAST);
			{
			_loop35:
			do {
				if ((LA(1)==COLON)) {
					c = LT(1);
					c_AST = (org.antlr.stringtemplate.language.StringTemplateAST)astFactory.create(c);
					astFactory.makeASTRoot(currentAST, c_AST);
					match(COLON);
					if ( inputState.guessing==0 ) {
						c_AST.setType(APPLY);
					}
					template();
					astFactory.addASTChild(currentAST, returnAST);
				}
				else {
					break _loop35;
				}
				
			} while (true);
			}
			nonAlternatingTemplateExpr_AST = (org.antlr.stringtemplate.language.StringTemplateAST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_13);
			} else {
			  throw ex;
			}
		}
		returnAST = nonAlternatingTemplateExpr_AST;
	}
	
	public final void singleArg() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		org.antlr.stringtemplate.language.StringTemplateAST singleArg_AST = null;
		
		try {      // for error handling
			match(LPAREN);
			nonAlternatingTemplateExpr();
			astFactory.addASTChild(currentAST, returnAST);
			match(RPAREN);
			if ( inputState.guessing==0 ) {
				singleArg_AST = (org.antlr.stringtemplate.language.StringTemplateAST)currentAST.root;
				singleArg_AST = (org.antlr.stringtemplate.language.StringTemplateAST)astFactory.make( (new ASTArray(2)).add((org.antlr.stringtemplate.language.StringTemplateAST)astFactory.create(SINGLEVALUEARG,"SINGLEVALUEARG")).add(singleArg_AST));
				currentAST.root = singleArg_AST;
				currentAST.child = singleArg_AST!=null &&singleArg_AST.getFirstChild()!=null ?
					singleArg_AST.getFirstChild() : singleArg_AST;
				currentAST.advanceChildToEnd();
			}
			singleArg_AST = (org.antlr.stringtemplate.language.StringTemplateAST)currentAST.root;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_11);
			} else {
			  throw ex;
			}
		}
		returnAST = singleArg_AST;
	}
	
	public final void namedTemplate() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		org.antlr.stringtemplate.language.StringTemplateAST namedTemplate_AST = null;
		Token  qid = null;
		org.antlr.stringtemplate.language.StringTemplateAST qid_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case ID:
			{
				org.antlr.stringtemplate.language.StringTemplateAST tmp35_AST = null;
				tmp35_AST = (org.antlr.stringtemplate.language.StringTemplateAST)astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp35_AST);
				match(ID);
				argList();
				astFactory.addASTChild(currentAST, returnAST);
				namedTemplate_AST = (org.antlr.stringtemplate.language.StringTemplateAST)currentAST.root;
				break;
			}
			case LITERAL_super:
			{
				match(LITERAL_super);
				match(DOT);
				qid = LT(1);
				qid_AST = (org.antlr.stringtemplate.language.StringTemplateAST)astFactory.create(qid);
				astFactory.addASTChild(currentAST, qid_AST);
				match(ID);
				if ( inputState.guessing==0 ) {
					qid_AST.setText("super."+qid_AST.getText());
				}
				argList();
				astFactory.addASTChild(currentAST, returnAST);
				namedTemplate_AST = (org.antlr.stringtemplate.language.StringTemplateAST)currentAST.root;
				break;
			}
			case LPAREN:
			{
				indirectTemplate();
				astFactory.addASTChild(currentAST, returnAST);
				namedTemplate_AST = (org.antlr.stringtemplate.language.StringTemplateAST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_8);
			} else {
			  throw ex;
			}
		}
		returnAST = namedTemplate_AST;
	}
	
	public final void argList() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		org.antlr.stringtemplate.language.StringTemplateAST argList_AST = null;
		
		try {      // for error handling
			if ((LA(1)==LPAREN) && (LA(2)==RPAREN)) {
				match(LPAREN);
				match(RPAREN);
				if ( inputState.guessing==0 ) {
					argList_AST = (org.antlr.stringtemplate.language.StringTemplateAST)currentAST.root;
					argList_AST = (org.antlr.stringtemplate.language.StringTemplateAST)astFactory.create(ARGS,"ARGS");
					currentAST.root = argList_AST;
					currentAST.child = argList_AST!=null &&argList_AST.getFirstChild()!=null ?
						argList_AST.getFirstChild() : argList_AST;
					currentAST.advanceChildToEnd();
				}
			}
			else {
				boolean synPredMatched52 = false;
				if (((LA(1)==LPAREN) && (_tokenSet_1.member(LA(2))))) {
					int _m52 = mark();
					synPredMatched52 = true;
					inputState.guessing++;
					try {
						{
						singleArg();
						}
					}
					catch (RecognitionException pe) {
						synPredMatched52 = false;
					}
					rewind(_m52);
inputState.guessing--;
				}
				if ( synPredMatched52 ) {
					singleArg();
					astFactory.addASTChild(currentAST, returnAST);
					argList_AST = (org.antlr.stringtemplate.language.StringTemplateAST)currentAST.root;
				}
				else if ((LA(1)==LPAREN) && (LA(2)==ID||LA(2)==DOTDOTDOT)) {
					match(LPAREN);
					argumentAssignment();
					astFactory.addASTChild(currentAST, returnAST);
					{
					_loop54:
					do {
						if ((LA(1)==COMMA)) {
							match(COMMA);
							argumentAssignment();
							astFactory.addASTChild(currentAST, returnAST);
						}
						else {
							break _loop54;
						}
						
					} while (true);
					}
					match(RPAREN);
					if ( inputState.guessing==0 ) {
						argList_AST = (org.antlr.stringtemplate.language.StringTemplateAST)currentAST.root;
						argList_AST = (org.antlr.stringtemplate.language.StringTemplateAST)astFactory.make( (new ASTArray(2)).add((org.antlr.stringtemplate.language.StringTemplateAST)astFactory.create(ARGS,"ARGS")).add(argList_AST));
						currentAST.root = argList_AST;
						currentAST.child = argList_AST!=null &&argList_AST.getFirstChild()!=null ?
							argList_AST.getFirstChild() : argList_AST;
						currentAST.advanceChildToEnd();
					}
					argList_AST = (org.antlr.stringtemplate.language.StringTemplateAST)currentAST.root;
				}
				else {
					throw new NoViableAltException(LT(1), getFilename());
				}
				}
			}
			catch (RecognitionException ex) {
				if (inputState.guessing==0) {
					reportError(ex);
					recover(ex,_tokenSet_12);
				} else {
				  throw ex;
				}
			}
			returnAST = argList_AST;
		}
		
/** Match (foo)() and (foo+".terse")() */
	public final void indirectTemplate() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		org.antlr.stringtemplate.language.StringTemplateAST indirectTemplate_AST = null;
		org.antlr.stringtemplate.language.StringTemplateAST e_AST = null;
		org.antlr.stringtemplate.language.StringTemplateAST args_AST = null;
		
		try {      // for error handling
			org.antlr.stringtemplate.language.StringTemplateAST tmp43_AST = null;
			tmp43_AST = (org.antlr.stringtemplate.language.StringTemplateAST)astFactory.create(LT(1));
			match(LPAREN);
			templatesExpr();
			e_AST = (org.antlr.stringtemplate.language.StringTemplateAST)returnAST;
			org.antlr.stringtemplate.language.StringTemplateAST tmp44_AST = null;
			tmp44_AST = (org.antlr.stringtemplate.language.StringTemplateAST)astFactory.create(LT(1));
			match(RPAREN);
			argList();
			args_AST = (org.antlr.stringtemplate.language.StringTemplateAST)returnAST;
			if ( inputState.guessing==0 ) {
				indirectTemplate_AST = (org.antlr.stringtemplate.language.StringTemplateAST)currentAST.root;
				indirectTemplate_AST = (org.antlr.stringtemplate.language.StringTemplateAST)astFactory.make( (new ASTArray(3)).add((org.antlr.stringtemplate.language.StringTemplateAST)astFactory.create(VALUE,"value")).add(e_AST).add(args_AST));
				currentAST.root = indirectTemplate_AST;
				currentAST.child = indirectTemplate_AST!=null &&indirectTemplate_AST.getFirstChild()!=null ?
					indirectTemplate_AST.getFirstChild() : indirectTemplate_AST;
				currentAST.advanceChildToEnd();
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_12);
			} else {
			  throw ex;
			}
		}
		returnAST = indirectTemplate_AST;
	}
	
	public final void listElement() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		org.antlr.stringtemplate.language.StringTemplateAST listElement_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case LPAREN:
			case ID:
			case LITERAL_first:
			case LITERAL_rest:
			case LITERAL_last:
			case LITERAL_length:
			case LITERAL_strip:
			case LITERAL_trunc:
			case LITERAL_super:
			case ANONYMOUS_TEMPLATE:
			case STRING:
			case INT:
			case LBRACK:
			{
				expr();
				astFactory.addASTChild(currentAST, returnAST);
				listElement_AST = (org.antlr.stringtemplate.language.StringTemplateAST)currentAST.root;
				break;
			}
			case COMMA:
			case RBRACK:
			{
				if ( inputState.guessing==0 ) {
					listElement_AST = (org.antlr.stringtemplate.language.StringTemplateAST)currentAST.root;
					listElement_AST = (org.antlr.stringtemplate.language.StringTemplateAST)astFactory.create(NOTHING,"NOTHING");
					currentAST.root = listElement_AST;
					currentAST.child = listElement_AST!=null &&listElement_AST.getFirstChild()!=null ?
						listElement_AST.getFirstChild() : listElement_AST;
					currentAST.advanceChildToEnd();
				}
				listElement_AST = (org.antlr.stringtemplate.language.StringTemplateAST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_14);
			} else {
			  throw ex;
			}
		}
		returnAST = listElement_AST;
	}
	
	public final void argumentAssignment() throws RecognitionException, TokenStreamException {
		
		returnAST = null;
		ASTPair currentAST = new ASTPair();
		org.antlr.stringtemplate.language.StringTemplateAST argumentAssignment_AST = null;
		
		try {      // for error handling
			switch ( LA(1)) {
			case ID:
			{
				org.antlr.stringtemplate.language.StringTemplateAST tmp45_AST = null;
				tmp45_AST = (org.antlr.stringtemplate.language.StringTemplateAST)astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp45_AST);
				match(ID);
				org.antlr.stringtemplate.language.StringTemplateAST tmp46_AST = null;
				tmp46_AST = (org.antlr.stringtemplate.language.StringTemplateAST)astFactory.create(LT(1));
				astFactory.makeASTRoot(currentAST, tmp46_AST);
				match(ASSIGN);
				nonAlternatingTemplateExpr();
				astFactory.addASTChild(currentAST, returnAST);
				argumentAssignment_AST = (org.antlr.stringtemplate.language.StringTemplateAST)currentAST.root;
				break;
			}
			case DOTDOTDOT:
			{
				org.antlr.stringtemplate.language.StringTemplateAST tmp47_AST = null;
				tmp47_AST = (org.antlr.stringtemplate.language.StringTemplateAST)astFactory.create(LT(1));
				astFactory.addASTChild(currentAST, tmp47_AST);
				match(DOTDOTDOT);
				argumentAssignment_AST = (org.antlr.stringtemplate.language.StringTemplateAST)currentAST.root;
				break;
			}
			default:
			{
				throw new NoViableAltException(LT(1), getFilename());
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				recover(ex,_tokenSet_13);
			} else {
			  throw ex;
			}
		}
		returnAST = argumentAssignment_AST;
	}
	
	
	public static final String[] _tokenNames = {
		"<0>",
		"EOF",
		"<2>",
		"NULL_TREE_LOOKAHEAD",
		"APPLY",
		"MULTI_APPLY",
		"ARGS",
		"INCLUDE",
		"\"if\"",
		"VALUE",
		"TEMPLATE",
		"FUNCTION",
		"SINGLEVALUEARG",
		"LIST",
		"NOTHING",
		"SEMI",
		"LPAREN",
		"RPAREN",
		"\"elseif\"",
		"COMMA",
		"ID",
		"ASSIGN",
		"COLON",
		"NOT",
		"PLUS",
		"DOT",
		"\"first\"",
		"\"rest\"",
		"\"last\"",
		"\"length\"",
		"\"strip\"",
		"\"trunc\"",
		"\"super\"",
		"ANONYMOUS_TEMPLATE",
		"STRING",
		"INT",
		"LBRACK",
		"RBRACK",
		"DOTDOTDOT",
		"TEMPLATE_ARGS",
		"NESTED_ANONYMOUS_TEMPLATE",
		"ESC_CHAR",
		"WS",
		"WS_CHAR"
	};
	
	protected void buildTokenTypeASTClassMap() {
		tokenTypeToASTClassMap=null;
	};
	
	private static final long[] mk_tokenSet_0() {
		long[] data = { 2L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_0 = new BitSet(mk_tokenSet_0());
	private static final long[] mk_tokenSet_1() {
		long[] data = { 137372958720L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_1 = new BitSet(mk_tokenSet_1());
	private static final long[] mk_tokenSet_2() {
		long[] data = { 274862768128L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_2 = new BitSet(mk_tokenSet_2());
	private static final long[] mk_tokenSet_3() {
		long[] data = { 274867126274L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_3 = new BitSet(mk_tokenSet_3());
	private static final long[] mk_tokenSet_4() {
		long[] data = { 163842L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_4 = new BitSet(mk_tokenSet_4());
	private static final long[] mk_tokenSet_5() {
		long[] data = { 131072L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_5 = new BitSet(mk_tokenSet_5());
	private static final long[] mk_tokenSet_6() {
		long[] data = { 524290L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_6 = new BitSet(mk_tokenSet_6());
	private static final long[] mk_tokenSet_7() {
		long[] data = { 137443835906L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_7 = new BitSet(mk_tokenSet_7());
	private static final long[] mk_tokenSet_8() {
		long[] data = { 4882434L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_8 = new BitSet(mk_tokenSet_8());
	private static final long[] mk_tokenSet_9() {
		long[] data = { 137406513152L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_9 = new BitSet(mk_tokenSet_9());
	private static final long[] mk_tokenSet_10() {
		long[] data = { 60130590720L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_10 = new BitSet(mk_tokenSet_10());
	private static final long[] mk_tokenSet_11() {
		long[] data = { 137494167554L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_11 = new BitSet(mk_tokenSet_11());
	private static final long[] mk_tokenSet_12() {
		long[] data = { 137460613122L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_12 = new BitSet(mk_tokenSet_12());
	private static final long[] mk_tokenSet_13() {
		long[] data = { 655360L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_13 = new BitSet(mk_tokenSet_13());
	private static final long[] mk_tokenSet_14() {
		long[] data = { 137439477760L, 0L};
		return data;
	}
	public static final BitSet _tokenSet_14 = new BitSet(mk_tokenSet_14());
	
	}
