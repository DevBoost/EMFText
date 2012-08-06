package jjtraveler;
import jjtraveler.Fail;
import jjtraveler.Identity;
import jjtraveler.Some;
import jjtraveler.VisitFailure;
import jjtraveler.Visitable;
import jjtraveler.Visitor;


/** Test cases for Some, covering all failures, all successes,
 *  and leaf nodes.
 *
 * @author Arie van Deursen, CWI
 * @date December 2002.
 */

public class SomeTest extends VisitorTestCase {

    public SomeTest(String test) {
	super(test);
    }

    public void testSomeIdentity() throws VisitFailure {
	Identity id = new Identity();
	Some     some = new Some(logVisitor(id));
	Logger expected = new Logger(id, new Visitable[]{n1,n2});

	Visitable nodeReturned = some.visit(n0);
	assertEquals(expected, logger);
	assertEquals(n0, nodeReturned);
	
    }

    public void testSomeAllFailures() {
	Fail f = new Fail();
	Some     some = new Some(logVisitor(f));
	Logger expected = new Logger(f, new Visitable[]{n1,n2});

	Visitable nodeReturned = null;

	try {
	    nodeReturned = some.visit(n0);
	} catch (VisitFailure vf) {
	    assertEquals(expected, logger);
	    assertNull(nodeReturned);
	}
	
    }

    public void testSomeOneFailure() throws VisitFailure {
	Visitor v = new FailAtNodes(n1);
	Some     some = new Some(logVisitor(v));
	Logger expected = new Logger(v, new Visitable[]{n1,n2});

	Visitable nodeReturned = null;

	nodeReturned = some.visit(n0);
	assertEquals(expected, logger);
	assertEquals(n0, nodeReturned);
    }


    public void testSomeLeaf() {
	Identity id = new Identity();
	Some     some = new Some(logVisitor(id));
	Logger expected = new Logger();
	Visitable nodeReturned = null;

	try {
	    nodeReturned = some.visit(n11);
	    fail("Some(leaf) should fail!");
	} catch (VisitFailure vf) {
	    assertEquals(expected, logger);
	    assertNull(nodeReturned);
	}
    }


}
