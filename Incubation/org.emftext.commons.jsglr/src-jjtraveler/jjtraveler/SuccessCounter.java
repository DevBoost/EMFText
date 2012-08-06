package jjtraveler;

/** Counter which keeps track of how
 *  often its argument visitor succeeds
 *  and how often it fails.
 *  Can be used for various metrics
 *  combinators. 
 * 
 * @author Arie van Deursen; Jun 30, 2003 
 * @version $Id: SuccessCounter.java 9897 2003-06-30 17:28:37Z arie $
 */


public class SuccessCounter implements Visitor {

    int success = 0;
    int failure = 0;
    Visitor action;

    public SuccessCounter(Visitor v) {
	action = v;
    }

    public int getSuccesses() {
	return success;
    }

    public int getFailures() {
	return failure;
    }

    public Visitable visit(Visitable x) {
	try {
	    action.visit(x);
	    success++;
	} catch (VisitFailure vf) {
	    failure++;
	}
	return x;
    }
}
