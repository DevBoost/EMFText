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
package org.emftext.sdk.codegen.resource.generators.mopp;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.COLLECTIONS;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.MAP;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.DefaultLoadOptionsExtensionPointSchemaGenerator;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class OptionProviderGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		String resourcePluginName = getContext().getResourcePlugin().getName();
		sc.addJavadoc(
			"This class can be used to configure options that must be used when " +
			"resources are loaded. This is similar to using the extension point '" + 
			resourcePluginName + "." + DefaultLoadOptionsExtensionPointSchemaGenerator.EXTENSION_ID_SUFFIX +
			"' with the difference that the options defined in this class are used even if no Eclipse platform is running."
		);
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " implements " + iOptionProviderClassName + " {");
		sc.addLineBreak();
		addMethods(sc);
		sc.add("}");
	}

	private void addMethods(JavaComposite sc) {
		addGetOptionsMethods(sc);
	}

	private void addGetOptionsMethods(JavaComposite sc) {
		sc.add("public " + MAP + "<?,?> getOptions() {");
		sc.addComment("create a map with static option providers here");
		sc.add("return " + COLLECTIONS + ".emptyMap();");
		sc.add("}");
		sc.addLineBreak();

	}
}
