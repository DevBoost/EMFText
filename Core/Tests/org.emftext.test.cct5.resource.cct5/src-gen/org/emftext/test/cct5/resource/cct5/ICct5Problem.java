/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5;

import java.util.Collection;

public interface ICct5Problem {
	public String getMessage();
	public org.emftext.test.cct5.resource.cct5.Cct5EProblemSeverity getSeverity();
	public org.emftext.test.cct5.resource.cct5.Cct5EProblemType getType();
	public Collection<org.emftext.test.cct5.resource.cct5.ICct5QuickFix> getQuickFixes();
}
