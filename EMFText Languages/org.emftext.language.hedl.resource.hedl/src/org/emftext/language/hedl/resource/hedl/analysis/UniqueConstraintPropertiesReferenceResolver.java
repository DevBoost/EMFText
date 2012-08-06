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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.language.hedl.Property;
import org.emftext.language.hedl.UniqueConstraint;
import org.emftext.language.hedl.resource.hedl.IHedlReferenceResolveResult;
import org.emftext.language.hedl.resource.hedl.IHedlReferenceResolver;

public class UniqueConstraintPropertiesReferenceResolver implements IHedlReferenceResolver<UniqueConstraint, Property> {
	
	private HedlDefaultResolverDelegate<UniqueConstraint, Property> delegate = new HedlDefaultResolverDelegate<UniqueConstraint, Property>();
	
	public void resolve(String identifier, UniqueConstraint container, EReference reference, int position, boolean resolveFuzzy, final IHedlReferenceResolveResult<Property> result) {
		EObject root = container.eContainer();
		delegate.tryToResolveIdentifierInObjectTree(identifier, container, root, reference, position, resolveFuzzy, result, true);
	}
	
	public String deResolve(Property element, UniqueConstraint container, EReference reference) {
		return element.getName();
	}
	
	public void setOptions(Map<?,?> options) {
		// not used
	}
	
}
