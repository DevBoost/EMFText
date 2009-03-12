/*******************************************************************************
 * Copyright (c) 2006-2009 
 * Software Technology Group, Dresden University of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2 of the License, or (at your option) any
 * later version. This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * 
 * See the GNU Lesser General Public License for more details. You should have
 * received a copy of the GNU Lesser General Public License along with this
 * program; if not, write to the Free Software Foundation, Inc., 59 Temple Place,
 * Suite 330, Boston, MA  02111-1307 USA
 * 
 * Contributors:
 *   Software Technology Group - TU Dresden, Germany 
 *   - initial API and implementation
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
