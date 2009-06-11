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

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.ecore.EReference;
import org.emftext.runtime.resource.IReferenceResolveResult;
import org.emftext.runtime.resource.impl.AbstractReferenceResolver;
import org.emftext.sdk.concretesyntax.Containment;
import org.emftext.sdk.concretesyntax.resource.cs.analysis.helper.MetaclassReferenceResolver;

public class ContainmentTypesReferenceResolver extends AbstractReferenceResolver<Containment, GenClass> {
	
	private MetaclassReferenceResolver resolver = new MetaclassReferenceResolver();
	
	public void resolve(String identifier, Containment container, EReference reference, int position, boolean resolveFuzzy, IReferenceResolveResult<GenClass> result) {
		GenClass superType = null;
		final GenFeature feature = container.getFeature();
		if (feature != null && feature.getEcoreFeature() != null) {
			superType = feature.getTypeGenClass();
		}
		resolver.doResolve(identifier, container, reference, position, resolveFuzzy, result, superType, true);
	}

	public String deResolve(GenClass element, Containment container, EReference reference) {
		return resolver.deResolve(element, container, reference);
	}

	public void setOptions(Map<?, ?> options) {
		// do nothing - we do not need the options
	}
}
