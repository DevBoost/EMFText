package org.emftext.sdk;

import org.eclipse.emf.ecore.resource.Resource;

/**
 * An IGenPackageFinder can be used to look up the EMF generator package for
 * a given URI.
 */
public interface IGenPackageFinder {

	/**
	 * Searches for all generator packages that match the given nsURI.
	 * 
	 * @param nsURI the URI of the generator package we search for
	 * @param resource the resource that contains a link to the generator package
	 *                 (needed if generator packages that reside in the same folder 
	 *                 shall be preferred)
	 * @return
	 */
	public IGenPackageFinderResult findGenPackage(String nsURI, Resource resource);
}
