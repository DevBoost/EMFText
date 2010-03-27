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
package org.emftext.sdk.codegen.generators.mopp;

import java.io.PrintWriter;
import java.util.Collection;

import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.GenerationProblem;
import org.emftext.sdk.codegen.IGenerator;

/**
 * An experimental (not yet implemented) generator for the SGLR compiler
 * framework.
 */
// TODO sheyden: implement this generator
public class SGLRGrammarGenerator implements IGenerator {

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
		return null;
	}
}
