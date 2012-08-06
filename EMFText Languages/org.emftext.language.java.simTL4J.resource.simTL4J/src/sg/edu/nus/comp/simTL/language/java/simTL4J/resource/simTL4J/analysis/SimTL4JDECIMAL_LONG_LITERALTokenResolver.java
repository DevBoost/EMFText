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

import static sg.edu.nus.comp.simTL.language.java.simTL4J.resource.simTL4J.analysis.helper.LiteralConstants.LONG_SUFFIX;

import java.math.BigInteger;
import java.util.Map;

import sg.edu.nus.comp.simTL.language.java.simTL4J.literals.DecimalLongLiteral;
import sg.edu.nus.comp.simTL.language.java.simTL4J.literals.LiteralsPackage;
import sg.edu.nus.comp.simTL.language.java.simTL4J.resource.simTL4J.ISimTL4JTokenResolveResult;

public class SimTL4JDECIMAL_LONG_LITERALTokenResolver implements sg.edu.nus.comp.simTL.language.java.simTL4J.resource.simTL4J.ISimTL4JTokenResolver {
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		assert container == null || container instanceof DecimalLongLiteral;
		assert value instanceof BigInteger;
		return value.toString() + LONG_SUFFIX;
	}

	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, ISimTL4JTokenResolveResult result) {
		assert feature == null || feature.getEContainingClass().equals(LiteralsPackage.eINSTANCE.getLongLiteral());
		assert lexem.toLowerCase().endsWith(LONG_SUFFIX);

		lexem = lexem.substring(0, lexem.length() - 1);
		parseToLong(lexem, 10, result);
	}

	public static void parseToLong(String lexem, int radix, ISimTL4JTokenResolveResult result) throws NumberFormatException {
		try {
			BigInteger tempInteger = new BigInteger(lexem, radix);
			result.setResolvedToken(tempInteger);
		} catch (NumberFormatException nfe) {
			result.setErrorMessage(nfe.getClass().getSimpleName() + ": " + nfe.getMessage());
		}
	}

	public void setOptions(Map<?, ?> options) {
	}
	
}
