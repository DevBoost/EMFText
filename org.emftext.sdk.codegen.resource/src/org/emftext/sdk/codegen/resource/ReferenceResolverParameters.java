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

import org.eclipse.emf.codegen.ecore.genmodel.GenFeature;
import org.emftext.sdk.codegen.parameters.AbstractArtifactParameter;

public class ReferenceResolverParameters extends AbstractArtifactParameter<GenerationContext, ReferenceResolverParameters> {

	private GenFeature reference;

	public ReferenceResolverParameters(GenFeature reference) {
		super(TextResourceArtifacts.REFERENCE_RESOLVER);
		this.reference = reference;
	}

	public GenFeature getReference() {
		return reference;
	}
}
