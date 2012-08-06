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
package org.emftext.language.lwc11.resource.lwc11.analysis;

import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emftext.language.lwc11.EntityModel;
import org.emftext.language.lwc11.Feature;
import org.emftext.language.lwc11.resource.lwc11.ILwc11ReferenceResolveResult;
import org.emftext.language.lwc11.resource.lwc11.ILwc11ReferenceResolver;
import org.emftext.language.lwc11.types.Type;
import org.emftext.language.lwc11.types.TypeLib;

public class FeatureTypeReferenceResolver implements ILwc11ReferenceResolver<Feature, Type> {
	
	private Lwc11DefaultResolverDelegate<Feature, Type> delegate = new Lwc11DefaultResolverDelegate<Feature, Type>();
	
	public void resolve(String identifier, Feature container, EReference reference, int position, boolean resolveFuzzy, final ILwc11ReferenceResolveResult<Type> result) {
		// look up primitive types in library
		Resource resource = container.eResource().getResourceSet().getResource(URI.createPlatformPluginURI("org.emftext.language.lwc11/modellib/primitivetypes.xmi", true), true);
		if (resource != null) {
			EList<EObject> contents = resource.getContents();
			for (EObject contentObject : contents) {
				if (contentObject instanceof TypeLib) {
					TypeLib lib = (TypeLib) contentObject;
					EList<Type> types = lib.getTypes();
					resolveType(identifier, resolveFuzzy, result, types);
					if (!resolveFuzzy && result.wasResolved()) {
						return;
					}
				}
			}
		}
		// try to resolve in imports
		EntityModel em = (EntityModel) EcoreUtil.getRootContainer(container);
		for (EntityModel importedModel : em.getImports()) {
			resolveType(identifier, resolveFuzzy, result, importedModel.getEntities());
			if (!resolveFuzzy && result.wasResolved()) {
				return;
			}
		}
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}

	private void resolveType(String identifier, boolean resolveFuzzy,
			final ILwc11ReferenceResolveResult<Type> result, EList<? extends Type> types) {
		for (Type type : types) {
			String typeName = type.getName();
			if (resolveFuzzy || typeName.equals(identifier)) {
				result.addMapping(typeName, type);
				if (!resolveFuzzy) {
					return;
				}
			}
		}
	}
	
	public java.lang.String deResolve(Type element, Feature container, EReference reference) {
		return delegate.deResolve(element, container, reference);
	}
	
	public void setOptions(Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
	
}
