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
package org.emftext.language.mecore.resource.mecore.mopp;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreValidator;
import org.emftext.language.mecore.MPackage;
import org.emftext.language.mecore.resource.mecore.IMecoreBuilder;
import org.emftext.language.mecore.resource.mecore.MecoreEProblemType;

/**
 * The MecoreBuilder is invoked when .mecore files are saved. It converts the
 * MEcore models to Ecore models and saves them with the respective file 
 * extension. The build does also invoke the EcoreValidator to check whether
 * the produced Ecore models are valid. If problems are found they are mapped
 * to the corresponding elements of the MEcore model and problem markers are 
 * attached.
 */
public class MecoreBuilder implements IMecoreBuilder {
	
	public boolean isBuildingNeeded(URI uri) {
		return true;
	}
	
	public IStatus build(MecoreResource resource, IProgressMonitor monitor) {
		List<EObject> contents = resource.getContents();

		// read existing .ecore file (if there is one)
		EPackage existingEPackage = null;
		URI ecoreURI = resource.getURI().trimFileExtension().trimFileExtension().appendFileExtension("ecore");
		Resource ecoreResource;
		try {
			ecoreResource = resource.getResourceSet().getResource(ecoreURI, true);
		} catch (WrappedException e) {
			// can't load resource, probably it does not exist
			ecoreResource = resource.getResourceSet().createResource(ecoreURI);
		}
		if (!ecoreResource.getErrors().isEmpty()) {
			// if the .ecore file has errors, we do not run the build, because it will
			// override the existing file
			return org.eclipse.core.runtime.Status.CANCEL_STATUS;
		}
		
		List<EObject> ecoreContents = ecoreResource.getContents();
		if (!ecoreContents.isEmpty()) {
			EObject root = ecoreContents.get(0);
			if (root instanceof EPackage) {
				existingEPackage = (EPackage) root;
			}
		}
		
		MecoreWrapper wrapper = new MecoreWrapper();
		for (EObject eObject : contents) {
			if (eObject instanceof MPackage) {
				MPackage mPackage = (MPackage) eObject;
				existingEPackage = wrapper.wrapMPackage(mPackage, existingEPackage);
				ecoreContents.add(existingEPackage);
			}
		}
		try {
			ecoreResource.save(null);
		} catch (IOException e) {
			e.printStackTrace();
			return org.eclipse.core.runtime.Status.CANCEL_STATUS;
		}
		reloadGeneratorModel(ecoreResource);
		
		// run Ecore validation and map result back to .mecore file
		Map<Object, Object> context = new LinkedHashMap<Object, Object>();
		TreeIterator<EObject> allContents = ecoreResource.getAllContents();
		while (allContents.hasNext()) {
			EObject next = (EObject) allContents.next();
			BasicDiagnostic diagnostics = new BasicDiagnostic();
			boolean result = EcoreValidator.INSTANCE.validate(next, diagnostics, context);
			if (!result) {
				processDiagnostics(resource, wrapper, diagnostics);
			}
		}
		return org.eclipse.core.runtime.Status.OK_STATUS;
	}

	/** 
	 * Reload the generator model (if one with the same name exists).
	 * 
	 * @param ecoreResource the resource containing the Ecore model
	 */
	private void reloadGeneratorModel(Resource ecoreResource) {
		URI genModelURI = ecoreResource.getURI().trimFileExtension().appendFileExtension("genmodel");
		ResourceSet resourceSet = ecoreResource.getResourceSet();
		// check if generator model exists
		if (!resourceSet.getURIConverter().exists(genModelURI, null)) {
			return;
		}
		Resource genModelResource = resourceSet.getResource(genModelURI, true);
		if (genModelResource == null) {
			return;
		}
		List<EObject> genModelContents = genModelResource.getContents();
		if (genModelContents.isEmpty()) {
			return;
		}
		for (EObject genModelObject : genModelContents) {
			if (genModelObject instanceof GenModel) {
				GenModel genModel = (GenModel) genModelObject;
				reloadGeneratorModel(genModel, resourceSet);
			}
		}
	}

	private void processDiagnostics(MecoreResource resource, MecoreWrapper wrapper, Diagnostic diagnostics) {
		String message = diagnostics.getMessage();
		List<?> data = diagnostics.getData();
		if (data != null) {
			for (Object object : data) {
				if (object instanceof EObject) {
					// find element in .mecore file that caused the problem
					EObject causingEObject = (EObject) object;
					EObject causingMObject = wrapper.getReverseMapping().get(causingEObject);
					if (causingMObject != null && causingMObject.eResource() != null) {
						attachProblemMarker(resource, diagnostics, message, causingMObject);
					} else {
						// attach problem to root object
						EList<EObject> contents = resource.getContents();
						if (contents.size() > 0) {
							EObject root = contents.get(0);
							attachProblemMarker(resource, diagnostics, message, root);
						}
					}
				}
			}
		}
		for (Diagnostic child : diagnostics.getChildren()) {
			processDiagnostics(resource, wrapper, child);
		}
	}

	private void attachProblemMarker(MecoreResource resource,
			Diagnostic diagnostics, String message, EObject causingMObject) {
		// attach a problem marker
		if (diagnostics.getSeverity() == Diagnostic.ERROR) {
			resource.addError(message, MecoreEProblemType.BUILDER_ERROR, causingMObject);
		} else if (diagnostics.getSeverity() == Diagnostic.WARNING) {
			resource.addWarning(message, MecoreEProblemType.BUILDER_ERROR, causingMObject);
		}
	}

	private GenModel reloadGeneratorModel(GenModel genModel, ResourceSet rs) {
		if (Platform.isRunning()) {
			IWorkspace workspace = ResourcesPlugin.getWorkspace();
			final URI genModelURI = genModel.eResource().getURI();
			//only reload when we are working on the platform
			if(genModelURI.isPlatform()) {
				IResource member = workspace.getRoot().findMember(genModelURI.toPlatformString(true));
				if (member instanceof IFile) {
					IFile file = (IFile) member;
					if (!file.isReadOnly()) {
		            	try {
		            		updateGenModel(genModel);
		            		Resource genModelResource = rs.getResource(genModelURI, true);
		        			return (GenModel) genModelResource.getContents().get(0);
		            	} catch (Exception e) {
		            		MecorePlugin.logError("Error while updating genmodel " + file, e);
		            	}
		        	}
				}
			}
		}
		return genModel;
	}

	private void updateGenModel(final GenModel genModel) throws Exception {
        final Resource genModelResource = genModel.eResource();
 
		final boolean reconcileSucceeded = genModel.reconcile();
		if (!reconcileSucceeded) {
			throw new RuntimeException("Reconciliation of genmodel failed.");
		}
        
        final Diagnostic diag = genModel.diagnose();
        if (diag.getSeverity() != Diagnostic.OK) {
        	throw new DiagnosticException(diag);
        }
        
        new Job("saving genmodel after reconciling") {
        	
        	@Override
        	protected IStatus run(IProgressMonitor monitor) {
        		try {
        			genModelResource.save(Collections.EMPTY_MAP);
        		} catch (IOException e) {
        			throw new RuntimeException(e);
        		}
        		return Status.OK_STATUS;
        	}
        }.schedule();
	}

	public IStatus handleDeletion(URI uri, IProgressMonitor monitor) {
		return Status.OK_STATUS;
	}
}
