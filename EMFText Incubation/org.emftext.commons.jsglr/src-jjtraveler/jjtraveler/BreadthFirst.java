package jjtraveler;

/**
 * <code>BF(v) = Seq(v,All(EnQ),IfThen(DeQ,BF(v)))</code>
 * <p>
 * Visit a tree in breadth-first order. Fails iff the argument visitor fails
 * on any of the nodes of the tree.
 */

import java.util.Collection;
import java.util.LinkedList;

public class BreadthFirst {

    public BreadthFirst(Visitor v) {
	pending = new LinkedList();
	this.v = v;
    }

    public BreadthFirst(Visitor v, Collection c) {
	pending = new LinkedList(c);
	this.v = v;
    }

    LinkedList pending;
    Visitor v;

    public Visitable visit(Visitable x)
      throws VisitFailure {
	Visitable result = v.visit(x);
	int childCount = result.getChildCount();

        for (int i = 0; i < childCount; i++) {
            pending.addLast(result.getChildAt(i));
        }

	if (pending.size() != 0) {
	    Visitable next = (Visitable) pending.removeFirst();
	    next = this.visit(next);
	}

        return result;
    }
}
	
