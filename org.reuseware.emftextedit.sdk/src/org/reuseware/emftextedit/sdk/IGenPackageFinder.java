package org.reuseware.emftextedit.sdk;

import org.reuseware.emftextedit.runtime.resource.TextResource;

public interface IGenPackageFinder {

	public IGenPackageFinderResult findGenPackage(String nsURI, TextResource resource);

}
