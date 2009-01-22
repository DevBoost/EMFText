package org.emftext.sdk.concretesyntax.resource.cs;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
public class CsResourceFactory implements Resource.Factory {


	public CsResourceFactory() {
		super();
	}

	public Resource createResource(URI uri) {
		return new CsResource(uri);
	}
}
