package jjtraveler;

import jjtraveler.Identity;
import jjtraveler.SpineTopDown;
import jjtraveler.VisitFailure;
import jjtraveler.Visitable;
import jjtraveler.Visitor;


/** Various test cases for the rather tricky spine top down.
 *
 * @author Arie van Deursen, CWI
 * @date December 2002
 */


public class SpineTopDownTest extends VisitorTestCase {

    public SpineTopDownTest(String test) {
	super(test);
    }

    public void testSpineTopDownAtInnerNode() throws VisitFailure {
	Visitor stop = new FailAtNodes(n1);
	SpineTopDown spineTopDown = new SpineTopDown(logVisitor(stop));

	// n1 fails, so searching continues in n2.
	Logger expected = new Logger(stop, new Visitable[]{n0,n1,n2});

	Visitable nodeReturned = spineTopDown.visit(n0);

	assertEquals("visit trace",expected, logger);
	assertEquals("return value",n0, nodeReturned);
    }



    public void testSpineTopDownAtLeaf() throws VisitFailure {
	Visitor stop = new FailAtNodes(n11);
	SpineTopDown spineTopDown = new SpineTopDown(logVisitor(stop));

	// n11 fails, so path to n12 is first to succeed.
	Logger expected = new Logger(stop, new Visitable[]{n0,n1,n11,n12});

	Visitable nodeReturned = spineTopDown.visit(n0);

	assertEquals("visit trace",expected, logger);
	assertEquals("return value",n0, nodeReturned);
    }

    public void testSpineTopDownOnlySuccess() throws VisitFailure {
	Visitor dontStop = new Identity();
	SpineTopDown spineTopDown = new SpineTopDown(logVisitor(dontStop));

	// First path from n0 to n11 successful -- spinetopdown
	// won't search any further after that.
	Logger expected = new Logger(dontStop, new Visitable[]{n0,n1,n11});

	Visitable nodeReturned = spineTopDown.visit(n0);

	assertEquals("visit trace",expected, logger);
	assertEquals("return value",n0, nodeReturned);
    }




    public void testSpineTopDownFailAtTop() {
	Visitor stop = new FailAtNodes(n0);
	SpineTopDown spineTopDown = new SpineTopDown(logVisitor(stop));
	Logger expected = new Logger(stop, new Visitable[]{n0});
	Visitable nodeReturned = null;
	try {
	    nodeReturned = spineTopDown.visit(n0);
	    fail("VisitFailure should have occured!");
	} catch (VisitFailure vf) {
	    assertEquals("visit trace",expected, logger);
	    assertNull("return value",nodeReturned);
	}
    }


    public void testSpineTopDownFailAtInners() {
	Visitor stop = new FailAtNodes(n1,n2);
	SpineTopDown spineTopDown = new SpineTopDown(logVisitor(stop));
	Logger expected = new Logger(stop, new Visitable[]{n0,n1,n2});
	Visitable nodeReturned = null;
	try {
	    nodeReturned = spineTopDown.visit(n0);
	    fail("VisitFailure should have occured!");
	} catch (VisitFailure vf) {
	    assertEquals("visit trace",expected, logger);
	    assertNull("return value",nodeReturned);
	}
    }
}
