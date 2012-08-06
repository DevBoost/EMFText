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

// A proposal for completing an incomplete document.
public class GeneratorconfigCompletionProposal implements java.lang.Comparable<GeneratorconfigCompletionProposal> {
	private java.lang.String insertString;
	private java.lang.String prefix;
	private boolean startsWithPrefix;
	private boolean structuralFeature;

	public GeneratorconfigCompletionProposal(java.lang.String insertString, java.lang.String prefix, boolean startsWithPrefix, boolean structuralFeature) {
		super();
		this.insertString = insertString;
		this.prefix = prefix;
		this.startsWithPrefix = startsWithPrefix;
		this.structuralFeature = structuralFeature;
	}

	public java.lang.String getInsertString() {
		return insertString;
	}

	public java.lang.String getPrefix() {
		return prefix;
	}

	public boolean getStartsWithPrefix() {
		return startsWithPrefix;
	}

	public boolean isStructuralFeature() {
		return structuralFeature;
	}

	public boolean equals(Object object) {
		if (object instanceof GeneratorconfigCompletionProposal) {
			GeneratorconfigCompletionProposal other = (GeneratorconfigCompletionProposal) object;
			return other.getInsertString().equals(getInsertString());
		}
		return false;
	}

	public int hashCode() {
		return getInsertString().hashCode();
	}

	public int compareTo(GeneratorconfigCompletionProposal object) {
		if (object instanceof GeneratorconfigCompletionProposal) {
			GeneratorconfigCompletionProposal other = (GeneratorconfigCompletionProposal) object;
			// proposals that start with the prefix are preferred over the ones that do not
			int startCompare = (startsWithPrefix ? 1 : 0) - (other.getStartsWithPrefix() ? 1 : 0);
			// if both proposals start with the prefix of both do not the insert string is compared
			return startCompare == 0 ? getInsertString().compareTo(other.getInsertString()) : -startCompare;
		}
		return -1;
	}

}
