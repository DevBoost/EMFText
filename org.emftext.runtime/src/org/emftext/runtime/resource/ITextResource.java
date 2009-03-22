/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.runtime.resource;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * An extended resource that can hold information about the exact positions 
 * of each element of its content in a text file. This can be used to give
 * more detailed error feedback.
 * 
 * @author Jendrik Johannes <jendrik.johannes@tu-dresden.de>
 *
 */
public interface ITextResource extends Resource {
	
	/**
	 * Returns a map containing information about the location of model
	 * elements in the text.
	 * 
	 * @return the model element to text location mapping
	 */
	public ILocationMap getLocationMap();
	
	/**
	 * Returns the reference resolver switch used by this resource. 
	 * The switch can be used to resolve references after the resource 
	 * has been loaded.
	 * 
	 * @return the resolver switch
	 */
	public IReferenceResolverSwitch getReferenceResolverSwitch();
	
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
	 * Internal method used by the parser to register a context dependent proxy object for later resolution.
	 * 
	 * @param container
	 * @param reference
	 * @param pos
	 * @param id
	 * @param proxyElement
	 */
	public <ContainerType extends EObject, ReferenceType extends EObject> void registerContextDependentProxy(org.emftext.runtime.resource.IContextDependentURIFragmentFactory<ContainerType, ReferenceType> factory, ContainerType container, org.eclipse.emf.ecore.EReference reference, java.lang.String id, org.eclipse.emf.ecore.EObject proxyElement);

	/**
	 * Return the default style that should be used to present tokens of the
	 * given type.
	 *  
	 * @param tokenName the name of the token type
	 * @return a style object or null if not default style is set
	 */
	public ITokenStyle getDefaultTokenStyle(String tokenName);
}
