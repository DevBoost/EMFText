package jjtraveler;

import jjtraveler.All;
import jjtraveler.Fail;
import jjtraveler.OnceTopDown;
import jjtraveler.VisitFailure;
import jjtraveler.Visitable;
import jjtraveler.Visitor;

public class OnceTopDownTest extends VisitorTestCase {

    public OnceTopDownTest(String test) {
	super(test);
    }

    public void testOnceTopDownIsLeaf() {
	Visitor isLeaf = new All(new Fail());
	OnceTopDown onceTopDown = new OnceTopDown(logVisitor(isLeaf));
	Logger expected = new Logger(isLeaf, new Visitable[]{n0,n1,n11});
	try {
	    Visitable nodeReturned = onceTopDown.visit(n0);
	    assertEquals("visit trace",expected, logger);
	    assertEquals("return value",n0, nodeReturned);
	} catch (VisitFailure vf) {
	    fail("VisitFailure should not occur!");
	}
    }

    public void testOnceTopDownFail() {
	Visitor f = new Fail();
	OnceTopDown onceTopDown = new OnceTopDown(logVisitor(f));
	Logger expected = new Logger(f, new Visitable[]{n0,n1,n11,n12,n2});
	Visitable nodeReturned = null;
	try {
	    nodeReturned = onceTopDown.visit(n0);
	    fail("VisitFailure should have occured!");
	} catch (VisitFailure vf) {
	    assertEquals("visit trace",expected, logger);
	    assertNull("return value",nodeReturned);
	}
    }

}
