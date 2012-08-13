/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.access.resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * An extended resource that can hold information about the exact positions 
 * of each element of its content in a text file. This can be used to give
 * more detailed error feedback.
 */
public interface IResource extends Resource {
	
	/**
	 * Try to load the content of this resource from the given stream. If
	 * loading fails, the state of this resource is kept. If loading is 
	 * successful, the content of this resource is replaced with the new
	 * content.
	 * This method can be used to try loading erroneous files, as e.g., 
	 * needed during background parsing in the editor.
	 * 
	 * @param stream the stream to read from
	 * @param options the load options to use
	 * @throws IOException thrown if the stream can not be read
	 */
	public void reload(InputStream stream, Map<?,?> options) throws IOException;
	
	/**
	 * Try to cancel a current reload of this resource. It is not guaranteed
	 * that canceling is successful. If this resource has already finished
	 * parsing the new content, it will replace its content unconditionally.
	 * 
	 * As of version 1.4.2 of EMFText this method is not available anymore.
	 */
	@Deprecated
	public void cancelReload();
	
	/**
	 * Returns a map containing information about the location of model
	 * elements in the text.
	 * 
	 * @return the model element to text location mapping
	 */
	public ILocationMap getLocationMap();

	/**
	 * Adds a new error to this resource.
	 * 
	 * @param message
	 * @param cause
	 */
	public void addError(String message, EObject cause);

	/**
	 * Adds a new warning to this resource.
	 * 
	 * @param message
	 * @param cause
	 */
	public void addWarning(String message, EObject cause);
}
