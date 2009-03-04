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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import org.emftext.runtime.resource.ILocationMap;

/**
 * A basic implementation of the ILocationMap interface. Instances
 * store information about element locations using four maps.
 * <p>
 * The set-methods can be called multiple times by the parser that may visit
 * multiple children from which it copies the localization information for the parent
 * (i.e., the element for which set-method is called)
 * It implements the following behavior:
 * <p>
 * Line:   The lowest of all sources is used for target<br>
 * Column: The lowest of all sources is used for target<br>
 * Start:  The lowest of all sources is used for target<br>
 * End:    The highest of all sources is used for target<br>
 */
public class LocationMap implements ILocationMap {

	/**
	 * A basic interface that can be implemented to select
	 * EObject based of their location in a text resource.
	 */
	public interface ISelector {
		boolean accept(int startOffset, int endOffset);
	}

	protected EMap<EObject, Integer> columnMap    = new BasicEMap<EObject, Integer>();
	protected EMap<EObject, Integer> lineMap      = new BasicEMap<EObject, Integer>();
	protected EMap<EObject, Integer> charStartMap = new BasicEMap<EObject, Integer>();
	protected EMap<EObject, Integer> charEndMap   = new BasicEMap<EObject, Integer>();
	
	public void setLine(EObject element, int line) {
		setMapValueToMin(lineMap, element, line);
	}

	public int getLine(EObject element) {
		return getMapValue(lineMap, element);
	}

	public void setColumn(EObject element, int column) {
		setMapValueToMin(columnMap, element, column);
	}	
	
	public int getColumn(EObject element) {
		return getMapValue(columnMap, element);
	}
	
	public void setCharStart(EObject element, int charStart) {
		setMapValueToMin(charStartMap, element, charStart);
	}	
	
	public int getCharStart(EObject element) {
		return getMapValue(charStartMap, element);
	}	
	
	public void setCharEnd(EObject element, int charEnd) {
		setMapValueToMax(charEndMap, element, charEnd);
	}	
	
	public int getCharEnd(EObject element) {
		return getMapValue(charEndMap, element);
	}

	private int getMapValue(EMap<EObject, Integer> map, EObject element) {
		if (!map.containsKey(element)) return -1;
		return map.get(element);
	}
	
	private void setMapValueToMin(EMap<EObject, Integer> map, EObject element, int value) {
		if (element == null || value < 0) return;
		if (map.containsKey(element) && map.get(element) < value) return;
		map.put(element, value);
	}
	
	private void setMapValueToMax(EMap<EObject, Integer> map, EObject element, int value) {
		if (element == null || value < 0) return;
		if (map.containsKey(element) && map.get(element) > value) return;
		map.put(element, value);
	}

	public List<EObject> getElementsAt(final int documentOffset) {
		List<EObject> result = getElements(new ISelector() {
			public boolean accept(int start, int end) {
				return start <= documentOffset && end >= documentOffset;
			}
		});
		return result;
	}

	public List<EObject> getElementsBetween(final int startOffset, final int endOffset) {
		List<EObject> result = getElements(new ISelector() {
			public boolean accept(int start, int end) {
				return start >= startOffset && end <= endOffset;
			}
		});
		return result;
	}

	private List<EObject> getElements(ISelector s) {
		// there might be more than one element at the given offset
		// thus, we collect all of them and sort them afterwards
		List<EObject> result = new ArrayList<EObject>();
		
		for (EObject next : charStartMap.keySet()) {
			int start = charStartMap.get(next);
			int end = charEndMap.get(next);
			if (s.accept(start, end)) {
				result.add(next);
			}
		}
		Collections.sort(result, new Comparator<EObject>() {
			public int compare(EObject objectA, EObject objectB) {
				int lengthA = getCharEnd(objectA) - getCharStart(objectA);
				int lengthB = getCharEnd(objectB) - getCharStart(objectB);
				return lengthA - lengthB;
			}
		});
		return result;
	}
}
