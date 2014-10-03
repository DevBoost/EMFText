/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.mopp;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;

public class Cct5Problem implements org.emftext.test.cct5.resource.cct5.ICct5Problem {
	
	private String message;
	private org.emftext.test.cct5.resource.cct5.Cct5EProblemType type;
	private org.emftext.test.cct5.resource.cct5.Cct5EProblemSeverity severity;
	private Collection<org.emftext.test.cct5.resource.cct5.ICct5QuickFix> quickFixes;
	
	public Cct5Problem(String message, org.emftext.test.cct5.resource.cct5.Cct5EProblemType type, org.emftext.test.cct5.resource.cct5.Cct5EProblemSeverity severity) {
		this(message, type, severity, Collections.<org.emftext.test.cct5.resource.cct5.ICct5QuickFix>emptySet());
	}
	
	public Cct5Problem(String message, org.emftext.test.cct5.resource.cct5.Cct5EProblemType type, org.emftext.test.cct5.resource.cct5.Cct5EProblemSeverity severity, org.emftext.test.cct5.resource.cct5.ICct5QuickFix quickFix) {
		this(message, type, severity, Collections.singleton(quickFix));
	}
	
	public Cct5Problem(String message, org.emftext.test.cct5.resource.cct5.Cct5EProblemType type, org.emftext.test.cct5.resource.cct5.Cct5EProblemSeverity severity, Collection<org.emftext.test.cct5.resource.cct5.ICct5QuickFix> quickFixes) {
		super();
		this.message = message;
		this.type = type;
		this.severity = severity;
		this.quickFixes = new LinkedHashSet<org.emftext.test.cct5.resource.cct5.ICct5QuickFix>();
		this.quickFixes.addAll(quickFixes);
	}
	
	public org.emftext.test.cct5.resource.cct5.Cct5EProblemType getType() {
		return type;
	}
	
	public org.emftext.test.cct5.resource.cct5.Cct5EProblemSeverity getSeverity() {
		return severity;
	}
	
	public String getMessage() {
		return message;
	}
	
	public Collection<org.emftext.test.cct5.resource.cct5.ICct5QuickFix> getQuickFixes() {
		return quickFixes;
	}
	
}
