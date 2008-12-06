package org.reuseware.emftextedit.sdk;

import org.eclipse.emf.ecore.resource.Resource;


public interface IGenPackageFinder {

	public IGenPackageFinderResult findGenPackage(String nsURI, Resource resource);

}
