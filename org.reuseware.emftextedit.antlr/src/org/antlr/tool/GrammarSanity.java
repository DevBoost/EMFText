package org.antlr.tool;

import org.antlr.analysis.NFAState;
import org.antlr.analysis.Transition;
import org.antlr.analysis.RuleClosureTransition;

import java.util.List;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Set;

/** Factor out routines that check sanity of rules, alts, grammars, etc.. */
public class GrammarSanity {
	protected Grammar grammar;
	public GrammarSanity(Grammar grammar) {
		this.grammar = grammar;
	}

	/** Check all rules for infinite left recursion before analysis. Return list
	 *  of troublesome rule cycles.  This method has two side-effects: it notifies
	 *  the error manager that we have problems and it sets the list of
	 *  recursive rules that we should ignore during analysis.
	 *
	 *  Return type: List<Set<String(rule-name)>>.
	 */
	public List checkAllRulesForLeftRecursion() {
		grammar.createNFAs(); // make sure we have NFAs
		grammar.leftRecursiveRules = new HashSet();
		List listOfRecursiveCycles = new ArrayList(); // List<Set<String(rule-name)>>
		for (int i = 0; i < grammar.ruleIndexToRuleList.size(); i++) {
			String ruleName = (String)grammar.ruleIndexToRuleList.elementAt(i);
			if ( ruleName!=null ) {
				NFAState s = grammar.getRuleStartState(ruleName);
				grammar.visitedDuringRecursionCheck = new HashSet();
				grammar.visitedDuringRecursionCheck.add(ruleName);
				Set visitedStates = new HashSet();
				traceStatesLookingForLeftRecursion(s, visitedStates, listOfRecursiveCycles);
			}
		}
		if ( listOfRecursiveCycles.size()>0 ) {
			ErrorManager.leftRecursionCycles(listOfRecursiveCycles);
		}
		return listOfRecursiveCycles;
	}

	/** From state s, look for any transition to a rule that is currently
	 *  being traced.  When tracing r, visitedDuringRecursionCheck has r
	 *  initially.  If you reach an accept state, return but notify the
	 *  invoking rule that it is nullable, which implies that invoking
	 *  rule must look at follow transition for that invoking state.
	 *  The visitedStates tracks visited states within a single rule so
	 *  we can avoid epsilon-loop-induced infinite recursion here.  Keep
	 *  filling the cycles in listOfRecursiveCycles and also, as a
	 *  side-effect, set leftRecursiveRules.
	 */
	protected boolean traceStatesLookingForLeftRecursion(NFAState s,
														 Set visitedStates,
														 List listOfRecursiveCycles)
	{
		if ( s.isAcceptState() ) {
			// this rule must be nullable!
			// At least one epsilon edge reached accept state
			return true;
		}
		if ( visitedStates.contains(s) ) {
			// within same rule, we've hit same state; quit looping
			return false;
		}
		visitedStates.add(s);
		boolean stateReachesAcceptState = false;
		Transition t0 = s.transition(0);
		if ( t0 instanceof RuleClosureTransition ) {
			String targetRuleName = ((NFAState)t0.target).getEnclosingRule();
			if ( grammar.visitedDuringRecursionCheck.contains(targetRuleName) ) {
				// record left-recursive rule, but don't go back in
				grammar.leftRecursiveRules.add(targetRuleName);
				/*
				System.out.println("already visited "+targetRuleName+", calling from "+
								   s.getEnclosingRule());
				*/
				addRulesToCycle(targetRuleName,
								s.getEnclosingRule(),
								listOfRecursiveCycles);
			}
			else {
				// must visit if not already visited; send new visitedStates set
				grammar.visitedDuringRecursionCheck.add(targetRuleName);
				boolean callReachedAcceptState =
					traceStatesLookingForLeftRecursion((NFAState)t0.target,
													   new HashSet(),
													   listOfRecursiveCycles);
				// we're back from visiting that rule
				grammar.visitedDuringRecursionCheck.remove(targetRuleName);
				// must keep going in this rule then
				if ( callReachedAcceptState ) {
					NFAState followingState =
						((RuleClosureTransition)t0).getFollowState();
					stateReachesAcceptState |=
						traceStatesLookingForLeftRecursion(followingState,
														   visitedStates,
														   listOfRecursiveCycles);
				}
			}
		}
		else if ( t0.label.isEpsilon() ) {
			stateReachesAcceptState |=
				traceStatesLookingForLeftRecursion((NFAState)t0.target, visitedStates, listOfRecursiveCycles);
		}
		// else it has a labeled edge

		// now do the other transition if it exists
		Transition t1 = s.transition(1);
		if ( t1!=null ) {
			stateReachesAcceptState |=
				traceStatesLookingForLeftRecursion((NFAState)t1.target,
												   visitedStates,
												   listOfRecursiveCycles);
		}
		return stateReachesAcceptState;
	}

