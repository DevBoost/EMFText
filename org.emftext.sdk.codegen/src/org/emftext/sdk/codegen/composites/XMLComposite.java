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

/**
 * A custom StringComposite that can be used to build XML
 * documents.
 */
public class XMLComposite extends StringComposite {
	
	public XMLComposite() {
		super();
		addLineBreaker(">");
	}

	@Override
	public boolean isIndendationStarter(Component component) {
		boolean isStarter = component.toString().endsWith(">") &&
			!component.toString().endsWith("?>") && 
			!(isEndTag(component) || isCompactTag(component) || isTagOnOneLine(component));
		return isStarter;
	}

	@Override
	public boolean isIndendationStopper(Component component) {
		boolean isStopper = isEndTag(component) && !isCompactTag(component) && !isTagOnOneLine(component);
		return isStopper;
	}

	private boolean isEndTag(Component component) {
		return component.toString().matches("</.*>");
	}

	private boolean isCompactTag(Component component) {
		return component.toString().matches("<.*/>");
	}
	
	private boolean isTagOnOneLine(Component component) {
		return component.toString().matches("<.*>.*</.*>");
	}
}
