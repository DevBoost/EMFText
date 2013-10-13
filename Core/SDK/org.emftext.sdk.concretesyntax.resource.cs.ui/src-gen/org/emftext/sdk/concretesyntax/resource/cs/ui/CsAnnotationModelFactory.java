/*******************************************************************************
 * Copyright (c) 2006-2013
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

package org.emftext.sdk.concretesyntax.resource.cs.ui;

import org.eclipse.core.filebuffers.IAnnotationModelFactory;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.text.source.IAnnotationModel;

public class CsAnnotationModelFactory implements IAnnotationModelFactory {
	
	public IAnnotationModel createAnnotationModel(IPath location) {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot root = workspace.getRoot();
		IResource resource = root.findMember(location);
		return new org.emftext.sdk.concretesyntax.resource.cs.ui.CsAnnotationModel(resource);
	}
	
}
