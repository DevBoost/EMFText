// $ANTLR 2.7.7 (2006-01-29): "define.g" -> "DefineGrammarItemsWalker.java"$

/*
 [The "BSD licence"]
 Copyright (c) 2005-2006 Terence Parr
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
	package org.antlr.tool;
	import java.util.*;
	import org.antlr.misc.*;

import antlr.TreeParser;
import antlr.Token;
import antlr.collections.AST;
import antlr.RecognitionException;
import antlr.ANTLRException;
import antlr.NoViableAltException;
import antlr.MismatchedTokenException;
import antlr.SemanticException;
import antlr.collections.impl.BitSet;
import antlr.ASTPair;
import antlr.collections.impl.ASTArray;


public class DefineGrammarItemsWalker extends antlr.TreeParser       implements DefineGrammarItemsWalkerTokenTypes
 {

protected Grammar grammar;
protected GrammarAST root;
protected String currentRuleName;
protected GrammarAST currentRewriteBlock;
protected GrammarAST currentRewriteRule;
protected int outerAltNum = 0;
protected int blockLevel = 0;

    public void reportError(RecognitionException ex) {
		Token token = null;
		if ( ex instanceof MismatchedTokenException ) {
			token = ((MismatchedTokenException)ex).token;
		}
		else if ( ex instanceof NoViableAltException ) {
			token = ((NoViableAltException)ex).token;
		}
        ErrorManager.syntaxError(
            ErrorManager.MSG_SYNTAX_ERROR,
            grammar,
            token,
            "define: "+ex.toString(),
            ex);
    }

	protected void finish() {
		trimGrammar();
	}

	/** Remove any lexer rules from a COMBINED; already passed to lexer */
	protected void trimGrammar() {
		if ( grammar.type!=Grammar.COMBINED ) {
			return;
		}
		// form is (header ... ) ( grammar ID (scope ...) ... ( rule ... ) ( rule ... ) ... )
		GrammarAST p = root;
		// find the grammar spec
		while ( !p.getText().equals("grammar") ) {
			p = (GrammarAST)p.getNextSibling();
		}
		p = (GrammarAST)p.getFirstChild(); // jump down to first child of grammar
		// look for first RULE def
		GrammarAST prev = p; // points to the ID (grammar name)
		while ( p.getType()!=RULE ) {
			prev = p;
			p = (GrammarAST)p.getNextSibling();
		}
		// prev points at last node before first rule subtree at this point
		while ( p!=null ) {
			String ruleName = p.getFirstChild().getText();
			//System.out.println("rule "+ruleName+" prev="+prev.getText());
			if ( Character.isUpperCase(ruleName.charAt(0)) ) {
				// remove lexer rule
				prev.setNextSibling(p.getNextSibling());
			}
			else {
				prev = p; // non-lexer rule; move on
			}
			p = (GrammarAST)p.getNextSibling();
		}
		//System.out.println("root after removal is: "+root.toStringList());
	}

    protected void trackInlineAction(GrammarAST actionAST) {
		Rule r = grammar.getRule(currentRuleName);
        if ( r!=null ) {
            r.trackInlineAction(actionAST);
        }
    }

