/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.emftext.sdk.concretesyntax.resource.cs.ICsOptionProvider;
import org.emftext.sdk.concretesyntax.resource.cs.ICsOptions;
import org.emftext.sdk.concretesyntax.resource.cs.ICsResourcePostProcessorProvider;
import org.emftext.sdk.syntax_analysis.ChoiceAnalyser;
import org.emftext.sdk.syntax_analysis.CollectInTokenAnalyser;
import org.emftext.sdk.syntax_analysis.CyclicImportAnalyser;
import org.emftext.sdk.syntax_analysis.DuplicateReferenceAnalyser;
import org.emftext.sdk.syntax_analysis.DuplicateRuleAnalyser;
import org.emftext.sdk.syntax_analysis.DuplicateTokenNameAnalyser;
import org.emftext.sdk.syntax_analysis.DuplicateTokenStyleAnalyser;
import org.emftext.sdk.syntax_analysis.FeatureCardinalityAnalyser;
import org.emftext.sdk.syntax_analysis.GenModelAnalyser;
import org.emftext.sdk.syntax_analysis.LeftRecursionAnalyser;
import org.emftext.sdk.syntax_analysis.MissingRulesAnalyser;
import org.emftext.sdk.syntax_analysis.ModifierAnalyser;
import org.emftext.sdk.syntax_analysis.OppositeReferenceAnalyser;
import org.emftext.sdk.syntax_analysis.OptionalKeywordAnalyser;
import org.emftext.sdk.syntax_analysis.OptionsAnalyser;
import org.emftext.sdk.syntax_analysis.QuotenTokenAnalyser;
import org.emftext.sdk.syntax_analysis.ReferencesAnalyser;
import org.emftext.sdk.syntax_analysis.RegularExpressionAnalyser;
import org.emftext.sdk.syntax_analysis.StartSymbolAnalyser;
import org.emftext.sdk.syntax_analysis.TokenConflictsAnalyser;
import org.emftext.sdk.syntax_analysis.TokenNameAnalyser;
import org.emftext.sdk.syntax_analysis.TokenStyleAnalyser;
import org.emftext.sdk.syntax_analysis.UnusedFeatureAnalyser;
import org.emftext.sdk.syntax_analysis.UnusedResolverAnalyser;
import org.emftext.sdk.syntax_analysis.UnusedTokenAnalyser;
import org.emftext.sdk.syntax_annotations.SuppressWarnings;
import org.emftext.sdk.syntax_extension.DefaultTokenConnector;
import org.emftext.sdk.syntax_extension.DerivedTokenCreator;
import org.emftext.sdk.syntax_extension.PredefinedTokenAdder;
import org.emftext.sdk.syntax_extension.TokenDefinitionMerger;
import org.emftext.sdk.syntax_extension.TokenStyleMerger;

/**
 * The SDKOptionProvider adds post-processors to the default 
 * load options for CS files. This post-processors check
 * whether CS files contain potential problems. For example,
 * checks for cases which might cause problems when parsed 
 * resources are printed are detected.
 */
public class SDKOptionProvider implements ICsOptionProvider {

	public Map<?, ?> getOptions() {
		Map<String, Object> options = new HashMap<String, Object>();

		LinkedList<ICsResourcePostProcessorProvider> postProcessors = new LinkedList<ICsResourcePostProcessorProvider>();
		// first: check the generator model and make sure that there
		// are not cycles in the imports
		postProcessors.add(new GenModelAnalyser());
		postProcessors.add(new CyclicImportAnalyser());

		// second: add implicit information to the resource
		postProcessors.add(new PredefinedTokenAdder());
		postProcessors.add(new DerivedTokenCreator());
		postProcessors.add(new TokenDefinitionMerger());
		postProcessors.add(new DefaultTokenConnector());
		postProcessors.add(new TokenStyleMerger());
		
		// then analyse it
		postProcessors.add(new FeatureCardinalityAnalyser());
		postProcessors.add(new OptionalKeywordAnalyser());
		postProcessors.add(new DuplicateReferenceAnalyser());
		postProcessors.add(new ChoiceAnalyser());
		postProcessors.add(new RegularExpressionAnalyser());
		postProcessors.add(new LeftRecursionAnalyser());
		postProcessors.add(new MissingRulesAnalyser());
		postProcessors.add(new ModifierAnalyser());
		postProcessors.add(new DuplicateRuleAnalyser());
		postProcessors.add(new DuplicateTokenStyleAnalyser());
		postProcessors.add(new UnusedFeatureAnalyser());
		postProcessors.add(new TokenNameAnalyser());
		postProcessors.add(new DuplicateTokenNameAnalyser());
		postProcessors.add(new ReferencesAnalyser());
		postProcessors.add(new UnusedTokenAnalyser());
		postProcessors.add(new OptionsAnalyser());
		postProcessors.add(new StartSymbolAnalyser());
		postProcessors.add(new OppositeReferenceAnalyser());
		postProcessors.add(new UnusedResolverAnalyser());
		postProcessors.add(new TokenStyleAnalyser());
		postProcessors.add(new QuotenTokenAnalyser());
		postProcessors.add(new TokenConflictsAnalyser());
		postProcessors.add(new CollectInTokenAnalyser());
		
		postProcessors.add(new SuppressWarnings());
		
		options.put(ICsOptions.RESOURCE_POSTPROCESSOR_PROVIDER, postProcessors);
		
		return options;
	}
}
