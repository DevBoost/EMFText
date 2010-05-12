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
package org.emftext.sdk.codegen.resource.ui.generators.ui;

import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.TextResourceUIArtifacts;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

public class PositionCategoryGenerator extends UIJavaBaseGenerator {

	public PositionCategoryGenerator() {
		super();
	}

	private PositionCategoryGenerator(GenerationContext context) {
		super(context, TextResourceUIArtifacts.POSITION_CATEGORY);
	}

	public boolean generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc("An enumeration of all position categories.");
		sc.add("public enum " + getResourceClassName() + " {");
		sc.add("BRACKET, DEFINTION, PROXY;");
		sc.add("}");
		return true;
	}

	public IGenerator<GenerationContext, Object> newInstance(GenerationContext context, Object parameters) {
		return new PositionCategoryGenerator(context);
	}
}