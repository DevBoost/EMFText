package jjtraveler;

import jjtraveler.Not;
import jjtraveler.VisitFailure;
import jjtraveler.Visitable;
import jjtraveler.Visitor;

/*
 * Simple visitor recognizing two nodes given at creation time.
 * Can be used to test generic visitors requiring a recognizing
 * argument.
 */

public class SucceedAtNodes implements jjtraveler.Visitor {
    Visitor success;
    public SucceedAtNodes(Visitable n1, Visitable n2) {
	success = new Not( new FailAtNodes(n1, n2) );
    }

    public SucceedAtNodes(Visitable n) {
	success = new Not( new FailAtNodes(n) );
    }

    public Visitable visit(Visitable x) throws VisitFailure {
	return success.visit(x);
    }
}
