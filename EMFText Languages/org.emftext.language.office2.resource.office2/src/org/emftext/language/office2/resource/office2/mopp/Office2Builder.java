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

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.emftext.language.office2.OfficeModel;
import org.emftext.language.office2.resource.office2.IOffice2Builder;
import org.emftext.language.office2.resource.office2.util.Office2RuntimeUtil;

public class Office2Builder implements IOffice2Builder {

	public boolean isBuildingNeeded(URI uri) {
		// change this to return true to enable building of all resources
		return true;
	}
	
	public IStatus build(Office2Resource resource, IProgressMonitor monitor) {
		OfficeModel officeModel = (OfficeModel) resource.getEObject("/");
		officeModel.assignToOffice();
		officeModel.relocate();
		officeModel.removeUnusedOffices();
		
		URI origURI = resource.getURI();
		URI completedURI = origURI.trimFileExtension().appendFileExtension("completed").appendFileExtension(origURI.fileExtension());
		resource.setURI(completedURI);
		try {
			resource.save(null);
		} catch (IOException e) {
			new Office2RuntimeUtil().logError("IOException while building office2 model.", e);
		}

		return org.eclipse.core.runtime.Status.OK_STATUS;
	}
	
	public IStatus handleDeletion(URI uri, IProgressMonitor monitor) {
		return Status.OK_STATUS;
	}
}
