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
package org.emftext.language.office2.resource.office2.mopp;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.emftext.language.office2.OfficeModel;

public class Office2Builder implements org.emftext.language.office2.resource.office2.IOffice2Builder {

	public boolean isBuildingNeeded(org.eclipse.emf.common.util.URI uri) {
		// change this to return true to enable building of all resources
		return true;
	}
	public org.eclipse.core.runtime.IStatus build(org.emftext.language.office2.resource.office2.mopp.Office2Resource resource, org.eclipse.core.runtime.IProgressMonitor monitor) {
		// set option overrideBuilder to 'false' and then perform build here
		((OfficeModel)resource.getEObject("/")).assignToOffice();
		((OfficeModel)resource.getEObject("/")).relocate();
		URI origURI = resource.getURI();
		URI completedURI = origURI.trimFileExtension().appendFileExtension("completed").appendFileExtension(origURI.fileExtension());
		resource.setURI(completedURI);
		try {
			resource.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return org.eclipse.core.runtime.Status.OK_STATUS;
	}

}
