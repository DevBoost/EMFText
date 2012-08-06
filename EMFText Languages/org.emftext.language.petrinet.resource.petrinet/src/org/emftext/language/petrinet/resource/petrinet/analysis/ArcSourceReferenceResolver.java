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
package org.emftext.language.petrinet.resource.petrinet.analysis;

import java.util.Map;

import org.eclipse.emf.ecore.EReference;
import org.emftext.language.petrinet.Arc;
import org.emftext.language.petrinet.Node;
import org.emftext.language.petrinet.resource.petrinet.IPetrinetReferenceResolveResult;
import org.emftext.language.petrinet.resource.petrinet.IPetrinetReferenceResolver;

public class ArcSourceReferenceResolver implements IPetrinetReferenceResolver<Arc, Node> {

	private PetrinetDefaultResolverDelegate<Arc, Node> delegate = new PetrinetDefaultResolverDelegate<Arc, Node>();

	public void resolve(String identifier, Arc container, EReference reference, int position, boolean resolveFuzzy, IPetrinetReferenceResolveResult<Node> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}

	public String deResolve(Node element, Arc container, EReference reference) {
		return delegate.deResolve(element, container, reference);
	}

	public void setOptions(Map<?,?> options) {
		// no used
	}
}
