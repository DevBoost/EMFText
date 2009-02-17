package org.emftext.sdk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.runtime.EMFTextPlugin;

/**
 * A finder that searches in the current project in the Eclipse workspace
 * for files that contain generator packages.
 */
public class GenPackageInCurrentProjectFinder implements IGenPackageFinder {
	
	/**
	 * An implementation of the IGenPackageFinderResult that is used to
	 * return generator package found in the current workspace.
	 */
	private class GenPackageInWorkspaceFinderResult implements IGenPackageFinderResult {

		private IFile file;
		private long initialModifiedStamp;
		private GenPackage genPackage;
		private boolean foundMultiple;
		
		public GenPackageInWorkspaceFinderResult(GenPackage genPackage, IFile file) {
			Assert.isNotNull(genPackage);
			Assert.isNotNull(file);
			
			this.genPackage = genPackage;
			this.file = file;
			this.initialModifiedStamp = file.getModificationStamp();
		}
		
		public GenPackage getResult() {
			return genPackage;
		}

		public boolean hasChanged() {
			return initialModifiedStamp != file.getModificationStamp();
		}

		public void setFoundMultiple(boolean foundMultiple) {
			this.foundMultiple = foundMultiple;
		}

		public boolean foundMultiple() {
			return foundMultiple;
		}
	}
	
	public IGenPackageFinderResult findGenPackage(String nsURI, Resource resource) {
		URI uri = resource.getURI();
		String platformString = uri.toPlatformString(true);
		if (platformString == null) {
			return null;
		}
		return findGenPackageInCurrentProject(nsURI, platformString);
	}

	/**
	 * Search the current project generator models.
	 * 
	 * @param nsURI
	 * @param rs
	 * @param platformString
	 * @return
	 */
	private IGenPackageFinderResult findGenPackageInCurrentProject(String nsURI, String platformString) {
		final ResourceSet rs = new ResourceSetImpl();
		final List<GenPackageInWorkspaceFinderResult> allPackages = new ArrayList<GenPackageInWorkspaceFinderResult>();
		IResource member = ResourcesPlugin.getWorkspace().getRoot().findMember(platformString);
		if (member == null) {
			return null;
		}
		IProject thisProject = member.getProject();
		try {
			thisProject.accept(new IResourceVisitor() {
				public boolean visit(IResource resource) throws CoreException {
					if(resource instanceof IFile) {
						IFile file = (IFile) resource;
						
						if ("genmodel".equals(file.getFileExtension())) {
							URI genModelURI = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
							Resource genModelResource = rs.getResource(genModelURI, true);
			            	GenModel genModel = (GenModel) genModelResource.getContents().get(0);
			            	
			            	if(!file.isReadOnly()){
				            	try {
				            		updateGenModel(genModel);
				            	} catch (Exception e){
				            		EMFTextPlugin.logError("Error while updating genmodel " + file, e);
				            	}				            		
			            	}
			            	
			            	Map<String, GenPackage> packages =  MetamodelManager.getGenPackages(genModel);
			            	for (String uri : packages.keySet()) {
			            		allPackages.add(new GenPackageInWorkspaceFinderResult(packages.get(uri), file));
			            	}
						}
						return false;
					}
					return true;
				}
			});
		} catch (CoreException e) {
			EMFTextPlugin.logError("Error while traversing resources.", e);
		}
		
		GenPackageInWorkspaceFinderResult foundResult = null;
		boolean foundMultiple = false;
		for (GenPackageInWorkspaceFinderResult result : allPackages) {
			if (result.getResult().getNSURI().equals(nsURI)) {
				if (foundResult != null) {
					foundMultiple = true;
				}
				foundResult = result;
			}
		}
		if (foundResult != null) {
			foundResult.setFoundMultiple(foundMultiple);
		}
		return foundResult;
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
