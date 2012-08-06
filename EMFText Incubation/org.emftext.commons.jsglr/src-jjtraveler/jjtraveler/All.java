package jjtraveler;

/**
 * <code>All(v).visit(T(t1,...,tN) = T(v.visit(t1), ..., v.visit(t1))</code>
 * <p>
 * Basic visitor combinator with one visitor argument, that applies
 * this visitor to all children.
 */

public class All implements Visitor {

	public Visitor v;

	public All(Visitor v) {
		this.v = v;
	}

	public Visitable visit(Visitable any) throws VisitFailure {
		int childCount = any.getChildCount();
		Visitable result = any;
		for (int i = 0; i < childCount; i++) {
			result = result.setChildAt(i, v.visit(result.getChildAt(i)));
		}
		return result;
	}

	// Factory method
	public All make(Visitor v) {
		return new All(v);
	}
	protected void setArgumentTo(Visitor v) {
		this.v = v;
	}
}
