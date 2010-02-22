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
package org.emftext.sdk.concretesyntax.resource.cs.analysis;

import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.ecore.EReference;
import org.emftext.sdk.concretesyntax.Containment;
import org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolveResult;
import org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolver;
import org.emftext.sdk.concretesyntax.resource.cs.analysis.helper.MetaclassReferenceResolver;
import org.emftext.sdk.concretesyntax.resource.cs.analysis.helper.MetaclassReferenceResolver.CustomMatchCondition;

public class ContainmentTypesReferenceResolver implements ICsReferenceResolver<Containment, GenClass> {
	
	private MetaclassReferenceResolver resolver = new MetaclassReferenceResolver();
	
	public void resolve(String identifier, Containment container, EReference reference, int position, boolean resolveFuzzy, ICsReferenceResolveResult<GenClass> result) {
		final GenFeature feature = container.getFeature();
		final GenClass superType = (feature != null && feature.getEcoreFeature() != null)?feature.getTypeGenClass():null;
		resolver.doResolve(identifier, container, reference, position, resolveFuzzy, result, new CustomMatchCondition(){

			@Override
			public boolean matches(GenClass genClass) {
				if(superType==null||getGenClassUtil().hasSupertype(genClass,superType)){
					return true;
				}
				else{
					String message = "EClass \"" + genClass.getEcoreClass().getName() + "\" does exist, but is not a subtype of \"" + superType.getName() + "\".";					
					setMessage(message);
				}
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
