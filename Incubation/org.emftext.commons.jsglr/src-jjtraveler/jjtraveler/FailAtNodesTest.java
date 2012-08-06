package jjtraveler;

import jjtraveler.Not;
import jjtraveler.VisitFailure;
import jjtraveler.Visitor;

public class FailAtNodesTest extends VisitorTestCase {

    public FailAtNodesTest(String test) {
        super(test);
    }

    public void testFailAtSomeNode() {
        Visitor v = new FailAtNodes(n0, n1);
        try {
            (logVisitor(v)).visit(n0);
            fail("VisitFailure should have occured");
        } catch (VisitFailure vf) {
            Logger expected = new Logger();
            expected.log(new Event(v, n0));
            assertEquals(expected, logger);
        }
    }

    public void testSucceedAtSomeNode() throws VisitFailure {
        Visitor v = new FailAtNodes(n1, n2);
        (logVisitor(v)).visit(n0);
        Logger expected = new Logger();
        expected.log(new Event(v, n0));
        assertEquals(expected, logger);
    }

    public void testFailAtSomeNodes() throws VisitFailure {
        java.util.Collection nodes = new java.util.HashSet();
        nodes.add(n0);
        nodes.add(n1);
        nodes.add(n11);
        Visitor v = new FailAtNodes(nodes);
        new Not((logVisitor(v))).visit(n0);
        new Not((logVisitor(v))).visit(n1);
        (logVisitor(v)).visit(n2);
        new Not((logVisitor(v))).visit(n11);
        (logVisitor(v)).visit(n12);
        Logger expected = new Logger();
        expected.log(new Event(v, n0));
        expected.log(new Event(v, n1));
        expected.log(new Event(v, n2));
        expected.log(new Event(v, n11));
        expected.log(new Event(v, n12));
        assertEquals(expected, logger);
    }
}
