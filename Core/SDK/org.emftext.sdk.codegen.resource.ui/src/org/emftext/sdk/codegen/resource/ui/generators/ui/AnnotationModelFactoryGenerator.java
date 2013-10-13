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

import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_ANNOTATION_MODEL;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_ANNOTATION_MODEL_FACTORY;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_PATH;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_RESOURCE;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_WORKSPACE;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_WORKSPACE_ROOT;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.RESOURCES_PLUGIN;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

import de.devboost.codecomposers.java.JavaComposite;

public class AnnotationModelFactoryGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		sc.add("package " + getResourcePackageName() + ";");sc.addLineBreak();sc.addImportsPlaceholder();
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " implements " + I_ANNOTATION_MODEL_FACTORY(sc) + " {");
		sc.addLineBreak();
		addCreateAnnotationModelMethod(sc);
		sc.add("}");
	}

	private void addCreateAnnotationModelMethod(JavaComposite sc) {
		sc.add("public " + I_ANNOTATION_MODEL(sc) + " createAnnotationModel(" + I_PATH(sc) + " location) {");
		sc.add(I_WORKSPACE(sc) + " workspace = " + RESOURCES_PLUGIN(sc) + ".getWorkspace();");
		sc.add(I_WORKSPACE_ROOT(sc) + " root = workspace.getRoot();");
		sc.add(I_RESOURCE(sc) + " resource = root.findMember(location);");
		sc.add("return new " + annotationModelClassName + "(resource);");
		sc.add("}");
		sc.addLineBreak();
	}
}
