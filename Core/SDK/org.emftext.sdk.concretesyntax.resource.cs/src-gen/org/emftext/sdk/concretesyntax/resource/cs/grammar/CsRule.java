/*******************************************************************************
 * Copyright (c) 2006-2013
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

package org.emftext.sdk.concretesyntax.resource.cs.grammar;

import org.eclipse.emf.ecore.EClass;

/**
 * A class to represent a rules in the grammar.
 */
public class CsRule extends org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSyntaxElement {
	
	private final EClass metaclass;
	
	public CsRule(EClass metaclass, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice choice, org.emftext.sdk.concretesyntax.resource.cs.grammar.CsCardinality cardinality) {
		super(cardinality, new org.emftext.sdk.concretesyntax.resource.cs.grammar.CsSyntaxElement[] {choice});
		this.metaclass = metaclass;
	}
	
	public EClass getMetaclass() {
		return metaclass;
	}
	
	public org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice getDefinition() {
		return (org.emftext.sdk.concretesyntax.resource.cs.grammar.CsChoice) getChildren()[0];
	}
	
}

