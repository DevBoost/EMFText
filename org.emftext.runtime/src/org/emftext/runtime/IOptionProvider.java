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

import java.util.Map;

/**
 * Implementors of this interface can provide options that
 * are used when resources are loaded.
 *
 */
public interface IOptionProvider {
	
	/**
	 * The name of the attribute of the default_load_options
	 * extension point that specifies to which resources an
	 * option provider applies.
	 */
	public static final String CS_NAME = "csName";

	/**
	 * Returns a map of options. The keys are the names of the
	 * options, the values are arbitrary object that provide
	 * additional information or logic for the option.
	 */
	public Map<?,?> getOptions();
}
