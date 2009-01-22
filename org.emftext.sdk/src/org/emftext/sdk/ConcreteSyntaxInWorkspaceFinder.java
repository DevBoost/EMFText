package org.emftext.sdk;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.runtime.EMFTextPlugin;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;

/**
 * A finder that searches in the current Eclipse workspace for concrete
 * syntax definitions.
 */
public class ConcreteSyntaxInWorkspaceFinder implements IConcreteSyntaxFinder {

	private final class WorkspaceVisitor implements IResourceVisitor {
		private final IResource workspaceResource;
		private final String csURI;
		private ConcreteSyntax foundSyntax;

		private WorkspaceVisitor(IResource workspaceResource, String csURI) {
			this.workspaceResource = workspaceResource;
			this.csURI = csURI;
		}

		public boolean visit(IResource resource) throws CoreException {
			// check whether we are visiting the textResource that triggered this request for
			// a concrete syntax. if so, stop visiting to avoid cycles
			if (resource.equals(workspaceResource)) {
				return false;
			}
			if (resource instanceof IFile) {
				IFile file = (IFile) resource;
				if ("cs".equals(file.getFileExtension())) {
		        	URI csLocation = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
		    		ResourceSet resourceSet = new ResourceSetImpl();
		        	Resource aCsResource = resourceSet.getResource(csLocation, true);
		        	ConcreteSyntax nextSyntax = (ConcreteSyntax) aCsResource.getContents().get(0);
		        	String nextSyntaxURI = MetamodelManager.getConcreteSyntaxURI(nextSyntax.getName(), nextSyntax.getPackage());
		        	if (csURI.equals(nextSyntaxURI)) {
		        		foundSyntax = nextSyntax;
						return false;
		        	}
				}
				return false;
			}
			return true;
		}

		public ConcreteSyntax getFoundSyntax() {
			return foundSyntax;
		}
	}

	public ConcreteSyntax findConcreteSyntax(String csURI, Resource resource) {
        // search the workspace for CS definitions
		IResource workspaceResource = ResourcesPlugin.getWorkspace().getRoot().findMember(resource.getURI().toPlatformString(true));
		IWorkspaceRoot workspaceRoot = workspaceResource.getWorkspace().getRoot();
		WorkspaceVisitor visitor = new WorkspaceVisitor(workspaceResource, csURI);
		try {
			workspaceRoot.accept(visitor);
		} catch (CoreException e) {
			EMFTextPlugin.logError("Exception while looking up concrete syntax.", e);
		} 
       	return visitor.getFoundSyntax();
	}
}
