package org.reuseware.emftextedit;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.reuseware.emftextedit.resource.TextResource;

public interface GenPackageFinder {

	public GenPackage findGenPackage(String nsURI, TextResource resource);

}
