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

package org.emftext.sdk.concretesyntax.resource.cs.ui;

/**
 * A proposal for completing an incomplete document.
 */
public class CsCompletionProposal implements java.lang.Comparable<CsCompletionProposal> {
	
	/**
	 * The root object of the resource for which this proposal was computed.
	 */
	private org.eclipse.emf.ecore.EObject root;
	
	/**
	 * The terminal that was expected at the cursor position.
	 */
	private org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal expectedTerminal;
	
	/**
	 * The string that will be inserted if the user picks this proposal. This string
	 * can differ from 'displayString' because usually only the missing part of the
	 * text is inserted and an existing prefix is kept.
	 */
	private String insertString;
	
	/**
	 * The string that will be shown in the pop-up containing the completion proposals.
	 */
	private String displayString;
	
	/**
	 * The part of the document right before the cursor that belongs to the proposal.
	 * This may for example be a partial name of a cross-referenced element.
	 */
	private String prefix;
	
	/**
	 * A flag that indicates whether this proposal is valid w.r.t. the prefix (i.e.,
	 * the text that has already been typed). We do keep proposals that do not match
	 * the prefix to allow proposal post processors to access these and add valid
	 * proposals even if the built-in proposal engine did not find a matching
	 * proposal. The completion pop-up will only show proposals for which this method
	 * returns true. See also {@link #getMatchesPrefix()}.
	 */
	private boolean matchesPrefix;
	
	/**
	 * The structural feature (attribute or non-containment reference) that was
	 * expected at the cursor position.
	 */
	private org.eclipse.emf.ecore.EStructuralFeature structuralFeature;
	
	/**
	 * The container objects that covers the cursor position. This container object
	 * may not be contained in the resource we're computing proposals for. See {@link
	 * #materialize(Runnable)} for an explanation of this.
	 */
	private org.eclipse.emf.ecore.EObject container;
	
	/**
	 * The image that will be shown in the pop-up containing the completion proposals.
	 */
	private org.eclipse.swt.graphics.Image image;
	
	public CsCompletionProposal(org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal expectedTerminal, String insertString, String prefix, boolean matchesPrefix, org.eclipse.emf.ecore.EStructuralFeature structuralFeature, org.eclipse.emf.ecore.EObject container) {
		super();
		this.expectedTerminal = expectedTerminal;
		this.insertString = insertString;
		this.prefix = prefix;
		this.matchesPrefix = matchesPrefix;
		this.structuralFeature = structuralFeature;
		this.container = container;
	}
	
	public CsCompletionProposal(org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal expectedTerminal, String insertString, String prefix, boolean matchesPrefix, org.eclipse.emf.ecore.EStructuralFeature structuralFeature, org.eclipse.emf.ecore.EObject container, org.eclipse.swt.graphics.Image image) {
		this(expectedTerminal, insertString, prefix, matchesPrefix, structuralFeature, container);
		this.image = image;
	}
	
	public CsCompletionProposal(org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal expectedTerminal, String insertString, String prefix, boolean matchesPrefix, org.eclipse.emf.ecore.EStructuralFeature structuralFeature, org.eclipse.emf.ecore.EObject container, org.eclipse.swt.graphics.Image image, String displayString) {
		this(expectedTerminal, insertString, prefix, matchesPrefix, structuralFeature, container, image);
		this.displayString = displayString;
	}
	
	public org.eclipse.emf.ecore.EObject getRoot() {
		return root;
	}
	
	public void setRoot(org.eclipse.emf.ecore.EObject root) {
		this.root = root;
	}
	
	public String getInsertString() {
		return insertString;
	}
	
	public String getDisplayString() {
		return displayString;
	}
	
	public String getPrefix() {
		return prefix;
	}
	
	/**
	 * Returns true if this proposal matched the prefix. This does not imply that the
	 * proposal exactly starts with the prefix, it can also match case-insensitive or
	 * using the camel case style. Only proposals that return true will be considered
	 * for the final list of proposals that is presented in the editor.
	 */
	public boolean getMatchesPrefix() {
		return matchesPrefix;
	}
	
	public org.eclipse.swt.graphics.Image getImage() {
		return image;
	}
	
	public boolean isStructuralFeature() {
		return structuralFeature != null;
	}
	
	public org.eclipse.emf.ecore.EStructuralFeature getStructuralFeature() {
		return structuralFeature;
	}
	
	public org.eclipse.emf.ecore.EObject getContainer() {
		return container;
	}
	
	public org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal getExpectedTerminal() {
		return expectedTerminal;
	}
	
	public boolean equals(Object object) {
		if (object instanceof CsCompletionProposal) {
			CsCompletionProposal other = (CsCompletionProposal) object;
			return other.getInsertString().equals(getInsertString());
		}
		return false;
	}
	
	public int hashCode() {
		return getInsertString().hashCode();
	}
	
	public int compareTo(CsCompletionProposal object) {
		if (object instanceof CsCompletionProposal) {
			CsCompletionProposal other = (CsCompletionProposal) object;
			// proposals that start with the prefix are preferred over the ones that do not
			int startCompare = (matchesPrefix ? 1 : 0) - (other.getMatchesPrefix() ? 1 : 0);
			// if both proposals start with the prefix of both do not the insert string is
			// compared
			return startCompare == 0 ? getInsertString().compareTo(other.getInsertString()) : -startCompare;
		}
		return -1;
	}
	
	public String toString() {
		String result = (container == null ? "null" : container.eClass().getName()) + ".";
		result += (structuralFeature == null ? "null" : structuralFeature.getName());
		result += ": " + insertString;
		return result;
	}
	
	/**
	 * This method creates a model that reflects the state that would be obtained if
	 * this proposal was accepted. This model can differ from the current model,
	 * because different proposals can result in different models. The code that is
	 * passed as argument is executed once the (changed) model was created. After
	 * executing the given code, all changes are reverted.
	 */
	public void materialize(Runnable code) {
		expectedTerminal.materialize(code);
	}
	
}
