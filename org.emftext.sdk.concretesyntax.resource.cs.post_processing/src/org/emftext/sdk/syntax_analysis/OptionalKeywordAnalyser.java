/*******************************************************************************
 * Copyright (c) 2006-2010 
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
package org.emftext.sdk.syntax_analysis;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.concretesyntax.CompoundDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.CsString;
import org.emftext.sdk.concretesyntax.Definition;
import org.emftext.sdk.concretesyntax.QUESTIONMARK;
import org.emftext.sdk.concretesyntax.STAR;
import org.emftext.sdk.concretesyntax.Sequence;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.ECsProblemType;

/**
 * An analyser that looks optional keywords (static strings) in 
 * syntax rules. Such keywords are not reflected in the models 
 * after parsing and are thus lost after printing.
 */
public class OptionalKeywordAnalyser extends AbstractPostProcessor {

	private static final String OPTIONAL_KEYWORD_WARNING = 
		"The keyword might be used stand alone and will not be reprinted in such case: ";
	
	@Override
	public void analyse(ConcreteSyntax syntax) {
		for(Iterator<EObject> i = syntax.eAllContents(); i.hasNext(); ) {
			EObject next = i.next();
			if (next instanceof CompoundDefinition) {
				CompoundDefinition compoundDefinition = (CompoundDefinition) next;
				if (compoundDefinition.getCardinality() instanceof QUESTIONMARK ||
						compoundDefinition.getCardinality() instanceof STAR) {
					for (Sequence sequence : compoundDefinition.getDefinition().getOptions()) {
						boolean containsKeyword = false;
						boolean restOptional = true;
						
						for (Definition definition : sequence.getParts()) {
							
							if (definition instanceof CsString) {
								containsKeyword = true;
							}
							else if (definition.hasNoOptionalPart()) {
								restOptional = false;
							}
						}
						if(containsKeyword && restOptional) {
							for (Definition definition : sequence.getParts()) {
								if (definition instanceof CsString) {
									CsString csString = (CsString) definition;
									addProblem(
											ECsProblemType.OPTIONAL_KEYWORD,
											OPTIONAL_KEYWORD_WARNING + csString.getValue(),
											definition);
								}
							}
						}
					}
				}
			}
		}
	}
}
