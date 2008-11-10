// $ANTLR 2.7.7 (2006-01-29): "codegen.g" -> "CodeGenTreeWalker.java"$

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
	package org.antlr.codegen;
    import org.antlr.tool.*;
    import org.antlr.analysis.*;
    import org.antlr.misc.*;
	import java.util.*;
	import org.antlr.stringtemplate.*;
    import antlr.TokenWithIndex;
    import antlr.CommonToken;

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


/** Walk a grammar and generate code by gradually building up
 *  a bigger and bigger StringTemplate.
 *
 *  Terence Parr
 *  University of San Francisco
 *  June 15, 2004
 */
public class CodeGenTreeWalker extends antlr.TreeParser       implements CodeGenTreeWalkerTokenTypes
 {

	protected static final int RULE_BLOCK_NESTING_LEVEL = 0;
	protected static final int OUTER_REWRITE_NESTING_LEVEL = 0;

    protected String currentRuleName = null;
    protected int blockNestingLevel = 0;
    protected int rewriteBlockNestingLevel = 0;
	protected int outerAltNum = 0;
    protected StringTemplate currentBlockST = null;
    protected boolean currentAltHasASTRewrite = false;
    protected int rewriteTreeNestingLevel = 0;
    protected Set rewriteRuleRefs = null;

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
            "codegen: "+ex.toString(),
            ex);
    }

    public void reportError(String s) {
        System.out.println("codegen: error: " + s);
    }

    protected CodeGenerator generator;
    protected Grammar grammar;
    protected StringTemplateGroup templates;

    /** The overall lexer/parser template; simulate dynamically scoped
     *  attributes by making this an instance var of the walker.
     */
    protected StringTemplate recognizerST;

    protected StringTemplate outputFileST;
    protected StringTemplate headerFileST;

    protected String outputOption = "";

	protected StringTemplate getWildcardST(GrammarAST elementAST, GrammarAST ast_suffix, String label) {
		String name = "wildcard";
		if ( grammar.type==Grammar.LEXER ) {
			name = "wildcardChar";
		}
		return getTokenElementST(name, name, elementAST, ast_suffix, label);
	}

	protected StringTemplate getRuleElementST(String name,
										      String elementName,
											  GrammarAST elementAST,
    										  GrammarAST ast_suffix,
    										  String label)
	{
		String suffix = getSTSuffix(ast_suffix,label);
		name += suffix;
		// if we're building trees and there is no label, gen a label
		// unless we're in a synpred rule.
		Rule r = grammar.getRule(currentRuleName);
		if ( (grammar.buildAST()||suffix.length()>0) && label==null &&
		     (r==null || !r.isSynPred) )
		{
			// we will need a label to do the AST or tracking, make one
			label = generator.createUniqueLabel(elementName);
			CommonToken labelTok = new CommonToken(ANTLRParser.ID, label);
			grammar.defineRuleRefLabel(currentRuleName, labelTok, elementAST);
		}
		StringTemplate elementST = templates.getInstanceOf(name);
		if ( label!=null ) {
			elementST.setAttribute("label", label);
		}
		return elementST;
	}

	protected StringTemplate getTokenElementST(String name,
											   String elementName,
											   GrammarAST elementAST,
											   GrammarAST ast_suffix,
											   String label)
	{
		String suffix = getSTSuffix(ast_suffix,label);
		name += suffix;
		// if we're building trees and there is no label, gen a label
		// unless we're in a synpred rule.
		Rule r = grammar.getRule(currentRuleName);
		if ( (grammar.buildAST()||suffix.length()>0) && label==null &&
		     (r==null || !r.isSynPred) )
		{
			label = generator.createUniqueLabel(elementName);
			CommonToken labelTok = new CommonToken(ANTLRParser.ID, label);
			grammar.defineTokenRefLabel(currentRuleName, labelTok, elementAST);
		}
		StringTemplate elementST = templates.getInstanceOf(name);
		if ( label!=null ) {
			elementST.setAttribute("label", label);
		}
		return elementST;
	}

    public boolean isListLabel(String label) {
		boolean hasListLabel=false;
		if ( label!=null ) {
			Rule r = grammar.getRule(currentRuleName);
			String stName = null;
			if ( r!=null ) {
				Grammar.LabelElementPair pair = r.getLabel(label);
				if ( pair!=null &&
					 (pair.type==Grammar.TOKEN_LIST_LABEL||
					  pair.type==Grammar.RULE_LIST_LABEL) )
				{
					hasListLabel=true;
				}
			}
		}
        return hasListLabel;
    }

	/** Return a non-empty template name suffix if the token is to be
	 *  tracked, added to a tree, or both.
	 */
	protected String getSTSuffix(GrammarAST ast_suffix, String label) {
		if ( grammar.type==Grammar.LEXER ) {
			return "";
		}
		// handle list label stuff; make element use "Track"

		String astPart = "";
		String operatorPart = "";
		String rewritePart = "";
		String listLabelPart = "";
		if ( grammar.buildAST() ) {
			astPart = "AST";
		}
		if ( ast_suffix!=null ) {
			if ( ast_suffix.getType()==ANTLRParser.ROOT ) {
    			operatorPart = "RuleRoot";
    		}
    		else if ( ast_suffix.getType()==ANTLRParser.BANG ) {
    			operatorPart = "Bang";
    		}
   		}
		if ( currentAltHasASTRewrite ) {
			rewritePart = "Track";
		}
		if ( isListLabel(label) ) {
			listLabelPart = "AndListLabel";
		}
		String STsuffix = operatorPart+rewritePart+listLabelPart;
		//System.out.println("suffix = "+STsuffix);

    	return STsuffix;
	}

    /** Convert rewrite AST lists to target labels list */
    protected List<String> getTokenTypesAsTargetLabels(Set<GrammarAST> refs) {
        if ( refs==null || refs.size()==0 ) {
            return null;
        }
        List<String> labels = new ArrayList<String>(refs.size());
        for (GrammarAST t : refs) {
            String label;
            if ( t.getType()==ANTLRParser.RULE_REF ) {
                label = t.getText();
            }
            else if ( t.getType()==ANTLRParser.LABEL ) {
                label = t.getText();
            }
            else {
                // must be char or string literal
                label = generator.getTokenTypeAsTargetLabel(
                            grammar.getTokenType(t.getText()));
            }
            labels.add(label);
        }
        return labels;
    }

    protected void init(Grammar g) {
        this.grammar = g;
        this.generator = grammar.getCodeGenerator();
        this.templates = generator.getTemplates();
    }
