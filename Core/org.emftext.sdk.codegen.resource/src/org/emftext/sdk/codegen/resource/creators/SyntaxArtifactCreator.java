/*******************************************************************************
 * Copyright (c) 2006-2012
 * Software Technology Group, Dresden University of Technology
 * DevBoost GmbH, Berlin, Amtsgericht Charlottenburg, HRB 140026
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany;
 *   DevBoost GmbH - Berlin, Germany
 *      - initial API and implementation
 ******************************************************************************/
package org.emftext.sdk.codegen.resource.creators;

import org.emftext.sdk.OptionManager;
import org.emftext.sdk.codegen.IArtifactParameter;
import org.emftext.sdk.codegen.creators.GenericArtifactCreator;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class SyntaxArtifactCreator<ParameterType extends IArtifactParameter<GenerationContext, ParameterType>> 
	extends GenericArtifactCreator<GenerationContext, ParameterType> {

	/*
	public SyntaxArtifactCreator(ArtifactDescriptor<GenerationContext, ArtifactParameter<GenerationContext, Object>> artifact) {
		super(artifact, new ArtifactParameter<GenerationContext, Object>());
	}
	*/

	public SyntaxArtifactCreator(ParameterType parameters) {
		super(parameters);
	}

	@Override
	public boolean doOverride(GenerationContext context) {
		OptionTypes overrideOption = getParameters().getArtifact().getOverrideOption();
		if (overrideOption == null) {
			return true;
		}
		
		ConcreteSyntax syntax = context.getConcreteSyntax();
		boolean override = OptionManager.INSTANCE.getBooleanOptionValue(syntax, overrideOption);
		return override;
	}
}
