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
package org.emftext.sdk.ui.actions;

import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.codegen.ecore.generator.Generator;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenBaseGeneratorAdapter;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsMetaInformation;
import org.emftext.sdk.concretesyntax.resource.cs.ui.CsUIPlugin;
import org.emftext.sdk.ui.jobs.GenerateResourcePluginsJob;

/**
 * The {@link GenerateAllAction} visits the selected elements and all their
 * children to find generator models and concrete syntax definitions. For all
 * found models the respective code generator is invoked (Ecode model code for
 * all generator models and EMFText resource plug-in code for all syntax
 * definitions).
 */
public class GenerateAllAction implements IObjectActionDelegate {

	private ISelection selection;

	public void run(IAction action) {
		if (selection instanceof IStructuredSelection) {
			Iterator<?> it = ((IStructuredSelection) selection).iterator();
            while (it.hasNext()) {
                Object o = it.next();
                if (o instanceof IResource) {
                	IResource resource = (IResource) o;                   
                   	try {
						traverse(resource);
					} catch (CoreException e) {
						CsUIPlugin.logError("Exception while traversing selection", e);
					}
                }
            }
		}
	}

	private void traverse(IResource resource) throws CoreException {
		if (resource instanceof IFile) {
			IFile file = (IFile) resource;
			process(file);
		} else {
			resource.accept(new IResourceVisitor() {
				
				@Override
				public boolean visit(IResource resource) throws CoreException {
					process(resource);
					return true;
				}
			});
		}
	}

	private void process(IResource resource) throws CoreException {
		if (resource instanceof IFile) {
			final IFile file = (IFile) resource;
			String fileExtension = file.getFileExtension();
			Job job = null;
			if (fileExtension == null) {
				return;
			}
			if (fileExtension.equals(new CsMetaInformation().getSyntaxName())) {
				job = new GenerateResourcePluginsJob("Generating resource project for " + file.getName(), file);
			} else if ("genmodel".equals(fileExtension)) {
				job = new Job("Generate metamodel code job") {

					@Override
					protected IStatus run(IProgressMonitor monitor) {
						URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
						ResourceSet rs = new ResourceSetImpl();
						@SuppressWarnings("deprecation")
						Map<URI, URI> platformURIMap = EcorePlugin.computePlatformURIMap();
						rs.getURIConverter().getURIMap().putAll(platformURIMap);
						Resource genModelResource = rs.getResource(uri, true);
						EList<EObject> contents = genModelResource.getContents();
						for (EObject eObject : contents) {
							if (eObject instanceof GenModel) {
								GenModel genModel = (GenModel) eObject;
								genModel.reconcile();
								genModel.setCanGenerate(true);
								Generator generator = new Generator();
								generator.setInput(genModel);
								String type = GenBaseGeneratorAdapter.MODEL_PROJECT_TYPE;
								generator.generate(genModel, type, new BasicMonitor());
							}
						}
						return Status.OK_STATUS;
					}
					
				};
			}
			if (job != null) {
				job.setUser(true);
				job.schedule();
			}
		}
	}
		
	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}

	public void setActivePart(IAction action, IWorkbenchPart part) {
		// do nothing
	}
}
