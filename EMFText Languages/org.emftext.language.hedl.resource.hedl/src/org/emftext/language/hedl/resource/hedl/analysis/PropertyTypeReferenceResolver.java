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
/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.hedl.resource.hedl.analysis;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.emftext.language.hedl.JavaType;
import org.emftext.language.hedl.Property;
import org.emftext.language.hedl.Type;
import org.emftext.language.hedl.resource.hedl.IHedlReferenceCache;
import org.emftext.language.hedl.types.HedlBuiltinTypes;

public class PropertyTypeReferenceResolver implements org.emftext.language.hedl.resource.hedl.IHedlReferenceResolver<org.emftext.language.hedl.Property, org.emftext.language.hedl.Type> {
	
	private HedlDefaultResolverDelegate<Property, Type> defaultDelegate = new HedlDefaultResolverDelegate<Property, Type>() {
		public java.util.List<String> getNames(EObject element) {
			if (element instanceof Type) {
				Type type = (Type) element;
				return Collections.singletonList(type.getName());
			}
			return Collections.emptyList();
		}
	};
	
	public void resolve(String identifier, org.emftext.language.hedl.Property container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.language.hedl.resource.hedl.IHedlReferenceResolveResult<org.emftext.language.hedl.Type> result) {
		for (JavaType type : HedlBuiltinTypes.TYPES) {
			String name = type.getName();
			if (name.equals(identifier) || resolveFuzzy) {
				result.addMapping(name, type);
				if (!resolveFuzzy) {
					return;
				}
			}
		}
		IHedlReferenceCache cache = defaultDelegate.getCache(container);
		Map<String, Set<EObject>> nameToObjectsMap = cache.getNameToObjectsMap();
		for (String name : nameToObjectsMap.keySet()) {
			if (name.equals(identifier) || resolveFuzzy) {
				Set<EObject> objects = nameToObjectsMap.get(name);
				for (EObject eObject : objects) {
					if (eObject instanceof Type) {
						result.addMapping(name, (Type) eObject);
						if (!resolveFuzzy) {
							return;
						}
					}
				}
			}
		}
	}
	
	public String deResolve(org.emftext.language.hedl.Type element, org.emftext.language.hedl.Property container, org.eclipse.emf.ecore.EReference reference) {
		return element.getName();
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// not needed
	}
}
