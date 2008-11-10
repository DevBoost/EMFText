package org.reuseware.emftextedit.runtime.resource;

import java.io.IOException;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;

/**
 * Converts a tree of <code>EObject</code>s into a plain text.
 * 
 * @author Jendrik Johannes (jj2)
 */
public interface EMFTextPrinter {

    public void setOptions(Map<?,?> options);
    
	/**
	 * Prints the given <code>EObject</code> and its content to some 
	 * underlying output stream.
	 * 
	 * @param element The element to print.
	 * @throws IOException if printing to an underlying stream or device fails. 
	 */
    public void print(EObject element) throws IOException;
}
