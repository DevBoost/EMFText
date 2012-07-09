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
package org.emftext.sdk.concretesyntax.resource.cs.analysis;

import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.ecore.EReference;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Containment;
import org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolveResult;
import org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolver;
import org.emftext.sdk.concretesyntax.resource.cs.analysis.helper.MetaclassReferenceResolver;
import org.emftext.sdk.concretesyntax.resource.cs.analysis.helper.MetaclassReferenceResolver.CustomMatchCondition;

public class ContainmentTypesReferenceResolver implements ICsReferenceResolver<Containment, GenClass> {
	
	private MetaclassReferenceResolver resolver = new MetaclassReferenceResolver();
	
	public void resolve(String identifier, Containment container, EReference reference, int position, boolean resolveFuzzy, ICsReferenceResolveResult<GenClass> result) {
		final GenFeature feature = container.getFeature();
		final GenClass featureType = (feature != null && feature.getEcoreFeature() != null)?feature.getTypeGenClass():null;
		final ConcreteSyntax syntax = resolver.getConcreteSyntax(container);
		
		resolver.doResolve(identifier, syntax, resolveFuzzy, result, new CustomMatchCondition() {

			@Override
			public boolean matches(GenClass genClass) {
				if (featureType == null) {
					return true;
				}
				// using the type of the feature as containment restriction
				// doesn't make sense since this does not restrict the type
				// any further, but we still allow it.
				if (genClass.getQualifiedClassName().equals(featureType.getQualifiedClassName())) {
					return true;
				}
				if (getGenClassUtil().isSuperClass(featureType, genClass, syntax.getGenClassCache())) {
					return true;
				}
				
				String message = "EClass \"" + genClass.getEcoreClass().getName() + "\" does exist, but is not a subtype of \"" + featureType.getName() + "\".";					
				setMessage(message);
				return false;
			}
			
		});
	}

	public String deResolve(GenClass element, Containment container, EReference reference) {
		return resolver.deResolve(element, container, reference);
	}

	public void setOptions(Map<?, ?> options) {
		// do nothing - we do not need the options
	}
}
