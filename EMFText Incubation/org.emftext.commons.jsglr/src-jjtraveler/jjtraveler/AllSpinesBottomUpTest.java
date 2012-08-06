package jjtraveler;


/** Various test cases for the rather tricky all spines bottom up.
 *
 * @author Arie van Deursen, CWI
 * @date December 2002
 */

public class AllSpinesBottomUpTest extends VisitorTestCase {

    public AllSpinesBottomUpTest(String test) {
	super(test);
    }

    public void testn1Success() throws VisitFailure {
	Visitor action = new Identity();
	Visitor goDown = new Identity();
	Visitor successNode = new SucceedAtNodes(n1);
	AllSpinesBottomUp asbu =
	    new AllSpinesBottomUp(goDown, successNode, logVisitor(action));

	Logger expected = new Logger(action, new Visitable[]{n1,n0});

	Visitable nodeReturned = asbu.visit(n0);

	assertEquals("visit trace",expected, logger);
	assertEquals("return value",n0, nodeReturned);
    }

   public void testn2Success() throws VisitFailure {
	Visitor action = new Identity();
	Visitor goDown = new Identity();
	Visitor successNode = new SucceedAtNodes(n2);
	AllSpinesBottomUp asbu =
	    new AllSpinesBottomUp(goDown, successNode, logVisitor(action));

	Logger expected = new Logger(action, new Visitable[]{n2,n0});

	Visitable nodeReturned = asbu.visit(n0);

	assertEquals("visit trace",expected, logger);
	assertEquals("return value",n0, nodeReturned);
    }

  public void testFailAtn1() throws VisitFailure {
	Visitor action = new Identity();
	Visitor goDown = new FailAtNodes(n1);
	Visitor successNode = new SucceedAtNodes(n12,n2);
	AllSpinesBottomUp asbu =
	    new AllSpinesBottomUp(goDown, successNode, logVisitor(action));

	Logger expected = new Logger(action, new Visitable[]{n2,n0});

	Visitable nodeReturned = asbu.visit(n0);

	assertEquals("visit trace",expected, logger);
	assertEquals("return value",n0, nodeReturned);
    }

  public void testMultiplePaths() throws VisitFailure {
	Visitor action = new Identity();
	Visitor goDown = new Identity();
	Visitor successNode = new SucceedAtNodes(n12,n2);
	AllSpinesBottomUp asbu =
	    new AllSpinesBottomUp(goDown, successNode, logVisitor(action));

	Logger expected = new Logger(action, new Visitable[]{n12,n1,n2,n0});

	Visitable nodeReturned = asbu.visit(n0);

	assertEquals("visit trace",expected, logger);
	assertEquals("return value",n0, nodeReturned);
    }
}
