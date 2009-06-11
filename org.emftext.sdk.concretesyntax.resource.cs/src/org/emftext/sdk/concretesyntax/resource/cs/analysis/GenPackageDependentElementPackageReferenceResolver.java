/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.concretesyntax.resource.cs.analysis;

import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage;
import org.eclipse.emf.ecore.EReference;
import org.emftext.runtime.resource.IReferenceResolveResult;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.resource.impl.AbstractReferenceResolver;
import org.emftext.sdk.MetamodelHelper;
import org.emftext.sdk.concretesyntax.GenPackageDependentElement;

public class GenPackageDependentElementPackageReferenceResolver extends AbstractReferenceResolver<GenPackageDependentElement, GenPackage> {
	
	private Map<?, ?> options;
	private MetamodelHelper mmHelper = new MetamodelHelper();

	public void resolve(String nsURI, GenPackageDependentElement container, EReference reference, int position, boolean resolveFuzzy, IReferenceResolveResult<GenPackage> result) {
		String locationHint = container.getPackageLocationHint();
		GenPackage genPackage = mmHelper.findGenPackage(options, container, nsURI, locationHint, (ITextResource) container.eResource());
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
