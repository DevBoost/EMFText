package org.antlr.tool;

import org.antlr.analysis.NFAState;
import org.antlr.analysis.RuleClosureTransition;
import org.antlr.analysis.Transition;
import org.antlr.analysis.Label;
import org.antlr.misc.IntSet;
import org.antlr.misc.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Random;

/** Generate a random phrase given a grammar.
 *  Usage:
 *     java org.antlr.tool.RandomPhrase grammarFile.g startRule [seed]
 *
 *  For example:
 *     java org.antlr.tool.RandomPhrase simple.g program 342
 *
 *  The seed acts like a unique identifier so you can get the same random
 *  phrase back during unit testing, for example.
 *
 *  If you do not specify a seed then the current time in milliseconds is used
 *  guaranteeing that you'll never see that seed again.
 */
public class RandomPhrase {
	protected static Random random;

	/** an experimental method to generate random phrases for a given
	 *  grammar given a start rule.  Return a list of token types.
	 */
	protected static void randomPhrase(Grammar g, List tokenTypes, String startRule) {
		NFAState state = g.getRuleStartState(startRule);
		NFAState stopState = g.getRuleStopState(startRule);

		Stack ruleInvocationStack = new Stack();
		while ( true ) {
			if ( state==stopState && ruleInvocationStack.size()==0 ) {
				break;
			}
			//System.out.println("state "+state);
			if ( state.getNumberOfTransitions()==0 ) {
				//System.out.println("dangling state: "+state);
				return;
			}
			// end of rule node
			if ( state.isAcceptState() ) {
				NFAState invokingState = (NFAState)ruleInvocationStack.pop();
				// System.out.println("pop invoking state "+invokingState);
				RuleClosureTransition invokingTransition =
					(RuleClosureTransition)invokingState.transition(0);
				// move to node after state that invoked this rule
				state = invokingTransition.getFollowState();
				continue;
			}
			if ( state.getNumberOfTransitions()==1 ) {
				// no branching, just take this path
				Transition t0 = state.transition(0);
				if ( t0 instanceof RuleClosureTransition ) {
					ruleInvocationStack.push(state);
					// System.out.println("push state "+state);
					int ruleIndex = ((RuleClosureTransition)t0).getRuleIndex();
					//System.out.println("invoke "+g.getRuleName(ruleIndex));
				}
				else if ( !t0.label.isEpsilon() ) {
					tokenTypes.add( getTokenType(t0.label) );
					//System.out.println(t0.label.toString(g));
				}
				state = (NFAState)t0.target;
				continue;
			}

			int decisionNumber = state.getDecisionNumber();
			if ( decisionNumber==0 ) {
				System.out.println("weird: no decision number but a choice node");
				continue;
			}
			// decision point, pick ith alternative randomly
			int n = g.getNumberOfAltsForDecisionNFA(state);
			int randomAlt = random.nextInt(n) + 1;
			//System.out.println("randomAlt="+randomAlt);
			NFAState altStartState =
				g.getNFAStateForAltOfDecision(state, randomAlt);
			Transition t = altStartState.transition(0);
			/*
			start of a decision could never be a labeled transition
			if ( !t.label.isEpsilon() ) {
				tokenTypes.add( getTokenType(t.label) );
			}
			*/
			state = (NFAState)t.target;
		}
	}

	protected static Integer getTokenType(Label label) {
		if ( label.isSet() ) {
			// pick random element of set
			IntSet typeSet = label.getSet();
			List typeList = typeSet.toList();
			int randomIndex = random.nextInt(typeList.size());
			return (Integer)typeList.get(randomIndex);
		}
		else {
			return Utils.integer(label.getAtom());
		}
		//System.out.println(t0.label.toString(g));
	}

	/** Used to generate random strings */
	public static void main(String[] args) throws Exception {
		String grammarFileName = args[0];
		String startRule = args[1];
		long seed = System.currentTimeMillis(); // use random seed unless spec.
		if ( args.length==3 ) {
			String seedStr = args[2];
			seed = Integer.parseInt(seedStr);
		}
		random = new Random(seed);

		Grammar parser =
			new Grammar(null,
						grammarFileName,
						new BufferedReader(new FileReader(grammarFileName)));
		parser.createNFAs();

		List leftRecursiveRules = parser.checkAllRulesForLeftRecursion();
		if ( leftRecursiveRules.size()>0 ) {
			return;
		}

		if ( parser.getRule(startRule)==null ) {
			System.out.println("undefined start rule "+startRule);
			return;
		}

		String lexerGrammarText = parser.getLexerGrammar();
		Grammar lexer = new Grammar();
		lexer.importTokenVocabulary(parser);
		if ( lexerGrammarText!=null ) {
			lexer.setGrammarContent(lexerGrammarText);
		}
		else {
			System.err.println("no lexer grammar found in "+grammarFileName);
		}
		lexer.createNFAs();
		leftRecursiveRules = lexer.checkAllRulesForLeftRecursion();
		if ( leftRecursiveRules.size()>0 ) {
			return;
		}

		List tokenTypes = new ArrayList(100);
		randomPhrase(parser, tokenTypes, startRule);
		//System.out.println("token types="+tokenTypes);
		for (int i = 0; i < tokenTypes.size(); i++) {
			Integer ttypeI = (Integer) tokenTypes.get(i);
			int ttype = ttypeI.intValue();
			String ttypeDisplayName = parser.getTokenDisplayName(ttype);
			if ( Character.isUpperCase(ttypeDisplayName.charAt(0)) ) {
				List charsInToken = new ArrayList(10);
				randomPhrase(lexer, charsInToken, ttypeDisplayName);
				System.out.print(" ");
				for (int j = 0; j < charsInToken.size(); j++) {
					java.lang.Integer cI = (java.lang.Integer) charsInToken.get(j);
					System.out.print((char)cI.intValue());
				}
			}
			else { // it's a literal
				String literal =
					ttypeDisplayName.substring(1,ttypeDisplayName.length()-1);
				System.out.print(" "+literal);
			}
		}
		System.out.println();
	}

}
