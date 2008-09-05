package org.reuseware.emftextedit.concretesyntax.resource.cs.analysis;

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
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.reuseware.emftextedit.EMFTextEditPlugin;
import org.reuseware.emftextedit.concretesyntax.ConcreteSyntax;
import org.reuseware.emftextedit.resource.TextResource;

public class MetamodelManager {
	
	public static MetamodelManager INSTANCE = new MetamodelManager();

	
	public GenPackage findGenPackage(String nsURI, TextResource resource) {
		if (nsURI == null) return null;
		
		final ResourceSet rs = new ResourceSetImpl();
		final Map<String, GenPackage> genPackages = new HashMap<String, GenPackage>();
		
        //search the current project generator models
		IProject thisProject = ResourcesPlugin.getWorkspace().getRoot().findMember(resource.getURI().toPlatformString(true)).getProject();        
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
			            	for(GenPackage genPackage : genModel.getGenPackages()) {
			            		genPackages.put(genPackage.getNSURI(), genPackage);
			            	}
			            	// added to resolve imported GenPackages too. 
			            	for(GenPackage gp : genModel.getUsedGenPackages()) {
			            		if(gp.getEcorePackage() != null) {
			            			genPackages.put(gp.getNSURI(), gp);
			            		}
			            	}
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
		
	
		
        //search all registered generator models
        for(URI genModelURI : EcorePlugin.getEPackageNsURIToGenModelLocationMap().values()) {
        	try {
        		Resource genModelResource = rs.getResource(genModelURI, true);
            	GenModel genModel = (GenModel) genModelResource.getContents().get(0);
            	for(GenPackage genPackage : genModel.getGenPackages()) {
            		if (nsURI.equals(genPackage.getNSURI())) {
            			return genPackage;
            		}
            	}
        	} catch (Exception e ) {
        		//FIXME print exception into error log
        	}

        }

        return null;
	}
	
	public ConcreteSyntax findConcreteSyntax(String cs, GenPackage genPackage, TextResource resource) {
		if (cs == null || genPackage == null) return null;
		
		String csURI = genPackage.getNSURI() + "%%" + cs;
		
		final ResourceSet rs = new ResourceSetImpl();
		final Map<String,ConcreteSyntax> concreteSyntaxes = new HashMap<String, ConcreteSyntax>();
		
        //search the current project for cs definitions
		IProject thisProject = ResourcesPlugin.getWorkspace().getRoot().findMember(resource.getURI().toPlatformString(true)).getProject();        
		try {
			thisProject.accept(new IResourceVisitor() {
				//TODO add some check if there are several copies of the same models, maybe prefer copies in same folder...
				public boolean visit(IResource resource) throws CoreException {
					if(resource instanceof IFile) {
						IFile file = (IFile) resource;
						if ("cs".equals(file.getFileExtension())) {
			            	URI csLocation = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
			            	Resource aCsResource = rs.getResource(csLocation, true);
			            	ConcreteSyntax csDef = (ConcreteSyntax) aCsResource.getContents().get(0);
			            	concreteSyntaxes.put(csDef.getPackage().getNSURI() + "%%" + csDef.getName(), csDef);							
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

        if (concreteSyntaxes.containsKey(csURI)) {
        	return concreteSyntaxes.get(csURI);
        }
		
        //find all registered concrete syntax definitions
		if (concreteSyntaxes.isEmpty()) {
	        for(String candCsURI : EMFTextEditPlugin.getURIToConcreteSyntaxLocationMap().keySet()) {
	        	URI csLocation = EMFTextEditPlugin.getURIToConcreteSyntaxLocationMap().get(csURI);
	        	Resource aCsResource = rs.getResource(csLocation, true);
	        	ConcreteSyntax csDef = (ConcreteSyntax) aCsResource.getContents().get(0);
	        	if (csURI.equals(candCsURI)) {
	        		return csDef;
	        	}
	        }
		}
	
		return null;
	}
	
	

	

}
