package jjtraveler;


/**
 * An implementation of the <code>Visitable</code> interface for
 * testing purposes.
 */

public class Node implements jjtraveler.Visitable {

    Node[] kids;
    int nodeID;

    static int nodeCounter = 0;

    /**
     * Create a new node with given kids. Each created node will have
     * a different nodeID.
     */
    public static Node factory(Node[] kids) {
	Node result = new Node(kids, nodeCounter);
	nodeCounter++;
	return result;
    }

    public static void reset() {
	nodeCounter = 0;
    }

    public Node(Node[] kids, int nodeID) {
	this.kids = kids;
	this.nodeID = nodeID;
    }

    public Node() {
	this.kids = new Node[]{};
	this.nodeID = nodeCounter++;
    }

    public Node(Node[] kids) {
	this.kids = kids;
	this.nodeID = nodeCounter++;
    }

    public Node accept(NodeVisitor v) throws jjtraveler.VisitFailure {
	return v.visitNode(this);
    }

    public int getChildCount() {
	return kids.length;
    }
    
    public jjtraveler.Visitable getChildAt(int i) {
	return kids[i];
    }
    
    public jjtraveler.Visitable setChildAt(int i, jjtraveler.Visitable child) {
	kids[i] = (Node) child;
	return this;
    }

    public String toString() {
	return "Node-" + nodeID;
    }
}
