package org.antlr.runtime.debug;

import org.antlr.runtime.Token;
import org.antlr.runtime.RecognitionException;

import java.util.List;
import java.util.ArrayList;

/** Broadcast debug events to multiple listeners.  Lets you debug and still
 *  use the event mechanism to build parse trees etc...  Not thread-safe.
 *  Don't add events in one thread while parser fires events in another.
 * 
 *  @see also DebugEventRepeater
 */
public class DebugEventHub implements DebugEventListener {
	protected List listeners = new ArrayList();

	public DebugEventHub(DebugEventListener listener) {
		listeners.add(listener);
	}

	public DebugEventHub(DebugEventListener a, DebugEventListener b) {
		listeners.add(a);
		listeners.add(b);
	}

	/** Add another listener to broadcast events too.  Not thread-safe.
	 *  Don't add events in one thread while parser fires events in another.
	 */
	public void addListener(DebugEventListener listener) {
		listeners.add(listeners);
	}
	
	/* To avoid a mess like this:
		public void enterRule(final String ruleName) {
			broadcast(new Code(){
				public void exec(DebugEventListener listener) {listener.enterRule(ruleName);}}
				);
		}
		I am dup'ing the for-loop in each.  Where are Java closures!? blech!
	 */

	public void enterRule(String ruleName) {
		for (int i = 0; i < listeners.size(); i++) {
			DebugEventListener listener = (DebugEventListener)listeners.get(i);
			listener.enterRule(ruleName);
		}
	}

	public void exitRule(String ruleName) {
		for (int i = 0; i < listeners.size(); i++) {
			DebugEventListener listener = (DebugEventListener)listeners.get(i);
			listener.exitRule(ruleName);
		}
	}

	public void enterAlt(int alt) {
		for (int i = 0; i < listeners.size(); i++) {
			DebugEventListener listener = (DebugEventListener)listeners.get(i);
			listener.enterAlt(alt);
		}
	}

	public void enterSubRule(int decisionNumber) {
		for (int i = 0; i < listeners.size(); i++) {
			DebugEventListener listener = (DebugEventListener)listeners.get(i);
			listener.enterSubRule(decisionNumber);
		}
	}

	public void exitSubRule(int decisionNumber) {
		for (int i = 0; i < listeners.size(); i++) {
			DebugEventListener listener = (DebugEventListener)listeners.get(i);
			listener.exitSubRule(decisionNumber);
		}
	}

	public void enterDecision(int decisionNumber) {
		for (int i = 0; i < listeners.size(); i++) {
			DebugEventListener listener = (DebugEventListener)listeners.get(i);
			listener.enterDecision(decisionNumber);
		}
	}

	public void exitDecision(int decisionNumber) {
		for (int i = 0; i < listeners.size(); i++) {
			DebugEventListener listener = (DebugEventListener)listeners.get(i);
			listener.exitDecision(decisionNumber);
		}
	}

	public void location(int line, int pos) {
		for (int i = 0; i < listeners.size(); i++) {
			DebugEventListener listener = (DebugEventListener)listeners.get(i);
			listener.location(line, pos);
		}
	}

	public void consumeToken(Token token) {
		for (int i = 0; i < listeners.size(); i++) {
			DebugEventListener listener = (DebugEventListener)listeners.get(i);
			listener.consumeToken(token);
		}
	}

	public void consumeHiddenToken(Token token) {
		for (int i = 0; i < listeners.size(); i++) {
			DebugEventListener listener = (DebugEventListener)listeners.get(i);
			listener.consumeHiddenToken(token);
		}
	}

	public void LT(int index, Token t) {
		for (int i = 0; i < listeners.size(); i++) {
			DebugEventListener listener = (DebugEventListener)listeners.get(i);
			listener.LT(index, t);
		}
	}

	public void mark(int index) {
		for (int i = 0; i < listeners.size(); i++) {
			DebugEventListener listener = (DebugEventListener)listeners.get(i);
			listener.mark(index);
		}
	}

