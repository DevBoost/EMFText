/*******************************************************************************
 * Copyright (c) 2006-2011
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
package org.emftext.sdk.concretesyntax.resource.cs.postprocessing.syntax_analysis;

import java.util.Collection;

import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.CsString;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsAnalysisProblemType;
import org.emftext.sdk.concretesyntax.resource.cs.postprocessing.AbstractPostProcessor;
import org.emftext.sdk.concretesyntax.resource.cs.util.CsEObjectUtil;

/**
 * A post processor that checks whether the syntax contains empty
 * CsStrings, which are not allowed.
 */
public class CsStringAnalyser extends AbstractPostProcessor {

	@Override
	public void analyse(ConcreteSyntax syntax) {
		Collection<CsString> csStrings = CsEObjectUtil.getObjectsByType(syntax.eAllContents(), ConcretesyntaxPackage.eINSTANCE.getCsString());
		for (CsString csString : csStrings) {
			checkNotEmpty(csString);
		}
	}

	/**
	 * Checks that csString is not empty. If it is, an error is reported.
	 * 
	 * @param resource
	 * @param csString
	 */
	private void checkNotEmpty(CsString csString) {
		final String value = csString.getValue();
		if ("".equals(value)) {
			addProblem(CsAnalysisProblemType.EMPTY_CS_STRING, "Empty strings are not allowed.", csString);
		}
	}
}
