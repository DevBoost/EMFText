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
package org.emftext.sdk.codegen.composites;

import static org.emftext.sdk.codegen.composites.IClassNameConstants.ARRAY_LIST;
import static org.emftext.sdk.codegen.composites.IClassNameConstants.LINKED_HASH_MAP;
import static org.emftext.sdk.codegen.composites.IClassNameConstants.LINKED_HASH_SET;
import static org.emftext.sdk.codegen.composites.IClassNameConstants.LIST;
import static org.emftext.sdk.codegen.composites.IClassNameConstants.MAP;
import static org.emftext.sdk.codegen.composites.IClassNameConstants.SET;

import java.util.ArrayList;
import java.util.List;

/**
 * A custom StringComposite that is configured with the Java-specific
 * line break characters and indentation starter and stoppers.
 */
public class JavaComposite extends StringComposite {

	public JavaComposite() {
		super(true);
		addIndentationStarter("{");
		addIndentationStopper("}");
		addLineBreaker("{");
		addLineBreaker(";");
		addLineBreaker(",");
		addLineBreaker("}");
		addLineBreaker("*/");
	}

	@Override
	protected boolean isLineBreaker(Component component) {
		boolean superResult = super.isLineBreaker(component);
		if (superResult) {
			return true;
		}
		// add line breaks after single line comments
		String componentText = component.toString();
		boolean isSingleLineComment = componentText.contains("//");
		if (isSingleLineComment) {
			return true;
		}
		boolean isMultiLineComment = 
			"/*".equals(componentText) ||      // start of multi-line comment
			"/**".equals(componentText) ||     // start of Javadoc comment
			componentText.startsWith(" * ") || // intermediate line
			" */".equals(componentText);       // end of multi-line comment
		return isMultiLineComment;
	}

	public void addComment(String... paragraphs) {
		for (String paragraph : paragraphs) {
			String[] chunks = paragraph.split("\n");
			for (String chunk : chunks) {
				// split chunk into lines of 80 characters (split at space)
				List<String> lines = split(chunk, 80);
				for (String line : lines) {
					add("// " + line);
				}
			}
		}
	}
	
	public void addJavadoc(String... paragraphs) {
		add("/**");
		boolean wasParameterParagraph = false;
		for (String paragraph : paragraphs) {
			boolean addEmptyLine = false;
			if (paragraph.startsWith("@param")) {
				if (!wasParameterParagraph) {
					addEmptyLine = true;
				}
				wasParameterParagraph = true;
			}
			if (paragraph.startsWith("@return")) {
				addEmptyLine = true;
			}
			if (paragraph.startsWith("@throws")) {
				addEmptyLine = true;
			}
			if (paragraph.startsWith("@see")) {
				addEmptyLine = true;
			}
			if (paragraph.startsWith("@since")) {
				addEmptyLine = true;
			}
			if (addEmptyLine) {
				add(" * ");
			}
			String[] chunks = paragraph.split("\n");
			for (String chunk : chunks) {
				// split chunk into lines of 80 characters (split at space)
				List<String> lines = split(chunk, 80);
				for (String line : lines) {
					add(" * " + line);
				}
			}
		}
		add(" */");
	}
	
	/**
	 * Splits the given text into lines where each line does
	 * contain at most 'maxLength' characters. The text is split
	 * at space characters (i.e., words are not split).
	 * 
	 * @param text the string to split
	 * @param maxLength the maximum length of the lines returned
	 * @return
	 */
	public List<String> split(String text, int maxLength) {
		String tail = text;
		List<String> result = new ArrayList<String>();
		int length = Integer.MAX_VALUE;
		while (length > maxLength) {
			length = tail.length();
			if (length <= maxLength) {
				result.add(tail);
			} else {
				String head = tail.substring(0, maxLength);
				int indexOfLastSpace = head.lastIndexOf(" ");
				if (indexOfLastSpace >= 0) {
					head = tail.substring(0, indexOfLastSpace);
				} else {
					indexOfLastSpace = head.length() - 1;
				}
				result.add(head);
				tail = tail.substring(indexOfLastSpace + 1).trim();
			}
		}
		return result;
	}

	public String declareArrayList(String name, String type) {
		return LIST + "<" + type + "> " + name  + " = new " + ARRAY_LIST + "<" + type + ">();";
	}

	public String declareLinkedHashMap(String name, String keyType, String valueType) {
		return MAP + "<" + keyType + ", " + valueType + "> " + name  + " = new " + LINKED_HASH_MAP + "<" + keyType + ", " + valueType + ">();";
	}

	public String declareLinkedHashSet(String name, String type) {
		return SET + "<" + type + "> " + name + " = new " + LINKED_HASH_SET + "<" + type + ">();";
	}
}
