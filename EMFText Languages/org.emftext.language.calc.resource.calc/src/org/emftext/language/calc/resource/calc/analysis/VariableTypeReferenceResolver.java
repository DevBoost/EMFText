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
/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package org.emftext.language.calc.resource.calc.analysis;

import java.util.Map;

import org.eclipse.emf.ecore.EReference;
import org.emftext.language.calc.Type;
import org.emftext.language.calc.Variable;
import org.emftext.language.calc.resource.calc.ICalcReferenceResolveResult;
import org.emftext.language.calc.resource.calc.ICalcReferenceResolver;
import org.emftext.language.calc.types.CalcBuiltinTypes;

public class VariableTypeReferenceResolver implements ICalcReferenceResolver<Variable, Type> {
	
	public void resolve(String identifier, Variable container, EReference reference, int position, boolean resolveFuzzy, final ICalcReferenceResolveResult<Type> result) {
		for (Type type : CalcBuiltinTypes.ALL_BUILT_IN_TYPES) {
			String name = type.getName();
			if (name.equals(identifier) || resolveFuzzy) {
				result.addMapping(name, type);
				if (!resolveFuzzy) {
					return;
				}
			}
		}
	}
	
	public String deResolve(Type element, Variable container, EReference reference) {
		return element.getName();
	}
	
	public void setOptions(Map<?,?> options) {
		// not needed
	}
}
