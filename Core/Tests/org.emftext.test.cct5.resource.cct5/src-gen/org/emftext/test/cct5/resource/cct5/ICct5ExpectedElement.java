/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5;

import java.util.Collection;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;

/**
 * An element that is expected at a given position in a resource stream.
 */
public interface ICct5ExpectedElement {
	
	/**
	 * Returns the names of all tokens that are expected at the given position.
	 */
	public Set<String> getTokenNames();
	
	/**
	 * Returns the metaclass of the rule that contains the expected element.
	 */
	public EClass getRuleMetaclass();
	
	/**
	 * Returns the syntax element that is expected.
	 */
	public org.emftext.test.cct5.resource.cct5.grammar.Cct5SyntaxElement getSyntaxElement();
	
	/**
	 * Adds an element that is a valid follower for this element.
	 */
	public void addFollower(org.emftext.test.cct5.resource.cct5.ICct5ExpectedElement follower, org.emftext.test.cct5.resource.cct5.mopp.Cct5ContainedFeature[] path);
	
	/**
	 * Returns all valid followers for this element. Each follower is represented by a
	 * pair of an expected elements and the containment trace that leads from the
	 * current element to the follower.
	 */
	public Collection<org.emftext.test.cct5.resource.cct5.util.Cct5Pair<org.emftext.test.cct5.resource.cct5.ICct5ExpectedElement, org.emftext.test.cct5.resource.cct5.mopp.Cct5ContainedFeature[]>> getFollowers();
	
}
