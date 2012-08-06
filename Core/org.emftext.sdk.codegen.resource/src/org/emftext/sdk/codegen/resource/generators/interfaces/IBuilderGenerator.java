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
package org.emftext.sdk.codegen.resource.generators.interfaces;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_PROGRESS_MONITOR;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_STATUS;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.URI;

import org.emftext.sdk.OptionManager;
import org.emftext.sdk.codegen.annotations.SyntaxDependent;
import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

@SyntaxDependent
public class IBuilderGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.addJavadoc(
			"An interface for builders that can be used to perform operations " +
			"when resources are changed and saved. This is an abstraction over " +
			"the Eclipse builder API that is specifically designed for building " +
			"resources that contain EMF models."
		);
		sc.add("public interface " + getResourceClassName() + " {");
		sc.addLineBreak();
		
		boolean removeEclipseDependentCode = OptionManager.INSTANCE.getBooleanOptionValue(getContext().getConcreteSyntax(), OptionTypes.REMOVE_ECLIPSE_DEPENDENT_CODE);
		if (!removeEclipseDependentCode) {
			sc.addJavadoc(
				"Check whether building the resource with the given URI is needed." +
				"This method allows to excluded resource from the build process before " +
				"these are actually loaded. If this method returns false, the build() " +
				"method will not be invoked for the resource located at the given URI."
			);
			sc.add("public boolean isBuildingNeeded(" + URI + " uri);");
			sc.addLineBreak();
			sc.addJavadoc(
					"Builds the given resource."
				);
			sc.add("public " + I_STATUS + " build(" + textResourceClassName + " resource, " + I_PROGRESS_MONITOR + " monitor);");
			sc.addLineBreak();
			
			sc.addJavadoc(
				"Handles the deletion of the given resource."
			);
			sc.add("public " + I_STATUS + " handleDeletion(" + URI + " uri, " + I_PROGRESS_MONITOR + " monitor);");
			sc.addLineBreak();
		} else {
			sc.addComment("This interface is empty because option '" + OptionTypes.REMOVE_ECLIPSE_DEPENDENT_CODE.getLiteral() + "' is set to true.");
		}

		sc.add("}");
	}
}
