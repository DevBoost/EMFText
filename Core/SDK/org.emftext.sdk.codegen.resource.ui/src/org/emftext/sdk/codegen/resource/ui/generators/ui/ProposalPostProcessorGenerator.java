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

import static de.devboost.codecomposers.java.ClassNameConstants.LIST;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

import de.devboost.codecomposers.java.JavaComposite;

public class ProposalPostProcessorGenerator extends
		UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {

		sc.add("package " + getResourcePackageName() + ";");sc.addLineBreak();sc.addImportsPlaceholder();
		sc.addLineBreak();

		sc.addJavadoc("A class which can be overridden to customize code completion proposals.");
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		addProcessProposalsMethod(sc);
		sc.add("}");
	}

	private void addProcessProposalsMethod(JavaComposite sc) {
		sc.add("public " + LIST(sc) + "<" + completionProposalClassName + "> process(" + LIST(sc) + "<" + completionProposalClassName + "> proposals) {");
		sc.addComment("the default implementation does returns the proposals as they are");
		sc.add("return proposals;");
		sc.add("}");
		sc.addLineBreak();
	}
}
