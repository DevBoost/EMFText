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
package org.emftext.sdk.analysis;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.emftext.runtime.IResourcePostProcessor;
import org.emftext.runtime.IResourcePostProcessorProvider;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.runtime.resource.impl.TextResourceHelper;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;

/**
 * An abstract super class for all syntax analysers. It tries to resolve all 
 * proxy objects and if this succeeds analyse(ITextResource, ConcreteSyntax)
 * is called.
 */
public abstract class AbstractAnalyser implements IResourcePostProcessorProvider, IResourcePostProcessor {

	private static final TextResourceHelper resourceHelper = new TextResourceHelper();
	
	public IResourcePostProcessor getResourcePostProcessor() {
		return this;
	}
	
	public void process(ITextResource resource) {
		if (!resourceHelper.resolveAll(resource)) {
			return;
		}
		EList<EObject> objects = resource.getContents();
		for (EObject next : objects) {
			if (next instanceof ConcreteSyntax) {
				analyse(resource, (ConcreteSyntax) next);
			}
		}
	}

	public abstract void analyse(ITextResource resource, ConcreteSyntax syntax);
}
