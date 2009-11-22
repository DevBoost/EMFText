/*******************************************************************************
 * Copyright (c) 2006-2009 
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
package org.emftext.sdk.codegen.generators;

import java.io.PrintWriter;
import java.util.Collection;

import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.GenerationProblem;
import org.emftext.sdk.codegen.IGenerator;

/**
 * An experimental (not yet implemented) generator for the Babylon compiler
 * framework.
 */
// TODO cbuerger: implement this class
public class BabylonSpecificationGenerator implements IGenerator {

	public BabylonSpecificationGenerator() {
		super();
	}

	private BabylonSpecificationGenerator(GenerationContext context) {
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

	public IGenerator newInstance(GenerationContext context) {
		return new BabylonSpecificationGenerator(context);
	}
}
