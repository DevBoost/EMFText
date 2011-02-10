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
package org.emftext.sdk.concretesyntax.resource.cs.mopp;

import java.util.Collection;

import org.emftext.sdk.concretesyntax.resource.cs.CsEProblemType;
import org.emftext.sdk.concretesyntax.resource.cs.ICsQuickFix;

public class CsAnalysisProblem extends CsProblem {

	private CsAnalysisProblemType analysisProblemType;

	public CsAnalysisProblem(String message, CsAnalysisProblemType type) {
		super(message, CsEProblemType.ANALYSIS_PROBLEM, type.getProblemSeverity());
		this.analysisProblemType = type;
	}

	public CsAnalysisProblem(String message, CsAnalysisProblemType type,
			ICsQuickFix quickFix) {
		super(message, CsEProblemType.ANALYSIS_PROBLEM, type.getProblemSeverity(), quickFix);
		this.analysisProblemType = type;
	}

	public CsAnalysisProblem(String message, CsAnalysisProblemType type,
			Collection<ICsQuickFix> quickFixes) {
		super(message, CsEProblemType.ANALYSIS_PROBLEM, type.getProblemSeverity(), quickFixes);
		this.analysisProblemType = type;
	}

	public CsAnalysisProblemType getAnalysisProblemType() {
		return analysisProblemType;
	}
}
