package org.emftext.sdk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.eclipse.emf.ecore.EObject;
import org.emftext.runtime.IOptionProvider;
import org.emftext.runtime.IOptions;
import org.emftext.runtime.IResourcePostProcessor;
import org.emftext.runtime.IResourcePostProcessorProvider;
import org.emftext.runtime.resource.ITextResource;
import org.emftext.sdk.concretesyntax.Choice;
import org.emftext.sdk.concretesyntax.CompoundDefinition;
import org.emftext.sdk.concretesyntax.CsString;
import org.emftext.sdk.concretesyntax.Definition;
import org.emftext.sdk.concretesyntax.QUESTIONMARK;
import org.emftext.sdk.concretesyntax.Rule;
import org.emftext.sdk.concretesyntax.STAR;
import org.emftext.sdk.concretesyntax.Sequence;
import org.emftext.sdk.concretesyntax.Terminal;

public class SDKOptionProvider implements IOptionProvider {

	private static final String OPTIONAL_KEYWORD_WARNING = 
		"The keyword might be used stand alone and will not be reprinted in such case: ";
	private static final String MULTIPLE_FEATURE_WARNING = 
		"The follwing feature is used twice in rule. Reprinting may fail for: ";
	
	public Map<?, ?> getOptions() {
		Map<String, Object> options = new HashMap<String, Object>();
		options.put(IOptions.RESOURCE_POSTPROCESSOR_PROVIDER, new IResourcePostProcessorProvider() {

			public IResourcePostProcessor getResourcePostProcessor() {
				return new IResourcePostProcessor() {
					public void process(ITextResource resource) {
						checkForOptionalKeywords(resource);
						//checkForDuplicateReferences(resource);
					}
				};
			}
			
		});
		return options;
	}

	private void checkForOptionalKeywords(ITextResource resource) {
		for(Iterator<EObject> i = resource.getAllContents(); i.hasNext(); ) {
			EObject next = i.next();
			if (next instanceof CompoundDefinition) {
				CompoundDefinition compoundDefinition = (CompoundDefinition) next;
				if (compoundDefinition.getCardinality() instanceof QUESTIONMARK) {
					for (Sequence sequence : compoundDefinition.getDefinitions().getOptions()) {
						boolean containsKeyword = false;
						boolean restOptional = true;
						
						for (Definition definition : sequence.getParts()) {
							
							if (definition instanceof CsString) {
								containsKeyword = true;
							}
							else if (!(definition.getCardinality() instanceof QUESTIONMARK ||
									definition.getCardinality() instanceof STAR)) {
								restOptional = false;
							}
						}
						if(containsKeyword && restOptional) {
							for (Definition definition : sequence.getParts()) {
								if (definition instanceof CsString) {
									CsString csString = (CsString) definition;
									resource.addWarning(
											OPTIONAL_KEYWORD_WARNING + csString.getValue(),
											definition);
								}
							}
						}
					}
				}
			}
		}
	}

	private void checkForDuplicateReferences(ITextResource resource) {
		for(Iterator<EObject> i = resource.getAllContents(); i.hasNext(); ) {
			EObject next = i.next();
			if (next instanceof Rule) {
				List<GenFeature> features = collectReferencedFeatures((Rule) next);
				for (GenFeature feature : features) {
					if (isContainedMoreThanOnce(feature, features)) {
						resource.addWarning(
								MULTIPLE_FEATURE_WARNING + feature.getEcoreFeature().getName(),
								next);
					}
				}
			}
		}
	}

	private boolean isContainedMoreThanOnce(GenFeature feature,
			List<GenFeature> features) {
		int count = 0;
		for (GenFeature next : features) {
			if (next.equals(feature)) {
				count++;
			}
		}
		return count > 1;
	}

	private List<GenFeature> collectReferencedFeatures(Rule rule) {
		return collectReferencedFeatures(rule.getDefinition());
	}
	
	private List<GenFeature> collectReferencedFeatures(Choice choice) {
		List<GenFeature> result = new ArrayList<GenFeature>();
		List<Sequence> choices = choice.getOptions();
		for (Sequence sequence : choices) {
			List<Definition> definitions = sequence.getParts();
			for (Definition definition : definitions) {
				// TODO incorporate cardinality of the definition, because
				// not all combinations of cardinalities cause reprint problems
				if (definition instanceof Terminal) {
					Terminal terminal = (Terminal) definition;
					result.add(terminal.getFeature());
				} else if (definition instanceof CompoundDefinition) {
					CompoundDefinition compound = (CompoundDefinition) definition;
					Choice subChoice = compound.getDefinitions();
					result.addAll(collectReferencedFeatures(subChoice));
				}
			}
		}
		return result;
	}
}
