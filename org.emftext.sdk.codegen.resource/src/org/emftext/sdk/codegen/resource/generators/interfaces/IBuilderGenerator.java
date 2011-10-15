/*******************************************************************************
 * Copyright (c) 2006-2011
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
package org.emftext.sdk.codegen.resource.generators.interfaces;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_PROGRESS_MONITOR;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_STATUS;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.URI;

import org.emftext.sdk.OptionManager;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class IBuilderGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public interface " + getResourceClassName() + " {");
		sc.addLineBreak();
		
		boolean removeEclipseDependentCode = OptionManager.INSTANCE.getBooleanOptionValue(getContext().getConcreteSyntax(), OptionTypes.REMOVE_ECLIPSE_DEPENDENT_CODE);
		if (!removeEclipseDependentCode) {
			sc.add("public boolean isBuildingNeeded(" + URI + " uri);");
			sc.addLineBreak();
			sc.add("public " + I_STATUS + " build(" + textResourceClassName + " resource, " + I_PROGRESS_MONITOR + " monitor);");
			sc.addLineBreak();
		} else {
			sc.addComment("This interface is empty because option '" + OptionTypes.REMOVE_ECLIPSE_DEPENDENT_CODE.getLiteral() + "' is set to true.");
		}

		sc.add("}");
	}
}
