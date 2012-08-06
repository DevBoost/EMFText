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
package org.emftext.sdk.codegen.resource.generators.launch;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.CORE_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_LAUNCH;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_LAUNCH_CONFIGURATION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_PROGRESS_MONITOR;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.LAUNCH_CONFIGURATION_DELEGATE;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class LaunchConfigurationDelegateGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		String classComment = "A class that handles launch configurations.";
		if (!getContext().isLaunchSupportEnabled()) {
			generateEmptyClass(sc, classComment, OptionTypes.DISABLE_LAUNCH_SUPPORT);
			return;
		}
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.addJavadoc(classComment);
		sc.add("public class " + getResourceClassName() + " extends " + LAUNCH_CONFIGURATION_DELEGATE + " {");
		sc.addLineBreak();
		addConstants(sc);
		addLaunchMethod(sc);
		sc.add("}");
	}

	private void addConstants(JavaComposite sc) {
		sc.addJavadoc("The URI of the resource that shall be launched.");
		sc.add("public final static String ATTR_RESOURCE_URI = \"uri\";");
		sc.addLineBreak();
	}

	private void addLaunchMethod(JavaComposite sc) {
		sc.add("public void launch(" + I_LAUNCH_CONFIGURATION + " configuration, String mode, " + I_LAUNCH + " launch, " + I_PROGRESS_MONITOR + " monitor) throws " + CORE_EXCEPTION + " {");
		sc.addComment(
				"Set the " + OptionTypes.OVERRIDE_LAUNCH_CONFIGURATION_DELEGATE.getLiteral() + " option to <code>false</code> to implement this method or " +
				"disable launching support by setting " + OptionTypes.DISABLE_LAUNCH_SUPPORT.getLiteral() + " to <code>true</code>.");
		sc.addLineBreak();
		sc.add("new " + launchConfigurationHelperClassName + "().launch(configuration, mode, launch, monitor);");
		sc.add("}");
		sc.addLineBreak();
	}
}
