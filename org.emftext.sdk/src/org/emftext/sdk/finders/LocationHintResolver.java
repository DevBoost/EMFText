package org.emftext.sdk.finders;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

/**
 * A LocationHintResolver can be used to convert location hints to 
 * URIs.
 */
public class LocationHintResolver {


	public URI getLocationHintURI(String locationHint, EObject container) {
		URI hintURI;
		if (locationHint.contains(":")) {
			// locationHint is an absolute path - we can use it as it is
			hintURI = URI.createURI(locationHint);
		} else {
			// locationHint is an relative path - we must resolve it
			URI containerURI = container.eResource().getURI();
			hintURI = URI.createURI(locationHint).resolve(containerURI);
		}
		return hintURI;
	}
}
