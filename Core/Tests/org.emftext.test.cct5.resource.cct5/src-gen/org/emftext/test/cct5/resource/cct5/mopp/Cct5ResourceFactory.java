/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.mopp;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

public class Cct5ResourceFactory implements Resource.Factory {
	
	public Cct5ResourceFactory() {
		super();
	}
	
	public Resource createResource(URI uri) {
		return new org.emftext.test.cct5.resource.cct5.mopp.Cct5Resource(uri);
	}
	
}
