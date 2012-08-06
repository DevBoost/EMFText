/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.test.markers;

import org.eclipse.emf.ecore.EObject;
import org.emftext.sdk.concretesyntax.resource.cs.CsEProblemSeverity;
import org.emftext.sdk.concretesyntax.resource.cs.CsEProblemType;
import org.emftext.sdk.concretesyntax.resource.cs.ICsProblem;
import org.emftext.sdk.concretesyntax.resource.cs.ICsTextDiagnostic;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsProblem;

public class DiagnosticMock implements ICsTextDiagnostic {

	private String message;
	private int charStart;
	private int charEnd;
	private int column;
	private int line;
	
	public DiagnosticMock(String message, int charStart, int charEnd,
			int column, int line) {
		super();
		this.message = message;
		this.charStart = charStart;
		this.charEnd = charEnd;
		this.column = column;
		this.line = line;
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public String getLocation() {
		return null;
	}

	@Override
	public int getCharStart() {
		return charStart;
	}

	@Override
	public int getCharEnd() {
		return charEnd;
	}

	@Override
	public int getColumn() {
		return column;
	}

	@Override
	public int getLine() {
		return line;
	}

	@Override
	public ICsProblem getProblem() {
		return new CsProblem("test problem", CsEProblemType.ANALYSIS_PROBLEM, CsEProblemSeverity.ERROR);
	}

	@Override
	public boolean wasCausedBy(EObject element) {
		return false;
	}
}
