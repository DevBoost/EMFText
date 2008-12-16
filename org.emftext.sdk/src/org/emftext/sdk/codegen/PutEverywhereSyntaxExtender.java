package org.emftext.sdk.codegen;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.emftext.sdk.concretesyntax.Choice;
import org.emftext.sdk.concretesyntax.CompoundDefinition;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.ConcretesyntaxFactory;
import org.emftext.sdk.concretesyntax.Containment;
import org.emftext.sdk.concretesyntax.Definition;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.Sequence;

/**
 * The PutEverywhereSyntaxExtender extends an existing concrete syntax with
 * additional containment references. This is useful if a syntax must 
 * explicitly parse comments or white-space characters (i.e., syntax elements 
 * that can occur everywhere).
 * 
 * In order to keep to the original syntax clean, users can use this extension
 * mechanism to generate parsers that create instances of the meta model for
 * comments or white-space characters.
 * 
 * The meta classes that shall be allowed everywhere must be tagged with the
 * PUT_EVERYWHERE_ANNOTATION. The concrete syntax for all subclasses of these 
 * is then extended by the PutEverywhereSyntaxExtender automatically.
 */
public class PutEverywhereSyntaxExtender {
	
	public final static String PUT_EVERYWHERE_ANNOTATION = "isPutEverywhere";
	
	private final static ConcretesyntaxFactory csFactory = ConcretesyntaxFactory.eINSTANCE;

	public void generatePutEverywhereExtensions(ConcreteSyntax concreteSyntax) {
		List<Rule> rules = concreteSyntax.getRules();
		for (Rule rule : rules) {
			boolean isStartRule = concreteSyntax.getStartSymbols().contains(rule.getMetaclass());
			//System.out.println("generatePutEverywhereExtensions() rule: " + rule.getMetaclass().getEcoreClass().getName() + " isStart="+isStartRule);
			List<GenFeature> glueFeatures = getPutEverywhereFeatures(rule);
			Choice choice = rule.getDefinition();
			generatePutEverywhereExtension(rule, choice, glueFeatures, isStartRule);
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
			List<GenFeature> glueFeatures, boolean isStartRule) {
		//System.out.println("generatePutEverywhereExtension() " + choice);
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
					generatePutEverywhereExtension(rule, compound.getDefinitions(), glueFeatures, false);
				} else {
					// TODO handle all glue features
					addGlueFeatures(glueFeatures, parts, position);
				}
			}
			// the start symbol must be extended with puteverywhere features at the last position
			if (isStartRule) {
				addGlueFeatures(glueFeatures, parts, -1);
			}
		}
	}

	private void addGlueFeatures(List<GenFeature> glueFeatures,
			List<Definition> parts, int position) {
		for (GenFeature glueFeature : glueFeatures) {
			addGlueFeature(parts, position, glueFeature);
		}
	}

	private void addGlueFeature(List<Definition> parts, int position,
			GenFeature glueFeature) {
		//System.out.println("adding put everywhere feature " + glueFeature.getName());
		Containment containment = csFactory.createContainment();
		containment.setFeature(glueFeature);
		containment.setCardinality(csFactory.createSTAR());
		if (position < 0) {
			parts.add(containment);
		} else {
			parts.add(position, containment);
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
