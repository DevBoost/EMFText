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
 */
public class LocationMap implements ILocationMap {

	public interface ISelector {
		boolean accept(int startOffset, int endOffset);
	}

	protected EMap<EObject, Integer> columnMap    = new BasicEMap<EObject, Integer>();
	protected EMap<EObject, Integer> lineMap      = new BasicEMap<EObject, Integer>();
	protected EMap<EObject, Integer> charStartMap = new BasicEMap<EObject, Integer>();
	protected EMap<EObject, Integer> charEndMap   = new BasicEMap<EObject, Integer>();
	
	public void setLine(EObject element, int line) {
		setMapValue(lineMap, element, line);
	}

	public int getLine(EObject element) {
		return getMapValue(lineMap, element);
	}

	public void setColumn(EObject element, int column) {
		setMapValue(columnMap, element, column);
	}	
	
	public int getColumn(EObject element) {
		return getMapValue(columnMap, element);
	}
	
	public void setCharStart(EObject element, int charStart) {
		setMapValue(charStartMap, element, charStart);
	}	
	
	public int getCharStart(EObject element) {
		return getMapValue(charStartMap, element);
	}	
	
	public void setCharEnd(EObject element, int charEnd) {
		if (element == null) return;
		if (charEndMap.containsKey(element)) {
			// TODO jjohannes: this is strange behavior since
			// it deviates from the other set methods. maybe 
			// this code should be better placed in callers of
			// this method?
			if (charEndMap.get(element) > charEnd) return;
		}
		charEndMap.put(element, charEnd);
	}	
	
	public int getCharEnd(EObject element) {
		return getMapValue(charEndMap, element);
	}

	private int getMapValue(EMap<EObject, Integer> map, EObject element) {
		if (!map.containsKey(element)) return -1;
		return map.get(element);
	}
	
	private void setMapValue(EMap<EObject, Integer> map, EObject element, int line) {
		if (element == null) return;
		if (map.containsKey(element)) return;
		map.put(element, line);
	}

	public List<EObject> getElementsAt(final int documentOffset) {
		List<EObject> result = getElements(new ISelector() {
			public boolean accept(int start, int end) {
				return start < documentOffset && end > documentOffset;
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
