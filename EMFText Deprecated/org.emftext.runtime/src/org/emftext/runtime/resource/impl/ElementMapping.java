/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.runtime.resource.impl;

import org.emftext.runtime.resource.IElementMapping;

/**
 * A basic implementation of the IElementMapping interface.
 * 
 * @param <ReferenceType> the type of the reference that can be mapped to
 */
@Deprecated public class ElementMapping<ReferenceType> extends AbstractReferenceMapping<ReferenceType> implements IElementMapping<ReferenceType> {
	
	private final ReferenceType target;
	
	public ElementMapping(String identifier, ReferenceType target, String warning) {
		super(identifier, warning);
		this.target = target;
	}

	public ReferenceType getTargetElement() {
		return target;
	}
}
