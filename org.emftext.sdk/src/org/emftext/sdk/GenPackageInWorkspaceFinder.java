package org.emftext.sdk;

import java.util.Collections;
import java.util.HashMap;
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
import org.emftext.runtime.EMFTextEditPlugin;

public class GenPackageInWorkspaceFinder implements IGenPackageFinder {
	
	private class GenPackageInWorkspaceFinderResult implements IGenPackageFinderResult {

		private IFile file;
		private long initialModifiedStamp;
		private GenPackage genPackage;
		
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
		final Map<String, GenPackageInWorkspaceFinderResult> genPackages = new HashMap<String, GenPackageInWorkspaceFinderResult>();
		IResource member = ResourcesPlugin.getWorkspace().getRoot().findMember(platformString);
		if (member != null) {
			IProject thisProject = member.getProject();        
			try {
				thisProject.accept(new IResourceVisitor() {
					//TODO add some check if there are several copies of the same models, maybe prefer copies in same folder...
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
					            		EMFTextEditPlugin.logError("Error while updating genmodel " + file, e);
					            	}				            		
				            	}
				            	
				            	Map<String,GenPackage> packages =  MetamodelManager.getGenPackages(genModel);
				            	for (String uri : packages.keySet()) {
				            		genPackages.put(uri, new GenPackageInWorkspaceFinderResult(packages.get(uri), file));
				            	}
							}
							return false;
						}
						return true;
					}
				});
			} catch (CoreException e) {
				EMFTextEditPlugin.logError("Error while traversing resources.", e);
			}
		
			if (genPackages.containsKey(nsURI)) {
				return genPackages.get(nsURI);
			}
		}
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
