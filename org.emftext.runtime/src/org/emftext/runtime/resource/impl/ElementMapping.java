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

import org.emftext.runtime.resource.IElementMapping;

/**
 * A basic implementation of the IElementMapping interface.
 * 
 * @param <ReferenceType> the type of the reference that can be mapped to
 * 
 * @deprecated This class will be removed for release 1.3 of EMFText
 */
public class ElementMapping<ReferenceType> extends AbstractReferenceMapping<ReferenceType> implements IElementMapping<ReferenceType> {
	
	private final ReferenceType target;
	
	public ElementMapping(String identifier, ReferenceType target, String warning) {
		super(identifier, warning);
		this.target = target;
	}

	public ReferenceType getTargetElement() {
		return target;
	}
}
