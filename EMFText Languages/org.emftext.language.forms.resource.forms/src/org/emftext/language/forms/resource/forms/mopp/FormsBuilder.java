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
package org.emftext.language.forms.resource.forms.mopp;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.emftext.language.forms.resource.forms.IFormsBuilder;
import org.emftext.language.forms.resource.forms.custom.FormsGenerator;

public class FormsBuilder implements IFormsBuilder {

	public IStatus build(FormsResource resource, IProgressMonitor monitor) {
		if (!resource.getErrors().isEmpty()) {
			return org.eclipse.core.runtime.Status.CANCEL_STATUS;
		}
		new FormsGenerator().process(resource.getContents());
		return org.eclipse.core.runtime.Status.OK_STATUS;
	}

	public boolean isBuildingNeeded(URI uri) {
		return true;
	}

	public IStatus handleDeletion(URI uri, IProgressMonitor monitor) {
		return Status.OK_STATUS;
	}
}
