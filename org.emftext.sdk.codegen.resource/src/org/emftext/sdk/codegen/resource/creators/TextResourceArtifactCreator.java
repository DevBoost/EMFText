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
import org.emftext.sdk.concretesyntax.OptionTypes;

public abstract class TextResourceArtifactCreator<ParameterType extends IArtifactParameter<GenerationContext, ParameterType>> extends GenericArtifactCreator<GenerationContext, ParameterType> {

	public TextResourceArtifactCreator(ParameterType parameters) {
		super(parameters);
	}

	public boolean doOverride(GenerationContext context) {
		return OptionManager.INSTANCE.doOverride(context.getConcreteSyntax(), getOverrideOption());
	}

	/**
	 * Returns the option that enables/disables this
	 * creator. If the option is set to true the creator
	 * should create or override the artifact. Otherwise
	 * the artifact should be created only in case it does
	 * not exist yet.
	 * 
	 * @return the option to enabled this creator
	 */
	public OptionTypes getOverrideOption() {
		return getParameters().getArtifact().getOverrideOption();
	}
}
