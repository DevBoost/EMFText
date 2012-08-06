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
package org.emftext.test;

import org.emftext.sdk.codegen.IProblemCollector;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;

/**
 * A stub implementation of a generation context that can be used
 * to test generators.
 */
public class TestGenerationContext extends GenerationContext {

	public TestGenerationContext(ConcreteSyntax concreteSyntax,
			IProblemCollector problemCollector) {
		super(new TestFileSyntaxConnector(), problemCollector, concreteSyntax);
	}

	@Override
	public String getSyntaxProjectName() {
		return null;
	}

	@Override
	public String getProjectRelativePathToSyntaxFile() {
		return null;
	}

	@Override
	public boolean getGenerateANTLRPlugin() {
		return true;
	}
}
