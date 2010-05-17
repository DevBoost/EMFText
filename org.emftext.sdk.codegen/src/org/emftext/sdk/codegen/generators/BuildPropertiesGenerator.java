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
package org.emftext.sdk.codegen.generators;

import java.io.PrintWriter;
import java.util.Collection;

import org.emftext.sdk.codegen.AbstractGenerator;
import org.emftext.sdk.codegen.ICodeGenerationComponent;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.parameters.BuildPropertiesParameters;
import org.emftext.sdk.util.StringUtil;

/**
 * A generator for build.properties files. The content of the file is determined by
 * the given parameters.
 *
 * @param <ContextType>
 */
public class BuildPropertiesGenerator<ContextType> extends AbstractGenerator<ContextType, BuildPropertiesParameters> {

	public BuildPropertiesGenerator(ICodeGenerationComponent parent, ContextType context, BuildPropertiesParameters parameters) {
		super(parent, context, parameters);
	}

	@Override
	public void generate(PrintWriter out) {
		Collection<String> sourceFolders = parameters.getSourceFolders();
		Collection<String> binIncludes = parameters.getBinIncludes();

		StringBuilder sc = new StringBuilder();
		sc.append("bin.includes = " + StringUtil.explode(binIncludes, ",\\\n"));
		sc.append("\n");
		sc.append("source.. = " + StringUtil.explode(sourceFolders, ","));
		sc.append("\n");

		out.write(sc.toString());
	}

	public IGenerator<ContextType, BuildPropertiesParameters> newInstance(ICodeGenerationComponent parent, ContextType context, BuildPropertiesParameters parameters) {
		return new BuildPropertiesGenerator<ContextType>(parent, context, parameters);
	}
}
