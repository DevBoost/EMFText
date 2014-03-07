/*******************************************************************************
 * Copyright (c) 2006-2013
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

import static de.devboost.codecomposers.java.ClassNameConstants.ARRAY_LIST;
import static de.devboost.codecomposers.java.ClassNameConstants.LIST;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.ADAPTER;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.NOTIFICATION;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.NOTIFIER;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

import de.devboost.codecomposers.StringComposite;
import de.devboost.codecomposers.java.JavaComposite;

public class LayoutInformationAdapterGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");sc.addLineBreak();sc.addImportsPlaceholder();
		sc.addLineBreak();
		
		sc.addJavadoc(
			"A " + getResourceClassName() + " is used to store layout information that is " +
			"found while parsing text files. Layout information does include all unused " +
			"tokens. Usually, these are whitespace characters, line breaks and comments, " +
			"but depending on the concrete syntax definition it can also include other tokens. " + getResourceClassName() + "s are attached to EObjects and aggregate multiple " +
			"LayoutInformation objects. Each of these objects contains the layout that was " +
			"found before a keyword, attribute or reference.",
			"",
			"Since layout information is stored in EAdapters, models can be transformed and " +
			"modified, while still keeping the formatting of the original text document from " +
			"which the model was originally created."
		);
		sc.add("public class " + getResourceClassName() + " implements " + ADAPTER(sc) + " {");
		sc.addLineBreak();
		addFields(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addMethods(JavaComposite sc) {
		addGetTargetMethod(sc);
		addIsAdapterForTypeMethod(sc);
		addNotifyChangedMethod(sc);
		addSetTargetMethod(sc);
		addGetLayoutInformationsMethod(sc);
		addAddLayoutInformationMethod(sc);
		addReplaceProxyMethod(sc);
	}

	private void addFields(JavaComposite sc) {
		sc.addJavadoc("The EObject that this adapter is attached to.");
		sc.add("private " + NOTIFIER(sc) + " target;");
		sc.addLineBreak();
		
		sc.addJavadoc("A list of LayoutInformation objects. one for each keyword, attribute and reference.");
		sc.add("private " + LIST(sc) + "<" + layoutInformationClassName + "> layoutInformations = new " + ARRAY_LIST(sc) + "<" + layoutInformationClassName + ">();");
		sc.addLineBreak();
	}

	private void addGetTargetMethod(JavaComposite sc) {
		sc.addJavadoc("Returns the EObject that this adapter is attached to.");
		sc.add("public " + NOTIFIER(sc) + " getTarget() {");
		sc.add("return target;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addIsAdapterForTypeMethod(StringComposite sc) {
		sc.add("public boolean isAdapterForType(Object type) {");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addNotifyChangedMethod(de.devboost.codecomposers.java.JavaComposite sc) {
		sc.add("public void notifyChanged(" + NOTIFICATION(sc) + " notification) {");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addSetTargetMethod(JavaComposite sc) {
		sc.addJavadoc("Sets the EObject that this adapter is attached to.");
		sc.add("public void setTarget(" + NOTIFIER(sc) + " newTarget) {");
		sc.add("this.target = newTarget;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetLayoutInformationsMethod(de.devboost.codecomposers.java.JavaComposite sc) {
		sc.add("public " + LIST(sc) + "<" + layoutInformationClassName + "> getLayoutInformations() {");
		sc.add("return layoutInformations;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddLayoutInformationMethod(StringComposite sc) {
		sc.add("public void addLayoutInformation(" + layoutInformationClassName + " layoutInformation) {");
		sc.add("layoutInformations.add(layoutInformation);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addReplaceProxyMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Iterates over all layout informations and searches for those that " +
			"refer to the given proxy object. Then, the old target of these layout " +
			"informations (i.e., the proxy) is changed to the new target. " +
			"This is required, because at the time when the layout information is " +
			"collected, all references point to proxy objects. But, later on these " +
			"proxy objects are replaced by the objects that are referenced. To " +
			"keep the layout information up to date, this replacement must be " +
			"propagated to all attached layout information objects.");
		sc.add("public void replaceProxy(" + E_OBJECT(sc) + " proxy, " + E_OBJECT(sc) + " target) {");
		sc.add("for (" + layoutInformationClassName + " layoutInformation : layoutInformations) {");
		sc.add("layoutInformation.replaceProxy(proxy, target);");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}
}
