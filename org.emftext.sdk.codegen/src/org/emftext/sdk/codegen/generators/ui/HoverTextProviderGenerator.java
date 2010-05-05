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
package org.emftext.sdk.codegen.generators.ui;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.STRING;

import org.emftext.sdk.codegen.TextResourceArtifacts;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class HoverTextProviderGenerator extends JavaBaseGenerator {
	
	public HoverTextProviderGenerator() {
		super();
	}

	private HoverTextProviderGenerator(GenerationContext context) {
		super(context, TextResourceArtifacts.HOVER_TEXT_PROVIDER);
	}

	@Override
	public boolean generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " implements " + iHoverTextProviderClassName + " {");
		sc.addLineBreak();
		addFields(sc);
		addGetHoverTestMethod(sc);
		sc.add("}");
		
		return true;
	}

	private void addFields(StringComposite sc) {
		sc.add("private " + defaultHoverTextProviderClassName + " defaultProvider = new " + defaultHoverTextProviderClassName + "();");
		sc.addLineBreak();
	}

	private void addGetHoverTestMethod(JavaComposite sc) {
		sc.add("public " + STRING + " getHoverText(" + E_OBJECT + " object) {");
		sc.addComment(
			"Set option " + OptionTypes.OVERRIDE_HOVER_TEXT_PROVIDER.getLiteral() + " to false and customize this method to obtain " +
			"custom hover texts."
		);
		sc.add("return defaultProvider.getHoverText(object);");
		sc.add("}");
		sc.addLineBreak();
	}

	public IGenerator newInstance(GenerationContext context) {
		return new HoverTextProviderGenerator(context);
	}

}
