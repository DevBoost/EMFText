package org.reuseware.emftextedit.sdk.codegen;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.reuseware.emftextedit.concretesyntax.Choice;
import org.reuseware.emftextedit.concretesyntax.CompoundDefinition;
import org.reuseware.emftextedit.concretesyntax.ConcreteSyntax;
import org.reuseware.emftextedit.concretesyntax.ConcretesyntaxFactory;
import org.reuseware.emftextedit.concretesyntax.Containment;
import org.reuseware.emftextedit.concretesyntax.Definition;
import org.reuseware.emftextedit.concretesyntax.Rule;
import org.reuseware.emftextedit.concretesyntax.Sequence;

public class PutEverywhereSyntaxExtender {
	
	public final static String PUT_EVERYWHERE_ANNOTATION = "isPutEverywhere";
	
	private final static ConcretesyntaxFactory csFactory = ConcretesyntaxFactory.eINSTANCE;

	public void generatePutEverywhereExtensions(ConcreteSyntax concreteSyntax) {
		List<Rule> rules = concreteSyntax.getRules();
		for (Rule rule : rules) {
			System.out.println("generatePutEverywhereExtensions() rule: "
					+ rule.getMetaclass().getEcoreClass().getName());
			List<GenFeature> glueFeatures = getPutEverywhereFeatures(rule);
			Choice choice = rule.getDefinition();
			generatePutEverywhereExtension(rule, choice, glueFeatures);
		}
	}

	private List<GenFeature> getPutEverywhereFeatures(Rule rule) {
		GenClass genClass = rule.getMetaclass();
		return collectPutEverywhereFeatures(genClass);
	}

	private List<GenFeature> collectPutEverywhereFeatures(GenClass genClass) {
		List<GenClass> superTypes = genClass.getAllBaseGenClasses();
		List<GenFeature> features = new ArrayList<GenFeature>();
		for (GenClass superType : superTypes) {
			features.addAll(getPutEverywhereFeatures(superType));
		}
		return features;
	}

	private List<GenFeature> getPutEverywhereFeatures(GenClass genClass) {
		List<GenFeature> features = new ArrayList<GenFeature>();
		for (GenFeature  genFeature : genClass.getGenFeatures()) {
			if (isPutEverywhereFeature(genClass, genFeature)) {
				features.add(genFeature);
			}
		}
		return features;
	}

	private void generatePutEverywhereExtension(Rule rule, Choice choice,
			List<GenFeature> glueFeatures) {
		System.out.println("generatePutEverywhereExtension() " + choice);
		if (glueFeatures.size() == 0) {
			return;
		}
		
		List<Sequence> options = choice.getOptions();
		for (Sequence sequence : options) {
			List<Definition> parts = sequence.getParts();
			int size = parts.size();
			for (int position = size - 1; position >= 0; position--) {
				Definition part = parts.get(position);
				if (part instanceof CompoundDefinition) {
					CompoundDefinition compound = (CompoundDefinition) part;
					// recursive call
					generatePutEverywhereExtension(rule, compound.getDefinitions(), glueFeatures);
				} else {
					// TODO handle all glue features
					for (GenFeature glueFeature : glueFeatures) {
						System.out.println("adding put everywhere feature " + glueFeature.getName());
						Containment containment = csFactory.createContainment();
						containment.setFeature(glueFeature);
						containment.setCardinality(csFactory.createSTAR());
						parts.add(position, containment);
					}
				}
			}
		}
	}

	private boolean isPutEverywhereFeature(GenClass genClass, GenFeature feature) {
		EClass ecoreClass = genClass.getEcoreClass();
		EAnnotation annotation = ecoreClass.getEAnnotation(PUT_EVERYWHERE_ANNOTATION);
		if (annotation != null) {
			return true;
		}
		return false;
	}
}
