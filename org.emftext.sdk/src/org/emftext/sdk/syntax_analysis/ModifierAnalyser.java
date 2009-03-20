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
package org.emftext.sdk.syntax_analysis;

import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.concretesyntax.Abstract;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;

/**
 * An analyser that checks whether the modifier ABSTRACT is used
 * correctly.
 */
public class ModifierAnalyser extends AbstractPostProcessor {

	@Override
	public void analyse(ITextResource resource, ConcreteSyntax syntax) {
		List<GenClass> symbols = syntax.getActiveStartSymbols();
		Abstract modifier = syntax.getModifier();
		boolean isDeclaredAbstract = modifier != null;
		if (isDeclaredAbstract) {
			// assert there is no start symbol (not a 
			// declared one and not an imported one)
			if (symbols.size() > 0) {
				resource.addError("Syntax has start symbols (" + getListOfNames(symbols) + "), but is declared abstract.", modifier);
			}
		} else {
			// assert the is at least one start symbol (either a 
			// declared one or an imported one)
			if (symbols.size() == 0) {
				resource.addError("Syntax has no start symbols, but is not declared abstract.", syntax);
			}
		}
	}

	private String getListOfNames(List<GenClass> classes) {
		boolean isFirst = true;
		String listOfNames = "";
		for (GenClass symbol : classes) {
			if (!isFirst) {
				listOfNames += ", ";
			}
			isFirst = false;
			listOfNames += symbol.getName();
		}
		return listOfNames;
	}
}