public CodeGenTreeWalker() {
	tokenNames = _tokenNames;
}

	public final void grammar(AST _t,
		Grammar g,
        StringTemplate recognizerST,
        StringTemplate outputFileST,
        StringTemplate headerFileST
	) throws RecognitionException {
		
		GrammarAST grammar_AST_in = (_t == ASTNULL) ? null : (GrammarAST)_t;
		
		init(g);
		this.recognizerST = recognizerST;
		this.outputFileST = outputFileST;
		this.headerFileST = headerFileST;
		String superClass = (String)g.getOption("superClass");
		outputOption = (String)g.getOption("output");
		recognizerST.setAttribute("superClass", superClass);
		if ( g.type!=Grammar.LEXER ) {
				recognizerST.setAttribute("ASTLabelType", g.getOption("ASTLabelType"));
			}
		if ( g.type==Grammar.TREE_PARSER && g.getOption("ASTLabelType")==null ) {
				ErrorManager.grammarWarning(ErrorManager.MSG_MISSING_AST_TYPE_IN_TREE_GRAMMAR,
										   g,
										   null,
										   g.name);
			}
		if ( g.type!=Grammar.TREE_PARSER ) {
				recognizerST.setAttribute("labelType", g.getOption("TokenLabelType"));
			}
			recognizerST.setAttribute("numRules", grammar.getRules().size());
			outputFileST.setAttribute("numRules", grammar.getRules().size());
			headerFileST.setAttribute("numRules", grammar.getRules().size());
		
		
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
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void grammarSpec(AST _t) throws RecognitionException {
		
		GrammarAST grammarSpec_AST_in = (_t == ASTNULL) ? null : (GrammarAST)_t;
		GrammarAST name = null;
		GrammarAST cmt = null;
		
		try {      // for error handling
			name = (GrammarAST)_t;
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
				
						 outputFileST.setAttribute("docComment", cmt.getText());
						 headerFileST.setAttribute("docComment", cmt.getText());
						
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
			
					String suffix = Grammar.grammarTypeToFileNameSuffix[grammar.type];
			String n = name.getText()+suffix;
					recognizerST.setAttribute("name", n);
					outputFileST.setAttribute("name", n);
					headerFileST.setAttribute("name", n);
					recognizerST.setAttribute("scopes", grammar.getGlobalScopes());
					headerFileST.setAttribute("scopes", grammar.getGlobalScopes());
					
			{
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case OPTIONS:
			{
				AST __t12 = _t;
				GrammarAST tmp5_AST_in = (GrammarAST)_t;
				match(_t,OPTIONS);
				_t = _t.getFirstChild();
				GrammarAST tmp6_AST_in = (GrammarAST)_t;
				if ( _t==null ) throw new MismatchedTokenException();
				_t = _t.getNextSibling();
				_t = __t12;
				_t = _t.getNextSibling();
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
				AST __t14 = _t;
				GrammarAST tmp7_AST_in = (GrammarAST)_t;
				match(_t,TOKENS);
				_t = _t.getFirstChild();
				GrammarAST tmp8_AST_in = (GrammarAST)_t;
				if ( _t==null ) throw new MismatchedTokenException();
				_t = _t.getNextSibling();
				_t = __t14;
				_t = _t.getNextSibling();
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
			_loop16:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_t.getType()==SCOPE)) {
					attrScope(_t);
					_t = _retTree;
				}
				else {
					break _loop16;
				}
				
			} while (true);
			}
			{
			_loop18:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_t.getType()==AMPERSAND)) {
					GrammarAST tmp9_AST_in = (GrammarAST)_t;
					match(_t,AMPERSAND);
					_t = _t.getNextSibling();
				}
				else {
					break _loop18;
				}
				
			} while (true);
			}
			rules(_t,recognizerST);
			_t = _retTree;
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void attrScope(AST _t) throws RecognitionException {
		
		GrammarAST attrScope_AST_in = (_t == ASTNULL) ? null : (GrammarAST)_t;
		
		try {      // for error handling
			AST __t8 = _t;
			GrammarAST tmp10_AST_in = (GrammarAST)_t;
			match(_t,SCOPE);
			_t = _t.getFirstChild();
			GrammarAST tmp11_AST_in = (GrammarAST)_t;
			match(_t,ID);
			_t = _t.getNextSibling();
			GrammarAST tmp12_AST_in = (GrammarAST)_t;
			match(_t,ACTION);
			_t = _t.getNextSibling();
			_t = __t8;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void rules(AST _t,
		StringTemplate recognizerST
	) throws RecognitionException {
		
		GrammarAST rules_AST_in = (_t == ASTNULL) ? null : (GrammarAST)_t;
		
		StringTemplate rST;
		
		
		try {      // for error handling
			{
			int _cnt22=0;
			_loop22:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_t.getType()==RULE)) {
					{
					
								String ruleName = _t.getFirstChild().getText();
								Rule r = grammar.getRule(ruleName);
								
					if (_t==null) _t=ASTNULL;
					if (((_t.getType()==RULE))&&(!r.isSynPred || grammar.synPredNamesUsedInDFA.contains(ruleName))) {
						rST=rule(_t);
						_t = _retTree;
						
										if ( rST!=null ) {
											recognizerST.setAttribute("rules", rST);
											outputFileST.setAttribute("rules", rST);
											headerFileST.setAttribute("rules", rST);
										}
										
					}
					else if ((_t.getType()==RULE)) {
						GrammarAST tmp13_AST_in = (GrammarAST)_t;
						match(_t,RULE);
						_t = _t.getNextSibling();
					}
					else {
						throw new NoViableAltException(_t);
					}
					
					}
				}
				else {
					if ( _cnt22>=1 ) { break _loop22; } else {throw new NoViableAltException(_t);}
				}
				
				_cnt22++;
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final StringTemplate  rule(AST _t) throws RecognitionException {
		StringTemplate code=null;
		
		GrammarAST rule_AST_in = (_t == ASTNULL) ? null : (GrammarAST)_t;
		GrammarAST id = null;
		GrammarAST mod = null;
		
		String r;
		String initAction = null;
		StringTemplate b;
			// get the dfa for the BLOCK
		GrammarAST block=rule_AST_in.getFirstChildWithType(BLOCK);
		DFA dfa=block.getLookaheadDFA();
			// init blockNestingLevel so it's block level RULE_BLOCK_NESTING_LEVEL
			// for alts of rule
			blockNestingLevel = RULE_BLOCK_NESTING_LEVEL-1;
			Rule ruleDescr = grammar.getRule(rule_AST_in.getFirstChild().getText());
		
			// For syn preds, we don't want any AST code etc... in there.
			// Save old templates ptr and restore later.  Base templates include Dbg.
			StringTemplateGroup saveGroup = templates;
			if ( ruleDescr.isSynPred ) {
				templates = generator.getBaseTemplates();
			}
		
		
		try {      // for error handling
			AST __t24 = _t;
			GrammarAST tmp14_AST_in = (GrammarAST)_t;
			match(_t,RULE);
			_t = _t.getFirstChild();
			id = (GrammarAST)_t;
			match(_t,ID);
			_t = _t.getNextSibling();
			r=id.getText(); currentRuleName = r;
			{
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case FRAGMENT:
			case LITERAL_protected:
			case LITERAL_public:
			case LITERAL_private:
			{
				mod = _t==ASTNULL ? null : (GrammarAST)_t;
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
			AST __t26 = _t;
			GrammarAST tmp15_AST_in = (GrammarAST)_t;
			match(_t,ARG);
			_t = _t.getFirstChild();
			{
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case ARG_ACTION:
			{
				GrammarAST tmp16_AST_in = (GrammarAST)_t;
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
			_t = __t26;
			_t = _t.getNextSibling();
			AST __t28 = _t;
			GrammarAST tmp17_AST_in = (GrammarAST)_t;
			match(_t,RET);
			_t = _t.getFirstChild();
			{
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case ARG_ACTION:
			{
				GrammarAST tmp18_AST_in = (GrammarAST)_t;
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
			_t = __t28;
			_t = _t.getNextSibling();
			{
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case OPTIONS:
			{
				AST __t31 = _t;
				GrammarAST tmp19_AST_in = (GrammarAST)_t;
				match(_t,OPTIONS);
				_t = _t.getFirstChild();
				GrammarAST tmp20_AST_in = (GrammarAST)_t;
				if ( _t==null ) throw new MismatchedTokenException();
				_t = _t.getNextSibling();
				_t = __t31;
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
				ruleScopeSpec(_t);
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
			_loop34:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_t.getType()==AMPERSAND)) {
					GrammarAST tmp21_AST_in = (GrammarAST)_t;
					match(_t,AMPERSAND);
					_t = _t.getNextSibling();
				}
				else {
					break _loop34;
				}
				
			} while (true);
			}
			b=block(_t,"ruleBlock", dfa);
			_t = _retTree;
			
						String description =
							grammar.grammarTreeToString(rule_AST_in.getFirstChildWithType(BLOCK),
			false);
						description =
			generator.target.getTargetStringLiteralFromString(description);
						b.setAttribute("description", description);
						// do not generate lexer rules in combined grammar
						String stName = null;
						if ( ruleDescr.isSynPred ) {
							stName = "synpredRule";
						}
						else if ( grammar.type==Grammar.LEXER ) {
							if ( r.equals(Grammar.ARTIFICIAL_TOKENS_RULENAME) ) {
								stName = "tokensRule";
							}
							else {
								stName = "lexerRule";
							}
						}
						else {
							if ( !(grammar.type==Grammar.COMBINED &&
								 Character.isUpperCase(r.charAt(0))) )
							{
								stName = "rule";
							}
						}
						code = templates.getInstanceOf(stName);
						if ( code.getName().equals("rule") ) {
							code.setAttribute("emptyRule",
								Boolean.valueOf(grammar.isEmptyRule(block)));
						}
						code.setAttribute("ruleDescriptor", ruleDescr);
						String memo = (String)rule_AST_in.getOption("memoize");
						if ( memo==null ) {
							memo = (String)grammar.getOption("memoize");
						}
						if ( memo!=null && memo.equals("true") &&
						     (stName.equals("rule")||stName.equals("lexerRule")) )
						{
				code.setAttribute("memoize",
					Boolean.valueOf(memo!=null && memo.equals("true")));
			}
						
			{
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case LITERAL_catch:
			case LITERAL_finally:
			{
				exceptionGroup(_t,code);
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
			GrammarAST tmp22_AST_in = (GrammarAST)_t;
			match(_t,EOR);
			_t = _t.getNextSibling();
			_t = __t24;
			_t = _t.getNextSibling();
			
			if ( code!=null ) {
						if ( grammar.type==Grammar.LEXER ) {
					    	boolean naked =
					    		r.equals(Grammar.ARTIFICIAL_TOKENS_RULENAME) ||
					    	    (mod!=null&&mod.getText().equals(Grammar.FRAGMENT_RULE_MODIFIER));
					    	code.setAttribute("nakedBlock", Boolean.valueOf(naked));
						}
						else {
							description =
								grammar.grammarTreeToString(rule_AST_in,false);
							description =
							    generator.target.getTargetStringLiteralFromString(description);
							code.setAttribute("description", description);
						}
						Rule theRule = grammar.getRule(r);
						generator.translateActionAttributeReferencesForSingleScope(
							theRule,
							theRule.getActions()
						);
						code.setAttribute("ruleName", r);
						code.setAttribute("block", b);
						if ( initAction!=null ) {
							code.setAttribute("initAction", initAction);
						}
			}
					templates = saveGroup;
			
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
		return code;
	}
	
	public final void modifier(AST _t) throws RecognitionException {
		
		GrammarAST modifier_AST_in = (_t == ASTNULL) ? null : (GrammarAST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case LITERAL_protected:
			{
				GrammarAST tmp23_AST_in = (GrammarAST)_t;
				match(_t,LITERAL_protected);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_public:
			{
				GrammarAST tmp24_AST_in = (GrammarAST)_t;
				match(_t,LITERAL_public);
				_t = _t.getNextSibling();
				break;
			}
			case LITERAL_private:
			{
				GrammarAST tmp25_AST_in = (GrammarAST)_t;
				match(_t,LITERAL_private);
				_t = _t.getNextSibling();
				break;
			}
			case FRAGMENT:
			{
				GrammarAST tmp26_AST_in = (GrammarAST)_t;
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
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void ruleScopeSpec(AST _t) throws RecognitionException {
		
		GrammarAST ruleScopeSpec_AST_in = (_t == ASTNULL) ? null : (GrammarAST)_t;
		
		try {      // for error handling
			AST __t38 = _t;
			GrammarAST tmp27_AST_in = (GrammarAST)_t;
			match(_t,SCOPE);
			_t = _t.getFirstChild();
			{
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case ACTION:
			{
				GrammarAST tmp28_AST_in = (GrammarAST)_t;
				match(_t,ACTION);
				_t = _t.getNextSibling();
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
			_loop41:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_t.getType()==ID)) {
					GrammarAST tmp29_AST_in = (GrammarAST)_t;
					match(_t,ID);
					_t = _t.getNextSibling();
				}
				else {
					break _loop41;
				}
				
			} while (true);
			}
			_t = __t38;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final StringTemplate  block(AST _t,
		String blockTemplateName, DFA dfa
	) throws RecognitionException {
		StringTemplate code=null;
		
		GrammarAST block_AST_in = (_t == ASTNULL) ? null : (GrammarAST)_t;
		
		StringTemplate decision = null;
		if ( dfa!=null ) {
		code = templates.getInstanceOf(blockTemplateName);
		decision = generator.genLookaheadDecision(recognizerST,dfa);
		code.setAttribute("decision", decision);
		code.setAttribute("decisionNumber", dfa.getDecisionNumber());
				code.setAttribute("maxK",dfa.getMaxLookaheadDepth());
				code.setAttribute("maxAlt",dfa.getNumberOfAlts());
		}
		else {
		code = templates.getInstanceOf(blockTemplateName+"SingleAlt");
		}
		blockNestingLevel++;
		code.setAttribute("blockLevel", blockNestingLevel);
		code.setAttribute("enclosingBlockLevel", blockNestingLevel-1);
		StringTemplate alt = null;
		StringTemplate rew = null;
		StringTemplate sb = null;
		GrammarAST r = null;
		int altNum = 1;
			if ( this.blockNestingLevel==RULE_BLOCK_NESTING_LEVEL ) {
		this.outerAltNum=1;
		}
		
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			if (((_t.getType()==BLOCK))&&(block_AST_in.getSetValue()!=null)) {
				sb=setBlock(_t);
				_t = _retTree;
				
				code.setAttribute("alts",sb);
				blockNestingLevel--;
				
			}
			else if ((_t.getType()==BLOCK)) {
				AST __t43 = _t;
				GrammarAST tmp30_AST_in = (GrammarAST)_t;
				match(_t,BLOCK);
				_t = _t.getFirstChild();
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case OPTIONS:
				{
					GrammarAST tmp31_AST_in = (GrammarAST)_t;
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
				int _cnt46=0;
				_loop46:
				do {
					if (_t==null) _t=ASTNULL;
					if ((_t.getType()==ALT)) {
						alt=alternative(_t);
						_t = _retTree;
						r=(GrammarAST)_t;
						rew=rewrite(_t);
						_t = _retTree;
						
						if ( this.blockNestingLevel==RULE_BLOCK_NESTING_LEVEL ) {
							this.outerAltNum++;
						}
						// add the rewrite code as just another element in the alt :)
								  if ( rew!=null ) {
								  	alt.setAttribute("elements.{el,line,pos}",
								  		rew, Utils.integer(r.getLine()), Utils.integer(r.getColumn()));
								  }
								  // add this alt to the list of alts for this block
						code.setAttribute("alts",alt);
						alt.setAttribute("altNum", Utils.integer(altNum));
						alt.setAttribute("outerAlt",
						Boolean.valueOf(blockNestingLevel==RULE_BLOCK_NESTING_LEVEL));
						altNum++;
						
					}
					else {
						if ( _cnt46>=1 ) { break _loop46; } else {throw new NoViableAltException(_t);}
					}
					
					_cnt46++;
				} while (true);
				}
				GrammarAST tmp32_AST_in = (GrammarAST)_t;
				match(_t,EOB);
				_t = _t.getNextSibling();
				_t = __t43;
				_t = _t.getNextSibling();
				blockNestingLevel--;
			}
			else {
				throw new NoViableAltException(_t);
			}
			
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
		return code;
	}
	
	public final void exceptionGroup(AST _t,
		StringTemplate ruleST
	) throws RecognitionException {
		
		GrammarAST exceptionGroup_AST_in = (_t == ASTNULL) ? null : (GrammarAST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case LITERAL_catch:
			{
				{
				int _cnt50=0;
				_loop50:
				do {
					if (_t==null) _t=ASTNULL;
					if ((_t.getType()==LITERAL_catch)) {
						exceptionHandler(_t,ruleST);
						_t = _retTree;
					}
					else {
						if ( _cnt50>=1 ) { break _loop50; } else {throw new NoViableAltException(_t);}
					}
					
					_cnt50++;
				} while (true);
				}
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case LITERAL_finally:
				{
					finallyClause(_t,ruleST);
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
				finallyClause(_t,ruleST);
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
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final StringTemplate  setBlock(AST _t) throws RecognitionException {
		StringTemplate code=null;
		
		GrammarAST setBlock_AST_in = (_t == ASTNULL) ? null : (GrammarAST)_t;
		GrammarAST s = null;
		
		if ( blockNestingLevel==RULE_BLOCK_NESTING_LEVEL && grammar.buildAST() ) {
		Rule r = grammar.getRule(currentRuleName);
		currentAltHasASTRewrite = r.hasRewrite(outerAltNum);
		if ( currentAltHasASTRewrite ) {
		r.trackTokenReferenceInAlt(setBlock_AST_in, outerAltNum);
		}
		}
		
		
		try {      // for error handling
			s = (GrammarAST)_t;
			match(_t,BLOCK);
			_t = _t.getNextSibling();
			
			StringTemplate setcode =
			getTokenElementST("matchSet", "set", s, null, null);
			int i = ((TokenWithIndex)s.getToken()).getIndex();
					setcode.setAttribute("elementIndex", i);
					if ( grammar.type!=Grammar.LEXER ) {
						generator.generateLocalFOLLOW(s,"set",currentRuleName,i);
			}
			setcode.setAttribute("s",
			generator.genSetExpr(templates,s.getSetValue(),1,false));
			StringTemplate altcode=templates.getInstanceOf("alt");
					altcode.setAttribute("elements.{el,line,pos}",
									     setcode,
			Utils.integer(s.getLine()),
			Utils.integer(s.getColumn())
			);
			altcode.setAttribute("altNum", Utils.integer(1));
			altcode.setAttribute("outerAlt",
			Boolean.valueOf(blockNestingLevel==RULE_BLOCK_NESTING_LEVEL));
			if ( !currentAltHasASTRewrite && grammar.buildAST() ) {
			altcode.setAttribute("autoAST", Boolean.valueOf(true));
			}
			code = altcode;
			
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
		return code;
	}
	
	public final StringTemplate  alternative(AST _t) throws RecognitionException {
		StringTemplate code=templates.getInstanceOf("alt");
		
		GrammarAST alternative_AST_in = (_t == ASTNULL) ? null : (GrammarAST)_t;
		GrammarAST a = null;
		
		/*
		// TODO: can we use Rule.altsWithRewrites???
		if ( blockNestingLevel==RULE_BLOCK_NESTING_LEVEL ) {
			GrammarAST aRewriteNode = #alternative.findFirstType(REWRITE);
			if ( grammar.buildAST() &&
				 (aRewriteNode!=null||
				 (#alternative.getNextSibling()!=null &&
				  #alternative.getNextSibling().getType()==REWRITE)) )
			{
				currentAltHasASTRewrite = true;
			}
			else {
				currentAltHasASTRewrite = false;
			}
		}
		*/
		if ( blockNestingLevel==RULE_BLOCK_NESTING_LEVEL && grammar.buildAST() ) {
		Rule r = grammar.getRule(currentRuleName);
		currentAltHasASTRewrite = r.hasRewrite(outerAltNum);
		}
		String description = grammar.grammarTreeToString(alternative_AST_in, false);
		description = generator.target.getTargetStringLiteralFromString(description);
		code.setAttribute("description", description);
		if ( !currentAltHasASTRewrite && grammar.buildAST() ) {
			code.setAttribute("autoAST", Boolean.valueOf(true));
		}
		StringTemplate e;
		
		
		try {      // for error handling
			AST __t57 = _t;
			a = _t==ASTNULL ? null :(GrammarAST)_t;
			match(_t,ALT);
			_t = _t.getFirstChild();
			{
			int _cnt59=0;
			_loop59:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_t.getType()==BLOCK||_t.getType()==OPTIONAL||_t.getType()==CLOSURE||_t.getType()==POSITIVE_CLOSURE||_t.getType()==CHAR_RANGE||_t.getType()==EPSILON||_t.getType()==GATED_SEMPRED||_t.getType()==SYN_SEMPRED||_t.getType()==BACKTRACK_SEMPRED||_t.getType()==ACTION||_t.getType()==ASSIGN||_t.getType()==STRING_LITERAL||_t.getType()==CHAR_LITERAL||_t.getType()==TOKEN_REF||_t.getType()==BANG||_t.getType()==PLUS_ASSIGN||_t.getType()==SEMPRED||_t.getType()==ROOT||_t.getType()==RULE_REF||_t.getType()==NOT||_t.getType()==TREE_BEGIN||_t.getType()==WILDCARD)) {
					GrammarAST elAST=(GrammarAST)_t;
					e=element(_t,null,null);
					_t = _retTree;
					
								if ( e!=null ) {
										code.setAttribute("elements.{el,line,pos}",
														  e,
														  Utils.integer(elAST.getLine()),
														  Utils.integer(elAST.getColumn())
														 );
								}
								
				}
				else {
					if ( _cnt59>=1 ) { break _loop59; } else {throw new NoViableAltException(_t);}
				}
				
				_cnt59++;
			} while (true);
			}
			GrammarAST tmp33_AST_in = (GrammarAST)_t;
			match(_t,EOA);
			_t = _t.getNextSibling();
			_t = __t57;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
		return code;
	}
	
	public final StringTemplate  rewrite(AST _t) throws RecognitionException {
		StringTemplate code=null;
		
		GrammarAST rewrite_AST_in = (_t == ASTNULL) ? null : (GrammarAST)_t;
		GrammarAST r = null;
		GrammarAST pred = null;
		
		StringTemplate alt;
		if ( rewrite_AST_in.getType()==REWRITE ) {
			if ( generator.grammar.buildTemplate() ) {
				code = templates.getInstanceOf("rewriteTemplate");
			}
			else {
				code = templates.getInstanceOf("rewriteCode");
				code.setAttribute("treeLevel", Utils.integer(OUTER_REWRITE_NESTING_LEVEL));
				code.setAttribute("rewriteBlockLevel", Utils.integer(OUTER_REWRITE_NESTING_LEVEL));
		code.setAttribute("referencedElementsDeep",
		getTokenTypesAsTargetLabels(rewrite_AST_in.rewriteRefsDeep));
		Set<String> tokenLabels =
		grammar.getLabels(rewrite_AST_in.rewriteRefsDeep, Grammar.TOKEN_LABEL);
		Set<String> tokenListLabels =
		grammar.getLabels(rewrite_AST_in.rewriteRefsDeep, Grammar.TOKEN_LIST_LABEL);
		Set<String> ruleLabels =
		grammar.getLabels(rewrite_AST_in.rewriteRefsDeep, Grammar.RULE_LABEL);
		Set<String> ruleListLabels =
		grammar.getLabels(rewrite_AST_in.rewriteRefsDeep, Grammar.RULE_LIST_LABEL);
		// just in case they ref $r for "previous value", make a stream
		// from retval.tree
		StringTemplate retvalST = templates.getInstanceOf("prevRuleRootRef");
		ruleLabels.add(retvalST.toString());
		code.setAttribute("referencedTokenLabels", tokenLabels);
		code.setAttribute("referencedTokenListLabels", tokenListLabels);
		code.setAttribute("referencedRuleLabels", ruleLabels);
		code.setAttribute("referencedRuleListLabels", ruleListLabels);
			}
		}
		
		
		try {      // for error handling
			{
			_loop95:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_t.getType()==REWRITE)) {
					rewriteRuleRefs = new HashSet();
					AST __t93 = _t;
					r = _t==ASTNULL ? null :(GrammarAST)_t;
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
					alt=rewrite_alternative(_t);
					_t = _retTree;
					_t = __t93;
					_t = _t.getNextSibling();
					
					rewriteBlockNestingLevel = OUTER_REWRITE_NESTING_LEVEL;
								List predChunks = null;
								if ( pred!=null ) {
									//predText = #pred.getText();
							predChunks = generator.translateAction(currentRuleName,pred);
								}
								String description =
								    grammar.grammarTreeToString(r,false);
								description = generator.target.getTargetStringLiteralFromString(description);
								code.setAttribute("alts.{pred,alt,description}",
												  predChunks,
												  alt,
												  description);
								pred=null;
								
				}
				else {
					break _loop95;
				}
				
			} while (true);
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
		return code;
	}
	
	public final void exceptionHandler(AST _t,
		StringTemplate ruleST
	) throws RecognitionException {
		
		GrammarAST exceptionHandler_AST_in = (_t == ASTNULL) ? null : (GrammarAST)_t;
		
		try {      // for error handling
			AST __t53 = _t;
			GrammarAST tmp34_AST_in = (GrammarAST)_t;
			match(_t,LITERAL_catch);
			_t = _t.getFirstChild();
			GrammarAST tmp35_AST_in = (GrammarAST)_t;
			match(_t,ARG_ACTION);
			_t = _t.getNextSibling();
			GrammarAST tmp36_AST_in = (GrammarAST)_t;
			match(_t,ACTION);
			_t = _t.getNextSibling();
			_t = __t53;
			_t = _t.getNextSibling();
			
				List chunks = generator.translateAction(currentRuleName,tmp36_AST_in);
				ruleST.setAttribute("exceptions.{decl,action}",tmp35_AST_in.getText(),chunks);
				
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void finallyClause(AST _t,
		StringTemplate ruleST
	) throws RecognitionException {
		
		GrammarAST finallyClause_AST_in = (_t == ASTNULL) ? null : (GrammarAST)_t;
		
		try {      // for error handling
			AST __t55 = _t;
			GrammarAST tmp37_AST_in = (GrammarAST)_t;
			match(_t,LITERAL_finally);
			_t = _t.getFirstChild();
			GrammarAST tmp38_AST_in = (GrammarAST)_t;
			match(_t,ACTION);
			_t = _t.getNextSibling();
			_t = __t55;
			_t = _t.getNextSibling();
			
				List chunks = generator.translateAction(currentRuleName,tmp38_AST_in);
				ruleST.setAttribute("finally",chunks);
				
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final StringTemplate  element(AST _t,
		GrammarAST label, GrammarAST astSuffix
	) throws RecognitionException {
		StringTemplate code=null;
		
		GrammarAST element_AST_in = (_t == ASTNULL) ? null : (GrammarAST)_t;
		GrammarAST n = null;
		GrammarAST alabel = null;
		GrammarAST label2 = null;
		GrammarAST a = null;
		GrammarAST b = null;
		GrammarAST sp = null;
		GrammarAST gsp = null;
		
		IntSet elements=null;
		GrammarAST ast = null;
		
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case ROOT:
			{
				AST __t61 = _t;
				GrammarAST tmp39_AST_in = (GrammarAST)_t;
				match(_t,ROOT);
				_t = _t.getFirstChild();
				code=element(_t,label,tmp39_AST_in);
				_t = _retTree;
				_t = __t61;
				_t = _t.getNextSibling();
				break;
			}
			case BANG:
			{
				AST __t62 = _t;
				GrammarAST tmp40_AST_in = (GrammarAST)_t;
				match(_t,BANG);
				_t = _t.getFirstChild();
				code=element(_t,label,tmp40_AST_in);
				_t = _retTree;
				_t = __t62;
				_t = _t.getNextSibling();
				break;
			}
			case NOT:
			{
				AST __t63 = _t;
				n = _t==ASTNULL ? null :(GrammarAST)_t;
				match(_t,NOT);
				_t = _t.getFirstChild();
				code=notElement(_t,n, label, astSuffix);
				_t = _retTree;
				_t = __t63;
				_t = _t.getNextSibling();
				break;
			}
			case ASSIGN:
			{
				AST __t64 = _t;
				GrammarAST tmp41_AST_in = (GrammarAST)_t;
				match(_t,ASSIGN);
				_t = _t.getFirstChild();
				alabel = (GrammarAST)_t;
				match(_t,ID);
				_t = _t.getNextSibling();
				code=element(_t,alabel,astSuffix);
				_t = _retTree;
				_t = __t64;
				_t = _t.getNextSibling();
				break;
			}
			case PLUS_ASSIGN:
			{
				AST __t65 = _t;
				GrammarAST tmp42_AST_in = (GrammarAST)_t;
				match(_t,PLUS_ASSIGN);
				_t = _t.getFirstChild();
				label2 = (GrammarAST)_t;
				match(_t,ID);
				_t = _t.getNextSibling();
				code=element(_t,label2,astSuffix);
				_t = _retTree;
				_t = __t65;
				_t = _t.getNextSibling();
				break;
			}
			case CHAR_RANGE:
			{
				AST __t66 = _t;
				GrammarAST tmp43_AST_in = (GrammarAST)_t;
				match(_t,CHAR_RANGE);
				_t = _t.getFirstChild();
				a = (GrammarAST)_t;
				match(_t,CHAR_LITERAL);
				_t = _t.getNextSibling();
				b = (GrammarAST)_t;
				match(_t,CHAR_LITERAL);
				_t = _t.getNextSibling();
				_t = __t66;
				_t = _t.getNextSibling();
				code = templates.getInstanceOf("charRangeRef");
						 String low =
						 	generator.target.getTargetCharLiteralFromANTLRCharLiteral(generator,a.getText());
						 String high =
						 	generator.target.getTargetCharLiteralFromANTLRCharLiteral(generator,b.getText());
				code.setAttribute("a", low);
				code.setAttribute("b", high);
				if ( label!=null ) {
				code.setAttribute("label", label.getText());
				}
				
				break;
			}
			case TREE_BEGIN:
			{
				code=tree(_t);
				_t = _retTree;
				break;
			}
			case ACTION:
			{
				code=element_action(_t);
				_t = _retTree;
				break;
			}
			case GATED_SEMPRED:
			case SEMPRED:
			{
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case SEMPRED:
				{
					sp = (GrammarAST)_t;
					match(_t,SEMPRED);
					_t = _t.getNextSibling();
					break;
				}
				case GATED_SEMPRED:
				{
					gsp = (GrammarAST)_t;
					match(_t,GATED_SEMPRED);
					_t = _t.getNextSibling();
					sp=gsp;
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
				}
				
				code = templates.getInstanceOf("validateSemanticPredicate");
				code.setAttribute("pred", generator.translateAction(currentRuleName,sp));
						String description =
							generator.target.getTargetStringLiteralFromString(sp.getText());
						code.setAttribute("description", description);
				
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
			case EPSILON:
			{
				GrammarAST tmp46_AST_in = (GrammarAST)_t;
				match(_t,EPSILON);
				_t = _t.getNextSibling();
				break;
			}
			default:
				if (_t==null) _t=ASTNULL;
				if ((((_t.getType() >= BLOCK && _t.getType() <= POSITIVE_CLOSURE)))&&(element_AST_in.getSetValue()==null)) {
					code=ebnf(_t);
					_t = _retTree;
				}
				else if ((_t.getType()==BLOCK||_t.getType()==STRING_LITERAL||_t.getType()==CHAR_LITERAL||_t.getType()==TOKEN_REF||_t.getType()==RULE_REF||_t.getType()==WILDCARD)) {
					code=atom(_t,label, astSuffix);
					_t = _retTree;
				}
			else {
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
		return code;
	}
	
	public final StringTemplate  notElement(AST _t,
		GrammarAST n, GrammarAST label, GrammarAST astSuffix
	) throws RecognitionException {
		StringTemplate code=null;
		
		GrammarAST notElement_AST_in = (_t == ASTNULL) ? null : (GrammarAST)_t;
		GrammarAST assign_c = null;
		GrammarAST assign_s = null;
		GrammarAST assign_t = null;
		GrammarAST assign_st = null;
		
		IntSet elements=null;
		String labelText = null;
		if ( label!=null ) {
		labelText = label.getText();
		}
		
		
		try {      // for error handling
			{
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case CHAR_LITERAL:
			{
				assign_c = (GrammarAST)_t;
				match(_t,CHAR_LITERAL);
				_t = _t.getNextSibling();
				
				int ttype=0;
				if ( grammar.type==Grammar.LEXER ) {
				ttype = Grammar.getCharValueFromGrammarCharLiteral(assign_c.getText());
				}
				else {
				ttype = grammar.getTokenType(assign_c.getText());
				}
				elements = grammar.complement(ttype);
				
				break;
			}
			case STRING_LITERAL:
			{
				assign_s = (GrammarAST)_t;
				match(_t,STRING_LITERAL);
				_t = _t.getNextSibling();
				
				int ttype=0;
				if ( grammar.type==Grammar.LEXER ) {
				// TODO: error!
				}
				else {
				ttype = grammar.getTokenType(assign_s.getText());
				}
				elements = grammar.complement(ttype);
				
				break;
			}
			case TOKEN_REF:
			{
				assign_t = (GrammarAST)_t;
				match(_t,TOKEN_REF);
				_t = _t.getNextSibling();
				
				int ttype = grammar.getTokenType(assign_t.getText());
				elements = grammar.complement(ttype);
				
				break;
			}
			case BLOCK:
			{
				assign_st = (GrammarAST)_t;
				match(_t,BLOCK);
				_t = _t.getNextSibling();
				
				elements = assign_st.getSetValue();
				elements = grammar.complement(elements);
				
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
			}
			
			code = getTokenElementST("matchSet",
			"set",
			(GrammarAST)n.getFirstChild(),
			astSuffix,
			labelText);
			code.setAttribute("s",generator.genSetExpr(templates,elements,1,false));
			int i = ((TokenWithIndex)n.getToken()).getIndex();
			code.setAttribute("elementIndex", i);
			if ( grammar.type!=Grammar.LEXER ) {
			generator.generateLocalFOLLOW(n,"set",currentRuleName,i);
			}
			
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
		return code;
	}
	
	public final StringTemplate  ebnf(AST _t) throws RecognitionException {
		StringTemplate code=null;
		
		GrammarAST ebnf_AST_in = (_t == ASTNULL) ? null : (GrammarAST)_t;
		
		DFA dfa=null;
		GrammarAST b = (GrammarAST)ebnf_AST_in.getFirstChild();
		GrammarAST eob = (GrammarAST)b.getLastChild(); // loops will use EOB DFA
		
		
		try {      // for error handling
			{
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case BLOCK:
			{
				dfa = ebnf_AST_in.getLookaheadDFA();
				code=block(_t,"block", dfa);
				_t = _retTree;
				break;
			}
			case OPTIONAL:
			{
				dfa = ebnf_AST_in.getLookaheadDFA();
				AST __t73 = _t;
				GrammarAST tmp47_AST_in = (GrammarAST)_t;
				match(_t,OPTIONAL);
				_t = _t.getFirstChild();
				code=block(_t,"optionalBlock", dfa);
				_t = _retTree;
				_t = __t73;
				_t = _t.getNextSibling();
				break;
			}
			case CLOSURE:
			{
				dfa = eob.getLookaheadDFA();
				AST __t74 = _t;
				GrammarAST tmp48_AST_in = (GrammarAST)_t;
				match(_t,CLOSURE);
				_t = _t.getFirstChild();
				code=block(_t,"closureBlock", dfa);
				_t = _retTree;
				_t = __t74;
				_t = _t.getNextSibling();
				break;
			}
			case POSITIVE_CLOSURE:
			{
				dfa = eob.getLookaheadDFA();
				AST __t75 = _t;
				GrammarAST tmp49_AST_in = (GrammarAST)_t;
				match(_t,POSITIVE_CLOSURE);
				_t = _t.getFirstChild();
				code=block(_t,"positiveClosureBlock", dfa);
				_t = _retTree;
				_t = __t75;
				_t = _t.getNextSibling();
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
			}
			
					String description = grammar.grammarTreeToString(ebnf_AST_in, false);
					description = generator.target.getTargetStringLiteralFromString(description);
				code.setAttribute("description", description);
				
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
		return code;
	}
	
	public final StringTemplate  atom(AST _t,
		GrammarAST label, GrammarAST astSuffix
	) throws RecognitionException {
		StringTemplate code=null;
		
		GrammarAST atom_AST_in = (_t == ASTNULL) ? null : (GrammarAST)_t;
		GrammarAST r = null;
		GrammarAST rarg = null;
		GrammarAST t = null;
		GrammarAST targ = null;
		GrammarAST c = null;
		GrammarAST s = null;
		GrammarAST w = null;
		
		String labelText=null;
		if ( label!=null ) {
		labelText = label.getText();
		}
		
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case RULE_REF:
			{
				AST __t83 = _t;
				r = _t==ASTNULL ? null :(GrammarAST)_t;
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
				_t = __t83;
				_t = _t.getNextSibling();
				
				grammar.checkRuleReference(r, rarg, currentRuleName);
				Rule rdef = grammar.getRule(r.getText());
				// don't insert label=r() if $label.attr not used, no ret value, ...
				if ( !rdef.getHasReturnValue() ) {
				labelText = null;
				}
				code = getRuleElementST("ruleRef", r.getText(), r, astSuffix, labelText);
						code.setAttribute("rule", r.getText());
				
						if ( rarg!=null ) {
							List args = generator.translateAction(currentRuleName,rarg);
							code.setAttribute("args", args);
						}
				int i = ((TokenWithIndex)r.getToken()).getIndex();
						code.setAttribute("elementIndex", i);
						generator.generateLocalFOLLOW(r,r.getText(),currentRuleName,i);
						r.code = code;
				
				break;
			}
			case TOKEN_REF:
			{
				AST __t85 = _t;
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
				_t = __t85;
				_t = _t.getNextSibling();
				
				grammar.checkRuleReference(t, targ, currentRuleName);
						   if ( grammar.type==Grammar.LEXER ) {
								if ( grammar.getTokenType(t.getText())==Label.EOF ) {
									code = templates.getInstanceOf("lexerMatchEOF");
								}
							    else {
									code = templates.getInstanceOf("lexerRuleRef");
				if ( isListLabel(labelText) ) {
				code = templates.getInstanceOf("lexerRuleRefAndListLabel");
				}
									code.setAttribute("rule", t.getText());
									if ( targ!=null ) {
										List args = generator.translateAction(currentRuleName,targ);
										code.setAttribute("args", args);
									}
								}
				int i = ((TokenWithIndex)t.getToken()).getIndex();
							    code.setAttribute("elementIndex", i);
							    if ( label!=null ) code.setAttribute("label", labelText);
						   }
						   else {
								code = getTokenElementST("tokenRef", t.getText(), t, astSuffix, labelText);
								String tokenLabel =
								   generator.getTokenTypeAsTargetLabel(grammar.getTokenType(t.getText()));
								code.setAttribute("token",tokenLabel);
				int i = ((TokenWithIndex)t.getToken()).getIndex();
							    code.setAttribute("elementIndex", i);
							    generator.generateLocalFOLLOW(t,tokenLabel,currentRuleName,i);
						   }
						   t.code = code;
						
				break;
			}
			case CHAR_LITERAL:
			{
				c = (GrammarAST)_t;
				match(_t,CHAR_LITERAL);
				_t = _t.getNextSibling();
				
						if ( grammar.type==Grammar.LEXER ) {
							code = templates.getInstanceOf("charRef");
							code.setAttribute("char",
							   generator.target.getTargetCharLiteralFromANTLRCharLiteral(generator,c.getText()));
							if ( label!=null ) {
								code.setAttribute("label", labelText);
							}
						}
						else { // else it's a token type reference
							code = getTokenElementST("tokenRef", "char_literal", c, astSuffix, labelText);
							String tokenLabel = generator.getTokenTypeAsTargetLabel(grammar.getTokenType(c.getText()));
							code.setAttribute("token",tokenLabel);
				int i = ((TokenWithIndex)c.getToken()).getIndex();
							code.setAttribute("elementIndex", i);
							generator.generateLocalFOLLOW(c,tokenLabel,currentRuleName,i);
						}
				
				break;
			}
			case STRING_LITERAL:
			{
				s = (GrammarAST)_t;
				match(_t,STRING_LITERAL);
				_t = _t.getNextSibling();
				
						if ( grammar.type==Grammar.LEXER ) {
							code = templates.getInstanceOf("lexerStringRef");
							code.setAttribute("string",
							   generator.target.getTargetStringLiteralFromANTLRStringLiteral(generator,s.getText()));
							if ( label!=null ) {
								code.setAttribute("label", labelText);
							}
						}
						else { // else it's a token type reference
							code = getTokenElementST("tokenRef", "string_literal", s, astSuffix, labelText);
							String tokenLabel =
							   generator.getTokenTypeAsTargetLabel(grammar.getTokenType(s.getText()));
							code.setAttribute("token",tokenLabel);
				int i = ((TokenWithIndex)s.getToken()).getIndex();
							code.setAttribute("elementIndex", i);
							generator.generateLocalFOLLOW(s,tokenLabel,currentRuleName,i);
						}
						
				break;
			}
			case WILDCARD:
			{
				w = (GrammarAST)_t;
				match(_t,WILDCARD);
				_t = _t.getNextSibling();
				
						code = getWildcardST(w,astSuffix,labelText);
						code.setAttribute("elementIndex", ((TokenWithIndex)w.getToken()).getIndex());
						
				break;
			}
			case BLOCK:
			{
				code=set(_t,label,astSuffix);
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
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
		return code;
	}
	
	public final StringTemplate  tree(AST _t) throws RecognitionException {
		StringTemplate code=templates.getInstanceOf("tree");
		
		GrammarAST tree_AST_in = (_t == ASTNULL) ? null : (GrammarAST)_t;
		
		StringTemplate el=null, act=null;
		GrammarAST elAST=null, actAST=null;
		NFAState afterDOWN = (NFAState)tree_AST_in.NFATreeDownState.transition(0).target;
		LookaheadSet s = grammar.LOOK(afterDOWN);
		if ( s.member(Label.UP) ) {
			// nullable child list if we can see the UP as the next token
			// we need an "if ( input.LA(1)==Token.DOWN )" gate around
			// the child list.
			code.setAttribute("nullableChildList", "true");
		}
		
		
		try {      // for error handling
			AST __t77 = _t;
			GrammarAST tmp50_AST_in = (GrammarAST)_t;
			match(_t,TREE_BEGIN);
			_t = _t.getFirstChild();
			elAST=(GrammarAST)_t;
			el=element(_t,null,null);
			_t = _retTree;
			
			code.setAttribute("root.{el,line,pos}",
										  el,
										  Utils.integer(elAST.getLine()),
										  Utils.integer(elAST.getColumn())
										  );
			
			{
			_loop79:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_t.getType()==ACTION)) {
					actAST=(GrammarAST)_t;
					act=element_action(_t);
					_t = _retTree;
					
					code.setAttribute("actionsAfterRoot.{el,line,pos}",
					act,
					Utils.integer(actAST.getLine()),
					Utils.integer(actAST.getColumn())
					);
					
				}
				else {
					break _loop79;
				}
				
			} while (true);
			}
			{
			_loop81:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_t.getType()==BLOCK||_t.getType()==OPTIONAL||_t.getType()==CLOSURE||_t.getType()==POSITIVE_CLOSURE||_t.getType()==CHAR_RANGE||_t.getType()==EPSILON||_t.getType()==GATED_SEMPRED||_t.getType()==SYN_SEMPRED||_t.getType()==BACKTRACK_SEMPRED||_t.getType()==ACTION||_t.getType()==ASSIGN||_t.getType()==STRING_LITERAL||_t.getType()==CHAR_LITERAL||_t.getType()==TOKEN_REF||_t.getType()==BANG||_t.getType()==PLUS_ASSIGN||_t.getType()==SEMPRED||_t.getType()==ROOT||_t.getType()==RULE_REF||_t.getType()==NOT||_t.getType()==TREE_BEGIN||_t.getType()==WILDCARD)) {
					elAST=(GrammarAST)_t;
					el=element(_t,null,null);
					_t = _retTree;
					
								 code.setAttribute("children.{el,line,pos}",
												  el,
												  Utils.integer(elAST.getLine()),
												  Utils.integer(elAST.getColumn())
												  );
								
				}
				else {
					break _loop81;
				}
				
			} while (true);
			}
			_t = __t77;
			_t = _t.getNextSibling();
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
		return code;
	}
	
	public final StringTemplate  element_action(AST _t) throws RecognitionException {
		StringTemplate code=null;
		
		GrammarAST element_action_AST_in = (_t == ASTNULL) ? null : (GrammarAST)_t;
		GrammarAST act = null;
		
		try {      // for error handling
			act = (GrammarAST)_t;
			match(_t,ACTION);
			_t = _t.getNextSibling();
			
			code = templates.getInstanceOf("execAction");
			code.setAttribute("action", generator.translateAction(currentRuleName,act));
			
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
		return code;
	}
	
	public final StringTemplate  set(AST _t,
		GrammarAST label, GrammarAST astSuffix
	) throws RecognitionException {
		StringTemplate code=null;
		
		GrammarAST set_AST_in = (_t == ASTNULL) ? null : (GrammarAST)_t;
		GrammarAST s = null;
		
		String labelText=null;
		if ( label!=null ) {
		labelText = label.getText();
		}
		
		
		try {      // for error handling
			s = (GrammarAST)_t;
			match(_t,BLOCK);
			_t = _t.getNextSibling();
			
			code = getTokenElementST("matchSet", "set", s, astSuffix, labelText);
			int i = ((TokenWithIndex)s.getToken()).getIndex();
					code.setAttribute("elementIndex", i);
					if ( grammar.type!=Grammar.LEXER ) {
						generator.generateLocalFOLLOW(s,"set",currentRuleName,i);
			}
			code.setAttribute("s", generator.genSetExpr(templates,s.getSetValue(),1,false));
			
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
		return code;
	}
	
	public final void ast_suffix(AST _t) throws RecognitionException {
		
		GrammarAST ast_suffix_AST_in = (_t == ASTNULL) ? null : (GrammarAST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case ROOT:
			{
				GrammarAST tmp51_AST_in = (GrammarAST)_t;
				match(_t,ROOT);
				_t = _t.getNextSibling();
				break;
			}
			case BANG:
			{
				GrammarAST tmp52_AST_in = (GrammarAST)_t;
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
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final void setElement(AST _t) throws RecognitionException {
		
		GrammarAST setElement_AST_in = (_t == ASTNULL) ? null : (GrammarAST)_t;
		GrammarAST c = null;
		GrammarAST t = null;
		GrammarAST s = null;
		GrammarAST c1 = null;
		GrammarAST c2 = null;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case CHAR_LITERAL:
			{
				c = (GrammarAST)_t;
				match(_t,CHAR_LITERAL);
				_t = _t.getNextSibling();
				break;
			}
			case TOKEN_REF:
			{
				t = (GrammarAST)_t;
				match(_t,TOKEN_REF);
				_t = _t.getNextSibling();
				break;
			}
			case STRING_LITERAL:
			{
				s = (GrammarAST)_t;
				match(_t,STRING_LITERAL);
				_t = _t.getNextSibling();
				break;
			}
			case CHAR_RANGE:
			{
				AST __t90 = _t;
				GrammarAST tmp53_AST_in = (GrammarAST)_t;
				match(_t,CHAR_RANGE);
				_t = _t.getFirstChild();
				c1 = (GrammarAST)_t;
				match(_t,CHAR_LITERAL);
				_t = _t.getNextSibling();
				c2 = (GrammarAST)_t;
				match(_t,CHAR_LITERAL);
				_t = _t.getNextSibling();
				_t = __t90;
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
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
	}
	
	public final StringTemplate  rewrite_alternative(AST _t) throws RecognitionException {
		StringTemplate code=null;
		
		GrammarAST rewrite_alternative_AST_in = (_t == ASTNULL) ? null : (GrammarAST)_t;
		GrammarAST a = null;
		
		StringTemplate el,st;
		
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			if (((_t.getType()==ALT))&&(generator.grammar.buildAST())) {
				AST __t99 = _t;
				a = _t==ASTNULL ? null :(GrammarAST)_t;
				match(_t,ALT);
				_t = _t.getFirstChild();
				code=templates.getInstanceOf("rewriteElementList");
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
					int _cnt102=0;
					_loop102:
					do {
						if (_t==null) _t=ASTNULL;
						if ((_t.getType()==OPTIONAL||_t.getType()==CLOSURE||_t.getType()==POSITIVE_CLOSURE||_t.getType()==LABEL||_t.getType()==ACTION||_t.getType()==STRING_LITERAL||_t.getType()==CHAR_LITERAL||_t.getType()==TOKEN_REF||_t.getType()==RULE_REF||_t.getType()==TREE_BEGIN)) {
							GrammarAST elAST=(GrammarAST)_t;
							el=rewrite_element(_t);
							_t = _retTree;
							code.setAttribute("elements.{el,line,pos}",
												 					el,
														  		Utils.integer(elAST.getLine()),
														  		Utils.integer(elAST.getColumn())
												 					);
												
						}
						else {
							if ( _cnt102>=1 ) { break _loop102; } else {throw new NoViableAltException(_t);}
						}
						
						_cnt102++;
					} while (true);
					}
					break;
				}
				case EPSILON:
				{
					GrammarAST tmp54_AST_in = (GrammarAST)_t;
					match(_t,EPSILON);
					_t = _t.getNextSibling();
					code.setAttribute("elements.{el,line,pos}",
												   templates.getInstanceOf("rewriteEmptyAlt"),
												   Utils.integer(a.getLine()),
												   Utils.integer(a.getColumn())
										 			   );
									
					break;
				}
				default:
				{
					throw new NoViableAltException(_t);
				}
				}
				}
				GrammarAST tmp55_AST_in = (GrammarAST)_t;
				match(_t,EOA);
				_t = _t.getNextSibling();
				_t = __t99;
				_t = _t.getNextSibling();
			}
			else if (((_t.getType()==ALT||_t.getType()==TEMPLATE||_t.getType()==ACTION))&&(generator.grammar.buildTemplate())) {
				code=rewrite_template(_t);
				_t = _retTree;
			}
			else {
				throw new NoViableAltException(_t);
			}
			
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
		return code;
	}
	
	public final StringTemplate  rewrite_block(AST _t,
		String blockTemplateName
	) throws RecognitionException {
		StringTemplate code=null;
		
		GrammarAST rewrite_block_AST_in = (_t == ASTNULL) ? null : (GrammarAST)_t;
		
		rewriteBlockNestingLevel++;
		code = templates.getInstanceOf(blockTemplateName);
		StringTemplate save_currentBlockST = currentBlockST;
		currentBlockST = code;
		code.setAttribute("rewriteBlockLevel", rewriteBlockNestingLevel);
		StringTemplate alt=null;
		
		
		try {      // for error handling
			AST __t97 = _t;
			GrammarAST tmp56_AST_in = (GrammarAST)_t;
			match(_t,BLOCK);
			_t = _t.getFirstChild();
			
			currentBlockST.setAttribute("referencedElementsDeep",
			getTokenTypesAsTargetLabels(tmp56_AST_in.rewriteRefsDeep));
			currentBlockST.setAttribute("referencedElements",
			getTokenTypesAsTargetLabels(tmp56_AST_in.rewriteRefsShallow));
			
			alt=rewrite_alternative(_t);
			_t = _retTree;
			GrammarAST tmp57_AST_in = (GrammarAST)_t;
			match(_t,EOB);
			_t = _t.getNextSibling();
			_t = __t97;
			_t = _t.getNextSibling();
			
				code.setAttribute("alt", alt);
				rewriteBlockNestingLevel--;
				currentBlockST = save_currentBlockST;
				
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
		return code;
	}
	
	public final StringTemplate  rewrite_element(AST _t) throws RecognitionException {
		StringTemplate code=null;
		
		GrammarAST rewrite_element_AST_in = (_t == ASTNULL) ? null : (GrammarAST)_t;
		
		IntSet elements=null;
		GrammarAST ast = null;
		
		
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
				code=rewrite_atom(_t,false);
				_t = _retTree;
				break;
			}
			case OPTIONAL:
			case CLOSURE:
			case POSITIVE_CLOSURE:
			{
				code=rewrite_ebnf(_t);
				_t = _retTree;
				break;
			}
			case TREE_BEGIN:
			{
				code=rewrite_tree(_t);
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
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
		return code;
	}
	
	public final StringTemplate  rewrite_template(AST _t) throws RecognitionException {
		StringTemplate code=null;
		
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
				AST __t117 = _t;
				GrammarAST tmp58_AST_in = (GrammarAST)_t;
				match(_t,ALT);
				_t = _t.getFirstChild();
				GrammarAST tmp59_AST_in = (GrammarAST)_t;
				match(_t,EPSILON);
				_t = _t.getNextSibling();
				GrammarAST tmp60_AST_in = (GrammarAST)_t;
				match(_t,EOA);
				_t = _t.getNextSibling();
				_t = __t117;
				_t = _t.getNextSibling();
				code=templates.getInstanceOf("rewriteEmptyTemplate");
				break;
			}
			case TEMPLATE:
			{
				AST __t118 = _t;
				GrammarAST tmp61_AST_in = (GrammarAST)_t;
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
				
						   if ( id!=null && id.getText().equals("template") ) {
						   		code = templates.getInstanceOf("rewriteInlineTemplate");
						   }
						   else if ( id!=null ) {
						   		code = templates.getInstanceOf("rewriteExternalTemplate");
						   		code.setAttribute("name", id.getText());
						   }
						   else if ( ind!=null ) { // must be %({expr})(args)
						   		code = templates.getInstanceOf("rewriteIndirectTemplate");
								List chunks=generator.translateAction(currentRuleName,ind);
						   		code.setAttribute("expr", chunks);
						   }
						
				AST __t120 = _t;
				GrammarAST tmp62_AST_in = (GrammarAST)_t;
				match(_t,ARGLIST);
				_t = _t.getFirstChild();
				{
				_loop123:
				do {
					if (_t==null) _t=ASTNULL;
					if ((_t.getType()==ARG)) {
						AST __t122 = _t;
						GrammarAST tmp63_AST_in = (GrammarAST)_t;
						match(_t,ARG);
						_t = _t.getFirstChild();
						arg = (GrammarAST)_t;
						match(_t,ID);
						_t = _t.getNextSibling();
						a = (GrammarAST)_t;
						match(_t,ACTION);
						_t = _t.getNextSibling();
						
						// must set alt num here rather than in define.g
						// because actions like %foo(name={$ID.text}) aren't
						// broken up yet into trees.
										   a.outerAltNum = this.outerAltNum;
								   		   List chunks = generator.translateAction(currentRuleName,a);
								   		   code.setAttribute("args.{name,value}", arg.getText(), chunks);
								   		
						_t = __t122;
						_t = _t.getNextSibling();
					}
					else {
						break _loop123;
					}
					
				} while (true);
				}
				_t = __t120;
				_t = _t.getNextSibling();
				{
				if (_t==null) _t=ASTNULL;
				switch ( _t.getType()) {
				case DOUBLE_QUOTE_STRING_LITERAL:
				{
					GrammarAST tmp64_AST_in = (GrammarAST)_t;
					match(_t,DOUBLE_QUOTE_STRING_LITERAL);
					_t = _t.getNextSibling();
					
					String sl = tmp64_AST_in.getText();
								 String t = sl.substring(1,sl.length()-1); // strip quotes
								 t = generator.target.getTargetStringLiteralFromString(t);
					code.setAttribute("template",t);
					
					break;
				}
				case DOUBLE_ANGLE_STRING_LITERAL:
				{
					GrammarAST tmp65_AST_in = (GrammarAST)_t;
					match(_t,DOUBLE_ANGLE_STRING_LITERAL);
					_t = _t.getNextSibling();
					
					String sl = tmp65_AST_in.getText();
								 String t = sl.substring(2,sl.length()-2); // strip double angle quotes
								 t = generator.target.getTargetStringLiteralFromString(t);
					code.setAttribute("template",t);
					
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
				_t = __t118;
				_t = _t.getNextSibling();
				break;
			}
			case ACTION:
			{
				act = (GrammarAST)_t;
				match(_t,ACTION);
				_t = _t.getNextSibling();
				
				// set alt num for same reason as ARGLIST above
				act.outerAltNum = this.outerAltNum;
						code=templates.getInstanceOf("rewriteAction");
						code.setAttribute("action",
										  generator.translateAction(currentRuleName,act));
						
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
		return code;
	}
	
	public final StringTemplate  rewrite_atom(AST _t,
		boolean isRoot
	) throws RecognitionException {
		StringTemplate code=null;
		
		GrammarAST rewrite_atom_AST_in = (_t == ASTNULL) ? null : (GrammarAST)_t;
		GrammarAST r = null;
		GrammarAST arg = null;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case RULE_REF:
			{
				r = (GrammarAST)_t;
				match(_t,RULE_REF);
				_t = _t.getNextSibling();
				
					String ruleRefName = r.getText();
					String stName = "rewriteRuleRef";
					if ( isRoot ) {
						stName += "Root";
					}
					code = templates.getInstanceOf(stName);
					code.setAttribute("rule", ruleRefName);
					if ( grammar.getRule(ruleRefName)==null ) {
							ErrorManager.grammarError(ErrorManager.MSG_UNDEFINED_RULE_REF,
													  grammar,
													  ((GrammarAST)(r)).getToken(),
													  ruleRefName);
						code = new StringTemplate(); // blank; no code gen
					}
					else if ( grammar.getRule(currentRuleName)
							     .getRuleRefsInAlt(ruleRefName,outerAltNum)==null )
						{
							ErrorManager.grammarError(ErrorManager.MSG_REWRITE_ELEMENT_NOT_PRESENT_ON_LHS,
													  grammar,
													  ((GrammarAST)(r)).getToken(),
													  ruleRefName);
						code = new StringTemplate(); // blank; no code gen
					}
					else {
						// track all rule refs as we must copy 2nd ref to rule and beyond
						if ( !rewriteRuleRefs.contains(ruleRefName) ) {
					    		rewriteRuleRefs.add(ruleRefName);
						}
						}
					
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
					AST __t114 = _t;
					GrammarAST tmp66_AST_in = (GrammarAST)_t;
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
					_t = __t114;
					_t = _t.getNextSibling();
					break;
				}
				case CHAR_LITERAL:
				{
					GrammarAST tmp67_AST_in = (GrammarAST)_t;
					match(_t,CHAR_LITERAL);
					_t = _t.getNextSibling();
					break;
				}
				case STRING_LITERAL:
				{
					GrammarAST tmp68_AST_in = (GrammarAST)_t;
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
				
					String tokenName = rewrite_atom_AST_in.getText();
					String stName = "rewriteTokenRef";
					Rule rule = grammar.getRule(currentRuleName);
					Set tokenRefsInAlt = rule.getTokenRefsInAlt(outerAltNum);
					boolean imaginary = !tokenRefsInAlt.contains(tokenName);
					if ( imaginary ) {
						stName = "rewriteImaginaryTokenRef";
					}
					if ( isRoot ) {
						stName += "Root";
					}
					code = templates.getInstanceOf(stName);
					if ( arg!=null ) {
							List args = generator.translateAction(currentRuleName,arg);
							code.setAttribute("args", args);
					}
						code.setAttribute("elementIndex", ((TokenWithIndex)rewrite_atom_AST_in.getToken()).getIndex());
						int ttype = grammar.getTokenType(tokenName);
						String tok = generator.getTokenTypeAsTargetLabel(ttype);
					code.setAttribute("token", tok);
					if ( grammar.getTokenType(tokenName)==Label.INVALID ) {
							ErrorManager.grammarError(ErrorManager.MSG_UNDEFINED_TOKEN_REF_IN_REWRITE,
													  grammar,
													  ((GrammarAST)(rewrite_atom_AST_in)).getToken(),
													  tokenName);
						code = new StringTemplate(); // blank; no code gen
					}
					
				break;
			}
			case LABEL:
			{
				GrammarAST tmp69_AST_in = (GrammarAST)_t;
				match(_t,LABEL);
				_t = _t.getNextSibling();
				
					String labelName = tmp69_AST_in.getText();
					Rule rule = grammar.getRule(currentRuleName);
					Grammar.LabelElementPair pair = rule.getLabel(labelName);
					if ( labelName.equals(currentRuleName) ) {
						// special case; ref to old value via $rule
						StringTemplate labelST = templates.getInstanceOf("prevRuleRootRef");
						code = templates.getInstanceOf("rewriteRuleLabelRef"+(isRoot?"Root":""));
						code.setAttribute("label", labelST);
					}
					else if ( pair==null ) {
							ErrorManager.grammarError(ErrorManager.MSG_UNDEFINED_LABEL_REF_IN_REWRITE,
													  grammar,
													  ((GrammarAST)(tmp69_AST_in)).getToken(),
													  labelName);
							code = new StringTemplate();
					}
					else {
							String stName = null;
							switch ( pair.type ) {
								case Grammar.TOKEN_LABEL :
									stName = "rewriteTokenLabelRef";
									break;
								case Grammar.RULE_LABEL :
									stName = "rewriteRuleLabelRef";
									break;
								case Grammar.TOKEN_LIST_LABEL :
									stName = "rewriteTokenListLabelRef";
									break;
								case Grammar.RULE_LIST_LABEL :
									stName = "rewriteRuleListLabelRef";
									break;
							}
							if ( isRoot ) {
								stName += "Root";
							}
							code = templates.getInstanceOf(stName);
							code.setAttribute("label", labelName);
						}
					
				break;
			}
			case ACTION:
			{
				GrammarAST tmp70_AST_in = (GrammarAST)_t;
				match(_t,ACTION);
				_t = _t.getNextSibling();
				
				// actions in rewrite rules yield a tree object
				String actText = tmp70_AST_in.getText();
				List chunks = generator.translateAction(currentRuleName,tmp70_AST_in);
						code = templates.getInstanceOf("rewriteNodeAction"+(isRoot?"Root":""));
						code.setAttribute("action", chunks);
				
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
		return code;
	}
	
	public final StringTemplate  rewrite_ebnf(AST _t) throws RecognitionException {
		StringTemplate code=null;
		
		GrammarAST rewrite_ebnf_AST_in = (_t == ASTNULL) ? null : (GrammarAST)_t;
		
		try {      // for error handling
			if (_t==null) _t=ASTNULL;
			switch ( _t.getType()) {
			case OPTIONAL:
			{
				AST __t105 = _t;
				GrammarAST tmp71_AST_in = (GrammarAST)_t;
				match(_t,OPTIONAL);
				_t = _t.getFirstChild();
				code=rewrite_block(_t,"rewriteOptionalBlock");
				_t = _retTree;
				_t = __t105;
				_t = _t.getNextSibling();
				
						String description = grammar.grammarTreeToString(rewrite_ebnf_AST_in, false);
						description = generator.target.getTargetStringLiteralFromString(description);
						code.setAttribute("description", description);
						
				break;
			}
			case CLOSURE:
			{
				AST __t106 = _t;
				GrammarAST tmp72_AST_in = (GrammarAST)_t;
				match(_t,CLOSURE);
				_t = _t.getFirstChild();
				code=rewrite_block(_t,"rewriteClosureBlock");
				_t = _retTree;
				_t = __t106;
				_t = _t.getNextSibling();
				
						String description = grammar.grammarTreeToString(rewrite_ebnf_AST_in, false);
						description = generator.target.getTargetStringLiteralFromString(description);
						code.setAttribute("description", description);
						
				break;
			}
			case POSITIVE_CLOSURE:
			{
				AST __t107 = _t;
				GrammarAST tmp73_AST_in = (GrammarAST)_t;
				match(_t,POSITIVE_CLOSURE);
				_t = _t.getFirstChild();
				code=rewrite_block(_t,"rewritePositiveClosureBlock");
				_t = _retTree;
				_t = __t107;
				_t = _t.getNextSibling();
				
						String description = grammar.grammarTreeToString(rewrite_ebnf_AST_in, false);
						description = generator.target.getTargetStringLiteralFromString(description);
						code.setAttribute("description", description);
						
				break;
			}
			default:
			{
				throw new NoViableAltException(_t);
			}
			}
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
		return code;
	}
	
	public final StringTemplate  rewrite_tree(AST _t) throws RecognitionException {
		StringTemplate code=templates.getInstanceOf("rewriteTree");
		
		GrammarAST rewrite_tree_AST_in = (_t == ASTNULL) ? null : (GrammarAST)_t;
		
		rewriteTreeNestingLevel++;
		code.setAttribute("treeLevel", rewriteTreeNestingLevel);
		code.setAttribute("enclosingTreeLevel", rewriteTreeNestingLevel-1);
		StringTemplate r, el;
		GrammarAST elAST=null;
		
		
		try {      // for error handling
			AST __t109 = _t;
			GrammarAST tmp74_AST_in = (GrammarAST)_t;
			match(_t,TREE_BEGIN);
			_t = _t.getFirstChild();
			elAST=(GrammarAST)_t;
			r=rewrite_atom(_t,true);
			_t = _retTree;
			code.setAttribute("root.{el,line,pos}",
										   r,
										   Utils.integer(elAST.getLine()),
										   Utils.integer(elAST.getColumn())
										  );
						
			{
			_loop111:
			do {
				if (_t==null) _t=ASTNULL;
				if ((_t.getType()==OPTIONAL||_t.getType()==CLOSURE||_t.getType()==POSITIVE_CLOSURE||_t.getType()==LABEL||_t.getType()==ACTION||_t.getType()==STRING_LITERAL||_t.getType()==CHAR_LITERAL||_t.getType()==TOKEN_REF||_t.getType()==RULE_REF||_t.getType()==TREE_BEGIN)) {
					elAST=(GrammarAST)_t;
					el=rewrite_element(_t);
					_t = _retTree;
					
								  code.setAttribute("children.{el,line,pos}",
												    el,
												    Utils.integer(elAST.getLine()),
												    Utils.integer(elAST.getColumn())
												    );
								
				}
				else {
					break _loop111;
				}
				
			} while (true);
			}
			_t = __t109;
			_t = _t.getNextSibling();
			
					String description = grammar.grammarTreeToString(rewrite_tree_AST_in, false);
					description = generator.target.getTargetStringLiteralFromString(description);
					code.setAttribute("description", description);
				rewriteTreeNestingLevel--;
					
		}
		catch (RecognitionException ex) {
			reportError(ex);
			if (_t!=null) {_t = _t.getNextSibling();}
		}
		_retTree = _t;
		return code;
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
	
