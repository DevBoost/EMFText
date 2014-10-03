/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.mopp;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;

/**
 * Abstract super class for all expected elements. Provides methods to add
 * followers.
 */
public abstract class Cct5AbstractExpectedElement implements org.emftext.test.cct5.resource.cct5.ICct5ExpectedElement {
	
	private EClass ruleMetaclass;
	
	private Set<org.emftext.test.cct5.resource.cct5.util.Cct5Pair<org.emftext.test.cct5.resource.cct5.ICct5ExpectedElement, org.emftext.test.cct5.resource.cct5.mopp.Cct5ContainedFeature[]>> followers = new LinkedHashSet<org.emftext.test.cct5.resource.cct5.util.Cct5Pair<org.emftext.test.cct5.resource.cct5.ICct5ExpectedElement, org.emftext.test.cct5.resource.cct5.mopp.Cct5ContainedFeature[]>>();
	
	public Cct5AbstractExpectedElement(EClass ruleMetaclass) {
		super();
		this.ruleMetaclass = ruleMetaclass;
	}
	
	public EClass getRuleMetaclass() {
		return ruleMetaclass;
	}
	
	public void addFollower(org.emftext.test.cct5.resource.cct5.ICct5ExpectedElement follower, org.emftext.test.cct5.resource.cct5.mopp.Cct5ContainedFeature[] path) {
		followers.add(new org.emftext.test.cct5.resource.cct5.util.Cct5Pair<org.emftext.test.cct5.resource.cct5.ICct5ExpectedElement, org.emftext.test.cct5.resource.cct5.mopp.Cct5ContainedFeature[]>(follower, path));
	}
	
	public Collection<org.emftext.test.cct5.resource.cct5.util.Cct5Pair<org.emftext.test.cct5.resource.cct5.ICct5ExpectedElement, org.emftext.test.cct5.resource.cct5.mopp.Cct5ContainedFeature[]>> getFollowers() {
		return followers;
	}
	
}
