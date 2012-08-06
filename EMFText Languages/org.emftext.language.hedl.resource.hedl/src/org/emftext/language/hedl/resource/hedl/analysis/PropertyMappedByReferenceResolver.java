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

import java.util.Map;

import org.eclipse.emf.ecore.EReference;
import org.emftext.language.hedl.Property;
import org.emftext.language.hedl.Type;
import org.emftext.language.hedl.resource.hedl.IHedlReferenceResolveResult;
import org.emftext.language.hedl.resource.hedl.IHedlReferenceResolver;

public class PropertyMappedByReferenceResolver implements IHedlReferenceResolver<Property, Property> {
	
	private HedlDefaultResolverDelegate<Property, Property> delegate = new HedlDefaultResolverDelegate<Property, Property>();
	
	public void resolve(String identifier, Property container, EReference reference, int position, boolean resolveFuzzy, final IHedlReferenceResolveResult<Property> result) {
		Type type = container.getType();
		if (type != null) {
			// the property that is referenced by the 'mappedBy' reference must be contained in the
			// type of the property
			delegate.tryToResolveIdentifierInObjectTree(identifier, container, type, reference, position, resolveFuzzy, result, true);
		}
	}
	
	public String deResolve(Property element, Property container, EReference reference) {
		return container.getName();
	}
	
	public void setOptions(Map<?,?> options) {
		// not used
	}
	
}
