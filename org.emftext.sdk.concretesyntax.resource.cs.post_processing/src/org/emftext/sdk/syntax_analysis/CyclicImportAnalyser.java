/*******************************************************************************
 * Copyright (c) 2006-2009 
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

import java.util.ArrayList;
import java.util.Collection;

import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Import;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResource;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.ECsProblemType;

public class CyclicImportAnalyser extends AbstractPostProcessor {

	private static final String CYCLIC_SYNTAX_IMPORT_IS_NOT_ALLOWED = 
		"The syntax %s is imported cyclic.";

	@Override
	public void analyse(CsResource resource, ConcreteSyntax syntax) {
		Collection<Import> cyclicImports = findCyclicImports(syntax);
		for (Import cyclicImport : cyclicImports) {
			addProblem(
					resource,
					ECsProblemType.CYCLIC_SYNTAX_IMPORT,
					String.format(CYCLIC_SYNTAX_IMPORT_IS_NOT_ALLOWED, cyclicImport.getConcreteSyntax().getName()),
					cyclicImport);
			// remove the cyclic import to avoid stack overflow errors once
			// the model is used
			((ConcreteSyntax) cyclicImport.eContainer()).getImports().remove(cyclicImport);
		}
	}


	@Override
	protected boolean doResolveProxiesBeforeAnalysis() {
		// we can not resolve proxies before, because the resolving
		// triggers stack overflows cyclic imports
		return false;
	}

	private Collection<Import> findCyclicImports(ConcreteSyntax syntax) {
		final ArrayList<String> initialList = new ArrayList<String>();
		initialList.add(syntax.getName());
		return findCyclicImports(syntax, initialList);
	}
	
	private Collection<Import> findCyclicImports(ConcreteSyntax syntax, Collection<String> foundSyntaxes) {
		Collection<Import> cyclicImports = new ArrayList<Import>();
		for (Import nextImport : syntax.getImports()) {
			ConcreteSyntax importedSyntax = nextImport.getConcreteSyntax();
			if (importedSyntax == null) {
				continue;
			}
			if (foundSyntaxes.contains(importedSyntax.getName())) {
				cyclicImports.add(nextImport);
			} else {
				cyclicImports.addAll(findCyclicImports(importedSyntax, foundSyntaxes));
			}
		}
		return cyclicImports;
	}
}
