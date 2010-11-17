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
