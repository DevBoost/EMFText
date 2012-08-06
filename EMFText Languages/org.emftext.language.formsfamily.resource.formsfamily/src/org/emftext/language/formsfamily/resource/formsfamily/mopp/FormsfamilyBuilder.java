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
package org.emftext.language.formsfamily.resource.formsfamily.mopp;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.emftext.language.formsfamily.resource.formsfamily.IFormsfamilyBuilder;

public class FormsfamilyBuilder implements IFormsfamilyBuilder {
	
	public boolean isBuildingNeeded(URI uri) {
		// change this to return true to enable building of all resources
		return false;
	}
	
	public IStatus build(FormsfamilyResource resource, IProgressMonitor monitor) {
		// set option overrideBuilder to 'false' and then perform build here
		return Status.OK_STATUS;
	}

	public IStatus handleDeletion(URI uri, IProgressMonitor monitor) {
		return Status.OK_STATUS;
	}
}
