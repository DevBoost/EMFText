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
package org.emftext.language.rails.resource.rails.analysis;

import java.util.Map;

import org.eclipse.emf.ecore.EReference;
import org.emftext.language.rails.Connection;
import org.emftext.language.rails.Out;
import org.emftext.language.rails.resource.rails.IRailsReferenceResolveResult;
import org.emftext.language.rails.resource.rails.IRailsReferenceResolver;

public class ConnectionFromReferenceResolver implements IRailsReferenceResolver<Connection, Out> {

	private RailsDefaultResolverDelegate<Connection, Out> delegate = new RailsDefaultResolverDelegate<Connection, Out>();

	public void resolve(String identifier, Connection container, EReference reference, int position, boolean resolveFuzzy, final IRailsReferenceResolveResult<Out> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}

	public String deResolve(Out element, Connection container, EReference reference) {
		return delegate.deResolve(element, container, reference);
	}

	public void setOptions(Map<?,?> options) {
		// not used
	}
}
