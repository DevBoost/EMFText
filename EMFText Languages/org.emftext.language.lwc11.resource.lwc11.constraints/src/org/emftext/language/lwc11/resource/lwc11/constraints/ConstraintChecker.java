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
package org.emftext.language.lwc11.resource.lwc11.constraints;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.emftext.language.lwc11.EntityModel;
import org.emftext.language.lwc11.resource.lwc11.ILwc11OptionProvider;
import org.emftext.language.lwc11.resource.lwc11.ILwc11Options;
import org.emftext.language.lwc11.resource.lwc11.ILwc11ResourcePostProcessor;
import org.emftext.language.lwc11.resource.lwc11.ILwc11ResourcePostProcessorProvider;
import org.emftext.language.lwc11.resource.lwc11.mopp.Lwc11Resource;
import org.emftext.language.lwc11.types.NamedElement;

public class ConstraintChecker implements ILwc11OptionProvider, ILwc11ResourcePostProcessorProvider, ILwc11ResourcePostProcessor {

	public void process(Lwc11Resource resource) {
		EList<EObject> contents = resource.getContents();
		for (EObject contentObject : contents) {
			if (contentObject instanceof EntityModel) {
				EntityModel em = (EntityModel) contentObject;
				checkForDuplicateNames(em, resource);
			}
		}
	}

	private void checkForDuplicateNames(EntityModel em, Lwc11Resource resource) {
		Set<String> usedNames = new LinkedHashSet<String>();
		TreeIterator<EObject> allContents = em.eAllContents();
		while (allContents.hasNext()) {
			EObject next = allContents.next();
			if (next instanceof NamedElement) {
				NamedElement element = (NamedElement) next;
				String name = element.getName();
				if (usedNames.contains(name)) {
					resource.addError("Found duplicate name.", element);
				} else {
					usedNames.add(name);
				}
			}
		}
	}

	public ILwc11ResourcePostProcessor getResourcePostProcessor() {
		return this;
	}

	public Map<?, ?> getOptions() {
		Map<String, Object> options = new LinkedHashMap<String, Object>();
		options.put(ILwc11Options.RESOURCE_POSTPROCESSOR_PROVIDER, this);
		return options;
	}
}
