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

package org.emftext.sdk.concretesyntax.resource.cs.mopp;

/**
 * Helper class to add markers to text files based on EMF's
 * <code>org.eclipse.emf.ecore.resource.Resource.Diagnostic</code>. If a resource
 * contains
 * <code>org.emftext.sdk.concretesyntax.resource.cs.ICsTextDiagnostic</code>s it
 * uses the more precise information of this extended diagnostic type.
 */
public class CsMarkerHelper {
	
	/**
	 * The extension id of the custom marker type that is used by this text resource.
	 */
	public static final String MARKER_TYPE = org.emftext.sdk.concretesyntax.resource.cs.mopp.CsPlugin.PLUGIN_ID + ".problem";
	
	/**
	 * The total number of markers per file is restricted with this constant.
	 * Restriction is needed because the performance of Eclipse decreases drastically
	 * if large amounts of markers are added to files.
	 */
	public static int MAXIMUM_MARKERS = 500;
	
	/**
	 * We use a queue to aggregate commands that create or remove markers. This is
	 * basically for performance reasons. Without the queue we would need to create a
	 * job for each marker creation/removal, which creates tons of threads and takes
	 * very long time.
	 */
	private final static MarkerCommandQueue COMMAND_QUEUE = new MarkerCommandQueue();
	
	private static class MarkerCommandQueue {
		
		private java.util.List<org.emftext.sdk.concretesyntax.resource.cs.ICsCommand<Object>> commands = new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.ICsCommand<Object>>();
		
		public void addCommand(org.emftext.sdk.concretesyntax.resource.cs.ICsCommand<Object> command) {
			synchronized(commands) {
				commands.add(command);
				// we only need to schedule a job, if the queue was empty
				if (commands.size() == 1) {
					scheduleRunCommandsJob();
				}
			}
		}
		
		private void scheduleRunCommandsJob() {
			new org.eclipse.core.runtime.jobs.Job("updating markers") {
				@Override				
				protected org.eclipse.core.runtime.IStatus run(org.eclipse.core.runtime.IProgressMonitor monitor) {
					java.util.List<org.emftext.sdk.concretesyntax.resource.cs.ICsCommand<Object>> commandsToProcess = new java.util.ArrayList<org.emftext.sdk.concretesyntax.resource.cs.ICsCommand<Object>>();
					synchronized(commands) {
						commandsToProcess.addAll(commands);
						commands.clear();
					}
					for (org.emftext.sdk.concretesyntax.resource.cs.ICsCommand<Object> command : commandsToProcess) {
						command.execute(null);
					}
					return org.eclipse.core.runtime.Status.OK_STATUS;
				}
			}.schedule();
		}
		
	}
	
	/**
	 * Marks a file with markers.
	 * 
	 * @param resource The resource that is the file to mark.
	 * @param diagnostic The diagnostic with information for the marker.
	 */
	public static void mark(org.eclipse.emf.ecore.resource.Resource resource, final org.emftext.sdk.concretesyntax.resource.cs.ICsTextDiagnostic diagnostic) {
		if (resource == null || !org.eclipse.core.runtime.Platform.isRunning()) {
			return;
		}
		String platformString = resource.getURI().toPlatformString(true);
		if (platformString == null) {
			return;
		}
		final org.eclipse.core.resources.IFile file = (org.eclipse.core.resources.IFile) org.eclipse.core.resources.ResourcesPlugin.getWorkspace().getRoot().findMember(platformString);
		// URI might not point at a platform file
		if (file == null) {
			return;
		}
		createMarkerFromDiagnostic(file, diagnostic);
	}
	
