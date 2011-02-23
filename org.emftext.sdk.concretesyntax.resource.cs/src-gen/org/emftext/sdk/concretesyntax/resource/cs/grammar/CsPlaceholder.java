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

/**
 * A class to represent placeholders in a grammar.
 */
public class CsPlaceholder extends org.emftext.sdk.concretesyntax.resource.cs.grammar.CsTerminal {
	
	private final String tokenName;
	
	public CsPlaceholder(org.eclipse.emf.ecore.EStructuralFeature feature, String tokenName, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality cardinality, int mandatoryOccurencesAfter) {
		super(feature, cardinality, mandatoryOccurencesAfter);
		this.tokenName = tokenName;
	}
	
	public String getTokenName() {
		return tokenName;
	}
	
}
