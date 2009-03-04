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
package org.emftext.runtime.resource.impl;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.emftext.runtime.resource.ILocationMap;

/**
 * An implementation of the ILocationMap interface that 
 * does not store location information at all. This class
 * can be used in test cases where location information
 * is not required.
 */
public class DevNullLocationMap implements ILocationMap {

	public int getCharEnd(EObject element) {
		return 0;
	}

	public int getCharStart(EObject element) {
		return 0;
	}

	public int getColumn(EObject element) {
		return 0;
	}

	public List<EObject> getElementsAt(int documentOffset) {
		return null;
	}

	public List<EObject> getElementsBetween(int startOffset,
			int endOffset) {
		return null;
	}

	public int getLine(EObject element) {
		return 0;
	}

	public void setCharEnd(EObject element, int charEnd) {
	}

	public void setCharStart(EObject element, int charStart) {
	}

	public void setColumn(EObject element, int column) {
	}

	public void setLine(EObject element, int line) {
	}
}
