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
package org.emftext.sdk.codegen.resource.generators.helpers;

import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.emftext.sdk.concretesyntax.Cardinality;
import org.emftext.sdk.concretesyntax.CardinalityDefinition;
import org.emftext.sdk.concretesyntax.Choice;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.SyntaxElement;
import org.emftext.sdk.concretesyntax.Terminal;

/**
 * A helper class to compute the mandatory occurrences of features in syntax
 * rules.
 */
public class OccurrenceCountHelper {

	public int getMandatoryOccurencesAfter(SyntaxElement syntaxElement, GenFeature feature) {
		Rule rule = syntaxElement.getContainingRule();
		int count = getMandatoryOccurencesAfter(rule, syntaxElement, feature, -1, true);
		return count < 0 ? 0 : count;
	}

	/**
	 * Calculates the number of mandatory occurrences of the given feature in a subtree
	 * of a syntax rule. 
	 * 
	 * @param syntaxElement the root node of the subtree to search in
	 * @param startAt the syntax node where to start the search, all node before this 
	 *                node are ignored
	 * @param feature the feature to search for
	 * @param count the number of occurrences already found, if no occurrence was found
	 *              the value of this parameter is -1
	 * @param mandatory a flag that indicates whether the current subtree is mandatory 
	 *                  or not
	 * @return the mandatory occurrences found in the subtree or -1 if no occurrence was
	 *         found
	 */
	private int getMandatoryOccurencesAfter(
			SyntaxElement syntaxElement, 
			SyntaxElement startAt, 
			GenFeature feature, 
			int count, 
			boolean mandatory) {
		boolean isMandatory = mandatory && isMandatory(syntaxElement);
		if (syntaxElement instanceof Terminal) {
			Terminal terminal = (Terminal) syntaxElement;
			if (terminal.getFeature() == feature) {
				if (count >= 0 && isMandatory) {
					count++;
				}
			}
		}
		// check children
		for (SyntaxElement child : syntaxElement.getChildren()) {
			int childCount = getMandatoryOccurencesAfter(child, startAt, feature, count >= 0 ? 0 : -1, isMandatory);
			if (childCount < 0) {
				// feature was not found yet
			} else {
				// childCount >= 0
				// feature was found in the subtree
				if (count < 0) {
					// but not before
					count = 0;
				}
				if (isMandatory) {
					count += childCount;
				}
			}
			if (syntaxElement instanceof Choice) {
				break;
			}
		}
		if (startAt == syntaxElement) {
			count = 0;
		}
		return count;
	}

	private boolean isMandatory(SyntaxElement element) {
		if (element instanceof CardinalityDefinition) {
			CardinalityDefinition cd = (CardinalityDefinition) element;
			Cardinality cardinality = cd.getCardinality();
			if (cardinality == Cardinality.STAR || cardinality == Cardinality.QUESTIONMARK) {
				return false;
			}
		}
		return true;
	}
}
