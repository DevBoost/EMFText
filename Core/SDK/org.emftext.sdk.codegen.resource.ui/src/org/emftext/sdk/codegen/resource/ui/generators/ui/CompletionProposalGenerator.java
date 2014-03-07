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
package org.emftext.sdk.codegen.resource.ui.generators.ui;

import static org.emftext.sdk.codegen.resource.ClassNameConstants.COMPARABLE;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.ClassNameConstants.E_STRUCTURAL_FEATURE;
import static org.emftext.sdk.codegen.resource.ui.UIClassNameConstants.IMAGE;

import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;
import org.emftext.sdk.codegen.resource.generators.code_completion.ExpectedTerminalGenerator;

import de.devboost.codecomposers.StringComposite;
import de.devboost.codecomposers.java.JavaComposite;

public class CompletionProposalGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");sc.addLineBreak();sc.addImportsPlaceholder();
		sc.addLineBreak();
		
		sc.addJavadoc("A proposal for completing an incomplete document.");
		sc.add("public class " + getResourceClassName() + " implements " + COMPARABLE(sc) + "<" + getResourceClassName() + "> {");
		
		sc.addLineBreak();
		addFields(sc);
		addConstructor1(sc);
		addConstructor2(sc);
		addConstructor3(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addMethods(JavaComposite sc) {
		sc.addGettersSetters();
		
		addGetPrefixMethod(sc);
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
		sc.addJavadoc(ExpectedTerminalGenerator.JAVADOC_MATERIALIZE_METHOD);
		sc.add("public void materialize(Runnable code) {");
		sc.add("expectedTerminal.materialize(code);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addToStringMethod(JavaComposite sc) {
		sc.add("public String toString() {");
		sc.add("String result = (container == null ? \"<NO_ECLASS>\" : container.eClass().getName()) + \".\";");
		sc.add("result += (structuralFeature == null ? \"<NO_ESTRUCTURALFEATURE>\" : structuralFeature.getName());");
		sc.add("result += \": '\" + insertString + \"'\";");
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
		sc.add("int startCompare = (matchesPrefix ? 1 : 0) - (other.isMatchesPrefix() ? 1 : 0);");
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

	private void addGetStructuralFeatureMethod(JavaComposite sc) {
		sc.add("public " + E_STRUCTURAL_FEATURE(sc) + " getStructuralFeature() {");
		sc.add("return structuralFeature;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetContainerMethod(JavaComposite sc) {
		sc.add("public " + E_OBJECT(sc) + " getContainer() {");
		sc.add("return container;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetPrefixMethod(StringComposite sc) {
		sc.add("public String getPrefix() {");
		sc.add("return prefix;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addImageMethod(JavaComposite sc) {
		sc.add("public " + IMAGE(sc) + " getImage() {");
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

	private void addConstructor1(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + expectedTerminalClassName + " expectedTerminal, String insertString, String prefix, boolean matchesPrefix, " + E_STRUCTURAL_FEATURE(sc) + " structuralFeature, " + E_OBJECT(sc) + " container) {");
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

	private void addConstructor2(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + expectedTerminalClassName + " expectedTerminal, String insertString, String prefix, boolean matchesPrefix, " + E_STRUCTURAL_FEATURE(sc) + " structuralFeature, " + E_OBJECT(sc) + " container, " + IMAGE(sc) + " image) {");
		sc.add("this(expectedTerminal, insertString, prefix, matchesPrefix, structuralFeature, container);");
		sc.add("this.image = image;");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addConstructor3(JavaComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + expectedTerminalClassName + " expectedTerminal, String insertString, String prefix, boolean matchesPrefix, " + E_STRUCTURAL_FEATURE(sc) + " structuralFeature, " + E_OBJECT(sc) + " container, " + IMAGE(sc) + " image, String displayString) {");
		sc.add("this(expectedTerminal, insertString, prefix, matchesPrefix, structuralFeature, container, image);");
		sc.add("this.displayString = displayString;");
		sc.add("}");
		sc.addLineBreak();
	}
	
	private void addFields(JavaComposite sc) {
		sc.addFieldGetSet("root", E_OBJECT(sc), "The root object of the resource for which this proposal was computed.");
		sc.addFieldGetSet("referenceTarget", "Object", "The target object, if this proposal suggests to insert a reference to another object.");

		sc.addJavadoc("The terminal that was expected at the cursor position.");
		sc.add("private " + expectedTerminalClassName + " expectedTerminal;");
		sc.addLineBreak();
		
		sc.addFieldGetSet("insertString", "String", 
			"The string that will be inserted if the user picks this proposal. " +
			"This string can differ from 'displayString' because usually only " +
			"the missing part of the text is inserted and an existing prefix is kept."
		);
		sc.addFieldGetSet("displayString", "String", "The string that will be shown in the pop-up containing the completion proposals.");

		sc.addJavadoc(
			"The part of the document right before the cursor that belongs to the proposal. " +
			"This may for example be a partial name of a cross-referenced element."
		);
		sc.add("private String prefix;");
		sc.addLineBreak();
		String fieldDoc = 
			"A flag that indicates whether this proposal is valid w.r.t. the prefix (i.e., " +
			"the text that has already been typed). We do keep proposals that do not match " +
			"the prefix to allow proposal post processors to access these and add valid proposals " +
			"even if the built-in proposal engine did not find a matching proposal. " +
			"The completion pop-up will only show proposals for which this method returns true. " +
			"See also {@link #isMatchesPrefix()}.";
		String getterDoc =
			"Returns true if this proposal matched the prefix. " +
			"This does not imply that the proposal exactly starts with the prefix, " +
			"it can also match case-insensitive or using the camel case style. " +
			"Only proposals that return true will be considered for the final list " +
			"of proposals that is presented in the editor.";

		sc.addFieldGetSet("matchesPrefix", "boolean", new String[] {fieldDoc}, new String[] {getterDoc});

		sc.addJavadoc("The structural feature (attribute or non-containment reference) that was expected at the cursor position.");
		sc.add("private " + E_STRUCTURAL_FEATURE(sc) + " structuralFeature;");
		sc.addLineBreak();

		sc.addJavadoc(
			"The container objects that covers the cursor position. " +
			"This container object may not be contained in the resource we're " +
			"computing proposals for. See {@link #materialize(Runnable)} for an explanation of this."
		);
		sc.add("private " + E_OBJECT(sc) + " container;");
		sc.addLineBreak();

		sc.addJavadoc(
				"The image that will be shown in the pop-up containing the completion proposals."
			);
		sc.add("private " + IMAGE(sc) + " image;");
		sc.addLineBreak();

		sc.addFields();
	}
}
