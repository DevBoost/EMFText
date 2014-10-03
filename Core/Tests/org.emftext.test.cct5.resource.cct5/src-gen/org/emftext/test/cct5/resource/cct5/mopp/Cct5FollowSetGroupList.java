/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.mopp;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used when computing code completion proposals hold groups of
 * expected elements which belong to the same follow set.
 */
public class Cct5FollowSetGroupList {
	
	private int lastFollowSetID = -1;
	private List<org.emftext.test.cct5.resource.cct5.mopp.Cct5FollowSetGroup> followSetGroups = new ArrayList<org.emftext.test.cct5.resource.cct5.mopp.Cct5FollowSetGroup>();
	
	public Cct5FollowSetGroupList(List<org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectedTerminal> expectedTerminals) {
		for (org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectedTerminal expectedTerminal : expectedTerminals) {
			addExpectedTerminal(expectedTerminal);
		}
	}
	
	private void addExpectedTerminal(org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectedTerminal expectedTerminal) {
		org.emftext.test.cct5.resource.cct5.mopp.Cct5FollowSetGroup group;
		
		int followSetID = expectedTerminal.getFollowSetID();
		if (followSetID == lastFollowSetID) {
			if (followSetGroups.isEmpty()) {
				group = addNewGroup();
			} else {
				group = followSetGroups.get(followSetGroups.size() - 1);
			}
		} else {
			group = addNewGroup();
			lastFollowSetID = followSetID;
		}
		
		group.add(expectedTerminal);
	}
	
	public List<org.emftext.test.cct5.resource.cct5.mopp.Cct5FollowSetGroup> getFollowSetGroups() {
		return followSetGroups;
	}
	
	private org.emftext.test.cct5.resource.cct5.mopp.Cct5FollowSetGroup addNewGroup() {
		org.emftext.test.cct5.resource.cct5.mopp.Cct5FollowSetGroup group = new org.emftext.test.cct5.resource.cct5.mopp.Cct5FollowSetGroup();
		followSetGroups.add(group);
		return group;
	}
	
}