	public void rewind(int index) {
		for (int i = 0; i < listeners.size(); i++) {
			DebugEventListener listener = (DebugEventListener)listeners.get(i);
			listener.rewind(index);
		}
	}

	public void rewind() {
		for (int i = 0; i < listeners.size(); i++) {
			DebugEventListener listener = (DebugEventListener)listeners.get(i);
			listener.rewind();
		}
	}

	public void beginBacktrack(int level) {
		for (int i = 0; i < listeners.size(); i++) {
			DebugEventListener listener = (DebugEventListener)listeners.get(i);
			listener.beginBacktrack(level);
		}
	}

	public void endBacktrack(int level, boolean successful) {
		for (int i = 0; i < listeners.size(); i++) {
			DebugEventListener listener = (DebugEventListener)listeners.get(i);
			listener.endBacktrack(level, successful);
		}
	}

	public void recognitionException(RecognitionException e) {
		for (int i = 0; i < listeners.size(); i++) {
			DebugEventListener listener = (DebugEventListener)listeners.get(i);
			listener.recognitionException(e);
		}
	}

	public void beginResync() {
		for (int i = 0; i < listeners.size(); i++) {
			DebugEventListener listener = (DebugEventListener)listeners.get(i);
			listener.beginResync();
		}
	}

	public void endResync() {
		for (int i = 0; i < listeners.size(); i++) {
			DebugEventListener listener = (DebugEventListener)listeners.get(i);
			listener.endResync();
		}
	}

	public void semanticPredicate(boolean result, String predicate) {
		for (int i = 0; i < listeners.size(); i++) {
			DebugEventListener listener = (DebugEventListener)listeners.get(i);
			listener.semanticPredicate(result, predicate);
		}
	}

	public void commence() {
		for (int i = 0; i < listeners.size(); i++) {
			DebugEventListener listener = (DebugEventListener)listeners.get(i);
			listener.commence();
		}
	}

	public void terminate() {
		for (int i = 0; i < listeners.size(); i++) {
			DebugEventListener listener = (DebugEventListener)listeners.get(i);
			listener.terminate();
		}
	}


	// Tree parsing stuff

	public void consumeNode(Object t) {
		for (int i = 0; i < listeners.size(); i++) {
			DebugEventListener listener = (DebugEventListener)listeners.get(i);
			listener.consumeNode(t);
		}
	}

	public void LT(int index, Object t) {
		for (int i = 0; i < listeners.size(); i++) {
			DebugEventListener listener = (DebugEventListener)listeners.get(i);
			listener.LT(index, t);
		}
	}


	// AST Stuff

	public void nilNode(Object t) {
		for (int i = 0; i < listeners.size(); i++) {
			DebugEventListener listener = (DebugEventListener)listeners.get(i);
			listener.nilNode(t);
		}
	}

	public void createNode(Object t) {
		for (int i = 0; i < listeners.size(); i++) {
			DebugEventListener listener = (DebugEventListener)listeners.get(i);
			listener.createNode(t);
		}
	}

	public void createNode(Object node, Token token) {
		for (int i = 0; i < listeners.size(); i++) {
			DebugEventListener listener = (DebugEventListener)listeners.get(i);
			listener.createNode(node, token);
		}
	}

	public void becomeRoot(Object newRoot, Object oldRoot) {
		for (int i = 0; i < listeners.size(); i++) {
			DebugEventListener listener = (DebugEventListener)listeners.get(i);
			listener.becomeRoot(newRoot, oldRoot);
		}
	}

	public void addChild(Object root, Object child) {
		for (int i = 0; i < listeners.size(); i++) {
			DebugEventListener listener = (DebugEventListener)listeners.get(i);
			listener.addChild(root, child);
		}
	}

	public void setTokenBoundaries(Object t, int tokenStartIndex, int tokenStopIndex) {
		for (int i = 0; i < listeners.size(); i++) {
			DebugEventListener listener = (DebugEventListener)listeners.get(i);
			listener.setTokenBoundaries(t, tokenStartIndex, tokenStopIndex);
		}
	}
}
