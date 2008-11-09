package org.reuseware.emftextedit.runtime;

import org.reuseware.emftextedit.runtime.resource.TextResource;

public interface GenPackageFinder {

	public IGenPackageFinderResult findGenPackage(String nsURI, TextResource resource);

}
