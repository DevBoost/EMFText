package org.emftext.runtime.resource;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.runtime.resource.TextDiagnostic.TextDiagnosticType;

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
	 * Used during {@link #load(java.util.Map)} to determine whether OCL
	 * constraints should be validated.
	 */
	public static final String OPTION_NO_VALIDATE = "TR_NO_VALIDATE_OCL"; 

	/**
	 * Returns a map containing information about the location of model
	 * elements in the text.
	 * 
	 * @return the model element to text location mapping
	 */
	public LocationMap getLocationMap();
	
	/**
	 * Returns the tree analyser used by this resource. The analyser
	 * can be used to resolve references after the resource has been
	 * loaded.
	 * 
	 * @return the tree analyser
	 */
	public EMFTextTreeAnalyser getTreeAnalyser();
	
	/**
	 * Add an error that should be displayed at the position of the given element.
	 */
	public void addError(String message, EObject element);
	public void addError(String message, EObject element, TextDiagnosticType type);
	
	/**
	 * Add a warning that should be displayed at the position of the given element.
	 */
	public void addWarning(String message, EObject element);
	public void addWarning(String message, EObject element, TextDiagnosticType type);
	
	/**
	 * Add an error to be displayed at the indicated position.
	 */
	public void addError(String message, int column, int line, int charStart, int charEnd);
	public void addError(String message, int column, int line, int charStart, int charEnd, TextDiagnosticType type);
	
	/**
	 * Add a warning to be displayed at the indicated position.
	 */
	public void addWarning(String message, int column, int line, int charStart, int charEnd);
	public void addWarning(String message, int column, int line, int charStart, int charEnd, TextDiagnosticType type);
	
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
}
