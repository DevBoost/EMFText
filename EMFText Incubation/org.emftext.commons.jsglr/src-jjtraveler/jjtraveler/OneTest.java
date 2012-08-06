package jjtraveler;
import jjtraveler.Identity;
import jjtraveler.One;
import jjtraveler.VisitFailure;
import jjtraveler.Visitable;

public class OneTest extends VisitorTestCase {

    public OneTest(String test) {
	super(test);
    }

    public void testOne() {
	Identity id = new Identity();
	One     one = new One(logVisitor(id));
	Logger expected = new Logger(id, new Visitable[]{n1});
	try {
	    Visitable nodeReturned = one.visit(n0);
	    assertEquals(expected, logger);
	    assertEquals(n0, nodeReturned);
	} catch (VisitFailure vf) {
	    assertEquals(expected, logger);
	    //	    assertEquals(n0, nodeReturned);
	    fail("VisitFailure should not occur!");
	}
    }

    public void testOneLeaf() {
	Identity id = new Identity();
	One     one = new One(logVisitor(id));
	Logger expected = new Logger();
	Visitable nodeReturned = null;

	try {
	    nodeReturned = one.visit(n11);
	    fail("One(leaf) should fail!");
	} catch (VisitFailure vf) {
	    assertEquals(expected, logger);
	    assertNull(nodeReturned);
	}
    }

}
