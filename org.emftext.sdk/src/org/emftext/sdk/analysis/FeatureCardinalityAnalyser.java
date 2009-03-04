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

import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.sdk.concretesyntax.Cardinality;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.STAR;
import org.emftext.sdk.concretesyntax.Terminal;

/**
 * An analyser that checks whether the cardinality of a feature
 * matches the cardinality given in the syntax.
 */
public class FeatureCardinalityAnalyser extends AbstractAnalyser {

	@Override
	public void analyse(ITextResource resource, ConcreteSyntax syntax) {
		TreeIterator<EObject> contents = syntax.eAllContents();
		while (contents.hasNext()) {
			EObject next = contents.next();
			if (next instanceof Terminal) {
				Terminal terminal = (Terminal) next;
				final Cardinality cardinality = terminal.getCardinality();
				if (cardinality != null && cardinality instanceof STAR) { 
					final GenFeature genFeature = terminal.getFeature();
					if (genFeature.getEcoreFeature().getUpperBound() != -1) {
						resource.addError("Multiplicity of feature \"" + genFeature.getName() + "\" does not match cardinality.", terminal);
					}
				}
			}
		}
	}
}
