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
import org.emftext.sdk.concretesyntax.Choice;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;

/**
 * An analyser that looks for explicit choices in the syntax
 * definition. Such choices are not reflected in the models
 * after parsing and can thus cause a result different from
 * the original text after printing.
 */
public class ChoiceAnalyser extends AbstractAnalyser {

	private static final String EXPLICIT_CHOICES_MAY_CAUSE_REPRINT_PROBLEMS = 
		"Explicit syntax choices are not reflected in model instances and may thus cause problem when printing models.";

	@Override
	public void analyse(ITextResource resource, ConcreteSyntax syntax) {
		Iterator<EObject> iterator = syntax.eAllContents();
		while (iterator.hasNext()) {
			EObject next = iterator.next();
			if (next instanceof Choice) {
				Choice choice = (Choice) next;
				if (choice.getOptions().size() > 1) {
					resource.addWarning(
							EXPLICIT_CHOICES_MAY_CAUSE_REPRINT_PROBLEMS,
							choice);
				}
			}
		}
	}

}
