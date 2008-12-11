package org.emftext.runtime.resource.impl;

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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.emftext.runtime.EMFTextPlugin;
import org.emftext.runtime.IOptionProvider;
import org.emftext.runtime.resource.EMFTextOCLValidator;
import org.emftext.runtime.resource.ElementMapping;
import org.emftext.runtime.resource.LocationMap;
import org.emftext.runtime.resource.ReferenceMapping;
import org.emftext.runtime.resource.ResolveResult;
import org.emftext.runtime.resource.TextResource;
import org.emftext.runtime.resource.TextDiagnostic.TextDiagnosticType;

/**
 * Base implementation for all generated text resources. 
 * It implements the specifications from {@link TextResource}.
 * 
 * @author Jendrik Johannes (jj2)
 */
public abstract class TextResourceImpl extends ResourceImpl implements TextResource {
	
	private LocationMap locationMap = new LocationMapImpl();
	
	public static final String INTERNAL_URI_FRAGMENT_PREFIX = "EMFTEXT_INTERNAL_URI_FRAGMENT_";
	
	private Map<String, ContextDependentURIFragment> internalURIFragmentMap =
		new HashMap<String, ContextDependentURIFragment>();
	
	private void convertContextDependenProxiest() {
		internalURIFragmentMap.clear();
		int count = 0;
		for(Iterator<EObject> contentIt = this.getAllContents(); contentIt.hasNext(); ) {
			EObject container = contentIt.next();
			for(EReference reference : container.eClass().getEAllReferences() ) {
				Object temp = container.eGet(reference);
				if (temp instanceof EList) {
					for(int pos = 0; pos < ((EList<EObject>)temp).size(); pos++) {
						EObject proxyCand = ((EList<EObject>)temp).get(pos);
						if (proxyCand.eIsProxy()) {
							InternalEObject proxy = (InternalEObject) proxyCand;
							String identifier = proxy.eProxyURI().fragment();
							String internalURIFragment = INTERNAL_URI_FRAGMENT_PREFIX + count++ + "_" + identifier;
							ContextDependentURIFragment uriFragment = new ContextDependentURIFragment(
									identifier,
									container,
									reference,
									pos,
									proxy
								);
							proxy.eSetProxyURI(proxy.eProxyURI().trimFragment().appendFragment(internalURIFragment));
							internalURIFragmentMap.put(internalURIFragment, uriFragment);
						}
					}
				}
				else {
					EObject proxyCand = (EObject) temp;
					if (proxyCand != null && proxyCand.eIsProxy()) {
						InternalEObject proxy = (InternalEObject) proxyCand;
						String identifier = proxy.eProxyURI().fragment();
						String internalURIFragment = INTERNAL_URI_FRAGMENT_PREFIX + count++ + "_" + identifier;
						ContextDependentURIFragment uriFragment = new ContextDependentURIFragment(
								identifier,
								container,
								reference,
								0,
								proxy
							);
						proxy.eSetProxyURI(proxy.eProxyURI().trimFragment().appendFragment(internalURIFragment));
						internalURIFragmentMap.put(internalURIFragment, uriFragment);
					}
				}

			}
		}
	}
	
	@Override
	public EObject getEObject(String id) {
		if (internalURIFragmentMap.containsKey(id)) {
			ContextDependentURIFragment uriFragment = 
				internalURIFragmentMap.get(id);
			ResolveResult result = new ResolveResultImpl(false);
			//set an initial default error message
			result.setErrorMessage(getErrorMessage(uriFragment));
			getTreeAnalyser().resolve(
					uriFragment.getIdentifier(),
					uriFragment.getContainer(), 
					uriFragment.getReference(), 
					uriFragment.getPositionInReference(), 
					false, result);
			if (!result.wasResolved()) {
				attachErrors(result, uriFragment.getProxy());
				return null;
			} else if (result.wasResolvedUniquely()) {
				//TODO do nicer; remove identifier mappings
				attachWarnings(result);
				return 
				((ElementMapping) result.getMappings().iterator().next()).getTargetElement();
			} else {
				assert(false);
				return null;
			}
		}
		else {
			return super.getEObject(id);
		}
	}
	
