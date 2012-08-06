package jjtraveler;

/**
 * Visitor that checks whether the condition succeeds
 * for the current node, and subsequently applies
 * the action to all immediate children. 
 * Its typical use is to create a conditional path
 * towards a particular node to which the given
 * action is applied.
 * <p>
 * The child combinator allows one to specify paths
 * downward a tree.
 * Child(A, Child(B, Child(C, Action)))
 * matches a path A.B.C and applies Action to the immediate
 * children of C.
 * <p>
 * See also the Descendant combinator.
 * 
 * @author Arie van Deursen; Jul 8, 2003 
 * @version $Id: Child.java 15767 2005-04-08 12:25:57Z kooiker $  
 */
public class Child extends DefinedCombinator {

 	/**
 	 * @param condition Visitor that determines if the action
 	 * 		  should be applied.
	 * @param childAction Visitor to be applied to immediate children.
	 */
	public Child(Visitor condition, Visitor childAction) {
  		setDefinition(
 			new IfThenElse(
 					condition,
 					new All(childAction)
 				)
 			);
 	}
}
