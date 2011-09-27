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

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.CHANGE_DESCRIPTION;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.CHANGE_RECORDER;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.COLLECTIONS;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.COMPARABLE;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_STRUCTURAL_FEATURE;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.IMAGE;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class CompletionProposalGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc("A proposal for completing an incomplete document.");
		sc.add("public class " + getResourceClassName() + " implements " + COMPARABLE + "<" + getResourceClassName() + "> {");
		addFields(sc);
		addConstructor1(sc);
		addConstructor2(sc);
		addConstructor3(sc);
		addMethods(sc);
		sc.addFieldGetSet("root", E_OBJECT);
		sc.add("}");
	}

	private void addMethods(JavaComposite sc) {
		addGetInsertStringMethod(sc);
		addGetDisplayStringMethod(sc);
		addGetPrefixMethod(sc);
		addGetStartsWithPrefixMethod(sc);
		addImageMethod(sc);
		addIsStructuralFeatureMethod(sc);
		addGetStructuralFeatureMethod(sc);
		addGetContainerMethod(sc);
		addGetExpectedTerminalMethod(sc);
		addEqualsMethod(sc);
		addHashCodeMethod(sc);
		addCompareToMethod(sc);
		addToStringMethod(sc);
		addMaterializeMethod(sc);
	}

	private void addMaterializeMethod(JavaComposite sc) {
		sc.add("public void materialize(Runnable code) {");
		sc.add("if (root == null) {");
		sc.add("code.run();");
		sc.add("return;");
		sc.add("}");
		sc.add(CHANGE_RECORDER + " recorder = new " + CHANGE_RECORDER + "();");
		sc.add("recorder.beginRecording(" + COLLECTIONS + ".singleton(root));");
		sc.addLineBreak();
		sc.addComment("attach proposal model fragment to main model");
		sc.add("Runnable attachmentCode = expectedTerminal.getAttachmentCode();");
		sc.add("if (attachmentCode != null) {");
		sc.addComment("Applying attachment code");
		sc.add("attachmentCode.run();");
		sc.add("}");
		sc.addLineBreak();
		sc.add(CHANGE_DESCRIPTION + " changes = recorder.endRecording();");
		//sc.add("changes.applyAndReverse();");
		sc.add("code.run();");
		sc.addComment("revert changes");
		//sc.add("System.out.println("materialize() Reverting changes");");
		sc.add("changes.apply();");
		//sc.add("System.out.println("materialize() Reverting changes (end)");");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addToStringMethod(JavaComposite sc) {
		sc.add("public String toString() {");
		sc.add("String result = (container == null ? \"null\" : container.eClass().getName()) + \".\";");
		sc.add("result += (structuralFeature == null ? \"null\" : structuralFeature.getName());");
		sc.add("result += \": \" + insertString;");
		sc.add("return result;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addHashCodeMethod(JavaComposite sc) {
		sc.add("public int hashCode() {");
		sc.add("return getInsertString().hashCode();");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addCompareToMethod(JavaComposite sc) {
		sc.add("public int compareTo(" + getResourceClassName() + " object) {");
		sc.add("if (object instanceof " + getResourceClassName() + ") {");
		sc.add(getResourceClassName() + " other = (" + getResourceClassName() + ") object;");
		sc.addComment("proposals that start with the prefix are preferred over the ones that do not");
		sc.add("int startCompare = (matchesPrefix ? 1 : 0) - (other.getMatchesPrefix() ? 1 : 0);");
		sc.addComment("if both proposals start with the prefix of both do not the insert string is compared");
		sc.add("return startCompare == 0 ? getInsertString().compareTo(other.getInsertString()) : -startCompare;");
		sc.add("}");
		sc.add("return -1;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addEqualsMethod(StringComposite sc) {
		sc.add("public boolean equals(Object object) {");
		sc.add("if (object instanceof " + getResourceClassName() + ") {");
		sc.add(getResourceClassName() + " other = (" + getResourceClassName() + ") object;");
		sc.add("return other.getInsertString().equals(getInsertString());");
		sc.add("}");
		sc.add("return false;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addIsStructuralFeatureMethod(StringComposite sc) {
		sc.add("public boolean isStructuralFeature() {");
		sc.add("return structuralFeature != null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetStructuralFeatureMethod(StringComposite sc) {
		sc.add("public " + E_STRUCTURAL_FEATURE + " getStructuralFeature() {");
		sc.add("return structuralFeature;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetContainerMethod(StringComposite sc) {
		sc.add("public " + E_OBJECT + " getContainer() {");
		sc.add("return container;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetStartsWithPrefixMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Returns true if this proposal matched the prefix. " +
			"This does not imply that the proposal exactly starts with the prefix, " +
			"it can also match case-insensitive or using the camel case style. " +
			"Only proposals that return true will be considered for the final list " +
			"of proposals that is presented in the editor."
		);
		sc.add("public boolean getMatchesPrefix() {");
		sc.add("return matchesPrefix;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetInsertStringMethod(StringComposite sc) {
		sc.add("public String getInsertString() {");
		sc.add("return insertString;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetDisplayStringMethod(StringComposite sc) {
		sc.add("public String getDisplayString() {");
		sc.add("return displayString;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetPrefixMethod(StringComposite sc) {
		sc.add("public String getPrefix() {");
		sc.add("return prefix;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addImageMethod(StringComposite sc) {
		sc.add("public " + IMAGE + " getImage() {");
		sc.add("return image;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetExpectedTerminalMethod(StringComposite sc) {
		sc.add("public " + expectedTerminalClassName + " getExpectedTerminal() {");
		sc.add("return expectedTerminal;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConstructor1(StringComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + expectedTerminalClassName + " expectedTerminal, String insertString, String prefix, boolean matchesPrefix, " + E_STRUCTURAL_FEATURE + " structuralFeature, " + E_OBJECT + " container) {");
		sc.add("super();");
		sc.add("this.expectedTerminal = expectedTerminal;");
		sc.add("this.insertString = insertString;");
		sc.add("this.prefix = prefix;");
		sc.add("this.matchesPrefix = matchesPrefix;");
		sc.add("this.structuralFeature = structuralFeature;");
		sc.add("this.container = container;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addConstructor2(StringComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + expectedTerminalClassName + " expectedTerminal, String insertString, String prefix, boolean matchesPrefix, " + E_STRUCTURAL_FEATURE + " structuralFeature, " + E_OBJECT + " container, " + IMAGE + " image) {");
		sc.add("this(expectedTerminal, insertString, prefix, matchesPrefix, structuralFeature, container);");
		sc.add("this.image = image;");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addConstructor3(StringComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + expectedTerminalClassName + " expectedTerminal, String insertString, String prefix, boolean matchesPrefix, " + E_STRUCTURAL_FEATURE + " structuralFeature, " + E_OBJECT + " container, " + IMAGE + " image, String displayString) {");
		sc.add("this(expectedTerminal, insertString, prefix, matchesPrefix, structuralFeature, container, image);");
		sc.add("this.displayString = displayString;");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addFields(StringComposite sc) {
		sc.add("private " + expectedTerminalClassName + " expectedTerminal;");
		sc.add("private String insertString;");
		sc.add("private String displayString;");
		sc.add("private String prefix;");
		sc.add("private boolean matchesPrefix;");
		sc.add("private " + E_STRUCTURAL_FEATURE + " structuralFeature;");
		sc.add("private " + E_OBJECT + " container;");
		sc.add("private " + IMAGE + " image;");
		sc.addLineBreak();
	}
}