	private String getErrorMessage(ContextDependentURIFragment uriFragment) {
		String identifier = uriFragment.getIdentifier();
		String typeName   = uriFragment.getReference().getEType().getName();
		String msg = typeName + " '" + identifier + "' not declared";  
		return msg;
	}
	
	private void attachErrors(ResolveResult result, EObject proxy) {
		// attach errors to resource
		assert result != null;
		String errorMessage = result.getErrorMessage();
		if (errorMessage == null) {
			assert(false);
		} else {
			addError(errorMessage, proxy);
		}
	}

	private void attachWarnings(ResolveResult result) {
		assert result != null;
		assert result.wasResolved();
		
		for (ReferenceMapping mapping : result.getMappings()) {
			String warningMessage = mapping.getWarning();
			if (warningMessage == null) {
				continue;
			}
			if (mapping instanceof ElementMapping) {
				final EObject target = ((ElementMapping) mapping).getTargetElement();
				addWarning(warningMessage, target);
			} else {
				assert false;
			}
		}
	}
	
	/**
	 * Extends the super implementation by clearing all information about element
	 * positions.
	 */
	public void doUnload() {
		super.doUnload();
		
		//clear concrete syntax information
		locationMap = new LocationMapImpl();
	}
	

	@Override
	public void load(Map<?, ?> options) throws IOException {
		super.load(options);

		convertContextDependenProxiest();
		
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
	
	public LocationMap getLocationMap() {
		return locationMap;
	}
	  
	public void addError(String message, EObject element) {
		getErrors().add(new ElementBasedTextDiagnosticImpl(locationMap, getURI(), message, element, null));
	}
	
	public void addError(String message, EObject element, TextDiagnosticType type) {
		getErrors().add(new ElementBasedTextDiagnosticImpl(locationMap, getURI(), message, element, type));
	}
	
	public void addWarning(String message, EObject element) {
		getWarnings().add(new ElementBasedTextDiagnosticImpl(locationMap, getURI(), message, element, null));
	}
	
	public void addWarning(String message, EObject element, TextDiagnosticType type) {
		getWarnings().add(new ElementBasedTextDiagnosticImpl(locationMap, getURI(), message, element, type));
	}
	
	public void addError(String message, int column, int line, int charStart,
			int charEnd) {
		getErrors().add(new PositionBasedTextDiagnosticImpl(getURI(), message, column, line, charStart, charEnd, null));
	}

	public void addError(String message, int column, int line, int charStart,
			int charEnd, TextDiagnosticType type) {
		getErrors().add(new PositionBasedTextDiagnosticImpl(getURI(), message, column, line, charStart, charEnd, type));
	}

	public void addWarning(String message, int column, int line, int charStart,
			int charEnd) {
		getWarnings().add(new PositionBasedTextDiagnosticImpl(getURI(), message, column, line, charStart, charEnd, null));
	}
	
	public void addWarning(String message, int column, int line, int charStart,
			int charEnd, TextDiagnosticType type) {
		getWarnings().add(new PositionBasedTextDiagnosticImpl(getURI(), message, column, line, charStart, charEnd, type));
	}
	
	public String[] getTokenNames() {
		return new String[]{};
	}
	
	protected Map<Object, Object> addDefaultLoadOptions(Map<?, ?> loadOptions) {
		Map<Object, Object> loadOptionsCopy = copySafelyToObjectToObjectMap(loadOptions); 
		if (Platform.isRunning()) {
			// find default load option providers
			IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
			IConfigurationElement configurationElements[] = extensionRegistry.getConfigurationElementsFor(EMFTextPlugin.EP_DEFAULT_LOAD_OPTIONS_ID);
			for (IConfigurationElement element : configurationElements) {
				try {
					IOptionProvider provider = (IOptionProvider) element.createExecutableExtension("class");//$NON-NLS-1$
					final Map<?, ?> options = provider.getOptions();
					final Collection<?> keys = options.keySet();
					for (Object key : keys) {
						addLoadOption(loadOptionsCopy, key, options.get(key));
					}
				} catch (CoreException ce) {
					EMFTextPlugin.logError("Exception while getting default options.", ce);
				}
			}
		}
		return loadOptionsCopy;
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

	protected Map<Object, Object> copySafelyToObjectToObjectMap(Map<?, ?> map) {
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
