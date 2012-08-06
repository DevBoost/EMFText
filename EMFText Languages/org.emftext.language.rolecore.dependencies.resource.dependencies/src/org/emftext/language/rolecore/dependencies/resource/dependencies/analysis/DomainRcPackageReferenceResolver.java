/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.language.rolecore.dependencies.resource.dependencies.analysis;

import java.util.Iterator;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.rolecore.RCPackage;

public class DomainRcPackageReferenceResolver implements org.emftext.language.rolecore.dependencies.resource.dependencies.IDependenciesReferenceResolver<org.emftext.language.rolecore.dependencies.Domain, org.emftext.language.rolecore.RCPackage> {
	
	private org.emftext.language.rolecore.dependencies.resource.dependencies.analysis.DependenciesDefaultResolverDelegate<org.emftext.language.rolecore.dependencies.Domain, org.emftext.language.rolecore.RCPackage> delegate = new org.emftext.language.rolecore.dependencies.resource.dependencies.analysis.DependenciesDefaultResolverDelegate<org.emftext.language.rolecore.dependencies.Domain, org.emftext.language.rolecore.RCPackage>();
	
	public void resolve(java.lang.String identifier, org.emftext.language.rolecore.dependencies.Domain container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.rolecore.dependencies.resource.dependencies.IDependenciesReferenceResolveResult<org.emftext.language.rolecore.RCPackage> result) {
		Resource resource = loadResource(identifier);
		if (resource != null && resource.getContents().get(0) instanceof RCPackage){
			RCPackage rcPackage = (RCPackage) resource.getContents().get(0);
			if (rcPackage.getNsURI().equals(container.getModelPackage().getNsURI())){
				result.addMapping(identifier, rcPackage);
			}
		}
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	private Resource loadResource(String pathURI) {
		ResourceSet resourceSet = new ResourceSetImpl();
		URI uri = URI.createPlatformPluginURI(pathURI, true);
		try {
			Resource resource = resourceSet.getResource(uri, true);
			return resource;
		} catch (Exception e) {
			// Exception
		}
		return null;
	}

	public java.lang.String deResolve(org.emftext.language.rolecore.RCPackage element, org.emftext.language.rolecore.dependencies.Domain container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend on any option
	}
	
}
