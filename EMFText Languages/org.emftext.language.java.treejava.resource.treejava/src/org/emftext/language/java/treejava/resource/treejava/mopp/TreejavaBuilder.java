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
package org.emftext.language.java.treejava.resource.treejava.mopp;

import java.io.IOException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.emftext.language.java.treejava.resource.treejava.ITreejavaBuilder;
import org.emftext.language.java.treejava.resource.treejava.compiler.TreeJavaCompiler;

public class TreejavaBuilder implements ITreejavaBuilder {
	
	public boolean isBuildingNeeded(URI uri) {
		return true;
	}
	
	public IStatus build(TreejavaResource resource, IProgressMonitor monitor) {
		try {
			new TreeJavaCompiler().compile(resource);
			return Status.OK_STATUS;
		} catch (IOException e) {
			return new Status(IStatus.ERROR, TreejavaPlugin.PLUGIN_ID, e.getMessage());
		}
	}

	public IStatus handleDeletion(URI uri, IProgressMonitor monitor) {
		return Status.OK_STATUS;
	}
}
