package org.antlr.analysis;

import org.antlr.misc.Barrier;
import org.antlr.tool.Grammar;
import org.antlr.tool.ErrorManager;

/** Convert all decisions i..j inclusive in a thread */
public class NFAConversionThread implements Runnable {
	Grammar grammar;
	int i, j;
	Barrier barrier;
	public NFAConversionThread(Grammar grammar,
							   Barrier barrier,
							   int i,
							   int j)
	{
		this.grammar = grammar;
		this.barrier = barrier;
		this.i = i;
		this.j = j;
	}
	public void run() {
		for (int decision=i; decision<=j; decision++) {
			NFAState decisionStartState = grammar.getDecisionNFAStartState(decision);
			if ( decisionStartState.getNumberOfTransitions()>1 ) {
				grammar.createLookaheadDFA(decision);
			}
		}
		// now wait for others to finish
		try {
			barrier.waitForRelease();
		}
		catch(InterruptedException e) {
			ErrorManager.internalError("what the hell? DFA interruptus", e);
		}
	}
}

