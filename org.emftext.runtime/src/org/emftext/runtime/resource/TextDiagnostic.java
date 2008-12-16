package org.emftext.runtime.resource;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * An extended diagnostic that gives access to the exact position of the problem
 * in a character stream.
 */
public interface TextDiagnostic extends Resource.Diagnostic {
	
	public enum TextDiagnosticType {
		RESOLVE_PROBLEM
	}
	
	/**
	 * @return Position of the first character of the problem area.
	 */
	public int getCharStart();
	
	/**
	 * @return Position of the last character of the problem area.
	 */
	public int getCharEnd();

	public int getColumn();
	public int getLine();
	
	public boolean wasCausedBy(EObject element);
	
	public TextDiagnosticType getType();
}