/*******************************************************************************
 * Copyright (c) 2006-2014
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

package org.emftext.sdk.concretesyntax.resource.cs.mopp;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.URI;

public class CsBuilder implements org.emftext.sdk.concretesyntax.resource.cs.ICsBuilder {
	
	public boolean isBuildingNeeded(URI uri) {
		// Change this to return true to enable building of all resources.
		return false;
	}
	
	public IStatus build(org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResource resource, IProgressMonitor monitor) {
		// Set option 'overrideBuilder' to 'false' and then perform build here.
		
		// We use one tick from the parent monitor because the BuilderAdapter reserves one
		// tick for the Builder.
		SubProgressMonitor subMonitor = new SubProgressMonitor(monitor, 1);
		subMonitor.beginTask("Building " + resource.getURI().lastSegment(), 10);
		// The actual work of the builder can be performed here.
		subMonitor.worked(10);
		subMonitor.done();
		return Status.OK_STATUS;
	}
	
	/**
	 * Handles the deletion of the given resource.
	 */
	public IStatus handleDeletion(URI uri, IProgressMonitor monitor) {
		// by default nothing is done when a resource is deleted
		return Status.OK_STATUS;
	}
	
}
