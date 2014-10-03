/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5;

import java.io.IOException;
import org.eclipse.emf.ecore.EObject;

/**
 * Converts a tree of <code>EObject</code>s into a plain text.
 */
public interface ICct5TextPrinter extends org.emftext.test.cct5.resource.cct5.ICct5Configurable {
	
	/**
	 * <p>
	 * Prints the given <code>EObject</code> and its content to the underlying output
	 * stream that was passed to this printer upon creation.
	 * </p>
	 * 
	 * @param element The element to print.
	 * 
	 * @throws IOException if printing to the underlying stream or device fails.
	 */
	public void print(EObject element) throws IOException;
	
	/**
	 * Sets the encoding used for printing.
	 */
	public void setEncoding(String encoding);
	
}
