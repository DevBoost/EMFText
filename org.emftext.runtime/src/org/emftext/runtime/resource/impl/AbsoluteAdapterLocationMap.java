package org.emftext.runtime.resource.impl;

import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.emftext.runtime.resource.ILocationMap;

/**
 * An implementation of the ILocationMap interface that stores location
 * data in EMF adapters using absolute line and column information.
 */
public class AbsoluteAdapterLocationMap implements ILocationMap {

	/**
	 * An EMF adapter implementation that is attached to EObjects
	 * to store location information. 
	 */
	private final static class LocationAdapter extends AdapterImpl {
		private int charStart = -1;
		private int charEnd = -1;
		private int line = -1;
		private int column = -1;
		
		public LocationAdapter() {
			super();
		}

		public int getCharStart() {
			return charStart;
		}

		public int getCharEnd() {
			return charEnd;
		}

		public int getLine() {
			return line;
		}

		public int getColumn() {
			return column;
		}

		public void setCharStart(int charStart) {
			this.charStart = charStart;
		}

		public void setCharEnd(int charEnd) {
			this.charEnd = charEnd;
		}

		public void setLine(int line) {
			this.line = line;
		}

		public void setColumn(int column) {
			this.column = column;
		}
	}

	private static final LocationAdapter NOT_FOUND_ADAPTER = new LocationAdapter();

	public int getCharEnd(EObject element) {
		return getLocationAdapter(element, false).getCharEnd();
	}

	public int getCharStart(EObject element) {
		return getLocationAdapter(element, false).getCharStart();
	}

	public int getColumn(EObject element) {
		return getLocationAdapter(element, false).getColumn();
	}

	public int getLine(EObject element) {
		return getLocationAdapter(element, false).getLine();
	}

	public void setCharEnd(EObject element, int charEnd) {
		getLocationAdapter(element, true).setCharEnd(charEnd);
	}

	public void setCharStart(EObject element, int charStart) {
		getLocationAdapter(element, true).setCharStart(charStart);
	}

	public void setColumn(EObject element, int column) {
		getLocationAdapter(element, true).setColumn(column);
	}

	public void setLine(EObject element, int line) {
		getLocationAdapter(element, true).setLine(line);
	}

	public List<EObject> getElementsAt(EObject root, int documentOffset) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<EObject> getElementsBetween(EObject root, int startOffset, int endOffset) {
		// TODO Auto-generated method stub
		return null;
	}

	private LocationAdapter getLocationAdapter(EObject element, boolean createIfNotFound) {
		// look for the adapter in the list of all adapters
        List<Adapter> adapters = element.eAdapters();
        for (Adapter adapter : adapters) {
        	if (adapter instanceof LocationAdapter) {
        		return (LocationAdapter) adapter;
        	}
        }

        if (createIfNotFound) {
	        // create new adapter or return the MissingAdapter 
        	LocationAdapter newLocationAdapter = new LocationAdapter();
			element.eAdapters().add(newLocationAdapter);
			return newLocationAdapter;
        } else {
	        // return the MissingAdapter 
        	return NOT_FOUND_ADAPTER;
        }
	}
}
