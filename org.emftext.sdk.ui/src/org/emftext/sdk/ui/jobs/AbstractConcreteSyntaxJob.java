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
package org.emftext.sdk.ui.jobs;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

/**
 * An abstract base class for all actions that generate something from
 * a CS specification.
 */
public abstract class AbstractConcreteSyntaxJob extends org.eclipse.core.runtime.jobs.Job {

	public AbstractConcreteSyntaxJob(String name) {
		super(name);
	}

	protected void saveGenModel(File javaFile, GenModel model) throws IOException {
		ResourceSet rs = new ResourceSetImpl();
		Resource resource = rs.createResource(URI.createURI("blah"));
		
		resource.getContents().add(model);
		
		Map<?, ?> options = Collections.EMPTY_MAP;
		OutputStream outputStream = new FileOutputStream(javaFile);
		resource.save(outputStream, options);
		outputStream.close();
	}
}
