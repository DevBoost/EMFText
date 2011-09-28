/*******************************************************************************
 * Copyright (c) 2006-2011
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/

package org.emftext.sdk.concretesyntax.resource.cs.ui;

/**
 * A proposal for completing an incomplete document.
 */
public class CsCompletionProposal implements java.lang.Comparable<CsCompletionProposal> {
	private org.eclipse.emf.ecore.EObject root;
	
	private org.emftext.sdk.concretesyntax.resource.cs.mopp.CsExpectedTerminal expectedTerminal;
	private String insertString;
	private String displayString;
	private String prefix;
	private boolean matchesPrefix;
	private org.eclipse.emf.ecore.EStructuralFeature structuralFeature;
	private org.eclipse.emf.ecore.EObject container;
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
	 * This method create a model that reflects that the state that would be obtained
	 * if this proposal was accepted. This model can differ from the current model,
	 * because different proposals can result in different models. The code that is
	 * passed as argument is executed once the (changed) model was created. After
	 * exectuing the given code, all changes are reverted.
	 */
	public void materialize(Runnable code) {
		if (root == null) {
			code.run();
			return;
		}
		org.eclipse.emf.ecore.change.util.ChangeRecorder recorder = new org.eclipse.emf.ecore.change.util.ChangeRecorder();
		recorder.beginRecording(java.util.Collections.singleton(root));
		
		// attach proposal model fragment to main model
		Runnable attachmentCode = expectedTerminal.getAttachmentCode();
		if (attachmentCode != null) {
			// Applying attachment code
			attachmentCode.run();
		}
		
		org.eclipse.emf.ecore.change.ChangeDescription changes = recorder.endRecording();
		code.run();
		// revert changes
		changes.apply();
	}
	
}
