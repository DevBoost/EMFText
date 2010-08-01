/*******************************************************************************
 * Copyright (c) 2006-2010 
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

package org.emftext.sdk.concretesyntax.resource.cs.ui;

public class CsMarkerResolutionGenerator implements org.eclipse.ui.IMarkerResolutionGenerator {
	
	public org.eclipse.ui.IMarkerResolution[] getResolutions(org.eclipse.core.resources.IMarker marker) {
		try {
			org.eclipse.core.resources.IResource resource = marker.getResource();
			if (resource instanceof org.eclipse.core.resources.IFile) {
				// load model
				final org.eclipse.core.resources.IFile file = (org.eclipse.core.resources.IFile) resource;
				org.eclipse.emf.common.util.URI uri = org.eclipse.emf.common.util.URI.createPlatformResourceURI(file.getFullPath().toString(), true);
				org.eclipse.emf.ecore.resource.ResourceSet rs = new org.eclipse.emf.ecore.resource.impl.ResourceSetImpl();
				org.eclipse.emf.ecore.resource.Resource emfResource = rs.getResource(uri, true);
				if (emfResource instanceof org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResource) {
					org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResource customResource = (org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResource) emfResource;
					org.eclipse.emf.ecore.util.EcoreUtil.resolveAll(customResource);
					// get data from marker (quick fix type and context object URIs)
					Object sourceIdObject = marker.getAttribute(org.eclipse.core.resources.IMarker.SOURCE_ID);
					String quickFixContext = null;
					if (sourceIdObject instanceof String) {
						quickFixContext = (String) sourceIdObject;
					}
					
					final org.emftext.sdk.concretesyntax.resource.cs.ICsQuickFix quickFix = customResource.getQuickFix(quickFixContext);
					return new org.eclipse.ui.IMarkerResolution[] {
						new org.eclipse.ui.IMarkerResolution() {
							
							public void run(org.eclipse.core.resources.IMarker marker) {
								String newText = quickFix.apply(null);
								// set new text as content for resource
								try {
									file.setContents(new java.io.ByteArrayInputStream(newText.getBytes()), true, true, null);
								} catch (org.eclipse.core.runtime.CoreException e) {
									org.emftext.sdk.concretesyntax.resource.cs.ui.CsUIPlugin.logError("Exception while applying quick fix", e);
								}
							}
							
							public String getLabel() {
								return quickFix.getDisplayString();
							}
						}
					};
				}
			}
		} catch (java.lang.Exception e) {
			org.emftext.sdk.concretesyntax.resource.cs.ui.CsUIPlugin.logError("Exception while applying quick fix", e);
		}
		return new org.eclipse.ui.IMarkerResolution[] {};
		
	}
	
}
