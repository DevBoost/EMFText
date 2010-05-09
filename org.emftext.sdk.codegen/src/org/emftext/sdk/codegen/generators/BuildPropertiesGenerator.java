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
import org.emftext.sdk.codegen.BuildPropertiesParameters;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.util.StringUtil;

public class BuildPropertiesGenerator<ContextType> extends AbstractGenerator<ContextType, BuildPropertiesParameters<ContextType>> {

	public BuildPropertiesGenerator(ContextType context, BuildPropertiesParameters<ContextType> parameters) {
		super(context, parameters);
	}

	@Override
	public boolean generate(PrintWriter out) {
		Collection<String> sourceFolders = parameters.getSourceFolders();
		Collection<String> binIncludes = parameters.getBinIncludes();

		StringBuilder sc = new StringBuilder();
		sc.append("bin.includes = " + StringUtil.explode(binIncludes, ",\\\n"));
		sc.append("\n");
		sc.append("source.. = " + StringUtil.explode(sourceFolders, ","));
		sc.append("\n");

		out.write(sc.toString());
		return true;
	}

	public IGenerator<ContextType, BuildPropertiesParameters<ContextType>> newInstance(ContextType context, BuildPropertiesParameters<ContextType> parameters) {
		return new BuildPropertiesGenerator<ContextType>(context, parameters);
	}
}