public DefineGrammarItemsWalker() {
	tokenNames = _tokenNames;
}

	public final void grammar(AST _t,
		Grammar g
	) throws RecognitionException {
		
		GrammarAST grammar_AST_in = (_t == ASTNULL) ? null : (GrammarAST)_t;
		
		grammar = g;
		root = grammar_AST_in;
		
		
		try {      // for error handling
			{
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case LEXER_GRAMMAR:
			{
				AST __t3 = _t;
				GrammarAST tmp1_AST_in = (GrammarAST)_t;
				match(_t,LEXER_GRAMMAR);
				_t = _t.getFirstChild();
				if ( inputState.guessing==0 ) {
					grammar.type = Grammar.LEXER;
				}
				grammarSpec(_t);
				_t = _retTree;
				_t = __t3;
				_t = _t.getNextSibling();
				break;
			}
			case PARSER_GRAMMAR:
			{
				AST __t4 = _t;
				GrammarAST tmp2_AST_in = (GrammarAST)_t;
				match(_t,PARSER_GRAMMAR);
				_t = _t.getFirstChild();
				if ( inputState.guessing==0 ) {
					grammar.type = Grammar.PARSER;
				}
				grammarSpec(_t);
				_t = _retTree;
				_t = __t4;
				_t = _t.getNextSibling();
				break;
			}
			case TREE_GRAMMAR:
			{
				AST __t5 = _t;
				GrammarAST tmp3_AST_in = (GrammarAST)_t;
				match(_t,TREE_GRAMMAR);
				_t = _t.getFirstChild();
				if ( inputState.guessing==0 ) {
					grammar.type = Grammar.TREE_PARSER;
				}
				grammarSpec(_t);
				_t = _retTree;
				_t = __t5;
				_t = _t.getNextSibling();
				break;
			}
			case COMBINED_GRAMMAR:
			{
				AST __t6 = _t;
				GrammarAST tmp4_AST_in = (GrammarAST)_t;
				match(_t,COMBINED_GRAMMAR);
				_t = _t.getFirstChild();
				if ( inputState.guessing==0 ) {
					grammar.type = Grammar.COMBINED;
				}
				grammarSpec(_t);
				_t = _retTree;
				_t = __t6;
				_t = _t.getNextSibling();
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
			}
			if ( inputState.guessing==0 ) {
				finish();
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void grammarSpec(AST _t) throws RecognitionException {
		
		GrammarAST grammarSpec_AST_in = (_t == ASTNULL) ? null : (GrammarAST)_t;
		GrammarAST id = null;
		GrammarAST cmt = null;
		
		Map opts=null;
		Token optionsStartToken=null;
		
		
		try {      // for error handling
			id = (GrammarAST)_t;
			match(_t,ID);
			_t = _t.getNextSibling();
			{
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case DOC_COMMENT:
			{
				cmt = (GrammarAST)_t;
				match(_t,DOC_COMMENT);
				_t = _t.getNextSibling();
				break;
			}
			case OPTIONS:
			case TOKENS:
			case RULE:
			case SCOPE:
			case AMPERSAND:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
			}
			{
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case OPTIONS:
			{
				if ( inputState.guessing==0 ) {
					optionsStartToken=((GrammarAST)_t).getToken();
				}
				optionsSpec(_t);
				_t = _retTree;
				break;
			}
			case TOKENS:
			case RULE:
			case SCOPE:
			case AMPERSAND:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
			}
			{
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case TOKENS:
			{
				tokensSpec(_t);
				_t = _retTree;
				break;
			}
			case RULE:
			case SCOPE:
			case AMPERSAND:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
			}
			{
			_loop14:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_t.getType()==SCOPE)) {
					attrScope(_t);
					_t = _retTree;
				}
				else {
					break _loop14;
				}
				
			} while (true);
			}
			{
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case AMPERSAND:
			{
				actions(_t);
				_t = _retTree;
				break;
			}
			case RULE:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
			}
			rules(_t);
			_t = _retTree;
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void attrScope(AST _t) throws RecognitionException {
		
		GrammarAST attrScope_AST_in = (_t == ASTNULL) ? null : (GrammarAST)_t;
		GrammarAST name = null;
		GrammarAST attrs = null;
		
		try {      // for error handling
			AST __t8 = _t;
			GrammarAST tmp5_AST_in = (GrammarAST)_t;
			match(_t,SCOPE);
			_t = _t.getFirstChild();
			name = (GrammarAST)_t;
			match(_t,ID);
			_t = _t.getNextSibling();
			attrs = (GrammarAST)_t;
			match(_t,ACTION);
			_t = _t.getNextSibling();
			_t = __t8;
			_t = _t.getNextSibling();
			if ( inputState.guessing==0 ) {
				
						AttributeScope scope = grammar.defineGlobalScope(name.getText(),attrs.token);
						scope.isDynamicGlobalScope = true;
						scope.addAttributes(attrs.getText(), ";");
						
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void optionsSpec(AST _t) throws RecognitionException {
		
		GrammarAST optionsSpec_AST_in = (_t == ASTNULL) ? null : (GrammarAST)_t;
		
		try {      // for error handling
			GrammarAST tmp6_AST_in = (GrammarAST)_t;
			match(_t,OPTIONS);
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void tokensSpec(AST _t) throws RecognitionException {
		
		GrammarAST tokensSpec_AST_in = (_t == ASTNULL) ? null : (GrammarAST)_t;
		
		try {      // for error handling
			AST __t24 = _t;
			GrammarAST tmp7_AST_in = (GrammarAST)_t;
			match(_t,TOKENS);
			_t = _t.getFirstChild();
			{
			int _cnt26=0;
			_loop26:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_t.getType()==ASSIGN||_t.getType()==TOKEN_REF)) {
					tokenSpec(_t);
					_t = _retTree;
				}
				else {
					if ( _cnt26>=1 ) { break _loop26; } else {throw new NoViableAltException(_t);}
				}
				
				_cnt26++;
			} while (true);
			}
			_t = __t24;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void actions(AST _t) throws RecognitionException {
		
		GrammarAST actions_AST_in = (_t == ASTNULL) ? null : (GrammarAST)_t;
		
		try {      // for error handling
			{
			int _cnt18=0;
			_loop18:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_t.getType()==AMPERSAND)) {
					action(_t);
					_t = _retTree;
				}
				else {
					if ( _cnt18>=1 ) { break _loop18; } else {throw new NoViableAltException(_t);}
				}
				
				_cnt18++;
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void rules(AST _t) throws RecognitionException {
		
		GrammarAST rules_AST_in = (_t == ASTNULL) ? null : (GrammarAST)_t;
		
		try {      // for error handling
			{
			int _cnt32=0;
			_loop32:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_t.getType()==RULE)) {
					rule(_t);
					_t = _retTree;
				}
				else {
					if ( _cnt32>=1 ) { break _loop32; } else {throw new NoViableAltException(_t);}
				}
				
				_cnt32++;
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void action(AST _t) throws RecognitionException {
		
		GrammarAST action_AST_in = (_t == ASTNULL) ? null : (GrammarAST)_t;
		GrammarAST amp = null;
		GrammarAST id1 = null;
		GrammarAST id2 = null;
		GrammarAST a1 = null;
		GrammarAST a2 = null;
		
		String scope=null;
		GrammarAST nameAST=null, actionAST=null;
		
		
		try {      // for error handling
			AST __t20 = _t;
			amp = _t==ASTNULL ? null :(GrammarAST)_t;
			match(_t,AMPERSAND);
			_t = _t.getFirstChild();
			id1 = (GrammarAST)_t;
			match(_t,ID);
			_t = _t.getNextSibling();
			{
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case ID:
			{
				id2 = (GrammarAST)_t;
				match(_t,ID);
				_t = _t.getNextSibling();
				a1 = (GrammarAST)_t;
				match(_t,ACTION);
				_t = _t.getNextSibling();
				if ( inputState.guessing==0 ) {
					scope=id1.getText(); nameAST=id2; actionAST=a1;
				}
				break;
			}
			case ACTION:
			{
				a2 = (GrammarAST)_t;
				match(_t,ACTION);
				_t = _t.getNextSibling();
				if ( inputState.guessing==0 ) {
					scope=null; nameAST=id1; actionAST=a2;
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
			}
			_t = __t20;
			_t = _t.getNextSibling();
			if ( inputState.guessing==0 ) {
				
						 grammar.defineNamedAction(amp,scope,nameAST,actionAST);
						
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void tokenSpec(AST _t) throws RecognitionException {
		
		GrammarAST tokenSpec_AST_in = (_t == ASTNULL) ? null : (GrammarAST)_t;
		GrammarAST t = null;
		GrammarAST t2 = null;
		GrammarAST s = null;
		GrammarAST c = null;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case TOKEN_REF:
			{
				t = (GrammarAST)_t;
				match(_t,TOKEN_REF);
				_t = _t.getNextSibling();
				break;
			}
			case ASSIGN:
			{
				AST __t28 = _t;
				GrammarAST tmp8_AST_in = (GrammarAST)_t;
				match(_t,ASSIGN);
				_t = _t.getFirstChild();
				t2 = (GrammarAST)_t;
				match(_t,TOKEN_REF);
				_t = _t.getNextSibling();
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case STRING_LITERAL:
				{
					s = (GrammarAST)_t;
					match(_t,STRING_LITERAL);
					_t = _t.getNextSibling();
					break;
				}
				case CHAR_LITERAL:
				{
					c = (GrammarAST)_t;
					match(_t,CHAR_LITERAL);
					_t = _t.getNextSibling();
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
				}
				_t = __t28;
				_t = _t.getNextSibling();
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void rule(AST _t) throws RecognitionException {
		
		GrammarAST rule_AST_in = (_t == ASTNULL) ? null : (GrammarAST)_t;
		GrammarAST id = null;
		GrammarAST args = null;
		GrammarAST ret = null;
		GrammarAST b = null;
		
		String mod=null;
		String name=null;
		Map opts=null;
		Rule r = null;
		
		
		try {      // for error handling
			AST __t34 = _t;
			GrammarAST tmp9_AST_in = (GrammarAST)_t;
			match(_t,RULE);
			_t = _t.getFirstChild();
			id = (GrammarAST)_t;
			match(_t,ID);
			_t = _t.getNextSibling();
			if ( inputState.guessing==0 ) {
				opts = tmp9_AST_in.options;
			}
			{
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case FRAGMENT:
			case LITERAL_protected:
			case LITERAL_public:
			case LITERAL_private:
			{
				mod=modifier(_t);
				_t = _retTree;
				break;
			}
			case ARG:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
			}
			AST __t36 = _t;
			GrammarAST tmp10_AST_in = (GrammarAST)_t;
			match(_t,ARG);
			_t = _t.getFirstChild();
			{
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case ARG_ACTION:
			{
				args = (GrammarAST)_t;
				match(_t,ARG_ACTION);
				_t = _t.getNextSibling();
				break;
			}
			case 3:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
			}
			_t = __t36;
			_t = _t.getNextSibling();
			AST __t38 = _t;
			GrammarAST tmp11_AST_in = (GrammarAST)_t;
			match(_t,RET);
			_t = _t.getFirstChild();
			{
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case ARG_ACTION:
			{
				ret = (GrammarAST)_t;
				match(_t,ARG_ACTION);
				_t = _t.getNextSibling();
				break;
			}
			case 3:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
			}
			_t = __t38;
			_t = _t.getNextSibling();
			{
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case OPTIONS:
			{
				optionsSpec(_t);
				_t = _retTree;
				break;
			}
			case BLOCK:
			case SCOPE:
			case AMPERSAND:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
			}
			if ( inputState.guessing==0 ) {
				
							name = id.getText();
							currentRuleName = name;
							if ( Character.isUpperCase(name.charAt(0)) &&
								 grammar.type==Grammar.COMBINED )
							{
								// a merged grammar spec, track lexer rules and send to another grammar
								grammar.defineLexerRuleFoundInParser(id.getToken(), rule_AST_in);
							}
							else {
								int numAlts = countAltsForRule(rule_AST_in);
								grammar.defineRule(id.getToken(), mod, opts, rule_AST_in, args, numAlts);
								r = grammar.getRule(name);
								if ( args!=null ) {
									r.parameterScope = grammar.createParameterScope(name,args.token);
									r.parameterScope.addAttributes(args.getText(), ",");
								}
								if ( ret!=null ) {
									r.returnScope = grammar.createReturnScope(name,ret.token);
									r.returnScope.addAttributes(ret.getText(), ",");
								}
							}
							
			}
			{
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case SCOPE:
			{
				ruleScopeSpec(_t,r);
				_t = _retTree;
				break;
			}
			case BLOCK:
			case AMPERSAND:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
			}
			{
			_loop43:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_t.getType()==AMPERSAND)) {
					ruleAction(_t,r);
					_t = _retTree;
				}
				else {
					break _loop43;
				}
				
			} while (true);
			}
			if ( inputState.guessing==0 ) {
				this.blockLevel=0;
			}
			b = _t==ASTNULL ? null : (GrammarAST)_t;
			block(_t);
			_t = _retTree;
			{
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case LITERAL_catch:
			case LITERAL_finally:
			{
				exceptionGroup(_t);
				_t = _retTree;
				break;
			}
			case EOR:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
			}
			GrammarAST tmp12_AST_in = (GrammarAST)_t;
			match(_t,EOR);
			_t = _t.getNextSibling();
			if ( inputState.guessing==0 ) {
				
				// copy rule options into the block AST, which is where
				// the analysis will look for k option etc...
				b.options = opts;
				
			}
			_t = __t34;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final String  modifier(AST _t) throws RecognitionException {
		String mod;
		
		GrammarAST modifier_AST_in = (_t == ASTNULL) ? null : (GrammarAST)_t;
		
		mod = modifier_AST_in.getText();
		
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case LITERAL_protected:
			{
				GrammarAST tmp13_AST_in = (GrammarAST)_t;
				match(_t,LITERAL_protected);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_public:
			{
				GrammarAST tmp14_AST_in = (GrammarAST)_t;
				match(_t,LITERAL_public);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_private:
			{
				GrammarAST tmp15_AST_in = (GrammarAST)_t;
				match(_t,LITERAL_private);
				_t = _t.getNextSibling();
				break;
			}
			case FRAGMENT:
			{
				GrammarAST tmp16_AST_in = (GrammarAST)_t;
				match(_t,FRAGMENT);
				_t = _t.getNextSibling();
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
		return mod;
	}
	
	public final void ruleScopeSpec(AST _t,
		Rule r
	) throws RecognitionException {
		
		GrammarAST ruleScopeSpec_AST_in = (_t == ASTNULL) ? null : (GrammarAST)_t;
		GrammarAST attrs = null;
		GrammarAST uses = null;
		
		try {      // for error handling
			AST __t63 = _t;
			GrammarAST tmp17_AST_in = (GrammarAST)_t;
			match(_t,SCOPE);
			_t = _t.getFirstChild();
			{
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case ACTION:
			{
				attrs = (GrammarAST)_t;
				match(_t,ACTION);
				_t = _t.getNextSibling();
				if ( inputState.guessing==0 ) {
					
						         r.ruleScope = grammar.createRuleScope(r.name,attrs.token);
								 r.ruleScope.isDynamicRuleScope = true;
								 r.ruleScope.addAttributes(attrs.getText(), ";");
								
				}
				break;
			}
			case 3:
			case ID:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
			}
			{
			_loop66:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_t.getType()==ID)) {
					uses = (GrammarAST)_t;
					match(_t,ID);
					_t = _t.getNextSibling();
					if ( inputState.guessing==0 ) {
						
							         if ( grammar.getGlobalScope(uses.getText())==null ) {
										 ErrorManager.grammarError(ErrorManager.MSG_UNKNOWN_DYNAMIC_SCOPE,
																   grammar,
																   uses.token,
																   uses.getText());
							         }
							         else {
							         	if ( r.useScopes==null ) {r.useScopes=new ArrayList();}
							         	r.useScopes.add(uses.getText());
							         }
							
					}
				}
				else {
					break _loop66;
				}
				
			} while (true);
			}
			_t = __t63;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void ruleAction(AST _t,
		Rule r
	) throws RecognitionException {
		
		GrammarAST ruleAction_AST_in = (_t == ASTNULL) ? null : (GrammarAST)_t;
		GrammarAST amp = null;
		GrammarAST id = null;
		GrammarAST a = null;
		
		try {      // for error handling
			AST __t60 = _t;
			amp = _t==ASTNULL ? null :(GrammarAST)_t;
			match(_t,AMPERSAND);
			_t = _t.getFirstChild();
			id = (GrammarAST)_t;
			match(_t,ID);
			_t = _t.getNextSibling();
			a = (GrammarAST)_t;
			match(_t,ACTION);
			_t = _t.getNextSibling();
			_t = __t60;
			_t = _t.getNextSibling();
			if ( inputState.guessing==0 ) {
				if (r!=null) r.defineNamedAction(amp,id,a);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void block(AST _t) throws RecognitionException {
		
		GrammarAST block_AST_in = (_t == ASTNULL) ? null : (GrammarAST)_t;
		
		this.blockLevel++;
		if ( this.blockLevel==1 ) {this.outerAltNum=1;}
		
		
		try {      // for error handling
			AST __t68 = _t;
			GrammarAST tmp18_AST_in = (GrammarAST)_t;
			match(_t,BLOCK);
			_t = _t.getFirstChild();
			{
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case OPTIONS:
			{
				optionsSpec(_t);
				_t = _retTree;
				break;
			}
			case ALT:
			case AMPERSAND:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
			}
			{
			_loop71:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_t.getType()==AMPERSAND)) {
					blockAction(_t);
					_t = _retTree;
				}
				else {
					break _loop71;
				}
				
			} while (true);
			}
			{
			int _cnt73=0;
			_loop73:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_t.getType()==ALT)) {
					alternative(_t);
					_t = _retTree;
					rewrite(_t);
					_t = _retTree;
					if ( inputState.guessing==0 ) {
						if ( this.blockLevel==1 ) {this.outerAltNum++;}
					}
				}
				else {
					if ( _cnt73>=1 ) { break _loop73; } else {throw new NoViableAltException(_t);}
				}
				
				_cnt73++;
			} while (true);
			}
			GrammarAST tmp19_AST_in = (GrammarAST)_t;
			match(_t,EOB);
			_t = _t.getNextSibling();
			_t = __t68;
			_t = _t.getNextSibling();
			if ( inputState.guessing==0 ) {
				this.blockLevel--;
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void exceptionGroup(AST _t) throws RecognitionException {
		
		GrammarAST exceptionGroup_AST_in = (_t == ASTNULL) ? null : (GrammarAST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case LITERAL_catch:
			{
				{
				int _cnt82=0;
				_loop82:
				do {
					if (_t==null) _t=ASTNULL;
					if ((_t.getType()==LITERAL_catch)) {
						exceptionHandler(_t);
						_t = _retTree;
					}
					else {
						if ( _cnt82>=1 ) { break _loop82; } else {throw new NoViableAltException(_t);}
					}
					
					_cnt82++;
				} while (true);
				}
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case LITERAL_finally:
				{
					finallyClause(_t);
					_t = _retTree;
					break;
				}
				case EOR:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
				}
				break;
			}
			case LITERAL_finally:
			{
				finallyClause(_t);
				_t = _retTree;
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final int  countAltsForRule(AST _t) throws RecognitionException {
		int n=0;
		
		GrammarAST countAltsForRule_AST_in = (_t == ASTNULL) ? null : (GrammarAST)_t;
		GrammarAST id = null;
		
		try {      // for error handling
			AST __t46 = _t;
			GrammarAST tmp20_AST_in = (GrammarAST)_t;
			match(_t,RULE);
			_t = _t.getFirstChild();
			id = (GrammarAST)_t;
			match(_t,ID);
			_t = _t.getNextSibling();
			{
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case FRAGMENT:
			case LITERAL_protected:
			case LITERAL_public:
			case LITERAL_private:
			{
				modifier(_t);
				_t = _retTree;
				break;
			}
			case ARG:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
			}
			GrammarAST tmp21_AST_in = (GrammarAST)_t;
			match(_t,ARG);
			_t = _t.getNextSibling();
			GrammarAST tmp22_AST_in = (GrammarAST)_t;
			match(_t,RET);
			_t = _t.getNextSibling();
			{
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case OPTIONS:
			{
				GrammarAST tmp23_AST_in = (GrammarAST)_t;
				match(_t,OPTIONS);
				_t = _t.getNextSibling();
				break;
			}
			case BLOCK:
			case SCOPE:
			case AMPERSAND:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
			}
			{
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case SCOPE:
			{
				GrammarAST tmp24_AST_in = (GrammarAST)_t;
				match(_t,SCOPE);
				_t = _t.getNextSibling();
				break;
			}
			case BLOCK:
			case AMPERSAND:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
			}
			{
			_loop51:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_t.getType()==AMPERSAND)) {
					GrammarAST tmp25_AST_in = (GrammarAST)_t;
					match(_t,AMPERSAND);
					_t = _t.getNextSibling();
				}
				else {
					break _loop51;
				}
				
			} while (true);
			}
			AST __t52 = _t;
			GrammarAST tmp26_AST_in = (GrammarAST)_t;
			match(_t,BLOCK);
			_t = _t.getFirstChild();
			{
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case OPTIONS:
			{
				GrammarAST tmp27_AST_in = (GrammarAST)_t;
				match(_t,OPTIONS);
				_t = _t.getNextSibling();
				break;
			}
			case ALT:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
			}
			{
			int _cnt57=0;
			_loop57:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_t.getType()==ALT)) {
					GrammarAST tmp28_AST_in = (GrammarAST)_t;
					match(_t,ALT);
					_t = _t.getNextSibling();
					{
					_loop56:
					do {
						if (_t==null) _t=ASTNULL;
						if ((_t.getType()==REWRITE)) {
							GrammarAST tmp29_AST_in = (GrammarAST)_t;
							match(_t,REWRITE);
							_t = _t.getNextSibling();
						}
						else {
							break _loop56;
						}
						
					} while (true);
					}
					if ( inputState.guessing==0 ) {
						n++;
					}
				}
				else {
					if ( _cnt57>=1 ) { break _loop57; } else {throw new NoViableAltException(_t);}
				}
				
				_cnt57++;
			} while (true);
			}
			GrammarAST tmp30_AST_in = (GrammarAST)_t;
			match(_t,EOB);
			_t = _t.getNextSibling();
			_t = __t52;
			_t = _t.getNextSibling();
			{
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case LITERAL_catch:
			case LITERAL_finally:
			{
				exceptionGroup(_t);
				_t = _retTree;
				break;
			}
			case EOR:
			{
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
			}
			GrammarAST tmp31_AST_in = (GrammarAST)_t;
			match(_t,EOR);
			_t = _t.getNextSibling();
			_t = __t46;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
		return n;
	}
	
	public final void blockAction(AST _t) throws RecognitionException {
		
		GrammarAST blockAction_AST_in = (_t == ASTNULL) ? null : (GrammarAST)_t;
		GrammarAST amp = null;
		GrammarAST id = null;
		GrammarAST a = null;
		
		try {      // for error handling
			AST __t75 = _t;
			amp = _t==ASTNULL ? null :(GrammarAST)_t;
			match(_t,AMPERSAND);
			_t = _t.getFirstChild();
			id = (GrammarAST)_t;
			match(_t,ID);
			_t = _t.getNextSibling();
			a = (GrammarAST)_t;
			match(_t,ACTION);
			_t = _t.getNextSibling();
			_t = __t75;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void alternative(AST _t) throws RecognitionException {
		
		GrammarAST alternative_AST_in = (_t == ASTNULL) ? null : (GrammarAST)_t;
		
		if ( grammar.type!=Grammar.LEXER && grammar.getOption("output")!=null && blockLevel==1 ) {
			GrammarAST aRewriteNode = alternative_AST_in.findFirstType(REWRITE);
			if ( aRewriteNode!=null||
				 (alternative_AST_in.getNextSibling()!=null &&
				  alternative_AST_in.getNextSibling().getType()==REWRITE) )
			{
				Rule r = grammar.getRule(currentRuleName);
				r.trackAltsWithRewrites(alternative_AST_in,this.outerAltNum);
			}
		}
		
		
		try {      // for error handling
			AST __t77 = _t;
			GrammarAST tmp32_AST_in = (GrammarAST)_t;
			match(_t,ALT);
			_t = _t.getFirstChild();
			{
			int _cnt79=0;
			_loop79:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_t.getType()==BLOCK||_t.getType()==OPTIONAL||_t.getType()==CLOSURE||_t.getType()==POSITIVE_CLOSURE||_t.getType()==SYNPRED||_t.getType()==RANGE||_t.getType()==CHAR_RANGE||_t.getType()==EPSILON||_t.getType()==GATED_SEMPRED||_t.getType()==SYN_SEMPRED||_t.getType()==BACKTRACK_SEMPRED||_t.getType()==ACTION||_t.getType()==ASSIGN||_t.getType()==STRING_LITERAL||_t.getType()==CHAR_LITERAL||_t.getType()==TOKEN_REF||_t.getType()==BANG||_t.getType()==PLUS_ASSIGN||_t.getType()==SEMPRED||_t.getType()==ROOT||_t.getType()==RULE_REF||_t.getType()==NOT||_t.getType()==TREE_BEGIN||_t.getType()==WILDCARD)) {
					element(_t);
					_t = _retTree;
				}
				else {
					if ( _cnt79>=1 ) { break _loop79; } else {throw new NoViableAltException(_t);}
				}
				
				_cnt79++;
			} while (true);
			}
			GrammarAST tmp33_AST_in = (GrammarAST)_t;
			match(_t,EOA);
			_t = _t.getNextSibling();
			_t = __t77;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void rewrite(AST _t) throws RecognitionException {
		
		GrammarAST rewrite_AST_in = (_t == ASTNULL) ? null : (GrammarAST)_t;
		GrammarAST pred = null;
		
		currentRewriteRule = rewrite_AST_in; // has to execute during guessing
		if ( grammar.buildAST() ) {
		rewrite_AST_in.rewriteRefsDeep = new HashSet<GrammarAST>();
		}
		
		
		try {      // for error handling
			{
			_loop124:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_t.getType()==REWRITE)) {
					AST __t122 = _t;
					GrammarAST tmp34_AST_in = (GrammarAST)_t;
					match(_t,REWRITE);
					_t = _t.getFirstChild();
					{
					if (_t==null) _t=ASTNULL;
					switch ( _t.getType()) {
					case SEMPRED:
					{
						pred = (GrammarAST)_t;
						match(_t,SEMPRED);
						_t = _t.getNextSibling();
						break;
					}
					case ALT:
					case TEMPLATE:
					case ACTION:
					{
						break;
					}
					default:
					{
						throw new NoViableAltException(_t);
					}
					}
					}
					rewrite_alternative(_t);
					_t = _retTree;
					_t = __t122;
					_t = _t.getNextSibling();
					if ( inputState.guessing==0 ) {
						
						if ( pred!=null ) {
						pred.outerAltNum = this.outerAltNum;
						trackInlineAction(pred);
						}
						
					}
				}
				else {
					break _loop124;
				}
				
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void element(AST _t) throws RecognitionException {
		
		GrammarAST element_AST_in = (_t == ASTNULL) ? null : (GrammarAST)_t;
		GrammarAST id = null;
		GrammarAST el = null;
		GrammarAST id2 = null;
		GrammarAST a2 = null;
		GrammarAST act = null;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case ROOT:
			{
				AST __t89 = _t;
				GrammarAST tmp35_AST_in = (GrammarAST)_t;
				match(_t,ROOT);
				_t = _t.getFirstChild();
				element(_t);
				_t = _retTree;
				_t = __t89;
				_t = _t.getNextSibling();
				break;
			}
			case BANG:
			{
				AST __t90 = _t;
				GrammarAST tmp36_AST_in = (GrammarAST)_t;
				match(_t,BANG);
				_t = _t.getFirstChild();
				element(_t);
				_t = _retTree;
				_t = __t90;
				_t = _t.getNextSibling();
				break;
			}
			case STRING_LITERAL:
			case CHAR_LITERAL:
			case TOKEN_REF:
			case RULE_REF:
			case WILDCARD:
			{
				atom(_t);
				_t = _retTree;
				break;
			}
			case NOT:
			{
				AST __t91 = _t;
				GrammarAST tmp37_AST_in = (GrammarAST)_t;
				match(_t,NOT);
				_t = _t.getFirstChild();
				element(_t);
				_t = _retTree;
				_t = __t91;
				_t = _t.getNextSibling();
				break;
			}
			case RANGE:
			{
				AST __t92 = _t;
				GrammarAST tmp38_AST_in = (GrammarAST)_t;
				match(_t,RANGE);
				_t = _t.getFirstChild();
				atom(_t);
				_t = _retTree;
				atom(_t);
				_t = _retTree;
				_t = __t92;
				_t = _t.getNextSibling();
				break;
			}
			case CHAR_RANGE:
			{
				AST __t93 = _t;
				GrammarAST tmp39_AST_in = (GrammarAST)_t;
				match(_t,CHAR_RANGE);
				_t = _t.getFirstChild();
				atom(_t);
				_t = _retTree;
				atom(_t);
				_t = _retTree;
				_t = __t93;
				_t = _t.getNextSibling();
				break;
			}
			case ASSIGN:
			{
				AST __t94 = _t;
				GrammarAST tmp40_AST_in = (GrammarAST)_t;
				match(_t,ASSIGN);
				_t = _t.getFirstChild();
				id = (GrammarAST)_t;
				match(_t,ID);
				_t = _t.getNextSibling();
				el = _t==ASTNULL ? null : (GrammarAST)_t;
				element(_t);
				_t = _retTree;
				_t = __t94;
				_t = _t.getNextSibling();
				if ( inputState.guessing==0 ) {
					
							if ( el.getType()==ANTLRParser.ROOT ||
					el.getType()==ANTLRParser.BANG )
							{
					el = (GrammarAST)el.getFirstChild();
					}
						if ( el.getType()==RULE_REF) {
							grammar.defineRuleRefLabel(currentRuleName,id.getToken(),el);
						}
						else {
							grammar.defineTokenRefLabel(currentRuleName,id.getToken(),el);
						}
						
				}
				break;
			}
			case PLUS_ASSIGN:
			{
				AST __t95 = _t;
				GrammarAST tmp41_AST_in = (GrammarAST)_t;
				match(_t,PLUS_ASSIGN);
				_t = _t.getFirstChild();
				id2 = (GrammarAST)_t;
				match(_t,ID);
				_t = _t.getNextSibling();
				a2 = _t==ASTNULL ? null : (GrammarAST)_t;
				element(_t);
				_t = _retTree;
				if ( inputState.guessing==0 ) {
					
					if ( a2.getType()==ANTLRParser.ROOT ||
					a2.getType()==ANTLRParser.BANG )
					{
					a2 = (GrammarAST)a2.getFirstChild();
					}
						    if ( a2.getType()==RULE_REF ) {
						    	grammar.defineRuleListLabel(currentRuleName,id2.getToken(),a2);
						    }
						    else {
						    	grammar.defineTokenListLabel(currentRuleName,id2.getToken(),a2);
						    }
						
				}
				_t = __t95;
				_t = _t.getNextSibling();
				break;
			}
			case BLOCK:
			case OPTIONAL:
			case CLOSURE:
			case POSITIVE_CLOSURE:
			{
				ebnf(_t);
				_t = _retTree;
				break;
			}
			case TREE_BEGIN:
			{
				tree(_t);
				_t = _retTree;
				break;
			}
			case SYNPRED:
			{
				AST __t96 = _t;
				GrammarAST tmp42_AST_in = (GrammarAST)_t;
				match(_t,SYNPRED);
				_t = _t.getFirstChild();
				block(_t);
				_t = _retTree;
				_t = __t96;
				_t = _t.getNextSibling();
				break;
			}
			case ACTION:
			{
				act = (GrammarAST)_t;
				match(_t,ACTION);
				_t = _t.getNextSibling();
				if ( inputState.guessing==0 ) {
					
					act.outerAltNum = this.outerAltNum;
							trackInlineAction(act);
					
				}
				break;
			}
			case SEMPRED:
			{
				GrammarAST tmp43_AST_in = (GrammarAST)_t;
				match(_t,SEMPRED);
				_t = _t.getNextSibling();
				if ( inputState.guessing==0 ) {
					
					tmp43_AST_in.outerAltNum = this.outerAltNum;
					trackInlineAction(tmp43_AST_in);
					
				}
				break;
			}
			case SYN_SEMPRED:
			{
				GrammarAST tmp44_AST_in = (GrammarAST)_t;
				match(_t,SYN_SEMPRED);
				_t = _t.getNextSibling();
				break;
			}
			case BACKTRACK_SEMPRED:
			{
				GrammarAST tmp45_AST_in = (GrammarAST)_t;
				match(_t,BACKTRACK_SEMPRED);
				_t = _t.getNextSibling();
				break;
			}
			case GATED_SEMPRED:
			{
				GrammarAST tmp46_AST_in = (GrammarAST)_t;
				match(_t,GATED_SEMPRED);
				_t = _t.getNextSibling();
				if ( inputState.guessing==0 ) {
					
					tmp46_AST_in.outerAltNum = this.outerAltNum;
					trackInlineAction(tmp46_AST_in);
					
				}
				break;
			}
			case EPSILON:
			{
				GrammarAST tmp47_AST_in = (GrammarAST)_t;
				match(_t,EPSILON);
				_t = _t.getNextSibling();
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void exceptionHandler(AST _t) throws RecognitionException {
		
		GrammarAST exceptionHandler_AST_in = (_t == ASTNULL) ? null : (GrammarAST)_t;
		
		try {      // for error handling
			AST __t85 = _t;
			GrammarAST tmp48_AST_in = (GrammarAST)_t;
			match(_t,LITERAL_catch);
			_t = _t.getFirstChild();
			GrammarAST tmp49_AST_in = (GrammarAST)_t;
			match(_t,ARG_ACTION);
			_t = _t.getNextSibling();
			GrammarAST tmp50_AST_in = (GrammarAST)_t;
			match(_t,ACTION);
			_t = _t.getNextSibling();
			_t = __t85;
			_t = _t.getNextSibling();
			if ( inputState.guessing==0 ) {
				trackInlineAction(tmp50_AST_in);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void finallyClause(AST _t) throws RecognitionException {
		
		GrammarAST finallyClause_AST_in = (_t == ASTNULL) ? null : (GrammarAST)_t;
		
		try {      // for error handling
			AST __t87 = _t;
			GrammarAST tmp51_AST_in = (GrammarAST)_t;
			match(_t,LITERAL_finally);
			_t = _t.getFirstChild();
			GrammarAST tmp52_AST_in = (GrammarAST)_t;
			match(_t,ACTION);
			_t = _t.getNextSibling();
			_t = __t87;
			_t = _t.getNextSibling();
			if ( inputState.guessing==0 ) {
				trackInlineAction(tmp52_AST_in);
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void atom(AST _t) throws RecognitionException {
		
		GrammarAST atom_AST_in = (_t == ASTNULL) ? null : (GrammarAST)_t;
		GrammarAST rr = null;
		GrammarAST rarg = null;
		GrammarAST t = null;
		GrammarAST targ = null;
		GrammarAST c = null;
		GrammarAST s = null;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case RULE_REF:
			{
				AST __t115 = _t;
				rr = _t==ASTNULL ? null :(GrammarAST)_t;
				match(_t,RULE_REF);
				_t = _t.getFirstChild();
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case ARG_ACTION:
				{
					rarg = (GrammarAST)_t;
					match(_t,ARG_ACTION);
					_t = _t.getNextSibling();
					break;
				}
				case 3:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
				}
				_t = __t115;
				_t = _t.getNextSibling();
				if ( inputState.guessing==0 ) {
					
					grammar.altReferencesRule(currentRuleName, rr, this.outerAltNum);
							if ( rarg!=null ) {
					rarg.outerAltNum = this.outerAltNum;
					trackInlineAction(rarg);
					}
					
				}
				break;
			}
			case TOKEN_REF:
			{
				AST __t117 = _t;
				t = _t==ASTNULL ? null :(GrammarAST)_t;
				match(_t,TOKEN_REF);
				_t = _t.getFirstChild();
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case ARG_ACTION:
				{
					targ = (GrammarAST)_t;
					match(_t,ARG_ACTION);
					_t = _t.getNextSibling();
					break;
				}
				case 3:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
				}
				_t = __t117;
				_t = _t.getNextSibling();
				if ( inputState.guessing==0 ) {
					
							if ( targ!=null ) {
					targ.outerAltNum = this.outerAltNum;
					trackInlineAction(targ);
					}
						if ( grammar.type==Grammar.LEXER ) {
							grammar.altReferencesRule(currentRuleName, t, this.outerAltNum);
						}
						else {
							grammar.altReferencesTokenID(currentRuleName, t, this.outerAltNum);
						}
						
				}
				break;
			}
			case CHAR_LITERAL:
			{
				c = (GrammarAST)_t;
				match(_t,CHAR_LITERAL);
				_t = _t.getNextSibling();
				if ( inputState.guessing==0 ) {
					
						if ( grammar.type!=Grammar.LEXER ) {
							Rule rule = grammar.getRule(currentRuleName);
								if ( rule!=null ) {
									rule.trackTokenReferenceInAlt(c, outerAltNum);
							}
						}
						
				}
				break;
			}
			case STRING_LITERAL:
			{
				s = (GrammarAST)_t;
				match(_t,STRING_LITERAL);
				_t = _t.getNextSibling();
				if ( inputState.guessing==0 ) {
					
						if ( grammar.type!=Grammar.LEXER ) {
							Rule rule = grammar.getRule(currentRuleName);
								if ( rule!=null ) {
									rule.trackTokenReferenceInAlt(s, outerAltNum);
							}
						}
						
				}
				break;
			}
			case WILDCARD:
			{
				GrammarAST tmp53_AST_in = (GrammarAST)_t;
				match(_t,WILDCARD);
				_t = _t.getNextSibling();
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void ebnf(AST _t) throws RecognitionException {
		
		GrammarAST ebnf_AST_in = (_t == ASTNULL) ? null : (GrammarAST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case BLOCK:
			{
				block(_t);
				_t = _retTree;
				break;
			}
			case OPTIONAL:
			{
				AST __t100 = _t;
				GrammarAST tmp54_AST_in = (GrammarAST)_t;
				match(_t,OPTIONAL);
				_t = _t.getFirstChild();
				block(_t);
				_t = _retTree;
				_t = __t100;
				_t = _t.getNextSibling();
				break;
			}
			default:
				boolean synPredMatched99 = false;
				if (_t==null) _t=ASTNULL;
				if (((_t.getType()==CLOSURE||_t.getType()==POSITIVE_CLOSURE))) {
					AST __t99 = _t;
					synPredMatched99 = true;
					inputState.guessing++;
					try {
						{
						dotLoop(_t);
						_t = _retTree;
						}
					}
					catch (RecognitionException pe) {
						synPredMatched99 = false;
					}
					_t = __t99;
inputState.guessing--;
				}
				if ( synPredMatched99 ) {
					dotLoop(_t);
					_t = _retTree;
				}
				else if ((_t.getType()==CLOSURE)) {
					AST __t101 = _t;
					GrammarAST tmp55_AST_in = (GrammarAST)_t;
					match(_t,CLOSURE);
					_t = _t.getFirstChild();
					block(_t);
					_t = _retTree;
					_t = __t101;
					_t = _t.getNextSibling();
				}
				else if ((_t.getType()==POSITIVE_CLOSURE)) {
					AST __t102 = _t;
					GrammarAST tmp56_AST_in = (GrammarAST)_t;
					match(_t,POSITIVE_CLOSURE);
					_t = _t.getFirstChild();
					block(_t);
					_t = _retTree;
					_t = __t102;
					_t = _t.getNextSibling();
				}
			else {
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void tree(AST _t) throws RecognitionException {
		
		GrammarAST tree_AST_in = (_t == ASTNULL) ? null : (GrammarAST)_t;
		
		try {      // for error handling
			AST __t111 = _t;
			GrammarAST tmp57_AST_in = (GrammarAST)_t;
			match(_t,TREE_BEGIN);
			_t = _t.getFirstChild();
			element(_t);
			_t = _retTree;
			{
			_loop113:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_t.getType()==BLOCK||_t.getType()==OPTIONAL||_t.getType()==CLOSURE||_t.getType()==POSITIVE_CLOSURE||_t.getType()==SYNPRED||_t.getType()==RANGE||_t.getType()==CHAR_RANGE||_t.getType()==EPSILON||_t.getType()==GATED_SEMPRED||_t.getType()==SYN_SEMPRED||_t.getType()==BACKTRACK_SEMPRED||_t.getType()==ACTION||_t.getType()==ASSIGN||_t.getType()==STRING_LITERAL||_t.getType()==CHAR_LITERAL||_t.getType()==TOKEN_REF||_t.getType()==BANG||_t.getType()==PLUS_ASSIGN||_t.getType()==SEMPRED||_t.getType()==ROOT||_t.getType()==RULE_REF||_t.getType()==NOT||_t.getType()==TREE_BEGIN||_t.getType()==WILDCARD)) {
					element(_t);
					_t = _retTree;
				}
				else {
					break _loop113;
				}
				
			} while (true);
			}
			_t = __t111;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
/** Track the .* and .+ idioms and make them nongreedy by default.
 */
	public final void dotLoop(AST _t) throws RecognitionException {
		
		GrammarAST dotLoop_AST_in = (_t == ASTNULL) ? null : (GrammarAST)_t;
		
		GrammarAST block = (GrammarAST)dotLoop_AST_in.getFirstChild();
		
		
		try {      // for error handling
			{
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case CLOSURE:
			{
				AST __t105 = _t;
				GrammarAST tmp58_AST_in = (GrammarAST)_t;
				match(_t,CLOSURE);
				_t = _t.getFirstChild();
				dotBlock(_t);
				_t = _retTree;
				_t = __t105;
				_t = _t.getNextSibling();
				break;
			}
			case POSITIVE_CLOSURE:
			{
				AST __t106 = _t;
				GrammarAST tmp59_AST_in = (GrammarAST)_t;
				match(_t,POSITIVE_CLOSURE);
				_t = _t.getFirstChild();
				dotBlock(_t);
				_t = _retTree;
				_t = __t106;
				_t = _t.getNextSibling();
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
			}
			if ( inputState.guessing==0 ) {
				
				Map opts=new HashMap();
				opts.put("greedy", "false");
				if ( grammar.type!=Grammar.LEXER ) {
				// parser grammars assume k=1 for .* loops
				// otherwise they (analysis?) look til EOF!
				opts.put("k", Utils.integer(1));
				}
				block.setOptions(grammar,opts);
				
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void dotBlock(AST _t) throws RecognitionException {
		
		GrammarAST dotBlock_AST_in = (_t == ASTNULL) ? null : (GrammarAST)_t;
		
		try {      // for error handling
			AST __t108 = _t;
			GrammarAST tmp60_AST_in = (GrammarAST)_t;
			match(_t,BLOCK);
			_t = _t.getFirstChild();
			AST __t109 = _t;
			GrammarAST tmp61_AST_in = (GrammarAST)_t;
			match(_t,ALT);
			_t = _t.getFirstChild();
			GrammarAST tmp62_AST_in = (GrammarAST)_t;
			match(_t,WILDCARD);
			_t = _t.getNextSibling();
			GrammarAST tmp63_AST_in = (GrammarAST)_t;
			match(_t,EOA);
			_t = _t.getNextSibling();
			_t = __t109;
			_t = _t.getNextSibling();
			GrammarAST tmp64_AST_in = (GrammarAST)_t;
			match(_t,EOB);
			_t = _t.getNextSibling();
			_t = __t108;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void ast_suffix(AST _t) throws RecognitionException {
		
		GrammarAST ast_suffix_AST_in = (_t == ASTNULL) ? null : (GrammarAST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case ROOT:
			{
				GrammarAST tmp65_AST_in = (GrammarAST)_t;
				match(_t,ROOT);
				_t = _t.getNextSibling();
				break;
			}
			case BANG:
			{
				GrammarAST tmp66_AST_in = (GrammarAST)_t;
				match(_t,BANG);
				_t = _t.getNextSibling();
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void rewrite_alternative(AST _t) throws RecognitionException {
		
		GrammarAST rewrite_alternative_AST_in = (_t == ASTNULL) ? null : (GrammarAST)_t;
		GrammarAST a = null;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			if (((_t.getType()==ALT))&&(grammar.buildAST())) {
				AST __t128 = _t;
				a = _t==ASTNULL ? null :(GrammarAST)_t;
				match(_t,ALT);
				_t = _t.getFirstChild();
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case OPTIONAL:
				case CLOSURE:
				case POSITIVE_CLOSURE:
				case LABEL:
				case ACTION:
				case STRING_LITERAL:
				case CHAR_LITERAL:
				case TOKEN_REF:
				case RULE_REF:
				case TREE_BEGIN:
				{
					{
					int _cnt131=0;
					_loop131:
					do {
						if (_t==null) _t=ASTNULL;
						if ((_t.getType()==OPTIONAL||_t.getType()==CLOSURE||_t.getType()==POSITIVE_CLOSURE||_t.getType()==LABEL||_t.getType()==ACTION||_t.getType()==STRING_LITERAL||_t.getType()==CHAR_LITERAL||_t.getType()==TOKEN_REF||_t.getType()==RULE_REF||_t.getType()==TREE_BEGIN)) {
							rewrite_element(_t);
							_t = _retTree;
						}
						else {
							if ( _cnt131>=1 ) { break _loop131; } else {throw new NoViableAltException(_t);}
						}
						
						_cnt131++;
					} while (true);
					}
					break;
				}
				case EPSILON:
				{
					GrammarAST tmp67_AST_in = (GrammarAST)_t;
					match(_t,EPSILON);
					_t = _t.getNextSibling();
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
				}
				GrammarAST tmp68_AST_in = (GrammarAST)_t;
				match(_t,EOA);
				_t = _t.getNextSibling();
				_t = __t128;
				_t = _t.getNextSibling();
			}
			else if (((_t.getType()==ALT||_t.getType()==TEMPLATE||_t.getType()==ACTION))&&(grammar.buildTemplate())) {
				rewrite_template(_t);
				_t = _retTree;
			}
			else {
				throw new NoViableAltException(_t);
			}
			
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void rewrite_block(AST _t) throws RecognitionException {
		
		GrammarAST rewrite_block_AST_in = (_t == ASTNULL) ? null : (GrammarAST)_t;
		
		GrammarAST enclosingBlock = currentRewriteBlock;
		if ( inputState.guessing==0 ) {  // don't do if guessing
		currentRewriteBlock=rewrite_block_AST_in; // pts to BLOCK node
		currentRewriteBlock.rewriteRefsShallow = new HashSet<GrammarAST>();
		currentRewriteBlock.rewriteRefsDeep = new HashSet<GrammarAST>();
		}
		
		
		try {      // for error handling
			AST __t126 = _t;
			GrammarAST tmp69_AST_in = (GrammarAST)_t;
			match(_t,BLOCK);
			_t = _t.getFirstChild();
			rewrite_alternative(_t);
			_t = _retTree;
			GrammarAST tmp70_AST_in = (GrammarAST)_t;
			match(_t,EOB);
			_t = _t.getNextSibling();
			_t = __t126;
			_t = _t.getNextSibling();
			if ( inputState.guessing==0 ) {
				
				// copy the element refs in this block to the surrounding block
				if ( enclosingBlock!=null ) {
				enclosingBlock.rewriteRefsDeep
				.addAll(currentRewriteBlock.rewriteRefsShallow);
				}
				currentRewriteBlock = enclosingBlock; // restore old BLOCK ptr
				
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void rewrite_element(AST _t) throws RecognitionException {
		
		GrammarAST rewrite_element_AST_in = (_t == ASTNULL) ? null : (GrammarAST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case LABEL:
			case ACTION:
			case STRING_LITERAL:
			case CHAR_LITERAL:
			case TOKEN_REF:
			case RULE_REF:
			{
				rewrite_atom(_t);
				_t = _retTree;
				break;
			}
			case OPTIONAL:
			case CLOSURE:
			case POSITIVE_CLOSURE:
			{
				rewrite_ebnf(_t);
				_t = _retTree;
				break;
			}
			case TREE_BEGIN:
			{
				rewrite_tree(_t);
				_t = _retTree;
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void rewrite_template(AST _t) throws RecognitionException {
		
		GrammarAST rewrite_template_AST_in = (_t == ASTNULL) ? null : (GrammarAST)_t;
		GrammarAST id = null;
		GrammarAST ind = null;
		GrammarAST arg = null;
		GrammarAST a = null;
		GrammarAST act = null;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case ALT:
			{
				AST __t146 = _t;
				GrammarAST tmp71_AST_in = (GrammarAST)_t;
				match(_t,ALT);
				_t = _t.getFirstChild();
				GrammarAST tmp72_AST_in = (GrammarAST)_t;
				match(_t,EPSILON);
				_t = _t.getNextSibling();
				GrammarAST tmp73_AST_in = (GrammarAST)_t;
				match(_t,EOA);
				_t = _t.getNextSibling();
				_t = __t146;
				_t = _t.getNextSibling();
				break;
			}
			case TEMPLATE:
			{
				AST __t147 = _t;
				GrammarAST tmp74_AST_in = (GrammarAST)_t;
				match(_t,TEMPLATE);
				_t = _t.getFirstChild();
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case ID:
				{
					id = (GrammarAST)_t;
					match(_t,ID);
					_t = _t.getNextSibling();
					break;
				}
				case ACTION:
				{
					ind = (GrammarAST)_t;
					match(_t,ACTION);
					_t = _t.getNextSibling();
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
				}
				AST __t149 = _t;
				GrammarAST tmp75_AST_in = (GrammarAST)_t;
				match(_t,ARGLIST);
				_t = _t.getFirstChild();
				{
				_loop152:
				do {
					if (_t==null) _t=ASTNULL;
					if ((_t.getType()==ARG)) {
						AST __t151 = _t;
						GrammarAST tmp76_AST_in = (GrammarAST)_t;
						match(_t,ARG);
						_t = _t.getFirstChild();
						arg = (GrammarAST)_t;
						match(_t,ID);
						_t = _t.getNextSibling();
						a = (GrammarAST)_t;
						match(_t,ACTION);
						_t = _t.getNextSibling();
						_t = __t151;
						_t = _t.getNextSibling();
						if ( inputState.guessing==0 ) {
							
							a.outerAltNum = this.outerAltNum;
							trackInlineAction(a);
							
						}
					}
					else {
						break _loop152;
					}
					
				} while (true);
				}
				_t = __t149;
				_t = _t.getNextSibling();
				if ( inputState.guessing==0 ) {
					
					if ( ind!=null ) {
					ind.outerAltNum = this.outerAltNum;
					trackInlineAction(ind);
					}
					
				}
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case DOUBLE_QUOTE_STRING_LITERAL:
				{
					GrammarAST tmp77_AST_in = (GrammarAST)_t;
					match(_t,DOUBLE_QUOTE_STRING_LITERAL);
					_t = _t.getNextSibling();
					break;
				}
				case DOUBLE_ANGLE_STRING_LITERAL:
				{
					GrammarAST tmp78_AST_in = (GrammarAST)_t;
					match(_t,DOUBLE_ANGLE_STRING_LITERAL);
					_t = _t.getNextSibling();
					break;
				}
				case 3:
				{
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
				}
				_t = __t147;
				_t = _t.getNextSibling();
				break;
			}
			case ACTION:
			{
				act = (GrammarAST)_t;
				match(_t,ACTION);
				_t = _t.getNextSibling();
				if ( inputState.guessing==0 ) {
					
					act.outerAltNum = this.outerAltNum;
					trackInlineAction(act);
					
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void rewrite_atom(AST _t) throws RecognitionException {
		
		GrammarAST rewrite_atom_AST_in = (_t == ASTNULL) ? null : (GrammarAST)_t;
		GrammarAST arg = null;
		
		Rule r = grammar.getRule(currentRuleName);
		Set tokenRefsInAlt = r.getTokenRefsInAlt(outerAltNum);
		boolean imaginary =
		rewrite_atom_AST_in.getType()==TOKEN_REF &&
		!tokenRefsInAlt.contains(rewrite_atom_AST_in.getText());
		if ( !imaginary && grammar.buildAST() &&
		(rewrite_atom_AST_in.getType()==RULE_REF ||
		rewrite_atom_AST_in.getType()==LABEL ||
		rewrite_atom_AST_in.getType()==TOKEN_REF ||
		rewrite_atom_AST_in.getType()==CHAR_LITERAL ||
		rewrite_atom_AST_in.getType()==STRING_LITERAL) )
		{
		// track per block and for entire rewrite rule
		if ( currentRewriteBlock!=null ) {
		currentRewriteBlock.rewriteRefsShallow.add(rewrite_atom_AST_in);
		currentRewriteBlock.rewriteRefsDeep.add(rewrite_atom_AST_in);
		}
		currentRewriteRule.rewriteRefsDeep.add(rewrite_atom_AST_in);
		}
		
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case RULE_REF:
			{
				GrammarAST tmp79_AST_in = (GrammarAST)_t;
				match(_t,RULE_REF);
				_t = _t.getNextSibling();
				break;
			}
			case STRING_LITERAL:
			case CHAR_LITERAL:
			case TOKEN_REF:
			{
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case TOKEN_REF:
				{
					AST __t143 = _t;
					GrammarAST tmp80_AST_in = (GrammarAST)_t;
					match(_t,TOKEN_REF);
					_t = _t.getFirstChild();
					{
					if (_t==null) _t=ASTNULL;
					switch ( _t.getType()) {
					case ARG_ACTION:
					{
						arg = (GrammarAST)_t;
						match(_t,ARG_ACTION);
						_t = _t.getNextSibling();
						break;
					}
					case 3:
					{
						break;
					}
					default:
					{
						throw new NoViableAltException(_t);
					}
					}
					}
					_t = __t143;
					_t = _t.getNextSibling();
					break;
				}
				case CHAR_LITERAL:
				{
					GrammarAST tmp81_AST_in = (GrammarAST)_t;
					match(_t,CHAR_LITERAL);
					_t = _t.getNextSibling();
					break;
				}
				case STRING_LITERAL:
				{
					GrammarAST tmp82_AST_in = (GrammarAST)_t;
					match(_t,STRING_LITERAL);
					_t = _t.getNextSibling();
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
				}
				if ( inputState.guessing==0 ) {
					
					if ( arg!=null ) {
					arg.outerAltNum = this.outerAltNum;
					trackInlineAction(arg);
					}
					
				}
				break;
			}
			case LABEL:
			{
				GrammarAST tmp83_AST_in = (GrammarAST)_t;
				match(_t,LABEL);
				_t = _t.getNextSibling();
				break;
			}
			case ACTION:
			{
				GrammarAST tmp84_AST_in = (GrammarAST)_t;
				match(_t,ACTION);
				_t = _t.getNextSibling();
				if ( inputState.guessing==0 ) {
					
					tmp84_AST_in.outerAltNum = this.outerAltNum;
					trackInlineAction(tmp84_AST_in);
					
				}
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void rewrite_ebnf(AST _t) throws RecognitionException {
		
		GrammarAST rewrite_ebnf_AST_in = (_t == ASTNULL) ? null : (GrammarAST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case OPTIONAL:
			{
				AST __t134 = _t;
				GrammarAST tmp85_AST_in = (GrammarAST)_t;
				match(_t,OPTIONAL);
				_t = _t.getFirstChild();
				rewrite_block(_t);
				_t = _retTree;
				_t = __t134;
				_t = _t.getNextSibling();
				break;
			}
			case CLOSURE:
			{
				AST __t135 = _t;
				GrammarAST tmp86_AST_in = (GrammarAST)_t;
				match(_t,CLOSURE);
				_t = _t.getFirstChild();
				rewrite_block(_t);
				_t = _retTree;
				_t = __t135;
				_t = _t.getNextSibling();
				break;
			}
			case POSITIVE_CLOSURE:
			{
				AST __t136 = _t;
				GrammarAST tmp87_AST_in = (GrammarAST)_t;
				match(_t,POSITIVE_CLOSURE);
				_t = _t.getFirstChild();
				rewrite_block(_t);
				_t = _retTree;
				_t = __t136;
				_t = _t.getNextSibling();
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	public final void rewrite_tree(AST _t) throws RecognitionException {
		
		GrammarAST rewrite_tree_AST_in = (_t == ASTNULL) ? null : (GrammarAST)_t;
		
		try {      // for error handling
			AST __t138 = _t;
			GrammarAST tmp88_AST_in = (GrammarAST)_t;
			match(_t,TREE_BEGIN);
			_t = _t.getFirstChild();
			rewrite_atom(_t);
			_t = _retTree;
			{
			_loop140:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_t.getType()==OPTIONAL||_t.getType()==CLOSURE||_t.getType()==POSITIVE_CLOSURE||_t.getType()==LABEL||_t.getType()==ACTION||_t.getType()==STRING_LITERAL||_t.getType()==CHAR_LITERAL||_t.getType()==TOKEN_REF||_t.getType()==RULE_REF||_t.getType()==TREE_BEGIN)) {
					rewrite_element(_t);
					_t = _retTree;
				}
				else {
					break _loop140;
				}
				
			} while (true);
			}
			_t = __t138;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			if (inputState.guessing==0) {
				reportError(ex);
				if (_t!=null) {_t = _t.getNextSibling();}
			} else {
			  throw ex;
			}
		}
		_retTree = _t;
	}
	
	
	public static final String[] _tokenNames = {
		"<0>",
		"EOF",
		"<2>",
		"NULL_TREE_LOOKAHEAD",
		"\"options\"",
		"\"tokens\"",
		"\"parser\"",
		"LEXER",
		"RULE",
		"BLOCK",
		"OPTIONAL",
		"CLOSURE",
		"POSITIVE_CLOSURE",
		"SYNPRED",
		"RANGE",
		"CHAR_RANGE",
		"EPSILON",
		"ALT",
		"EOR",
		"EOB",
		"EOA",
		"ID",
		"ARG",
		"ARGLIST",
		"RET",
		"LEXER_GRAMMAR",
		"PARSER_GRAMMAR",
		"TREE_GRAMMAR",
		"COMBINED_GRAMMAR",
		"INITACTION",
		"LABEL",
		"TEMPLATE",
		"\"scope\"",
		"GATED_SEMPRED",
		"SYN_SEMPRED",
		"BACKTRACK_SEMPRED",
		"\"fragment\"",
		"ACTION",
		"DOC_COMMENT",
		"SEMI",
		"\"lexer\"",
		"\"tree\"",
		"\"grammar\"",
		"AMPERSAND",
		"COLON",
		"RCURLY",
		"ASSIGN",
		"STRING_LITERAL",
		"CHAR_LITERAL",
		"INT",
		"STAR",
		"TOKEN_REF",
		"\"protected\"",
		"\"public\"",
		"\"private\"",
		"BANG",
		"ARG_ACTION",
		"\"returns\"",
		"\"throws\"",
		"COMMA",
		"LPAREN",
		"OR",
		"RPAREN",
		"\"catch\"",
		"\"finally\"",
		"PLUS_ASSIGN",
		"SEMPRED",
		"IMPLIES",
		"ROOT",
		"RULE_REF",
		"NOT",
		"TREE_BEGIN",
		"QUESTION",
		"PLUS",
		"WILDCARD",
		"REWRITE",
		"DOLLAR",
		"DOUBLE_QUOTE_STRING_LITERAL",
		"DOUBLE_ANGLE_STRING_LITERAL",
		"WS",
		"COMMENT",
		"SL_COMMENT",
		"ML_COMMENT",
		"OPEN_ELEMENT_OPTION",
		"CLOSE_ELEMENT_OPTION",
		"ESC",
		"DIGIT",
		"XDIGIT",
		"NESTED_ARG_ACTION",
		"NESTED_ACTION",
		"ACTION_CHAR_LITERAL",
		"ACTION_STRING_LITERAL",
		"ACTION_ESC",
		"WS_LOOP",
		"INTERNAL_RULE_REF",
		"WS_OPT",
		"SRC"
	};
	
	}
	