	private static void createMarkerFromDiagnostic(final org.eclipse.core.resources.IFile file, final org.emftext.sdk.concretesyntax.resource.cs.ICsTextDiagnostic diagnostic) {
		final org.emftext.sdk.concretesyntax.resource.cs.ICsProblem problem = diagnostic.getProblem();
		org.emftext.sdk.concretesyntax.resource.cs.CsEProblemType problemType = problem.getType();
		final String markerID = getMarkerID(problemType);
		COMMAND_QUEUE.addCommand(new org.emftext.sdk.concretesyntax.resource.cs.ICsCommand<Object>() {
			public boolean execute(Object context) {
				try {
					// if there are too many markers, we do not add new ones
					if (file.findMarkers(markerID, false, org.eclipse.core.resources.IResource.DEPTH_ZERO).length >= MAXIMUM_MARKERS) {
						return true;
					}
					
					org.eclipse.core.resources.IMarker marker = file.createMarker(markerID);
					if (problem.getSeverity() == org.emftext.sdk.concretesyntax.resource.cs.CsEProblemSeverity.ERROR) {
						marker.setAttribute(org.eclipse.core.resources.IMarker.SEVERITY, org.eclipse.core.resources.IMarker.SEVERITY_ERROR);
					} else {
						marker.setAttribute(org.eclipse.core.resources.IMarker.SEVERITY, org.eclipse.core.resources.IMarker.SEVERITY_WARNING);
					}
					marker.setAttribute(org.eclipse.core.resources.IMarker.MESSAGE, diagnostic.getMessage());
					org.emftext.sdk.concretesyntax.resource.cs.ICsTextDiagnostic textDiagnostic = (org.emftext.sdk.concretesyntax.resource.cs.ICsTextDiagnostic) diagnostic;
					marker.setAttribute(org.eclipse.core.resources.IMarker.LINE_NUMBER, textDiagnostic.getLine());
					marker.setAttribute(org.eclipse.core.resources.IMarker.CHAR_START, textDiagnostic.getCharStart());
					marker.setAttribute(org.eclipse.core.resources.IMarker.CHAR_END, textDiagnostic.getCharEnd() + 1);
					if (diagnostic instanceof org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResource.ElementBasedTextDiagnostic) {
						org.eclipse.emf.ecore.EObject element = ((org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResource.ElementBasedTextDiagnostic) diagnostic).getElement();
						if (element != null) {
							org.eclipse.emf.ecore.resource.Resource eResource = element.eResource();
							if (eResource != null) {
								marker.setAttribute(org.eclipse.emf.ecore.util.EcoreValidator.URI_ATTRIBUTE, eResource.getURI().toString() + "#" + eResource.getURIFragment(element));
							}
						}
					}
					java.util.Collection<org.emftext.sdk.concretesyntax.resource.cs.ICsQuickFix> quickFixes = textDiagnostic.getProblem().getQuickFixes();
					java.util.Collection<Object> sourceIDs = new java.util.ArrayList<Object>();
					if (quickFixes != null) {
						for (org.emftext.sdk.concretesyntax.resource.cs.ICsQuickFix quickFix : quickFixes) {
							if (quickFix != null) {
								sourceIDs.add(quickFix.getContextAsString());
							}
						}
					}
					if (!sourceIDs.isEmpty()) {
						marker.setAttribute(org.eclipse.core.resources.IMarker.SOURCE_ID, org.emftext.sdk.concretesyntax.resource.cs.util.CsStringUtil.explode(sourceIDs, "|"));
					}
				} catch (org.eclipse.core.runtime.CoreException ce) {
					if (ce.getMessage().matches("Marker.*not found.")) {
						// ignore
					} else {
						org.emftext.sdk.concretesyntax.resource.cs.mopp.CsPlugin.logError("Error while creating marks for resource:", ce);
					}
				}
				return true;
			}
		});
	}
	
	/**
	 * Removes all markers from a given resource.
	 * 
	 * @param resource The resource where to delete markers from
	 */
	public static void unmark(org.eclipse.emf.ecore.resource.Resource resource, org.emftext.sdk.concretesyntax.resource.cs.CsEProblemType problemType) {
		if (resource == null || !org.eclipse.core.runtime.Platform.isRunning()) {
			return;
		}
		String platformString = resource.getURI().toPlatformString(true);
		if (platformString == null) {
			return;
		}
		final org.eclipse.core.resources.IFile file = (org.eclipse.core.resources.IFile) org.eclipse.core.resources.ResourcesPlugin.getWorkspace().getRoot().findMember(platformString);
		if (file == null) {
			return;
		}
		final String markerType = getMarkerID(problemType);
		COMMAND_QUEUE.addCommand(new org.emftext.sdk.concretesyntax.resource.cs.ICsCommand<Object>() {
			public boolean execute(Object context) {
				try {
					file.deleteMarkers(markerType, false, org.eclipse.core.resources.IResource.DEPTH_ZERO);
				} catch (org.eclipse.core.runtime.CoreException ce) {
					if (ce.getMessage().matches("Marker.*not found.")) {
						// ignore
					} else {
						org.emftext.sdk.concretesyntax.resource.cs.mopp.CsPlugin.logError("Error while removing markers from resource:", ce);
					}
				}
				return true;
			}
		});
	}
	
	private static String getMarkerID(org.emftext.sdk.concretesyntax.resource.cs.CsEProblemType problemType) {
		String markerID = MARKER_TYPE;
		String typeID = problemType.getID();
		if (!"".equals(typeID)) {
			markerID += "." + typeID;
		}
		return markerID;
	}
	
}
