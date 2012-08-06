package jjtraveler;

import jjtraveler.Fail;
import jjtraveler.Identity;
import jjtraveler.IfThenElse;
import jjtraveler.VisitFailure;
import jjtraveler.Visitable;

public class IfThenElseTest extends VisitorTestCase {

    Identity idTrue = new Identity();

    Identity idFalse = new Identity();

    Visitable nodeReturned;

    public IfThenElseTest(String test) {
        super(test);
    }

    public void testFalse() throws VisitFailure {
        Logger expected = new Logger();
        expected.log(new Event(idFalse, n0));

        Visitable nodeReturned = new IfThenElse(new Fail(), logVisitor(idTrue),
                logVisitor(idFalse)).visit(n0);

        assertEquals(expected, logger);
        assertEquals("input node is returned", n0, nodeReturned);
    }

    public void testTrue() throws VisitFailure {
        Logger expected = new Logger();
        expected.log(new Event(idTrue, n0));

        Visitable nodeReturned = new IfThenElse(new Identity(),
                logVisitor(idTrue), logVisitor(idFalse)).visit(n0);

        assertEquals(expected, logger);
        assertEquals(n0, nodeReturned);
    }

    public void testTrueFailingThen() {
        Fail failingThen = new Fail();
        Logger expected = new Logger();
        expected.log(new Event(failingThen, n0));

        try {
            nodeReturned = new IfThenElse(new Identity(),
                    logVisitor(failingThen), logVisitor(idFalse)).visit(n0);
            fail();
        } catch (VisitFailure vf) {
            assertEquals("trace", expected, logger);
            assertNull("returned node", nodeReturned);
        }

    }

}
