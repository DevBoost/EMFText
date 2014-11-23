/*******************************************************************************
 * Copyright (c) 2006-2014
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
package org.emftext.sdk.codegen.resource.generators.code_completion.helpers;

import java.util.Stack;

import org.eclipse.emf.codegen.ecore.genmodel.GenClass;

/**
 * The {@link MetaclassStack} is used by the {@link ExpectationComputer} to keep track which meta class have been
 * visited while computing FIRST and FOLLOW sets. Keeping track of this is required to avoid {@link StackOverflowError}s
 * for (left-)recursive grammars.
 * <p>
 * Previously, a set was used instead of a stack, but this did not consider the scoping when diving into sub rules while
 * computing the FIRST and FOLLOW sets. Once a meta class was visited in one branch of the depth first search it was not
 * considered in other branches anymore. This let to problems with the code completion, because the FIRST/FOLLOW
 * elements from the other branches were missing and therefore completion proposals were also missing.
 */
public class MetaclassStack {

	private final Stack<GenClass> metaClasses = new Stack<GenClass>();
	
	public void push(GenClass metaClass) {
		metaClasses.push(metaClass);
	}

	public boolean contains(GenClass metaClass) {
		return metaClasses.contains(metaClass);
	}

	public void pop() {
		metaClasses.pop();
	}
}
