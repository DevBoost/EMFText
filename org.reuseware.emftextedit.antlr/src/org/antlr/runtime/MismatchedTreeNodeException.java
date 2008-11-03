package org.antlr.runtime;

import org.antlr.runtime.tree.TreeNodeStream;
import org.antlr.runtime.tree.Tree;

/**
 */
public class MismatchedTreeNodeException extends RecognitionException {
	public int expecting;

	public MismatchedTreeNodeException() {
	}

	public MismatchedTreeNodeException(int expecting, TreeNodeStream input) {
		super(input);
		this.expecting = expecting;
	}

	public String toString() {
		return "MismatchedTreeNodeException("+getUnexpectedType()+"!="+expecting+")";
	}
}
