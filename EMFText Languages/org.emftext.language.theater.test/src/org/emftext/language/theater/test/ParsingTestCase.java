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
package org.emftext.language.theater.test;

import java.io.IOException;
import java.util.Collections;

import junit.framework.TestCase;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.theater.resource.theater.mopp.TheaterResourceFactory;

public abstract class ParsingTestCase extends TestCase {

	public ParsingTestCase() {
		super();
	}

	protected Resource parserInputFile(String pathName) throws IOException {
		TheaterResourceFactory factory = new TheaterResourceFactory();
	
		ResourceSet rs = new ResourceSetImpl();
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
				"theater", factory);
	
		Resource resource = rs.createResource(URI
		 		.createFileURI(pathName));
		resource.load(Collections.EMPTY_MAP);
		EcoreUtil.resolveAll(resource);
		return resource;
	}

}
