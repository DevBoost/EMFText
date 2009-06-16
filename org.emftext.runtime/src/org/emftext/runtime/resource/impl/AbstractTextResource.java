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
package org.emftext.runtime.resource.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.emftext.runtime.resource.ITextResource;

/**
 * This class is used to adapt existing text resource plug-ins to API
 * changes. For EMFText 1.2.0 is must be empty (except the two constructors). 
 * Future version may add default implementations for new methods that are 
 * added to ITextResource.
 */
public abstract class AbstractTextResource extends ResourceImpl implements ITextResource {
	
	// Attention: Please do add only code that adapts existing implementations of
	// old versions of ITextResource here.
	// Please document the date and version when the API was changed

	public AbstractTextResource() {
		super();
	}

	public AbstractTextResource(URI uri) {
		super(uri);	
	}
}
