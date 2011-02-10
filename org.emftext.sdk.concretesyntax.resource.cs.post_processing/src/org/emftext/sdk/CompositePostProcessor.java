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
package org.emftext.sdk;

import java.util.LinkedList;

import org.emftext.sdk.concretesyntax.resource.cs.ICsResourcePostProcessor;
import org.emftext.sdk.concretesyntax.resource.cs.ICsResourcePostProcessorProvider;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsResource;
import org.emftext.sdk.syntax_analysis.BooleanTerminalAnalyser;
import org.emftext.sdk.syntax_analysis.ChoiceAnalyser;
import org.emftext.sdk.syntax_analysis.CollectInTokenAnalyser;
import org.emftext.sdk.syntax_analysis.CsStringAnalyser;
import org.emftext.sdk.syntax_analysis.CyclicImportAnalyser;
import org.emftext.sdk.syntax_analysis.CyclicTokenDefinitionAnalyser;
import org.emftext.sdk.syntax_analysis.DuplicateFeatureAnalyser;
import org.emftext.sdk.syntax_analysis.DuplicateRuleAnalyser;
import org.emftext.sdk.syntax_analysis.DuplicateTokenNameAnalyser;
import org.emftext.sdk.syntax_analysis.DuplicateTokenStyleAnalyser;
import org.emftext.sdk.syntax_analysis.EmptyCompoundAnalyser;
import org.emftext.sdk.syntax_analysis.FeatureCardinalityAnalyser;
import org.emftext.sdk.syntax_analysis.GenModelAnalyser;
import org.emftext.sdk.syntax_analysis.LeftRecursionAnalyser;
import org.emftext.sdk.syntax_analysis.LicenceHeaderAnalyser;
import org.emftext.sdk.syntax_analysis.MissingRulesAnalyser;
import org.emftext.sdk.syntax_analysis.ModifierAnalyser;
import org.emftext.sdk.syntax_analysis.OperatorAnnotationsValidator;
import org.emftext.sdk.syntax_analysis.OppositeReferenceAnalyser;
import org.emftext.sdk.syntax_analysis.OptionalKeywordAnalyser;
import org.emftext.sdk.syntax_analysis.OptionsAnalyser;
import org.emftext.sdk.syntax_analysis.PlaceholderInQuotesAnalyser;
import org.emftext.sdk.syntax_analysis.QuotenTokenAnalyser;
import org.emftext.sdk.syntax_analysis.ReferencesAnalyser;
import org.emftext.sdk.syntax_analysis.RegularExpressionAnalyser;
import org.emftext.sdk.syntax_analysis.StartSymbolAnalyser;
import org.emftext.sdk.syntax_analysis.SubclassRestrictionAnalyser;
import org.emftext.sdk.syntax_analysis.SyntaxNameWithDotAnalyser;
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

public class CompositePostProcessor implements ICsResourcePostProcessorProvider, ICsResourcePostProcessor {

	private final LinkedList<AbstractPostProcessor> postProcessors;
	
	private boolean terminate = false;
	
	public CompositePostProcessor() {
		super();

		postProcessors = new LinkedList<AbstractPostProcessor>();
		// first: check the generator model and make sure that there
		// are no cycles in the imports
		postProcessors.add(new GenModelAnalyser());
		postProcessors.add(new CyclicImportAnalyser());

		// second: add implicit information to the resource
		postProcessors.add(new PredefinedTokenAdder());
		postProcessors.add(new DerivedTokenCreator());
		postProcessors.add(new TokenDefinitionMerger());
		postProcessors.add(new DefaultTokenConnector());
		
		// moved to metamodel
		//postProcessors.add(new TokenStyleMerger());
		//postProcessors.add(new DefaultTokenStyleAdder());
		
		postProcessors.add(new CyclicTokenDefinitionAnalyser());
		
		// then analyse it
		postProcessors.add(new PlaceholderInQuotesAnalyser());
		postProcessors.add(new FeatureCardinalityAnalyser());
		postProcessors.add(new OptionalKeywordAnalyser());
		postProcessors.add(new DuplicateFeatureAnalyser());
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
		postProcessors.add(new CsStringAnalyser());
		postProcessors.add(new LicenceHeaderAnalyser());
		postProcessors.add(new OperatorAnnotationsValidator());
		postProcessors.add(new SyntaxNameWithDotAnalyser());
		postProcessors.add(new EmptyCompoundAnalyser());
		postProcessors.add(new BooleanTerminalAnalyser());
		postProcessors.add(new SubclassRestrictionAnalyser());
		
		postProcessors.add(new SuppressWarnings());
	}
	
	public ICsResourcePostProcessor getResourcePostProcessor() {
		// we need to create a fresh instance instead of returning 'this',
		// because we want to use fresh instances of the individual post
		// processors
		return new CompositePostProcessor();
	}

	public void process(CsResource resource) {
		PostProcessingContext context = new PostProcessingContext(resource);
		for (AbstractPostProcessor postProcessor : postProcessors) {
			if (terminate) {
				return;
			}
			postProcessor.process(context);
		}
		context.addProblemsToResource();
	}

	public void terminate() {
		this.terminate = true;
		for (AbstractPostProcessor postProcessor : postProcessors) {
			postProcessor.terminate();
		}
	}
}
