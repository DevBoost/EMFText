package jjtraveler;

import jjtraveler.VisitFailure;
import jjtraveler.Visitable;
import jjtraveler.Visitor;

/** 
 * A combinator that generates a loggable event each time that its
 * argument visitor is invoked.
 */

public class LogVisitor implements Visitor {
    protected Visitor visitor;
    protected Logger logger;
    
    public LogVisitor(Visitor v, Logger l) {
	visitor = v;
	logger = l;
    }

    public Visitable visit(Visitable visitable) throws VisitFailure {
	logger.log( new Event(visitor, visitable) );
	return visitor.visit( visitable );
    }

}
