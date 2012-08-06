package jjtraveler;

/**
 * <code>BF(v) = Seq(Try(Seq(v,All(EnQ))),IfThen(DeQ,BF(v)))</code>
 * <p>
 * Visit a tree in breadth-first order. The traversal is cut off below
 * nodes where the argument visitor fails. Guaranteed to succeed.
 */

import java.util.Collection;
import java.util.LinkedList;

public class OnceBreadthFirst {

    public OnceBreadthFirst(Visitor v) {
	pending = new LinkedList();
	this.v = v;
    }

    public OnceBreadthFirst(Visitor v, Collection c) {
	pending = new LinkedList(c);
	this.v = v;
    }

    LinkedList pending;
    Visitor v;

    public Visitable visit(Visitable x)
    throws VisitFailure {
	try {
	  return v.visit(x);
	} catch (VisitFailure vf) {}
	int childCount = x.getChildCount();
        for (int i = 0; i < childCount; i++) {
          pending.addLast(x.getChildAt(i));
        }
	if (pending.size() != 0) {
	    Visitable next = (Visitable) pending.removeFirst();
	    next = this.visit(next);
	}
        return x;
    }
}
	
