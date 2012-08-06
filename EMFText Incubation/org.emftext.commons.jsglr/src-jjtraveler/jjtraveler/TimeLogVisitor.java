package jjtraveler;

import jjtraveler.VisitFailure;
import jjtraveler.Visitable;
import jjtraveler.Visitor;

/**
 * This specialization of the LogVisitor additionally times the
 * invocation and return moments of the argument visitor.
 */

public class TimeLogVisitor extends LogVisitor {

    long firstInvocationTimeStamp = 0;
    long lastReturnTimeStamp;
    long consumedTime = 0;

    public TimeLogVisitor(Visitor v, Logger l) {
	super(v,l);
    }

    public Visitable visit(Visitable visitable) throws VisitFailure {
	long startTime = System.currentTimeMillis();
	if (firstInvocationTimeStamp == 0) {
	    firstInvocationTimeStamp = startTime;
	}

	logger.log( new Event(visitor,visitable) );
	Visitable result = visitor.visit( visitable );

	long endTime = System.currentTimeMillis();
	lastReturnTimeStamp = endTime;
	consumedTime = consumedTime + (endTime - startTime);

	return result;
    }

    /**
     * Retrieve the total elapsed time (in milliseconds) since the
     * first invocation of the argument visitor.
     */
    public long getElapsedTime() {
	return lastReturnTimeStamp - firstInvocationTimeStamp;
    }
    /**
     * Retrieve the cumulatively consumed time (in milliseconds)
     * during all executions of the argument visitor.
     */
    public long getConsumedTime() {
	return consumedTime;
    }

}
