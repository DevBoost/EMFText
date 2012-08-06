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
package org.emftext.language.mecore.resource.mecore.analysis;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.emftext.language.mecore.MClass;
import org.emftext.language.mecore.MFeature;
import org.emftext.language.mecore.resource.mecore.IMecoreReferenceResolveResult;
import org.emftext.language.mecore.resource.mecore.IMecoreReferenceResolver;

public class MFeatureOppositeReferenceResolver implements IMecoreReferenceResolver<MFeature, MFeature> {
	
	private MecoreDefaultResolverDelegate<MFeature, MFeature> delegate = new MecoreDefaultResolverDelegate<MFeature, MFeature>() {

		@Override
		public List<String> getNames(EObject eObject) {
			if (eObject instanceof MFeature) {
				MFeature element = (MFeature) eObject;
				String name = MFeatureOppositeReferenceResolver.this.getName(element);
				return Collections.singletonList(name);
			} else {
				return super.getNames(eObject);
			}
		}
	};
	
	public void resolve(String identifier, MFeature container, EReference reference, int position, boolean resolveFuzzy, final IMecoreReferenceResolveResult<MFeature> result) {
		delegate.resolve(identifier, container, reference, position, resolveFuzzy, result);
	}
	
	public String deResolve(MFeature element, MFeature container, EReference reference) {
		return getName(element);
	}
	
	private String getName(MFeature element) {
		EObject eContainer = element.eContainer();
		String name = "";
		if (eContainer instanceof MClass) {
			MClass containingClass = (MClass) eContainer;
			name += containingClass.getName();
		}
		return name + "." + element.getName();
	}

	public void setOptions(Map<?,?> options) {
		// not needed
	}
	
}
