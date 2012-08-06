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
package org.emftext.sdk.ui.syntaxgenerator.jobs;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.sdk.codegen.generators.IResourceMarker;
import org.emftext.sdk.concretesyntax.resource.cs.ui.CsMarkerHelper;

/**
 * Adds errors and warning contained in the given resource as
 * workspace markers so they appear in the Eclipse problems
 * view.
 */
public class WorkspaceMarker implements IResourceMarker {

	public void mark(Resource resource) throws CoreException {
		CsMarkerHelper.mark(resource);
	}

	public void unmark(Resource resource) throws CoreException {
		CsMarkerHelper.unmark(resource);
	}
}
