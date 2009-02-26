package org.emftext.sdk.finders;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.runtime.EMFTextRuntimePlugin;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.sdk.MetamodelManager;
import org.emftext.sdk.concretesyntax.GenPackageDependentElement;

/**
 * A finder that searches in the current project in the Eclipse workspace
 * for files that contain generator packages.
 */
public class GenPackageByHintFinder implements IGenPackageFinder {
	
	private Set<String> faultyHints = new HashSet<String>();
	
	/**
	 * An implementation of the IGenPackageFinderResult that is used to
	 * return generator package found in the current workspace.
	 */
	private class GenPackageInWorkspaceFinderResult implements IGenPackageFinderResult {

		private GenPackage genPackage;
		
		public GenPackageInWorkspaceFinderResult(GenPackage genPackage) {
			Assert.isNotNull(genPackage);
			
			this.genPackage = genPackage;
		}
		
		public GenPackage getResult() {
			return genPackage;
		}
	}
	
	public IGenPackageFinderResult findGenPackage(String nsURI, String locationHint, GenPackageDependentElement container, ITextResource resource) {
		if (locationHint == null) {
			return null;
		}
		if (faultyHints.contains(locationHint)) {
			return null;
		}
		return findGenPackageUsingHint(nsURI, locationHint, container, resource);
	}

	/**
	 * Search the current project generator models.
	 * 
	 * @param nsURI
	 * @param rs
	 * @param platformString
	 * @return
	 */
	private IGenPackageFinderResult findGenPackageUsingHint(String nsURI, String locationHint, GenPackageDependentElement container, ITextResource resource) {
		final ResourceSet rs = new ResourceSetImpl();
		try {
			URI hintURI = null;
			if(locationHint.contains(":")) {
				//absolute path
				hintURI = URI.createURI(locationHint);
			}
			else {
				//relative path
				hintURI = container.eResource().getURI().trimSegments(1).appendSegment(locationHint);
			}
			if ("genmodel".equals(hintURI.fileExtension())) {
				
				Resource genModelResource = null;
				
				try {
					genModelResource = rs.getResource(hintURI, true);
				} catch (Exception e) {}
				
				EList<EObject> contents = null; 
				if (genModelResource != null) {
					contents = genModelResource.getContents();	
				}
				if (contents != null && contents.size() > 0) {
					GenModel genModel = (GenModel) contents.get(0);
					if (Platform.isRunning()) {
						IWorkspace workspace = ResourcesPlugin.getWorkspace();
						final String platformString = hintURI.toPlatformString(true);
						if (platformString != null) {
							IResource member = workspace.getRoot().findMember(platformString);
							if (member instanceof IFile) {
								IFile file = (IFile) member;
								if (!file.isReadOnly()) {
					            	try {
					            		updateGenModel(genModel);
					            	} catch (Exception e){
					            		EMFTextRuntimePlugin.logError("Error while updating genmodel " + file, e);
					            	}				            		
					        	}
							}
						}
					}
		        	Map<String, GenPackage> packages =  MetamodelManager.getGenPackages(genModel);
		        	for (String uri : packages.keySet()) {
		    			if (uri.equals(nsURI)) {
		    				return new GenPackageInWorkspaceFinderResult(packages.get(uri));
		    			}
		        	}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			EMFTextRuntimePlugin.logError("Exception while looking for generator package.", e);
		}
		
		resource.addWarning("The generator package was not found at " + locationHint, container);
		faultyHints.add(locationHint);
		return null;
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
	
}
