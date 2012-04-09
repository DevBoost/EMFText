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

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.CORE_EXCEPTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_LAUNCH_CONFIGURATION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_PROGRESS_MONITOR;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_SOURCE_CONTAINER;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_SOURCE_CONTAINER_TYPE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_SOURCE_LOOKUP_DIRECTOR;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.I_SOURCE_PATH_COMPUTER_DELEGATE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.RESOURCES_PLUGIN;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.URI;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

public class SourcePathComputerDelegateGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		if (!getContext().isDebugSupportEnabled()) {
			generateEmptyClass(sc, null, OptionTypes.DISABLE_DEBUG_SUPPORT);
			return;
		}
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("public class " + getResourceClassName() + " implements " + I_SOURCE_PATH_COMPUTER_DELEGATE + " {");
		sc.addLineBreak();
		addComputeSourceContainersMethod(sc);
		sc.add("}");
	}

	private void addComputeSourceContainersMethod(JavaComposite sc) {
		sc.add("public " + I_SOURCE_CONTAINER + "[] computeSourceContainers(" + I_LAUNCH_CONFIGURATION + " configuration, " + I_PROGRESS_MONITOR + " monitor) throws " + CORE_EXCEPTION + " {");
		sc.add("return new " + I_SOURCE_CONTAINER + "[] {new " + I_SOURCE_CONTAINER + "() {");
		sc.addLineBreak();
		sc.add("@SuppressWarnings(\"rawtypes\")").addLineBreak();
		sc.add("public Object getAdapter(Class adapter) {");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public boolean isComposite() {");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void init(" + I_SOURCE_LOOKUP_DIRECTOR + " director) {");
		sc.addComment("do nothing");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public " + I_SOURCE_CONTAINER_TYPE + " getType() {");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public " + I_SOURCE_CONTAINER + "[] getSourceContainers() throws " + CORE_EXCEPTION + " {");
		sc.add("return new " + I_SOURCE_CONTAINER + "[0];");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public String getName() {");
		sc.add("return \"Resource " + URI + "\";");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public Object[] findSourceElements(String name) throws " + CORE_EXCEPTION + " {");
		sc.add("" + URI + " eUri = " + URI + ".createURI(name);");
		sc.add("if (eUri.isPlatformResource()) {");
		sc.add("String platformString = eUri.toPlatformString(true);");
		sc.add("return new Object[] {" + RESOURCES_PLUGIN + ".getWorkspace().getRoot().findMember(platformString)};");
		sc.add("}");
		sc.add("return new Object[0];");
		sc.add("}");
		sc.addLineBreak();
		sc.add("public void dispose() {");
		sc.add("}");
		sc.add("}};");
		sc.add("}");
		sc.addLineBreak();
	}
}
