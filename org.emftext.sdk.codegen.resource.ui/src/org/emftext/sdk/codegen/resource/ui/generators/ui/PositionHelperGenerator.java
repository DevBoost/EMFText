/*******************************************************************************
 * Copyright (c) 2006-2010 
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

import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.BAD_LOCATION_EXCEPTION;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.BAD_POSITION_CATEGORY_EXCEPTION;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.I_DOCUMENT;
import static org.emftext.sdk.codegen.resource.ui.IUIClassNameConstants.POSITION;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.ui.generators.UIJavaBaseGenerator;

public class PositionHelperGenerator extends UIJavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc("A helper class to add, get or remove positions with a specific category in a document.");
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		addMethods(sc);
		sc.add("}");
	}

	private void addMethods(JavaComposite sc) {
		addAddPositionMethod(sc);
		addCreatePositionMethod(sc);
		addGetPositionsMethod(sc);
		addGetFirstPositionMethod(sc);
		addRemovePositionsMethod(sc);
	}

	private void addCreatePositionMethod(JavaComposite sc) {
		sc.add("public " + POSITION + " createPosition(int offset, int length) {");
		sc.add("return new " + POSITION + "(offset, length);");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addRemovePositionsMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Deletes the position category from the document. " +
			"All positions in this category are thus deleted as well.",
			"@param document the document contains the category",
			"@param category the category to be removed"
		);
		sc.add("public void removePositions(" + I_DOCUMENT + " document, String category) {");
		sc.add("try {");
		sc.add("document.removePositionCategory(category);");
		sc.add("} catch (" + BAD_POSITION_CATEGORY_EXCEPTION + " e) {");
		sc.add("}");
		sc.add("}");
	}

	private void addGetFirstPositionMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Returns the first position of a specific category of the given document.",
			"@param document the document to get the positions from",
			"@param category the category of the position",
			"@return a position. If there is none return <code>null</code>."
		);
		sc.add("public " + POSITION + " getFirstPosition(" + I_DOCUMENT + " document, String category) {");
		sc.add("try {");
		sc.add(POSITION + "[] positions = document.getPositions(category);");
		sc.add("if (positions.length > 0) {");
		sc.add("return positions[0];");
		sc.add("}");
		sc.add("} catch (" + BAD_POSITION_CATEGORY_EXCEPTION + " e) {");
		sc.add("}");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetPositionsMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Returns the positions of a specific category of the given document.",
			"@param document the document to get the positions from",
			"@param category the position's category",
			"@return an array of positions. If there is none return an array with the length = 0"
		);
		sc.add("public " + POSITION + "[] getPositions(" + I_DOCUMENT + " document, String category) {");
		sc.add("try {");
		sc.add("return document.getPositions(category);");
		sc.add("} catch (" + BAD_POSITION_CATEGORY_EXCEPTION + " e) {");
		sc.add("}");
		sc.add("return new " + POSITION + "[0];");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddPositionMethod(JavaComposite sc) {
		sc.addJavadoc(
			"Adds a position with the given offset and length into a document.",
			"@param document the document to add a position into",
			"@param category the category of this position",
			"@param offset the offset of the position",
			"@param length the length of the position"
		);
		sc.add("public void addPosition(" + I_DOCUMENT + " document, String category, int offset, int length) {");
		sc.add("try {");
		sc.add("document.addPositionCategory(category);");
		sc.add(POSITION + " position = new " + POSITION + "(offset, length);");
		sc.add("document.addPosition(category, position);");
		sc.add("} catch (" + BAD_LOCATION_EXCEPTION + " e) {");
		sc.add("} catch (" + BAD_POSITION_CATEGORY_EXCEPTION + " e) {");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	
}
