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
package org.emftext.sdk.codegen;

import org.emftext.sdk.concretesyntax.OptionTypes;

public interface Constants {

	public IPackage<ISyntaxContext> ROOT_PACKAGE = new ResourcePackage<ISyntaxContext>(OptionTypes.BASE_PACKAGE, "", "");
	public IPackage<ISyntaxContext> CC_PACKAGE = new ResourcePackage<ISyntaxContext>(OptionTypes.BASE_PACKAGE, "", "mopp");
	public IPackage<ISyntaxContext> GRAMMAR_PACKAGE = new ResourcePackage<ISyntaxContext>(OptionTypes.BASE_PACKAGE, "", "grammar");
	public IPackage<ISyntaxContext> UTIL_PACKAGE = new ResourcePackage<ISyntaxContext>(OptionTypes.BASE_PACKAGE, "", "util");
	public IPackage<ISyntaxContext> MOPP_PACKAGE = new ResourcePackage<ISyntaxContext>(OptionTypes.BASE_PACKAGE, "", "mopp");
	public IPackage<ISyntaxContext> ANALYSIS_PACKAGE = new ResourcePackage<ISyntaxContext>(OptionTypes.BASE_PACKAGE, "", "analysis");

	public String UI_SUFFIX = "ui";
	public String RESOURCE_UI_PLUGIN_SUFFIX = "." + UI_SUFFIX;
	public IPackage<ISyntaxContext> UI_PACKAGE = new ResourcePackage<ISyntaxContext>(OptionTypes.UI_BASE_PACKAGE, RESOURCE_UI_PLUGIN_SUFFIX, "");
}
