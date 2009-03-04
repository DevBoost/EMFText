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

import org.emftext.runtime.IOptionProvider;
import org.emftext.runtime.IOptions;
import org.emftext.runtime.IResourcePostProcessorProvider;
import org.emftext.sdk.analysis.ChoiceAnalyser;
import org.emftext.sdk.analysis.DuplicateReferenceAnalyser;
import org.emftext.sdk.analysis.DuplicateRuleAnalyser;
import org.emftext.sdk.analysis.DuplicateTokenNameAnalyser;
import org.emftext.sdk.analysis.FeatureCardinalityAnalyser;
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

		LinkedList<IResourcePostProcessorProvider> postProcessors = new LinkedList<IResourcePostProcessorProvider>();
		postProcessors.add(new FeatureCardinalityAnalyser());
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
