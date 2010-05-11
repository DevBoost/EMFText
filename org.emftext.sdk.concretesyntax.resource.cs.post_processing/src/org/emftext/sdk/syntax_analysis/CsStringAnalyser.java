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

import java.util.Collection;

import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.CsString;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResource;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.ECsProblemType;
import org.emftext.sdk.concretesyntax.resource.cs.util.CsEObjectUtil;
import org.emftext.sdk.util.Pair;
import org.emftext.sdk.util.StringUtil;

/**
 * A post processor that checks whether the syntax contains empty
 * CsStrings or CsString containing invalid escape sequences, 
 * which are not allowed.
 */
public class CsStringAnalyser extends AbstractPostProcessor {

	@Override
	public void analyse(CsResource resource, ConcreteSyntax syntax) {
		Collection<CsString> csStrings = CsEObjectUtil.getObjectsByType(syntax.eAllContents(), ConcretesyntaxPackage.eINSTANCE.getCsString());
		for (CsString csString : csStrings) {
			checkNotEmpty(resource, csString);
			checkForInvalidEscapes(resource, csString);
		}
	}

	/**
	 * Checks that csString is not empty. If it is, an error is reported.
	 * 
	 * @param resource
	 * @param csString
	 */
	private void checkNotEmpty(CsResource resource, CsString csString) {
		final String value = csString.getValue();
		if ("".equals(value)) {
			addProblem(resource, ECsProblemType.EMPTY_CS_STRING, "Empty strings are not allowed.", csString);
		}
	}

	/**
	 * Checks that csString does not contain invalid escape sequences. 
	 * If it does, an error is reported.
	 * 
	 * An example for an invalid escape sequence is '\e', because there
	 * is not special character \e.
	 * 
	 * @param resource
	 * @param csString
	 */
	private void checkForInvalidEscapes(CsResource resource, CsString csString) {
		Pair<String, Boolean> result = StringUtil.escapeToANTLRKeywordComplex(csString.getValue());
		if (result.getRight()) {
			// found invalid escape sequence
			addProblem(resource, ECsProblemType.INVALID_ESCAPE_IN_CS_STRING, "Invalid escape sequence detected.", csString);
		}
	}
}
