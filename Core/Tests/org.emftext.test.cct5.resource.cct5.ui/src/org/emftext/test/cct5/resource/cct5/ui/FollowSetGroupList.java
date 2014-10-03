package org.emftext.test.cct5.resource.cct5.ui;

import java.util.ArrayList;
import java.util.List;

import org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectedTerminal;

public class FollowSetGroupList {

	private int lastFollowSetID = -1;
	private List<FollowSetGroup> followSetGroups = new ArrayList<FollowSetGroup>();
	
	public FollowSetGroupList(List<Cct5ExpectedTerminal> expectedTerminals) {
		for (Cct5ExpectedTerminal expectedTerminal : expectedTerminals) {
			addExpectedTerminal(expectedTerminal);
		}
	}
	
	private void addExpectedTerminal(Cct5ExpectedTerminal expectedTerminal) {
		FollowSetGroup group;

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
	
	public List<FollowSetGroup> getFollowSetGroups() {
		return followSetGroups;
	}

	private FollowSetGroup addNewGroup() {
		FollowSetGroup group = new FollowSetGroup();
		followSetGroups.add(group);
		return group;
	}
}
