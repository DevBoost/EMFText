package org.emftext.sdk;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.emftext.runtime.IOptionProvider;
import org.emftext.runtime.IOptions;
import org.emftext.runtime.IResourcePostProcessorProvider;
import org.emftext.sdk.analysis.ChoiceAnalyser;
import org.emftext.sdk.analysis.DuplicateReferenceAnalyser;
import org.emftext.sdk.analysis.DuplicateRuleAnalyser;
import org.emftext.sdk.analysis.DuplicateTokenNameAnalyser;
import org.emftext.sdk.analysis.LeftRecursionAnalyser;
import org.emftext.sdk.analysis.MissingRulesAnalyser;
import org.emftext.sdk.analysis.ModifierAnalyser;
import org.emftext.sdk.analysis.OptionalKeywordAnalyser;
import org.emftext.sdk.analysis.ReferencesToAbstractClassesAnalyser;
import org.emftext.sdk.analysis.RegularExpressionAnalyser;
import org.emftext.sdk.analysis.TokenNameAnalyser;
import org.emftext.sdk.analysis.UnusedFeatureAnalyser;

/**
 * The SDKOptionProvider adds post-processors to the default 
 * load options for CS files. This post-processors check
 * whether CS files contain potential problems. For example,
 * checks for cases which might cause problems when parsed 
 * resources are printed are detected.
 */
public class SDKOptionProvider implements IOptionProvider {

	public Map<?, ?> getOptions() {
		Map<String, Object> options = new HashMap<String, Object>();
		// TODO add checker for constraint:
		// "Multiplicity of Structural Feature does not match Cardinality", 
		// if ( self.cardinality = null or not self.cardinality.oclIsTypeOf(STAR) ) 
		//   then true 
		//   else (self.feature.ecoreFeature.upperBound = -1)
		// endif

		LinkedList<IResourcePostProcessorProvider> postProcessors = new LinkedList<IResourcePostProcessorProvider>();
		
		postProcessors.add(new OptionalKeywordAnalyser());
		postProcessors.add(new DuplicateReferenceAnalyser());
		postProcessors.add(new ChoiceAnalyser());
		postProcessors.add(new RegularExpressionAnalyser());
		postProcessors.add(new LeftRecursionAnalyser());
		postProcessors.add(new MissingRulesAnalyser());
		postProcessors.add(new ModifierAnalyser());
		postProcessors.add(new DuplicateRuleAnalyser());
		postProcessors.add(new UnusedFeatureAnalyser());
		postProcessors.add(new TokenNameAnalyser());
		postProcessors.add(new DuplicateTokenNameAnalyser());
		postProcessors.add(new ReferencesToAbstractClassesAnalyser());
		
		options.put(IOptions.RESOURCE_POSTPROCESSOR_PROVIDER, postProcessors);
		
		return options;
	}
}
