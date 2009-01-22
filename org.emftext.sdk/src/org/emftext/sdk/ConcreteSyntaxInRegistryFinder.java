package org.emftext.sdk;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.runtime.EMFTextPlugin;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;

/**
 * A finder that searches in the registry for concrete
 * syntax definitions.
 */
public class ConcreteSyntaxInRegistryFinder implements IConcreteSyntaxFinder {

	public ConcreteSyntax findConcreteSyntax(String csURI, Resource resource) {
		ResourceSet resourceSet = new ResourceSetImpl();
		
		//find all registered concrete syntax definitions
        final Map<String, URI> uriToCSLocationMap = EMFTextPlugin.getURIToConcreteSyntaxLocationMap();
		for (String candCsURI : uriToCSLocationMap.keySet()) {
        	URI csLocation = uriToCSLocationMap.get(csURI);
        	Resource csResource = resourceSet.getResource(csLocation, true);
        	ConcreteSyntax concreteSyntax = (ConcreteSyntax) csResource.getContents().get(0);
        	if (csURI.equals(candCsURI)) {
        		return concreteSyntax;
        	}
        }
		return null;
	}
}
