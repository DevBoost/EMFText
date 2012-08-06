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

import org.eclipse.emf.common.util.URI;
import org.emftext.runtime.resource.IURIMapping;

/**
 * A basic implementation of the IURIMapping interface that can
 * map identifiers to URIs.
 * 
 * @param <ReferenceType> unused type parameter which is needed to implement IURIMapping.
 */
@Deprecated public class URIMapping<ReferenceType> extends AbstractReferenceMapping<ReferenceType> implements IURIMapping<ReferenceType> {
	
	private URI uri;

	public URIMapping(String identifier, URI newIdentifier, String warning) {
		super(identifier, warning);
		this.uri = newIdentifier;
	}

	public URI getTargetIdentifier() {
		return uri;
	}
}
