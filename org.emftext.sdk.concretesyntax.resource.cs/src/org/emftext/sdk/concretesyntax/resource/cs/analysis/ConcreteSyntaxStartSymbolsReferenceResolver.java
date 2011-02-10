/*******************************************************************************
 * Copyright (c) 2006-2011
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

import java.util.List;
import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.ecore.EReference;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolveResult;
import org.emftext.sdk.concretesyntax.resource.cs.ICsReferenceResolver;
import org.emftext.sdk.concretesyntax.resource.cs.analysis.helper.MetaclassReferenceResolver;
import org.emftext.sdk.concretesyntax.resource.cs.analysis.helper.MetaclassReferenceResolver.CustomMatchCondition;

public class ConcreteSyntaxStartSymbolsReferenceResolver implements ICsReferenceResolver<ConcreteSyntax, GenClass> {
	
	private MetaclassReferenceResolver resolver = new MetaclassReferenceResolver();
	
	public void resolve(String identifier, final ConcreteSyntax container,
			EReference reference, int position, boolean resolveFuzzy, ICsReferenceResolveResult<GenClass> result) {
		
		ConcreteSyntax syntax = resolver.getConcreteSyntax(container);
		resolver.doResolve(identifier, syntax, resolveFuzzy, result, new CustomMatchCondition() {

			@Override
			public boolean matches(GenClass genClass) {
				boolean isOperatorMetaClass = isCommonOperatorMetaClass(genClass.getName());
				boolean isConcrete = getGenClassUtil().isConcrete(genClass);
				if (isConcrete) {
					if (isOperatorMetaClass) {
						String message = "EClass \"" + genClass.getEcoreClass().getName() + "\" does exist, but is concrete and a common operator metaclass, which is not allowed.";						
						setMessage(message);
						return false;
					}
					else {
						return true;						
					}
				}
				else{
					if (!isOperatorMetaClass) {
						String message = "EClass \"" + genClass.getEcoreClass().getName() + "\" does exist, but is "+(genClass.getEcoreClass().isInterface()?"interface":"abstract")+" and not a common operator metaclass.";						
						setMessage(message);
					}	
					else {
						return true;
					}
				}
				return false;
			}
			
			private boolean isCommonOperatorMetaClass(String operatorSliceName){
				List<Rule> operatorSlice = container.getOperatorRuleSubset(operatorSliceName);
				if(!operatorSlice.isEmpty()){
					return true;
				}
				return false;
			}
			
		});
	}

	public String deResolve(GenClass element, ConcreteSyntax container, EReference reference) {
		// TODO this does not correctly work when GenClasses are referenced 
		// using the prefix notation (e.g., namespace.MyGenClass)
		return resolver.deResolve(element, container, reference);
	}

	public void setOptions(Map<?, ?> options) {
		// do nothing - we do not need the options
	}
}
