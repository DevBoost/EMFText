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
package org.emftext.sdk.syntax_analysis;

import java.util.Collection;

import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.concretesyntax.BooleanTerminal;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsAnalysisProblemType;
import org.emftext.sdk.util.ConcreteSyntaxUtil;
import org.emftext.sdk.util.EObjectUtil;

// TODO mseifert: check that there can only be multiple BooleanTerminals referring
//      to the same feature if no literal is empty (otherwise empty syntax
//      is allowed for one of the values and it is not clear how often this
//      value must be added to the attribute's list of values)
public class BooleanTerminalAnalyser extends AbstractPostProcessor {

	private static final String FEATURE_NOT_ATTRIBUTE = "Only attributes (no references) can be used with boolean terminals.";
	private static final String FEATURE_NOT_BOOLEAN = "Only boolean attributes can be used with boolean terminals.";
	private static final String WRONG_UPPER_BOUND = "Attributes must have upper bound of 1 to be used with a boolean terminal.";
	private static final String EQUAL_LITERALS = "Literals of boolean terminals must be different.";
	private static final String BOTH_LITERALS_EMPTY = "At most one literal can be empty.";
	private static final String ANONYMOUS_FEATURE = "The anonymous feature can not be used with boolean terminals.";

	@Override
	public void analyse(ConcreteSyntax syntax) {
		Collection<BooleanTerminal> booleanTerminals = EObjectUtil.getObjectsByType(syntax.eAllContents(), ConcretesyntaxPackage.eINSTANCE.getBooleanTerminal());
		for (BooleanTerminal booleanTerminal : booleanTerminals) {
			GenFeature genFeature = booleanTerminal.getFeature();
			EStructuralFeature eFeature = genFeature.getEcoreFeature();
			if (!(eFeature instanceof EAttribute)) {
				addProblem(CsAnalysisProblemType.BOOLEAN_TERMINAL_FEATURE_NOT_ATTRIBUTE, FEATURE_NOT_ATTRIBUTE, booleanTerminal);
				continue;
			}
			EAttribute eAttribute = (EAttribute) eFeature;
			EClassifier eType = eAttribute.getEType();
			EDataType eBoolean = EcorePackage.eINSTANCE.getEBoolean();
			if (!eType.getInstanceClass().equals(eBoolean.getInstanceClass())) {
				addProblem(CsAnalysisProblemType.BOOLEAN_TERMINAL_FEATURE_NOT_BOOLEAN, FEATURE_NOT_BOOLEAN, booleanTerminal);
				continue;
			}
			int upperBound = eAttribute.getUpperBound();
			if (upperBound != 1) {
				addProblem(CsAnalysisProblemType.BOOLEAN_TERMINAL_WRONG_FEATURE_UPPER_BOUND, WRONG_UPPER_BOUND, booleanTerminal);
				continue;
			}
			String trueLiteral = booleanTerminal.getTrueLiteral();
			String falseLiteral = booleanTerminal.getFalseLiteral();
			if ("".equals(trueLiteral) && "".equals(falseLiteral)) {
				addProblem(CsAnalysisProblemType.BOOLEAN_TERMINAL_BOTH_LITERALS_EMPTY, BOTH_LITERALS_EMPTY, booleanTerminal);
				continue;
			}
			if (trueLiteral.equals(falseLiteral)) {
				addProblem(CsAnalysisProblemType.BOOLEAN_TERMINAL_EQUAL_LITERALS, EQUAL_LITERALS, booleanTerminal);
				continue;
			}
			if (genFeature == ConcreteSyntaxUtil.ANONYMOUS_GEN_FEATURE) {
				addProblem(CsAnalysisProblemType.BOOLEAN_TERMINAL_ANONYMOUS_FEATURE, ANONYMOUS_FEATURE, booleanTerminal);
				continue;
			}
		}
	}
}
