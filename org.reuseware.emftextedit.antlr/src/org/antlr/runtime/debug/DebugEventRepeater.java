package org.antlr.runtime.debug;

import org.antlr.runtime.Token;
import org.antlr.runtime.RecognitionException;

/** A simple event repeater (proxy) that delegates all functionality to the
 *  listener sent into the ctor.  Useful if you want to listen in on a few
 *  debug events w/o interrupting the debugger.  Just subclass the repeater
 *  and override the methods you want to listen in on.  Remember to call
 *  the method in this class so the event will continue on to the original
 *  recipient.
 *
 *  @see also DebugEventHub
 */
public class DebugEventRepeater implements DebugEventListener {
	protected DebugEventListener listener;

	public DebugEventRepeater(DebugEventListener listener) {
		this.listener = listener;
	}
	
	public void enterRule(String ruleName) { listener.enterRule(ruleName); }
	public void exitRule(String ruleName) { listener.exitRule(ruleName); }
	public void enterAlt(int alt) { listener.enterAlt(alt); }
	public void enterSubRule(int decisionNumber) { listener.enterSubRule(decisionNumber); }
	public void exitSubRule(int decisionNumber) { listener.exitSubRule(decisionNumber); }
	public void enterDecision(int decisionNumber) { listener.enterDecision(decisionNumber); }
	public void exitDecision(int decisionNumber) { listener.exitDecision(decisionNumber); }
	public void location(int line, int pos) { listener.location(line, pos); }
	public void consumeToken(Token token) { listener.consumeToken(token); }
	public void consumeHiddenToken(Token token) { listener.consumeHiddenToken(token); }
	public void LT(int i, Token t) { listener.LT(i, t); }
	public void mark(int i) { listener.mark(i); }
	public void rewind(int i) { listener.rewind(i); }
	public void rewind() { listener.rewind(); }
	public void beginBacktrack(int level) { listener.beginBacktrack(level); }
	public void endBacktrack(int level, boolean successful) { listener.endBacktrack(level, successful); }
	public void recognitionException(RecognitionException e) { listener.recognitionException(e); }
	public void beginResync() { listener.beginResync(); }
	public void endResync() { listener.endResync(); }
	public void semanticPredicate(boolean result, String predicate) { listener.semanticPredicate(result, predicate); }
	public void commence() { listener.commence(); }
	public void terminate() { listener.terminate(); }

	// Tree parsing stuff

	public void consumeNode(Object t) { listener.consumeNode(t); }
	public void LT(int i, Object t) { listener.LT(i, t); }

	// AST Stuff

	public void nilNode(Object t) { listener.nilNode(t); }
	public void createNode(Object t) { listener.createNode(t); }
	public void createNode(Object node, Token token) { listener.createNode(node, token); }
	public void becomeRoot(Object newRoot, Object oldRoot) { listener.becomeRoot(newRoot, oldRoot); }
	public void addChild(Object root, Object child) { listener.addChild(root, child); }
	public void setTokenBoundaries(Object t, int tokenStartIndex, int tokenStopIndex) {
		listener.setTokenBoundaries(t, tokenStartIndex, tokenStopIndex);
	}
}
