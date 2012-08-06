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
package org.emftext.language.rolecore.resource.rolecore.analysis;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emftext.language.rolecore.Import;
import org.emftext.language.rolecore.RCPackage;

public class ImportImportedPackageReferenceResolver implements org.emftext.language.rolecore.resource.rolecore.IRolecoreReferenceResolver<org.emftext.language.rolecore.Import, org.emftext.language.rolecore.RCPackage> {
	
	private org.emftext.language.rolecore.resource.rolecore.analysis.RolecoreDefaultResolverDelegate<org.emftext.language.rolecore.Import, org.emftext.language.rolecore.RCPackage> delegate = new org.emftext.language.rolecore.resource.rolecore.analysis.RolecoreDefaultResolverDelegate<org.emftext.language.rolecore.Import, org.emftext.language.rolecore.RCPackage>();

	public void resolve(
			java.lang.String identifier,
			org.emftext.language.rolecore.Import container,
			org.eclipse.emf.ecore.EReference reference,
			int position,
			boolean resolveFuzzy,
			final org.emftext.language.rolecore.resource.rolecore.IRolecoreReferenceResolveResult<org.emftext.language.rolecore.RCPackage> result) {
		String locationHint = container.getRcPackageLocationHint();
		findRCPackages(identifier, locationHint, container, resolveFuzzy, result);
	}

	private void findRCPackages(
			String identifier,
			String locationHint,
			Import container,
			boolean resolveFuzzy,
			final org.emftext.language.rolecore.resource.rolecore.IRolecoreReferenceResolveResult<org.emftext.language.rolecore.RCPackage> result) {
		if (!resolveFuzzy) {
			RCPackage rcPackage = null;
			if (locationHint == null) {
				String resourceURI = container.eResource().getURI().toPlatformString(true);
				rcPackage = loadRCPackage(resourceURI.substring(0, resourceURI.lastIndexOf("/") + 1)
						+ identifier);
			} else {
				// TODO verify
				rcPackage = loadRCPackage(locationHint + identifier);
			}
			result.addMapping(rcPackage.getNsURI(), rcPackage);
		} else {
			// too complex
		}
	}

	public RCPackage loadRCPackage(String fileURI) {
		// create resource set and resource
		ResourceSet resourceSet = new ResourceSetImpl();

		try {
			return (RCPackage) resourceSet.getResource(URI.createPlatformResourceURI(fileURI, true), true)
					.getContents().get(0);

		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("Resource " + fileURI + " does not exist");
		}
		return null;
	}

	public java.lang.String deResolve(org.emftext.language.rolecore.RCPackage element,
			org.emftext.language.rolecore.Import container, org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}

	public void setOptions(java.util.Map<?, ?> options) {
		// save options in a field or leave method empty if this resolver does
		// not depend on any option
	}

}
