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

public class CsProblem implements org.emftext.sdk.concretesyntax.resource.cs.ICsProblem {
	
	private String message;
	private org.emftext.sdk.concretesyntax.resource.cs.CsEProblemType type;
	private org.emftext.sdk.concretesyntax.resource.cs.CsEProblemSeverity severity;
	private java.util.Collection<org.emftext.sdk.concretesyntax.resource.cs.ICsQuickFix> quickFixes;
	
	public CsProblem(String message, org.emftext.sdk.concretesyntax.resource.cs.CsEProblemType type, org.emftext.sdk.concretesyntax.resource.cs.CsEProblemSeverity severity) {
		this(message, type, severity, java.util.Collections.<org.emftext.sdk.concretesyntax.resource.cs.ICsQuickFix>emptySet());
	}
	
	public CsProblem(String message, org.emftext.sdk.concretesyntax.resource.cs.CsEProblemType type, org.emftext.sdk.concretesyntax.resource.cs.CsEProblemSeverity severity, org.emftext.sdk.concretesyntax.resource.cs.ICsQuickFix quickFix) {
		this(message, type, severity, java.util.Collections.singleton(quickFix));
	}
	
	public CsProblem(String message, org.emftext.sdk.concretesyntax.resource.cs.CsEProblemType type, org.emftext.sdk.concretesyntax.resource.cs.CsEProblemSeverity severity, java.util.Collection<org.emftext.sdk.concretesyntax.resource.cs.ICsQuickFix> quickFixes) {
		super();
		this.message = message;
		this.type = type;
		this.severity = severity;
		this.quickFixes = new java.util.LinkedHashSet<org.emftext.sdk.concretesyntax.resource.cs.ICsQuickFix>();
		this.quickFixes.addAll(quickFixes);
	}
	
	public org.emftext.sdk.concretesyntax.resource.cs.CsEProblemType getType() {
		return type;
	}
	
	public org.emftext.sdk.concretesyntax.resource.cs.CsEProblemSeverity getSeverity() {
		return severity;
	}
	
	public String getMessage() {
		return message;
	}
	
	public java.util.Collection<org.emftext.sdk.concretesyntax.resource.cs.ICsQuickFix> getQuickFixes() {
		return quickFixes;
	}
	
}
