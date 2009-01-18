package org.emftext.sdk;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.runtime.EMFTextPlugin;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;

public class ConcreteSyntaxInRegistryFinder implements IConcreteSyntaxFinder {

	public ConcreteSyntax findConcreteSyntax(String csURI, Resource resource) {
		ResourceSet resourceSet = new ResourceSetImpl();
		
		//find all registered concrete syntax definitions
        for(String candCsURI : EMFTextPlugin.getURIToConcreteSyntaxLocationMap().keySet()) {
        	URI csLocation = EMFTextPlugin.getURIToConcreteSyntaxLocationMap().get(csURI);
        	Resource csResource = resourceSet.getResource(csLocation, true);
        	ConcreteSyntax concreteSyntax = (ConcreteSyntax) csResource.getContents().get(0);
        	if (csURI.equals(candCsURI)) {
        		return concreteSyntax;
        	}
        }
		return null;
	}
}
