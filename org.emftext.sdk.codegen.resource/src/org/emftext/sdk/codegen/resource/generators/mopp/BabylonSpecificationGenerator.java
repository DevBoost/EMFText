/*******************************************************************************
 * Copyright (c) 2006-2010 
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
package org.emftext.sdk.codegen.resource.generators.mopp;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.ResourceBaseGenerator;

/**
 * An experimental (not yet implemented) generator for the Babylon compiler
 * framework.
 */
// TODO cbuerger: implement this class
public class BabylonSpecificationGenerator extends ResourceBaseGenerator<ArtifactParameter<GenerationContext>> {

	public BabylonSpecificationGenerator() {
		super();
	}

	@Override
	public void doGenerate(PrintWriter out) {
		super.doGenerate(out);
		throw new UnsupportedOperationException("The " + BabylonSpecificationGenerator.class.getName() + " has not been implemented yet.");
	}
}
