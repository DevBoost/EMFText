/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/

package org.emftext.sdk.concretesyntax.resource.cs.mopp;

public class CsBuilderAdapter extends org.eclipse.core.resources.IncrementalProjectBuilder {
	
	/**
	 * The ID of the default, generated builder.
	 */
	public final static String BUILDER_ID = "org.emftext.sdk.concretesyntax.resource.cs.builder";
	
	private org.emftext.sdk.concretesyntax.resource.cs.ICsBuilder defaultBuilder = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsBuilder();
	
	public org.eclipse.core.resources.IProject[] build(int kind, java.util.Map<String, String> args, final org.eclipse.core.runtime.IProgressMonitor monitor) throws org.eclipse.core.runtime.CoreException {
		org.eclipse.core.resources.IResourceDelta delta = getDelta(getProject());
		if (delta == null) {
			return null;
		}
		final org.eclipse.emf.ecore.resource.ResourceSet resourceSet = new org.eclipse.emf.ecore.resource.impl.ResourceSetImpl();
		delta.accept(new org.eclipse.core.resources.IResourceDeltaVisitor() {
			public boolean visit(org.eclipse.core.resources.IResourceDelta delta) throws org.eclipse.core.runtime.CoreException {
				org.eclipse.core.resources.IResource resource = delta.getResource();
				if (delta.getKind() == org.eclipse.core.resources.IResourceDelta.REMOVED) {
					org.eclipse.emf.common.util.URI uri = org.eclipse.emf.common.util.URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
					org.emftext.sdk.concretesyntax.resource.cs.ICsBuilder builder = getBuilder();
					if (builder.isBuildingNeeded(uri)) {
						builder.handleDeletion(uri, monitor);
					}
					new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMarkerHelper().removeAllMarkers(resource, getBuilderMarkerId());
					return false;
				}
				if (resource instanceof org.eclipse.core.resources.IFile && resource.getName().endsWith("." + new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMetaInformation().getSyntaxName())) {
					// Calling the default generated builder is disabled because of syntax option
					// 'disableBuilder'.
					// Second, call the task item builder that searches for task items in DSL
					// documents and creates task markers.
					runTaskItemBuilder((org.eclipse.core.resources.IFile) resource, resourceSet, monitor);
					return false;
				}
				return true;
			}
		});
		return null;
	}
	
	public void build(org.eclipse.core.resources.IFile resource, org.eclipse.emf.ecore.resource.ResourceSet resourceSet, org.eclipse.core.runtime.IProgressMonitor monitor) {
		org.eclipse.emf.common.util.URI uri = org.eclipse.emf.common.util.URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
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
	public void runTaskItemBuilder(org.eclipse.core.resources.IFile resource, org.eclipse.emf.ecore.resource.ResourceSet resourceSet, org.eclipse.core.runtime.IProgressMonitor monitor) {
		org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTaskItemBuilder taskItemBuilder = new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsTaskItemBuilder();
		new org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMarkerHelper().removeAllMarkers(resource, taskItemBuilder.getBuilderMarkerId());
		taskItemBuilder.build(resource, resourceSet, monitor);
	}
	
}
