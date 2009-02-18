package org.emftext.sdk;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.runtime.EMFTextPlugin;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Import;

/**
 * A finder that searches in the current Eclipse workspace for concrete
 * syntax definitions.
 */
public class ConcreteSyntaxByHintFinder implements IConcreteSyntaxFinder {

	public IConcreteSyntaxFinderResult findConcreteSyntax(String csURI, String locationHint, Import container, ITextResource resource) {
		if (locationHint == null) {
			return null;
		}
        // search the workspace for CS definitions
		try {
			URI hintURI = URI.createURI(locationHint);
			IResource hintResource = ResourcesPlugin.getWorkspace().getRoot().findMember(hintURI.toPlatformString(true));
			if (hintResource instanceof IFile) {
				IFile file = (IFile) hintResource;
		       	return find(csURI, file);
			}
		} catch (CoreException e) {
			EMFTextPlugin.logError("Exception while looking up concrete syntax.", e);
		}
		// TODO this warning is added multiple times, since the finder is called
		// not only once
		resource.addWarning("Can't find syntax at " + locationHint, container);
       	return null;
	}

	private IConcreteSyntaxFinderResult find(String csURI, IFile resource) throws CoreException {
		IFile file = (IFile) resource;
		if ("cs".equals(file.getFileExtension())) {
        	URI csLocation = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
        	ResourceSet resourceSet = new ResourceSetImpl();
        	Resource aCsResource = resourceSet.getResource(csLocation, true);
        	if (!aCsResource.getContents().isEmpty()){
	        	ConcreteSyntax nextSyntax = (ConcreteSyntax) aCsResource.getContents().get(0);
	        	if (nextSyntax.getName() != null && nextSyntax.getPackage() != null) {
		        	String nextSyntaxURI = MetamodelManager.getConcreteSyntaxURI(nextSyntax.getName(), nextSyntax.getPackage());
		        	if (csURI.equals(nextSyntaxURI)) {
		        		return new ConcreteSyntaxFinderResult(nextSyntax);
		        	}
	        	}
        	}
		}
		return null;
	}
}
