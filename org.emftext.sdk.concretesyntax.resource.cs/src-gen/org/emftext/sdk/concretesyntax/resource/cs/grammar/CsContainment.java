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

package org.emftext.sdk.concretesyntax.resource.cs.grammar;

public class CsContainment extends org.emftext.sdk.concretesyntax.resource.cs.grammar.CsTerminal {
	
	private final org.eclipse.emf.ecore.EClass[] allowedTypes;
	
	public CsContainment(org.eclipse.emf.ecore.EStructuralFeature feature, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality cardinality, org.eclipse.emf.ecore.EClass[] allowedTypes, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.allowedTypes = allowedTypes;
	}
	
	public org.eclipse.emf.ecore.EClass[] getAllowedTypes() {
		return allowedTypes;
	}
	
	public String toString() {
		return getFeature().getName();
	}
	
}
