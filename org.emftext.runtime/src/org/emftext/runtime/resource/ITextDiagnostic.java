package org.emftext.runtime.resource;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * An extended diagnostic that gives access to the exact position of the problem
 * in a character stream.
 */
public interface ITextDiagnostic extends Resource.Diagnostic {
	
	/**
	 * @return Position of the first character of the problem area.
	 */
	public int getCharStart();
	
	/**
	 * @return Position of the last character of the problem area.
	 */
	public int getCharEnd();

	/**
	 * @return The column of the problem area.
	 */
	public int getColumn();

	/**
	 * @return The line that contains the problem area.
	 */
	public int getLine();
	
	/**
	 * Checks whether the problem was caused by the given element.
	 */
	public boolean wasCausedBy(EObject element);
}