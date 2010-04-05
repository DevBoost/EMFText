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
package org.emftext.sdk.codegen.generators.ui;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.BAD_LOCATION_EXCEPTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.BAD_POSITION_CATEGORY_EXCEPTION;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.I_DOCUMENT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.POSITION;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class PositionHelperGenerator extends JavaBaseGenerator {

	public PositionHelperGenerator() {
		super();
	}

	private PositionHelperGenerator(GenerationContext context) {
		super(context, EArtifact.POSITION_HELPER);
	}

	public boolean generateJavaContents(StringComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		sc.add("// A helper class to add, get or remove positions with a specific category in a document.");
		sc.add("public class " + getResourceClassName() + " {");
		sc.addLineBreak();
		addMethods(sc);
		sc.add("}");
		return true;
	}

	private void addMethods(StringComposite sc) {
		addAddPositionMethod(sc);
		addGetPositionsMethod(sc);
		addGetFirstPositionMethod(sc);
		addRemovePositionsMethod(sc);
	}

	private void addRemovePositionsMethod(StringComposite sc) {
		sc.add("// Deletes the position category from the document.");
		sc.add("// All positions in this category are thus deleted as well.");
		sc.add("//");
		sc.add("// @param document the document contains the category");
		sc.add("// @param category the category to be removed");
		sc.add("public void removePositions(" + I_DOCUMENT + " document, String category) {");
		sc.add("try {");
		sc.add("document.removePositionCategory(category);");
		sc.add("} catch (" + BAD_POSITION_CATEGORY_EXCEPTION + " e) {");
		sc.add("//e.printStackTrace();");
		sc.add("}");
		sc.add("}");
	}

	private void addGetFirstPositionMethod(StringComposite sc) {
		sc.add("// Gets the first position of a specific category of the given document.");
		sc.add("//");
		sc.add("// @param document the document to get the positions from");
		sc.add("// @param category the category of the position");
		sc.add("//");
		sc.add("// @return a position. If there is none return <code>null</code>.");
		sc.add("public " + POSITION + " getFirstPosition(" + I_DOCUMENT + " document, String category) {");
		sc.add("try {");
		sc.add(POSITION + "[] positions = document.getPositions(category);");
		sc.add("if (positions.length > 0) {");
		sc.add("return positions[0];");
		sc.add("}");
		sc.add("} catch (" + BAD_POSITION_CATEGORY_EXCEPTION + " e) {");
		sc.add("//e.printStackTrace();");
		sc.add("}");
		sc.add("return null;");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addGetPositionsMethod(StringComposite sc) {
		sc.add("// Gets the positions of a specific category of the given document.");
		sc.add("//");
		sc.add("// @param document the document to get the positions from");
		sc.add("// @param category the position's category");
		sc.add("// @return an array of positions. If there is none return an array with the length = 0");
		sc.add("public " + POSITION + "[] getPositions(" + I_DOCUMENT + " document, String category) {");
		sc.add("try {");
		sc.add("return document.getPositions(category);");
		sc.add("} catch (" + BAD_POSITION_CATEGORY_EXCEPTION + " e) {");
		sc.add("//e.printStackTrace();");
		sc.add("}");
		sc.add("return new " + POSITION + "[0];");
		sc.add("}");
		sc.addLineBreak();
	}

	private void addAddPositionMethod(StringComposite sc) {
		sc.add("// Adds a position with the given offset and length into a document.");
		sc.add("//");
		sc.add("// @param document the document to add a position into");
		sc.add("// @param category the category of this position");
		sc.add("// @param offset the offset of the position");
		sc.add("// @param length the length of the position");
		sc.add("public void addPosition(" + I_DOCUMENT + " document, String category, int offset, int length) {");
		sc.add("try {");
		sc.add("document.addPositionCategory(category);");
		sc.add(POSITION + " position = new " + POSITION + "(offset, length);");
		sc.add("document.addPosition(category, position);");
		sc.add("} catch (" + BAD_LOCATION_EXCEPTION + " e) {");
		sc.add("//e.printStackTrace();");
		sc.add("} catch (" + BAD_POSITION_CATEGORY_EXCEPTION + " e) {");
		sc.add("//e.printStackTrace();");
		sc.add("}");
		sc.add("}");
		sc.addLineBreak();
	}

	public IGenerator newInstance(GenerationContext context) {
		return new PositionHelperGenerator(context);
	}
}
