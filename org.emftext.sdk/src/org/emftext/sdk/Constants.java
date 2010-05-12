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
package org.emftext.sdk;


public interface Constants {
	
	public String JAVA_FILE_EXTENSION = ".java";

	public String CLASS_SUFFIX_TOKEN_RESOLVER     = "TokenResolver";
	public String CLASS_SUFFIX_REFERENCE_RESOLVER = "ReferenceResolver";
	public String CLASS_SUFFIX_DEFAULT_RESOLVER_DELEFATE = "DefaultResolverDelegate";

	public String ROOT_PACKAGE = "";
	public String CC_PACKAGE = "mopp";
	public String GRAMMAR_PACKAGE = "grammar";
	public String UI_PACKAGE = "ui";
	public String UTIL_PACKAGE = "util";
	public String MOPP_PACKAGE = "mopp";
	public String ANALYSIS_PACKAGE = "analysis";

	public String ANTLR_VERSION = "3_2_0";
	public String DEFAULT_ANTLR_PLUGIN_NAME = "org.emftext.commons.antlr" + ANTLR_VERSION;
	public String ANTLR_RUNTIME_PACKAGE = "org.antlr.runtime" + ANTLR_VERSION;
	
	public String ANTLR_RUNTIME_DEBUG_PACKAGE = ANTLR_RUNTIME_PACKAGE + ".debug";
	public String ANTLR_RUNTIME_MISC_PACKAGE = ANTLR_RUNTIME_PACKAGE + ".misc";
	public String ANTLR_RUNTIME_TREE_PACKAGE = ANTLR_RUNTIME_PACKAGE + ".tree";

	public String RESOURCE_PLUGIN_SUFFIX = ".resource.";
	public String RESOURCE_UI_PLUGIN_SUFFIX = "." + Constants.UI_PACKAGE;
}
