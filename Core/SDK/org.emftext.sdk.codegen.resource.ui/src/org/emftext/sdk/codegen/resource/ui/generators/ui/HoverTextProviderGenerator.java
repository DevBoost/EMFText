/*******************************************************************************
 * Copyright (c) 2006-2014
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
package org.emftext.sdk.codegen.resource.ui.generators.ui;

import static org.emftext.sdk.codegen.resource.ClassNameConstants.E_OBJECT;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

import de.devboost.codecomposers.StringComposite;
import de.devboost.codecomposers.java.JavaComposite;

public class HoverTextProviderGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {
	
	@Override
	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");sc.addLineBreak();sc.addImportsPlaceholder();
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " implements " + iHoverTextProviderClassName + " {");
		sc.addLineBreak();
		addFields(sc);
		addGetHoverTextMethod1(sc);
		addGetHoverTextMethod2(sc);
		sc.add("}");
	}

	private void addFields(StringComposite sc) {
		sc.add("private " + defaultHoverTextProviderClassName + " defaultProvider = new " + defaultHoverTextProviderClassName + "();");
		sc.addLineBreak();
	}

	private void addGetHoverTextMethod1(JavaComposite sc) {
		sc.add("public String getHoverText(" + E_OBJECT(sc) + " container, " + E_OBJECT(sc) + " referencedObject) {");
		sc.addComment(
			"Set option " + OptionTypes.OVERRIDE_HOVER_TEXT_PROVIDER.getLiteral() + " to false and customize this method to obtain " +
			"custom hover texts."
		);
		sc.add("return defaultProvider.getHoverText(referencedObject);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetHoverTextMethod2(JavaComposite sc) {
		sc.add("public String getHoverText(" + E_OBJECT(sc) + " object) {");
		sc.addComment(
			"Set option " + OptionTypes.OVERRIDE_HOVER_TEXT_PROVIDER.getLiteral() + " to false and customize this method to obtain " +
			"custom hover texts."
		);
		sc.add("return defaultProvider.getHoverText(object);");
		sc.add("}");
		sc.addLineBreak();
	}
}
