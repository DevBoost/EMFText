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
package org.emftext.sdk.codegen.generators.ui;

import java.io.PrintWriter;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.generators.BaseGenerator;

public class PositionCategoryGenerator extends BaseGenerator {

	public PositionCategoryGenerator() {
		super();
	}

	private PositionCategoryGenerator(GenerationContext context) {
		super(context, EArtifact.POSITION_CATEGORY);
	}

	public boolean generate(PrintWriter out) {
		org.emftext.sdk.codegen.composites.StringComposite sc = new org.emftext.sdk.codegen.composites.JavaComposite();
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("// An enumeration of all position categories.");
		sc.add("public enum " + getResourceClassName() + " {");
		sc.add("BRACKET, DEFINTION, PROXY;");
		sc.add("}");
		out.print(sc.toString());
		return true;
	}

	public IGenerator newInstance(GenerationContext context) {
		return new PositionCategoryGenerator(context);
	}
}
