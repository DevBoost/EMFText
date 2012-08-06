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

package org.emftext.language.java.ejava.resource.ejava.mopp;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

public class EjavaBuilderAdapter extends org.eclipse.core.resources.IncrementalProjectBuilder implements org.eclipse.core.resources.IResourceDeltaVisitor, org.eclipse.core.resources.IResourceVisitor {
	
	/**
	 * The ID of the default, generated builder.
	 */
	public final static String BUILDER_ID = "org.emftext.language.java.ejava.resource.ejava.builder";
	
	private org.emftext.language.java.ejava.resource.ejava.IEjavaBuilder defaultBuilder = new org.emftext.language.java.ejava.resource.ejava.mopp.EjavaBuilder();
	
	/**
	 * This resource set is used during the whole build.
	 */
	//private org.eclipse.emf.ecore.resource.ResourceSet resourceSet;
	
	/**
	 * This monitor is used during the build.
	 */
	private org.eclipse.core.runtime.IProgressMonitor monitor;
	
	public org.eclipse.core.resources.IProject[] build(int kind, java.util.Map<String, String> args, final org.eclipse.core.runtime.IProgressMonitor monitor) throws org.eclipse.core.runtime.CoreException {
		// Set context for build
		this.monitor = monitor;
		//this.resourceSet = new org.eclipse.emf.ecore.resource.impl.ResourceSetImpl();
		// Perform build by calling the resource visitors
		org.eclipse.core.resources.IResourceDelta delta = getDelta(getProject());
		if (delta != null) {
			// This is an incremental build
			delta.accept(this);
		} else {
			// This is a full build
			getProject().accept(this);
		}
		// Reset build context
		//this.resourceSet = null;
		this.monitor = null;
		return null;
	}
	
	public void build(org.eclipse.core.resources.IFile resource, org.eclipse.emf.ecore.resource.ResourceSet resourceSet, org.eclipse.core.runtime.IProgressMonitor monitor) {
		org.eclipse.emf.common.util.URI uri = org.eclipse.emf.common.util.URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
		org.emftext.language.java.ejava.resource.ejava.IEjavaBuilder builder = getBuilder();
		if (builder.isBuildingNeeded(uri)) {
			org.emftext.language.java.ejava.resource.ejava.mopp.EjavaResource customResource = (org.emftext.language.java.ejava.resource.ejava.mopp.EjavaResource) resourceSet.getResource(uri, true);
			new org.emftext.language.java.ejava.resource.ejava.mopp.EjavaMarkerHelper().removeAllMarkers(resource, getBuilderMarkerId());
			builder.build(customResource, monitor);
		}
	}
	
	/**
	 * Returns the builder that shall be used by this adapter. This allows subclasses
	 * to perform builds with different builders.
	 */
	public org.emftext.language.java.ejava.resource.ejava.IEjavaBuilder getBuilder() {
		return defaultBuilder;
	}
	
	/**
	 * Returns the id for the markers that are created by this builder. This allows
	 * subclasses to produce different kinds of markers.
	 */
	public String getBuilderMarkerId() {
		return new org.emftext.language.java.ejava.resource.ejava.mopp.EjavaMarkerHelper().getMarkerID(org.emftext.language.java.ejava.resource.ejava.EjavaEProblemType.BUILDER_ERROR);
	}
	
	/**
	 * Runs the task item builder to search for new task items in changed resources.
	 */
	public void runTaskItemBuilder(org.eclipse.core.resources.IFile resource, org.eclipse.emf.ecore.resource.ResourceSet resourceSet, org.eclipse.core.runtime.IProgressMonitor monitor) {
		org.emftext.language.java.ejava.resource.ejava.mopp.EjavaTaskItemBuilder taskItemBuilder = new org.emftext.language.java.ejava.resource.ejava.mopp.EjavaTaskItemBuilder();
		new org.emftext.language.java.ejava.resource.ejava.mopp.EjavaMarkerHelper().removeAllMarkers(resource, taskItemBuilder.getBuilderMarkerId());
		taskItemBuilder.build(resource, resourceSet, monitor);
	}
	
	@Override	
	public boolean visit(org.eclipse.core.resources.IResourceDelta delta) throws org.eclipse.core.runtime.CoreException {
		org.eclipse.core.resources.IResource resource = delta.getResource();
		return doVisit(resource, delta.getKind() == org.eclipse.core.resources.IResourceDelta.REMOVED);
	}
	
	@Override	
	public boolean visit(org.eclipse.core.resources.IResource resource) throws org.eclipse.core.runtime.CoreException {
		return doVisit(resource, false);
	}
	
	protected boolean doVisit(org.eclipse.core.resources.IResource resource, boolean removed) throws org.eclipse.core.runtime.CoreException {
		if (removed) {
			org.eclipse.emf.common.util.URI uri = org.eclipse.emf.common.util.URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
			org.emftext.language.java.ejava.resource.ejava.IEjavaBuilder builder = getBuilder();
			if (builder.isBuildingNeeded(uri)) {
				builder.handleDeletion(uri, monitor);
			}
			new org.emftext.language.java.ejava.resource.ejava.mopp.EjavaMarkerHelper().removeAllMarkers(resource, getBuilderMarkerId());
			return false;
		}
		if (resource instanceof org.eclipse.core.resources.IFile && resource.getName().endsWith("." + new org.emftext.language.java.ejava.resource.ejava.mopp.EjavaMetaInformation().getSyntaxName())) {
			// First, call the default generated builder that is usually customized to add
			// compilation-like behavior.
			
			//=== CHANGED: eJava's wrapper mechanism needs one resource set per resource!
			ResourceSet resourceLocatResourceResourceSet = new ResourceSetImpl();
			build((org.eclipse.core.resources.IFile) resource, resourceLocatResourceResourceSet, monitor);
			runTaskItemBuilder((org.eclipse.core.resources.IFile) resource, resourceLocatResourceResourceSet, monitor);
			//====
			
			return false;
		}
		return true;
	}
	
}
