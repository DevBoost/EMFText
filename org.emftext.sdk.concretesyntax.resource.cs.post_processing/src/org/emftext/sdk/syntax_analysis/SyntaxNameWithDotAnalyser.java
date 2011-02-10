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
package org.emftext.sdk.syntax_analysis;

import org.emftext.sdk.AbstractPostProcessor;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.Option;
import org.emftext.sdk.concretesyntax.OptionTypes;
import org.emftext.sdk.concretesyntax.resource.cs.mopp.CsAnalysisProblemType;

/**
 * An analyser that checks that the "baseResourcePlugin" option is set if the 
 * syntax name contains a dot. This is needed, because the dot indicates a
 * secondary syntax that needs to be selected explicitly by a custom 
 * ResourceFactory. Such ResourceFactory implementation must reside in the
 * base resource plug-in.
 * 
 * The analyser does also check that the syntax does not contain more than 
 * one dot.
 * 
 * TODO add quick fix that sets the baseResourcePlugin option
 */
public class SyntaxNameWithDotAnalyser extends AbstractPostProcessor {

	private static final String SYNTAX_NAME_MAY_CONTAIN_ONE_DOT_MAX = 
		"The syntax name must not contain more than one dot.";
	
	private static final String BASE_RESOURCE_PLUGIN_OPTION_MISSING = 
		"If the syntax name contains one dot, the option '" + OptionTypes.BASE_RESOURCE_PLUGIN.getLiteral() + "' needs to be specified.";

	@Override
	public void analyse(ConcreteSyntax syntax) {
		int numberOfDots = syntax.getName().split("\\.").length - 1;
		
		if (numberOfDots == 1) {
			//look for baseResourcePlugin option
			for(Option option : syntax.getOptions()) {
				if (option.getType() == OptionTypes.BASE_RESOURCE_PLUGIN) {
					return;
				}
			}
			addProblem(
					CsAnalysisProblemType.SYNTAX_NAME_CONTAINS_DOTS,
					BASE_RESOURCE_PLUGIN_OPTION_MISSING,
					syntax);
			return;
		}
		if (numberOfDots > 1) {
			addProblem(
					CsAnalysisProblemType.SYNTAX_NAME_CONTAINS_DOTS,
					SYNTAX_NAME_MAY_CONTAIN_ONE_DOT_MAX,
					syntax);
			return;
		}
	}

}
