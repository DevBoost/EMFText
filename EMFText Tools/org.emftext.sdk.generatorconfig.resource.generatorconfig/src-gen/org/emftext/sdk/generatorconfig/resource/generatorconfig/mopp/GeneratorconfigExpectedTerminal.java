/*******************************************************************************
 * Copyright (c) 2006-2012
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
package org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp;

// A representation for a range in a document where a terminal (i.e.,
// a placeholder or a keyword) is expected.
// The range is expressed using two integers denoting the start of the range
// including hidden tokens (e.g., whitespace) and excluding those token
// (i.e., the part of the document containing the relevant characters).
public class GeneratorconfigExpectedTerminal {

	private int followSetID;
	private org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement terminal;
	private int startIncludingHiddenTokens;
	private int startExcludingHiddenTokens;
	private java.lang.String prefix;
	private org.eclipse.emf.ecore.EStructuralFeature[] containmentTrace;

	public GeneratorconfigExpectedTerminal(org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement terminal, int followSetID, org.eclipse.emf.ecore.EStructuralFeature... containmentTrace) {
		super();
		this.terminal = terminal;
		this.followSetID = followSetID;
		this.containmentTrace = containmentTrace;
	}

	public int getFollowSetID() {
		return followSetID;
	}

	public org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigExpectedElement getTerminal() {
		return terminal;
	}

	public java.lang.String toString() {
		return terminal == null ? "null" : terminal.toString();
	}

	public boolean equals(java.lang.Object o) {
		return this.terminal.equals(((GeneratorconfigExpectedTerminal) o).terminal);
	}

	public void setPosition(int startIncludingHiddenTokens, int startExcludingHiddenTokens) {
		assert startExcludingHiddenTokens <= startExcludingHiddenTokens;
		assert startIncludingHiddenTokens <= startExcludingHiddenTokens;
		this.startIncludingHiddenTokens = startIncludingHiddenTokens;
		this.startExcludingHiddenTokens = startExcludingHiddenTokens;
	}

	public int getStartIncludingHiddenTokens() {
		return startIncludingHiddenTokens;
	}

	public int getStartExcludingHiddenTokens() {
		return startExcludingHiddenTokens;
	}

	public java.lang.String getPrefix() {
		return prefix;
	}

	public void setPrefix(java.lang.String prefix) {
		this.prefix = prefix;
	}

	public org.eclipse.emf.ecore.EStructuralFeature[] getContainmentTrace() {
		return containmentTrace;
	}

}
