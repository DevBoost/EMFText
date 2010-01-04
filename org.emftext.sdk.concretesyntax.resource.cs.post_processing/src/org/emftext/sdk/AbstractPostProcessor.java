/*******************************************************************************
 * Copyright (c) 2006-2010 
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
package org.emftext.sdk;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.resource.cs.ICsResourcePostProcessor;
import org.emftext.sdk.concretesyntax.resource.cs.ICsResourcePostProcessorProvider;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsProblem;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResource;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.ECsProblemType;
import org.emftext.sdk.concretesyntax.resource.cs.util.CsResourceUtil;

/**
 * An abstract super class for all post processors. It tries to resolve all 
 * proxy objects and if this succeeds analyse(ITextResource, ConcreteSyntax)
 * is called.
 */
public abstract class AbstractPostProcessor implements ICsResourcePostProcessorProvider, ICsResourcePostProcessor {

	public ICsResourcePostProcessor getResourcePostProcessor() {
		return this;
	}
	
	public void process(CsResource resource) {
		if (!(resource instanceof CsResource)) {
			return;
		}
		CsResource csResource = (CsResource) resource;
		boolean hasErrors = resource.getErrors().size() > 0;
		if (hasErrors && !doAnalysisAfterPreviousErrors()) {
			return;
		}
		if (doResolveProxiesBeforeAnalysis()) {
			// TODO it is sufficient to do this once (for the first post processor)
			if (!CsResourceUtil.resolveAll(resource)) {
				return;
			}
		}
		List<EObject> objects = resource.getContents();
		for (EObject next : objects) {
			if (next instanceof ConcreteSyntax) {
				analyse(csResource, (ConcreteSyntax) next);
			}
		}
	}

	protected boolean doAnalysisAfterPreviousErrors() {
		return false;
	}

	protected boolean doResolveProxiesBeforeAnalysis() {
		return true;
	}

	protected void addProblem(CsResource resource, ECsProblemType problemType,
			final String message, EObject cause) {
		resource.addProblem(new CsProblem(message, problemType), cause);
	}

	protected void addProblem(CsResource resource, ECsProblemType problemType,
			final String message, int i1, int i2, int i3, int i4) {
		resource.addProblem(new CsProblem(message, problemType), i1, i2, i3 ,i4);
	}

	public abstract void analyse(CsResource resource, ConcreteSyntax syntax);
}
