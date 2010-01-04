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

import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.concretesyntax.Abstract;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResource;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.ECsProblemType;

/**
 * An analyser that checks whether the modifier ABSTRACT is used
 * correctly.
 */
public class ModifierAnalyser extends AbstractPostProcessor {

	@Override
	public void analyse(CsResource resource, ConcreteSyntax syntax) {
		List<GenClass> symbols = syntax.getActiveStartSymbols();
		Abstract modifier = syntax.getModifier();
		boolean isDeclaredAbstract = modifier != null;
		if (isDeclaredAbstract) {
			// assert there is no start symbol (not a 
			// declared one and not an imported one)
			if (symbols.size() > 0) {
				addProblem(resource, ECsProblemType.ABSTRACT_SYNTAX_HAS_START_SYMBOLS, "Syntax has start symbols (" + getListOfNames(symbols) + "), but is declared abstract. Note that these start symbols are thrown away during import.", modifier);
			}
		} else {
			// assert the is at least one start symbol (either a 
			// declared one or an imported one)
			if (symbols.size() == 0) {
				addProblem(resource, ECsProblemType.CONCRETE_SYNTAX_HAS_NO_START_SYMBOLS, "Syntax has no start symbols, but is not declared abstract.", syntax);
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
