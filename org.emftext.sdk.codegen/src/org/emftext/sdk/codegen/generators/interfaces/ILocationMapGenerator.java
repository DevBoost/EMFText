/*******************************************************************************
 * Copyright (c) 2006-2009 
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
package org.emftext.sdk.codegen.generators.interfaces;

import static org.emftext.sdk.codegen.generators.IClassNameConstants.E_OBJECT;
import static org.emftext.sdk.codegen.generators.IClassNameConstants.LIST;

import org.emftext.sdk.codegen.EArtifact;
import org.emftext.sdk.codegen.GenerationContext;
import org.emftext.sdk.codegen.IGenerator;
import org.emftext.sdk.codegen.composites.StringComposite;
import org.emftext.sdk.codegen.generators.JavaBaseGenerator;

public class ILocationMapGenerator extends JavaBaseGenerator {

	public ILocationMapGenerator() {
		super();
	}

	private ILocationMapGenerator(GenerationContext context) {
		super(context, EArtifact.I_LOCATION_MAP);
	}

	public IGenerator newInstance(GenerationContext context) {
		return new ILocationMapGenerator(context);
	}

	public boolean generateJavaContents(StringComposite sc) {
		
		sc.add("package " + getResourcePackageName() + ";");
		sc.addLineBreak();
		
		sc.add("// A LocationMap map EObjects to the position of their textual");
		sc.add("// representations. For each " + E_OBJECT + " the map can contain information");
		sc.add("// about the line, the column, the character position where the");
		sc.add("// object begins and the character position where the object ends.");
		sc.add("public interface " + getResourceClassName() + " {");
		sc.addLineBreak();
		
		sc.add("// Used by parsers to set location information.");
		sc.add("public void setLine(" + E_OBJECT + " element, int line);");
		sc.addLineBreak();
		
		sc.add("// Used by parsers to set location information.");
		sc.add("public int getLine(" + E_OBJECT + " element);");
		sc.addLineBreak();
		
		sc.add("// Used by parsers to set location information.");
		sc.add("public void setColumn(" + E_OBJECT + " element, int column);");
		sc.addLineBreak();
		
		sc.add("// Used by parsers to set location information.");
		sc.add("public int getColumn(" + E_OBJECT + " element);");
		sc.addLineBreak();
		
		sc.add("// Used by parsers to set location information.");
		sc.add("public void setCharStart(" + E_OBJECT + " element, int charStart);");
		sc.addLineBreak();
		
		sc.add("// Used by parsers to set location information.");
		sc.add("public int getCharStart(" + E_OBJECT + " element);");
		sc.addLineBreak();
		
		sc.add("// Used by parsers to set location information.");
		sc.add("public void setCharEnd(" + E_OBJECT + " element, int charEnd);");
		sc.addLineBreak();
		
		sc.add("// Used by parsers to set location information.");
		sc.add("public int getCharEnd(" + E_OBJECT + " element);");
		sc.addLineBreak();
		
		sc.add("// Returns all EObjects that are located at the given");
		sc.add("// offset in the text document. The method can return");
		sc.add("// multiple elements, because containers include their");
		sc.add("// children in the textual representation.");
		sc.add("//");
		sc.add("// @param documentOffset");
		sc.add("// @return");
		sc.add("public " + LIST + "<" + E_OBJECT + "> getElementsAt(int documentOffset);");
		sc.addLineBreak();
		
		sc.add("// Returns all EObjects that are located between the given");
		sc.add("// offsets in the text document. The method can return");
		sc.add("// multiple elements.");
		sc.add("//");
		sc.add("// @param startOffset");
		sc.add("// @param endOffset");
		sc.add("// @return");
		sc.add("public " + LIST + "<" + E_OBJECT + "> getElementsBetween(int startOffset, int endOffset);");
		sc.add("}");
		return true;
	}
}
