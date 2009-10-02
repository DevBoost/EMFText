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
package org.emftext.runtime;

import java.io.InputStream;

/**
 * Implementors of this interface can provide InputStreamProcessors. These
 * processors can be used to pre-process input stream before a text resource
 * is actually lexed and parsed. This can be for example useful to do an 
 * encoding conversion.
 * 
 * TODO use EMF's load option Resource.OPTION_CIPHER instead
 */
public interface IInputStreamProcessorProvider {
	
	/**
	 * Return a processor for the given input stream.
	 * 
	 * @param inputStream the actual stream that provides the content of a resource
	 * @return a processor that pre-processes the input stream
	 */
	public InputStreamProcessor getInputStreamProcessor(InputStream inputStream);
}
