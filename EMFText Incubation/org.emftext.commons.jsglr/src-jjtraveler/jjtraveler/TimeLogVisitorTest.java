package jjtraveler;

import jjtraveler.Sequence;
import jjtraveler.TopDown;
import jjtraveler.VisitFailure;
import jjtraveler.Visitable;
import jjtraveler.Visitor;

public class TimeLogVisitorTest extends VisitorTestCase {

    public TimeLogVisitorTest(String test) {
        super(test);
    }

    public void testVisitorTiming() throws VisitFailure {
        Logger l = new Logger();
        TimeLogVisitor tlv = new TimeLogVisitor(new Sleep(1), l);
        (new TopDown(new Sequence(tlv, new Sleep(1)))).visit(n0);
        System.err.println("Elapsed: " + tlv.getElapsedTime());
        System.err.println("Consumed: " + tlv.getConsumedTime());
        assertTrue(tlv.getElapsedTime() >= 0);
        assertTrue(tlv.getConsumedTime() >= 0);
        assertTrue(tlv.getElapsedTime() >= tlv.getConsumedTime());
    }

    public static class Sleep implements Visitor {
        int sleepTime;

        public Sleep(int i) {
            sleepTime = i;
        }

        public Visitable visit(Visitable x) {
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
            }
            return x;
        }
    }

}
