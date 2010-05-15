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
import java.util.Collection;

import org.emftext.sdk.codegen.GenerationProblem;
import org.emftext.sdk.codegen.ICodeGenerationComponent;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.generators.GeneratorProvider;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.ResourceBaseGenerator;

/**
 * An experimental (not yet implemented) generator for the Babylon compiler
 * framework.
 */
// TODO cbuerger: implement this class
public class BabylonSpecificationGenerator extends ResourceBaseGenerator<Object> {

	public final static GeneratorProvider<GenerationContext, Object> PROVIDER =
		new GeneratorProvider<GenerationContext, Object>(new BabylonSpecificationGenerator());
	
	private BabylonSpecificationGenerator() {
		super();
	}

	private BabylonSpecificationGenerator(ICodeGenerationComponent parent, GenerationContext context) {
	}

	public boolean generate(PrintWriter out) {
		return false;
	}

	public Collection<GenerationProblem> getCollectedErrors() {
		return null;
	}

	public Collection<GenerationProblem> getCollectedProblems() {
		return null;
	}

	public IGenerator<GenerationContext, Object> newInstance(ICodeGenerationComponent parent, GenerationContext context, Object parameters) {
		return new BabylonSpecificationGenerator(parent, context);
	}
}
