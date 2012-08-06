package jjtraveler;

/**
 * Go down the tree until the condition succeeds
 * on a node -- then apply the descendant action
 * to the children of that node.
 * The search does not recurse in nodes below
 * those that meet the condition.
 * <p>
 * This allows expressions such as
 * Descendant(ProcedureBodyRecognizer, Descendant(SwitchRecognizer, Action))
 * which would apply an Action to all switch statements that in
 * turn are contained within ProceduresBodies.
 * <p>
 * See also the Child combinator.
 * 
 * @author Arie van Deursen; Jun 30, 2003 
 * @version $Id: Descendant.java 12575 2004-02-10 20:31:58Z arie $  
 */
public class Descendant extends DefinedCombinator {
	public Descendant(Visitor condition, Visitor action) {
		setDefinition( 
			new TopDownUntil(condition, new All(action))
		);
	}
}
