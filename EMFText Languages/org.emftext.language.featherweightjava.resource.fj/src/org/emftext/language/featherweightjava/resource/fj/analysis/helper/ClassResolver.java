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
package org.emftext.language.featherweightjava.resource.fj.analysis.helper;

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.emftext.language.featherweightjava.Class;
import org.emftext.language.featherweightjava.FeatherweightjavaFactory;
import org.emftext.language.featherweightjava.resource.fj.IFjReferenceResolveResult;
import org.emftext.language.featherweightjava.resource.fj.util.FjEObjectUtil;

// TODO maybe we should add resolving for files that are in the same directory
public class ClassResolver {

	private final static org.emftext.language.featherweightjava.Class OBJECT = FeatherweightjavaFactory.eINSTANCE.createClass();

	static {
		OBJECT.setName("Object");
	}

	public void resolve(String identifier, EObject container,
			EReference reference, int position, boolean resolveFuzzy, IFjReferenceResolveResult<Class> result) {

		Resource resource = container.eResource();
		Collection<org.emftext.language.featherweightjava.Class> classes =
			FjEObjectUtil.getObjectsByType(resource.getAllContents(), org.emftext.language.featherweightjava.FeatherweightjavaPackage.eINSTANCE.getClass_());
		for (Class nextClass : classes) {
			if (identifier.equals(nextClass.getName())) {
				result.addMapping(identifier, nextClass);
				return;
			}
		}
		if (identifier.equals(OBJECT.getName())) {
			result.addMapping(identifier, OBJECT);
		}
	}

	public String deResolve(Class element, EObject container, EReference reference) {
		return element.getName();
	}
}
