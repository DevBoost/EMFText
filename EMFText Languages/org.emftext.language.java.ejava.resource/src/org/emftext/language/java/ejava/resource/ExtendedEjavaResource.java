/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.language.java.ejava.resource;

import org.eclipse.emf.common.util.URI;
import org.emftext.language.java.ejava.resource.ejava.mopp.EjavaResource;

/**
 * Extension of generate resource implementation that prints all operations into
 * the corresponding EAnnotation each time the model is loaded.
 */
//TODO jjohannes: is this still needed?
public class ExtendedEjavaResource extends EjavaResource {

	public ExtendedEjavaResource(URI uri) {
		super(uri);
	}
}
