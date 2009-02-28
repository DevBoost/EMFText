package org.emftext.sdk.analysis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.sdk.concretesyntax.Choice;
import org.emftext.sdk.concretesyntax.CompoundDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Definition;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.Sequence;
import org.emftext.sdk.concretesyntax.Terminal;

public class UnusedFeatureAnalyser extends AbstractAnalyser {

	@Override
	public void analyse(ITextResource resource, ConcreteSyntax syntax) {
		// get collect-in feature to tag them as used

		Map<EStructuralFeature, Rule> unusedReferencesWithOpposite = new HashMap<EStructuralFeature, Rule>();

		final EList<Rule> rules = syntax.getRules();
		for (Rule rule : rules) {
			GenClass genClass = rule.getMetaclass();
			if (genClass == null || genClass.eIsProxy()) {
				continue;
			}
			for (GenFeature genFeature : genClass.getAllGenFeatures()) {
				final EStructuralFeature ecoreFeature = genFeature.getEcoreFeature();
				if (ecoreFeature == null) {
					continue;
				}
				if (ecoreFeature.isDerived()) {
					continue;
				}
				if (new ConcreteSyntaxAnalyser().isCollectInFeature(rule.getSyntax(), ecoreFeature)) {
					continue;
				}
				Choice choice = rule.getDefinition();
				final boolean isUsed = isUsed(choice, genFeature);
				final EReference opposite = getOpposite(ecoreFeature);
				if (!isUsed) {
					if (opposite != null) {
						unusedReferencesWithOpposite.put(ecoreFeature, rule);
					} else {
						resource.addWarning("Feature " + genFeature.getGenClass().getName() + "." + genFeature.getName() + " has no syntax.", rule);
					}
				}
			}
		}

		List<EStructuralFeature> handledFeatures = new ArrayList<EStructuralFeature>();
		for (EStructuralFeature feature : unusedReferencesWithOpposite.keySet()) {
			if (handledFeatures.contains(feature)) {
				continue;
			}
			final EReference opposite = getOpposite(feature);
			handledFeatures.add(opposite);
			if (unusedReferencesWithOpposite.containsKey(opposite)) {
				// both are not defined
				Rule rule1 = unusedReferencesWithOpposite.get(feature);
				Rule rule2 = unusedReferencesWithOpposite.get(opposite);

				resource.addWarning("Feature " + getFeatureString(feature) + " (Opposite is " + getFeatureString(opposite) + ") has no syntax.", rule1);
				resource.addWarning("Feature " + getFeatureString(opposite) + " (Opposite is " + getFeatureString(feature) + ") has no syntax.", rule2);
			}
		}
	}

	private EReference getOpposite(EStructuralFeature ecoreFeature) {
		if (ecoreFeature instanceof EReference) {
			EReference ecoreReference = (EReference) ecoreFeature;
			return ecoreReference.getEOpposite();
		}
		return null;
	}


	private boolean isUsed(Choice choice, GenFeature genFeature) {
		for (Sequence sequence : choice.getOptions()) {
			for (Definition part : sequence.getParts()) {
				if (part instanceof Terminal) {
					Terminal terminal = (Terminal) part;
					GenFeature terminalGenFeature = terminal.getFeature();
					if (terminalGenFeature != null) {
						if (!terminalGenFeature.eIsProxy()) {
							if (genFeature.getName().equals(terminalGenFeature.getName())) {
								return true;
							}
						}
					}
				} else if (part instanceof CompoundDefinition) {
					CompoundDefinition compound = (CompoundDefinition) part;
					Choice subChoice = compound.getDefinitions();
					boolean isUsedInSubChoice = isUsed(subChoice, genFeature);
					if (isUsedInSubChoice) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private String getFeatureString(EStructuralFeature f) {
		EClass containerClass = f.getEContainingClass();
		return containerClass.getName() + "." + f.getName();
	}
}
