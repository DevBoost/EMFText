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
package sg.edu.nus.comp.simTL.language.java.simTL4J.resource.simTL4J.analysis;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import sg.edu.nus.comp.simTL.language.java.simTL4J.resource.simTL4J.ISimTL4JTokenResolveResult;
import sg.edu.nus.comp.simTL.language.java.simTL4J.util.CharacterEscaper;

public class SimTL4JCHARACTER_LITERALTokenResolver implements sg.edu.nus.comp.simTL.language.java.simTL4J.resource.simTL4J.ISimTL4JTokenResolver {
	
	private sg.edu.nus.comp.simTL.language.java.simTL4J.resource.simTL4J.analysis.SimTL4JDefaultTokenResolver defaultTokenResolver = new sg.edu.nus.comp.simTL.language.java.simTL4J.resource.simTL4J.analysis.SimTL4JDefaultTokenResolver();
	
	public String deResolve(Object value, EStructuralFeature feature, EObject container) {
		String result = defaultTokenResolver.deResolve(value,feature,container);
		result = CharacterEscaper.escapeEscapedCharacters(result);
		result = '\'' + result + '\'';
		return result;
	}

	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, ISimTL4JTokenResolveResult result) {
		// remove single quotes
		assert lexem.charAt(0) == '\'';
		assert lexem.charAt(lexem.length() - 1) == '\'';
		lexem = lexem.substring(1, lexem.length() - 1);
		Character character = Character.valueOf(lexem.charAt(0));
		result.setResolvedToken(character);
	}
	
	public void setOptions(java.util.Map<?,?> options) {
		defaultTokenResolver.setOptions(options);
	}
	
}
