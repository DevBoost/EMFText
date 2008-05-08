package org.reuseware.emftextedit.resource;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * An extended resource that can hold information about the exact positions 
 * of each element of its content in a text file. This can be used to give
 * more detailed error feedback.
 * 
 * @author Jendrik Johannes (jj2)
 *
 */
public interface TextResource extends Resource {
	
	/**
	 * Used by parsers to set location information.
	 */
	public void setElementLine(EObject element, int line);

	/**
	 * Used by parsers to set location information.
	 */
	public int getElementLine(EObject element);
	
	/**
	 * Used by parsers to set location information.
	 */
	public void setElementColumn(EObject element, int column);
	
	/**
	 * Used by parsers to set location information.
	 */
	public int getElementColumn(EObject element);
	
	/**
	 * Used by parsers to set location information.
	 */
	public void setElementCharStart(EObject element, int charStart);
	
	/**
	 * Used by parsers to set location information.
	 */
	public int getElementCharStart(EObject element);
	
	/**
	 * Used by parsers to set location information.
	 */
	public void setElementCharEnd(EObject element, int charEnd);
	
	/**
	 * Used by parsers to set location information.
	 */
	public int getElementCharEnd(EObject element);
	
	/**
	 * Add an error that should be displayed at the position of the given element.
	 */
	public void addError(String message, EObject element);
	
	/**
	 * Add a warning that should be displayed at the position of the given element.
	 */
	public void addWarning(String message, EObject element);
	
	/**
	 * Add an error to be displayed at the indicated position.
	 */
	public void addError(String message, int column, int line, int charStart, int charEnd);
	
	/**
	 * Add a warning to be displayed at the indicated position.
	 */
	public void addWarning(String message, int column, int line, int charStart, int charEnd);
	
	/**
	 * Helper method to access the names of different tokens that may exist in the underlying text file.
	 * 
	 * @return All token names.
	 */
	public String[] getTokenNames();
	
	/**
	 * Return a scanner capable to split the underlying text file into tokens.
	 * 
	 * @return A scanner.
	 */
	public Object getScanner();
	
	/**
	 * An extended diagnostic that gives access to the exact position of the problem
	 * in a character stream.
	 */
	public interface TextDiagnostic extends Resource.Diagnostic {
		
		/**
		 * @return Position of the first character of the problem area.
		 */
		public int getCharStart();
		
		/**
		 * @return Position of the last character of the problem area.
		 */
		public int getCharEnd();
	}
}
