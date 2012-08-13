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
import org.eclipse.emf.ecore.EReference;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolveResult;
import org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolver;
import org.emftext.sdk.concretesyntax.resource.cs.analysis.helper.MetaclassReferenceResolver;
import org.emftext.sdk.concretesyntax.resource.cs.analysis.helper.MetaclassReferenceResolver.CustomMatchCondition;

public class RuleMetaclassReferenceResolver implements ICsReferenceResolver<Rule, GenClass> {
	
	private MetaclassReferenceResolver resolver = new MetaclassReferenceResolver();
	
	public void resolve(final String identifier, Rule container,
			EReference reference, int position, boolean resolveFuzzy, ICsReferenceResolveResult<GenClass> result) {
		
		ConcreteSyntax syntax = resolver.getConcreteSyntax(container);
		resolver.doResolve(identifier, syntax, resolveFuzzy, result,new CustomMatchCondition(){

			public boolean matches(GenClass genClass) {
				if(!getGenClassUtil().isNotConcrete(genClass)){
					return true;
				}
				else{
					String message = "EClass \"" + genClass.getEcoreClass().getName() + "\" does exist, but is "+(genClass.getEcoreClass().isInterface()?"interface":"abstract")+".";
					setMessage(message);
				}
				return false;
			}
			
			
		});
	}

	public String deResolve(GenClass element, Rule container, EReference reference){
		return resolver.deResolve(element, container, reference);
	}

	public void setOptions(Map<?, ?> options) {
		// do nothing - we do not need the options
	}
}
