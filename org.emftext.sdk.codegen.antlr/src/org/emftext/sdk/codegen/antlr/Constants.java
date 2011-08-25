/*******************************************************************************
 * Copyright (c) 2006-2011
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
package org.emftext.sdk.codegen.antlr;

import org.emftext.sdk.codegen.BasicPackage;
import org.emftext.sdk.codegen.IPackage;
import org.emftext.sdk.codegen.ISyntaxContext;

public interface Constants {

	public String ANTLR_VERSION = "3_4_0";
	public String DEFAULT_ANTLR_PLUGIN_NAME = "org.emftext.commons.antlr" + ANTLR_VERSION;
	
	public IPackage<ISyntaxContext> ANTLR_RUNTIME_PACKAGE = new BasicPackage<ISyntaxContext>("org.antlr.runtime" + ANTLR_VERSION);
	
	public IPackage<ISyntaxContext> ANTLR_RUNTIME_DEBUG_PACKAGE = new BasicPackage<ISyntaxContext>(ANTLR_RUNTIME_PACKAGE.getName(null) + ".debug");
	public IPackage<ISyntaxContext> ANTLR_RUNTIME_MISC_PACKAGE = new BasicPackage<ISyntaxContext>(ANTLR_RUNTIME_PACKAGE.getName(null) + ".misc");
	public IPackage<ISyntaxContext> ANTLR_RUNTIME_TREE_PACKAGE = new BasicPackage<ISyntaxContext>(ANTLR_RUNTIME_PACKAGE.getName(null) + ".tree");
}
