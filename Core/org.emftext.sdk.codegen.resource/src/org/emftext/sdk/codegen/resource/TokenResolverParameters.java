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
package org.emftext.sdk.codegen.resource;

import org.emftext.sdk.codegen.parameters.AbstractArtifactParameter;
import org.emftext.sdk.concretesyntax.CompleteTokenDefinition;

public class TokenResolverParameters extends AbstractArtifactParameter<GenerationContext, TokenResolverParameters> {

	private CompleteTokenDefinition definition;

	public TokenResolverParameters(CompleteTokenDefinition definition) {
		super(TextResourceArtifacts.TOKEN_RESOLVER);
		this.definition = definition;
	}

	public CompleteTokenDefinition getDefinition() {
		return definition;
	}
}
