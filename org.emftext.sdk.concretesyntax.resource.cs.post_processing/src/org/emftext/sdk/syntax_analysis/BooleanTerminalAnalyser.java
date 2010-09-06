package org.emftext.sdk.syntax_analysis;

import java.util.Collection;

import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.concretesyntax.BooleanTerminal;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxPackage;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.ECsProblemType;
import org.emftext.sdk.util.ConcreteSyntaxUtil;
import org.emftext.sdk.util.EObjectUtil;

// TODO check that BooleanTerminals refer only to boolean attributes

// TODO check that BooleanTerminals refer only to attribute with upperBound == 1

// TODO check that trueLiteral and falseLiteral are different
// TODO check that at most one of the two literals is empty
// TODO check that the feature of the terminal is not the anonymous feature

// TODO check that there can only be multiple BooleanTerminal referring
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
				addProblem(ECsProblemType.BOOLEAN_TERMINAL_FEATURE_NOT_ATTRIBUTE, FEATURE_NOT_ATTRIBUTE, booleanTerminal);
				continue;
			}
			EAttribute eAttribute = (EAttribute) eFeature;
			EClassifier eType = eAttribute.getEType();
			if (!eType.equals(EcorePackage.eINSTANCE.getEBoolean())) {
				addProblem(ECsProblemType.BOOLEAN_TERMINAL_FEATURE_NOT_BOOLEAN, FEATURE_NOT_BOOLEAN, booleanTerminal);
				continue;
			}
			int upperBound = eAttribute.getUpperBound();
			if (upperBound != 1) {
				addProblem(ECsProblemType.BOOLEAN_TERMINAL_WRONG_FEATURE_UPPER_BOUND, WRONG_UPPER_BOUND, booleanTerminal);
				continue;
			}
			String trueLiteral = booleanTerminal.getTrueLiteral();
			String falseLiteral = booleanTerminal.getFalseLiteral();
			if ("".equals(trueLiteral) && "".equals(falseLiteral)) {
				addProblem(ECsProblemType.BOOLEAN_TERMINAL_BOTH_LITERALS_EMPTY, BOTH_LITERALS_EMPTY, booleanTerminal);
				continue;
			}
			if (trueLiteral.equals(falseLiteral)) {
				addProblem(ECsProblemType.BOOLEAN_TERMINAL_EQUAL_LITERALS, EQUAL_LITERALS, booleanTerminal);
				continue;
			}
			if (genFeature == ConcreteSyntaxUtil.ANONYMOUS_GEN_FEATURE) {
				addProblem(ECsProblemType.BOOLEAN_TERMINAL_ANONYMOUS_FEATURE, ANONYMOUS_FEATURE, booleanTerminal);
				continue;
			}
		}
	}
}
