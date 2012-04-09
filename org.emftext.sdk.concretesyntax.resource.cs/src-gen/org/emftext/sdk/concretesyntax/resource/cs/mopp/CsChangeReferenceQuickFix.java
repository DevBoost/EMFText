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
package org.emftext.sdk.concretesyntax.resource.cs.mopp;

/**
 * A quick fix that replaces the target of a reference with another EObject. This
 * class is used to implement default quick fixes for references that could not be
 * resolved, but can also be used by custom reference resolvers.
 */
public class CsChangeReferenceQuickFix extends org.emftext.sdk.concretesyntax.resource.cs.mopp.CsQuickFix {
	
	private org.eclipse.emf.ecore.EObject container;
	private org.eclipse.emf.ecore.EReference reference;
	private org.eclipse.emf.ecore.EObject oldTarget;
	private org.eclipse.emf.ecore.EObject newTarget;
	
	public CsChangeReferenceQuickFix(String displayString, String imageKey, org.eclipse.emf.ecore.EObject container, org.eclipse.emf.ecore.EReference reference, org.eclipse.emf.ecore.EObject oldTarget, org.eclipse.emf.ecore.EObject newTarget) {
		super(displayString, imageKey, java.util.Arrays.asList(container, reference, oldTarget));
		this.container = container;
		this.reference = reference;
		this.oldTarget = oldTarget;
		this.newTarget = newTarget;
	}
	
	@Override	
	public void applyChanges() {
		org.eclipse.emf.ecore.util.EcoreUtil.replace(container, reference, oldTarget, newTarget);
	}
	
}
