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
package org.emftext.sdk.codegen.resource.ui.generators.ui;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.PROPERTY_TESTER;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.FILE_EDITOR_INPUT;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_FILE;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_RESOURCE;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

public class PropertyTesterGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("public class " + getResourceClassName());
		if (getContext().isLaunchSupportEnabled()) {
			sc.add(" extends " + PROPERTY_TESTER);
		}
		sc.add(" {");
		sc.addLineBreak();
		if (getContext().isLaunchSupportEnabled()) {
			addMethods(sc);
		} else {
			sc.addComment("This class is currently empty, because launch support was disabled for this DSL.");
		}
		sc.add("}");
	}

	private void addMethods(JavaComposite sc) {
		addTestMethod(sc);
		addHasMatchingURIMethod(sc);
	}

	private void addTestMethod(JavaComposite sc) {
		sc.add("public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {");
		sc.add("if (receiver instanceof " + I_RESOURCE + ") {");
		sc.add(I_RESOURCE + " resource = (" + I_RESOURCE + ") receiver;");
		sc.add("return hasMatchingURI(resource);");
		sc.add("} else if (receiver instanceof " + FILE_EDITOR_INPUT + ") {");
		sc.add(FILE_EDITOR_INPUT + " editorInput = (" + FILE_EDITOR_INPUT + ") receiver;");
		sc.add(I_FILE + " file = editorInput.getFile();");
		sc.add("return hasMatchingURI(file);");
		sc.add("}");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addHasMatchingURIMethod(JavaComposite sc) {
		sc.add("private boolean hasMatchingURI(" + I_RESOURCE + " resource) {");
		sc.add("String path = resource.getLocationURI().getPath();");
		sc.add("return path.endsWith(\".\" + new " + metaInformationClassName + "().getSyntaxName());");
		sc.add("}");
		sc.addLineBreak();
	}
}
