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
package org.emftext.test.resolving.resource.resolving.analysis;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class ObjectCustomRefReferenceResolver implements org.emftext.test.resolving.resource.resolving.IResolvingReferenceResolver<org.emftext.test.resolving.Object, org.emftext.test.resolving.Object> {
	
	public void resolve(String identifier, org.emftext.test.resolving.Object container, org.eclipse.emf.ecore.EReference reference, int position, boolean resolveFuzzy, final org.emftext.test.resolving.resource.resolving.IResolvingReferenceResolveResult<org.emftext.test.resolving.Object> result) {
		EObject root = EcoreUtil.getRootContainer(container);
		TreeIterator<EObject> it = root.eAllContents();
		while (it.hasNext()) {
			EObject next = (EObject) it.next();
			if (next instanceof org.emftext.test.resolving.Object) {
				org.emftext.test.resolving.Object nextObject = (org.emftext.test.resolving.Object) next;
				if (identifier.equals(nextObject.getId())) {
					result.addMapping(identifier, nextObject);
				}
			}
		}
	}
	
	public String deResolve(org.emftext.test.resolving.Object element, org.emftext.test.resolving.Object container, org.eclipse.emf.ecore.EReference reference) {
		return element.getId();
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		// save options in a field or leave method empty if this resolver does not depend
		// on any option
	}
}
