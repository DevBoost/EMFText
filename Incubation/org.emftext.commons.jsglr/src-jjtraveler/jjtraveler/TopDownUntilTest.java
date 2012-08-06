package jjtraveler;
import jjtraveler.Identity;
import jjtraveler.TopDownUntil;
import jjtraveler.VisitFailure;
import jjtraveler.Visitable;
import jjtraveler.Visitor;

/** Test cases for TopDownUntil,
 *  illustrating its effect with a 
 *  failing condition.
 * 
 * 
 * @author Arie van Deursen; Jun 30, 2003 
 * @version $Id: TopDownUntilTest.java 13922 2004-06-16 14:52:05Z jurgenv $
 */

public class TopDownUntilTest extends VisitorTestCase {

	public TopDownUntilTest(String test) {
		super(test);
	}
	
	Visitor stopAt;
	Logger expected;

	public void setUp() {
		super.setUp();
		stopAt = new SucceedAtNodes(n1, n2);
		expected = new Logger();
	}

	public void testTopDownUntil() throws VisitFailure {
 		expected.log(new Event(stopAt, n0));
		expected.log(new Event(stopAt, n1));
		expected.log(new Event(stopAt, n2));

		Visitable nodeReturned = 
		    new TopDownUntil(logVisitor(stopAt)).visit(n0);

		assertEquals(expected, logger);
		assertEquals(n0, nodeReturned);
	}
	
	public void testTopDownAtBorder() throws VisitFailure {
		Visitor borderAction = new Identity();
		
		expected.log(new Event(stopAt, n0));
		expected.log(new Event(stopAt, n1));
		expected.log(new Event(borderAction, n1));
		expected.log(new Event(stopAt, n2));
		expected.log(new Event(borderAction, n2));

		Visitable nodeReturned = 
			new TopDownUntil(logVisitor(stopAt),
							 logVisitor(borderAction)
			).visit(n0);

		assertEquals(expected, logger);
		assertEquals(n0, nodeReturned);
	}
}
