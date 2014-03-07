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
package org.emftext.sdk.codegen.resource.ui.generators.ui.debug;

import static org.emftext.sdk.codegen.resource.ClassNameConstants.DEBUG_EXCEPTION;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.I_ADAPTER_FACTORY;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.I_RESOURCE;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.I_VALUE;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.I_VARIABLE;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_CHILDREN_COUNT_UPDATE;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_CHILDREN_UPDATE;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_ELEMENT_CONTENT_PROVIDER;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_ELEMENT_LABEL_PROVIDER;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_HAS_CHILDREN_UPDATE;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_LABEL_UPDATE;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_TEXT_EDITOR;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.I_TOGGLE_BREAKPOINTS_TARGET;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;
import org.emftext.sdk.concretesyntax.OptionTypes;

import de.devboost.codecomposers.java.JavaComposite;

public class AdapterFactoryGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		if (!getContext().isDebugSupportEnabled()) {
			generateEmptyClass(sc, null, OptionTypes.DISABLE_DEBUG_SUPPORT);
			return;
		}
		sc.add("package " + getResourcePackageName() + ";");sc.addLineBreak();sc.addImportsPlaceholder();
		sc.addLineBreak();
		sc.add("@SuppressWarnings(\"restriction\")");
		sc.add("public class " + getResourceClassName() + " implements " + I_ADAPTER_FACTORY(sc) + " {");
		sc.addLineBreak();
		addMethods(sc);
		sc.add("}");
	}

	private void addMethods(JavaComposite sc) {
		addGetAdapterMethod(sc);
		addGetAdapterListMethod(sc);
	}

	private void addGetAdapterMethod(JavaComposite sc) {
		sc.add("@SuppressWarnings(\"rawtypes\")");
		sc.add("public Object getAdapter(Object adaptableObject, Class adapterType) {");
		sc.add("if (adaptableObject instanceof " + I_TEXT_EDITOR(sc) + ") {");
		sc.add(I_TEXT_EDITOR(sc) + " editorPart = (" + I_TEXT_EDITOR(sc) + ") adaptableObject;");
		sc.add(I_RESOURCE(sc) + " resource = (" + I_RESOURCE(sc) + ") editorPart.getEditorInput().getAdapter(" + I_RESOURCE(sc) + ".class);");
		sc.add("if (resource != null) {");
		sc.add("String extension = resource.getFileExtension();");
		sc.add("if (extension != null && extension.equals(new " + metaInformationClassName + "().getSyntaxName())) {");
		sc.add("return new " + uiMetaInformationClassName + "().createResourceAdapter(adaptableObject, adapterType, resource);");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("if (adapterType == " + I_ELEMENT_LABEL_PROVIDER(sc) + ".class && adaptableObject instanceof " + debugVariableClassName + ") {");
		sc.add("final " + debugVariableClassName + " variable = (" + debugVariableClassName + ") adaptableObject;");
		sc.add("return new " + I_ELEMENT_LABEL_PROVIDER(sc) + "() {");
		sc.addLineBreak();
		sc.add("public void update(" + I_LABEL_UPDATE(sc) + "[] updates) {");
		sc.add("for (" + I_LABEL_UPDATE(sc) + " update : updates) {");
		sc.add("try {");
		sc.add("update.setLabel(variable.getName(), 0);");
		sc.add("update.setLabel(variable.getValue().getValueString(), 1);");
		sc.add("update.done();");
		sc.add("} catch (" + DEBUG_EXCEPTION(sc) + " e) {");
		// TODO handle exception
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("};");
		sc.add("}");
		sc.add("if (adapterType == " + I_ELEMENT_CONTENT_PROVIDER(sc) + ".class && adaptableObject instanceof " + debugVariableClassName + ") {");
		sc.add("final " + debugVariableClassName + " variable = (" + debugVariableClassName + ") adaptableObject;");
		sc.add("return new " + I_ELEMENT_CONTENT_PROVIDER(sc) + "() {");
		sc.addLineBreak();
		sc.add("public void update(" + I_CHILDREN_COUNT_UPDATE(sc) + "[] updates) {");
		sc.add("try {");
		sc.add("for (" + I_CHILDREN_COUNT_UPDATE(sc) + " update : updates) {");
		sc.add(I_VALUE(sc) + " value = variable.getValue();");
		sc.add(debugValueClassName + " castedValue = (" + debugValueClassName + ") value;");
		sc.add("update.setChildCount(castedValue.getVariableCount());");
		sc.add("update.done();");
		sc.add("}");
		sc.add("} catch (" + DEBUG_EXCEPTION(sc) + " e) {");
		sc.add("e.printStackTrace();");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("public void update(" + I_CHILDREN_UPDATE(sc) + "[] updates) {");
		sc.add("try {");
		sc.add(I_VALUE(sc) + " value = variable.getValue();");
		sc.add(debugValueClassName + " castedValue = (" + debugValueClassName + ") value;");
		sc.add("for (" + I_CHILDREN_UPDATE(sc) + " update : updates) {");
		sc.add("int offset = update.getOffset();");
		sc.add("int length = update.getLength();");
		sc.add("for (int i = offset; i < offset + length; i++) {");
		sc.add(I_VARIABLE(sc) + " variable = castedValue.getChild(i);");
		sc.add("update.setChild(variable, i);");
		sc.add("}");
		sc.add("update.done();");
		sc.add("}");
		sc.add("} catch (" + DEBUG_EXCEPTION(sc) + " e) {");
		// TODO handle exception
		sc.add("e.printStackTrace();");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
		
		sc.add("public void update(" + I_HAS_CHILDREN_UPDATE(sc) + "[] updates) {");
		sc.add("for (" + I_HAS_CHILDREN_UPDATE(sc) + " update : updates) {");
		sc.add("try {");
		sc.add("update.setHasChilren(variable.getValue().hasVariables());");
		sc.add("update.done();");
		sc.add("} catch (" + DEBUG_EXCEPTION(sc) + " e) {");
		// TODO handle exception
		sc.add("e.printStackTrace();");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("};");
		sc.add("}");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetAdapterListMethod(JavaComposite sc) {
		sc.add("@SuppressWarnings(\"rawtypes\")");
		sc.add("public Class[] getAdapterList() {");
		sc.add("return new Class[] {" + I_TOGGLE_BREAKPOINTS_TARGET(sc) + ".class};");
		sc.add("}");
		sc.addLineBreak();
	}
}
