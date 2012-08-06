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
package org.emftext.sdk.codegen;

import org.emftext.sdk.Constants;
import org.emftext.sdk.codegen.util.NameUtil;
import org.emftext.sdk.concretesyntax.ConcreteSyntax;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class ResourcePackage<ContextType extends ISyntaxContext> implements IPackage<ContextType> {

	private final static NameUtil nameUtil = new NameUtil();
	
	private String subPackage;
	private String basePackageSuffix;
	private OptionTypes basePackageOption;
	
	public ResourcePackage(OptionTypes basePackageOption, String basePackageSuffix, String subPackage) {
		super();
		this.basePackageOption = basePackageOption;
		this.basePackageSuffix = basePackageSuffix;
		this.subPackage = subPackage;
	}

	public String getName(ContextType context) {
		ConcreteSyntax syntax = context.getConcreteSyntax();
		String basePackage = nameUtil.getBasePackage(syntax, Constants.RESOURCE_PLUGIN_SUFFIX, basePackageSuffix, basePackageOption);
		if (basePackage == null || "".equals(basePackage)) {
			return subPackage;
		} else {
			if ("".equals(subPackage)) {
				return basePackage;
			} else {
				return basePackage + "." + subPackage;
			}
		}
	}
}
