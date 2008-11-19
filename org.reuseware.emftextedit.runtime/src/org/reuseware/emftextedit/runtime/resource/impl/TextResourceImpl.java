package org.reuseware.emftextedit.runtime.resource.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.reuseware.emftextedit.runtime.EMFTextEditPlugin;
import org.reuseware.emftextedit.runtime.IOptionProvider;
import org.reuseware.emftextedit.runtime.resource.EMFTextOCLValidator;
import org.reuseware.emftextedit.runtime.resource.TextResource;

/**
 * Base implementation for all generated text resources. 
 * It implements the specifications from {@link TextResource}.
 * 
 * @author Jendrik Johannes (jj2)
 */
public abstract class TextResourceImpl extends ResourceImpl implements TextResource {
	
	protected EMap<EObject, Integer> columnInfo    = new BasicEMap<EObject, Integer>();
	protected EMap<EObject, Integer> lineInfo      = new BasicEMap<EObject, Integer>();
	protected EMap<EObject, Integer> charStartInfo = new BasicEMap<EObject, Integer>();
	protected EMap<EObject, Integer> charEndInfo   = new BasicEMap<EObject, Integer>();
	
	/**
	 * Extends the super implementation by clearing all information about element
	 * positions.
	 */
	public void doUnload() {
		super.doUnload();
		
		//clear concrete syntax information
		columnInfo.clear();
		lineInfo.clear();
		charStartInfo.clear();
		charEndInfo.clear();
	}
	

	@Override
	public void load(Map<?, ?> loadOptions) throws IOException {
		// get default options
		Map<Object, Object> options = copySafelyToObjectToObjectMap(loadOptions); 
		addDefaultLoadOptions(options);
		
		super.load(options);

		if (options != null
				&& Boolean.TRUE.equals(options
						.get(TextResourceImpl.OPTION_NO_VALIDATE))) {
		} else {
			EList<EObject> contents = getContents();
			EMFTextOCLValidator oclValidator = new EMFTextOCLValidator();
			Set<EObject> distinctObjects = new HashSet<EObject>();
			distinctObjects.addAll(contents);
			for (EObject eobject : distinctObjects) {
				// TODO check if this leads to performance problems
				// - due to traversing some objects more than once
	
				oclValidator.analyse(eobject);
			}
		}
	}

	/**
	 * Creates a empty instance.
	 */
	public TextResourceImpl() {
		super();
	}

	/**
	 * Creates an instance with the given URI.
	 * 
	 * @param uri The URI.
	 */
	public TextResourceImpl(URI uri) {
		super(uri);	
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
	
	public void setElementLine(EObject element, int line) {
		setMapValue(lineInfo, element, line);
	}

	public int getElementLine(EObject element) {
		return getMapValue(lineInfo, element);
	}

	public void setElementColumn(EObject element, int column) {
		setMapValue(columnInfo, element, column);
	}	
	
	public int getElementColumn(EObject element) {
		return getMapValue(columnInfo, element);
	}
	
	public void setElementCharStart(EObject element, int charStart) {
		setMapValue(charStartInfo, element, charStart);
	}	
	
	public int getElementCharStart(EObject element) {
		return getMapValue(charStartInfo, element);
	}	
	
	public void setElementCharEnd(EObject element, int charEnd) {
		if (element == null) return;
		if (charEndInfo.containsKey(element)) {
			// TODO jjohannes: this is strange behavior since
			// it deviates from the other set methods. maybe 
			// this code should be better placed in callers of
			// this method?
			if (charEndInfo.get(element) > charEnd) return;
		}
		charEndInfo.put(element, charEnd);
	}	
	
	public int getElementCharEnd(EObject element) {
		return getMapValue(charEndInfo, element);
	}	
	
	public void addError(String message, EObject element) {
		getErrors().add(new ElementBasedTextDiagnosticImpl(this, message, element));
	}
	
	public void addWarning(String message, EObject element) {
		getWarnings().add(new ElementBasedTextDiagnosticImpl(this, message, element));
	}
	
	public void addError(String message, int column, int line, int charStart,
			int charEnd) {
		getErrors().add(new PositionBasedTextDiagnosticImpl(getURI(), message, column, line, charStart, charEnd));
	}

	public void addWarning(String message, int column, int line, int charStart,
			int charEnd) {
		getWarnings().add(new PositionBasedTextDiagnosticImpl(getURI(), message, column, line, charStart, charEnd));
	}
	
	public String[] getTokenNames() {
		return new String[]{};
	}
	
	private void addDefaultLoadOptions(Map<Object, Object> loadOptions) {
		if (Platform.isRunning()) {
			// find default load option providers
			IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
			IConfigurationElement configurationElements[] = extensionRegistry.getConfigurationElementsFor(EMFTextEditPlugin.EP_DEFAULT_LOAD_OPTIONS_ID);
			for (IConfigurationElement element : configurationElements) {
				try {
					IOptionProvider provider = (IOptionProvider) element.createExecutableExtension("class");//$NON-NLS-1$
					final Map<?, ?> options = provider.getOptions();
					final Collection<?> keys = options.keySet();
					for (Object key : keys) {
						addLoadOption(loadOptions, key, options.get(key));
					}
				} catch (CoreException ce) {
					EMFTextEditPlugin.logError("Exception while getting default options.", ce);
				}
			}
		}
	}

	/**
	 * Adds a new key,value pair to the list of options. If there
	 * is already an option with the same key, the two values are 
	 * collected in a list.
	 * 
	 * @param options
	 * @param key
	 * @param value
	 */
	private void addLoadOption(Map<Object, Object> options,
			Object key, Object value) {
		// check if there is already an option set
		if (options.containsKey(key)) {
			Object currentValue = options.get(key);
			if (currentValue instanceof List) {
				// if the current value is a list, we add the new value to
				// this list
				List<?> currentValueAsList = (List<?>) currentValue;
				List<Object> currentValueAsObjectList = copySafelyToObjectList(currentValueAsList);
				currentValueAsObjectList.add(value);
				options.put(key, currentValueAsObjectList);
			} else {
				// if the current value is not a list, we create a fresh list
				// and add both the old (current) and the new value to this list
				List<Object> newValueList = new ArrayList<Object>();
				newValueList.add(currentValue);
				newValueList.add(value);
				options.put(key, newValueList);
			}
		} else {
			options.put(key, value);
		}
	}

	private Map<Object, Object> copySafelyToObjectToObjectMap(Map<?, ?> map) {
		Map<Object, Object> castedCopy = new HashMap<Object, Object>();
		
		if(map == null) {
			return castedCopy;
		}
		
		Iterator<?> it = map.keySet().iterator();
		while (it.hasNext()) {
			Object nextKey = it.next();
			castedCopy.put(nextKey, map.get(nextKey));
		}
		return castedCopy;
	}

	private List<Object> copySafelyToObjectList(List<?> list) {
		Iterator<?> it = list.iterator();
		List<Object> castedCopy = new ArrayList<Object>();
		while (it.hasNext()) {
			castedCopy.add(it.next());
		}
		return castedCopy;
	}
}
