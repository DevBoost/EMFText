package org.reuseware.emftextedit.sdk.concretesyntax.resource.cs;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
public class CsResourceFactoryImpl implements Resource.Factory {


	public CsResourceFactoryImpl(){
		super();
	}

	public Resource createResource(URI uri){
		return new CsResourceImpl(uri);
	}
}
