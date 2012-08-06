package jjtraveler;

import java.util.Collection;
import java.util.HashSet;

/**
 * A visitor combinator that collects the visitables that result from
 * succesful applications of its argument visitor. The visitor itself
 * does not iterate, but factory methods are provided that construct
 * iterating variants.
 */

public class Collect implements Visitor {

    /**
     * Construct a (non-iterating) collect visitor with initial
     * collection <code>c</code>.
     */
    public Collect(Visitor v, Collection c) {
	collection = c;
        visitor = v;
    }

    /**
     * Constructor which uses a new empty HashSet as collection.
     */
    public Collect(Visitor v) {
	this(v, new HashSet());
    }

    private Collection collection;
    private Visitor visitor;

    /**
     * Return the collection that has been built up so far.
     */
    public Collection getCollection() {
        return collection;
    }

    /**
     * Apply the argument strategy to the visitable <code>x</code>,
     * and add the resulting visitable to the collection if
     * successful.
     */
    public Visitable visit(Visitable x) 
      throws VisitFailure {
        Visitable result = visitor.visit(x);
        collection.add(result);
	return result;
    }

    /**
     * Factory method that produces a collecting visitor that iterates
     * in top-down fashion.
     */
    public static GuaranteeSuccess topdown(Visitor v, Collection c) {
	return (new GuaranteeSuccess
		(new TopDown
		 (new Try(new Collect(v,c)))));
    }

    /**
     * Factory method that produces a collecting visitor that iterates
     * left-to-right over immediate children.
     */
    public static GuaranteeSuccess all(Visitor v, Collection c) {
	return (new GuaranteeSuccess
		(new All
		 (new Try(new Collect(v,c)))));
    }
}
        
