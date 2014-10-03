/*******************************************************************************
 * Copyright (c) 2006-2014
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/

package org.emftext.sdk.concretesyntax.resource.cs.mopp;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used when computing code completion proposals hold groups of
 * expected elements which belong to the same follow set.
 */
public class CsFollowSetGroupList {
	
	private int lastFollowSetID = -1;
	private List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsFollowSetGroup> followSetGroups = new ArrayList<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsFollowSetGroup>();
	
	public CsFollowSetGroupList(List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal> expectedTerminals) {
		for (org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal expectedTerminal : expectedTerminals) {
			addExpectedTerminal(expectedTerminal);
		}
	}
	
	private void addExpectedTerminal(org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal expectedTerminal) {
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsFollowSetGroup group;
		
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
	
	public List<org.emftext.sdk.concretesyntax.resource.cs.mopp.CsFollowSetGroup> getFollowSetGroups() {
		return followSetGroups;
	}
	
	private org.emftext.sdk.concretesyntax.resource.cs.mopp.CsFollowSetGroup addNewGroup() {
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsFollowSetGroup group = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsFollowSetGroup();
		followSetGroups.add(group);
		return group;
	}
	
}
