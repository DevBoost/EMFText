package jjtraveler;

/**
 * <code>BF(v) = Seq(Try(Seq(v,All(EnQ))),IfThen(DeQ,BF(v)))</code>
 * <p>
 * Visit a tree in breadth-first order. The traversal is cut off below
 * nodes where the argument visitor fails. Guaranteed to succeed.
 */

import java.util.Collection;
import java.util.LinkedList;

public class BreadthFirstWhile {

    public BreadthFirstWhile(Visitor v) {
	pending = new LinkedList();
	this.v = v;
    }

    public BreadthFirstWhile(Visitor v, Collection c) {
	pending = new LinkedList(c);
	this.v = v;
    }

    LinkedList pending;
    Visitor v;

    public Visitable visit(Visitable x) {
	Visitable result = x;
	try {
	  result = v.visit(x);
	  int childCount = result.getChildCount();
          for (int i = 0; i < childCount; i++) {
              pending.addLast(result.getChildAt(i));
          }
	} catch (VisitFailure vf) {}
	if (pending.size() != 0) {
	    Visitable next = (Visitable) pending.removeFirst();
	    next = this.visit(next);
	}
        return result;
    }
}
	
