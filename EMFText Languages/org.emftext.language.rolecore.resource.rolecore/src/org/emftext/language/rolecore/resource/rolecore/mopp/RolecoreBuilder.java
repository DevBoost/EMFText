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
/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.rolecore.resource.rolecore.mopp;

import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;

public class RolecoreBuilder implements org.emftext.language.rolecore.resource.rolecore.IRolecoreBuilder {
	
	public org.eclipse.core.runtime.IStatus build(org.emftext.language.rolecore.resource.rolecore.mopp.RolecoreResource resource, org.eclipse.core.runtime.IProgressMonitor monitor) {
		//RolecoreCompiler compiler = new RolecoreCompiler();
		//return compiler.process(resource.getContents());
		return Status.OK_STATUS;
	}

	public boolean isBuildingNeeded(URI uri) {
		return true;
	}
}
