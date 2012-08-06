package jjtraveler.graph;

import jjtraveler.Event;
import jjtraveler.Fail;
import jjtraveler.FailAtNodes;
import jjtraveler.Identity;
import jjtraveler.Logger;
import jjtraveler.VisitFailure;
import jjtraveler.Visitor;
import jjtraveler.VisitorTestCase;

public class ToGraphTest extends VisitorTestCase {

    public ToGraphTest(String test) {
	super(test);
    }

    public void testASTToGraph() throws jjtraveler.VisitFailure {
	EdgesGraph g = new EdgesGraph();
	Visitor v = new ASTToGraph(g);
	v.visit(n0);
	EdgesGraph expected = new EdgesGraph();
	expected.addEdge(n0, n1);
	expected.addEdge(n0, n2);
	expected.addEdge(n1, n11);
	expected.addEdge(n1, n12);
	assertEquals(expected,g);
    }

    public void testToGraphIdentity() throws jjtraveler.VisitFailure {
	EdgesGraph g = new EdgesGraph();
	Visitor v = new ToGraph(g, new Identity());
	v.visit(n0);
	EdgesGraph expected = new EdgesGraph();
	expected.addEdge(n1, n11);
	expected.addEdge(n1, n12);
	expected.addEdge(n0, n1);
	expected.addEdge(n0, n2);
	assertEquals(expected,g);
    }

    public void testToGraphFail() throws jjtraveler.VisitFailure {
	EdgesGraph g = new EdgesGraph();
	Visitor v = new ToGraph(g, new Fail());
	v.visit(n0);
	EdgesGraph expected = new EdgesGraph();
	assertEquals(expected,g);
    }

    public void testToGraphNoInternals() throws jjtraveler.VisitFailure {
	EdgesGraph g = new EdgesGraph();
	Visitor select = new FailAtNodes(n1,n2);
	Visitor v = new ToGraph(g,select);
	v.visit(n0);
	EdgesGraph expected = new EdgesGraph();
	expected.addEdge(n0, n11);
	expected.addEdge(n0, n12);
	assertEquals(expected,g);
    }

    public void testToGraphNoRoot() throws jjtraveler.VisitFailure {
	EdgesGraph g = new EdgesGraph();
	Visitor select = new FailAtNodes(n0,n0);
	Visitor v = new ToGraph(g, logVisitor(select));
	v.visit(n0);
	Logger expectedLogger = new Logger();
	expectedLogger.log(new Event(select,n0));
	expectedLogger.log(new Event(select,n1));
	expectedLogger.log(new Event(select,n11));
	expectedLogger.log(new Event(select,n11));
	expectedLogger.log(new Event(select,n12));
	expectedLogger.log(new Event(select,n12));
	expectedLogger.log(new Event(select,n2));
	EdgesGraph expected = new EdgesGraph();
	expected.addEdge(n1, n11);
	expected.addEdge(n1, n12);
	assertEquals(expected,g);
	assertEquals(expectedLogger,logger);
    }

    public void testToGraphNoLeaves() throws jjtraveler.VisitFailure {
	EdgesGraph g = new EdgesGraph();
	java.util.Set leaves = new java.util.HashSet();
	leaves.add(n11); leaves.add(n12); leaves.add(n2);
	Visitor select = new FailAtNodes(leaves);
	Visitor v = new ToGraph(g, logVisitor(select));
	v.visit(n0);
	Logger expectedLogger = new Logger();
	expectedLogger.log(new Event(select,n0));
	expectedLogger.log(new Event(select,n1));
	expectedLogger.log(new Event(select,n1));
	expectedLogger.log(new Event(select,n11));
	expectedLogger.log(new Event(select,n12));
	expectedLogger.log(new Event(select,n2));
	EdgesGraph expected = new EdgesGraph();
	expected.addEdge(n0, n1);
	assertEquals(expected,g);
	assertEquals(expectedLogger,logger);
    }

    public void testMkEdgeFromParent()
      throws VisitFailure {
	EdgesGraph g = new EdgesGraph();
	Visitor v = new MkEdgeFromParent(n0,g);
	v.visit(n1);
	EdgesGraph expectedGraph = new EdgesGraph();
	expectedGraph.addEdge(n0,n1);
	assertEquals(expectedGraph,g);
    }

    public void testMkEdgesToKids()
      throws VisitFailure {
	EdgesGraph g = new EdgesGraph();
	Visitor v = new MkEdgesToKids(g);
	v.visit(n0);
	EdgesGraph expectedGraph = new EdgesGraph();
	expectedGraph.addEdge(n0,n1);
	expectedGraph.addEdge(n0,n2);
	assertEquals(expectedGraph,g);
    }

    public void testMkEdgesToKidsSelective()
      throws VisitFailure {
	EdgesGraph g = new EdgesGraph();
	Visitor v = new MkEdgesToKids(g, new FailAtNodes(n1,n2));
	v.visit(n0);
	EdgesGraph expectedGraph = new EdgesGraph();
	expectedGraph.addEdge(n0,n11);
	expectedGraph.addEdge(n0,n12);
	assertEquals(expectedGraph,g);
    }

}
