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

import org.emftext.sdk.EMFTextSDKPlugin;
import org.emftext.sdk.concretesyntax.OptionTypes;

/**
 * An ArtifactDescriptor bundles information about an artifact that
 * is created during code generation. This includes data about the
 * name of the artifact (classNamePrefix and classNameSuffix), the
 * target package of the artifact (packageName) and the generator
 * that can be used to produce the artifact.
 *
 * @param <ContextType> the type of the context class that is required
 *                      by the code generator for this artifact
 * @param <ParameterType> the type of the parameter class that can be
 *                        used to configure the code generator
 */
public class ArtifactDescriptor<ContextType, ParameterType> {

	private IPackage<ISyntaxContext> targetPackage;
	private String classNamePrefix;
	private String classNameSuffix;
	private Class<? extends IGenerator<ContextType, ParameterType>> generatorClass;
	private OptionTypes overrideOption;

	public ArtifactDescriptor(IPackage<ISyntaxContext> targetPackage, String classNamePrefix, String classNameSuffix, Class<? extends IGenerator<ContextType, ParameterType>> generatorClass, OptionTypes overrideOption) {
		this.targetPackage = targetPackage;
		this.classNamePrefix = classNamePrefix;
		this.classNameSuffix = classNameSuffix;
		this.generatorClass = generatorClass;
		this.overrideOption = overrideOption;
	}

	public IPackage<ISyntaxContext> getPackage() {
		return targetPackage;
	}

	public String getClassNamePrefix() {
		return classNamePrefix;
	}

	public String getClassNameSuffix() {
		return classNameSuffix;
	}
	
	public Class<? extends IGenerator<ContextType, ParameterType>> getGeneratorClass() {
		return generatorClass;
	}

	public IGenerator<ContextType, ParameterType> createGenerator() {
		try {
			return generatorClass.newInstance();
		} catch (InstantiationException e) {
			EMFTextSDKPlugin.logError(e.getMessage(), e);
		} catch (IllegalAccessException e) {
			EMFTextSDKPlugin.logError(e.getMessage(), e);
		}
		return null;
	}

	public OptionTypes getOverrideOption() {
		return overrideOption;
	}
}
