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
import org.emftext.sdk.codegen.util.GeneratorUtil;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Rule;

/**
 * The StartSymbolAnalyser checks that all start symbols have syntax.
 */
public class StartSymbolAnalyser extends AbstractPostProcessor {
	
	private final static GeneratorUtil generatorUtil = new GeneratorUtil();

	@Override
	public void analyse(ITextResource resource, ConcreteSyntax syntax) {
		List<GenClass> startSymbols = syntax.getActiveStartSymbols();
		for (GenClass nextStartSymbol : startSymbols) {
			Rule rule = generatorUtil.getRule(syntax, nextStartSymbol);
			if (rule == null) {
				resource.addError("Meta class " + nextStartSymbol.getName() + " has no syntax and can therefore not be used as start element.", syntax);
			}
		}
	}
}
