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
package org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp;

public class GeneratorconfigBuilderAdapter extends org.eclipse.core.resources.IncrementalProjectBuilder {

	// the ID of the default, generated builder
	public final static String BUILDER_ID = "org.emftext.sdk.generatorconfig.resource.generatorconfig.builder";

	private org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigBuilder builder = new org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigBuilder();

	public org.eclipse.core.resources.IProject[] build(int kind, java.util.Map args, final org.eclipse.core.runtime.IProgressMonitor monitor) throws org.eclipse.core.runtime.CoreException {
		return build(kind, args, monitor, builder, getProject());
	}

	public org.eclipse.core.resources.IProject[] build(int kind, java.util.Map args, final org.eclipse.core.runtime.IProgressMonitor monitor, final org.emftext.sdk.generatorconfig.resource.generatorconfig.IGeneratorconfigBuilder builder, org.eclipse.core.resources.IProject project) throws org.eclipse.core.runtime.CoreException {
		org.eclipse.core.resources.IResourceDelta delta = getDelta(project);
		if (delta == null) {
			return null;
		}
		delta.accept(new org.eclipse.core.resources.IResourceDeltaVisitor() {
			public boolean visit(org.eclipse.core.resources.IResourceDelta delta) throws org.eclipse.core.runtime.CoreException {
				org.eclipse.core.resources.IResource resource = delta.getResource();
				if (resource instanceof org.eclipse.core.resources.IFile && "generatorconfig".equals(resource.getFileExtension())) {
					org.eclipse.emf.common.util.URI uri = org.eclipse.emf.common.util.URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
					if (builder.isBuildingNeeded(uri)) {
						org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigResource customResource = (org.emftext.sdk.generatorconfig.resource.generatorconfig.mopp.GeneratorconfigResource) new org.eclipse.emf.ecore.resource.impl.ResourceSetImpl().getResource(uri, true);
						builder.build(customResource, monitor);
					}
					return false;
				}
				return true;
			}
		});
		return null;
	}

}