	/** enclosingRuleName calls targetRuleName, find the cycle containing
	 *  the target and add the caller.  Find the cycle containing the caller
	 *  and add the target.  If no cycles contain either, then create a new
	 *  cycle.  listOfRecursiveCycles is List<Set<String>> that holds a list
	 *  of cycles (sets of rule names).
	 */
	protected void addRulesToCycle(String targetRuleName,
								   String enclosingRuleName,
								   List listOfRecursiveCycles)
	{
		boolean foundCycle = false;
		for (int i = 0; i < listOfRecursiveCycles.size(); i++) {
			Set rulesInCycle = (Set)listOfRecursiveCycles.get(i);
			// ensure both rules are in same cycle
			if ( rulesInCycle.contains(targetRuleName) ) {
				rulesInCycle.add(enclosingRuleName);
				foundCycle = true;
			}
			if ( rulesInCycle.contains(enclosingRuleName) ) {
				rulesInCycle.add(targetRuleName);
				foundCycle = true;
			}
		}
		if ( !foundCycle ) {
			Set cycle = new HashSet();
			cycle.add(targetRuleName);
			cycle.add(enclosingRuleName);
			listOfRecursiveCycles.add(cycle);
		}
	}

	public void checkRuleReference(GrammarAST refAST,
								   GrammarAST argsAST,
								   String currentRuleName)
	{
		Rule r = grammar.getRule(refAST.getText());
		if ( refAST.getType()==ANTLRParser.RULE_REF ) {
			if ( argsAST!=null ) {
				// rule[args]; ref has args
                if ( r!=null && r.argActionAST==null ) {
					// but rule def has no args
					ErrorManager.grammarError(
						ErrorManager.MSG_RULE_HAS_NO_ARGS,
						grammar,
						argsAST.getToken(),
						r.name);
				}
			}
			else {
				// rule ref has no args
				if ( r!=null && r.argActionAST!=null ) {
					// but rule def has args
					ErrorManager.grammarError(
						ErrorManager.MSG_MISSING_RULE_ARGS,
						grammar,
						refAST.getToken(),
						r.name);
				}
			}
		}
		else if ( refAST.getType()==ANTLRParser.TOKEN_REF ) {
			if ( grammar.type!=Grammar.LEXER ) {
				if ( argsAST!=null ) {
					// args on a token ref not in a lexer rule
					ErrorManager.grammarError(
						ErrorManager.MSG_ARGS_ON_TOKEN_REF,
						grammar,
						refAST.getToken(),
						refAST.getText());
				}
				return; // ignore token refs in nonlexers
			}
			if ( argsAST!=null ) {
				// tokenRef[args]; ref has args
				if ( r!=null && r.argActionAST==null ) {
					// but token rule def has no args
					ErrorManager.grammarError(
						ErrorManager.MSG_RULE_HAS_NO_ARGS,
						grammar,
						argsAST.getToken(),
						r.name);
				}
			}
			else {
				// token ref has no args
				if ( r!=null && r.argActionAST!=null ) {
					// but token rule def has args
					ErrorManager.grammarError(
						ErrorManager.MSG_MISSING_RULE_ARGS,
						grammar,
						refAST.getToken(),
						r.name);
				}
			}
		}
	}

	/** Rules in tree grammar that use -> rewrites and are spitting out
	 *  templates via output=template and then use rewrite=true must only
	 *  use -> on alts that are simple nodes or trees or single rule refs
	 *  that match either nodes or trees.  The altAST is the ALT node
	 *  for an ALT.  Verify that its first child is simple.  Must be either
	 *  ( ALT ^( A B ) <end-of-alt> ) or ( ALT A <end-of-alt> ) or
	 *  other element.
	 *
	 *  Ignore predicates in front and labels.
	 */
	public void ensureAltIsSimpleNodeOrTree(GrammarAST altAST,
											GrammarAST elementAST,
											int outerAltNum)
	{
		if ( isValidSimpleElementNode(elementAST) ) {
			GrammarAST next = (GrammarAST)elementAST.getNextSibling();
			if ( !isNextNonActionElementEOA(next)) {
				ErrorManager.grammarWarning(ErrorManager.MSG_REWRITE_FOR_MULTI_ELEMENT_ALT,
											grammar,
											next.token,
											new Integer(outerAltNum));
			}
			return;
		}
		switch ( elementAST.getType() ) {
			case ANTLRParser.ASSIGN :		// labels ok on non-rule refs
			case ANTLRParser.PLUS_ASSIGN :
				if ( isValidSimpleElementNode(elementAST.getChild(1)) ) {
					return;
				}
				break;
			case ANTLRParser.ACTION :		// skip past actions
			case ANTLRParser.SEMPRED :
			case ANTLRParser.SYN_SEMPRED :
			case ANTLRParser.BACKTRACK_SEMPRED :
			case ANTLRParser.GATED_SEMPRED :
				ensureAltIsSimpleNodeOrTree(altAST,
											(GrammarAST)elementAST.getNextSibling(),
											outerAltNum);
				return;
		}
		ErrorManager.grammarWarning(ErrorManager.MSG_REWRITE_FOR_MULTI_ELEMENT_ALT,
									grammar,
									elementAST.token,
									new Integer(outerAltNum));
	}

	protected boolean isValidSimpleElementNode(GrammarAST t) {
		switch ( t.getType() ) {
			case ANTLRParser.TREE_BEGIN :
			case ANTLRParser.TOKEN_REF :
			case ANTLRParser.CHAR_LITERAL :
			case ANTLRParser.STRING_LITERAL :
			case ANTLRParser.WILDCARD :
				return true;
			default :
				return false;
		}
	}

	protected boolean isNextNonActionElementEOA(GrammarAST t) {
		while ( t.getType()==ANTLRParser.ACTION ||
				t.getType()==ANTLRParser.SEMPRED )
		{
			t = (GrammarAST)t.getNextSibling();
		}
		if ( t.getType()==ANTLRParser.EOA ) {
			return true;
		}
		return false;
	}
}
