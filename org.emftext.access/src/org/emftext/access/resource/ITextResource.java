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
package org.emftext.access.resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;

/**
 * An extended resource that can hold information about the exact positions 
 * of each element of its content in a text file. This can be used to give
 * more detailed error feedback.
 */
public interface ITextResource extends Resource {
	
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
	 */
	public void cancelReload();
	
	/**
	 * Returns a map containing information about the location of model
	 * elements in the text.
	 * 
	 * @return the model element to text location mapping
	 */
	public ILocationMap getLocationMap();
	
}
