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
/**
 * 
 */
package org.emftext.sdk.concretesyntax.resource.cs.mopp;

import java.util.Collection;
import java.util.LinkedHashSet;

import org.emftext.sdk.concretesyntax.resource.cs.CsEProblemType;
import org.emftext.sdk.concretesyntax.resource.cs.ICsProblem;
import org.emftext.sdk.concretesyntax.resource.cs.ICsQuickFix;

public class CsProblem implements ICsProblem {
	
	private String message;
	private ECsProblemType csProblemType;
	private CsEProblemType problemType;
	private Collection<ICsQuickFix> quickFixes;

	public CsProblem(String message, ECsProblemType type) {
		this.message = message;
		this.csProblemType = type;
		this.problemType = csProblemType.getProblemType();
	}

	public CsProblem(String message, ECsProblemType type, ICsQuickFix quickFix) {
		this.message = message;
		this.csProblemType = type;
		this.problemType = csProblemType.getProblemType();
		this.quickFixes = new LinkedHashSet<ICsQuickFix>();
		this.quickFixes.add(quickFix);
	}

	public CsProblem(String message, ECsProblemType type, Collection<ICsQuickFix> quickFixes) {
		this.message = message;
		this.csProblemType = type;
		this.problemType = csProblemType.getProblemType();
		this.quickFixes = new LinkedHashSet<ICsQuickFix>();
		this.quickFixes.addAll(quickFixes);
	}

	public CsProblem(String message, CsEProblemType type) {
		this.message = message;
		this.problemType = type;
	}

	public CsProblem(String message, CsEProblemType type, Collection<ICsQuickFix> quickFixes) {
		this.message = message;
		this.problemType = type;
		this.quickFixes = new LinkedHashSet<ICsQuickFix>();
		this.quickFixes.addAll(quickFixes);
	}

	public CsEProblemType getType() {
		return problemType;
	}

	public ECsProblemType getCsType() {
		return csProblemType;
	}

	public String getMessage() {
		return message;
	}

	public Collection<ICsQuickFix> getQuickFixes() {
		return quickFixes;
	}
}
