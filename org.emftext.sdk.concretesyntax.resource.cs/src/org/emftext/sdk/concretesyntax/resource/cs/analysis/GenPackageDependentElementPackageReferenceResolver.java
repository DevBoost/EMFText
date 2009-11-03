/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.concretesyntax.resource.cs.analysis;

import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EReference;
import org.emftext.sdk.MetamodelHelper;
import org.emftext.sdk.concretesyntax.GenPackageDependentElement;
import org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolveResult;
import org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolver;

public class GenPackageDependentElementPackageReferenceResolver implements ICsReferenceResolver<GenPackageDependentElement, GenPackage> {
	
	private Map<?, ?> options;
	private MetamodelHelper mmHelper = new MetamodelHelper();

	public void resolve(String nsURI, GenPackageDependentElement container, EReference reference, int position, boolean resolveFuzzy, ICsReferenceResolveResult<GenPackage> result) {
		String locationHint = container.getPackageLocationHint();
		GenPackage genPackage = mmHelper.findGenPackage(options, container, nsURI, locationHint, container.eResource());
		if (genPackage == null) {
			result.setErrorMessage("Generator model \"" + nsURI + "\" could not be resolved." + 
					(locationHint == null ? "" : " Maybe " + locationHint + " is wrong?")
			);
		} else {
			result.addMapping(nsURI, genPackage);
		}
	}
	
	public String deResolve(GenPackage element, GenPackageDependentElement container, EReference reference) {
		return element.getNSURI();
	}

	public void setOptions(Map<?, ?> options) {
		this.options = options;
	}
}
