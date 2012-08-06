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
package org.emftext.language.webtest.codegen;

import java.io.File;
import java.util.Collections;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.emftext.language.webtest.codegen.files.Generate;
import org.emftext.language.webtest.resource.webtest.IWebtestBuilder;
import org.emftext.language.webtest.resource.webtest.mopp.WebtestBuilderAdapter;
import org.emftext.language.webtest.resource.webtest.mopp.WebtestResource;
import org.emftext.language.webtest.resource.webtest.util.WebtestURIUtil;

public class WebTestBuilder extends IncrementalProjectBuilder implements IWebtestBuilder {

	public IProject[] build(int kind, Map<String, String> args, IProgressMonitor monitor) throws CoreException {
		return new WebtestBuilderAdapter() {
			public IWebtestBuilder getBuilder() {
				return WebTestBuilder.this;
			};
		}.build(kind, args, monitor);
	}

	public boolean isBuildingNeeded(URI uri) {
		return !new WebtestURIUtil().isInBinFolder(uri);
	}

	public IStatus build(WebtestResource resource, IProgressMonitor monitor) {
		Generate generate = new Generate();
		URI uri = resource.getURI();
		IResource wRes = getResourceInWorkspace(uri);
		File targetFolder = getTargetFolder(wRes);
		try {
			generate.initialize(uri, targetFolder, Collections.EMPTY_LIST);
			generate.doGenerate(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Status.OK_STATUS;
	}

	private File getTargetFolder(IResource member) {
		File targetFolder =  new File(member.getRawLocation().toOSString());
		return targetFolder;
	}

	private IResource getResourceInWorkspace(URI model) {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		URI targetURI = model.trimSegments(1);
		String platformString = targetURI.toPlatformString(true);
		IResource member = root.findMember(platformString);
		return member;
	}

	public IStatus handleDeletion(URI uri, IProgressMonitor monitor) {
		return Status.OK_STATUS;
	}
}
