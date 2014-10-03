/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.test.cct5.resource.cct5.mopp;

import java.util.LinkedHashMap;
import java.util.Map;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Factory;

public class Cct5ResourceFactoryDelegator implements Factory {
	
	protected Map<String, Factory> factories = null;
	
	public Cct5ResourceFactoryDelegator() {
		init();
	}
	
	protected void init() {
		if (factories == null) {
			factories = new LinkedHashMap<String, Factory>();
		}
		if (new org.emftext.test.cct5.resource.cct5.util.Cct5RuntimeUtil().isEclipsePlatformAvailable()) {
			new org.emftext.test.cct5.resource.cct5.util.Cct5EclipseProxy().getResourceFactoryExtensions(factories);
		}
		if (factories.get("") == null) {
			factories.put("", new org.emftext.test.cct5.resource.cct5.mopp.Cct5ResourceFactory());
		}
	}
	
	public Map<String, Factory> getResourceFactoriesMap() {
		return factories;
	}
	
	public Factory getFactoryForURI(URI uri) {
		URI trimmedURI = uri.trimFileExtension();
		String secondaryFileExtension = trimmedURI.fileExtension();
		Factory factory = factories.get(secondaryFileExtension);
		if (factory == null) {
			factory = factories.get("");
		}
		return factory;
	}
	
	public Resource createResource(URI uri) {
		return getFactoryForURI(uri).createResource(uri);
	}
	
}
