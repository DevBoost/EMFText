package jjtraveler;

public class NestingDepthTest extends VisitorTestCase {

    public NestingDepthTest(String test) {
        super(test);
    }

    public void testDepth2() {
        Visitor recognize = new SucceedAtNodes(n1, n12);
        NestingDepth nd = new NestingDepth(recognize);
        nd.visit(n0);
        assertEquals(2, nd.getDepth());
    }

    public void testDepth1() {
        Visitor recognize = new SucceedAtNodes(n1);
        NestingDepth nd = new NestingDepth(recognize);
        nd.visit(n0);
        assertEquals(1, nd.getDepth());
    }

    public void testDepth11() {
        Visitor recognize = new SucceedAtNodes(n1, n2);
        NestingDepth nd = new NestingDepth(recognize);
        nd.visit(n0);
        assertEquals(1, nd.getDepth());
    }

    public void testNestingStopAt() {
        Visitor recognize = new FailAtNodes(n1, n12);
        Visitor goOnWhile = new SucceedAtNodes(n0, n1);
        NestingDepth nd = new NestingDepth(recognize, goOnWhile);
        nd.visit(n0);
        assertEquals(1, nd.getDepth());
    }
}
