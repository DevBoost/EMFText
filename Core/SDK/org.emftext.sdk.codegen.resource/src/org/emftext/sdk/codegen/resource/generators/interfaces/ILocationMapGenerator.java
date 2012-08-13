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
package org.emftext.sdk.codegen.resource.generators.interfaces;

import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.resource.generators.IClassNameConstants.LIST;

import org.emftext.sdk.codegen.composites.JavaComposite;
import org.emftext.sdk.codegen.parameters.ArtifactParameter;
import org.emftext.sdk.codegen.resource.GenerationContext;
import org.emftext.sdk.codegen.resource.generators.JavaBaseGenerator;

public class ILocationMapGenerator extends JavaBaseGenerator<ArtifactParameter<GenerationContext>> {

	@Override
	public void generateJavaContents(JavaComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"A LocationMap maps EObjects to the position of their textual " +
			"representations. For each " + E_OBJECT + " the map contains information " +
			"about the line, the column, the character position where the " +
			"object begins and the character position where the object ends."
		);
		sc.add("public interface " + getResourceClassName() + " {");
		sc.addLineBreak();
		
		sc.addJavadoc("Used by parsers to set location information.");
		sc.add("public void setLine(" + E_OBJECT + " element, int line);");
		sc.addLineBreak();
		
		sc.addJavadoc("Returns the line where the given element starts.");
		sc.add("public int getLine(" + E_OBJECT + " element);");
		sc.addLineBreak();
		
		sc.addJavadoc("Used by parsers to set location information.");
		sc.add("public void setColumn(" + E_OBJECT + " element, int column);");
		sc.addLineBreak();
		
		sc.addJavadoc("Returns the column where the given element starts.");
		sc.add("public int getColumn(" + E_OBJECT + " element);");
		sc.addLineBreak();
		
		sc.addJavadoc("Used by parsers to set location information.");
		sc.add("public void setCharStart(" + E_OBJECT + " element, int charStart);");
		sc.addLineBreak();
		
		sc.addJavadoc("Returns the character position where the given element starts.");
		sc.add("public int getCharStart(" + E_OBJECT + " element);");
		sc.addLineBreak();
		
		sc.addJavadoc("Used by parsers to set location information.");
		sc.add("public void setCharEnd(" + E_OBJECT + " element, int charEnd);");
		sc.addLineBreak();
		
		sc.addJavadoc("Returns the character position where the given element ends.");
		sc.add("public int getCharEnd(" + E_OBJECT + " element);");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"Returns all EObjects that are located at the given " +
			"offset in the text document. This method can return " +
			"multiple elements, because containers include their " +
			"children in the textual representation. The child " +
			"elements are returned at the head of the result list.",
			"@param documentOffset\n the offset where to search for elements",
			"@return a list of elements located at the given offset"
		);
		sc.add("public " + LIST + "<" + E_OBJECT + "> getElementsAt(int documentOffset);");
		sc.addLineBreak();
		
		sc.addJavadoc(
			"Returns all EObjects that are located between the given " +
			"offsets in the text document. The method can return " +
			"multiple elements. This no guarantee about the order of " +
			"the elements returned by this method. Even parsing the same " +
			"document twice may yield a different order of elements.",
			"@param startOffset",
			"@param endOffset",
			"@return a list of elements located between the given offsets"
		);
		sc.add("public " + LIST + "<" + E_OBJECT + "> getElementsBetween(int startOffset, int endOffset);");
		sc.addLineBreak();
		
		sc.add("}");
	}
}
