/*******************************************************************************
 * Copyright (c) 2006-2011
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
package org.emftext.sdk.finders;

import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.sdk.concretesyntax.Import;

/**
 * IConcreteSyntaxFinder is an interface for finders that can locate concrete
 * syntax definitions.
 */
public interface IConcreteSyntaxFinder {
	
	/**
	 * Searches for a syntax definition with the given URI.
	 * 
	 * @param csURI the URI to look for
	 * @param resource the resource that triggered the search
	 * @return
	 */
	public IConcreteSyntaxFinderResult findConcreteSyntax(String csURI, String locationHint,  Import container, Resource resource);
}
