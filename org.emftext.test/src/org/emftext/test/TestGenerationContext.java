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
package org.emftext.test;

import java.io.File;

import org.emftext.sdk.EPlugins;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IProblemCollector;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;

/**
 * A stub implementation of a generation context that can be used
 * to test generators.
 */
public class TestGenerationContext extends GenerationContext {

	public TestGenerationContext(ConcreteSyntax concreteSyntax,
			IProblemCollector problemCollector) {
		super(concreteSyntax, problemCollector);
	}

	@Override
	public File getProjectFolder(EPlugins plugin) {
		return null;
	}

	@Override
	public String getSyntaxProjectName() {
		return null;
	}

	@Override
	public String getProjectRelativePathToSyntaxFile() {
		return null;
	}
}
