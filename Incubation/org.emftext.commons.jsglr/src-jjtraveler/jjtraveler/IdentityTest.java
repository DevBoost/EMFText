package jjtraveler;
import jjtraveler.Identity;
import jjtraveler.VisitFailure;
import jjtraveler.Visitable;

public class IdentityTest extends VisitorTestCase {

    public IdentityTest(String test) {
	super(test);
    }

    public void testIdentity() throws VisitFailure {
	Identity id = new Identity();
	Logger expected = new Logger(id, n0);
	Visitable nodeReturned = logVisitor(id).visit(n0);
	assertEquals(expected, logger);
	assertEquals(n0, nodeReturned);
    }

}
