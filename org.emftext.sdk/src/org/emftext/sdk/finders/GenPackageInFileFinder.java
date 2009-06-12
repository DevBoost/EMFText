/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.finders;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.runtime.EMFTextRuntimePlugin;
import org.emftext.sdk.MetamodelManager;
import org.emftext.sdk.codegen.OptionManager;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.GenPackageDependentElement;
import org.emftext.sdk.concretesyntax.OptionTypes;

/**
 * An abstract super class for all finders that search for generator 
 * packages in files. Concrete sub classes basically determine the
 * URI of the file to look in and the remaining functionality (loading
 * generator models, updating them) is performed in this class.
 */
public abstract class GenPackageInFileFinder implements IGenPackageFinder {

	protected IGenPackageFinderResult findGenPackage(ConcreteSyntax syntax, String nsURI, final ResourceSet rs, URI genModelURI) {
		Resource genModelResource = null;
		
		try {
			genModelResource = rs.getResource(genModelURI, true);
		} catch (Exception e) {}
		
		EList<EObject> contents = null; 
		if (genModelResource != null) {
			contents = genModelResource.getContents();	
		}
		if (contents != null && contents.size() > 0) {
			GenModel genModel = (GenModel) contents.get(0);
			File ecoreFile = null;
			File genmodelFile = null;
			
			if (Platform.isRunning()) {
				// reload generator model if option is enabled
				boolean reloadEnabled = OptionManager.INSTANCE.getBooleanOptionValue(syntax, OptionTypes.RELOAD_GENERATOR_MODEL);
				if (reloadEnabled) {
					genModel = reloadGeneratorModel(genModel, rs);
				}

				if (genModelResource != null) {
					URI genmodelURI = genModelResource.getURI();
					if (genmodelURI != null && genModelURI.isPlatform()) {
						IResource genmodelMember = ResourcesPlugin.getWorkspace().getRoot().findMember(genmodelURI.toPlatformString(true));
						if (genmodelMember != null) {
							genmodelFile = genmodelMember.getLocation().toFile();
						}
					}
				}
				// find the Ecore files used by the generator model 
				List<GenFeature> allGenFeatures = genModel.getAllGenFeatures();
				for (GenFeature genFeature : allGenFeatures) {
					final Resource ecoreResource = genFeature.getEcoreFeature().eResource();
					if (ecoreResource == null) {
						continue;
					}
					URI ecoreURI = ecoreResource.getURI();
					if (ecoreURI == null) {
						continue;
					}
					if(genModelURI.isPlatform()) {
						IResource ecoreMember = ResourcesPlugin.getWorkspace().getRoot().findMember(ecoreURI.toPlatformString(true));
						if (ecoreMember != null) {
							ecoreFile = ecoreMember.getLocation().toFile();
						}
					}
					break;
				}
			}

			Map<String, GenPackage> packages =  MetamodelManager.getGenPackages(genModel);
			for (String uri : packages.keySet()) {
				if (uri == null) {
					continue;
				}
				if (uri.equals(nsURI)) {
					return new GenPackageInFileResult(packages.get(nsURI), ecoreFile, genmodelFile);
				}
			}
		}
		return null;
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
		            		EMFTextRuntimePlugin.logError("Error while updating genmodel " + file, e);
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
        
		genModelResource.save(Collections.EMPTY_MAP);
	}

	protected ConcreteSyntax getSyntax(GenPackageDependentElement container) {
		return (ConcreteSyntax) EcoreUtil.getRootContainer(container);
	}
}
