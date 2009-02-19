package org.emftext.sdk.finders;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.runtime.EMFTextPlugin;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Import;

/**
 * A finder that searches in the registry for concrete
 * syntax definitions.
 */
public class ConcreteSyntaxInRegistryFinder implements IConcreteSyntaxFinder {
	
	public IConcreteSyntaxFinderResult findConcreteSyntax(String csURI, String locationHint, Import container, ITextResource resource) {
		ResourceSet resourceSet = new ResourceSetImpl();
		
		//find all registered concrete syntax definitions
        final Map<String, URI> uriToCSLocationMap = EMFTextPlugin.getURIToConcreteSyntaxLocationMap();
		for (String candCsURI : uriToCSLocationMap.keySet()) {
        	URI csLocation = uriToCSLocationMap.get(csURI);
        	if (csLocation == null) {
        		continue;
        	}
        	Resource csResource = resourceSet.getResource(csLocation, true);
        	ConcreteSyntax concreteSyntax = (ConcreteSyntax) csResource.getContents().get(0);
        	if (csURI.equals(candCsURI)) {
        		return new ConcreteSyntaxFinderResult(concreteSyntax);
        	}
        }
		return null;
	}
}
