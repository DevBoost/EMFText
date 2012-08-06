package jjtraveler;


/**
 * Test the Child combinator, distinguishing
 * condition failure and success.
 * 
 * @author Arie van Deursen; Jul 8, 2003 
 * @version $Id: ChildTest.java 13922 2004-06-16 14:52:05Z jurgenv $  
 */
public class ChildTest extends VisitorTestCase {

 	public ChildTest(String name) {
		super(name);
 	}

	Visitor childVisitor;
	Visitor childAction;
	Visitor condition;
	Logger expected;

	public void setUp() {
		super.setUp();
		childAction = new Identity();
		expected = new Logger();
	}



	public void testConditionFails() throws VisitFailure {
		condition = new FailAtNodes(n0);
 		expected.log(new Event(condition, n0));
		childVisitor = 
			new Child(logVisitor(condition), logVisitor(childAction));
 		Visitable nodeReturned = childVisitor.visit(n0);
  		assertEquals(expected, logger);
  		assertEquals(nodeReturned, n0);
	}
	
	
	public void testConditionSucceeds() throws VisitFailure {
		condition = new SucceedAtNodes(n0);
 		expected.log(new Event(condition, n0));
		expected.log(new Event(childAction, n1));
		expected.log(new Event(childAction, n2));
		childVisitor = 
			new Child(logVisitor(condition), logVisitor(childAction));
 		Visitable nodeReturned = childVisitor.visit(n0);
 		assertEquals(expected, logger);
		assertEquals(nodeReturned, n0);		
 	}
 	
 
}
