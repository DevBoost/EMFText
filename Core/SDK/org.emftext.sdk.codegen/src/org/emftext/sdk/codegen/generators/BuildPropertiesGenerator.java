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
package org.emftext.sdk.codegen.generators;

import java.io.PrintWriter;
import java.util.Collection;

import org.emftext.sdk.codegen.AbstractGenerator;
import org.emftext.sdk.codegen.IContext;
import org.emftext.sdk.codegen.parameters.BuildPropertiesParameters;

import de.devboost.codecomposers.util.StringUtil;

/**
 * A generator for build.properties files. The content of the file is determined by
 * the given parameters.
 *
 * @param <ContextType>
 */
public class BuildPropertiesGenerator<ContextType extends IContext<ContextType>> extends AbstractGenerator<ContextType, BuildPropertiesParameters<ContextType>> {

	public BuildPropertiesGenerator() {
		super();
	}

	@Override
	public void doGenerate(PrintWriter out) {
		BuildPropertiesParameters<ContextType> parameters = getParameters();
		
		Collection<String> sourceFolders = parameters.getSourceFolders();
		Collection<String> binIncludes = parameters.getBinIncludes();

		StringBuilder sc = new StringBuilder();
		sc.append("bin.includes = " + StringUtil.explode(binIncludes, ",\\\n"));
		sc.append("\n");
		sc.append("source.. = " + StringUtil.explode(sourceFolders, ","));
		sc.append("\n");

		out.write(sc.toString());
	}
}
