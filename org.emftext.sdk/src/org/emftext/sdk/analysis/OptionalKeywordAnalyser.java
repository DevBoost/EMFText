/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.analysis;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.sdk.codegen.util.GeneratorUtil;
import org.emftext.sdk.concretesyntax.CompoundDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.CsString;
import org.emftext.sdk.concretesyntax.Definition;
import org.emftext.sdk.concretesyntax.QUESTIONMARK;
import org.emftext.sdk.concretesyntax.STAR;
import org.emftext.sdk.concretesyntax.Sequence;

/**
 * An analyser that looks optional keywords (static strings) in 
 * syntax rules. Such keywords are not reflected in the models 
 * after parsing and are thus lost after printing.
 */
public class OptionalKeywordAnalyser extends AbstractAnalyser {

	private static final String OPTIONAL_KEYWORD_WARNING = 
		"The keyword might be used stand alone and will not be reprinted in such case: ";

	@Override
	public void analyse(ITextResource resource, ConcreteSyntax syntax) {
		for(Iterator<EObject> i = syntax.eAllContents(); i.hasNext(); ) {
			EObject next = i.next();
			if (next instanceof CompoundDefinition) {
				CompoundDefinition compoundDefinition = (CompoundDefinition) next;
				if (compoundDefinition.getCardinality() instanceof QUESTIONMARK ||
						compoundDefinition.getCardinality() instanceof STAR) {
					for (Sequence sequence : compoundDefinition.getDefinitions().getOptions()) {
						boolean containsKeyword = false;
						boolean restOptional = true;
						
						for (Definition definition : sequence.getParts()) {
							
							if (definition instanceof CsString) {
								containsKeyword = true;
							}
							else if (GeneratorUtil.hasNoOptionalPart(definition)) {
								restOptional = false;
							}
						}
						if(containsKeyword && restOptional) {
							for (Definition definition : sequence.getParts()) {
								if (definition instanceof CsString) {
									CsString csString = (CsString) definition;
									resource.addWarning(
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
