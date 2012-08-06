package jjtraveler;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import jjtraveler.VisitFailure;
import jjtraveler.Visitable;

/*
 * Simple visitor recognizing two nodes given at creation time.
 * Can be used to test generic visitors requiring a recognizing
 * argument.
 */

public class FailAtNodes implements jjtraveler.Visitor {
	/*
	 * caching a VisitFailure for efficiency (preventing generation of a
	 * stacktrace)
	 */
	private static VisitFailure failure = new VisitFailure();

	Set visitables = new HashSet();

	public FailAtNodes(Collection visitables) {
		this.visitables.addAll(visitables);
	}

	public FailAtNodes(Visitable n) {
		visitables.add(n);
	}

	public FailAtNodes(Visitable n1, Visitable n2) {
		visitables.add(n1);
		visitables.add(n2);
	}

	public Visitable visit(Visitable x) throws VisitFailure {
		if (visitables.contains(x)) {
			throw failure;
		}
		return x;
	}
}
