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

import java.util.Map;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

public class CsBuilderAdapter extends IncrementalProjectBuilder implements IResourceDeltaVisitor, IResourceVisitor {
	
	/**
	 * The ID of the default, generated builder.
	 */
	public final static String BUILDER_ID = "org.emftext.sdk.concretesyntax.resource.cs.builder";
	
	private org.emftext.sdk.concretesyntax.resource.cs.ICsBuilder defaultBuilder = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsBuilder();
	
	/**
	 * This resource set is used during the whole build.
	 */
	private ResourceSet resourceSet;
	
	/**
	 * This monitor is used during the build.
	 */
	private IProgressMonitor monitor;
	
	public IProject[] build(int kind, Map<String, String> args, final IProgressMonitor monitor) throws CoreException {
		// Set context for build
		this.monitor = monitor;
		this.resourceSet = new ResourceSetImpl();
		// Perform build by calling the resource visitors
		IResourceDelta delta = getDelta(getProject());
		if (delta != null) {
			// This is an incremental build
			delta.accept(this);
		} else {
			// This is a full build
			getProject().accept(this);
		}
		// Reset build context
		this.resourceSet = null;
		this.monitor = null;
		return null;
	}
	
	public void build(IFile resource, ResourceSet resourceSet, IProgressMonitor monitor) {
		URI uri = URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
		org.emftext.sdk.concretesyntax.resource.cs.ICsBuilder builder = getBuilder();
		if (builder.isBuildingNeeded(uri)) {
			org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResource customResource = (org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResource) resourceSet.getResource(uri, true);
			new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMarkerHelper().removeAllMarkers(resource, getBuilderMarkerId());
			builder.build(customResource, monitor);
		}
	}
	
	/**
	 * Returns the builder that shall be used by this adapter. This allows subclasses
	 * to perform builds with different builders.
	 */
	public org.emftext.sdk.concretesyntax.resource.cs.ICsBuilder getBuilder() {
		return defaultBuilder;
	}
	
	/**
	 * Returns the id for the markers that are created by this builder. This allows
	 * subclasses to produce different kinds of markers.
	 */
	public String getBuilderMarkerId() {
		return new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMarkerHelper().getMarkerID(org.emftext.sdk.concretesyntax.resource.cs.CsEProblemType.BUILDER_ERROR);
	}
	
	/**
	 * Runs the task item builder to search for new task items in changed resources.
	 */
	public void runTaskItemBuilder(IFile resource, ResourceSet resourceSet, IProgressMonitor monitor) {
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTaskItemBuilder taskItemBuilder = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTaskItemBuilder();
		new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMarkerHelper().removeAllMarkers(resource, taskItemBuilder.getBuilderMarkerId());
		taskItemBuilder.build(resource, resourceSet, monitor);
	}
	
	public boolean visit(IResourceDelta delta) throws CoreException {
		IResource resource = delta.getResource();
		return doVisit(resource, delta.getKind() == IResourceDelta.REMOVED);
	}
	
	public boolean visit(IResource resource) throws CoreException {
		return doVisit(resource, false);
	}
	
	protected boolean doVisit(IResource resource, boolean removed) throws CoreException {
		if (removed) {
			URI uri = URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
			org.emftext.sdk.concretesyntax.resource.cs.ICsBuilder builder = getBuilder();
			if (builder.isBuildingNeeded(uri)) {
				builder.handleDeletion(uri, monitor);
			}
			new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMarkerHelper().removeAllMarkers(resource, getBuilderMarkerId());
			return false;
		}
		if (resource instanceof IFile && resource.getName().endsWith("." + new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMetaInformation().getSyntaxName())) {
			// Calling the default generated builder is disabled because of syntax option
			// 'disableBuilder'.
			// Second, call the task item builder that searches for task items in DSL
			// documents and creates task markers.
			runTaskItemBuilder((IFile) resource, resourceSet, monitor);
			return false;
		}
		return true;
	}
	
}
