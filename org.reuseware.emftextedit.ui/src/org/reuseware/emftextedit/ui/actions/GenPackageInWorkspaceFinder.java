package org.reuseware.emftextedit.ui.actions;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.reuseware.emftextedit.GenPackageFinder;
import org.reuseware.emftextedit.MetamodelManager;
import org.reuseware.emftextedit.resource.TextResource;

public class GenPackageInWorkspaceFinder implements GenPackageFinder {
	
	public GenPackage findGenPackage(String nsURI, TextResource resource) {
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
	private GenPackage findGenPackageInCurrentProject(String nsURI, String platformString) {
		final ResourceSet rs = new ResourceSetImpl();
		final Map<String, GenPackage> genPackages = new HashMap<String, GenPackage>();
		IResource member = ResourcesPlugin.getWorkspace().getRoot().findMember(platformString);
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
			            	genPackages.putAll(MetamodelManager.getGenPackages(genModel));
						}
						return false;
					}
					return true;
				}
			});
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (genPackages.containsKey(nsURI)) {
			return genPackages.get(nsURI);
		}
		return null;
	}
}
