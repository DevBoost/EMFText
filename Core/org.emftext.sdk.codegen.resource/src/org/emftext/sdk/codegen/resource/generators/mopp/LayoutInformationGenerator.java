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

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.INTERNAL_E_OBJECT;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class LayoutInformationGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc(
			getResourceClassName() + " objects are used to store layout information that is " +
			"found while parsing text files. Layout information does include all unused " +
			"tokens. Usually, these are whitespace characters, line breaks and comments, " +
			"but depending on the concrete syntax definition it can also include other tokens.",
			getResourceClassName() + "s are aggregated in LayoutInformationAdapters. " +
			"One " + getResourceClassName() + " contains the layout that was " +
			"found before a keyword, attribute or reference."
		);
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		addFields(sc);
		addConstructor(sc);
		addMethods(sc);
		sc.add("}");
	}

	private void addFields(JavaComposite sc) {
		sc.addJavadoc(
			"The element in the grammar that is associated with this layout information. " +
			"This can be either an attribute, a non-containment reference (placeholder) or a " +
			"terminal (boolean or enumeration)."
		);
		sc.add("private final " + syntaxElementClassName + " syntaxElement;");
		sc.addLineBreak();
		
		sc.addJavadoc("The offset in the document where this piece of layout was found.");
		sc.add("private final int startOffset;");
		sc.addLineBreak();

		sc.addJavadoc("Contains a concatenated version of all hidden tokens that were found before this object.");
		sc.add("private final String hiddenTokenText;");
		sc.addLineBreak();

		sc.addJavadoc("Contains the visible token that represented this object in its text form.");
		sc.add("private final String visibleTokenText;");
		sc.addLineBreak();

		sc.addJavadoc("The object the layout information refers to. This can be either the value of an attribute or a referenced EObject.");
		sc.add("private Object object;");
		sc.addLineBreak();

		sc.addJavadoc("A flag that is used to remember whether the proxy to which this layout refers was resolved.");
		sc.add("private boolean wasResolved;");
		sc.addLineBreak();
	}

	private void addConstructor(StringComposite sc) {
		sc.add("public " + getResourceClassName() + "(" + syntaxElementClassName + " syntaxElement, Object object, int startOffset, String hiddenTokenText, String visibleTokenText) {");
		sc.add("super();");
		sc.add("this.syntaxElement = syntaxElement;");
		sc.add("this.object = object;");
		sc.add("this.startOffset = startOffset;");
		sc.add("this.hiddenTokenText = hiddenTokenText;");
		sc.add("this.visibleTokenText = visibleTokenText;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addMethods(JavaComposite sc) {
		addGetSyntaxElementMethod(sc);
		addGetStartOffsetMethod(sc);
		addGetObjectMethod(sc);
		addGetHiddenTokenTextMethod(sc);
		addGetVisibleTokenTextMethod(sc);
		addReplaceProxyMethod(sc);
		addToStringMethod(sc);
	}

	private void addGetSyntaxElementMethod(StringComposite sc) {
		sc.add("public " + syntaxElementClassName + " getSyntaxElement() {");
		sc.add("return syntaxElement;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetStartOffsetMethod(StringComposite sc) {
		sc.add("public int getStartOffset() {");
		sc.add("return startOffset;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetObjectMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Returns the objects that this layout information adapter refers to. " +
			"This can be either the value of an attribute or a referenced object. " +
			"If the parameter 'resolve' is set to true and the referenced object " +
			"is a proxy, this method tries to resolve the proxy."
		);
		sc.add("public Object getObject(" + E_OBJECT + " container, boolean resolve) {");
		sc.add("if (wasResolved || !resolve) {");
		sc.add("return object;");
		sc.add("}");
		sc.addComment(
			"we need to try to resolve proxy objects again, because the proxy " +
			"might have been resolved before this adapter existed, which means " +
			"we missed the replaceProxy() notification"
		);
		sc.add("if (object instanceof " + INTERNAL_E_OBJECT + ") {");
		sc.add(INTERNAL_E_OBJECT + " internalObject = (" + INTERNAL_E_OBJECT + ") object;");
		sc.add("if (internalObject.eIsProxy()) {");
		sc.add("if (container instanceof " + INTERNAL_E_OBJECT + ") {");
		sc.add(INTERNAL_E_OBJECT + " internalContainer = (" + INTERNAL_E_OBJECT + ") container;");
		sc.add(E_OBJECT + " resolvedObject = internalContainer.eResolveProxy(internalObject);");
		sc.add("if (resolvedObject != internalObject) {");
		sc.add("object = resolvedObject;");
		sc.add("wasResolved = true;");
		sc.add("}");
		sc.add("}");
		sc.add("}");
		sc.add("} else {");
		sc.add("wasResolved = true;");
		sc.add("}");
		sc.add("return object;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetHiddenTokenTextMethod(StringComposite sc) {
		sc.add("public String getHiddenTokenText() {");
		sc.add("return hiddenTokenText;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetVisibleTokenTextMethod(StringComposite sc) {
		sc.add("public String getVisibleTokenText() {");
		sc.add("return visibleTokenText;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addReplaceProxyMethod(StringComposite sc) {
		sc.add("public void replaceProxy(" + E_OBJECT + " proxy, " + E_OBJECT + " target) {");
		sc.add("if (this.object == proxy) {");
		sc.add("this.object = target;");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addToStringMethod(JavaComposite sc) {
		sc.add("public String toString() {");
		sc.add("return \"visible='\" + visibleTokenText + \"', hidden='\" + hiddenTokenText + \"', object='\" + object + \"', syntaxElement='\" + syntaxElement + \"'\";");
		sc.add("}");
		sc.addLineBreak();
	}
}
