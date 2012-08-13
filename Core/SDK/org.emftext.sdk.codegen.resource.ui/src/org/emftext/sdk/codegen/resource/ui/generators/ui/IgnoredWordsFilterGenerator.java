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
package org.emftext.sdk.codegen.resource.ui.generators.ui;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class IgnoredWordsFilterGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"The IgnoredWordsFilter can be customized to add additional words that " +
			"must not be marked as misspelled. To customize this class, set option '" +
			OptionTypes.OVERRIDE_IGNORED_WORDS_FILTER.getLiteral() + "' to <code>false</code>."
		);
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		
		addIgnoreWordMethod(sc);
		sc.add("}");
	}

	private void addIgnoreWordMethod(JavaComposite sc) {
		sc.addJavadoc("Checks whether the given word must be ignored even it is misspelled.");
		sc.add("public boolean ignoreWord(String word) {");
		sc.addComment("By default we ignore all keywords that are defined in the syntax");
		sc.add("return " + grammarInformationProviderClassName + ".INSTANCE.getKeywords().contains(word);");
		sc.add("}");
		sc.addLineBreak();
	}
}
