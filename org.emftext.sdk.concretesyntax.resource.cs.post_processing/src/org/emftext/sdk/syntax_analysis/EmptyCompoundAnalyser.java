package org.emftext.sdk.syntax_analysis;

import org.eclipse.emf.common.util.EList;
import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.concretesyntax.Cardinality;
import org.emftext.sdk.concretesyntax.CardinalityDefinition;
import org.emftext.sdk.concretesyntax.Choice;
import org.emftext.sdk.concretesyntax.CompoundDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.CsString;
import org.emftext.sdk.concretesyntax.LineBreak;
import org.emftext.sdk.concretesyntax.PLUS;
import org.emftext.sdk.concretesyntax.QUESTIONMARK;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.STAR;
import org.emftext.sdk.concretesyntax.Sequence;
import org.emftext.sdk.concretesyntax.SyntaxElement;
import org.emftext.sdk.concretesyntax.WhiteSpaces;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResource;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.ECsProblemType;

public class EmptyCompoundAnalyser extends AbstractPostProcessor {

	@Override
	public void analyse(CsResource resource, ConcreteSyntax syntax) {
		EList<Rule> rules = syntax.getRules();
		for (Rule rule : rules) {
			EList<SyntaxElement> children = rule.getChildren();
			checkCompounds(resource, children);
		}
	}

	private void checkCompounds(CsResource resource,
			EList<SyntaxElement> children) {
		for (SyntaxElement syntaxElement : children) {
			if (syntaxElement instanceof CompoundDefinition) {
				CompoundDefinition compound = (CompoundDefinition) syntaxElement;
				if (compound.getCardinality() instanceof PLUS ||
					compound.getCardinality() instanceof STAR) {
					// check whether the compound allows the empty sentence
					if (canBeEmpty(compound.getDefinition())) {
						addProblem(resource, ECsProblemType.EMPTY_COMPOUND, "Compounds with * or + must not allow empty syntax.", compound);
					}
				}
			}
			checkCompounds(resource, syntaxElement.getChildren());
		}
	}

	private boolean canBeEmpty(SyntaxElement element) {
		if (element instanceof LineBreak) {
			return true;
		}
		if (element instanceof WhiteSpaces) {
			return true;
		}
		if (element instanceof CsString) {
			return false;
		}
		if (element instanceof CardinalityDefinition) {
			CardinalityDefinition cd = (CardinalityDefinition) element;
			Cardinality cardinality = cd.getCardinality();
			return cardinality instanceof STAR || cardinality instanceof QUESTIONMARK;
		}
		if (element instanceof CompoundDefinition) {
			CompoundDefinition compound = (CompoundDefinition) element;
			EList<SyntaxElement> children = compound.getChildren();
			boolean canBeEmpty = true;
			for (SyntaxElement child : children) {
				canBeEmpty &= canBeEmpty(child);
			}
			return canBeEmpty;
		}
		if (element instanceof Choice) {
			Choice choice = (Choice) element;
			EList<SyntaxElement> children = choice.getChildren();
			boolean canBeEmpty = true;
			for (SyntaxElement child : children) {
				// TODO check how ANTLR behaves in this case
				canBeEmpty &= canBeEmpty(child);
			}
			return canBeEmpty;
		}
		if (element instanceof Sequence) {
			Sequence sequence = (Sequence) element;
			EList<SyntaxElement> children = sequence.getChildren();
			for (SyntaxElement child : children) {
				if (!canBeEmpty(child)) {
					return false;
				}
			}
			return true;
		}
		if (element instanceof Rule) {
			Rule rule = (Rule) element;
			EList<SyntaxElement> children = rule.getChildren();
			boolean canBeEmpty = true;
			for (SyntaxElement child : children) {
				canBeEmpty &= canBeEmpty(child);
			}
			return canBeEmpty;
		}
		throw new RuntimeException("Unknown syntax element found.");
	}
}
