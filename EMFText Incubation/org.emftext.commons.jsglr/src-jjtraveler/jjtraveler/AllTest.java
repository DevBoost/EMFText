package jjtraveler;

import jjtraveler.All;
import jjtraveler.Identity;
import jjtraveler.VisitFailure;
import jjtraveler.Visitable;

public class AllTest extends VisitorTestCase {

	public AllTest(String test) {
		super(test);
	}

	public void testAll() {
		Identity id = new Identity();
		All all = new All(logVisitor(id));
		Logger expected = new Logger(id, new Visitable[] { n1, n2 });
		try {
			Visitable nodeReturned = all.visit(n0);
			assertEquals(expected, logger);
			assertEquals(n0, nodeReturned);
		} catch (VisitFailure vf) {
			fail("VisitFailure should not occur!");
		}
	}

}
