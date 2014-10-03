package org.emftext.test.cct5.resource.cct5.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.emftext.test.cct5.resource.cct5.mopp.Cct5ExpectedTerminal;

public class FollowSetGroup {

	private List<Cct5ExpectedTerminal> expectedTerminals = new ArrayList<Cct5ExpectedTerminal>();

	public void add(Cct5ExpectedTerminal expectedTerminal) {
		expectedTerminals.add(expectedTerminal);
	}

	public List<Cct5ExpectedTerminal> getExpectedTerminals() {
		return expectedTerminals;
	}

	public int getStartExcludingHiddenTokens() {
		int lastStart = -1;
		for (Cct5ExpectedTerminal expectedTerminal : expectedTerminals) {
			int nextStart = expectedTerminal.getStartExcludingHiddenTokens();
			if (lastStart < 0) {
				lastStart = nextStart;
			} else if (lastStart != nextStart) {
				System.err
						.println("Found terminals in same follow set with different start.");
			}
		}

		return lastStart;
	}

	public EClass getRule() {
		EClass lastRule = null;
		for (Cct5ExpectedTerminal expectedTerminal : expectedTerminals) {
			EClass nextRule = expectedTerminal.getTerminal().getRuleMetaclass();
			if (lastRule == null) {
				lastRule = nextRule;
			} else if (lastRule != nextRule) {
				System.err
						.println("Found terminals in same follow set with different rule.");
			}
		}

		return lastRule;
	}

	public boolean hasSameStartExcludingHiddenTokens(
			int lastStartExcludingHiddenTokens) {
		if (lastStartExcludingHiddenTokens < 0) {
			return false;
		}

		return lastStartExcludingHiddenTokens == getStartExcludingHiddenTokens();
	}

	public boolean hasDifferentRule(EClass lastRule) {
		if (lastRule == null) {
			return true;
		}

		return lastRule != getRule();
	}

	public EObject getContainer() {
		EObject lastContainer = null;
		for (Cct5ExpectedTerminal expectedTerminal : expectedTerminals) {
			EObject nextContainer = expectedTerminal.getContainer();
			if (lastContainer == null) {
				lastContainer = nextContainer;
			} else if (lastContainer != nextContainer) {
				System.err
						.println("Found terminals in same follow set with different container.");
			}
		}

		return lastContainer;
	}

	@Override
	public String toString() {
		return "FollowSetGroup " + expectedTerminals;
	}
}
