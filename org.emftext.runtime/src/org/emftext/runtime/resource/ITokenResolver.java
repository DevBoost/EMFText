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
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * Basic Interface to directly manipulate parsed tokens and convert them into the attribute type in the meta model.
 * All generated TokenResolvers inherit from JavaBasedTokenResolver which does the standard conversion to Java Types.
 * 
 * @see org.emftext.runtime.resource.impl.JavaBasedTokenResolver
 * @see org.emftext.sdk.codegen.TokenResolverGenerator
 * 
 * @author Sven Karol (Sven.Karol@tu-dresden.de)
 */
public interface ITokenResolver extends IConfigurable {
	
	/**
	 * Converts a token into an Object (might be a String again). 
	 * 
	 * @param lexem the parsed String
	 * @param feature the corresponding feature in the meta model
	 * @param result the result of resolving the lexem, can be used to add processing errors
	 */
	public void resolve(String lexem, EStructuralFeature feature, ITokenResolveResult result);
	
	/**
	 * Does the inverse mapping from Object to a lexem which can be printed.
	 * 
	 * @param value the Object to be printed as String
	 * @param feature the corresponding feature
	 * @param container the container of the object
	 * @return the String representation or null if a problem occurred
	 */
	public String deResolve(Object value, EStructuralFeature feature, EObject container);
}
