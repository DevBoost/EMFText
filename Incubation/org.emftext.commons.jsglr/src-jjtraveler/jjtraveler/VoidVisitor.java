package jjtraveler;

/**
 * Abstract visitor implementation that has no return value.
 */

public abstract class VoidVisitor implements Visitor{

    /**
     * Forward to <code>voidVisit()</code> and return the incoming
     * visitable as result.
     */
    public final Visitable visit(Visitable any)
    throws VisitFailure {
      voidVisit(any);
      return any;
    }

    /**
     * Like <code>visit()</code>, except no visitable needs to be
     * returned.
     */
    public abstract void voidVisit(Visitable any) throws VisitFailure;

}
