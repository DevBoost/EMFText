package org.reuseware.emftextedit;

import org.reuseware.emftextedit.resource.TextResource;

public interface GenPackageFinder {

	public IGenPackageFinderResult findGenPackage(String nsURI, TextResource resource);

}
