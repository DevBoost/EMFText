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
package org.emftext.language.hedl.resource.hedl.analysis;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.jdt.core.IJavaProject;
import org.emftext.commons.jdt.JDTJavaClassifier;
import org.emftext.commons.jdt.resolve.JDTClassifierResolver;
import org.emftext.language.hedl.Entity;
import org.emftext.language.hedl.resource.hedl.IHedlReferenceResolveResult;
import org.emftext.language.hedl.resource.hedl.IHedlReferenceResolver;

public class EntityImplementedInterfacesReferenceResolver implements IHedlReferenceResolver<Entity, JDTJavaClassifier> {
	
	private final static class JDTClassCache extends AdapterImpl {
		
		private List<JDTJavaClassifier> classesInClassPath;

		public JDTClassCache(URI uri) {
			JDTClassifierResolver resolver = new JDTClassifierResolver();
			IJavaProject javaProject = resolver.getJavaProject(uri);
			if (javaProject == null) {
				return;
			}
			classesInClassPath = resolver.getAllClassifiersInClassPath(javaProject);
		}

		public List<JDTJavaClassifier> getClassifiersInClassPath() {
			return classesInClassPath;
		}
	}
	
	public void resolve(String identifier, Entity container, EReference reference, int position, boolean resolveFuzzy, IHedlReferenceResolveResult<JDTJavaClassifier> result) {
		JDTClassCache cache = null;
		EList<Adapter> eAdapters = container.eResource().getResourceSet().eAdapters();
		for (Adapter adapter : eAdapters) {
			if (adapter instanceof JDTClassCache) {
				cache = (JDTClassCache) adapter;
			}
		}
		// no cache found - create a new one
		if (cache == null) {
			cache = new JDTClassCache(container.eResource().getURI());
			eAdapters.add(cache);
		}
		
		for (JDTJavaClassifier jdtJavaClass : cache.getClassifiersInClassPath()) {
			String qualifiedName = jdtJavaClass.getQualifiedName();
			if (resolveFuzzy || identifier.equals(qualifiedName)) {
				result.addMapping(qualifiedName, jdtJavaClass);
			}
		}
	}
	
	public String deResolve(JDTJavaClassifier element, Entity container, EReference reference) {
		return element.getQualifiedName();
	}
	
	public void setOptions(Map<?,?> options) {
		// not required
	}
}
