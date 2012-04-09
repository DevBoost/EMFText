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
package org.emftext.sdk.codegen.resource.generators.debug;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.ABSTRACT_SOURCE_LOOKUP_DIRECTOR;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_SOURCE_LOOKUP_PARTICIPANT;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class SourceLocatorGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		if (!getContext().isDebugSupportEnabled()) {
			generateEmptyClass(sc, null, OptionTypes.DISABLE_DEBUG_SUPPORT);
			return;
		}
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " extends " + ABSTRACT_SOURCE_LOOKUP_DIRECTOR + " {");
		sc.addLineBreak();
		addInitializeParticipantsMethod(sc);
		sc.add("}");
	}

	private void addInitializeParticipantsMethod(JavaComposite sc) {
		sc.add("public void initializeParticipants() {");
		sc.add("addParticipants(new " + I_SOURCE_LOOKUP_PARTICIPANT + "[]{new " + sourceLookupParticipantClassName + "()});");
		sc.add("}");
		sc.addLineBreak();
	}
}
