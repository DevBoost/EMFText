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

import static sg.edu.nus.comp.simTL.language.java.simTL4J.resource.simTL4J.analysis.helper.LiteralConstants.DOUBLE_SUFFIX;
import static sg.edu.nus.comp.simTL.language.java.simTL4J.resource.simTL4J.analysis.helper.LiteralConstants.HEX_PREFIX;

import java.util.Map;

import sg.edu.nus.comp.simTL.language.java.simTL4J.literals.HexDoubleLiteral;
import sg.edu.nus.comp.simTL.language.java.simTL4J.literals.LiteralsPackage;
import sg.edu.nus.comp.simTL.language.java.simTL4J.resource.simTL4J.ISimTL4JTokenResolveResult;

public class SimTL4JHEX_DOUBLE_LITERALTokenResolver implements sg.edu.nus.comp.simTL.language.java.simTL4J.resource.simTL4J.ISimTL4JTokenResolver {
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		assert container == null || container instanceof HexDoubleLiteral;
		assert value instanceof Double;
		return Double.toHexString((Double) value);
	}

	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, ISimTL4JTokenResolveResult result) {
		assert feature == null || feature.getEContainingClass().equals(LiteralsPackage.eINSTANCE.getDoubleLiteral());
		// this assertion is wrong, because hex literals of the form 0x1P10 are also valid
		//assert lexem.contains(".");
		assert lexem.toLowerCase().startsWith(HEX_PREFIX);
		if (lexem.toLowerCase().endsWith(DOUBLE_SUFFIX)) {
			lexem = lexem.substring(0, lexem.length() - 1);
		}
		
		result.setResolvedToken(Double.parseDouble(lexem));
	}

	public void setOptions(Map<?, ?> options) {
	}
	
}
