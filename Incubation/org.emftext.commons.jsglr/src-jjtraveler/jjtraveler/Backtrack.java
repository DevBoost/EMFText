package jjtraveler;

/* 
   The Backtrack(StateVisitor) combinator saves the state of its
   argument visitor before executing it, and restores this state
   afterwards. Note that the argument visitor should clone its state
   before modifying it, otherwise state restoration will not work
   properly.
 */

public class Backtrack implements Visitor {

    StateVisitor v;

    public Backtrack(StateVisitor v) {
	this.v = v;
    }

    public Visitable visit(Visitable x)
    throws VisitFailure {
	Object state = v.getState();
	Visitable result = v.visit(x);
	v.setState(state);
	return result;
    }

}
