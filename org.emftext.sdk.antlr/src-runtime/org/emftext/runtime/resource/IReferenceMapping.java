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

/**
 * A mapping from an identifier to something else. The
 * &quot;something else&quot; is defined by subclasses 
 * of this interface. Implementors of such subclasses
 * are used during the process of resolving references,
 * where identifiers need to be mapped to other object.
 * 
 * This interface must not be implemented by clients.
 * 
 * @param <ReferenceType> the type of the reference this mapping points to.
 */
public interface IReferenceMapping<ReferenceType> {
	
	/**
	 * Returns the identifier that is mapped.
	 */
	public String getIdentifier();
	
	/**
	 * A mapping can have a warning attached that contains
	 * additional information (e.g., when the mapping might
	 * be wrong under specific conditions). The warning is 
	 * meant to be presented to the user together with the
	 * mapping result.
	 */
	public String getWarning();
}
