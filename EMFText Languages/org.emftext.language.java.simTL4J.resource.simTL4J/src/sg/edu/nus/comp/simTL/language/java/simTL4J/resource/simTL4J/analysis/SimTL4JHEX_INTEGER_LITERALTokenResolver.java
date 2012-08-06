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

import static sg.edu.nus.comp.simTL.language.java.simTL4J.resource.simTL4J.analysis.helper.LiteralConstants.HEX_PREFIX;

import java.math.BigInteger;
import java.util.Map;

import sg.edu.nus.comp.simTL.language.java.simTL4J.literals.HexIntegerLiteral;
import sg.edu.nus.comp.simTL.language.java.simTL4J.literals.LiteralsPackage;
import sg.edu.nus.comp.simTL.language.java.simTL4J.resource.simTL4J.ISimTL4JTokenResolveResult;

public class SimTL4JHEX_INTEGER_LITERALTokenResolver implements sg.edu.nus.comp.simTL.language.java.simTL4J.resource.simTL4J.ISimTL4JTokenResolver {
	
	public java.lang.String deResolve(java.lang.Object value, org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.ecore.EObject container) {
		assert container == null || container instanceof HexIntegerLiteral;
		assert value instanceof BigInteger;
		return HEX_PREFIX + ((BigInteger) value).toString(16);
	}

	public void resolve(java.lang.String lexem, org.eclipse.emf.ecore.EStructuralFeature feature, ISimTL4JTokenResolveResult result) {
		assert feature == null || feature.getEContainingClass().equals(LiteralsPackage.eINSTANCE.getIntegerLiteral());
		assert lexem.toLowerCase().startsWith(HEX_PREFIX);
		
		lexem = lexem.substring(2);
		
		SimTL4JDECIMAL_LONG_LITERALTokenResolver.parseToLong(lexem, 16, result);
	}

	public void setOptions(Map<?, ?> options) {
	}
	
}
