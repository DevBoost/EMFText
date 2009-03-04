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

/**
 * A list of constants that contains the keys for some options that
 * are built into EMFText. Generated resource plug-ins do automatically
 * recognize this options and use them if they are configured properly.
 */
public interface IOptions {
	
	/**
	 * The key for the option to provide a stream pre-processor.
	 */
	public String INPUT_STREAM_PREPROCESSOR_PROVIDER = "INPUT_STREAM_PREPROCESSOR_PROVIDER";
	
	/**
	 * The key for the option to provide a resource post-processor.
	 */
	public String RESOURCE_POSTPROCESSOR_PROVIDER = "RESOURCE_POSTPROCESSOR_PROVIDER";
}
